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
  private static final int[] apH = { 16843830 };
  private static final int[] apI = { 16842987 };
  static final boolean apJ;
  static final boolean apK;
  static final boolean apL;
  static final boolean apM;
  private static final boolean apN;
  private static final boolean apO;
  private static final Class<?>[] apP;
  static final Interpolator ard;
  private final int[] SL;
  final int[] SM;
  private final Rect Xg = new Rect();
  a abe;
  private final q apQ = new q();
  final o apR = new o();
  private SavedState apS;
  d apT;
  s apU;
  final bg apV = new bg();
  boolean apW;
  final Runnable apX = new Runnable()
  {
    public final void run()
    {
      if ((!RecyclerView.this.aqh) || (RecyclerView.this.isLayoutRequested())) {
        return;
      }
      if (!RecyclerView.this.aqe)
      {
        RecyclerView.this.requestLayout();
        return;
      }
      if (RecyclerView.this.aqk)
      {
        RecyclerView.this.aqj = true;
        return;
      }
      RecyclerView.this.kr();
    }
  };
  final RectF apY = new RectF();
  i apZ;
  private int aqA = -1;
  private int aqB;
  private int aqC;
  private int aqD;
  private int aqE;
  private k aqF;
  private final int aqG;
  private final int aqH;
  private float aqI = 1.4E-45F;
  private float aqJ = 1.4E-45F;
  private boolean aqK = true;
  final v aqL = new v();
  ac aqM;
  ac.a aqN;
  final t aqO;
  private m aqP;
  private List<m> aqQ;
  boolean aqR;
  boolean aqS;
  private RecyclerView.f.b aqT;
  boolean aqU;
  al aqV;
  private d aqW;
  private final int[] aqX;
  private l aqY;
  private final int[] aqZ;
  p aqa;
  public final ArrayList<h> aqb = new ArrayList();
  private final ArrayList<l> aqc = new ArrayList();
  private l aqd;
  boolean aqe;
  boolean aqf;
  boolean aqg;
  boolean aqh;
  private int aqi = 0;
  boolean aqj;
  public boolean aqk;
  private boolean aql;
  private int aqm;
  boolean aqn;
  private final AccessibilityManager aqo;
  public List<j> aqp;
  boolean aqq = false;
  boolean aqr = false;
  private int aqs = 0;
  private int aqt = 0;
  private e aqu = new e();
  private EdgeEffect aqv;
  private EdgeEffect aqw;
  private EdgeEffect aqx;
  private EdgeEffect aqy;
  f aqz = new v();
  final int[] ara;
  final List<w> arb;
  private Runnable arc;
  private final bg.b are;
  private int mScrollState = 0;
  final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      apJ = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label169;
      }
      bool = true;
      label62:
      apK = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label174;
      }
      bool = true;
      label76:
      apL = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label179;
      }
      bool = true;
      label90:
      apM = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label184;
      }
      bool = true;
      label104:
      apN = bool;
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
      apO = bool;
      apP = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      ard = new Interpolator()
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
    if (apM)
    {
      localObject1 = new ac.a();
      this.aqN = ((ac.a)localObject1);
      this.aqO = new t();
      this.aqR = false;
      this.aqS = false;
      this.aqT = new g();
      this.aqU = false;
      this.aqX = new int[2];
      this.SL = new int[2];
      this.SM = new int[2];
      this.aqZ = new int[2];
      this.ara = new int[2];
      this.arb = new ArrayList();
      this.arc = new Runnable()
      {
        public final void run()
        {
          if (RecyclerView.this.aqz != null) {
            RecyclerView.this.aqz.je();
          }
          RecyclerView.this.aqU = false;
        }
      };
      this.are = new bg.b()
      {
        public final void a(RecyclerView.w paramAnonymousw, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView.this.apR.u(paramAnonymousw);
          RecyclerView localRecyclerView = RecyclerView.this;
          localRecyclerView.f(paramAnonymousw);
          paramAnonymousw.ax(false);
          if (localRecyclerView.aqz.d(paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.kH();
          }
        }
        
        public final void b(RecyclerView.w paramAnonymousw, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          paramAnonymousw.ax(false);
          if (localRecyclerView.aqz.e(paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.kH();
          }
        }
        
        public final void c(RecyclerView.w paramAnonymousw, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          paramAnonymousw.ax(false);
          if (RecyclerView.this.aqq) {
            if (RecyclerView.this.aqz.a(paramAnonymousw, paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
              RecyclerView.this.kH();
            }
          }
          while (!RecyclerView.this.aqz.f(paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
            return;
          }
          RecyclerView.this.kH();
        }
        
        public final void j(RecyclerView.w paramAnonymousw)
        {
          RecyclerView.this.apZ.a(paramAnonymousw.asD, RecyclerView.this.apR);
        }
      };
      if (paramAttributeSet == null) {
        break label693;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, apI, paramInt, 0);
      this.apW = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label358:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.aqI = u.a((ViewConfiguration)localObject1, paramContext);
      this.aqJ = u.b((ViewConfiguration)localObject1, paramContext);
      this.aqG = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.aqH = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
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
      this.aqz.ari = this.aqT;
      this.apT = new d(new d.a()
      {
        private void f(d.b paramAnonymousb)
        {
          switch (paramAnonymousb.CW)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            return;
          case 1: 
            RecyclerView.this.apZ.c(RecyclerView.this, paramAnonymousb.ahV, paramAnonymousb.ahX);
            return;
          case 2: 
            RecyclerView.this.apZ.d(RecyclerView.this, paramAnonymousb.ahV, paramAnonymousb.ahX);
            return;
          case 4: 
            RecyclerView.this.apZ.a(RecyclerView.this, paramAnonymousb.ahV, paramAnonymousb.ahX, paramAnonymousb.ahW);
            return;
          }
          RecyclerView.this.apZ.a(RecyclerView.this, paramAnonymousb.ahV, paramAnonymousb.ahX, 1);
        }
        
        public final void M(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, true);
          RecyclerView.this.aqR = true;
          RecyclerView.t localt = RecyclerView.this.aqO;
          localt.asl += paramAnonymousInt2;
        }
        
        public final void N(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, false);
          RecyclerView.this.aqR = true;
        }
        
        public final void O(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          int j = localRecyclerView.apU.jb();
          int i = 0;
          while (i < j)
          {
            localObject = RecyclerView.bv(localRecyclerView.apU.bL(i));
            if ((localObject != null) && (!((RecyclerView.w)localObject).lt()) && (((RecyclerView.w)localObject).mPosition >= paramAnonymousInt1))
            {
              ((RecyclerView.w)localObject).k(paramAnonymousInt2, false);
              localRecyclerView.aqO.aso = true;
            }
            i += 1;
          }
          Object localObject = localRecyclerView.apR;
          j = ((RecyclerView.o)localObject).arS.size();
          i = 0;
          while (i < j)
          {
            RecyclerView.w localw = (RecyclerView.w)((RecyclerView.o)localObject).arS.get(i);
            if ((localw != null) && (localw.mPosition >= paramAnonymousInt1)) {
              localw.k(paramAnonymousInt2, true);
            }
            i += 1;
          }
          localRecyclerView.requestLayout();
          RecyclerView.this.aqR = true;
        }
        
        public final void P(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int n = -1;
          RecyclerView localRecyclerView = RecyclerView.this;
          int i1 = localRecyclerView.apU.jb();
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
            localObject = RecyclerView.bv(localRecyclerView.apU.bL(m));
            if ((localObject != null) && (((RecyclerView.w)localObject).mPosition >= k) && (((RecyclerView.w)localObject).mPosition <= j))
            {
              if (((RecyclerView.w)localObject).mPosition != paramAnonymousInt1) {
                break label129;
              }
              ((RecyclerView.w)localObject).k(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            localRecyclerView.aqO.aso = true;
            m += 1;
            break label35;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label129:
            ((RecyclerView.w)localObject).k(i, false);
          }
          label139:
          Object localObject = localRecyclerView.apR;
          label173:
          RecyclerView.w localw;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            i = n;
            n = ((RecyclerView.o)localObject).arS.size();
            m = 0;
            if (m >= n) {
              break label268;
            }
            localw = (RecyclerView.w)((RecyclerView.o)localObject).arS.get(m);
            if ((localw != null) && (localw.mPosition >= k) && (localw.mPosition <= j))
            {
              if (localw.mPosition != paramAnonymousInt1) {
                break label258;
              }
              localw.k(paramAnonymousInt2 - paramAnonymousInt1, false);
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
            localw.k(i, false);
          }
          label268:
          localRecyclerView.requestLayout();
          RecyclerView.this.aqR = true;
        }
        
        public final RecyclerView.w bF(int paramAnonymousInt)
        {
          RecyclerView.w localw = RecyclerView.this.j(paramAnonymousInt, true);
          if (localw == null) {}
          while (RecyclerView.this.apU.bg(localw.asD)) {
            return null;
          }
          return localw;
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          Object localObject = RecyclerView.this;
          int j = ((RecyclerView)localObject).apU.jb();
          int i = 0;
          while (i < j)
          {
            View localView = ((RecyclerView)localObject).apU.bL(i);
            RecyclerView.w localw = RecyclerView.bv(localView);
            if ((localw != null) && (!localw.lt()) && (localw.mPosition >= paramAnonymousInt1) && (localw.mPosition < paramAnonymousInt1 + paramAnonymousInt2))
            {
              localw.addFlags(2);
              localw.N(paramAnonymousObject);
              ((RecyclerView.LayoutParams)localView.getLayoutParams()).arI = true;
            }
            i += 1;
          }
          paramAnonymousObject = ((RecyclerView)localObject).apR;
          i = paramAnonymousObject.arS.size() - 1;
          while (i >= 0)
          {
            localObject = (RecyclerView.w)paramAnonymousObject.arS.get(i);
            if (localObject != null)
            {
              j = ((RecyclerView.w)localObject).mPosition;
              if ((j >= paramAnonymousInt1) && (j < paramAnonymousInt1 + paramAnonymousInt2))
              {
                ((RecyclerView.w)localObject).addFlags(2);
                paramAnonymousObject.cw(i);
              }
            }
            i -= 1;
          }
          RecyclerView.this.aqS = true;
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
      this.apU = new s(new s.b()
      {
        public final void addView(View paramAnonymousView, int paramAnonymousInt)
        {
          RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
          RecyclerView localRecyclerView = RecyclerView.this;
          RecyclerView.w localw = RecyclerView.bv(paramAnonymousView);
          if ((localRecyclerView.abe != null) && (localw != null)) {
            localRecyclerView.abe.k(localw);
          }
          if (localRecyclerView.aqp != null)
          {
            paramAnonymousInt = localRecyclerView.aqp.size() - 1;
            while (paramAnonymousInt >= 0)
            {
              ((RecyclerView.j)localRecyclerView.aqp.get(paramAnonymousInt)).bQ(paramAnonymousView);
              paramAnonymousInt -= 1;
            }
          }
        }
        
        public final void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
        {
          RecyclerView.w localw = RecyclerView.bv(paramAnonymousView);
          if (localw != null)
          {
            if ((!localw.lF()) && (!localw.lt())) {
              throw new IllegalArgumentException("Called attach on a child which is not detached: " + localw + RecyclerView.this.kp());
            }
            localw.lD();
          }
          RecyclerView.a(RecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
        }
        
        public final RecyclerView.w bh(View paramAnonymousView)
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
            if (paramAnonymousView.asS == -1) {
              break label38;
            }
          }
          label38:
          for (paramAnonymousView.asR = paramAnonymousView.asS;; paramAnonymousView.asR = t.X(paramAnonymousView.asD))
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
            RecyclerView.this.b(paramAnonymousView, paramAnonymousView.asR);
            paramAnonymousView.asR = 0;
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
              if ((((RecyclerView.w)localObject).lF()) && (!((RecyclerView.w)localObject).lt())) {
                throw new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.kp());
              }
              ((RecyclerView.w)localObject).addFlags(256);
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
      this.aqo = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new al(this));
      if (paramAttributeSet == null) {
        break label1272;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(7);
      if (((TypedArray)localObject1).getInt(1, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.aqg = ((TypedArray)localObject1).getBoolean(2, false);
      if (!this.aqg) {
        break label757;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(5);
      localObject4 = ((TypedArray)localObject1).getDrawable(6);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(3);
      localDrawable = ((TypedArray)localObject1).getDrawable(4);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label707;
      }
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + kp());
      localObject1 = null;
      break;
      this.apW = true;
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
          localObject3 = ((Class)localObject4).getConstructor(apP);
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
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, apH, paramInt, 0);
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
  
  private void a(long paramLong, w paramw1, w paramw2)
  {
    int j = this.apU.getChildCount();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.apU.getChildAt(i));
      if ((localw != paramw1) && (g(localw) == paramLong))
      {
        if ((this.abe != null) && (this.abe.arh)) {
          throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localw + " \n View Holder 2:" + paramw1 + kp());
        }
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localw + " \n View Holder 2:" + paramw1 + kp());
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramw2).append(" cannot be found but it is necessary for ").append(paramw1).append(kp());
  }
  
  private void a(w paramw1, w paramw2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramw1.ax(false);
    if (paramBoolean1) {
      f(paramw1);
    }
    if (paramw1 != paramw2)
    {
      if (paramBoolean2) {
        f(paramw2);
      }
      paramw1.asJ = paramw2;
      f(paramw1);
      this.apR.u(paramw1);
      paramw2.ax(false);
      paramw2.asK = paramw1;
    }
    if (this.aqz.a(paramw1, paramw2, paramc1, paramc2)) {
      kH();
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    kr();
    int i;
    int j;
    int k;
    int m;
    if (this.abe != null)
    {
      b(paramInt1, paramInt2, this.ara);
      i = this.ara[0];
      j = this.ara[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.aqb.isEmpty()) {
        invalidate();
      }
      if (a(i, j, k, m, this.SL, 0))
      {
        this.aqD -= this.SL[0];
        this.aqE -= this.SL[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.SL[0], this.SL[1]);
        }
        paramMotionEvent = this.aqZ;
        paramMotionEvent[0] += this.SL[0];
        paramMotionEvent = this.aqZ;
        paramMotionEvent[1] += this.SL[1];
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
    m(this.aqX);
    if ((this.aqX[0] != paramInt1) || (this.aqX[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  static w bv(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).arH;
  }
  
  public static int bw(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lv();
    }
    return -1;
  }
  
  public static int bx(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lu();
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
    Rect localRect = localLayoutParams.anO;
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
        if (!((LayoutParams)localObject).arI)
        {
          localObject = ((LayoutParams)localObject).anO;
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
      localObject = this.apZ;
      localRect = this.mTempRect;
      if (this.aqh) {
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
  
  private long g(w paramw)
  {
    if (this.abe.arh) {
      return paramw.asG;
    }
    return paramw.mPosition;
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      kw();
      android.support.v4.widget.i.a(this.aqv, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      ky();
      android.support.v4.widget.i.a(this.aqw, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
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
      kx();
      android.support.v4.widget.i.a(this.aqx, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        kz();
        android.support.v4.widget.i.a(this.aqy, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  static void h(w paramw)
  {
    Object localObject;
    if (paramw.asE != null) {
      localObject = (View)paramw.asE.get();
    }
    while (localObject != null)
    {
      if (localObject == paramw.asD) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramw.asE = null;
  }
  
  private void i(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.aqA) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.aqA = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.aqD = j;
      this.aqB = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.aqE = i;
      this.aqC = i;
      return;
    }
  }
  
  private void kA()
  {
    this.aqy = null;
    this.aqw = null;
    this.aqx = null;
    this.aqv = null;
  }
  
  private void kB()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    aM(0);
    kv();
  }
  
  private void kC()
  {
    kB();
    setScrollState(0);
  }
  
  private void kF()
  {
    int i = this.aqm;
    this.aqm = 0;
    if ((i != 0) && (kE()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      android.support.v4.view.a.a.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private boolean kI()
  {
    return (this.aqz != null) && (this.apZ.jK());
  }
  
  private void kJ()
  {
    boolean bool2 = true;
    if (this.aqq)
    {
      this.apT.reset();
      if (this.aqr) {
        this.apZ.a(this);
      }
    }
    int i;
    label61:
    t localt;
    if (kI())
    {
      this.apT.iB();
      if ((!this.aqR) && (!this.aqS)) {
        break label180;
      }
      i = 1;
      localt = this.aqO;
      if ((!this.aqh) || (this.aqz == null) || ((!this.aqq) && (i == 0) && (!this.apZ.arv)) || ((this.aqq) && (!this.abe.arh))) {
        break label185;
      }
      bool1 = true;
      label121:
      localt.ass = bool1;
      localt = this.aqO;
      if ((!this.aqO.ass) || (i == 0) || (this.aqq) || (!kI())) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localt.ast = bool1;
      return;
      this.apT.iE();
      break;
      i = 0;
      break label61;
      bool1 = false;
      break label121;
    }
  }
  
  private void kK()
  {
    if (this.abe == null) {}
    while (this.apZ == null) {
      return;
    }
    this.aqO.asr = false;
    if (this.aqO.asm == 1)
    {
      kO();
      this.apZ.h(this);
      kP();
    }
    for (;;)
    {
      kQ();
      return;
      if ((this.apT.iF()) || (this.apZ.mWidth != getWidth()) || (this.apZ.mHeight != getHeight()))
      {
        this.apZ.h(this);
        kP();
      }
      else
      {
        this.apZ.h(this);
      }
    }
  }
  
  private void kL()
  {
    if ((this.aqK) && (hasFocus()) && (this.abe != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = bu((View)localObject1))
      {
        kM();
        return;
      }
      Object localObject2 = this.aqO;
      long l;
      int i;
      if (this.abe.arh)
      {
        l = ((w)localObject1).asG;
        ((t)localObject2).asv = l;
        localObject2 = this.aqO;
        if (!this.aqq) {
          break label191;
        }
        i = -1;
      }
      t localt;
      for (;;)
      {
        ((t)localObject2).asu = i;
        localt = this.aqO;
        localObject1 = ((w)localObject1).asD;
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
        if (((w)localObject1).isRemoved()) {
          i = ((w)localObject1).asF;
        } else {
          i = ((w)localObject1).lv();
        }
      }
      localt.asw = i;
      return;
    }
  }
  
  private void kM()
  {
    this.aqO.asv = -1L;
    this.aqO.asu = -1;
    this.aqO.asw = -1;
  }
  
  private void kN()
  {
    View localView = null;
    if ((!this.aqK) || (this.abe == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject = getFocusedChild();
      if ((apO) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.apU.getChildCount() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.apU.bg((View)localObject));
    if ((this.aqO.asv != -1L) && (this.abe.arh)) {}
    for (Object localObject = m(this.aqO.asv);; localObject = null)
    {
      int i;
      label216:
      int k;
      int j;
      if ((localObject == null) || (this.apU.bg(((w)localObject).asD)) || (!((w)localObject).asD.hasFocusable()))
      {
        localObject = localView;
        if (this.apU.getChildCount() > 0)
        {
          if (this.aqO.asu != -1)
          {
            i = this.aqO.asu;
            k = this.aqO.getItemCount();
            j = i;
            label226:
            if (j >= k) {
              break label331;
            }
            localObject = ci(j);
            if (localObject == null) {
              break label331;
            }
            if (!((w)localObject).asD.hasFocusable()) {
              break label324;
            }
            localObject = ((w)localObject).asD;
          }
        }
        else
        {
          label261:
          if (localObject == null) {
            break label397;
          }
          if (this.aqO.asw == -1L) {
            break label399;
          }
          localView = ((View)localObject).findViewById(this.aqO.asw);
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
          localObject = ci(i);
          if (localObject == null) {
            break label383;
          }
          if (((w)localObject).asD.hasFocusable())
          {
            localObject = ((w)localObject).asD;
            break;
          }
          i -= 1;
        }
        label383:
        localObject = null;
        break label261;
        localObject = ((w)localObject).asD;
        break label261;
        break;
      }
    }
  }
  
  private void kO()
  {
    this.aqO.cA(1);
    m(this.aqO);
    this.aqO.asr = false;
    ks();
    this.apV.clear();
    kD();
    kJ();
    kL();
    Object localObject = this.aqO;
    if ((this.aqO.ass) && (this.aqS)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((t)localObject).asq = bool;
      this.aqS = false;
      this.aqR = false;
      this.aqO.asp = this.aqO.ast;
      this.aqO.asn = this.abe.getItemCount();
      m(this.aqX);
      if (!this.aqO.ass) {
        break;
      }
      j = this.apU.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bv(this.apU.getChildAt(i));
        if ((!((w)localObject).lt()) && ((!((w)localObject).bj()) || (this.abe.arh)))
        {
          localc = this.aqz.a(this.aqO, (w)localObject, f.m((w)localObject), ((w)localObject).lI());
          this.apV.b((w)localObject, localc);
          if ((this.aqO.asq) && (((w)localObject).lL()) && (!((w)localObject).isRemoved()) && (!((w)localObject).lt()) && (!((w)localObject).bj()))
          {
            long l = g((w)localObject);
            this.apV.a(l, (w)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.aqO.ast)
    {
      kS();
      bool = this.aqO.aso;
      this.aqO.aso = false;
      this.apZ.c(this.apR, this.aqO);
      this.aqO.aso = bool;
      i = 0;
      if (i < this.apU.getChildCount())
      {
        localObject = bv(this.apU.getChildAt(i));
        if ((!((w)localObject).lt()) && (!this.apV.F((w)localObject)))
        {
          int k = f.m((w)localObject);
          bool = ((w)localObject).cB(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.aqz.a(this.aqO, (w)localObject, j, ((w)localObject).lI());
          if (!bool) {
            break label471;
          }
          a((w)localObject, localc);
        }
        for (;;)
        {
          i += 1;
          break;
          label471:
          this.apV.c((w)localObject, localc);
        }
      }
      kT();
    }
    for (;;)
    {
      at(true);
      as(false);
      this.aqO.asm = 2;
      return;
      kT();
    }
  }
  
  private void kP()
  {
    ks();
    kD();
    this.aqO.cA(6);
    this.apT.iE();
    this.aqO.asn = this.abe.getItemCount();
    this.aqO.asl = 0;
    this.aqO.asp = false;
    this.apZ.c(this.apR, this.aqO);
    this.aqO.aso = false;
    this.apS = null;
    t localt = this.aqO;
    if ((this.aqO.ass) && (this.aqz != null)) {}
    for (boolean bool = true;; bool = false)
    {
      localt.ass = bool;
      this.aqO.asm = 4;
      at(true);
      as(false);
      return;
    }
  }
  
  private void kQ()
  {
    this.aqO.cA(4);
    ks();
    kD();
    this.aqO.asm = 1;
    if (this.aqO.ass)
    {
      int i = this.apU.getChildCount() - 1;
      if (i >= 0)
      {
        w localw1 = bv(this.apU.getChildAt(i));
        RecyclerView.f.c localc2;
        w localw2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localw1.lt())
        {
          long l = g(localw1);
          localc2 = new RecyclerView.f.c().c(localw1, 0);
          localw2 = this.apV.n(l);
          if ((localw2 == null) || (localw2.lt())) {
            break label224;
          }
          bool1 = this.apV.E(localw2);
          bool2 = this.apV.E(localw1);
          if ((bool1) && (localw2 == localw1)) {
            break label224;
          }
          localc1 = this.apV.d(localw2, 4);
          this.apV.d(localw1, localc2);
          localc2 = this.apV.d(localw1, 8);
          if (localc1 != null) {
            break label205;
          }
          a(l, localw1, localw2);
        }
        for (;;)
        {
          i -= 1;
          break;
          label205:
          a(localw2, localw1, localc1, localc2, bool1, bool2);
          continue;
          label224:
          this.apV.d(localw1, localc2);
        }
      }
      this.apV.a(this.are);
    }
    this.apZ.c(this.apR);
    this.aqO.ask = this.aqO.asn;
    this.aqq = false;
    this.aqr = false;
    this.aqO.ass = false;
    this.aqO.ast = false;
    this.apZ.arv = false;
    if (this.apR.arR != null) {
      this.apR.arR.clear();
    }
    if (this.apZ.arA)
    {
      this.apZ.arz = 0;
      this.apZ.arA = false;
      this.apR.ln();
    }
    this.apZ.a(this.aqO);
    at(true);
    as(false);
    this.apV.clear();
    if (am(this.aqX[0], this.aqX[1])) {
      an(0, 0);
    }
    kN();
    kM();
  }
  
  private void kS()
  {
    int j = this.apU.jb();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.apU.bL(i));
      if (!localw.lt()) {
        localw.ls();
      }
      i += 1;
    }
  }
  
  private void kT()
  {
    int j = this.apU.jb();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.apU.bL(i));
      if (!localw.lt()) {
        localw.lr();
      }
      i += 1;
    }
    this.apR.kT();
  }
  
  private void kU()
  {
    int j = this.apU.jb();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.apU.bL(i));
      if ((localw != null) && (!localw.lt())) {
        localw.addFlags(6);
      }
      i += 1;
    }
    kR();
    this.apR.kU();
  }
  
  private void kW()
  {
    int i = this.arb.size() - 1;
    while (i >= 0)
    {
      w localw = (w)this.arb.get(i);
      if ((localw.asD.getParent() == this) && (!localw.lt()))
      {
        int j = localw.asS;
        if (j != -1)
        {
          t.p(localw.asD, j);
          localw.asS = -1;
        }
      }
      i -= 1;
    }
    this.arb.clear();
  }
  
  private void ku()
  {
    this.aqL.stop();
    if (this.apZ != null) {
      this.apZ.lh();
    }
  }
  
  private void kv()
  {
    boolean bool2 = false;
    if (this.aqv != null)
    {
      this.aqv.onRelease();
      bool2 = this.aqv.isFinished();
    }
    boolean bool1 = bool2;
    if (this.aqw != null)
    {
      this.aqw.onRelease();
      bool1 = bool2 | this.aqw.isFinished();
    }
    bool2 = bool1;
    if (this.aqx != null)
    {
      this.aqx.onRelease();
      bool2 = bool1 | this.aqx.isFinished();
    }
    bool1 = bool2;
    if (this.aqy != null)
    {
      this.aqy.onRelease();
      bool1 = bool2 | this.aqy.isFinished();
    }
    if (bool1) {
      t.W(this);
    }
  }
  
  private void kw()
  {
    if (this.aqv != null) {
      return;
    }
    this.aqv = e.e(this);
    if (this.apW)
    {
      this.aqv.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.aqv.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kx()
  {
    if (this.aqx != null) {
      return;
    }
    this.aqx = e.e(this);
    if (this.apW)
    {
      this.aqx.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.aqx.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void ky()
  {
    if (this.aqw != null) {
      return;
    }
    this.aqw = e.e(this);
    if (this.apW)
    {
      this.aqw.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.aqw.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void kz()
  {
    if (this.aqy != null) {
      return;
    }
    this.aqy = e.e(this);
    if (this.apW)
    {
      this.aqy.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.aqy.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void m(t paramt)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.aqL.SC;
      paramt.asx = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramt.asy = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramt.asx = 0;
    paramt.asy = 0;
  }
  
  private void m(int[] paramArrayOfInt)
  {
    int i2 = this.apU.getChildCount();
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
      w localw = bv(this.apU.getChildAt(n));
      m = i;
      if (localw.lt()) {
        break label122;
      }
      int i1 = localw.lu();
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
  
  final void G(String paramString)
  {
    if (kG())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + kp());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.aqt > 0) {
      new IllegalStateException(kp());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    if (this.apZ == null) {}
    for (;;)
    {
      return;
      if (!this.aqk)
      {
        if (!this.apZ.jM()) {
          paramInt1 = 0;
        }
        if (!this.apZ.jN()) {
          paramInt2 = i;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          v localv = this.aqL;
          i = localv.aE(paramInt1, paramInt2);
          Interpolator localInterpolator = paramInterpolator;
          if (paramInterpolator == null) {
            localInterpolator = ard;
          }
          localv.b(paramInt1, paramInt2, i, localInterpolator);
          return;
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    if (this.apZ != null) {
      this.apZ.G("Cannot add item decoration during a scroll  or layout");
    }
    if (this.aqb.isEmpty()) {
      setWillNotDraw(false);
    }
    this.aqb.add(paramh);
    kR();
    requestLayout();
  }
  
  public final void a(j paramj)
  {
    if (this.aqp == null) {
      this.aqp = new ArrayList();
    }
    this.aqp.add(paramj);
  }
  
  public final void a(l paraml)
  {
    this.aqc.add(paraml);
  }
  
  public final void a(m paramm)
  {
    if (this.aqQ == null) {
      this.aqQ = new ArrayList();
    }
    this.aqQ.add(paramm);
  }
  
  final void a(w paramw, RecyclerView.f.c paramc)
  {
    paramw.setFlags(0, 8192);
    if ((this.aqO.asq) && (paramw.lL()) && (!paramw.isRemoved()) && (!paramw.lt()))
    {
      long l = g(paramw);
      this.apV.a(l, paramw);
    }
    this.apV.b(paramw, paramc);
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
    if ((this.apZ == null) || (!this.apZ.a(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean ai(int paramInt1, int paramInt2)
  {
    if (this.apZ == null) {}
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
        } while (this.aqk);
        bool2 = this.apZ.jM();
        bool3 = this.apZ.jN();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.aqG) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.aqG) {}
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
        if ((this.aqF == null) || (!this.aqF.aA(i, j))) {
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
      paramInt1 = Math.max(-this.aqH, Math.min(i, this.aqH));
      paramInt2 = Math.max(-this.aqH, Math.min(j, this.aqH));
      v localv = this.aqL;
      localv.arf.setScrollState(2);
      localv.asA = 0;
      localv.asz = 0;
      localv.SC.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localv.lq();
      return true;
    }
  }
  
  final void aj(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aqv != null)
    {
      bool1 = bool2;
      if (!this.aqv.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.aqv.onRelease();
          bool1 = this.aqv.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.aqx != null)
    {
      bool2 = bool1;
      if (!this.aqx.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.aqx.onRelease();
          bool2 = bool1 | this.aqx.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.aqw != null)
    {
      bool1 = bool2;
      if (!this.aqw.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.aqw.onRelease();
          bool1 = bool2 | this.aqw.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.aqy != null)
    {
      bool2 = bool1;
      if (!this.aqy.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.aqy.onRelease();
          bool2 = bool1 | this.aqy.isFinished();
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
      kw();
      this.aqv.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      ky();
      this.aqw.onAbsorb(-paramInt2);
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
      kx();
      this.aqx.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        kz();
        this.aqy.onAbsorb(paramInt2);
      }
    }
  }
  
  final void al(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(i.m(paramInt1, getPaddingLeft() + getPaddingRight(), t.ae(this)), i.m(paramInt2, getPaddingTop() + getPaddingBottom(), t.af(this)));
  }
  
  final void an(int paramInt1, int paramInt2)
  {
    this.aqt += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.aqP != null) {
      this.aqP.a(this, paramInt1, paramInt2);
    }
    if (this.aqQ != null)
    {
      i = this.aqQ.size() - 1;
      while (i >= 0)
      {
        ((m)this.aqQ.get(i)).a(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.aqt -= 1;
  }
  
  final void as(boolean paramBoolean)
  {
    if (this.aqi <= 0) {
      this.aqi = 1;
    }
    if ((!paramBoolean) && (!this.aqk)) {
      this.aqj = false;
    }
    if (this.aqi == 1)
    {
      if ((paramBoolean) && (this.aqj) && (!this.aqk) && (this.apZ != null) && (this.abe != null)) {
        kK();
      }
      if (!this.aqk) {
        this.aqj = false;
      }
    }
    this.aqi -= 1;
  }
  
  final void at(boolean paramBoolean)
  {
    this.aqs -= 1;
    if (this.aqs <= 0)
    {
      this.aqs = 0;
      if (paramBoolean)
      {
        kF();
        kW();
      }
    }
  }
  
  final void au(boolean paramBoolean)
  {
    this.aqr |= paramBoolean;
    this.aqq = true;
    kU();
  }
  
  final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    ks();
    kD();
    e.beginSection("RV Scroll");
    m(this.aqO);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.apZ.a(paramInt1, this.apR, this.aqO);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.apZ.b(paramInt2, this.apR, this.aqO);; paramInt2 = 0)
      {
        e.endSection();
        int j = this.apU.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.apU.getChildAt(i);
          Object localObject = bh(localView);
          if ((localObject != null) && (((w)localObject).asK != null))
          {
            localObject = ((w)localObject).asK.asD;
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
    this.aqc.remove(paraml);
    if (this.aqd == paraml) {
      this.aqd = null;
    }
  }
  
  public final void b(m paramm)
  {
    if (this.aqQ != null) {
      this.aqQ.remove(paramm);
    }
  }
  
  final boolean b(w paramw, int paramInt)
  {
    if (kG())
    {
      paramw.asS = paramInt;
      this.arb.add(paramw);
      return false;
    }
    t.p(paramw.asD, paramInt);
    return true;
  }
  
  final void bA(View paramView)
  {
    w localw = bv(paramView);
    if ((this.abe != null) && (localw != null)) {
      this.abe.l(localw);
    }
    if (this.aqp != null)
    {
      int i = this.aqp.size() - 1;
      while (i >= 0)
      {
        ((j)this.aqp.get(i)).bR(paramView);
        i -= 1;
      }
    }
  }
  
  public final w bh(View paramView)
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
  
  public final w bu(View paramView)
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
    if (!localLayoutParams.arI) {
      return localLayoutParams.anO;
    }
    if ((this.aqO.asp) && ((localLayoutParams.arH.lL()) || (localLayoutParams.arH.bj()))) {
      return localLayoutParams.anO;
    }
    Rect localRect = localLayoutParams.anO;
    localRect.set(0, 0, 0, 0);
    int j = this.aqb.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((h)this.aqb.get(i)).a(this.mTempRect, paramView, this, this.aqO);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.arI = false;
    return localRect;
  }
  
  public final void c(h paramh)
  {
    if (this.apZ != null) {
      this.apZ.G("Cannot remove item decoration during a scroll  or layout");
    }
    this.aqb.remove(paramh);
    if (this.aqb.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      kR();
      requestLayout();
      return;
    }
  }
  
  public void ca(int paramInt)
  {
    if (this.aqk) {}
    do
    {
      return;
      kt();
    } while (this.apZ == null);
    i locali = this.apZ;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.aeD(), "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  final void cg(int paramInt)
  {
    if (this.apZ == null) {
      return;
    }
    i locali = this.apZ;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.aeD(), "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  public final w ch(int paramInt)
  {
    return j(paramInt, false);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.apZ.a((LayoutParams)paramLayoutParams));
  }
  
  public final w ci(int paramInt)
  {
    Object localObject = null;
    if (this.aqq) {}
    int i;
    w localw;
    do
    {
      return localObject;
      int j = this.apU.jb();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localw = bv(this.apU.bL(i));
      if ((localw == null) || (localw.isRemoved()) || (i(localw) != paramInt)) {
        break label100;
      }
      localObject = localw;
    } while (!this.apU.bg(localw.asD));
    localObject = localw;
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
    if (this.apZ == null) {}
    while (!this.apZ.jM()) {
      return 0;
    }
    return this.apZ.f(this.aqO);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.apZ == null) {}
    while (!this.apZ.jM()) {
      return 0;
    }
    return this.apZ.d(this.aqO);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.apZ == null) {}
    while (!this.apZ.jM()) {
      return 0;
    }
    return this.apZ.h(this.aqO);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.apZ == null) {}
    while (!this.apZ.jN()) {
      return 0;
    }
    return this.apZ.g(this.aqO);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.apZ == null) {}
    while (!this.apZ.jN()) {
      return 0;
    }
    return this.apZ.e(this.aqO);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.apZ == null) {}
    while (!this.apZ.jN()) {
      return 0;
    }
    return this.apZ.i(this.aqO);
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
    int j = this.aqb.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.aqb.get(i)).b(paramCanvas, this, this.aqO);
      i += 1;
    }
    int n;
    if ((this.aqv != null) && (!this.aqv.isFinished()))
    {
      n = paramCanvas.save();
      if (this.apW)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.aqv == null) || (!this.aqv.draw(paramCanvas))) {
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
      if (this.aqw != null)
      {
        i = j;
        if (!this.aqw.isFinished())
        {
          n = paramCanvas.save();
          if (this.apW) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.aqw == null) || (!this.aqw.draw(paramCanvas))) {
            break label461;
          }
          i = 1;
          label202:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.aqx != null)
      {
        j = i;
        if (!this.aqx.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.apW) {
            break label466;
          }
          j = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.aqx == null) || (!this.aqx.draw(paramCanvas))) {
            break label471;
          }
          j = 1;
          label295:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.aqy != null)
      {
        i = j;
        if (!this.aqy.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.apW) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i = m;
          if (this.aqy != null)
          {
            i = m;
            if (this.aqy.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.aqz != null) && (this.aqb.size() > 0) && (this.aqz.isRunning())) {
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
    int j = this.apU.jb();
    int i = 0;
    if (i < j)
    {
      localObject = bv(this.apU.bL(i));
      if ((localObject != null) && (!((w)localObject).lt()))
      {
        if (((w)localObject).mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((w)localObject).k(-paramInt2, paramBoolean);
        this.aqO.aso = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (((w)localObject).mPosition >= paramInt1)
        {
          int k = -paramInt2;
          ((w)localObject).addFlags(8);
          ((w)localObject).k(k, paramBoolean);
          ((w)localObject).mPosition = (paramInt1 - 1);
          this.aqO.aso = true;
        }
      }
    }
    Object localObject = this.apR;
    i = ((o)localObject).arS.size() - 1;
    if (i >= 0)
    {
      w localw = (w)((o)localObject).arS.get(i);
      if (localw != null)
      {
        if (localw.mPosition < paramInt1 + paramInt2) {
          break label200;
        }
        localw.k(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label200:
        if (localw.mPosition >= paramInt1)
        {
          localw.addFlags(8);
          ((o)localObject).cw(i);
        }
      }
    }
    requestLayout();
  }
  
  final void f(w paramw)
  {
    View localView = paramw.asD;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.apR.u(bh(localView));
      if (!paramw.lF()) {
        break;
      }
      this.apU.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.apU.a(localView, -1, true);
      return;
    }
    paramw = this.apU;
    i = paramw.ajT.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
    }
    paramw.ajU.set(i);
    paramw.be(localView);
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    int i;
    Object localObject;
    label74:
    int k;
    if ((this.abe != null) && (this.apZ != null) && (!kG()) && (!this.aqk))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label327;
      }
      if (!this.apZ.jN()) {
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
      if (apN) {
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
        if (this.apZ.jM())
        {
          if (t.Y(this.apZ.alu) != 1) {
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
        if (apN)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label288;
        }
        kr();
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
      ks();
      this.apZ.a(paramView, k, this.apR, this.aqO);
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
              kr();
              if (bt(paramView) == null) {
                return null;
              }
              ks();
              localObject = this.apZ.a(paramView, paramInt, this.apR, this.aqO);
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
              this.Xg.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.Xg);
              if (t.Y(this.apZ.alu) == 1)
              {
                m = -1;
                if (((this.mTempRect.left >= this.Xg.left) && (this.mTempRect.right > this.Xg.left)) || (this.mTempRect.right >= this.Xg.right)) {
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
        if (((this.mTempRect.top < this.Xg.top) || (this.mTempRect.bottom <= this.Xg.top)) && (this.mTempRect.bottom < this.Xg.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + k + kp());
            m = 1;
            break label547;
            label755:
            if (((this.mTempRect.right <= this.Xg.right) && (this.mTempRect.left < this.Xg.right)) || (this.mTempRect.left <= this.Xg.left)) {
              break label986;
            }
            i = -1;
            break label600;
            if ((this.mTempRect.bottom > this.Xg.bottom) || (this.mTempRect.top >= this.Xg.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.Xg.top) {}
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
    if (this.apZ == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kp());
    }
    return this.apZ.jG();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.apZ == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kp());
    }
    return this.apZ.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.apZ == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kp());
    }
    return this.apZ.d(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.abe;
  }
  
  public int getBaseline()
  {
    if (this.apZ != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.aqW == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.aqW.av(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.apW;
  }
  
  public al getCompatAccessibilityDelegate()
  {
    return this.aqV;
  }
  
  public e getEdgeEffectFactory()
  {
    return this.aqu;
  }
  
  public f getItemAnimator()
  {
    return this.aqz;
  }
  
  public int getItemDecorationCount()
  {
    return this.aqb.size();
  }
  
  public i getLayoutManager()
  {
    return this.apZ;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.aqH;
  }
  
  public int getMinFlingVelocity()
  {
    return this.aqG;
  }
  
  long getNanoTime()
  {
    if (apM) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public k getOnFlingListener()
  {
    return this.aqF;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.aqK;
  }
  
  public n getRecycledViewPool()
  {
    return this.apR.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  l getScrollingChildHelper()
  {
    if (this.aqY == null) {
      this.aqY = new l(this);
    }
    return this.aqY;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().aN(0);
  }
  
  final int i(w paramw)
  {
    if ((paramw.cB(524)) || (!paramw.isBound())) {
      return -1;
    }
    return this.apT.bE(paramw.mPosition);
  }
  
  public boolean isAttachedToWindow()
  {
    return this.aqe;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().NV;
  }
  
  public final w j(int paramInt, boolean paramBoolean)
  {
    int j = this.apU.jb();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      w localw = bv(this.apU.bL(i));
      Object localObject2 = localObject1;
      if (localw != null)
      {
        localObject2 = localObject1;
        if (!localw.isRemoved())
        {
          if (!paramBoolean) {
            break label82;
          }
          if (localw.mPosition == paramInt) {
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
        if (localw.lu() == paramInt)
        {
          label95:
          localObject1 = localw;
          if (!this.apU.bg(localw.asD)) {
            break label121;
          }
          localObject2 = localw;
        }
      }
    }
    label121:
    return localObject1;
  }
  
  final void kD()
  {
    this.aqs += 1;
  }
  
  final boolean kE()
  {
    return (this.aqo != null) && (this.aqo.isEnabled());
  }
  
  public final boolean kG()
  {
    return this.aqs > 0;
  }
  
  final void kH()
  {
    if ((!this.aqU) && (this.aqe))
    {
      t.b(this, this.arc);
      this.aqU = true;
    }
  }
  
  public void kR()
  {
    int j = 0;
    int k = this.apU.jb();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.apU.bL(i).getLayoutParams()).arI = true;
      i += 1;
    }
    o localo = this.apR;
    k = localo.arS.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((w)localo.arS.get(i)).asD.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.arI = true;
      }
      i += 1;
    }
  }
  
  public final boolean kV()
  {
    return (!this.aqh) || (this.aqq) || (this.apT.iD());
  }
  
  final String kp()
  {
    return " " + super.toString() + ", adapter:" + this.abe + ", layout:" + this.apZ + ", context:" + getContext();
  }
  
  final void kq()
  {
    if (this.aqz != null) {
      this.aqz.jg();
    }
    if (this.apZ != null)
    {
      this.apZ.d(this.apR);
      this.apZ.c(this.apR);
    }
    this.apR.clear();
  }
  
  final void kr()
  {
    int k = 0;
    if ((!this.aqh) || (this.aqq))
    {
      e.beginSection("RV FullInvalidate");
      kK();
      e.endSection();
    }
    label168:
    label175:
    do
    {
      do
      {
        return;
      } while (!this.apT.iD());
      if ((this.apT.bC(4)) && (!this.apT.bC(11)))
      {
        e.beginSection("RV PartialInvalidate");
        ks();
        kD();
        this.apT.iB();
        int i;
        if (!this.aqj)
        {
          int m = this.apU.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            w localw = bv(this.apU.getChildAt(i));
            if ((localw == null) || (localw.lt()) || (!localw.lL())) {
              break label168;
            }
            j = 1;
          }
          if (j == 0) {
            break label175;
          }
          kK();
        }
        for (;;)
        {
          as(true);
          at(true);
          e.endSection();
          return;
          i += 1;
          break;
          this.apT.iC();
        }
      }
    } while (!this.apT.iD());
    e.beginSection("RV FullInvalidate");
    kK();
    e.endSection();
  }
  
  final void ks()
  {
    this.aqi += 1;
    if ((this.aqi == 1) && (!this.aqk)) {
      this.aqj = false;
    }
  }
  
  public void kt()
  {
    setScrollState(0);
    ku();
  }
  
  public final w m(long paramLong)
  {
    w localw2 = null;
    w localw1 = localw2;
    if (this.abe != null)
    {
      if (this.abe.arh) {
        break label31;
      }
      localw1 = localw2;
    }
    label31:
    int i;
    do
    {
      return localw1;
      int j = this.apU.jb();
      i = 0;
      localw1 = null;
      if (i >= j) {
        break;
      }
      localw2 = bv(this.apU.bL(i));
      if ((localw2 == null) || (localw2.isRemoved()) || (localw2.asG != paramLong)) {
        break label120;
      }
      localw1 = localw2;
    } while (!this.apU.bg(localw2.asD));
    localw1 = localw2;
    label120:
    for (;;)
    {
      i += 1;
      break;
      return localw1;
    }
  }
  
  public final View o(float paramFloat1, float paramFloat2)
  {
    int i = this.apU.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.apU.getChildAt(i);
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
    this.aqs = 0;
    this.aqe = true;
    float f;
    if ((this.aqh) && (!isLayoutRequested()))
    {
      this.aqh = bool;
      if (this.apZ != null) {
        this.apZ.f(this);
      }
      this.aqU = false;
      if (apM)
      {
        this.aqM = ((ac)ac.alN.get());
        if (this.aqM == null)
        {
          this.aqM = new ac();
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
      this.aqM.alQ = ((1.0E+009F / f));
      ac.alN.set(this.aqM);
      this.aqM.alO.add(this);
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
    if (this.aqz != null) {
      this.aqz.jg();
    }
    kt();
    this.aqe = false;
    if (this.apZ != null) {
      this.apZ.b(this, this.apR);
    }
    this.arb.clear();
    removeCallbacks(this.arc);
    bg.a.mT();
    if ((apM) && (this.aqM != null))
    {
      this.aqM.alO.remove(this);
      this.aqM = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.aqb.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.aqb.get(i)).a(paramCanvas, this, this.aqO);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.apZ == null) {}
    label188:
    for (;;)
    {
      return false;
      if ((!this.aqk) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f3;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.apZ.jN())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.apZ.jM()) {
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
          a((int)(this.aqI * f1), (int)(this.aqJ * f2), paramMotionEvent);
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
            if (this.apZ.jN())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.apZ.jM())
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
    if (this.aqk) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.aqd = null;
    }
    int k = this.aqc.size();
    int i = 0;
    if (i < k)
    {
      l locall = (l)this.aqc.get(i);
      if ((locall.a(this, paramMotionEvent)) && (j != 3)) {
        this.aqd = locall;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label105;
      }
      kC();
      return true;
      i += 1;
      break;
    }
    label105:
    if (this.apZ == null) {
      return false;
    }
    boolean bool1 = this.apZ.jM();
    boolean bool2 = this.apZ.jN();
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
      if (this.aql) {
        this.aql = false;
      }
      this.aqA = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.aqD = i;
      this.aqB = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.aqE = i;
      this.aqC = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.aqZ;
      this.aqZ[1] = 0;
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
      this.aqA = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.aqD = j;
      this.aqB = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.aqE = i;
      this.aqC = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.aqA);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.aqA).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.aqB;
      int m = this.aqC;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.aqD = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.aqE = k;
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        setScrollState(1);
        break;
        i(paramMotionEvent);
        break;
        this.mVelocityTracker.clear();
        aM(0);
        break;
        kC();
        break;
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e.beginSection("RV OnLayout");
    kK();
    e.endSection();
    this.aqh = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.apZ == null) {
      al(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.apZ.jL()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.apZ.az(paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.abe == null));
      if (this.aqO.asm == 1) {
        kO();
      }
      this.apZ.aw(paramInt1, paramInt2);
      this.aqO.asr = true;
      kP();
      this.apZ.ax(paramInt1, paramInt2);
    } while (!this.apZ.jR());
    this.apZ.aw(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.aqO.asr = true;
    kP();
    this.apZ.ax(paramInt1, paramInt2);
    return;
    if (this.aqf)
    {
      this.apZ.az(paramInt1, paramInt2);
      return;
    }
    if (this.aqn)
    {
      ks();
      kD();
      kJ();
      at(true);
      if (this.aqO.ast)
      {
        this.aqO.asp = true;
        this.aqn = false;
        as(false);
        label256:
        if (this.abe == null) {
          break label345;
        }
      }
    }
    label345:
    for (this.aqO.asn = this.abe.getItemCount();; this.aqO.asn = 0)
    {
      ks();
      this.apZ.az(paramInt1, paramInt2);
      as(false);
      this.aqO.asp = false;
      return;
      this.apT.iE();
      this.aqO.asp = false;
      break;
      if (!this.aqO.ast) {
        break label256;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (kG()) {
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
      this.apS = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.apS.Nj);
    } while ((this.apZ == null) || (this.apS.arY == null));
    this.apZ.onRestoreInstanceState(this.apS.arY);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.apS != null)
    {
      localSavedState.arY = this.apS.arY;
      return localSavedState;
    }
    if (this.apZ != null)
    {
      localSavedState.arY = this.apZ.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.arY = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      kA();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.aqk) || (this.aql)) {}
    label146:
    label155:
    label161:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.aqd != null)
      {
        if (i == 0) {
          this.aqd = null;
        }
      }
      else
      {
        if (i == 0) {
          break label155;
        }
        j = this.aqc.size();
        i = 0;
        if (i >= j) {
          break label155;
        }
        localObject = (l)this.aqc.get(i);
        if (!((l)localObject).a(this, paramMotionEvent)) {
          break label146;
        }
        this.aqd = ((l)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label161;
        }
        kC();
        return true;
        this.aqd.b(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.aqd = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.apZ == null);
    boolean bool1 = this.apZ.jM();
    boolean bool2 = this.apZ.jN();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.aqZ;
      this.aqZ[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.aqZ[0], this.aqZ[1]);
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
      this.aqA = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.aqD = i;
      this.aqB = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.aqE = i;
      this.aqC = i;
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
      this.aqA = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.aqD = i;
      this.aqB = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.aqE = i;
      this.aqC = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.aqA);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.aqA).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.aqD - i3;
      k = this.aqE - i4;
      j = m;
      i = k;
      if (a(m, k, this.SM, this.SL, 0))
      {
        j = m - this.SM[0];
        i = k - this.SM[1];
        ((MotionEvent)localObject).offsetLocation(this.SL[0], this.SL[1]);
        paramMotionEvent = this.aqZ;
        paramMotionEvent[0] += this.SL[0];
        paramMotionEvent = this.aqZ;
        paramMotionEvent[1] += this.SL[1];
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
        this.aqD = (i3 - this.SL[0]);
        this.aqE = (i4 - this.SL[1]);
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
          if (this.aqM == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.aqM.b(this, k, m);
          i = i2;
          break;
          j = this.mTouchSlop + j;
          break label730;
          i = this.mTouchSlop + i;
          break label780;
          i = 0;
          break label860;
        }
        i(paramMotionEvent);
        i = i2;
        break;
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.aqH);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.aqA);
          if (!bool2) {
            break label1087;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.aqA);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!ai((int)f1, (int)f2))) {
            setScrollState(0);
          }
          kB();
          i = 1;
          break;
          f1 = 0.0F;
          break label1026;
        }
        kC();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    w localw = bv(paramView);
    if (localw != null)
    {
      if (!localw.lF()) {
        break label36;
      }
      localw.lD();
    }
    label36:
    while (localw.lt())
    {
      paramView.clearAnimation();
      bA(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localw + kp());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((this.apZ.lf()) || (kG())) {}
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
    return this.apZ.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.aqc.size();
    int i = 0;
    while (i < j)
    {
      ((l)this.aqc.get(i)).ai(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.aqi == 0) && (!this.aqk))
    {
      super.requestLayout();
      return;
    }
    this.aqj = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.apZ == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.aqk);
      bool1 = this.apZ.jM();
      bool2 = this.apZ.jN();
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
    if (kG())
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
        this.aqm |= i;
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
    this.aqV = paramal;
    t.a(this, this.aqV);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    if (this.abe != null)
    {
      this.abe.b(this.apQ);
      this.abe.d(this);
    }
    kq();
    this.apT.reset();
    a locala = this.abe;
    this.abe = parama;
    if (parama != null)
    {
      parama.a(this.apQ);
      parama.c(this);
    }
    if (this.apZ != null) {
      this.apZ.lg();
    }
    Object localObject = this.apR;
    parama = this.abe;
    ((o)localObject).clear();
    localObject = ((o)localObject).getRecycledViewPool();
    if (locala != null) {
      ((n)localObject).detach();
    }
    if (((n)localObject).arL == 0)
    {
      int i = 0;
      while (i < ((n)localObject).arK.size())
      {
        ((RecyclerView.n.a)((n)localObject).arK.valueAt(i)).arM.clear();
        i += 1;
      }
    }
    if (parama != null) {
      ((n)localObject).lm();
    }
    this.aqO.aso = true;
    au(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.aqW) {
      return;
    }
    this.aqW = paramd;
    if (this.aqW != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.apW) {
      kA();
    }
    this.apW = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.aqh) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(e parame)
  {
    m.checkNotNull(parame);
    this.aqu = parame;
    kA();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.aqf = paramBoolean;
  }
  
  public void setItemAnimator(f paramf)
  {
    if (this.aqz != null)
    {
      this.aqz.jg();
      this.aqz.ari = null;
    }
    this.aqz = paramf;
    if (this.aqz != null) {
      this.aqz.ari = this.aqT;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    o localo = this.apR;
    localo.arU = paramInt;
    localo.ln();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.aqk)
    {
      G("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.aqk = false;
        if ((this.aqj) && (this.apZ != null) && (this.abe != null)) {
          requestLayout();
        }
        this.aqj = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.aqk = true;
    this.aql = true;
    kt();
  }
  
  public void setLayoutManager(i parami)
  {
    if (parami == this.apZ) {
      return;
    }
    kt();
    if (this.apZ != null)
    {
      if (this.aqz != null) {
        this.aqz.jg();
      }
      this.apZ.d(this.apR);
      this.apZ.c(this.apR);
      this.apR.clear();
      if (this.aqe) {
        this.apZ.b(this, this.apR);
      }
      this.apZ.setRecyclerView(null);
      this.apZ = null;
    }
    s locals;
    for (;;)
    {
      locals = this.apU;
      for (s.a locala = locals.ajU;; locala = locala.ajX)
      {
        locala.ajW = 0L;
        if (locala.ajX == null) {
          break;
        }
      }
      this.apR.clear();
    }
    int i = locals.ajV.size() - 1;
    while (i >= 0)
    {
      locals.ajT.bj((View)locals.ajV.get(i));
      locals.ajV.remove(i);
      i -= 1;
    }
    locals.ajT.removeAllViews();
    this.apZ = parami;
    if (parami != null)
    {
      if (parami.alu != null) {
        throw new IllegalArgumentException("LayoutManager " + parami + " is already attached to a RecyclerView:" + parami.alu.kp());
      }
      this.apZ.setRecyclerView(this);
      if (this.aqe) {
        this.apZ.f(this);
      }
    }
    this.apR.ln();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(k paramk)
  {
    this.aqF = paramk;
  }
  
  @Deprecated
  public void setOnScrollListener(m paramm)
  {
    this.aqP = paramm;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.aqK = paramBoolean;
  }
  
  public void setRecycledViewPool(n paramn)
  {
    o localo = this.apR;
    if (localo.arW != null) {
      localo.arW.detach();
    }
    localo.arW = paramn;
    if ((localo.arW != null) && (localo.arf.getAdapter() != null)) {
      localo.arW.lm();
    }
  }
  
  public void setRecyclerListener(p paramp)
  {
    this.aqa = paramp;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if (paramInt != 2) {
        ku();
      }
      if (this.apZ != null) {
        this.apZ.cp(paramInt);
      }
      if (this.aqP != null) {
        this.aqP.b(this, paramInt);
      }
      if (this.aqQ != null)
      {
        int i = this.aqQ.size() - 1;
        while (i >= 0)
        {
          ((m)this.aqQ.get(i)).b(this, paramInt);
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
  
  public void setViewCacheExtension(u paramu)
  {
    this.apR.arX = paramu;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.aqk) {}
    while (this.apZ == null) {
      return;
    }
    this.apZ.a(this, this.aqO, paramInt);
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
    final Rect anO = new Rect();
    public RecyclerView.w arH;
    boolean arI = true;
    boolean arJ = false;
    
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
    
    public final int ll()
    {
      return this.arH.lv();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Parcelable arY;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader != null) {}
      for (;;)
      {
        this.arY = paramParcel.readParcelable(paramClassLoader);
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
      paramParcel.writeParcelable(this.arY, 0);
    }
  }
  
  public static abstract class a<VH extends RecyclerView.w>
  {
    public final RecyclerView.b arg = new RecyclerView.b();
    protected boolean arh = false;
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public void a(RecyclerView.c paramc)
    {
      this.arg.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public final void ao(int paramInt1, int paramInt2)
    {
      this.arg.ao(paramInt1, paramInt2);
    }
    
    public final void ap(int paramInt1, int paramInt2)
    {
      this.arg.ap(paramInt1, paramInt2);
    }
    
    public final void aq(int paramInt1, int paramInt2)
    {
      this.arg.aq(paramInt1, paramInt2);
    }
    
    public final void ar(int paramInt1, int paramInt2)
    {
      this.arg.ar(paramInt1, paramInt2);
    }
    
    public void av(boolean paramBoolean)
    {
      if (this.arg.hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.arh = paramBoolean;
    }
    
    public final void b(int paramInt, Object paramObject)
    {
      this.arg.e(paramInt, 1, paramObject);
    }
    
    public void b(RecyclerView.c paramc)
    {
      this.arg.unregisterObserver(paramc);
    }
    
    public void c(RecyclerView paramRecyclerView) {}
    
    public final void cj(int paramInt)
    {
      this.arg.ao(paramInt, 1);
    }
    
    public final void ck(int paramInt)
    {
      this.arg.aq(paramInt, 1);
    }
    
    public final void cl(int paramInt)
    {
      this.arg.ar(paramInt, 1);
    }
    
    public final VH d(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        e.beginSection("RV CreateView");
        paramViewGroup = a(paramViewGroup, paramInt);
        if (paramViewGroup.asD.getParent() != null) {
          throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        }
      }
      finally
      {
        e.endSection();
      }
      paramViewGroup.asH = paramInt;
      e.endSection();
      return paramViewGroup;
    }
    
    public void d(RecyclerView paramRecyclerView) {}
    
    public final void e(int paramInt1, int paramInt2, Object paramObject)
    {
      this.arg.e(paramInt1, paramInt2, paramObject);
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
      this.arg.notifyChanged();
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
    b ari = null;
    private ArrayList<a> arj = new ArrayList();
    public long ark = 120L;
    public long arl = 120L;
    public long arm = 250L;
    public long arn = 250L;
    
    static int m(RecyclerView.w paramw)
    {
      int j = paramw.DU & 0xE;
      int i;
      if (paramw.bj()) {
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
            k = paramw.asF;
            m = paramw.lv();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    public c a(RecyclerView.t paramt, RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      return new c().c(paramw, 0);
    }
    
    public final boolean a(a parama)
    {
      boolean bool = isRunning();
      if (parama != null)
      {
        if (!bool) {
          parama.ld();
        }
      }
      else {
        return bool;
      }
      this.arj.add(parama);
      return bool;
    }
    
    public abstract boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, c paramc1, c paramc2);
    
    public boolean a(RecyclerView.w paramw, List<Object> paramList)
    {
      return p(paramw);
    }
    
    public abstract void d(RecyclerView.w paramw);
    
    public abstract boolean d(RecyclerView.w paramw, c paramc1, c paramc2);
    
    public abstract boolean e(RecyclerView.w paramw, c paramc1, c paramc2);
    
    public abstract boolean f(RecyclerView.w paramw, c paramc1, c paramc2);
    
    public abstract boolean isRunning();
    
    public abstract void je();
    
    public abstract void jg();
    
    public long kX()
    {
      return this.ark;
    }
    
    public long kY()
    {
      return this.arl;
    }
    
    public final void kZ()
    {
      this.arl = 2000L;
    }
    
    public final long la()
    {
      return this.arn;
    }
    
    public final void lb()
    {
      this.arn = 0L;
    }
    
    public final void lc()
    {
      int j = this.arj.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.arj.get(i)).ld();
        i += 1;
      }
      this.arj.clear();
    }
    
    public final void n(RecyclerView.w paramw)
    {
      o(paramw);
      if (this.ari != null) {
        this.ari.o(paramw);
      }
    }
    
    public void o(RecyclerView.w paramw) {}
    
    public boolean p(RecyclerView.w paramw)
    {
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void ld();
    }
    
    static abstract interface b
    {
      public abstract void o(RecyclerView.w paramw);
    }
    
    public static class c
    {
      public int aro;
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public c c(RecyclerView.w paramw, int paramInt)
      {
        paramw = paramw.asD;
        this.left = paramw.getLeft();
        this.top = paramw.getTop();
        this.right = paramw.getRight();
        this.bottom = paramw.getBottom();
        return this;
      }
    }
  }
  
  final class g
    implements RecyclerView.f.b
  {
    g() {}
    
    public final void o(RecyclerView.w paramw)
    {
      boolean bool = true;
      paramw.ax(true);
      if ((paramw.asJ != null) && (paramw.asK == null)) {
        paramw.asJ = null;
      }
      paramw.asK = null;
      int i;
      RecyclerView localRecyclerView;
      Object localObject;
      s locals;
      if ((paramw.DU & 0x10) != 0)
      {
        i = 1;
        if (i == 0)
        {
          localRecyclerView = RecyclerView.this;
          localObject = paramw.asD;
          localRecyclerView.ks();
          locals = localRecyclerView.apU;
          i = locals.ajT.indexOfChild((View)localObject);
          if (i != -1) {
            break label169;
          }
          locals.bf((View)localObject);
          i = 1;
          label99:
          if (i != 0)
          {
            localObject = RecyclerView.bv((View)localObject);
            localRecyclerView.apR.u((RecyclerView.w)localObject);
            localRecyclerView.apR.t((RecyclerView.w)localObject);
          }
          if (i != 0) {
            break label220;
          }
        }
      }
      for (;;)
      {
        localRecyclerView.as(bool);
        if ((i == 0) && (paramw.lF())) {
          RecyclerView.this.removeDetachedView(paramw.asD, false);
        }
        return;
        i = 0;
        break;
        label169:
        if (locals.ajU.get(i))
        {
          locals.ajU.remove(i);
          locals.bf((View)localObject);
          locals.ajT.removeViewAt(i);
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
    public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt) {}
    
    public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      paramView.getLayoutParams();
      paramRect.set(0, 0, 0, 0);
    }
    
    public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt) {}
  }
  
  public static abstract class i
  {
    protected RecyclerView alu;
    s apU;
    boolean arA;
    protected int arB;
    protected int arC;
    private final bf.b arp = new bf.b()
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
      
      public final int lj()
      {
        return RecyclerView.i.this.getPaddingLeft();
      }
      
      public final int lk()
      {
        return RecyclerView.i.this.mWidth - RecyclerView.i.this.getPaddingRight();
      }
    };
    private final bf.b arq = new bf.b()
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
      
      public final int lj()
      {
        return RecyclerView.i.this.getPaddingTop();
      }
      
      public final int lk()
      {
        return RecyclerView.i.this.mHeight - RecyclerView.i.this.getPaddingBottom();
      }
    };
    bf ars = new bf(this.arp);
    bf art = new bf(this.arq);
    RecyclerView.s aru;
    boolean arv = false;
    protected boolean arw = false;
    protected boolean arx = true;
    boolean ary = true;
    int arz;
    public int mHeight;
    public int mWidth;
    boolean ou = false;
    
    private void H(View paramView, int paramInt)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if (localw.isRemoved()) {
        this.alu.apV.G(localw);
      }
      for (;;)
      {
        this.apU.a(paramView, paramInt, localLayoutParams, localw.isRemoved());
        return;
        this.alu.apV.H(localw);
      }
    }
    
    private void a(RecyclerView.o paramo, int paramInt, View paramView)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if (localw.lt()) {
        return;
      }
      if ((localw.bj()) && (!localw.isRemoved()) && (!this.alu.abe.arh))
      {
        removeViewAt(paramInt);
        paramo.t(localw);
        return;
      }
      cm(paramInt);
      paramo.bU(paramView);
      this.alu.apV.H(localw);
    }
    
    private void ay(int paramInt1, int paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == null) {
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.alu.toString());
      }
      cm(paramInt1);
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).arH.lu();
    }
    
    public static int bC(View paramView)
    {
      return RecyclerView.bv(paramView).asH;
    }
    
    public static int bE(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public static int bF(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO;
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO.top;
    }
    
    public static int bL(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO.bottom;
    }
    
    public static int bM(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO.left;
    }
    
    public static int bN(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO.right;
    }
    
    public static b c(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      b localb = new b();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt1, paramInt2);
      localb.orientation = paramContext.getInt(0, 1);
      localb.arE = paramContext.getInt(9, 1);
      localb.arF = paramContext.getBoolean(8, false);
      localb.arG = paramContext.getBoolean(10, false);
      paramContext.recycle();
      return localb;
    }
    
    private void c(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localw.isRemoved()))
      {
        this.alu.apV.G(localw);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localw.lB()) && (!localw.lz())) {
          break label128;
        }
        if (!localw.lz()) {
          break label120;
        }
        localw.lA();
        label68:
        this.apU.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.arJ)
        {
          localw.asD.invalidate();
          localLayoutParams.arJ = false;
        }
        return;
        this.alu.apV.H(localw);
        break;
        label120:
        localw.lC();
        break label68;
        label128:
        if (paramView.getParent() == this.alu)
        {
          int j = this.apU.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.apU.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.alu.indexOfChild(paramView) + this.alu.kp());
          }
          if (j != i) {
            this.alu.apZ.ay(j, i);
          }
        }
        else
        {
          this.apU.a(paramView, paramInt, false);
          localLayoutParams.arI = true;
          if ((this.aru != null) && (this.aru.eg)) {
            this.aru.bV(paramView);
          }
        }
      }
    }
    
    public static void c(View paramView, Rect paramRect)
    {
      RecyclerView.d(paramView, paramRect);
    }
    
    private void cm(int paramInt)
    {
      getChildAt(paramInt);
      this.apU.detachViewFromParent(paramInt);
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
        localRect = this.alu.mTempRect;
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
      if (t.Y(this.alu) == 1) {
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
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public static void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.anO;
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
      s locals = this.apU;
      int i = locals.ajT.indexOfChild(paramView);
      if (i >= 0)
      {
        if (locals.ajU.remove(i)) {
          locals.bf(paramView);
        }
        locals.ajT.removeViewAt(i);
      }
    }
    
    private void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.apU.removeViewAt(paramInt);
      }
    }
    
    public final void G(View paramView, int paramInt)
    {
      c(paramView, paramInt, true);
    }
    
    public void G(String paramString)
    {
      if (this.alu != null) {
        this.alu.G(paramString);
      }
    }
    
    public int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
    {
      return 0;
    }
    
    public int a(RecyclerView.o paramo, RecyclerView.t paramt)
    {
      if ((this.alu == null) || (this.alu.abe == null)) {}
      while (!jN()) {
        return 1;
      }
      return this.alu.abe.getItemCount();
    }
    
    public RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
    {
      return null;
    }
    
    public void a(int paramInt1, int paramInt2, RecyclerView.t paramt, a parama) {}
    
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
      setMeasuredDimension(m(paramInt1, i + j + k, t.ae(this.alu)), m(paramInt2, m + n + i1, t.af(this.alu)));
    }
    
    public void a(RecyclerView.o paramo, RecyclerView.t paramt, View paramView, android.support.v4.view.a.c paramc)
    {
      int i;
      if (jN())
      {
        i = bB(paramView);
        if (!jM()) {
          break label48;
        }
      }
      label48:
      for (int j = bB(paramView);; j = 0)
      {
        paramc.G(c.c.a(i, 1, j, 1, false));
        return;
        i = 0;
        break;
      }
    }
    
    public final void a(RecyclerView.s params)
    {
      if ((this.aru != null) && (params != this.aru) && (this.aru.eg)) {
        this.aru.stop();
      }
      this.aru = params;
      params = this.aru;
      RecyclerView localRecyclerView = this.alu;
      if (params.mStarted) {
        new StringBuilder("An instance of ").append(params.getClass().getSimpleName()).append(" was started more than once. Each instance of").append(params.getClass().getSimpleName()).append(" is intended to only be used once. You should create a new instance for each use.");
      }
      params.alu = localRecyclerView;
      params.apE = this;
      if (params.arZ == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      params.alu.aqO.arZ = params.arZ;
      params.eg = true;
      params.asa = true;
      int i = params.arZ;
      params.asb = params.alu.apZ.bY(i);
      params.alu.aqL.lq();
      params.mStarted = true;
    }
    
    public void a(RecyclerView.t paramt) {}
    
    public void a(RecyclerView paramRecyclerView) {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      g(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo) {}
    
    public void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt) {}
    
    final void a(View paramView, android.support.v4.view.a.c paramc)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if ((localw != null) && (!localw.isRemoved()) && (!this.apU.bg(localw.asD))) {
        a(this.alu.apR, this.alu.aqO, paramView, paramc);
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
      return (!this.arx) || (!n(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
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
      this.arB = View.MeasureSpec.getMode(paramInt1);
      if ((this.arB == 0) && (!RecyclerView.apK)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.arC = View.MeasureSpec.getMode(paramInt2);
      if ((this.arC == 0) && (!RecyclerView.apK)) {
        this.mHeight = 0;
      }
    }
    
    public final void aw(boolean paramBoolean)
    {
      if (paramBoolean != this.ary)
      {
        this.ary = paramBoolean;
        this.arz = 0;
        if (this.alu != null) {
          this.alu.apR.ln();
        }
      }
    }
    
    final void ax(int paramInt1, int paramInt2)
    {
      int i5 = getChildCount();
      if (i5 == 0)
      {
        this.alu.al(paramInt1, paramInt2);
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
        Rect localRect = this.alu.mTempRect;
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
      this.alu.mTempRect.set(i3, k, n, j);
      a(this.alu.mTempRect, paramInt1, paramInt2);
    }
    
    public final void az(int paramInt1, int paramInt2)
    {
      this.alu.al(paramInt1, paramInt2);
    }
    
    public int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
    {
      return 0;
    }
    
    public int b(RecyclerView.o paramo, RecyclerView.t paramt)
    {
      if ((this.alu == null) || (this.alu.abe == null)) {}
      while (!jM()) {
        return 1;
      }
      return this.alu.abe.getItemCount();
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
      this.ou = false;
      a(paramRecyclerView, paramo);
    }
    
    final boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.arx) || (!n(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public final void bD(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.alu.by(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      k = b(this.mWidth, this.arB, k + m + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, jM());
      i = b(this.mHeight, this.arC, j + i + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, jN());
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
        RecyclerView.w localw = RecyclerView.bv(localView);
        if ((localw != null) && (localw.lu() == paramInt) && (!localw.lt()) && ((this.alu.aqO.asp) || (!localw.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public final View bt(View paramView)
    {
      if (this.alu == null) {}
      do
      {
        return null;
        paramView = this.alu.bt(paramView);
      } while ((paramView == null) || (this.apU.bg(paramView)));
      return paramView;
    }
    
    final void c(RecyclerView.o paramo)
    {
      int j = paramo.arQ.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.w)paramo.arQ.get(i)).asD;
        RecyclerView.w localw = RecyclerView.bv(localView);
        if (!localw.lt())
        {
          localw.ax(false);
          if (localw.lF()) {
            this.alu.removeDetachedView(localView, false);
          }
          if (this.alu.aqz != null) {
            this.alu.aqz.d(localw);
          }
          localw.ax(true);
          paramo.bT(localView);
        }
        i -= 1;
      }
      paramo.arQ.clear();
      if (paramo.arR != null) {
        paramo.arR.clear();
      }
      if (j > 0) {
        this.alu.invalidate();
      }
    }
    
    public void c(RecyclerView.o paramo, RecyclerView.t paramt) {}
    
    public void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void ca(int paramInt) {}
    
    public void cn(int paramInt)
    {
      if (this.alu != null)
      {
        RecyclerView localRecyclerView = this.alu;
        int j = localRecyclerView.apU.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.apU.getChildAt(i).offsetLeftAndRight(paramInt);
          i += 1;
        }
      }
    }
    
    public void co(int paramInt)
    {
      if (this.alu != null)
      {
        RecyclerView localRecyclerView = this.alu;
        int j = localRecyclerView.apU.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.apU.getChildAt(i).offsetTopAndBottom(paramInt);
          i += 1;
        }
      }
    }
    
    public void cp(int paramInt) {}
    
    public int d(RecyclerView.t paramt)
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
        if (!RecyclerView.bv(getChildAt(i)).lt()) {
          a(i, paramo);
        }
        i -= 1;
      }
    }
    
    public void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public int e(RecyclerView.t paramt)
    {
      return 0;
    }
    
    public final void e(View paramView, Rect paramRect)
    {
      Object localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).anO;
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      int k = paramView.getWidth();
      int m = ((Rect)localObject).right;
      int n = paramView.getHeight();
      paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
      if (this.alu != null)
      {
        localObject = paramView.getMatrix();
        if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
        {
          RectF localRectF = this.alu.apY;
          localRectF.set(paramRect);
          ((Matrix)localObject).mapRect(localRectF);
          paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
        }
      }
      paramRect.offset(paramView.getLeft(), paramView.getTop());
    }
    
    public int f(RecyclerView.t paramt)
    {
      return 0;
    }
    
    final void f(RecyclerView paramRecyclerView)
    {
      this.ou = true;
      g(paramRecyclerView);
    }
    
    public final void f(View paramView, Rect paramRect)
    {
      if (this.alu == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.alu.by(paramView));
    }
    
    public int g(RecyclerView.t paramt)
    {
      return 0;
    }
    
    public void g(RecyclerView paramRecyclerView) {}
    
    public void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public final View getChildAt(int paramInt)
    {
      if (this.apU != null) {
        return this.apU.getChildAt(paramInt);
      }
      return null;
    }
    
    public final int getChildCount()
    {
      if (this.apU != null) {
        return this.apU.getChildCount();
      }
      return 0;
    }
    
    public final boolean getClipToPadding()
    {
      return (this.alu != null) && (this.alu.apW);
    }
    
    public final View getFocusedChild()
    {
      if (this.alu == null) {}
      View localView;
      do
      {
        return null;
        localView = this.alu.getFocusedChild();
      } while ((localView == null) || (this.apU.bg(localView)));
      return localView;
    }
    
    public final int getHeight()
    {
      return this.mHeight;
    }
    
    public final int getItemCount()
    {
      if (this.alu != null) {}
      for (RecyclerView.a locala = this.alu.getAdapter(); locala != null; locala = null) {
        return locala.getItemCount();
      }
      return 0;
    }
    
    public int getPaddingBottom()
    {
      if (this.alu != null) {
        return this.alu.getPaddingBottom();
      }
      return 0;
    }
    
    public int getPaddingEnd()
    {
      if (this.alu != null) {
        return t.ac(this.alu);
      }
      return 0;
    }
    
    public int getPaddingLeft()
    {
      if (this.alu != null) {
        return this.alu.getPaddingLeft();
      }
      return 0;
    }
    
    public int getPaddingRight()
    {
      if (this.alu != null) {
        return this.alu.getPaddingRight();
      }
      return 0;
    }
    
    public int getPaddingStart()
    {
      if (this.alu != null) {
        return t.ab(this.alu);
      }
      return 0;
    }
    
    public int getPaddingTop()
    {
      if (this.alu != null) {
        return this.alu.getPaddingTop();
      }
      return 0;
    }
    
    public final int getWidth()
    {
      return this.mWidth;
    }
    
    public int h(RecyclerView.t paramt)
    {
      return 0;
    }
    
    final void h(RecyclerView paramRecyclerView)
    {
      aw(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public int i(RecyclerView.t paramt)
    {
      return 0;
    }
    
    public abstract RecyclerView.LayoutParams jG();
    
    public boolean jK()
    {
      return false;
    }
    
    public boolean jL()
    {
      return this.arw;
    }
    
    public boolean jM()
    {
      return false;
    }
    
    public boolean jN()
    {
      return false;
    }
    
    boolean jR()
    {
      return false;
    }
    
    @Deprecated
    public final void le()
    {
      this.arw = true;
    }
    
    public final boolean lf()
    {
      return (this.aru != null) && (this.aru.eg);
    }
    
    public void lg() {}
    
    final void lh()
    {
      if (this.aru != null) {
        this.aru.stop();
      }
    }
    
    public void li()
    {
      this.arv = true;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      if ((this.alu == null) || (paramAccessibilityEvent == null)) {
        return;
      }
      boolean bool1 = bool2;
      if (!this.alu.canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.alu.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.alu.canScrollHorizontally(-1)) {
            if (!this.alu.canScrollHorizontally(1)) {
              break label96;
            }
          }
        }
      }
      label96:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (this.alu.abe == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.alu.abe.getItemCount());
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
        this.apU.removeViewAt(i);
        i -= 1;
      }
    }
    
    public final boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.alu != null) {
        return this.alu.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public final void requestLayout()
    {
      if (this.alu != null) {
        this.alu.requestLayout();
      }
    }
    
    public final void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      RecyclerView.e(this.alu, paramInt1, paramInt2);
    }
    
    final void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.alu = null;
        this.apU = null;
        this.mWidth = 0;
      }
      for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
      {
        this.arB = 1073741824;
        this.arC = 1073741824;
        return;
        this.alu = paramRecyclerView;
        this.apU = paramRecyclerView.apU;
        this.mWidth = paramRecyclerView.getWidth();
      }
    }
    
    public static abstract interface a
    {
      public abstract void R(int paramInt1, int paramInt2);
    }
    
    public static final class b
    {
      public int arE;
      public boolean arF;
      public boolean arG;
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
    SparseArray<a> arK = new SparseArray();
    int arL = 0;
    
    static long c(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    final boolean a(int paramInt, long paramLong1, long paramLong2)
    {
      long l = cs(paramInt).arO;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }
    
    public final void aB(int paramInt1, int paramInt2)
    {
      Object localObject = cs(paramInt1);
      ((a)localObject).arN = paramInt2;
      localObject = ((a)localObject).arM;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
    }
    
    public final int cq(int paramInt)
    {
      return cs(paramInt).arM.size();
    }
    
    public RecyclerView.w cr(int paramInt)
    {
      Object localObject = (a)this.arK.get(paramInt);
      if ((localObject != null) && (!((a)localObject).arM.isEmpty()))
      {
        localObject = ((a)localObject).arM;
        return (RecyclerView.w)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      return null;
    }
    
    final a cs(int paramInt)
    {
      a locala2 = (a)this.arK.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.arK.put(paramInt, locala1);
      }
      return locala1;
    }
    
    final void d(int paramInt, long paramLong)
    {
      a locala = cs(paramInt);
      locala.arO = c(locala.arO, paramLong);
    }
    
    final void detach()
    {
      this.arL -= 1;
    }
    
    final void lm()
    {
      this.arL += 1;
    }
    
    public void q(RecyclerView.w paramw)
    {
      int i = paramw.asH;
      ArrayList localArrayList = cs(i).arM;
      if (((a)this.arK.get(i)).arN <= localArrayList.size()) {
        return;
      }
      paramw.resetInternal();
      localArrayList.add(paramw);
    }
    
    static final class a
    {
      final ArrayList<RecyclerView.w> arM = new ArrayList();
      int arN = 5;
      long arO = 0L;
      long arP = 0L;
    }
  }
  
  public final class o
  {
    final ArrayList<RecyclerView.w> arQ = new ArrayList();
    ArrayList<RecyclerView.w> arR = null;
    final ArrayList<RecyclerView.w> arS = new ArrayList();
    final List<RecyclerView.w> arT = Collections.unmodifiableList(this.arQ);
    int arU = 2;
    int arV = 2;
    RecyclerView.n arW;
    RecyclerView.u arX;
    
    public o() {}
    
    private RecyclerView.w a(long paramLong, int paramInt)
    {
      int i = this.arQ.size() - 1;
      RecyclerView.w localw;
      while (i >= 0)
      {
        localw = (RecyclerView.w)this.arQ.get(i);
        if ((localw.asG == paramLong) && (!localw.lB()))
        {
          if (paramInt == localw.asH)
          {
            localw.addFlags(32);
            if ((localw.isRemoved()) && (!RecyclerView.this.aqO.asp)) {
              localw.setFlags(2, 14);
            }
            return localw;
          }
          this.arQ.remove(i);
          RecyclerView.this.removeDetachedView(localw.asD, false);
          bT(localw.asD);
        }
        i -= 1;
      }
      i = this.arS.size() - 1;
      while (i >= 0)
      {
        localw = (RecyclerView.w)this.arS.get(i);
        if (localw.asG == paramLong)
        {
          if (paramInt == localw.asH)
          {
            this.arS.remove(i);
            return localw;
          }
          cw(i);
          return null;
        }
        i -= 1;
      }
      return null;
    }
    
    private boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, long paramLong)
    {
      paramw.asT = RecyclerView.this;
      int i = paramw.asH;
      long l1 = RecyclerView.this.getNanoTime();
      if (paramLong != 9223372036854775807L)
      {
        long l2 = this.arW.cs(i).arP;
        if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
        for (i = 1; i == 0; i = 0) {
          return false;
        }
      }
      Object localObject = RecyclerView.this.abe;
      paramw.mPosition = paramInt1;
      if (((RecyclerView.a)localObject).arh) {
        paramw.asG = ((RecyclerView.a)localObject).getItemId(paramInt1);
      }
      paramw.setFlags(1, 519);
      e.beginSection("RV OnBindView");
      ((RecyclerView.a)localObject).a(paramw, paramInt1, paramw.lI());
      paramw.lH();
      localObject = paramw.asD.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)localObject).arI = true;
      }
      e.endSection();
      paramLong = RecyclerView.this.getNanoTime();
      localObject = this.arW.cs(paramw.asH);
      ((RecyclerView.n.a)localObject).arP = RecyclerView.n.c(((RecyclerView.n.a)localObject).arP, paramLong - l1);
      if (RecyclerView.this.kE())
      {
        localObject = paramw.asD;
        if (t.X((View)localObject) == 0) {
          t.p((View)localObject, 1);
        }
        if (!t.U((View)localObject))
        {
          paramw.addFlags(16384);
          t.a((View)localObject, RecyclerView.this.aqV.asU);
        }
      }
      if (RecyclerView.this.aqO.asp) {
        paramw.asI = paramInt2;
      }
      return true;
    }
    
    private RecyclerView.w cx(int paramInt)
    {
      int j = 0;
      int k;
      if (this.arR != null)
      {
        k = this.arR.size();
        if (k != 0) {}
      }
      else
      {
        return null;
      }
      int i = 0;
      RecyclerView.w localw;
      while (i < k)
      {
        localw = (RecyclerView.w)this.arR.get(i);
        if ((!localw.lB()) && (localw.lu() == paramInt))
        {
          localw.addFlags(32);
          return localw;
        }
        i += 1;
      }
      if (RecyclerView.this.abe.arh)
      {
        paramInt = RecyclerView.this.apT.L(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.abe.getItemCount()))
        {
          long l = RecyclerView.this.abe.getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localw = (RecyclerView.w)this.arR.get(paramInt);
            if ((!localw.lB()) && (localw.asG == l))
            {
              localw.addFlags(32);
              return localw;
            }
            paramInt += 1;
          }
        }
      }
      return null;
    }
    
    private RecyclerView.w cy(int paramInt)
    {
      int j = 0;
      int k = this.arQ.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.w)this.arQ.get(i);
        if ((!((RecyclerView.w)localObject1).lB()) && (((RecyclerView.w)localObject1).lu() == paramInt) && (!((RecyclerView.w)localObject1).bj()) && ((RecyclerView.this.aqO.asp) || (!((RecyclerView.w)localObject1).isRemoved())))
        {
          ((RecyclerView.w)localObject1).addFlags(32);
          return localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.apU;
      k = ((s)localObject2).ajV.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((s)localObject2).ajV.get(i);
        localObject3 = ((s)localObject2).ajT.bh((View)localObject1);
        if ((((RecyclerView.w)localObject3).lu() != paramInt) || (((RecyclerView.w)localObject3).bj()) || (((RecyclerView.w)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.bv((View)localObject1);
          localObject3 = RecyclerView.this.apU;
          paramInt = ((s)localObject3).ajT.indexOfChild((View)localObject1);
          if (paramInt < 0)
          {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((s)localObject3).ajU.get(paramInt)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
          }
          ((s)localObject3).ajU.clear(paramInt);
          ((s)localObject3).bf((View)localObject1);
          paramInt = RecyclerView.this.apU.indexOfChild((View)localObject1);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + RecyclerView.this.kp());
          }
          RecyclerView.this.apU.detachViewFromParent(paramInt);
          bU((View)localObject1);
          ((RecyclerView.w)localObject2).addFlags(8224);
          return localObject2;
        }
      }
      k = this.arS.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.w)this.arS.get(i);
        if ((!((RecyclerView.w)localObject1).bj()) && (((RecyclerView.w)localObject1).lu() == paramInt))
        {
          this.arS.remove(i);
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
    
    private void lo()
    {
      int i = this.arS.size() - 1;
      while (i >= 0)
      {
        cw(i);
        i -= 1;
      }
      this.arS.clear();
      if (RecyclerView.apM) {
        RecyclerView.this.aqN.jm();
      }
    }
    
    private boolean r(RecyclerView.w paramw)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramw.isRemoved()) {
        bool1 = RecyclerView.this.aqO.asp;
      }
      do
      {
        do
        {
          return bool1;
          if ((paramw.mPosition < 0) || (paramw.mPosition >= RecyclerView.this.abe.getItemCount())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramw + RecyclerView.this.kp());
          }
          if (RecyclerView.this.aqO.asp) {
            break;
          }
          bool1 = bool2;
        } while (RecyclerView.this.abe.getItemViewType(paramw.mPosition) != paramw.asH);
        if (!RecyclerView.this.abe.arh) {
          break;
        }
        bool1 = bool2;
      } while (paramw.asG != RecyclerView.this.abe.getItemId(paramw.mPosition));
      return true;
      return true;
    }
    
    private void s(RecyclerView.w paramw)
    {
      if ((paramw.asD instanceof ViewGroup)) {
        d((ViewGroup)paramw.asD, false);
      }
    }
    
    private void v(RecyclerView.w paramw)
    {
      if (RecyclerView.this.abe != null) {
        RecyclerView.this.abe.a(paramw);
      }
      if (RecyclerView.this.aqO != null) {
        RecyclerView.this.apV.I(paramw);
      }
    }
    
    final void a(RecyclerView.w paramw, boolean paramBoolean)
    {
      RecyclerView.h(paramw);
      if (paramw.cB(16384))
      {
        paramw.setFlags(0, 16384);
        t.a(paramw.asD, null);
      }
      if (paramBoolean) {
        v(paramw);
      }
      paramw.asT = null;
      getRecycledViewPool().q(paramw);
    }
    
    public final void bS(View paramView)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if (localw.lF()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localw.lz()) {
        localw.lA();
      }
      for (;;)
      {
        t(localw);
        return;
        if (localw.lB()) {
          localw.lC();
        }
      }
    }
    
    final void bT(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      paramView.asP = null;
      paramView.asQ = false;
      paramView.lC();
      t(paramView);
    }
    
    final void bU(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      int i;
      if ((!paramView.cB(12)) && (paramView.lL()))
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.aqz != null) && (!localRecyclerView.aqz.a(paramView, paramView.lI()))) {
          break label112;
        }
        i = 1;
      }
      while (i != 0) {
        if ((paramView.bj()) && (!paramView.isRemoved()) && (!RecyclerView.this.abe.arh))
        {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.kp());
          label112:
          i = 0;
        }
        else
        {
          paramView.a(this, false);
          this.arQ.add(paramView);
          return;
        }
      }
      if (this.arR == null) {
        this.arR = new ArrayList();
      }
      paramView.a(this, true);
      this.arR.add(paramView);
    }
    
    public final void clear()
    {
      this.arQ.clear();
      lo();
    }
    
    public final int ct(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.aqO.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.aqO.getItemCount() + RecyclerView.this.kp());
      }
      if (!RecyclerView.this.aqO.asp) {
        return paramInt;
      }
      return RecyclerView.this.apT.bD(paramInt);
    }
    
    public final View cu(int paramInt)
    {
      return cv(paramInt);
    }
    
    final View cv(int paramInt)
    {
      return e(paramInt, 9223372036854775807L).asD;
    }
    
    final void cw(int paramInt)
    {
      a((RecyclerView.w)this.arS.get(paramInt), true);
      this.arS.remove(paramInt);
    }
    
    final RecyclerView.w e(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.aqO.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.aqO.getItemCount() + RecyclerView.this.kp());
      }
      Object localObject1;
      int i;
      if (RecyclerView.this.aqO.asp)
      {
        localObject1 = cx(paramInt);
        if (localObject1 != null) {
          i = 1;
        }
      }
      for (int j = i;; j = 0)
      {
        Object localObject2;
        if (localObject1 == null)
        {
          localObject2 = cy(paramInt);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null)
          {
            if (r((RecyclerView.w)localObject2)) {
              break label321;
            }
            ((RecyclerView.w)localObject2).addFlags(4);
            if (!((RecyclerView.w)localObject2).lz()) {
              break label305;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.w)localObject2).asD, false);
            ((RecyclerView.w)localObject2).lA();
            label183:
            t((RecyclerView.w)localObject2);
            localObject1 = null;
            i = j;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int k = RecyclerView.this.apT.bD(paramInt);
            if ((k < 0) || (k >= RecyclerView.this.abe.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.aqO.getItemCount() + RecyclerView.this.kp());
              i = 0;
              break;
              label305:
              if (!((RecyclerView.w)localObject2).lB()) {
                break label183;
              }
              ((RecyclerView.w)localObject2).lC();
              break label183;
              label321:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.this.abe.getItemViewType(k);
            if (RecyclerView.this.abe.arh)
            {
              localObject2 = a(RecyclerView.this.abe.getItemId(k), j);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.w)localObject2).mPosition = k;
                i = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject2 = getRecycledViewPool().cr(j);
                  localObject1 = localObject2;
                  if (localObject2 != null)
                  {
                    ((RecyclerView.w)localObject2).resetInternal();
                    localObject1 = localObject2;
                    if (RecyclerView.apJ)
                    {
                      s((RecyclerView.w)localObject2);
                      localObject1 = localObject2;
                    }
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  long l1 = RecyclerView.this.getNanoTime();
                  if ((paramLong != 9223372036854775807L) && (!this.arW.a(j, l1, paramLong))) {
                    return null;
                  }
                  localObject2 = RecyclerView.this.abe.d(RecyclerView.this, j);
                  if (RecyclerView.apM)
                  {
                    localObject1 = RecyclerView.bz(((RecyclerView.w)localObject2).asD);
                    if (localObject1 != null) {
                      ((RecyclerView.w)localObject2).asE = new WeakReference(localObject1);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.arW.d(j, l2 - l1);
                }
              }
            }
          }
          for (;;)
          {
            if ((i != 0) && (!RecyclerView.this.aqO.asp) && (((RecyclerView.w)localObject2).cB(8192)))
            {
              ((RecyclerView.w)localObject2).setFlags(0, 8192);
              if (RecyclerView.this.aqO.ass)
              {
                j = RecyclerView.f.m((RecyclerView.w)localObject2);
                localObject1 = RecyclerView.this.aqz.a(RecyclerView.this.aqO, (RecyclerView.w)localObject2, j | 0x1000, ((RecyclerView.w)localObject2).lI());
                RecyclerView.this.a((RecyclerView.w)localObject2, (RecyclerView.f.c)localObject1);
              }
            }
            boolean bool1;
            if ((RecyclerView.this.aqO.asp) && (((RecyclerView.w)localObject2).isBound()))
            {
              ((RecyclerView.w)localObject2).asI = paramInt;
              bool1 = false;
            }
            for (;;)
            {
              localObject1 = ((RecyclerView.w)localObject2).asD.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                ((RecyclerView.w)localObject2).asD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label738:
                ((RecyclerView.LayoutParams)localObject1).arH = ((RecyclerView.w)localObject2);
                if ((i == 0) || (!bool1)) {
                  break label866;
                }
              }
              label866:
              for (bool1 = bool2;; bool1 = false)
              {
                ((RecyclerView.LayoutParams)localObject1).arJ = bool1;
                return localObject2;
                if ((((RecyclerView.w)localObject2).isBound()) && (!((RecyclerView.w)localObject2).lE()) && (!((RecyclerView.w)localObject2).bj())) {
                  break label872;
                }
                bool1 = a((RecyclerView.w)localObject2, RecyclerView.this.apT.bD(paramInt), paramInt, paramLong);
                break;
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((RecyclerView.w)localObject2).asD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
      if (this.arW == null) {
        this.arW = new RecyclerView.n();
      }
      return this.arW;
    }
    
    final void kT()
    {
      int j = 0;
      int k = this.arS.size();
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.w)this.arS.get(i)).lr();
        i += 1;
      }
      k = this.arQ.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.w)this.arQ.get(i)).lr();
        i += 1;
      }
      if (this.arR != null)
      {
        k = this.arR.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.w)this.arR.get(i)).lr();
          i += 1;
        }
      }
    }
    
    final void kU()
    {
      int j = this.arS.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.w localw = (RecyclerView.w)this.arS.get(i);
        if (localw != null)
        {
          localw.addFlags(6);
          localw.N(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.abe == null) || (!RecyclerView.this.abe.arh)) {
        lo();
      }
    }
    
    final void ln()
    {
      if (RecyclerView.this.apZ != null) {}
      for (int i = RecyclerView.this.apZ.arz;; i = 0)
      {
        this.arV = (i + this.arU);
        i = this.arS.size() - 1;
        while ((i >= 0) && (this.arS.size() > this.arV))
        {
          cw(i);
          i -= 1;
        }
      }
    }
    
    final void t(RecyclerView.w paramw)
    {
      int k = 1;
      if ((paramw.lz()) || (paramw.asD.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramw.lz()).append(" isAttached:");
        if (paramw.asD.getParent() != null) {}
        for (bool = true;; bool = false) {
          throw new IllegalArgumentException(bool + RecyclerView.this.kp());
        }
      }
      if (paramw.lF()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramw + RecyclerView.this.kp());
      }
      if (paramw.lt()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.kp());
      }
      boolean bool = paramw.lK();
      int j;
      int i;
      if (paramw.lJ()) {
        if ((this.arV > 0) && (!paramw.cB(526)))
        {
          j = this.arS.size();
          i = j;
          if (j >= this.arV)
          {
            i = j;
            if (j > 0)
            {
              cw(0);
              i = j - 1;
            }
          }
          j = i;
          if (RecyclerView.apM)
          {
            j = i;
            if (i > 0)
            {
              j = i;
              if (!RecyclerView.this.aqN.bO(paramw.mPosition))
              {
                i -= 1;
                while (i >= 0)
                {
                  j = ((RecyclerView.w)this.arS.get(i)).mPosition;
                  if (!RecyclerView.this.aqN.bO(j)) {
                    break;
                  }
                  i -= 1;
                }
                j = i + 1;
              }
            }
          }
          this.arS.add(j, paramw);
          i = 1;
          if (i == 0)
          {
            a(paramw, true);
            j = k;
          }
        }
      }
      for (;;)
      {
        RecyclerView.this.apV.I(paramw);
        if ((i == 0) && (j == 0) && (bool)) {
          paramw.asT = null;
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
    
    final void u(RecyclerView.w paramw)
    {
      if (paramw.asQ) {
        this.arR.remove(paramw);
      }
      for (;;)
      {
        paramw.asP = null;
        paramw.asQ = false;
        paramw.lC();
        return;
        this.arQ.remove(paramw);
      }
    }
  }
  
  public static abstract interface p {}
  
  final class q
    extends RecyclerView.c
  {
    q() {}
    
    private void lp()
    {
      if ((RecyclerView.apL) && (RecyclerView.this.aqf) && (RecyclerView.this.aqe))
      {
        t.b(RecyclerView.this, RecyclerView.this.apX);
        return;
      }
      RecyclerView.this.aqn = true;
      RecyclerView.this.requestLayout();
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.G(null);
      d locald = RecyclerView.this.apT;
      if (paramInt2 > 0)
      {
        locald.ahO.add(locald.b(1, paramInt1, paramInt2, null));
        locald.ahU |= 0x1;
        if (locald.ahO.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lp();
        }
        return;
      }
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.G(null);
      d locald = RecyclerView.this.apT;
      if (paramInt2 > 0)
      {
        locald.ahO.add(locald.b(2, paramInt1, paramInt2, null));
        locald.ahU |= 0x2;
        if (locald.ahO.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lp();
        }
        return;
      }
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      RecyclerView.this.G(null);
      d locald = RecyclerView.this.apT;
      if (paramInt2 > 0)
      {
        locald.ahO.add(locald.b(4, paramInt1, paramInt2, paramObject));
        locald.ahU |= 0x4;
        if (locald.ahO.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lp();
        }
        return;
      }
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      RecyclerView.this.G(null);
      d locald = RecyclerView.this.apT;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1) {
          throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        locald.ahO.add(locald.b(8, paramInt1, paramInt2, null));
        locald.ahU |= 0x8;
        if (locald.ahO.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lp();
        }
        return;
      }
    }
    
    public final void onChanged()
    {
      RecyclerView.this.G(null);
      RecyclerView.this.aqO.aso = true;
      RecyclerView.this.au(true);
      if (!RecyclerView.this.apT.iD()) {
        RecyclerView.this.requestLayout();
      }
    }
  }
  
  public static abstract class s
  {
    RecyclerView alu;
    RecyclerView.i apE;
    public int arZ = -1;
    boolean asa;
    View asb;
    private final a asc = new a();
    boolean eg;
    boolean mStarted;
    
    protected abstract void a(int paramInt1, int paramInt2, a parama);
    
    protected abstract void a(View paramView, RecyclerView.t paramt, a parama);
    
    final void aC(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.alu;
      if ((!this.eg) || (this.arZ == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.asa) && (this.asb == null) && (this.apE != null))
      {
        PointF localPointF = bZ(this.arZ);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.b((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.asa = false;
      if (this.asb != null)
      {
        if (RecyclerView.bx(this.asb) != this.arZ) {
          break label233;
        }
        a(this.asb, localRecyclerView.aqO, this.asc);
        this.asc.i(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.eg)
        {
          a(paramInt1, paramInt2, this.asc);
          paramInt1 = i;
          if (this.asc.asg >= 0) {
            paramInt1 = 1;
          }
          this.asc.i(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.eg) {
              break;
            }
            this.asa = true;
            localRecyclerView.aqL.lq();
          }
        }
        return;
        label233:
        this.asb = null;
      }
      stop();
    }
    
    protected final void bV(View paramView)
    {
      if (RecyclerView.bx(paramView) == this.arZ) {
        this.asb = paramView;
      }
    }
    
    public PointF bZ(int paramInt)
    {
      RecyclerView.i locali = this.apE;
      if ((locali instanceof b)) {
        return ((b)locali).bZ(paramInt);
      }
      new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
      return null;
    }
    
    public final void cz(int paramInt)
    {
      this.arZ = paramInt;
    }
    
    public final RecyclerView.i getLayoutManager()
    {
      return this.apE;
    }
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.eg) {
        return;
      }
      this.eg = false;
      onStop();
      this.alu.aqO.arZ = -1;
      this.asb = null;
      this.arZ = -1;
      this.asa = false;
      RecyclerView.i locali = this.apE;
      if (locali.aru == this) {
        locali.aru = null;
      }
      this.apE = null;
      this.alu = null;
    }
    
    public static final class a
    {
      private int asd = 0;
      private int ase = 0;
      private int asf = -2147483648;
      int asg = -1;
      private boolean ash = false;
      private int asi = 0;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this((byte)0);
      }
      
      private a(byte paramByte) {}
      
      private void validate()
      {
        if ((this.mInterpolator != null) && (this.asf <= 0)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.asf <= 0) {
          throw new IllegalStateException("Scroll duration must be a positive number");
        }
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.asd = paramInt1;
        this.ase = paramInt2;
        this.asf = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.ash = true;
      }
      
      final void i(RecyclerView paramRecyclerView)
      {
        if (this.asg >= 0)
        {
          int i = this.asg;
          this.asg = -1;
          paramRecyclerView.cg(i);
          this.ash = false;
          return;
        }
        if (this.ash)
        {
          validate();
          if (this.mInterpolator == null) {
            if (this.asf == -2147483648) {
              paramRecyclerView.aqL.aD(this.asd, this.ase);
            }
          }
          for (;;)
          {
            this.asi += 1;
            this.ash = false;
            return;
            paramRecyclerView.aqL.o(this.asd, this.ase, this.asf);
            continue;
            paramRecyclerView.aqL.b(this.asd, this.ase, this.asf, this.mInterpolator);
          }
        }
        this.asi = 0;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF bZ(int paramInt);
    }
  }
  
  public static final class t
  {
    int arZ = -1;
    private SparseArray<Object> asj;
    int ask = 0;
    int asl = 0;
    int asm = 1;
    int asn = 0;
    boolean aso = false;
    public boolean asp = false;
    boolean asq = false;
    boolean asr = false;
    boolean ass = false;
    boolean ast = false;
    int asu;
    long asv;
    int asw;
    int asx;
    int asy;
    
    final void cA(int paramInt)
    {
      if ((this.asm & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.asm));
      }
    }
    
    public final int getItemCount()
    {
      if (this.asp) {
        return this.ask - this.asl;
      }
      return this.asn;
    }
    
    public final String toString()
    {
      return "State{mTargetPosition=" + this.arZ + ", mData=" + this.asj + ", mItemCount=" + this.asn + ", mIsMeasuring=" + this.asr + ", mPreviousLayoutItemCount=" + this.ask + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.asl + ", mStructureChanged=" + this.aso + ", mInPreLayout=" + this.asp + ", mRunSimpleAnimations=" + this.ass + ", mRunPredictiveAnimations=" + this.ast + '}';
    }
  }
  
  public static abstract class u {}
  
  final class v
    implements Runnable
  {
    OverScroller SC = new OverScroller(RecyclerView.this.getContext(), RecyclerView.ard);
    int asA;
    private boolean asB = false;
    private boolean asC = false;
    int asz;
    Interpolator mInterpolator = RecyclerView.ard;
    
    v() {}
    
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
        this.SC = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.asA = 0;
      this.asz = 0;
      this.SC.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.SC.computeScrollOffset();
      }
      lq();
    }
    
    final void lq()
    {
      if (this.asB)
      {
        this.asC = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      t.b(RecyclerView.this, this);
    }
    
    public final void o(int paramInt1, int paramInt2, int paramInt3)
    {
      b(paramInt1, paramInt2, paramInt3, RecyclerView.ard);
    }
    
    public final void run()
    {
      if (RecyclerView.this.apZ == null)
      {
        stop();
        return;
      }
      this.asC = false;
      this.asB = true;
      RecyclerView.this.kr();
      OverScroller localOverScroller = this.SC;
      RecyclerView.s locals = RecyclerView.this.apZ.aru;
      int i6;
      int i7;
      int k;
      int j;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.SM;
        i6 = localOverScroller.getCurrX();
        i7 = localOverScroller.getCurrY();
        k = i6 - this.asz;
        j = i7 - this.asA;
        this.asz = i6;
        this.asA = i7;
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
        if (RecyclerView.this.abe != null)
        {
          RecyclerView.this.b(k, j, RecyclerView.this.ara);
          i = RecyclerView.this.ara[0];
          i3 = RecyclerView.this.ara[1];
          i4 = k - i;
          i5 = j - i3;
          m = i;
          n = i3;
          i1 = i4;
          i2 = i5;
          if (locals != null)
          {
            m = i;
            n = i3;
            i1 = i4;
            i2 = i5;
            if (!locals.asa)
            {
              m = i;
              n = i3;
              i1 = i4;
              i2 = i5;
              if (locals.eg)
              {
                m = RecyclerView.this.aqO.getItemCount();
                if (m != 0) {
                  break label695;
                }
                locals.stop();
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
          if (!RecyclerView.this.aqb.isEmpty()) {
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
              if ((j != 0) && (RecyclerView.this.apZ.jN()) && (n == j))
              {
                i = 1;
                if ((k == 0) || (!RecyclerView.this.apZ.jM()) || (m != k)) {
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
                if (RecyclerView.apM) {
                  RecyclerView.this.aqN.jm();
                }
                RecyclerView.this.aM(1);
              }
              for (;;)
              {
                if (locals != null)
                {
                  if (locals.asa) {
                    locals.aC(0, 0);
                  }
                  if (!this.asC) {
                    locals.stop();
                  }
                }
                this.asB = false;
                if (!this.asC) {
                  break;
                }
                lq();
                return;
                if (locals.arZ >= m) {
                  locals.arZ = (m - 1);
                }
                locals.aC(k - i4, j - i5);
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
                lq();
                if (RecyclerView.this.aqM != null) {
                  RecyclerView.this.aqM.b(RecyclerView.this, k, j);
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
      this.SC.abortAnimation();
    }
  }
  
  public static abstract class w
  {
    private static final List<Object> asL = ;
    int DU;
    public final View asD;
    WeakReference<RecyclerView> asE;
    int asF = -1;
    public long asG = -1L;
    public int asH = -1;
    int asI = -1;
    w asJ = null;
    w asK = null;
    List<Object> asM = null;
    List<Object> asN = null;
    private int asO = 0;
    RecyclerView.o asP = null;
    boolean asQ = false;
    int asR = 0;
    int asS = -1;
    RecyclerView asT;
    int mPosition = -1;
    
    public w(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.asD = paramView;
    }
    
    private void lG()
    {
      if (this.asM == null)
      {
        this.asM = new ArrayList();
        this.asN = Collections.unmodifiableList(this.asM);
      }
    }
    
    final void N(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((this.DU & 0x400) != 0) {
        return;
      }
      lG();
      this.asM.add(paramObject);
    }
    
    final void a(RecyclerView.o paramo, boolean paramBoolean)
    {
      this.asP = paramo;
      this.asQ = paramBoolean;
    }
    
    final void addFlags(int paramInt)
    {
      this.DU |= paramInt;
    }
    
    public final void ax(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.asO - 1;
        this.asO = i;
        if (this.asO >= 0) {
          break label53;
        }
        this.asO = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.asO + 1;
        break;
        if ((!paramBoolean) && (this.asO == 1))
        {
          this.DU |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.asO != 0));
      this.DU &= 0xFFFFFFEF;
    }
    
    final boolean bj()
    {
      return (this.DU & 0x4) != 0;
    }
    
    final boolean cB(int paramInt)
    {
      return (this.DU & paramInt) != 0;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.asI == -1) {
        return this.mPosition;
      }
      return this.asI;
    }
    
    final boolean isBound()
    {
      return (this.DU & 0x1) != 0;
    }
    
    public final boolean isRemoved()
    {
      return (this.DU & 0x8) != 0;
    }
    
    final void k(int paramInt, boolean paramBoolean)
    {
      if (this.asF == -1) {
        this.asF = this.mPosition;
      }
      if (this.asI == -1) {
        this.asI = this.mPosition;
      }
      if (paramBoolean) {
        this.asI += paramInt;
      }
      this.mPosition += paramInt;
      if (this.asD.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.asD.getLayoutParams()).arI = true;
      }
    }
    
    final void lA()
    {
      this.asP.u(this);
    }
    
    final boolean lB()
    {
      return (this.DU & 0x20) != 0;
    }
    
    final void lC()
    {
      this.DU &= 0xFFFFFFDF;
    }
    
    final void lD()
    {
      this.DU &= 0xFFFFFEFF;
    }
    
    final boolean lE()
    {
      return (this.DU & 0x2) != 0;
    }
    
    final boolean lF()
    {
      return (this.DU & 0x100) != 0;
    }
    
    final void lH()
    {
      if (this.asM != null) {
        this.asM.clear();
      }
      this.DU &= 0xFFFFFBFF;
    }
    
    final List<Object> lI()
    {
      if ((this.DU & 0x400) == 0)
      {
        if ((this.asM == null) || (this.asM.size() == 0)) {
          return asL;
        }
        return this.asN;
      }
      return asL;
    }
    
    public final boolean lJ()
    {
      return ((this.DU & 0x10) == 0) && (!t.V(this.asD));
    }
    
    final boolean lK()
    {
      return ((this.DU & 0x10) == 0) && (t.V(this.asD));
    }
    
    final boolean lL()
    {
      return (this.DU & 0x2) != 0;
    }
    
    final void lr()
    {
      this.asF = -1;
      this.asI = -1;
    }
    
    final void ls()
    {
      if (this.asF == -1) {
        this.asF = this.mPosition;
      }
    }
    
    final boolean lt()
    {
      return (this.DU & 0x80) != 0;
    }
    
    public final int lu()
    {
      if (this.asI == -1) {
        return this.mPosition;
      }
      return this.asI;
    }
    
    public final int lv()
    {
      if (this.asT == null) {
        return -1;
      }
      return this.asT.i(this);
    }
    
    public final int lw()
    {
      return this.asF;
    }
    
    public final long lx()
    {
      return this.asG;
    }
    
    public final int ly()
    {
      return this.asH;
    }
    
    final boolean lz()
    {
      return this.asP != null;
    }
    
    final void resetInternal()
    {
      this.DU = 0;
      this.mPosition = -1;
      this.asF = -1;
      this.asG = -1L;
      this.asI = -1;
      this.asO = 0;
      this.asJ = null;
      this.asK = null;
      lH();
      this.asR = 0;
      this.asS = -1;
      RecyclerView.h(this);
    }
    
    final void setFlags(int paramInt1, int paramInt2)
    {
      this.DU = (this.DU & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.asG + ", oldPos=" + this.asF + ", pLpos:" + this.asI);
      String str;
      if (lz())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.asQ)
        {
          str = "[changeScrap]";
          localStringBuilder2.append(str);
        }
      }
      else
      {
        if (bj()) {
          localStringBuilder1.append(" invalid");
        }
        if (!isBound()) {
          localStringBuilder1.append(" unbound");
        }
        if (lE()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (lt()) {
          localStringBuilder1.append(" ignored");
        }
        if (lF()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!lJ()) {
          localStringBuilder1.append(" not recyclable(" + this.asO + ")");
        }
        if (((this.DU & 0x200) == 0) && (!bj())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.asD.getParent() == null) {
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