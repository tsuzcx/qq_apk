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
  private static final int[] arA;
  static final boolean arB;
  static final boolean arC;
  static final boolean arD;
  static final boolean arE;
  private static final boolean arF;
  private static final boolean arG;
  private static final Class<?>[] arH;
  private static final int[] arz = { 16843830 };
  static final Interpolator asV;
  private final int[] UA;
  final int[] UB;
  private final Rect YV = new Rect();
  a acW;
  private final q arI = new q();
  final o arJ = new o();
  private SavedState arK;
  d arL;
  s arM;
  final bg arN = new bg();
  boolean arO;
  final Runnable arP = new Runnable()
  {
    public final void run()
    {
      if ((!RecyclerView.this.arZ) || (RecyclerView.this.isLayoutRequested())) {
        return;
      }
      if (!RecyclerView.this.arW)
      {
        RecyclerView.this.requestLayout();
        return;
      }
      if (RecyclerView.this.asc)
      {
        RecyclerView.this.asb = true;
        return;
      }
      RecyclerView.this.kH();
    }
  };
  final RectF arQ = new RectF();
  i arR;
  p arS;
  public final ArrayList<h> arT = new ArrayList();
  private final ArrayList<l> arU = new ArrayList();
  private l arV;
  boolean arW;
  boolean arX;
  boolean arY;
  boolean arZ;
  private float asA = 1.4E-45F;
  private float asB = 1.4E-45F;
  private boolean asC = true;
  final v asD = new v();
  ac asE;
  ac.a asF;
  final t asG;
  private m asH;
  private List<m> asI;
  boolean asJ;
  boolean asK;
  private RecyclerView.f.b asL;
  boolean asM;
  al asN;
  private d asO;
  private final int[] asP;
  private l asQ;
  private final int[] asR;
  final int[] asS;
  final List<w> asT;
  private Runnable asU;
  private final bg.b asW;
  private int asa = 0;
  boolean asb;
  public boolean asc;
  private boolean asd;
  private int ase;
  boolean asf;
  private final AccessibilityManager asg;
  public List<j> ash;
  boolean asi = false;
  boolean asj = false;
  private int ask = 0;
  private int asl = 0;
  private e asm = new e();
  private EdgeEffect asn;
  private EdgeEffect aso;
  private EdgeEffect asp;
  private EdgeEffect asq;
  f asr = new v();
  private int ass = -1;
  private int ast;
  private int asu;
  private int asv;
  private int asw;
  private k asx;
  private final int asy;
  private final int asz;
  private int mScrollState = 0;
  final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    arA = new int[] { 16842987 };
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      arB = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label169;
      }
      bool = true;
      label62:
      arC = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label174;
      }
      bool = true;
      label76:
      arD = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label179;
      }
      bool = true;
      label90:
      arE = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label184;
      }
      bool = true;
      label104:
      arF = bool;
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
      arG = bool;
      arH = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      asV = new Interpolator()
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
    if (arE)
    {
      localObject1 = new ac.a();
      this.asF = ((ac.a)localObject1);
      this.asG = new t();
      this.asJ = false;
      this.asK = false;
      this.asL = new g();
      this.asM = false;
      this.asP = new int[2];
      this.UA = new int[2];
      this.UB = new int[2];
      this.asR = new int[2];
      this.asS = new int[2];
      this.asT = new ArrayList();
      this.asU = new Runnable()
      {
        public final void run()
        {
          if (RecyclerView.this.asr != null) {
            RecyclerView.this.asr.ju();
          }
          RecyclerView.this.asM = false;
        }
      };
      this.asW = new bg.b()
      {
        public final void a(RecyclerView.w paramAnonymousw, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView.this.arJ.u(paramAnonymousw);
          RecyclerView localRecyclerView = RecyclerView.this;
          localRecyclerView.f(paramAnonymousw);
          paramAnonymousw.ax(false);
          if (localRecyclerView.asr.d(paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.kX();
          }
        }
        
        public final void b(RecyclerView.w paramAnonymousw, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          paramAnonymousw.ax(false);
          if (localRecyclerView.asr.e(paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.kX();
          }
        }
        
        public final void c(RecyclerView.w paramAnonymousw, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          paramAnonymousw.ax(false);
          if (RecyclerView.this.asi) {
            if (RecyclerView.this.asr.a(paramAnonymousw, paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
              RecyclerView.this.kX();
            }
          }
          while (!RecyclerView.this.asr.f(paramAnonymousw, paramAnonymousc1, paramAnonymousc2)) {
            return;
          }
          RecyclerView.this.kX();
        }
        
        public final void j(RecyclerView.w paramAnonymousw)
        {
          RecyclerView.this.arR.a(paramAnonymousw.auu, RecyclerView.this.arJ);
        }
      };
      if (paramAttributeSet == null) {
        break label693;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, arA, paramInt, 0);
      this.arO = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label358:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.asA = u.a((ViewConfiguration)localObject1, paramContext);
      this.asB = u.b((ViewConfiguration)localObject1, paramContext);
      this.asy = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.asz = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
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
      this.asr.ata = this.asL;
      this.arL = new d(new d.a()
      {
        private void f(d.b paramAnonymousb)
        {
          switch (paramAnonymousb.EN)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            return;
          case 1: 
            RecyclerView.this.arR.c(RecyclerView.this, paramAnonymousb.ajM, paramAnonymousb.ajO);
            return;
          case 2: 
            RecyclerView.this.arR.d(RecyclerView.this, paramAnonymousb.ajM, paramAnonymousb.ajO);
            return;
          case 4: 
            RecyclerView.this.arR.a(RecyclerView.this, paramAnonymousb.ajM, paramAnonymousb.ajO, paramAnonymousb.ajN);
            return;
          }
          RecyclerView.this.arR.a(RecyclerView.this, paramAnonymousb.ajM, paramAnonymousb.ajO, 1);
        }
        
        public final void N(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, true);
          RecyclerView.this.asJ = true;
          RecyclerView.t localt = RecyclerView.this.asG;
          localt.auc += paramAnonymousInt2;
        }
        
        public final void O(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, false);
          RecyclerView.this.asJ = true;
        }
        
        public final void P(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          int j = localRecyclerView.arM.jr();
          int i = 0;
          while (i < j)
          {
            localObject = RecyclerView.bv(localRecyclerView.arM.bL(i));
            if ((localObject != null) && (!((RecyclerView.w)localObject).lL()) && (((RecyclerView.w)localObject).mPosition >= paramAnonymousInt1))
            {
              ((RecyclerView.w)localObject).k(paramAnonymousInt2, false);
              localRecyclerView.asG.auf = true;
            }
            i += 1;
          }
          Object localObject = localRecyclerView.arJ;
          j = ((RecyclerView.o)localObject).atJ.size();
          i = 0;
          while (i < j)
          {
            RecyclerView.w localw = (RecyclerView.w)((RecyclerView.o)localObject).atJ.get(i);
            if ((localw != null) && (localw.mPosition >= paramAnonymousInt1)) {
              localw.k(paramAnonymousInt2, true);
            }
            i += 1;
          }
          localRecyclerView.requestLayout();
          RecyclerView.this.asJ = true;
        }
        
        public final void Q(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int n = -1;
          RecyclerView localRecyclerView = RecyclerView.this;
          int i1 = localRecyclerView.arM.jr();
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
            localObject = RecyclerView.bv(localRecyclerView.arM.bL(m));
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
            localRecyclerView.asG.auf = true;
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
          Object localObject = localRecyclerView.arJ;
          label173:
          RecyclerView.w localw;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            i = n;
            n = ((RecyclerView.o)localObject).atJ.size();
            m = 0;
            if (m >= n) {
              break label268;
            }
            localw = (RecyclerView.w)((RecyclerView.o)localObject).atJ.get(m);
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
          RecyclerView.this.asJ = true;
        }
        
        public final RecyclerView.w bF(int paramAnonymousInt)
        {
          RecyclerView.w localw = RecyclerView.this.j(paramAnonymousInt, true);
          if (localw == null) {}
          while (RecyclerView.this.arM.bg(localw.auu)) {
            return null;
          }
          return localw;
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          Object localObject = RecyclerView.this;
          int j = ((RecyclerView)localObject).arM.jr();
          int i = 0;
          while (i < j)
          {
            View localView = ((RecyclerView)localObject).arM.bL(i);
            RecyclerView.w localw = RecyclerView.bv(localView);
            if ((localw != null) && (!localw.lL()) && (localw.mPosition >= paramAnonymousInt1) && (localw.mPosition < paramAnonymousInt1 + paramAnonymousInt2))
            {
              localw.addFlags(2);
              localw.O(paramAnonymousObject);
              ((RecyclerView.LayoutParams)localView.getLayoutParams()).atz = true;
            }
            i += 1;
          }
          paramAnonymousObject = ((RecyclerView)localObject).arJ;
          i = paramAnonymousObject.atJ.size() - 1;
          while (i >= 0)
          {
            localObject = (RecyclerView.w)paramAnonymousObject.atJ.get(i);
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
          RecyclerView.this.asK = true;
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
      this.arM = new s(new s.b()
      {
        public final void addView(View paramAnonymousView, int paramAnonymousInt)
        {
          RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
          RecyclerView localRecyclerView = RecyclerView.this;
          RecyclerView.w localw = RecyclerView.bv(paramAnonymousView);
          if ((localRecyclerView.acW != null) && (localw != null)) {
            localRecyclerView.acW.k(localw);
          }
          if (localRecyclerView.ash != null)
          {
            paramAnonymousInt = localRecyclerView.ash.size() - 1;
            while (paramAnonymousInt >= 0)
            {
              ((RecyclerView.j)localRecyclerView.ash.get(paramAnonymousInt)).bQ(paramAnonymousView);
              paramAnonymousInt -= 1;
            }
          }
        }
        
        public final void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
        {
          RecyclerView.w localw = RecyclerView.bv(paramAnonymousView);
          if (localw != null)
          {
            if ((!localw.lX()) && (!localw.lL())) {
              throw new IllegalArgumentException("Called attach on a child which is not detached: " + localw + RecyclerView.this.kF());
            }
            localw.lV();
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
            if (paramAnonymousView.auJ == -1) {
              break label38;
            }
          }
          label38:
          for (paramAnonymousView.auI = paramAnonymousView.auJ;; paramAnonymousView.auI = t.X(paramAnonymousView.auu))
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
            RecyclerView.this.b(paramAnonymousView, paramAnonymousView.auI);
            paramAnonymousView.auI = 0;
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
              if ((((RecyclerView.w)localObject).lX()) && (!((RecyclerView.w)localObject).lL())) {
                throw new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.kF());
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
      this.asg = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new al(this));
      if (paramAttributeSet == null) {
        break label1272;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(7);
      if (((TypedArray)localObject1).getInt(1, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.arY = ((TypedArray)localObject1).getBoolean(2, false);
      if (!this.arY) {
        break label757;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(5);
      localObject4 = ((TypedArray)localObject1).getDrawable(6);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(3);
      localDrawable = ((TypedArray)localObject1).getDrawable(4);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label707;
      }
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + kF());
      localObject1 = null;
      break;
      this.arO = true;
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
          localObject3 = ((Class)localObject4).getConstructor(arH);
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
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arz, paramInt, 0);
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
  
  private boolean A(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().A(paramInt1, paramInt2);
  }
  
  private void a(long paramLong, w paramw1, w paramw2)
  {
    int j = this.arM.getChildCount();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.arM.getChildAt(i));
      if ((localw != paramw1) && (g(localw) == paramLong))
      {
        if ((this.acW != null) && (this.acW.asZ)) {
          throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localw + " \n View Holder 2:" + paramw1 + kF());
        }
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localw + " \n View Holder 2:" + paramw1 + kF());
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramw2).append(" cannot be found but it is necessary for ").append(paramw1).append(kF());
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
      paramw1.auA = paramw2;
      f(paramw1);
      this.arJ.u(paramw1);
      paramw2.ax(false);
      paramw2.auB = paramw1;
    }
    if (this.asr.a(paramw1, paramw2, paramc1, paramc2)) {
      kX();
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    kH();
    int i;
    int j;
    int k;
    int m;
    if (this.acW != null)
    {
      b(paramInt1, paramInt2, this.asS);
      i = this.asS[0];
      j = this.asS[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.arT.isEmpty()) {
        invalidate();
      }
      if (a(i, j, k, m, this.UA, 0))
      {
        this.asv -= this.UA[0];
        this.asw -= this.UA[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.UA[0], this.UA[1]);
        }
        paramMotionEvent = this.asR;
        paramMotionEvent[0] += this.UA[0];
        paramMotionEvent = this.asR;
        paramMotionEvent[1] += this.UA[1];
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          ao(i, j);
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
          ak(paramInt1, paramInt2);
        }
      }
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
  }
  
  private boolean an(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    m(this.asP);
    if ((this.asP[0] != paramInt1) || (this.asP[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  static w bv(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).aty;
  }
  
  public static int bw(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lN();
    }
    return -1;
  }
  
  public static int bx(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lM();
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
    Rect localRect = localLayoutParams.apG;
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
        if (!((LayoutParams)localObject).atz)
        {
          localObject = ((LayoutParams)localObject).apG;
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
      localObject = this.arR;
      localRect = this.mTempRect;
      if (this.arZ) {
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
    if (this.acW.asZ) {
      return paramw.aux;
    }
    return paramw.mPosition;
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      kM();
      android.support.v4.widget.i.a(this.asn, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      kO();
      android.support.v4.widget.i.a(this.aso, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
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
      kN();
      android.support.v4.widget.i.a(this.asp, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        kP();
        android.support.v4.widget.i.a(this.asq, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  static void h(w paramw)
  {
    Object localObject;
    if (paramw.auv != null) {
      localObject = (View)paramw.auv.get();
    }
    while (localObject != null)
    {
      if (localObject == paramw.auu) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramw.auv = null;
  }
  
  private void i(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.ass) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.ass = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.asv = j;
      this.ast = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.asw = i;
      this.asu = i;
      return;
    }
  }
  
  private void kK()
  {
    this.asD.stop();
    if (this.arR != null) {
      this.arR.lz();
    }
  }
  
  private void kL()
  {
    boolean bool2 = false;
    if (this.asn != null)
    {
      this.asn.onRelease();
      bool2 = this.asn.isFinished();
    }
    boolean bool1 = bool2;
    if (this.aso != null)
    {
      this.aso.onRelease();
      bool1 = bool2 | this.aso.isFinished();
    }
    bool2 = bool1;
    if (this.asp != null)
    {
      this.asp.onRelease();
      bool2 = bool1 | this.asp.isFinished();
    }
    bool1 = bool2;
    if (this.asq != null)
    {
      this.asq.onRelease();
      bool1 = bool2 | this.asq.isFinished();
    }
    if (bool1) {
      t.W(this);
    }
  }
  
  private void kM()
  {
    if (this.asn != null) {
      return;
    }
    this.asn = e.e(this);
    if (this.arO)
    {
      this.asn.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.asn.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kN()
  {
    if (this.asp != null) {
      return;
    }
    this.asp = e.e(this);
    if (this.arO)
    {
      this.asp.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.asp.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kO()
  {
    if (this.aso != null) {
      return;
    }
    this.aso = e.e(this);
    if (this.arO)
    {
      this.aso.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.aso.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void kP()
  {
    if (this.asq != null) {
      return;
    }
    this.asq = e.e(this);
    if (this.arO)
    {
      this.asq.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.asq.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void kQ()
  {
    this.asq = null;
    this.aso = null;
    this.asp = null;
    this.asn = null;
  }
  
  private void kR()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    aM(0);
    kL();
  }
  
  private void kS()
  {
    kR();
    setScrollState(0);
  }
  
  private void kV()
  {
    int i = this.ase;
    this.ase = 0;
    if ((i != 0) && (kU()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      android.support.v4.view.a.a.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private boolean kY()
  {
    return (this.asr != null) && (this.arR.ka());
  }
  
  private void kZ()
  {
    boolean bool2 = true;
    if (this.asi)
    {
      this.arL.reset();
      if (this.asj) {
        this.arR.a(this);
      }
    }
    int i;
    label61:
    t localt;
    if (kY())
    {
      this.arL.iR();
      if ((!this.asJ) && (!this.asK)) {
        break label180;
      }
      i = 1;
      localt = this.asG;
      if ((!this.arZ) || (this.asr == null) || ((!this.asi) && (i == 0) && (!this.arR.atm)) || ((this.asi) && (!this.acW.asZ))) {
        break label185;
      }
      bool1 = true;
      label121:
      localt.auj = bool1;
      localt = this.asG;
      if ((!this.asG.auj) || (i == 0) || (this.asi) || (!kY())) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localt.auk = bool1;
      return;
      this.arL.iU();
      break;
      i = 0;
      break label61;
      bool1 = false;
      break label121;
    }
  }
  
  private void la()
  {
    if (this.acW == null) {}
    while (this.arR == null) {
      return;
    }
    this.asG.aui = false;
    if (this.asG.aud == 1)
    {
      le();
      this.arR.h(this);
      lf();
    }
    for (;;)
    {
      lg();
      return;
      if ((this.arL.iV()) || (this.arR.mWidth != getWidth()) || (this.arR.mHeight != getHeight()))
      {
        this.arR.h(this);
        lf();
      }
      else
      {
        this.arR.h(this);
      }
    }
  }
  
  private void lb()
  {
    if ((this.asC) && (hasFocus()) && (this.acW != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = bu((View)localObject1))
      {
        lc();
        return;
      }
      Object localObject2 = this.asG;
      long l;
      int i;
      if (this.acW.asZ)
      {
        l = ((w)localObject1).aux;
        ((t)localObject2).aum = l;
        localObject2 = this.asG;
        if (!this.asi) {
          break label191;
        }
        i = -1;
      }
      t localt;
      for (;;)
      {
        ((t)localObject2).aul = i;
        localt = this.asG;
        localObject1 = ((w)localObject1).auu;
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
          i = ((w)localObject1).auw;
        } else {
          i = ((w)localObject1).lN();
        }
      }
      localt.aun = i;
      return;
    }
  }
  
  private void lc()
  {
    this.asG.aum = -1L;
    this.asG.aul = -1;
    this.asG.aun = -1;
  }
  
  private void ld()
  {
    View localView = null;
    if ((!this.asC) || (this.acW == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject = getFocusedChild();
      if ((arG) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.arM.getChildCount() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.arM.bg((View)localObject));
    if ((this.asG.aum != -1L) && (this.acW.asZ)) {}
    for (Object localObject = m(this.asG.aum);; localObject = null)
    {
      int i;
      label216:
      int k;
      int j;
      if ((localObject == null) || (this.arM.bg(((w)localObject).auu)) || (!((w)localObject).auu.hasFocusable()))
      {
        localObject = localView;
        if (this.arM.getChildCount() > 0)
        {
          if (this.asG.aul != -1)
          {
            i = this.asG.aul;
            k = this.asG.getItemCount();
            j = i;
            label226:
            if (j >= k) {
              break label331;
            }
            localObject = ci(j);
            if (localObject == null) {
              break label331;
            }
            if (!((w)localObject).auu.hasFocusable()) {
              break label324;
            }
            localObject = ((w)localObject).auu;
          }
        }
        else
        {
          label261:
          if (localObject == null) {
            break label397;
          }
          if (this.asG.aun == -1L) {
            break label399;
          }
          localView = ((View)localObject).findViewById(this.asG.aun);
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
          if (((w)localObject).auu.hasFocusable())
          {
            localObject = ((w)localObject).auu;
            break;
          }
          i -= 1;
        }
        label383:
        localObject = null;
        break label261;
        localObject = ((w)localObject).auu;
        break label261;
        break;
      }
    }
  }
  
  private void le()
  {
    this.asG.cA(1);
    m(this.asG);
    this.asG.aui = false;
    kI();
    this.arN.clear();
    kT();
    kZ();
    lb();
    Object localObject = this.asG;
    if ((this.asG.auj) && (this.asK)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((t)localObject).auh = bool;
      this.asK = false;
      this.asJ = false;
      this.asG.aug = this.asG.auk;
      this.asG.aue = this.acW.getItemCount();
      m(this.asP);
      if (!this.asG.auj) {
        break;
      }
      j = this.arM.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bv(this.arM.getChildAt(i));
        if ((!((w)localObject).lL()) && ((!((w)localObject).isInvalid()) || (this.acW.asZ)))
        {
          localc = this.asr.a(this.asG, (w)localObject, f.m((w)localObject), ((w)localObject).ma());
          this.arN.b((w)localObject, localc);
          if ((this.asG.auh) && (((w)localObject).md()) && (!((w)localObject).isRemoved()) && (!((w)localObject).lL()) && (!((w)localObject).isInvalid()))
          {
            long l = g((w)localObject);
            this.arN.a(l, (w)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.asG.auk)
    {
      li();
      bool = this.asG.auf;
      this.asG.auf = false;
      this.arR.c(this.arJ, this.asG);
      this.asG.auf = bool;
      i = 0;
      if (i < this.arM.getChildCount())
      {
        localObject = bv(this.arM.getChildAt(i));
        if ((!((w)localObject).lL()) && (!this.arN.F((w)localObject)))
        {
          int k = f.m((w)localObject);
          bool = ((w)localObject).cB(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.asr.a(this.asG, (w)localObject, j, ((w)localObject).ma());
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
          this.arN.c((w)localObject, localc);
        }
      }
      lj();
    }
    for (;;)
    {
      at(true);
      as(false);
      this.asG.aud = 2;
      return;
      lj();
    }
  }
  
  private void lf()
  {
    kI();
    kT();
    this.asG.cA(6);
    this.arL.iU();
    this.asG.aue = this.acW.getItemCount();
    this.asG.auc = 0;
    this.asG.aug = false;
    this.arR.c(this.arJ, this.asG);
    this.asG.auf = false;
    this.arK = null;
    t localt = this.asG;
    if ((this.asG.auj) && (this.asr != null)) {}
    for (boolean bool = true;; bool = false)
    {
      localt.auj = bool;
      this.asG.aud = 4;
      at(true);
      as(false);
      return;
    }
  }
  
  private void lg()
  {
    this.asG.cA(4);
    kI();
    kT();
    this.asG.aud = 1;
    if (this.asG.auj)
    {
      int i = this.arM.getChildCount() - 1;
      if (i >= 0)
      {
        w localw1 = bv(this.arM.getChildAt(i));
        RecyclerView.f.c localc2;
        w localw2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localw1.lL())
        {
          long l = g(localw1);
          localc2 = new RecyclerView.f.c().c(localw1, 0);
          localw2 = this.arN.n(l);
          if ((localw2 == null) || (localw2.lL())) {
            break label224;
          }
          bool1 = this.arN.E(localw2);
          bool2 = this.arN.E(localw1);
          if ((bool1) && (localw2 == localw1)) {
            break label224;
          }
          localc1 = this.arN.d(localw2, 4);
          this.arN.d(localw1, localc2);
          localc2 = this.arN.d(localw1, 8);
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
          this.arN.d(localw1, localc2);
        }
      }
      this.arN.a(this.asW);
    }
    this.arR.c(this.arJ);
    this.asG.aub = this.asG.aue;
    this.asi = false;
    this.asj = false;
    this.asG.auj = false;
    this.asG.auk = false;
    this.arR.atm = false;
    if (this.arJ.atI != null) {
      this.arJ.atI.clear();
    }
    if (this.arR.atr)
    {
      this.arR.atq = 0;
      this.arR.atr = false;
      this.arJ.lF();
    }
    this.arR.a(this.asG);
    at(true);
    as(false);
    this.arN.clear();
    if (an(this.asP[0], this.asP[1])) {
      ao(0, 0);
    }
    ld();
    lc();
  }
  
  private void li()
  {
    int j = this.arM.jr();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.arM.bL(i));
      if (!localw.lL()) {
        localw.lK();
      }
      i += 1;
    }
  }
  
  private void lj()
  {
    int j = this.arM.jr();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.arM.bL(i));
      if (!localw.lL()) {
        localw.lJ();
      }
      i += 1;
    }
    this.arJ.lj();
  }
  
  private void lk()
  {
    int j = this.arM.jr();
    int i = 0;
    while (i < j)
    {
      w localw = bv(this.arM.bL(i));
      if ((localw != null) && (!localw.lL())) {
        localw.addFlags(6);
      }
      i += 1;
    }
    lh();
    this.arJ.lk();
  }
  
  private void ln()
  {
    int i = this.asT.size() - 1;
    while (i >= 0)
    {
      w localw = (w)this.asT.get(i);
      if ((localw.auu.getParent() == this) && (!localw.lL()))
      {
        int j = localw.auJ;
        if (j != -1)
        {
          t.p(localw.auu, j);
          localw.auJ = -1;
        }
      }
      i -= 1;
    }
    this.asT.clear();
  }
  
  private void m(t paramt)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.asD.Ur;
      paramt.auo = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramt.aup = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramt.auo = 0;
    paramt.aup = 0;
  }
  
  private void m(int[] paramArrayOfInt)
  {
    int i2 = this.arM.getChildCount();
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
      w localw = bv(this.arM.getChildAt(n));
      m = i;
      if (localw.lL()) {
        break label122;
      }
      int i1 = localw.lM();
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
  
  final void F(String paramString)
  {
    if (kW())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + kF());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.asl > 0) {
      new IllegalStateException(kF());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    if (this.arR == null) {}
    for (;;)
    {
      return;
      if (!this.asc)
      {
        if (!this.arR.kc()) {
          paramInt1 = 0;
        }
        if (!this.arR.kd()) {
          paramInt2 = i;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          v localv = this.asD;
          i = localv.aF(paramInt1, paramInt2);
          Interpolator localInterpolator = paramInterpolator;
          if (paramInterpolator == null) {
            localInterpolator = asV;
          }
          localv.b(paramInt1, paramInt2, i, localInterpolator);
          return;
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    if (this.arR != null) {
      this.arR.F("Cannot add item decoration during a scroll  or layout");
    }
    if (this.arT.isEmpty()) {
      setWillNotDraw(false);
    }
    this.arT.add(paramh);
    lh();
    requestLayout();
  }
  
  public final void a(j paramj)
  {
    if (this.ash == null) {
      this.ash = new ArrayList();
    }
    this.ash.add(paramj);
  }
  
  public final void a(l paraml)
  {
    this.arU.add(paraml);
  }
  
  public final void a(m paramm)
  {
    if (this.asI == null) {
      this.asI = new ArrayList();
    }
    this.asI.add(paramm);
  }
  
  final void a(w paramw, RecyclerView.f.c paramc)
  {
    paramw.setFlags(0, 8192);
    if ((this.asG.auh) && (paramw.md()) && (!paramw.isRemoved()) && (!paramw.lL()))
    {
      long l = g(paramw);
      this.arN.a(l, paramw);
    }
    this.arN.b(paramw, paramc);
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
    if ((this.arR == null) || (!this.arR.a(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean aj(int paramInt1, int paramInt2)
  {
    if (this.arR == null) {}
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
        } while (this.asc);
        bool2 = this.arR.kc();
        bool3 = this.arR.kd();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.asy) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.asy) {}
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
        if ((this.asx == null) || (!this.asx.aB(i, j))) {
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
      A(paramInt2, 1);
      paramInt1 = Math.max(-this.asz, Math.min(i, this.asz));
      paramInt2 = Math.max(-this.asz, Math.min(j, this.asz));
      v localv = this.asD;
      localv.asX.setScrollState(2);
      localv.aur = 0;
      localv.auq = 0;
      localv.Ur.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localv.lI();
      return true;
    }
  }
  
  final void ak(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.asn != null)
    {
      bool1 = bool2;
      if (!this.asn.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.asn.onRelease();
          bool1 = this.asn.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.asp != null)
    {
      bool2 = bool1;
      if (!this.asp.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.asp.onRelease();
          bool2 = bool1 | this.asp.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.aso != null)
    {
      bool1 = bool2;
      if (!this.aso.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.aso.onRelease();
          bool1 = bool2 | this.aso.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.asq != null)
    {
      bool2 = bool1;
      if (!this.asq.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.asq.onRelease();
          bool2 = bool1 | this.asq.isFinished();
        }
      }
    }
    if (bool2) {
      t.W(this);
    }
  }
  
  final void al(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      kM();
      this.asn.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      kO();
      this.aso.onAbsorb(-paramInt2);
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
      kN();
      this.asp.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        kP();
        this.asq.onAbsorb(paramInt2);
      }
    }
  }
  
  final void am(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(i.m(paramInt1, getPaddingLeft() + getPaddingRight(), t.ae(this)), i.m(paramInt2, getPaddingTop() + getPaddingBottom(), t.af(this)));
  }
  
  final void ao(int paramInt1, int paramInt2)
  {
    this.asl += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.asH != null) {
      this.asH.a(this, paramInt1, paramInt2);
    }
    if (this.asI != null)
    {
      i = this.asI.size() - 1;
      while (i >= 0)
      {
        ((m)this.asI.get(i)).a(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.asl -= 1;
  }
  
  final void as(boolean paramBoolean)
  {
    if (this.asa <= 0) {
      this.asa = 1;
    }
    if ((!paramBoolean) && (!this.asc)) {
      this.asb = false;
    }
    if (this.asa == 1)
    {
      if ((paramBoolean) && (this.asb) && (!this.asc) && (this.arR != null) && (this.acW != null)) {
        la();
      }
      if (!this.asc) {
        this.asb = false;
      }
    }
    this.asa -= 1;
  }
  
  final void at(boolean paramBoolean)
  {
    this.ask -= 1;
    if (this.ask <= 0)
    {
      this.ask = 0;
      if (paramBoolean)
      {
        kV();
        ln();
      }
    }
  }
  
  final void au(boolean paramBoolean)
  {
    this.asj |= paramBoolean;
    this.asi = true;
    lk();
  }
  
  final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    kI();
    kT();
    e.beginSection("RV Scroll");
    m(this.asG);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.arR.a(paramInt1, this.arJ, this.asG);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.arR.b(paramInt2, this.arJ, this.asG);; paramInt2 = 0)
      {
        e.endSection();
        int j = this.arM.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.arM.getChildAt(i);
          Object localObject = bh(localView);
          if ((localObject != null) && (((w)localObject).auB != null))
          {
            localObject = ((w)localObject).auB.auu;
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
    this.arU.remove(paraml);
    if (this.arV == paraml) {
      this.arV = null;
    }
  }
  
  public final void b(m paramm)
  {
    if (this.asI != null) {
      this.asI.remove(paramm);
    }
  }
  
  final boolean b(w paramw, int paramInt)
  {
    if (kW())
    {
      paramw.auJ = paramInt;
      this.asT.add(paramw);
      return false;
    }
    t.p(paramw.auu, paramInt);
    return true;
  }
  
  final void bA(View paramView)
  {
    w localw = bv(paramView);
    if ((this.acW != null) && (localw != null)) {
      this.acW.l(localw);
    }
    if (this.ash != null)
    {
      int i = this.ash.size() - 1;
      while (i >= 0)
      {
        ((j)this.ash.get(i)).bR(paramView);
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
    if (!localLayoutParams.atz) {
      return localLayoutParams.apG;
    }
    if ((this.asG.aug) && ((localLayoutParams.aty.md()) || (localLayoutParams.aty.isInvalid()))) {
      return localLayoutParams.apG;
    }
    Rect localRect = localLayoutParams.apG;
    localRect.set(0, 0, 0, 0);
    int j = this.arT.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((h)this.arT.get(i)).a(this.mTempRect, paramView, this, this.asG);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.atz = false;
    return localRect;
  }
  
  public final void c(h paramh)
  {
    if (this.arR != null) {
      this.arR.F("Cannot remove item decoration during a scroll  or layout");
    }
    this.arT.remove(paramh);
    if (this.arT.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      lh();
      requestLayout();
      return;
    }
  }
  
  public void ca(int paramInt)
  {
    if (this.asc) {}
    do
    {
      return;
      kJ();
    } while (this.arR == null);
    i locali = this.arR;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahE(), "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  final void cg(int paramInt)
  {
    if (this.arR == null) {
      return;
    }
    i locali = this.arR;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahE(), "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  public final w ch(int paramInt)
  {
    return j(paramInt, false);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.arR.a((LayoutParams)paramLayoutParams));
  }
  
  public final w ci(int paramInt)
  {
    Object localObject = null;
    if (this.asi) {}
    int i;
    w localw;
    do
    {
      return localObject;
      int j = this.arM.jr();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localw = bv(this.arM.bL(i));
      if ((localw == null) || (localw.isRemoved()) || (i(localw) != paramInt)) {
        break label100;
      }
      localObject = localw;
    } while (!this.arM.bg(localw.auu));
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
    if (this.arR == null) {}
    while (!this.arR.kc()) {
      return 0;
    }
    return this.arR.f(this.asG);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.arR == null) {}
    while (!this.arR.kc()) {
      return 0;
    }
    return this.arR.d(this.asG);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.arR == null) {}
    while (!this.arR.kc()) {
      return 0;
    }
    return this.arR.h(this.asG);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.arR == null) {}
    while (!this.arR.kd()) {
      return 0;
    }
    return this.arR.g(this.asG);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.arR == null) {}
    while (!this.arR.kd()) {
      return 0;
    }
    return this.arR.e(this.asG);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.arR == null) {}
    while (!this.arR.kd()) {
      return 0;
    }
    return this.arR.i(this.asG);
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
    int j = this.arT.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.arT.get(i)).b(paramCanvas, this, this.asG);
      i += 1;
    }
    int n;
    if ((this.asn != null) && (!this.asn.isFinished()))
    {
      n = paramCanvas.save();
      if (this.arO)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.asn == null) || (!this.asn.draw(paramCanvas))) {
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
      if (this.aso != null)
      {
        i = j;
        if (!this.aso.isFinished())
        {
          n = paramCanvas.save();
          if (this.arO) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.aso == null) || (!this.aso.draw(paramCanvas))) {
            break label461;
          }
          i = 1;
          label202:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.asp != null)
      {
        j = i;
        if (!this.asp.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.arO) {
            break label466;
          }
          j = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.asp == null) || (!this.asp.draw(paramCanvas))) {
            break label471;
          }
          j = 1;
          label295:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.asq != null)
      {
        i = j;
        if (!this.asq.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.arO) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i = m;
          if (this.asq != null)
          {
            i = m;
            if (this.asq.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.asr != null) && (this.arT.size() > 0) && (this.asr.isRunning())) {
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
    int j = this.arM.jr();
    int i = 0;
    if (i < j)
    {
      localObject = bv(this.arM.bL(i));
      if ((localObject != null) && (!((w)localObject).lL()))
      {
        if (((w)localObject).mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((w)localObject).k(-paramInt2, paramBoolean);
        this.asG.auf = true;
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
          this.asG.auf = true;
        }
      }
    }
    Object localObject = this.arJ;
    i = ((o)localObject).atJ.size() - 1;
    if (i >= 0)
    {
      w localw = (w)((o)localObject).atJ.get(i);
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
    View localView = paramw.auu;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.arJ.u(bh(localView));
      if (!paramw.lX()) {
        break;
      }
      this.arM.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.arM.a(localView, -1, true);
      return;
    }
    paramw = this.arM;
    i = paramw.alK.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
    }
    paramw.alL.set(i);
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
    if ((this.acW != null) && (this.arR != null) && (!kW()) && (!this.asc))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label327;
      }
      if (!this.arR.kd()) {
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
      if (arF) {
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
        if (this.arR.kc())
        {
          if (t.Y(this.arR.anl) != 1) {
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
        if (arF)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label288;
        }
        kH();
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
      kI();
      this.arR.a(paramView, k, this.arJ, this.asG);
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
              kH();
              if (bt(paramView) == null) {
                return null;
              }
              kI();
              localObject = this.arR.a(paramView, paramInt, this.arJ, this.asG);
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
              this.YV.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.YV);
              if (t.Y(this.arR.anl) == 1)
              {
                m = -1;
                if (((this.mTempRect.left >= this.YV.left) && (this.mTempRect.right > this.YV.left)) || (this.mTempRect.right >= this.YV.right)) {
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
        if (((this.mTempRect.top < this.YV.top) || (this.mTempRect.bottom <= this.YV.top)) && (this.mTempRect.bottom < this.YV.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + k + kF());
            m = 1;
            break label547;
            label755:
            if (((this.mTempRect.right <= this.YV.right) && (this.mTempRect.left < this.YV.right)) || (this.mTempRect.left <= this.YV.left)) {
              break label986;
            }
            i = -1;
            break label600;
            if ((this.mTempRect.bottom > this.YV.bottom) || (this.mTempRect.top >= this.YV.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.YV.top) {}
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
    if (this.arR == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kF());
    }
    return this.arR.jW();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.arR == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kF());
    }
    return this.arR.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.arR == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kF());
    }
    return this.arR.d(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.acW;
  }
  
  public int getBaseline()
  {
    if (this.arR != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.asO == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.asO.aw(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.arO;
  }
  
  public al getCompatAccessibilityDelegate()
  {
    return this.asN;
  }
  
  public e getEdgeEffectFactory()
  {
    return this.asm;
  }
  
  public f getItemAnimator()
  {
    return this.asr;
  }
  
  public int getItemDecorationCount()
  {
    return this.arT.size();
  }
  
  public i getLayoutManager()
  {
    return this.arR;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.asz;
  }
  
  public int getMinFlingVelocity()
  {
    return this.asy;
  }
  
  long getNanoTime()
  {
    if (arE) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public k getOnFlingListener()
  {
    return this.asx;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.asC;
  }
  
  public n getRecycledViewPool()
  {
    return this.arJ.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  l getScrollingChildHelper()
  {
    if (this.asQ == null) {
      this.asQ = new l(this);
    }
    return this.asQ;
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
    return this.arL.bE(paramw.mPosition);
  }
  
  public boolean isAttachedToWindow()
  {
    return this.arW;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().PM;
  }
  
  public final w j(int paramInt, boolean paramBoolean)
  {
    int j = this.arM.jr();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      w localw = bv(this.arM.bL(i));
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
        if (localw.lM() == paramInt)
        {
          label95:
          localObject1 = localw;
          if (!this.arM.bg(localw.auu)) {
            break label121;
          }
          localObject2 = localw;
        }
      }
    }
    label121:
    return localObject1;
  }
  
  final String kF()
  {
    return " " + super.toString() + ", adapter:" + this.acW + ", layout:" + this.arR + ", context:" + getContext();
  }
  
  final void kG()
  {
    if (this.asr != null) {
      this.asr.jw();
    }
    if (this.arR != null)
    {
      this.arR.d(this.arJ);
      this.arR.c(this.arJ);
    }
    this.arJ.clear();
  }
  
  final void kH()
  {
    int k = 0;
    if ((!this.arZ) || (this.asi))
    {
      e.beginSection("RV FullInvalidate");
      la();
      e.endSection();
    }
    label168:
    label175:
    do
    {
      do
      {
        return;
      } while (!this.arL.iT());
      if ((this.arL.bC(4)) && (!this.arL.bC(11)))
      {
        e.beginSection("RV PartialInvalidate");
        kI();
        kT();
        this.arL.iR();
        int i;
        if (!this.asb)
        {
          int m = this.arM.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            w localw = bv(this.arM.getChildAt(i));
            if ((localw == null) || (localw.lL()) || (!localw.md())) {
              break label168;
            }
            j = 1;
          }
          if (j == 0) {
            break label175;
          }
          la();
        }
        for (;;)
        {
          as(true);
          at(true);
          e.endSection();
          return;
          i += 1;
          break;
          this.arL.iS();
        }
      }
    } while (!this.arL.iT());
    e.beginSection("RV FullInvalidate");
    la();
    e.endSection();
  }
  
  final void kI()
  {
    this.asa += 1;
    if ((this.asa == 1) && (!this.asc)) {
      this.asb = false;
    }
  }
  
  public void kJ()
  {
    setScrollState(0);
    kK();
  }
  
  final void kT()
  {
    this.ask += 1;
  }
  
  final boolean kU()
  {
    return (this.asg != null) && (this.asg.isEnabled());
  }
  
  public final boolean kW()
  {
    return this.ask > 0;
  }
  
  final void kX()
  {
    if ((!this.asM) && (this.arW))
    {
      t.b(this, this.asU);
      this.asM = true;
    }
  }
  
  public void lh()
  {
    int j = 0;
    int k = this.arM.jr();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.arM.bL(i).getLayoutParams()).atz = true;
      i += 1;
    }
    o localo = this.arJ;
    k = localo.atJ.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((w)localo.atJ.get(i)).auu.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.atz = true;
      }
      i += 1;
    }
  }
  
  public final void ll()
  {
    if (this.arT.size() == 0) {
      return;
    }
    if (this.arR != null) {
      this.arR.F("Cannot invalidate item decorations during a scroll or layout");
    }
    lh();
    requestLayout();
  }
  
  public final boolean lm()
  {
    return (!this.arZ) || (this.asi) || (this.arL.iT());
  }
  
  public final w m(long paramLong)
  {
    w localw2 = null;
    w localw1 = localw2;
    if (this.acW != null)
    {
      if (this.acW.asZ) {
        break label31;
      }
      localw1 = localw2;
    }
    label31:
    int i;
    do
    {
      return localw1;
      int j = this.arM.jr();
      i = 0;
      localw1 = null;
      if (i >= j) {
        break;
      }
      localw2 = bv(this.arM.bL(i));
      if ((localw2 == null) || (localw2.isRemoved()) || (localw2.aux != paramLong)) {
        break label120;
      }
      localw1 = localw2;
    } while (!this.arM.bg(localw2.auu));
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
    int i = this.arM.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.arM.getChildAt(i);
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
    this.ask = 0;
    this.arW = true;
    float f;
    if ((this.arZ) && (!isLayoutRequested()))
    {
      this.arZ = bool;
      if (this.arR != null) {
        this.arR.f(this);
      }
      this.asM = false;
      if (arE)
      {
        this.asE = ((ac)ac.anE.get());
        if (this.asE == null)
        {
          this.asE = new ac();
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
      this.asE.anH = ((1.0E+009F / f));
      ac.anE.set(this.asE);
      this.asE.anF.add(this);
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
    if (this.asr != null) {
      this.asr.jw();
    }
    kJ();
    this.arW = false;
    if (this.arR != null) {
      this.arR.b(this, this.arJ);
    }
    this.asT.clear();
    removeCallbacks(this.asU);
    bg.a.nl();
    if ((arE) && (this.asE != null))
    {
      this.asE.anF.remove(this);
      this.asE = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.arT.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.arT.get(i)).a(paramCanvas, this, this.asG);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.arR == null) {}
    label188:
    for (;;)
    {
      return false;
      if ((!this.asc) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f3;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.arR.kd())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.arR.kc()) {
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
          a((int)(this.asA * f1), (int)(this.asB * f2), paramMotionEvent);
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
            if (this.arR.kd())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.arR.kc())
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
    if (this.asc) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.arV = null;
    }
    int k = this.arU.size();
    int i = 0;
    if (i < k)
    {
      l locall = (l)this.arU.get(i);
      if ((locall.a(this, paramMotionEvent)) && (j != 3)) {
        this.arV = locall;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label105;
      }
      kS();
      return true;
      i += 1;
      break;
    }
    label105:
    if (this.arR == null) {
      return false;
    }
    boolean bool1 = this.arR.kc();
    boolean bool2 = this.arR.kd();
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
      if (this.asd) {
        this.asd = false;
      }
      this.ass = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.asv = i;
      this.ast = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.asw = i;
      this.asu = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.asR;
      this.asR[1] = 0;
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
      A(j, 0);
      break;
      this.ass = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.asv = j;
      this.ast = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.asw = i;
      this.asu = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.ass);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.ass).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.ast;
      int m = this.asu;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.asv = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.asw = k;
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
        kS();
        break;
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e.beginSection("RV OnLayout");
    la();
    e.endSection();
    this.arZ = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.arR == null) {
      am(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.arR.kb()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.arR.aA(paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.acW == null));
      if (this.asG.aud == 1) {
        le();
      }
      this.arR.ax(paramInt1, paramInt2);
      this.asG.aui = true;
      lf();
      this.arR.ay(paramInt1, paramInt2);
    } while (!this.arR.kh());
    this.arR.ax(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.asG.aui = true;
    lf();
    this.arR.ay(paramInt1, paramInt2);
    return;
    if (this.arX)
    {
      this.arR.aA(paramInt1, paramInt2);
      return;
    }
    if (this.asf)
    {
      kI();
      kT();
      kZ();
      at(true);
      if (this.asG.auk)
      {
        this.asG.aug = true;
        this.asf = false;
        as(false);
        label256:
        if (this.acW == null) {
          break label345;
        }
      }
    }
    label345:
    for (this.asG.aue = this.acW.getItemCount();; this.asG.aue = 0)
    {
      kI();
      this.arR.aA(paramInt1, paramInt2);
      as(false);
      this.asG.aug = false;
      return;
      this.arL.iU();
      this.asG.aug = false;
      break;
      if (!this.asG.auk) {
        break label256;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (kW()) {
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
      this.arK = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.arK.Pa);
    } while ((this.arR == null) || (this.arK.atP == null));
    this.arR.onRestoreInstanceState(this.arK.atP);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.arK != null)
    {
      localSavedState.atP = this.arK.atP;
      return localSavedState;
    }
    if (this.arR != null)
    {
      localSavedState.atP = this.arR.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.atP = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      kQ();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.asc) || (this.asd)) {}
    label146:
    label155:
    label161:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.arV != null)
      {
        if (i == 0) {
          this.arV = null;
        }
      }
      else
      {
        if (i == 0) {
          break label155;
        }
        j = this.arU.size();
        i = 0;
        if (i >= j) {
          break label155;
        }
        localObject = (l)this.arU.get(i);
        if (!((l)localObject).a(this, paramMotionEvent)) {
          break label146;
        }
        this.arV = ((l)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label161;
        }
        kS();
        return true;
        this.arV.b(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.arV = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.arR == null);
    boolean bool1 = this.arR.kc();
    boolean bool2 = this.arR.kd();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.asR;
      this.asR[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.asR[0], this.asR[1]);
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
      this.ass = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.asv = i;
      this.ast = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.asw = i;
      this.asu = i;
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
      A(j, 0);
      i = i2;
      break;
      this.ass = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.asv = i;
      this.ast = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.asw = i;
      this.asu = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.ass);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.ass).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.asv - i3;
      k = this.asw - i4;
      j = m;
      i = k;
      if (a(m, k, this.UB, this.UA, 0))
      {
        j = m - this.UB[0];
        i = k - this.UB[1];
        ((MotionEvent)localObject).offsetLocation(this.UA[0], this.UA[1]);
        paramMotionEvent = this.asR;
        paramMotionEvent[0] += this.UA[0];
        paramMotionEvent = this.asR;
        paramMotionEvent[1] += this.UA[1];
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
        this.asv = (i3 - this.UA[0]);
        this.asw = (i4 - this.UA[1]);
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
          if (this.asE == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.asE.b(this, k, m);
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
        this.mVelocityTracker.computeCurrentVelocity(1000, this.asz);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.ass);
          if (!bool2) {
            break label1087;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.ass);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!aj((int)f1, (int)f2))) {
            setScrollState(0);
          }
          kR();
          i = 1;
          break;
          f1 = 0.0F;
          break label1026;
        }
        kS();
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
      if (!localw.lX()) {
        break label36;
      }
      localw.lV();
    }
    label36:
    while (localw.lL())
    {
      paramView.clearAnimation();
      bA(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localw + kF());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((this.arR.lx()) || (kW())) {}
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
    return this.arR.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.arU.size();
    int i = 0;
    while (i < j)
    {
      ((l)this.arU.get(i)).ai(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.asa == 0) && (!this.asc))
    {
      super.requestLayout();
      return;
    }
    this.asb = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.arR == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.asc);
      bool1 = this.arR.kc();
      bool2 = this.arR.kd();
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
    if (kW())
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
        this.ase |= i;
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
    this.asN = paramal;
    t.a(this, this.asN);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    if (this.acW != null)
    {
      this.acW.b(this.arI);
      this.acW.d(this);
    }
    kG();
    this.arL.reset();
    a locala = this.acW;
    this.acW = parama;
    if (parama != null)
    {
      parama.a(this.arI);
      parama.c(this);
    }
    if (this.arR != null) {
      this.arR.ly();
    }
    Object localObject = this.arJ;
    parama = this.acW;
    ((o)localObject).clear();
    localObject = ((o)localObject).getRecycledViewPool();
    if (locala != null) {
      ((n)localObject).detach();
    }
    if (((n)localObject).atC == 0)
    {
      int i = 0;
      while (i < ((n)localObject).atB.size())
      {
        ((RecyclerView.n.a)((n)localObject).atB.valueAt(i)).atD.clear();
        i += 1;
      }
    }
    if (parama != null) {
      ((n)localObject).lE();
    }
    this.asG.auf = true;
    au(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.asO) {
      return;
    }
    this.asO = paramd;
    if (this.asO != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.arO) {
      kQ();
    }
    this.arO = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.arZ) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(e parame)
  {
    m.checkNotNull(parame);
    this.asm = parame;
    kQ();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.arX = paramBoolean;
  }
  
  public void setItemAnimator(f paramf)
  {
    if (this.asr != null)
    {
      this.asr.jw();
      this.asr.ata = null;
    }
    this.asr = paramf;
    if (this.asr != null) {
      this.asr.ata = this.asL;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    o localo = this.arJ;
    localo.atL = paramInt;
    localo.lF();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.asc)
    {
      F("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.asc = false;
        if ((this.asb) && (this.arR != null) && (this.acW != null)) {
          requestLayout();
        }
        this.asb = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.asc = true;
    this.asd = true;
    kJ();
  }
  
  public void setLayoutManager(i parami)
  {
    if (parami == this.arR) {
      return;
    }
    kJ();
    if (this.arR != null)
    {
      if (this.asr != null) {
        this.asr.jw();
      }
      this.arR.d(this.arJ);
      this.arR.c(this.arJ);
      this.arJ.clear();
      if (this.arW) {
        this.arR.b(this, this.arJ);
      }
      this.arR.setRecyclerView(null);
      this.arR = null;
    }
    s locals;
    for (;;)
    {
      locals = this.arM;
      for (s.a locala = locals.alL;; locala = locala.alO)
      {
        locala.alN = 0L;
        if (locala.alO == null) {
          break;
        }
      }
      this.arJ.clear();
    }
    int i = locals.alM.size() - 1;
    while (i >= 0)
    {
      locals.alK.bj((View)locals.alM.get(i));
      locals.alM.remove(i);
      i -= 1;
    }
    locals.alK.removeAllViews();
    this.arR = parami;
    if (parami != null)
    {
      if (parami.anl != null) {
        throw new IllegalArgumentException("LayoutManager " + parami + " is already attached to a RecyclerView:" + parami.anl.kF());
      }
      this.arR.setRecyclerView(this);
      if (this.arW) {
        this.arR.f(this);
      }
    }
    this.arJ.lF();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(k paramk)
  {
    this.asx = paramk;
  }
  
  @Deprecated
  public void setOnScrollListener(m paramm)
  {
    this.asH = paramm;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.asC = paramBoolean;
  }
  
  public void setRecycledViewPool(n paramn)
  {
    o localo = this.arJ;
    if (localo.atN != null) {
      localo.atN.detach();
    }
    localo.atN = paramn;
    if ((localo.atN != null) && (localo.asX.getAdapter() != null)) {
      localo.atN.lE();
    }
  }
  
  public void setRecyclerListener(p paramp)
  {
    this.arS = paramp;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if (paramInt != 2) {
        kK();
      }
      if (this.arR != null) {
        this.arR.cp(paramInt);
      }
      if (this.asH != null) {
        this.asH.b(this, paramInt);
      }
      if (this.asI != null)
      {
        int i = this.asI.size() - 1;
        while (i >= 0)
        {
          ((m)this.asI.get(i)).b(this, paramInt);
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
    this.arJ.atO = paramu;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.asc) {}
    while (this.arR == null) {
      return;
    }
    this.arR.a(this, this.asG, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().A(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().aM(0);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect apG = new Rect();
    boolean atA = false;
    public RecyclerView.w aty;
    boolean atz = true;
    
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
    
    public final int lD()
    {
      return this.aty.lN();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Parcelable atP;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader != null) {}
      for (;;)
      {
        this.atP = paramParcel.readParcelable(paramClassLoader);
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
      paramParcel.writeParcelable(this.atP, 0);
    }
  }
  
  public static abstract class a<VH extends RecyclerView.w>
  {
    public final RecyclerView.b asY = new RecyclerView.b();
    protected boolean asZ = false;
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public void a(RecyclerView.c paramc)
    {
      this.asY.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public final void ap(int paramInt1, int paramInt2)
    {
      this.asY.ap(paramInt1, paramInt2);
    }
    
    public final void aq(int paramInt1, int paramInt2)
    {
      this.asY.aq(paramInt1, paramInt2);
    }
    
    public final void ar(int paramInt1, int paramInt2)
    {
      this.asY.ar(paramInt1, paramInt2);
    }
    
    public final void as(int paramInt1, int paramInt2)
    {
      this.asY.as(paramInt1, paramInt2);
    }
    
    public void av(boolean paramBoolean)
    {
      if (this.asY.hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.asZ = paramBoolean;
    }
    
    public final void b(int paramInt, Object paramObject)
    {
      this.asY.e(paramInt, 1, paramObject);
    }
    
    public void b(RecyclerView.c paramc)
    {
      this.asY.unregisterObserver(paramc);
    }
    
    public void c(RecyclerView paramRecyclerView) {}
    
    public final void cj(int paramInt)
    {
      this.asY.ap(paramInt, 1);
    }
    
    public final void ck(int paramInt)
    {
      this.asY.ar(paramInt, 1);
    }
    
    public final void cl(int paramInt)
    {
      this.asY.as(paramInt, 1);
    }
    
    public final VH d(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        e.beginSection("RV CreateView");
        paramViewGroup = a(paramViewGroup, paramInt);
        if (paramViewGroup.auu.getParent() != null) {
          throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        }
      }
      finally
      {
        e.endSection();
      }
      paramViewGroup.auy = paramInt;
      e.endSection();
      return paramViewGroup;
    }
    
    public void d(RecyclerView paramRecyclerView) {}
    
    public final void e(int paramInt1, int paramInt2, Object paramObject)
    {
      this.asY.e(paramInt1, paramInt2, paramObject);
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
      this.asY.notifyChanged();
    }
  }
  
  public static final class b
    extends Observable<RecyclerView.c>
  {
    public final void ap(int paramInt1, int paramInt2)
    {
      e(paramInt1, paramInt2, null);
    }
    
    public final void aq(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).l(paramInt1, paramInt2, 1);
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
    
    public final void as(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).av(paramInt1, paramInt2);
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
    public void at(int paramInt1, int paramInt2) {}
    
    public void au(int paramInt1, int paramInt2) {}
    
    public void av(int paramInt1, int paramInt2) {}
    
    public void f(int paramInt1, int paramInt2, Object paramObject)
    {
      at(paramInt1, paramInt2);
    }
    
    public void l(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onChanged() {}
  }
  
  public static abstract interface d
  {
    public abstract int aw(int paramInt1, int paramInt2);
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
    b ata = null;
    private ArrayList<a> atb = new ArrayList();
    public long atc = 120L;
    public long atd = 120L;
    public long ate = 250L;
    public long atf = 250L;
    
    static int m(RecyclerView.w paramw)
    {
      int j = paramw.FL & 0xE;
      int i;
      if (paramw.isInvalid()) {
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
            k = paramw.auw;
            m = paramw.lN();
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
          parama.lv();
        }
      }
      else {
        return bool;
      }
      this.atb.add(parama);
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
    
    public abstract void ju();
    
    public abstract void jw();
    
    public final void lo()
    {
      this.ate = 0L;
    }
    
    public long lp()
    {
      return this.atc;
    }
    
    public long lq()
    {
      return this.atd;
    }
    
    public final void lr()
    {
      this.atd = 2000L;
    }
    
    public final long ls()
    {
      return this.atf;
    }
    
    public final void lt()
    {
      this.atf = 0L;
    }
    
    public final void lu()
    {
      int j = this.atb.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.atb.get(i)).lv();
        i += 1;
      }
      this.atb.clear();
    }
    
    public final void n(RecyclerView.w paramw)
    {
      o(paramw);
      if (this.ata != null) {
        this.ata.o(paramw);
      }
    }
    
    public void o(RecyclerView.w paramw) {}
    
    public boolean p(RecyclerView.w paramw)
    {
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void lv();
    }
    
    static abstract interface b
    {
      public abstract void o(RecyclerView.w paramw);
    }
    
    public static class c
    {
      public int atg;
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public c c(RecyclerView.w paramw, int paramInt)
      {
        paramw = paramw.auu;
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
      if ((paramw.auA != null) && (paramw.auB == null)) {
        paramw.auA = null;
      }
      paramw.auB = null;
      int i;
      RecyclerView localRecyclerView;
      Object localObject;
      s locals;
      if ((paramw.FL & 0x10) != 0)
      {
        i = 1;
        if (i == 0)
        {
          localRecyclerView = RecyclerView.this;
          localObject = paramw.auu;
          localRecyclerView.kI();
          locals = localRecyclerView.arM;
          i = locals.alK.indexOfChild((View)localObject);
          if (i != -1) {
            break label169;
          }
          locals.bf((View)localObject);
          i = 1;
          label99:
          if (i != 0)
          {
            localObject = RecyclerView.bv((View)localObject);
            localRecyclerView.arJ.u((RecyclerView.w)localObject);
            localRecyclerView.arJ.t((RecyclerView.w)localObject);
          }
          if (i != 0) {
            break label220;
          }
        }
      }
      for (;;)
      {
        localRecyclerView.as(bool);
        if ((i == 0) && (paramw.lX())) {
          RecyclerView.this.removeDetachedView(paramw.auu, false);
        }
        return;
        i = 0;
        break;
        label169:
        if (locals.alL.get(i))
        {
          locals.alL.remove(i);
          locals.bf((View)localObject);
          locals.alK.removeViewAt(i);
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
    protected RecyclerView anl;
    s arM;
    private final bf.b ath = new bf.b()
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
      
      public final int lB()
      {
        return RecyclerView.i.this.getPaddingLeft();
      }
      
      public final int lC()
      {
        return RecyclerView.i.this.mWidth - RecyclerView.i.this.getPaddingRight();
      }
    };
    private final bf.b ati = new bf.b()
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
      
      public final int lB()
      {
        return RecyclerView.i.this.getPaddingTop();
      }
      
      public final int lC()
      {
        return RecyclerView.i.this.mHeight - RecyclerView.i.this.getPaddingBottom();
      }
    };
    bf atj = new bf(this.ath);
    bf atk = new bf(this.ati);
    RecyclerView.s atl;
    boolean atm = false;
    protected boolean atn = false;
    protected boolean ato = true;
    boolean atp = true;
    int atq;
    boolean atr;
    protected int ats;
    protected int att;
    public int mHeight;
    public int mWidth;
    boolean qm = false;
    
    private void H(View paramView, int paramInt)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if (localw.isRemoved()) {
        this.anl.arN.G(localw);
      }
      for (;;)
      {
        this.arM.a(paramView, paramInt, localLayoutParams, localw.isRemoved());
        return;
        this.anl.arN.H(localw);
      }
    }
    
    private void a(RecyclerView.o paramo, int paramInt, View paramView)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if (localw.lL()) {
        return;
      }
      if ((localw.isInvalid()) && (!localw.isRemoved()) && (!this.anl.acW.asZ))
      {
        removeViewAt(paramInt);
        paramo.t(localw);
        return;
      }
      cm(paramInt);
      paramo.bU(paramView);
      this.anl.arN.H(localw);
    }
    
    private void az(int paramInt1, int paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == null) {
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.anl.toString());
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aty.lM();
    }
    
    public static int bC(View paramView)
    {
      return RecyclerView.bv(paramView).auy;
    }
    
    public static int bE(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public static int bF(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG;
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG.top;
    }
    
    public static int bL(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG.bottom;
    }
    
    public static int bM(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG.left;
    }
    
    public static int bN(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG.right;
    }
    
    public static b c(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      b localb = new b();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt1, paramInt2);
      localb.orientation = paramContext.getInt(0, 1);
      localb.atv = paramContext.getInt(9, 1);
      localb.atw = paramContext.getBoolean(8, false);
      localb.atx = paramContext.getBoolean(10, false);
      paramContext.recycle();
      return localb;
    }
    
    private void c(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localw.isRemoved()))
      {
        this.anl.arN.G(localw);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localw.lT()) && (!localw.lR())) {
          break label128;
        }
        if (!localw.lR()) {
          break label120;
        }
        localw.lS();
        label68:
        this.arM.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.atA)
        {
          localw.auu.invalidate();
          localLayoutParams.atA = false;
        }
        return;
        this.anl.arN.H(localw);
        break;
        label120:
        localw.lU();
        break label68;
        label128:
        if (paramView.getParent() == this.anl)
        {
          int j = this.arM.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.arM.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.anl.indexOfChild(paramView) + this.anl.kF());
          }
          if (j != i) {
            this.anl.arR.az(j, i);
          }
        }
        else
        {
          this.arM.a(paramView, paramInt, false);
          localLayoutParams.atz = true;
          if ((this.atl != null) && (this.atl.ga)) {
            this.atl.bV(paramView);
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
      this.arM.detachViewFromParent(paramInt);
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
        localRect = this.anl.mTempRect;
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
      if (t.Y(this.anl) == 1) {
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
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public static void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.apG;
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
      s locals = this.arM;
      int i = locals.alK.indexOfChild(paramView);
      if (i >= 0)
      {
        if (locals.alL.remove(i)) {
          locals.bf(paramView);
        }
        locals.alK.removeViewAt(i);
      }
    }
    
    private void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.arM.removeViewAt(paramInt);
      }
    }
    
    public void F(String paramString)
    {
      if (this.anl != null) {
        this.anl.F(paramString);
      }
    }
    
    public final void G(View paramView, int paramInt)
    {
      c(paramView, paramInt, true);
    }
    
    public int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
    {
      return 0;
    }
    
    public int a(RecyclerView.o paramo, RecyclerView.t paramt)
    {
      if ((this.anl == null) || (this.anl.acW == null)) {}
      while (!kd()) {
        return 1;
      }
      return this.anl.acW.getItemCount();
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
      setMeasuredDimension(m(paramInt1, i + j + k, t.ae(this.anl)), m(paramInt2, m + n + i1, t.af(this.anl)));
    }
    
    public void a(RecyclerView.o paramo, RecyclerView.t paramt, View paramView, android.support.v4.view.a.c paramc)
    {
      int i;
      if (kd())
      {
        i = bB(paramView);
        if (!kc()) {
          break label48;
        }
      }
      label48:
      for (int j = bB(paramView);; j = 0)
      {
        paramc.H(c.c.a(i, 1, j, 1, false));
        return;
        i = 0;
        break;
      }
    }
    
    public final void a(RecyclerView.s params)
    {
      if ((this.atl != null) && (params != this.atl) && (this.atl.ga)) {
        this.atl.stop();
      }
      this.atl = params;
      params = this.atl;
      RecyclerView localRecyclerView = this.anl;
      if (params.mStarted) {
        new StringBuilder("An instance of ").append(params.getClass().getSimpleName()).append(" was started more than once. Each instance of").append(params.getClass().getSimpleName()).append(" is intended to only be used once. You should create a new instance for each use.");
      }
      params.anl = localRecyclerView;
      params.arw = this;
      if (params.atQ == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      params.anl.asG.atQ = params.atQ;
      params.ga = true;
      params.atR = true;
      int i = params.atQ;
      params.atS = params.anl.arR.bY(i);
      params.anl.asD.lI();
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
      if ((localw != null) && (!localw.isRemoved()) && (!this.arM.bg(localw.auu))) {
        a(this.anl.arJ, this.anl.asG, paramView, paramc);
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
      return (!this.ato) || (!n(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public final void aA(int paramInt1, int paramInt2)
    {
      this.anl.am(paramInt1, paramInt2);
    }
    
    public final void addView(View paramView)
    {
      c(paramView, -1, false);
    }
    
    public final void addView(View paramView, int paramInt)
    {
      c(paramView, paramInt, false);
    }
    
    public final void aw(boolean paramBoolean)
    {
      if (paramBoolean != this.atp)
      {
        this.atp = paramBoolean;
        this.atq = 0;
        if (this.anl != null) {
          this.anl.arJ.lF();
        }
      }
    }
    
    final void ax(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.ats = View.MeasureSpec.getMode(paramInt1);
      if ((this.ats == 0) && (!RecyclerView.arC)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.att = View.MeasureSpec.getMode(paramInt2);
      if ((this.att == 0) && (!RecyclerView.arC)) {
        this.mHeight = 0;
      }
    }
    
    final void ay(int paramInt1, int paramInt2)
    {
      int i5 = getChildCount();
      if (i5 == 0)
      {
        this.anl.am(paramInt1, paramInt2);
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
        Rect localRect = this.anl.mTempRect;
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
      this.anl.mTempRect.set(i3, k, n, j);
      a(this.anl.mTempRect, paramInt1, paramInt2);
    }
    
    public int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
    {
      return 0;
    }
    
    public int b(RecyclerView.o paramo, RecyclerView.t paramt)
    {
      if ((this.anl == null) || (this.anl.acW == null)) {}
      while (!kc()) {
        return 1;
      }
      return this.anl.acW.getItemCount();
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
      this.qm = false;
      a(paramRecyclerView, paramo);
    }
    
    final boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.ato) || (!n(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public final void bD(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.anl.by(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      k = b(this.mWidth, this.ats, k + m + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, kc());
      i = b(this.mHeight, this.att, j + i + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, kd());
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
        if ((localw != null) && (localw.lM() == paramInt) && (!localw.lL()) && ((this.anl.asG.aug) || (!localw.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public final View bt(View paramView)
    {
      if (this.anl == null) {}
      do
      {
        return null;
        paramView = this.anl.bt(paramView);
      } while ((paramView == null) || (this.arM.bg(paramView)));
      return paramView;
    }
    
    final void c(RecyclerView.o paramo)
    {
      int j = paramo.atH.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.w)paramo.atH.get(i)).auu;
        RecyclerView.w localw = RecyclerView.bv(localView);
        if (!localw.lL())
        {
          localw.ax(false);
          if (localw.lX()) {
            this.anl.removeDetachedView(localView, false);
          }
          if (this.anl.asr != null) {
            this.anl.asr.d(localw);
          }
          localw.ax(true);
          paramo.bT(localView);
        }
        i -= 1;
      }
      paramo.atH.clear();
      if (paramo.atI != null) {
        paramo.atI.clear();
      }
      if (j > 0) {
        this.anl.invalidate();
      }
    }
    
    public void c(RecyclerView.o paramo, RecyclerView.t paramt) {}
    
    public void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void ca(int paramInt) {}
    
    public void cn(int paramInt)
    {
      if (this.anl != null)
      {
        RecyclerView localRecyclerView = this.anl;
        int j = localRecyclerView.arM.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.arM.getChildAt(i).offsetLeftAndRight(paramInt);
          i += 1;
        }
      }
    }
    
    public void co(int paramInt)
    {
      if (this.anl != null)
      {
        RecyclerView localRecyclerView = this.anl;
        int j = localRecyclerView.arM.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.arM.getChildAt(i).offsetTopAndBottom(paramInt);
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
        if (!RecyclerView.bv(getChildAt(i)).lL()) {
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
      Object localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apG;
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      int k = paramView.getWidth();
      int m = ((Rect)localObject).right;
      int n = paramView.getHeight();
      paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
      if (this.anl != null)
      {
        localObject = paramView.getMatrix();
        if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
        {
          RectF localRectF = this.anl.arQ;
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
      this.qm = true;
      g(paramRecyclerView);
    }
    
    public final void f(View paramView, Rect paramRect)
    {
      if (this.anl == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.anl.by(paramView));
    }
    
    public int g(RecyclerView.t paramt)
    {
      return 0;
    }
    
    public void g(RecyclerView paramRecyclerView) {}
    
    public void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public final View getChildAt(int paramInt)
    {
      if (this.arM != null) {
        return this.arM.getChildAt(paramInt);
      }
      return null;
    }
    
    public final int getChildCount()
    {
      if (this.arM != null) {
        return this.arM.getChildCount();
      }
      return 0;
    }
    
    public final boolean getClipToPadding()
    {
      return (this.anl != null) && (this.anl.arO);
    }
    
    public final View getFocusedChild()
    {
      if (this.anl == null) {}
      View localView;
      do
      {
        return null;
        localView = this.anl.getFocusedChild();
      } while ((localView == null) || (this.arM.bg(localView)));
      return localView;
    }
    
    public final int getHeight()
    {
      return this.mHeight;
    }
    
    public final int getItemCount()
    {
      if (this.anl != null) {}
      for (RecyclerView.a locala = this.anl.getAdapter(); locala != null; locala = null) {
        return locala.getItemCount();
      }
      return 0;
    }
    
    public int getPaddingBottom()
    {
      if (this.anl != null) {
        return this.anl.getPaddingBottom();
      }
      return 0;
    }
    
    public int getPaddingEnd()
    {
      if (this.anl != null) {
        return t.ac(this.anl);
      }
      return 0;
    }
    
    public int getPaddingLeft()
    {
      if (this.anl != null) {
        return this.anl.getPaddingLeft();
      }
      return 0;
    }
    
    public int getPaddingRight()
    {
      if (this.anl != null) {
        return this.anl.getPaddingRight();
      }
      return 0;
    }
    
    public int getPaddingStart()
    {
      if (this.anl != null) {
        return t.ab(this.anl);
      }
      return 0;
    }
    
    public int getPaddingTop()
    {
      if (this.anl != null) {
        return this.anl.getPaddingTop();
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
      ax(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public int i(RecyclerView.t paramt)
    {
      return 0;
    }
    
    public abstract RecyclerView.LayoutParams jW();
    
    public boolean ka()
    {
      return false;
    }
    
    public boolean kb()
    {
      return this.atn;
    }
    
    public boolean kc()
    {
      return false;
    }
    
    public boolean kd()
    {
      return false;
    }
    
    boolean kh()
    {
      return false;
    }
    
    public void lA()
    {
      this.atm = true;
    }
    
    @Deprecated
    public final void lw()
    {
      this.atn = true;
    }
    
    public final boolean lx()
    {
      return (this.atl != null) && (this.atl.ga);
    }
    
    public void ly() {}
    
    final void lz()
    {
      if (this.atl != null) {
        this.atl.stop();
      }
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      if ((this.anl == null) || (paramAccessibilityEvent == null)) {
        return;
      }
      boolean bool1 = bool2;
      if (!this.anl.canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.anl.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.anl.canScrollHorizontally(-1)) {
            if (!this.anl.canScrollHorizontally(1)) {
              break label96;
            }
          }
        }
      }
      label96:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (this.anl.acW == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.anl.acW.getItemCount());
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
        this.arM.removeViewAt(i);
        i -= 1;
      }
    }
    
    public final boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.anl != null) {
        return this.anl.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public final void requestLayout()
    {
      if (this.anl != null) {
        this.anl.requestLayout();
      }
    }
    
    public final void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      RecyclerView.e(this.anl, paramInt1, paramInt2);
    }
    
    final void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.anl = null;
        this.arM = null;
        this.mWidth = 0;
      }
      for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
      {
        this.ats = 1073741824;
        this.att = 1073741824;
        return;
        this.anl = paramRecyclerView;
        this.arM = paramRecyclerView.arM;
        this.mWidth = paramRecyclerView.getWidth();
      }
    }
    
    public static abstract interface a
    {
      public abstract void S(int paramInt1, int paramInt2);
    }
    
    public static final class b
    {
      public int atv;
      public boolean atw;
      public boolean atx;
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
    public abstract boolean aB(int paramInt1, int paramInt2);
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
    SparseArray<a> atB = new SparseArray();
    int atC = 0;
    
    static long c(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    final boolean a(int paramInt, long paramLong1, long paramLong2)
    {
      long l = cs(paramInt).atF;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }
    
    public final void aC(int paramInt1, int paramInt2)
    {
      Object localObject = cs(paramInt1);
      ((a)localObject).atE = paramInt2;
      localObject = ((a)localObject).atD;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
    }
    
    public final int cq(int paramInt)
    {
      return cs(paramInt).atD.size();
    }
    
    public RecyclerView.w cr(int paramInt)
    {
      Object localObject = (a)this.atB.get(paramInt);
      if ((localObject != null) && (!((a)localObject).atD.isEmpty()))
      {
        localObject = ((a)localObject).atD;
        return (RecyclerView.w)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      return null;
    }
    
    final a cs(int paramInt)
    {
      a locala2 = (a)this.atB.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.atB.put(paramInt, locala1);
      }
      return locala1;
    }
    
    final void d(int paramInt, long paramLong)
    {
      a locala = cs(paramInt);
      locala.atF = c(locala.atF, paramLong);
    }
    
    final void detach()
    {
      this.atC -= 1;
    }
    
    final void lE()
    {
      this.atC += 1;
    }
    
    public void q(RecyclerView.w paramw)
    {
      int i = paramw.auy;
      ArrayList localArrayList = cs(i).atD;
      if (((a)this.atB.get(i)).atE <= localArrayList.size()) {
        return;
      }
      paramw.resetInternal();
      localArrayList.add(paramw);
    }
    
    static final class a
    {
      final ArrayList<RecyclerView.w> atD = new ArrayList();
      int atE = 5;
      long atF = 0L;
      long atG = 0L;
    }
  }
  
  public final class o
  {
    final ArrayList<RecyclerView.w> atH = new ArrayList();
    ArrayList<RecyclerView.w> atI = null;
    final ArrayList<RecyclerView.w> atJ = new ArrayList();
    final List<RecyclerView.w> atK = Collections.unmodifiableList(this.atH);
    int atL = 2;
    int atM = 2;
    RecyclerView.n atN;
    RecyclerView.u atO;
    
    public o() {}
    
    private RecyclerView.w a(long paramLong, int paramInt)
    {
      int i = this.atH.size() - 1;
      RecyclerView.w localw;
      while (i >= 0)
      {
        localw = (RecyclerView.w)this.atH.get(i);
        if ((localw.aux == paramLong) && (!localw.lT()))
        {
          if (paramInt == localw.auy)
          {
            localw.addFlags(32);
            if ((localw.isRemoved()) && (!RecyclerView.this.asG.aug)) {
              localw.setFlags(2, 14);
            }
            return localw;
          }
          this.atH.remove(i);
          RecyclerView.this.removeDetachedView(localw.auu, false);
          bT(localw.auu);
        }
        i -= 1;
      }
      i = this.atJ.size() - 1;
      while (i >= 0)
      {
        localw = (RecyclerView.w)this.atJ.get(i);
        if (localw.aux == paramLong)
        {
          if (paramInt == localw.auy)
          {
            this.atJ.remove(i);
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
      paramw.auK = RecyclerView.this;
      int i = paramw.auy;
      long l1 = RecyclerView.this.getNanoTime();
      if (paramLong != 9223372036854775807L)
      {
        long l2 = this.atN.cs(i).atG;
        if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
        for (i = 1; i == 0; i = 0) {
          return false;
        }
      }
      Object localObject = RecyclerView.this.acW;
      paramw.mPosition = paramInt1;
      if (((RecyclerView.a)localObject).asZ) {
        paramw.aux = ((RecyclerView.a)localObject).getItemId(paramInt1);
      }
      paramw.setFlags(1, 519);
      e.beginSection("RV OnBindView");
      ((RecyclerView.a)localObject).a(paramw, paramInt1, paramw.ma());
      paramw.lZ();
      localObject = paramw.auu.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)localObject).atz = true;
      }
      e.endSection();
      paramLong = RecyclerView.this.getNanoTime();
      localObject = this.atN.cs(paramw.auy);
      ((RecyclerView.n.a)localObject).atG = RecyclerView.n.c(((RecyclerView.n.a)localObject).atG, paramLong - l1);
      if (RecyclerView.this.kU())
      {
        localObject = paramw.auu;
        if (t.X((View)localObject) == 0) {
          t.p((View)localObject, 1);
        }
        if (!t.U((View)localObject))
        {
          paramw.addFlags(16384);
          t.a((View)localObject, RecyclerView.this.asN.auL);
        }
      }
      if (RecyclerView.this.asG.aug) {
        paramw.auz = paramInt2;
      }
      return true;
    }
    
    private RecyclerView.w cx(int paramInt)
    {
      int j = 0;
      int k;
      if (this.atI != null)
      {
        k = this.atI.size();
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
        localw = (RecyclerView.w)this.atI.get(i);
        if ((!localw.lT()) && (localw.lM() == paramInt))
        {
          localw.addFlags(32);
          return localw;
        }
        i += 1;
      }
      if (RecyclerView.this.acW.asZ)
      {
        paramInt = RecyclerView.this.arL.M(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.acW.getItemCount()))
        {
          long l = RecyclerView.this.acW.getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localw = (RecyclerView.w)this.atI.get(paramInt);
            if ((!localw.lT()) && (localw.aux == l))
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
      int k = this.atH.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.w)this.atH.get(i);
        if ((!((RecyclerView.w)localObject1).lT()) && (((RecyclerView.w)localObject1).lM() == paramInt) && (!((RecyclerView.w)localObject1).isInvalid()) && ((RecyclerView.this.asG.aug) || (!((RecyclerView.w)localObject1).isRemoved())))
        {
          ((RecyclerView.w)localObject1).addFlags(32);
          return localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.arM;
      k = ((s)localObject2).alM.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((s)localObject2).alM.get(i);
        localObject3 = ((s)localObject2).alK.bh((View)localObject1);
        if ((((RecyclerView.w)localObject3).lM() != paramInt) || (((RecyclerView.w)localObject3).isInvalid()) || (((RecyclerView.w)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.bv((View)localObject1);
          localObject3 = RecyclerView.this.arM;
          paramInt = ((s)localObject3).alK.indexOfChild((View)localObject1);
          if (paramInt < 0)
          {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((s)localObject3).alL.get(paramInt)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
          }
          ((s)localObject3).alL.clear(paramInt);
          ((s)localObject3).bf((View)localObject1);
          paramInt = RecyclerView.this.arM.indexOfChild((View)localObject1);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + RecyclerView.this.kF());
          }
          RecyclerView.this.arM.detachViewFromParent(paramInt);
          bU((View)localObject1);
          ((RecyclerView.w)localObject2).addFlags(8224);
          return localObject2;
        }
      }
      k = this.atJ.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.w)this.atJ.get(i);
        if ((!((RecyclerView.w)localObject1).isInvalid()) && (((RecyclerView.w)localObject1).lM() == paramInt))
        {
          this.atJ.remove(i);
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
    
    private void lG()
    {
      int i = this.atJ.size() - 1;
      while (i >= 0)
      {
        cw(i);
        i -= 1;
      }
      this.atJ.clear();
      if (RecyclerView.arE) {
        RecyclerView.this.asF.jC();
      }
    }
    
    private boolean r(RecyclerView.w paramw)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramw.isRemoved()) {
        bool1 = RecyclerView.this.asG.aug;
      }
      do
      {
        do
        {
          return bool1;
          if ((paramw.mPosition < 0) || (paramw.mPosition >= RecyclerView.this.acW.getItemCount())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramw + RecyclerView.this.kF());
          }
          if (RecyclerView.this.asG.aug) {
            break;
          }
          bool1 = bool2;
        } while (RecyclerView.this.acW.getItemViewType(paramw.mPosition) != paramw.auy);
        if (!RecyclerView.this.acW.asZ) {
          break;
        }
        bool1 = bool2;
      } while (paramw.aux != RecyclerView.this.acW.getItemId(paramw.mPosition));
      return true;
      return true;
    }
    
    private void s(RecyclerView.w paramw)
    {
      if ((paramw.auu instanceof ViewGroup)) {
        d((ViewGroup)paramw.auu, false);
      }
    }
    
    private void v(RecyclerView.w paramw)
    {
      if (RecyclerView.this.acW != null) {
        RecyclerView.this.acW.a(paramw);
      }
      if (RecyclerView.this.asG != null) {
        RecyclerView.this.arN.I(paramw);
      }
    }
    
    final void a(RecyclerView.w paramw, boolean paramBoolean)
    {
      RecyclerView.h(paramw);
      if (paramw.cB(16384))
      {
        paramw.setFlags(0, 16384);
        t.a(paramw.auu, null);
      }
      if (paramBoolean) {
        v(paramw);
      }
      paramw.auK = null;
      getRecycledViewPool().q(paramw);
    }
    
    public final void bS(View paramView)
    {
      RecyclerView.w localw = RecyclerView.bv(paramView);
      if (localw.lX()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localw.lR()) {
        localw.lS();
      }
      for (;;)
      {
        t(localw);
        return;
        if (localw.lT()) {
          localw.lU();
        }
      }
    }
    
    final void bT(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      paramView.auG = null;
      paramView.auH = false;
      paramView.lU();
      t(paramView);
    }
    
    final void bU(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      int i;
      if ((!paramView.cB(12)) && (paramView.md()))
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.asr != null) && (!localRecyclerView.asr.a(paramView, paramView.ma()))) {
          break label112;
        }
        i = 1;
      }
      while (i != 0) {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.acW.asZ))
        {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.kF());
          label112:
          i = 0;
        }
        else
        {
          paramView.a(this, false);
          this.atH.add(paramView);
          return;
        }
      }
      if (this.atI == null) {
        this.atI = new ArrayList();
      }
      paramView.a(this, true);
      this.atI.add(paramView);
    }
    
    public final void clear()
    {
      this.atH.clear();
      lG();
    }
    
    public final int ct(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.asG.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.asG.getItemCount() + RecyclerView.this.kF());
      }
      if (!RecyclerView.this.asG.aug) {
        return paramInt;
      }
      return RecyclerView.this.arL.bD(paramInt);
    }
    
    public final View cu(int paramInt)
    {
      return cv(paramInt);
    }
    
    final View cv(int paramInt)
    {
      return e(paramInt, 9223372036854775807L).auu;
    }
    
    final void cw(int paramInt)
    {
      a((RecyclerView.w)this.atJ.get(paramInt), true);
      this.atJ.remove(paramInt);
    }
    
    final RecyclerView.w e(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.asG.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.asG.getItemCount() + RecyclerView.this.kF());
      }
      Object localObject1;
      int i;
      if (RecyclerView.this.asG.aug)
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
            if (!((RecyclerView.w)localObject2).lR()) {
              break label305;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.w)localObject2).auu, false);
            ((RecyclerView.w)localObject2).lS();
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
            int k = RecyclerView.this.arL.bD(paramInt);
            if ((k < 0) || (k >= RecyclerView.this.acW.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.asG.getItemCount() + RecyclerView.this.kF());
              i = 0;
              break;
              label305:
              if (!((RecyclerView.w)localObject2).lT()) {
                break label183;
              }
              ((RecyclerView.w)localObject2).lU();
              break label183;
              label321:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.this.acW.getItemViewType(k);
            if (RecyclerView.this.acW.asZ)
            {
              localObject2 = a(RecyclerView.this.acW.getItemId(k), j);
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
                    if (RecyclerView.arB)
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
                  if ((paramLong != 9223372036854775807L) && (!this.atN.a(j, l1, paramLong))) {
                    return null;
                  }
                  localObject2 = RecyclerView.this.acW.d(RecyclerView.this, j);
                  if (RecyclerView.arE)
                  {
                    localObject1 = RecyclerView.bz(((RecyclerView.w)localObject2).auu);
                    if (localObject1 != null) {
                      ((RecyclerView.w)localObject2).auv = new WeakReference(localObject1);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.atN.d(j, l2 - l1);
                }
              }
            }
          }
          for (;;)
          {
            if ((i != 0) && (!RecyclerView.this.asG.aug) && (((RecyclerView.w)localObject2).cB(8192)))
            {
              ((RecyclerView.w)localObject2).setFlags(0, 8192);
              if (RecyclerView.this.asG.auj)
              {
                j = RecyclerView.f.m((RecyclerView.w)localObject2);
                localObject1 = RecyclerView.this.asr.a(RecyclerView.this.asG, (RecyclerView.w)localObject2, j | 0x1000, ((RecyclerView.w)localObject2).ma());
                RecyclerView.this.a((RecyclerView.w)localObject2, (RecyclerView.f.c)localObject1);
              }
            }
            boolean bool1;
            if ((RecyclerView.this.asG.aug) && (((RecyclerView.w)localObject2).isBound()))
            {
              ((RecyclerView.w)localObject2).auz = paramInt;
              bool1 = false;
            }
            for (;;)
            {
              localObject1 = ((RecyclerView.w)localObject2).auu.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                ((RecyclerView.w)localObject2).auu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label738:
                ((RecyclerView.LayoutParams)localObject1).aty = ((RecyclerView.w)localObject2);
                if ((i == 0) || (!bool1)) {
                  break label866;
                }
              }
              label866:
              for (bool1 = bool2;; bool1 = false)
              {
                ((RecyclerView.LayoutParams)localObject1).atA = bool1;
                return localObject2;
                if ((((RecyclerView.w)localObject2).isBound()) && (!((RecyclerView.w)localObject2).lW()) && (!((RecyclerView.w)localObject2).isInvalid())) {
                  break label872;
                }
                bool1 = a((RecyclerView.w)localObject2, RecyclerView.this.arL.bD(paramInt), paramInt, paramLong);
                break;
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((RecyclerView.w)localObject2).auu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
      if (this.atN == null) {
        this.atN = new RecyclerView.n();
      }
      return this.atN;
    }
    
    final void lF()
    {
      if (RecyclerView.this.arR != null) {}
      for (int i = RecyclerView.this.arR.atq;; i = 0)
      {
        this.atM = (i + this.atL);
        i = this.atJ.size() - 1;
        while ((i >= 0) && (this.atJ.size() > this.atM))
        {
          cw(i);
          i -= 1;
        }
      }
    }
    
    final void lj()
    {
      int j = 0;
      int k = this.atJ.size();
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.w)this.atJ.get(i)).lJ();
        i += 1;
      }
      k = this.atH.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.w)this.atH.get(i)).lJ();
        i += 1;
      }
      if (this.atI != null)
      {
        k = this.atI.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.w)this.atI.get(i)).lJ();
          i += 1;
        }
      }
    }
    
    final void lk()
    {
      int j = this.atJ.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.w localw = (RecyclerView.w)this.atJ.get(i);
        if (localw != null)
        {
          localw.addFlags(6);
          localw.O(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.acW == null) || (!RecyclerView.this.acW.asZ)) {
        lG();
      }
    }
    
    final void t(RecyclerView.w paramw)
    {
      int k = 1;
      if ((paramw.lR()) || (paramw.auu.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramw.lR()).append(" isAttached:");
        if (paramw.auu.getParent() != null) {}
        for (bool = true;; bool = false) {
          throw new IllegalArgumentException(bool + RecyclerView.this.kF());
        }
      }
      if (paramw.lX()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramw + RecyclerView.this.kF());
      }
      if (paramw.lL()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.kF());
      }
      boolean bool = paramw.mc();
      int j;
      int i;
      if (paramw.mb()) {
        if ((this.atM > 0) && (!paramw.cB(526)))
        {
          j = this.atJ.size();
          i = j;
          if (j >= this.atM)
          {
            i = j;
            if (j > 0)
            {
              cw(0);
              i = j - 1;
            }
          }
          j = i;
          if (RecyclerView.arE)
          {
            j = i;
            if (i > 0)
            {
              j = i;
              if (!RecyclerView.this.asF.bO(paramw.mPosition))
              {
                i -= 1;
                while (i >= 0)
                {
                  j = ((RecyclerView.w)this.atJ.get(i)).mPosition;
                  if (!RecyclerView.this.asF.bO(j)) {
                    break;
                  }
                  i -= 1;
                }
                j = i + 1;
              }
            }
          }
          this.atJ.add(j, paramw);
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
        RecyclerView.this.arN.I(paramw);
        if ((i == 0) && (j == 0) && (bool)) {
          paramw.auK = null;
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
      if (paramw.auH) {
        this.atI.remove(paramw);
      }
      for (;;)
      {
        paramw.auG = null;
        paramw.auH = false;
        paramw.lU();
        return;
        this.atH.remove(paramw);
      }
    }
  }
  
  public static abstract interface p {}
  
  final class q
    extends RecyclerView.c
  {
    q() {}
    
    private void lH()
    {
      if ((RecyclerView.arD) && (RecyclerView.this.arX) && (RecyclerView.this.arW))
      {
        t.b(RecyclerView.this, RecyclerView.this.arP);
        return;
      }
      RecyclerView.this.asf = true;
      RecyclerView.this.requestLayout();
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.F(null);
      d locald = RecyclerView.this.arL;
      if (paramInt2 > 0)
      {
        locald.ajF.add(locald.b(1, paramInt1, paramInt2, null));
        locald.ajL |= 0x1;
        if (locald.ajF.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lH();
        }
        return;
      }
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.F(null);
      d locald = RecyclerView.this.arL;
      if (paramInt2 > 0)
      {
        locald.ajF.add(locald.b(2, paramInt1, paramInt2, null));
        locald.ajL |= 0x2;
        if (locald.ajF.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lH();
        }
        return;
      }
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      RecyclerView.this.F(null);
      d locald = RecyclerView.this.arL;
      if (paramInt2 > 0)
      {
        locald.ajF.add(locald.b(4, paramInt1, paramInt2, paramObject));
        locald.ajL |= 0x4;
        if (locald.ajF.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lH();
        }
        return;
      }
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      RecyclerView.this.F(null);
      d locald = RecyclerView.this.arL;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1) {
          throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        locald.ajF.add(locald.b(8, paramInt1, paramInt2, null));
        locald.ajL |= 0x8;
        if (locald.ajF.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lH();
        }
        return;
      }
    }
    
    public final void onChanged()
    {
      RecyclerView.this.F(null);
      RecyclerView.this.asG.auf = true;
      RecyclerView.this.au(true);
      if (!RecyclerView.this.arL.iT()) {
        RecyclerView.this.requestLayout();
      }
    }
  }
  
  public static abstract class s
  {
    RecyclerView anl;
    RecyclerView.i arw;
    public int atQ = -1;
    boolean atR;
    View atS;
    private final a atT = new a();
    boolean ga;
    boolean mStarted;
    
    protected abstract void a(int paramInt1, int paramInt2, a parama);
    
    protected abstract void a(View paramView, RecyclerView.t paramt, a parama);
    
    final void aD(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.anl;
      if ((!this.ga) || (this.atQ == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.atR) && (this.atS == null) && (this.arw != null))
      {
        PointF localPointF = bZ(this.atQ);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.b((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.atR = false;
      if (this.atS != null)
      {
        if (RecyclerView.bx(this.atS) != this.atQ) {
          break label233;
        }
        a(this.atS, localRecyclerView.asG, this.atT);
        this.atT.i(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.ga)
        {
          a(paramInt1, paramInt2, this.atT);
          paramInt1 = i;
          if (this.atT.atX >= 0) {
            paramInt1 = 1;
          }
          this.atT.i(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.ga) {
              break;
            }
            this.atR = true;
            localRecyclerView.asD.lI();
          }
        }
        return;
        label233:
        this.atS = null;
      }
      stop();
    }
    
    protected final void bV(View paramView)
    {
      if (RecyclerView.bx(paramView) == this.atQ) {
        this.atS = paramView;
      }
    }
    
    public PointF bZ(int paramInt)
    {
      RecyclerView.i locali = this.arw;
      if ((locali instanceof b)) {
        return ((b)locali).bZ(paramInt);
      }
      new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
      return null;
    }
    
    public final void cz(int paramInt)
    {
      this.atQ = paramInt;
    }
    
    public final RecyclerView.i getLayoutManager()
    {
      return this.arw;
    }
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.ga) {
        return;
      }
      this.ga = false;
      onStop();
      this.anl.asG.atQ = -1;
      this.atS = null;
      this.atQ = -1;
      this.atR = false;
      RecyclerView.i locali = this.arw;
      if (locali.atl == this) {
        locali.atl = null;
      }
      this.arw = null;
      this.anl = null;
    }
    
    public static final class a
    {
      private int atU = 0;
      private int atV = 0;
      private int atW = -2147483648;
      int atX = -1;
      private boolean atY = false;
      private int atZ = 0;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this((byte)0);
      }
      
      private a(byte paramByte) {}
      
      private void validate()
      {
        if ((this.mInterpolator != null) && (this.atW <= 0)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.atW <= 0) {
          throw new IllegalStateException("Scroll duration must be a positive number");
        }
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.atU = paramInt1;
        this.atV = paramInt2;
        this.atW = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.atY = true;
      }
      
      final void i(RecyclerView paramRecyclerView)
      {
        if (this.atX >= 0)
        {
          int i = this.atX;
          this.atX = -1;
          paramRecyclerView.cg(i);
          this.atY = false;
          return;
        }
        if (this.atY)
        {
          validate();
          if (this.mInterpolator == null) {
            if (this.atW == -2147483648) {
              paramRecyclerView.asD.aE(this.atU, this.atV);
            }
          }
          for (;;)
          {
            this.atZ += 1;
            this.atY = false;
            return;
            paramRecyclerView.asD.o(this.atU, this.atV, this.atW);
            continue;
            paramRecyclerView.asD.b(this.atU, this.atV, this.atW, this.mInterpolator);
          }
        }
        this.atZ = 0;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF bZ(int paramInt);
    }
  }
  
  public static final class t
  {
    int atQ = -1;
    private SparseArray<Object> aua;
    int aub = 0;
    int auc = 0;
    int aud = 1;
    int aue = 0;
    boolean auf = false;
    public boolean aug = false;
    boolean auh = false;
    boolean aui = false;
    boolean auj = false;
    boolean auk = false;
    int aul;
    long aum;
    int aun;
    int auo;
    int aup;
    
    final void cA(int paramInt)
    {
      if ((this.aud & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.aud));
      }
    }
    
    public final int getItemCount()
    {
      if (this.aug) {
        return this.aub - this.auc;
      }
      return this.aue;
    }
    
    public final String toString()
    {
      return "State{mTargetPosition=" + this.atQ + ", mData=" + this.aua + ", mItemCount=" + this.aue + ", mIsMeasuring=" + this.aui + ", mPreviousLayoutItemCount=" + this.aub + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.auc + ", mStructureChanged=" + this.auf + ", mInPreLayout=" + this.aug + ", mRunSimpleAnimations=" + this.auj + ", mRunPredictiveAnimations=" + this.auk + '}';
    }
  }
  
  public static abstract class u {}
  
  final class v
    implements Runnable
  {
    OverScroller Ur = new OverScroller(RecyclerView.this.getContext(), RecyclerView.asV);
    int auq;
    int aur;
    private boolean aus = false;
    private boolean aut = false;
    Interpolator mInterpolator = RecyclerView.asV;
    
    v() {}
    
    private static float distanceInfluenceForSnapDuration(float paramFloat)
    {
      return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    }
    
    final void aE(int paramInt1, int paramInt2)
    {
      o(paramInt1, paramInt2, aF(paramInt1, paramInt2));
    }
    
    final int aF(int paramInt1, int paramInt2)
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
        this.Ur = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.aur = 0;
      this.auq = 0;
      this.Ur.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.Ur.computeScrollOffset();
      }
      lI();
    }
    
    final void lI()
    {
      if (this.aus)
      {
        this.aut = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      t.b(RecyclerView.this, this);
    }
    
    public final void o(int paramInt1, int paramInt2, int paramInt3)
    {
      b(paramInt1, paramInt2, paramInt3, RecyclerView.asV);
    }
    
    public final void run()
    {
      if (RecyclerView.this.arR == null)
      {
        stop();
        return;
      }
      this.aut = false;
      this.aus = true;
      RecyclerView.this.kH();
      OverScroller localOverScroller = this.Ur;
      RecyclerView.s locals = RecyclerView.this.arR.atl;
      int i6;
      int i7;
      int k;
      int j;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.UB;
        i6 = localOverScroller.getCurrX();
        i7 = localOverScroller.getCurrY();
        k = i6 - this.auq;
        j = i7 - this.aur;
        this.auq = i6;
        this.aur = i7;
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
        if (RecyclerView.this.acW != null)
        {
          RecyclerView.this.b(k, j, RecyclerView.this.asS);
          i = RecyclerView.this.asS[0];
          i3 = RecyclerView.this.asS[1];
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
            if (!locals.atR)
            {
              m = i;
              n = i3;
              i1 = i4;
              i2 = i5;
              if (locals.ga)
              {
                m = RecyclerView.this.asG.getItemCount();
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
          if (!RecyclerView.this.arT.isEmpty()) {
            RecyclerView.this.invalidate();
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.ak(k, j);
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
                RecyclerView.this.al(i4, i);
              }
              if (((i4 != 0) || (i1 == i6) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (i2 == i7) || (localOverScroller.getFinalY() == 0))) {
                localOverScroller.abortAnimation();
              }
              if ((m != 0) || (n != 0)) {
                RecyclerView.this.ao(m, n);
              }
              if (!RecyclerView.b(RecyclerView.this)) {
                RecyclerView.this.invalidate();
              }
              if ((j != 0) && (RecyclerView.this.arR.kd()) && (n == j))
              {
                i = 1;
                if ((k == 0) || (!RecyclerView.this.arR.kc()) || (m != k)) {
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
                if (RecyclerView.arE) {
                  RecyclerView.this.asF.jC();
                }
                RecyclerView.this.aM(1);
              }
              for (;;)
              {
                if (locals != null)
                {
                  if (locals.atR) {
                    locals.aD(0, 0);
                  }
                  if (!this.aut) {
                    locals.stop();
                  }
                }
                this.aus = false;
                if (!this.aut) {
                  break;
                }
                lI();
                return;
                if (locals.atQ >= m) {
                  locals.atQ = (m - 1);
                }
                locals.aD(k - i4, j - i5);
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
                lI();
                if (RecyclerView.this.asE != null) {
                  RecyclerView.this.asE.b(RecyclerView.this, k, j);
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
      this.Ur.abortAnimation();
    }
  }
  
  public static abstract class w
  {
    private static final List<Object> auC = ;
    int FL;
    w auA = null;
    w auB = null;
    List<Object> auD = null;
    List<Object> auE = null;
    private int auF = 0;
    RecyclerView.o auG = null;
    boolean auH = false;
    int auI = 0;
    int auJ = -1;
    RecyclerView auK;
    public final View auu;
    WeakReference<RecyclerView> auv;
    int auw = -1;
    public long aux = -1L;
    public int auy = -1;
    int auz = -1;
    int mPosition = -1;
    
    public w(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.auu = paramView;
    }
    
    private void lY()
    {
      if (this.auD == null)
      {
        this.auD = new ArrayList();
        this.auE = Collections.unmodifiableList(this.auD);
      }
    }
    
    final void O(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((this.FL & 0x400) != 0) {
        return;
      }
      lY();
      this.auD.add(paramObject);
    }
    
    final void a(RecyclerView.o paramo, boolean paramBoolean)
    {
      this.auG = paramo;
      this.auH = paramBoolean;
    }
    
    final void addFlags(int paramInt)
    {
      this.FL |= paramInt;
    }
    
    public final void ax(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.auF - 1;
        this.auF = i;
        if (this.auF >= 0) {
          break label53;
        }
        this.auF = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.auF + 1;
        break;
        if ((!paramBoolean) && (this.auF == 1))
        {
          this.FL |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.auF != 0));
      this.FL &= 0xFFFFFFEF;
    }
    
    final boolean cB(int paramInt)
    {
      return (this.FL & paramInt) != 0;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.auz == -1) {
        return this.mPosition;
      }
      return this.auz;
    }
    
    final boolean isBound()
    {
      return (this.FL & 0x1) != 0;
    }
    
    final boolean isInvalid()
    {
      return (this.FL & 0x4) != 0;
    }
    
    public final boolean isRemoved()
    {
      return (this.FL & 0x8) != 0;
    }
    
    final void k(int paramInt, boolean paramBoolean)
    {
      if (this.auw == -1) {
        this.auw = this.mPosition;
      }
      if (this.auz == -1) {
        this.auz = this.mPosition;
      }
      if (paramBoolean) {
        this.auz += paramInt;
      }
      this.mPosition += paramInt;
      if (this.auu.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.auu.getLayoutParams()).atz = true;
      }
    }
    
    final void lJ()
    {
      this.auw = -1;
      this.auz = -1;
    }
    
    final void lK()
    {
      if (this.auw == -1) {
        this.auw = this.mPosition;
      }
    }
    
    final boolean lL()
    {
      return (this.FL & 0x80) != 0;
    }
    
    public final int lM()
    {
      if (this.auz == -1) {
        return this.mPosition;
      }
      return this.auz;
    }
    
    public final int lN()
    {
      if (this.auK == null) {
        return -1;
      }
      return this.auK.i(this);
    }
    
    public final int lO()
    {
      return this.auw;
    }
    
    public final long lP()
    {
      return this.aux;
    }
    
    public final int lQ()
    {
      return this.auy;
    }
    
    final boolean lR()
    {
      return this.auG != null;
    }
    
    final void lS()
    {
      this.auG.u(this);
    }
    
    final boolean lT()
    {
      return (this.FL & 0x20) != 0;
    }
    
    final void lU()
    {
      this.FL &= 0xFFFFFFDF;
    }
    
    final void lV()
    {
      this.FL &= 0xFFFFFEFF;
    }
    
    final boolean lW()
    {
      return (this.FL & 0x2) != 0;
    }
    
    final boolean lX()
    {
      return (this.FL & 0x100) != 0;
    }
    
    final void lZ()
    {
      if (this.auD != null) {
        this.auD.clear();
      }
      this.FL &= 0xFFFFFBFF;
    }
    
    final List<Object> ma()
    {
      if ((this.FL & 0x400) == 0)
      {
        if ((this.auD == null) || (this.auD.size() == 0)) {
          return auC;
        }
        return this.auE;
      }
      return auC;
    }
    
    public final boolean mb()
    {
      return ((this.FL & 0x10) == 0) && (!t.V(this.auu));
    }
    
    final boolean mc()
    {
      return ((this.FL & 0x10) == 0) && (t.V(this.auu));
    }
    
    final boolean md()
    {
      return (this.FL & 0x2) != 0;
    }
    
    final void resetInternal()
    {
      this.FL = 0;
      this.mPosition = -1;
      this.auw = -1;
      this.aux = -1L;
      this.auz = -1;
      this.auF = 0;
      this.auA = null;
      this.auB = null;
      lZ();
      this.auI = 0;
      this.auJ = -1;
      RecyclerView.h(this);
    }
    
    final void setFlags(int paramInt1, int paramInt2)
    {
      this.FL = (this.FL & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.aux + ", oldPos=" + this.auw + ", pLpos:" + this.auz);
      String str;
      if (lR())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.auH)
        {
          str = "[changeScrap]";
          localStringBuilder2.append(str);
        }
      }
      else
      {
        if (isInvalid()) {
          localStringBuilder1.append(" invalid");
        }
        if (!isBound()) {
          localStringBuilder1.append(" unbound");
        }
        if (lW()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (lL()) {
          localStringBuilder1.append(" ignored");
        }
        if (lX()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!mb()) {
          localStringBuilder1.append(" not recyclable(" + this.auF + ")");
        }
        if (((this.FL & 0x200) == 0) && (!isInvalid())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.auu.getParent() == null) {
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