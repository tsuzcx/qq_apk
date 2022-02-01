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
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.e.m;
import android.support.v4.os.e;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c.b;
import android.support.v4.view.a.c.c;
import android.support.v4.view.k;
import android.support.v4.view.l;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
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
  private static final int[] arL = { 16843830 };
  private static final int[] arM = { 16842987 };
  static final boolean arN;
  static final boolean arO;
  static final boolean arP;
  static final boolean arQ;
  private static final boolean arR;
  private static final boolean arS;
  private static final Class<?>[] arT;
  static final Interpolator atg;
  private final int[] UN;
  final int[] UO;
  private final Rect Zi = new Rect();
  a adj;
  private final p arU = new p();
  final n arV = new n();
  private SavedState arW;
  d arX;
  final bg arY = new bg();
  boolean arZ;
  private EdgeEffect asA;
  private EdgeEffect asB;
  f asC = new v();
  private int asD = -1;
  private int asE;
  private int asF;
  private int asG;
  private int asH;
  private j asI;
  private final int asJ;
  private final int asK;
  private float asL = 1.4E-45F;
  private float asM = 1.4E-45F;
  private boolean asN = true;
  final u asO = new u();
  ac asP;
  ac.a asQ;
  final s asR;
  private l asS;
  private List<l> asT;
  boolean asU;
  boolean asV;
  private RecyclerView.f.b asW;
  boolean asX;
  al asY;
  private d asZ;
  final Runnable asa = new Runnable()
  {
    public final void run()
    {
      if ((!RecyclerView.this.ask) || (RecyclerView.this.isLayoutRequested())) {
        return;
      }
      if (!RecyclerView.this.ash)
      {
        RecyclerView.this.requestLayout();
        return;
      }
      if (RecyclerView.this.asn)
      {
        RecyclerView.this.asm = true;
        return;
      }
      RecyclerView.this.kO();
    }
  };
  final RectF asb = new RectF();
  LayoutManager asc;
  o asd;
  final ArrayList<h> ase = new ArrayList();
  private final ArrayList<k> asf = new ArrayList();
  private k asg;
  boolean ash;
  boolean asi;
  boolean asj;
  boolean ask;
  private int asl = 0;
  boolean asm;
  public boolean asn;
  private boolean aso;
  private int asp;
  boolean asq;
  private final AccessibilityManager asr;
  public List<i> ass;
  boolean ast = false;
  boolean asu = false;
  private int asv = 0;
  private int asw = 0;
  private e asx = new e();
  private EdgeEffect asy;
  private EdgeEffect asz;
  private final int[] ata;
  private l atb;
  private final int[] atc;
  final int[] atd;
  final List<v> ate;
  private Runnable atf;
  private final bg.b ath;
  s mChildHelper;
  private int mScrollState = 0;
  final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      arN = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label169;
      }
      bool = true;
      label62:
      arO = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label174;
      }
      bool = true;
      label76:
      arP = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label179;
      }
      bool = true;
      label90:
      arQ = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label184;
      }
      bool = true;
      label104:
      arR = bool;
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
      arS = bool;
      arT = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      atg = new Interpolator()
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
    if (arQ)
    {
      localObject1 = new ac.a();
      this.asQ = ((ac.a)localObject1);
      this.asR = new s();
      this.asU = false;
      this.asV = false;
      this.asW = new g();
      this.asX = false;
      this.ata = new int[2];
      this.UN = new int[2];
      this.UO = new int[2];
      this.atc = new int[2];
      this.atd = new int[2];
      this.ate = new ArrayList();
      this.atf = new Runnable()
      {
        public final void run()
        {
          if (RecyclerView.this.asC != null) {
            RecyclerView.this.asC.jD();
          }
          RecyclerView.this.asX = false;
        }
      };
      this.ath = new bg.b()
      {
        public final void a(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView.this.arV.u(paramAnonymousv);
          RecyclerView localRecyclerView = RecyclerView.this;
          localRecyclerView.f(paramAnonymousv);
          paramAnonymousv.av(false);
          if (localRecyclerView.asC.d(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.le();
          }
        }
        
        public final void b(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          paramAnonymousv.av(false);
          if (localRecyclerView.asC.e(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.le();
          }
        }
        
        public final void c(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          paramAnonymousv.av(false);
          if (RecyclerView.this.ast) {
            if (RecyclerView.this.asC.a(paramAnonymousv, paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
              RecyclerView.this.le();
            }
          }
          while (!RecyclerView.this.asC.f(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            return;
          }
          RecyclerView.this.le();
        }
        
        public final void j(RecyclerView.v paramAnonymousv)
        {
          RecyclerView.this.asc.removeAndRecycleView(paramAnonymousv.aus, RecyclerView.this.arV);
        }
      };
      if (paramAttributeSet == null) {
        break label693;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, arM, paramInt, 0);
      this.arZ = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label358:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.asL = android.support.v4.view.v.a((ViewConfiguration)localObject1, paramContext);
      this.asM = android.support.v4.view.v.b((ViewConfiguration)localObject1, paramContext);
      this.asJ = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.asK = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
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
      this.asC.atl = this.asW;
      this.arX = new d(new d.a()
      {
        private void f(d.b paramAnonymousb)
        {
          switch (paramAnonymousb.EX)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            return;
          case 1: 
            RecyclerView.this.asc.onItemsAdded(RecyclerView.this, paramAnonymousb.ajZ, paramAnonymousb.akb);
            return;
          case 2: 
            RecyclerView.this.asc.onItemsRemoved(RecyclerView.this, paramAnonymousb.ajZ, paramAnonymousb.akb);
            return;
          case 4: 
            RecyclerView.this.asc.onItemsUpdated(RecyclerView.this, paramAnonymousb.ajZ, paramAnonymousb.akb, paramAnonymousb.aka);
            return;
          }
          RecyclerView.this.asc.onItemsMoved(RecyclerView.this, paramAnonymousb.ajZ, paramAnonymousb.akb, 1);
        }
        
        public final void N(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, true);
          RecyclerView.this.asU = true;
          RecyclerView.s locals = RecyclerView.this.asR;
          locals.aua += paramAnonymousInt2;
        }
        
        public final void O(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, false);
          RecyclerView.this.asU = true;
        }
        
        public final void P(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          RecyclerView localRecyclerView = RecyclerView.this;
          int j = localRecyclerView.mChildHelper.jA();
          int i = 0;
          while (i < j)
          {
            localObject = RecyclerView.bv(localRecyclerView.mChildHelper.bM(i));
            if ((localObject != null) && (!((RecyclerView.v)localObject).lP()) && (((RecyclerView.v)localObject).mPosition >= paramAnonymousInt1))
            {
              ((RecyclerView.v)localObject).m(paramAnonymousInt2, false);
              localRecyclerView.asR.aud = true;
            }
            i += 1;
          }
          Object localObject = localRecyclerView.arV;
          j = ((RecyclerView.n)localObject).atH.size();
          i = 0;
          while (i < j)
          {
            RecyclerView.v localv = (RecyclerView.v)((RecyclerView.n)localObject).atH.get(i);
            if ((localv != null) && (localv.mPosition >= paramAnonymousInt1)) {
              localv.m(paramAnonymousInt2, true);
            }
            i += 1;
          }
          localRecyclerView.requestLayout();
          RecyclerView.this.asU = true;
        }
        
        public final void Q(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int n = -1;
          RecyclerView localRecyclerView = RecyclerView.this;
          int i1 = localRecyclerView.mChildHelper.jA();
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
            localObject = RecyclerView.bv(localRecyclerView.mChildHelper.bM(m));
            if ((localObject != null) && (((RecyclerView.v)localObject).mPosition >= k) && (((RecyclerView.v)localObject).mPosition <= j))
            {
              if (((RecyclerView.v)localObject).mPosition != paramAnonymousInt1) {
                break label129;
              }
              ((RecyclerView.v)localObject).m(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            localRecyclerView.asR.aud = true;
            m += 1;
            break label35;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label129:
            ((RecyclerView.v)localObject).m(i, false);
          }
          label139:
          Object localObject = localRecyclerView.arV;
          label173:
          RecyclerView.v localv;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            i = n;
            n = ((RecyclerView.n)localObject).atH.size();
            m = 0;
            if (m >= n) {
              break label268;
            }
            localv = (RecyclerView.v)((RecyclerView.n)localObject).atH.get(m);
            if ((localv != null) && (localv.mPosition >= k) && (localv.mPosition <= j))
            {
              if (localv.mPosition != paramAnonymousInt1) {
                break label258;
              }
              localv.m(paramAnonymousInt2 - paramAnonymousInt1, false);
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
            localv.m(i, false);
          }
          label268:
          localRecyclerView.requestLayout();
          RecyclerView.this.asU = true;
        }
        
        public final RecyclerView.v bG(int paramAnonymousInt)
        {
          RecyclerView.v localv = RecyclerView.this.k(paramAnonymousInt, true);
          if (localv == null) {}
          while (RecyclerView.this.mChildHelper.bh(localv.aus)) {
            return null;
          }
          return localv;
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          Object localObject = RecyclerView.this;
          int j = ((RecyclerView)localObject).mChildHelper.jA();
          int i = 0;
          while (i < j)
          {
            View localView = ((RecyclerView)localObject).mChildHelper.bM(i);
            RecyclerView.v localv = RecyclerView.bv(localView);
            if ((localv != null) && (!localv.lP()) && (localv.mPosition >= paramAnonymousInt1) && (localv.mPosition < paramAnonymousInt1 + paramAnonymousInt2))
            {
              localv.addFlags(2);
              localv.O(paramAnonymousObject);
              ((RecyclerView.LayoutParams)localView.getLayoutParams()).atx = true;
            }
            i += 1;
          }
          paramAnonymousObject = ((RecyclerView)localObject).arV;
          i = paramAnonymousObject.atH.size() - 1;
          while (i >= 0)
          {
            localObject = (RecyclerView.v)paramAnonymousObject.atH.get(i);
            if (localObject != null)
            {
              j = ((RecyclerView.v)localObject).mPosition;
              if ((j >= paramAnonymousInt1) && (j < paramAnonymousInt1 + paramAnonymousInt2))
              {
                ((RecyclerView.v)localObject).addFlags(2);
                paramAnonymousObject.cr(i);
              }
            }
            i -= 1;
          }
          RecyclerView.this.asV = true;
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
      this.mChildHelper = new s(new s.b()
      {
        public final void addView(View paramAnonymousView, int paramAnonymousInt)
        {
          RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
          RecyclerView localRecyclerView = RecyclerView.this;
          RecyclerView.v localv = RecyclerView.bv(paramAnonymousView);
          if ((localRecyclerView.adj != null) && (localv != null)) {
            localRecyclerView.adj.k(localv);
          }
          if (localRecyclerView.ass != null)
          {
            paramAnonymousInt = localRecyclerView.ass.size() - 1;
            while (paramAnonymousInt >= 0)
            {
              ((RecyclerView.i)localRecyclerView.ass.get(paramAnonymousInt)).bD(paramAnonymousView);
              paramAnonymousInt -= 1;
            }
          }
        }
        
        public final void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
        {
          RecyclerView.v localv = RecyclerView.bv(paramAnonymousView);
          if (localv != null)
          {
            if ((!localv.mb()) && (!localv.lP())) {
              throw new IllegalArgumentException("Called attach on a child which is not detached: " + localv + RecyclerView.this.kL());
            }
            localv.lZ();
          }
          RecyclerView.a(RecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
        }
        
        public final RecyclerView.v bi(View paramAnonymousView)
        {
          return RecyclerView.bv(paramAnonymousView);
        }
        
        public final void bj(View paramAnonymousView)
        {
          paramAnonymousView = RecyclerView.bv(paramAnonymousView);
          RecyclerView localRecyclerView;
          if (paramAnonymousView != null)
          {
            localRecyclerView = RecyclerView.this;
            if (paramAnonymousView.auH == -1) {
              break label38;
            }
          }
          label38:
          for (paramAnonymousView.auG = paramAnonymousView.auH;; paramAnonymousView.auG = u.Y(paramAnonymousView.aus))
          {
            localRecyclerView.b(paramAnonymousView, 4);
            return;
          }
        }
        
        public final void bk(View paramAnonymousView)
        {
          paramAnonymousView = RecyclerView.bv(paramAnonymousView);
          if (paramAnonymousView != null)
          {
            RecyclerView.this.b(paramAnonymousView, paramAnonymousView.auG);
            paramAnonymousView.auG = 0;
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
              if ((((RecyclerView.v)localObject).mb()) && (!((RecyclerView.v)localObject).lP())) {
                throw new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.kL());
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
      if (u.T(this) == 0) {
        u.U(this);
      }
      if (u.Y(this) == 0) {
        u.p(this, 1);
      }
      this.asr = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new al(this));
      if (paramAttributeSet == null) {
        break label1272;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(7);
      if (((TypedArray)localObject1).getInt(1, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.asj = ((TypedArray)localObject1).getBoolean(2, false);
      if (!this.asj) {
        break label757;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(5);
      localObject4 = ((TypedArray)localObject1).getDrawable(6);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(3);
      localDrawable = ((TypedArray)localObject1).getDrawable(4);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label707;
      }
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + kL());
      localObject1 = null;
      break;
      this.arZ = true;
      break label358;
    }
    label707:
    Resources localResources = getContext().getResources();
    new z(this, (StateListDrawable)localObject3, (Drawable)localObject4, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(2131166330), localResources.getDimensionPixelSize(2131166332), localResources.getDimensionPixelOffset(2131166331));
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
          localObject4 = ((ClassLoader)localObject2).loadClass((String)localObject1).asSubclass(LayoutManager.class);
        }
        try
        {
          localObject3 = ((Class)localObject4).getConstructor(arT);
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
        setLayoutManager((LayoutManager)((Constructor)localObject3).newInstance((Object[])localObject2));
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arL, paramInt, 0);
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
  
  private void a(long paramLong, v paramv1, v paramv2)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.mChildHelper.getChildAt(i));
      if ((localv != paramv1) && (g(localv) == paramLong))
      {
        if ((this.adj != null) && (this.adj.atk)) {
          throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + kL());
        }
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + kL());
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramv2).append(" cannot be found but it is necessary for ").append(paramv1).append(kL());
  }
  
  private void a(v paramv1, v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramv1.av(false);
    if (paramBoolean1) {
      f(paramv1);
    }
    if (paramv1 != paramv2)
    {
      if (paramBoolean2) {
        f(paramv2);
      }
      paramv1.auy = paramv2;
      f(paramv1);
      this.arV.u(paramv1);
      paramv2.av(false);
      paramv2.auz = paramv1;
    }
    if (this.asC.a(paramv1, paramv2, paramc1, paramc2)) {
      le();
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    kO();
    int i;
    int j;
    int k;
    int m;
    if (this.adj != null)
    {
      b(paramInt1, paramInt2, this.atd);
      i = this.atd[0];
      j = this.atd[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.ase.isEmpty()) {
        invalidate();
      }
      if (a(i, j, k, m, this.UN, 0))
      {
        this.asG -= this.UN[0];
        this.asH -= this.UN[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.UN[0], this.UN[1]);
        }
        paramMotionEvent = this.atc;
        paramMotionEvent[0] += this.UN[0];
        paramMotionEvent = this.atc;
        paramMotionEvent[1] += this.UN[1];
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          ap(i, j);
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
          if ((paramMotionEvent != null) && (!android.support.v4.view.i.h(paramMotionEvent))) {
            h(paramMotionEvent.getX(), k, paramMotionEvent.getY(), m);
          }
          al(paramInt1, paramInt2);
        }
      }
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
  }
  
  private boolean ao(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    m(this.ata);
    if ((this.ata[0] != paramInt1) || (this.ata[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  static v bv(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).atw;
  }
  
  public static int bw(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lR();
    }
    return -1;
  }
  
  public static int bx(View paramView)
  {
    paramView = bv(paramView);
    if (paramView != null) {
      return paramView.lQ();
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
  
  static void c(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.apS;
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
  
  private void f(s params)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.asO.UD;
      params.aum = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      params.aun = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    params.aum = 0;
    params.aun = 0;
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
        if (!((LayoutParams)localObject).atx)
        {
          localObject = ((LayoutParams)localObject).apS;
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
      localObject = this.asc;
      localRect = this.mTempRect;
      if (this.ask) {
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
      ((LayoutManager)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool1, bool2);
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
    if (this.adj.atk) {
      return paramv.auv;
    }
    return paramv.mPosition;
  }
  
  public static void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
  {
    c(paramView, paramRect);
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      kT();
      android.support.v4.widget.i.a(this.asy, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      kV();
      android.support.v4.widget.i.a(this.asz, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        u.X(this);
      }
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      kU();
      android.support.v4.widget.i.a(this.asA, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        kW();
        android.support.v4.widget.i.a(this.asB, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  static void h(v paramv)
  {
    Object localObject;
    if (paramv.aut != null) {
      localObject = (View)paramv.aut.get();
    }
    while (localObject != null)
    {
      if (localObject == paramv.aus) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramv.aut = null;
  }
  
  private void kR()
  {
    this.asO.stop();
    if (this.asc != null) {
      this.asc.stopSmoothScroller();
    }
  }
  
  private void kS()
  {
    boolean bool2 = false;
    if (this.asy != null)
    {
      this.asy.onRelease();
      bool2 = this.asy.isFinished();
    }
    boolean bool1 = bool2;
    if (this.asz != null)
    {
      this.asz.onRelease();
      bool1 = bool2 | this.asz.isFinished();
    }
    bool2 = bool1;
    if (this.asA != null)
    {
      this.asA.onRelease();
      bool2 = bool1 | this.asA.isFinished();
    }
    bool1 = bool2;
    if (this.asB != null)
    {
      this.asB.onRelease();
      bool1 = bool2 | this.asB.isFinished();
    }
    if (bool1) {
      u.X(this);
    }
  }
  
  private void kT()
  {
    if (this.asy != null) {
      return;
    }
    this.asy = e.d(this);
    if (this.arZ)
    {
      this.asy.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.asy.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kU()
  {
    if (this.asA != null) {
      return;
    }
    this.asA = e.d(this);
    if (this.arZ)
    {
      this.asA.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.asA.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void kV()
  {
    if (this.asz != null) {
      return;
    }
    this.asz = e.d(this);
    if (this.arZ)
    {
      this.asz.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.asz.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void kW()
  {
    if (this.asB != null) {
      return;
    }
    this.asB = e.d(this);
    if (this.arZ)
    {
      this.asB.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.asB.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void kX()
  {
    this.asB = null;
    this.asz = null;
    this.asA = null;
    this.asy = null;
  }
  
  private void kY()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    aM(0);
    kS();
  }
  
  private void kZ()
  {
    kY();
    setScrollState(0);
  }
  
  private void l(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.asD) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.asD = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.asG = j;
      this.asE = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.asH = i;
      this.asF = i;
      return;
    }
  }
  
  private void lc()
  {
    int i = this.asp;
    this.asp = 0;
    if ((i != 0) && (lb()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      android.support.v4.view.a.a.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private boolean lf()
  {
    return (this.asC != null) && (this.asc.supportsPredictiveItemAnimations());
  }
  
  private void lg()
  {
    boolean bool2 = true;
    if (this.ast)
    {
      this.arX.reset();
      if (this.asu) {
        this.asc.onItemsChanged(this);
      }
    }
    int i;
    label61:
    s locals;
    if (lf())
    {
      this.arX.ja();
      if ((!this.asU) && (!this.asV)) {
        break label180;
      }
      i = 1;
      locals = this.asR;
      if ((!this.ask) || (this.asC == null) || ((!this.ast) && (i == 0) && (!this.asc.mRequestedSimpleAnimations)) || ((this.ast) && (!this.adj.atk))) {
        break label185;
      }
      bool1 = true;
      label121:
      locals.auh = bool1;
      locals = this.asR;
      if ((!this.asR.auh) || (i == 0) || (this.ast) || (!lf())) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locals.aui = bool1;
      return;
      this.arX.jd();
      break;
      i = 0;
      break label61;
      bool1 = false;
      break label121;
    }
  }
  
  private void lh()
  {
    if (this.adj == null) {}
    while (this.asc == null) {
      return;
    }
    this.asR.aug = false;
    if (this.asR.aub == 1)
    {
      ll();
      this.asc.setExactMeasureSpecsFrom(this);
      lm();
    }
    for (;;)
    {
      ln();
      return;
      if ((this.arX.je()) || (this.asc.getWidth() != getWidth()) || (this.asc.getHeight() != getHeight()))
      {
        this.asc.setExactMeasureSpecsFrom(this);
        lm();
      }
      else
      {
        this.asc.setExactMeasureSpecsFrom(this);
      }
    }
  }
  
  private void li()
  {
    if ((this.asN) && (hasFocus()) && (this.adj != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = bu((View)localObject1))
      {
        lj();
        return;
      }
      Object localObject2 = this.asR;
      long l;
      int i;
      if (this.adj.atk)
      {
        l = ((v)localObject1).auv;
        ((s)localObject2).auk = l;
        localObject2 = this.asR;
        if (!this.ast) {
          break label191;
        }
        i = -1;
      }
      s locals;
      for (;;)
      {
        ((s)localObject2).auj = i;
        locals = this.asR;
        localObject1 = ((v)localObject1).aus;
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
          i = ((v)localObject1).auu;
        } else {
          i = ((v)localObject1).lR();
        }
      }
      locals.aul = i;
      return;
    }
  }
  
  private void lj()
  {
    this.asR.auk = -1L;
    this.asR.auj = -1;
    this.asR.aul = -1;
  }
  
  private void lk()
  {
    View localView = null;
    if ((!this.asN) || (this.adj == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject = getFocusedChild();
      if ((arS) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.mChildHelper.getChildCount() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.mChildHelper.bh((View)localObject));
    if ((this.asR.auk != -1L) && (this.adj.atk)) {}
    for (Object localObject = m(this.asR.auk);; localObject = null)
    {
      int i;
      label216:
      int k;
      int j;
      if ((localObject == null) || (this.mChildHelper.bh(((v)localObject).aus)) || (!((v)localObject).aus.hasFocusable()))
      {
        localObject = localView;
        if (this.mChildHelper.getChildCount() > 0)
        {
          if (this.asR.auj != -1)
          {
            i = this.asR.auj;
            k = this.asR.getItemCount();
            j = i;
            label226:
            if (j >= k) {
              break label331;
            }
            localObject = ch(j);
            if (localObject == null) {
              break label331;
            }
            if (!((v)localObject).aus.hasFocusable()) {
              break label324;
            }
            localObject = ((v)localObject).aus;
          }
        }
        else
        {
          label261:
          if (localObject == null) {
            break label397;
          }
          if (this.asR.aul == -1L) {
            break label399;
          }
          localView = ((View)localObject).findViewById(this.asR.aul);
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
          localObject = ch(i);
          if (localObject == null) {
            break label383;
          }
          if (((v)localObject).aus.hasFocusable())
          {
            localObject = ((v)localObject).aus;
            break;
          }
          i -= 1;
        }
        label383:
        localObject = null;
        break label261;
        localObject = ((v)localObject).aus;
        break label261;
        break;
      }
    }
  }
  
  private void ll()
  {
    this.asR.cu(1);
    f(this.asR);
    this.asR.aug = false;
    kP();
    this.arY.clear();
    la();
    lg();
    li();
    Object localObject = this.asR;
    if ((this.asR.auh) && (this.asV)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((s)localObject).auf = bool;
      this.asV = false;
      this.asU = false;
      this.asR.aue = this.asR.aui;
      this.asR.auc = this.adj.getItemCount();
      m(this.ata);
      if (!this.asR.auh) {
        break;
      }
      j = this.mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bv(this.mChildHelper.getChildAt(i));
        if ((!((v)localObject).lP()) && ((!((v)localObject).isInvalid()) || (this.adj.atk)))
        {
          localc = this.asC.a(this.asR, (v)localObject, f.m((v)localObject), ((v)localObject).me());
          this.arY.b((v)localObject, localc);
          if ((this.asR.auf) && (((v)localObject).mh()) && (!((v)localObject).isRemoved()) && (!((v)localObject).lP()) && (!((v)localObject).isInvalid()))
          {
            long l = g((v)localObject);
            this.arY.a(l, (v)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.asR.aui)
    {
      lp();
      bool = this.asR.aud;
      this.asR.aud = false;
      this.asc.onLayoutChildren(this.arV, this.asR);
      this.asR.aud = bool;
      i = 0;
      if (i < this.mChildHelper.getChildCount())
      {
        localObject = bv(this.mChildHelper.getChildAt(i));
        if ((!((v)localObject).lP()) && (!this.arY.H((v)localObject)))
        {
          int k = f.m((v)localObject);
          bool = ((v)localObject).cv(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.asC.a(this.asR, (v)localObject, j, ((v)localObject).me());
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
          this.arY.c((v)localObject, localc);
        }
      }
      lq();
    }
    for (;;)
    {
      as(true);
      ar(false);
      this.asR.aub = 2;
      return;
      lq();
    }
  }
  
  private void lm()
  {
    kP();
    la();
    this.asR.cu(6);
    this.arX.jd();
    this.asR.auc = this.adj.getItemCount();
    this.asR.aua = 0;
    this.asR.aue = false;
    this.asc.onLayoutChildren(this.arV, this.asR);
    this.asR.aud = false;
    this.arW = null;
    s locals = this.asR;
    if ((this.asR.auh) && (this.asC != null)) {}
    for (boolean bool = true;; bool = false)
    {
      locals.auh = bool;
      this.asR.aub = 4;
      as(true);
      ar(false);
      return;
    }
  }
  
  private void ln()
  {
    this.asR.cu(4);
    kP();
    la();
    this.asR.aub = 1;
    if (this.asR.auh)
    {
      int i = this.mChildHelper.getChildCount() - 1;
      if (i >= 0)
      {
        v localv1 = bv(this.mChildHelper.getChildAt(i));
        RecyclerView.f.c localc2;
        v localv2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localv1.lP())
        {
          long l = g(localv1);
          localc2 = new RecyclerView.f.c().c(localv1, 0);
          localv2 = this.arY.n(l);
          if ((localv2 == null) || (localv2.lP())) {
            break label224;
          }
          bool1 = this.arY.G(localv2);
          bool2 = this.arY.G(localv1);
          if ((bool1) && (localv2 == localv1)) {
            break label224;
          }
          localc1 = this.arY.d(localv2, 4);
          this.arY.d(localv1, localc2);
          localc2 = this.arY.d(localv1, 8);
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
          this.arY.d(localv1, localc2);
        }
      }
      this.arY.a(this.ath);
    }
    this.asc.removeAndRecycleScrapInt(this.arV);
    this.asR.atZ = this.asR.auc;
    this.ast = false;
    this.asu = false;
    this.asR.auh = false;
    this.asR.aui = false;
    this.asc.mRequestedSimpleAnimations = false;
    if (this.arV.atG != null) {
      this.arV.atG.clear();
    }
    if (this.asc.mPrefetchMaxObservedInInitialPrefetch)
    {
      this.asc.mPrefetchMaxCountObserved = 0;
      this.asc.mPrefetchMaxObservedInInitialPrefetch = false;
      this.arV.lI();
    }
    this.asc.onLayoutCompleted(this.asR);
    as(true);
    ar(false);
    this.arY.clear();
    if (ao(this.ata[0], this.ata[1])) {
      ap(0, 0);
    }
    lk();
    lj();
  }
  
  private void lp()
  {
    int j = this.mChildHelper.jA();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.mChildHelper.bM(i));
      if (!localv.lP()) {
        localv.lO();
      }
      i += 1;
    }
  }
  
  private void lq()
  {
    int j = this.mChildHelper.jA();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.mChildHelper.bM(i));
      if (!localv.lP()) {
        localv.lN();
      }
      i += 1;
    }
    this.arV.lq();
  }
  
  private void lr()
  {
    int j = this.mChildHelper.jA();
    int i = 0;
    while (i < j)
    {
      v localv = bv(this.mChildHelper.bM(i));
      if ((localv != null) && (!localv.lP())) {
        localv.addFlags(6);
      }
      i += 1;
    }
    lo();
    this.arV.lr();
  }
  
  private void lu()
  {
    int i = this.ate.size() - 1;
    while (i >= 0)
    {
      v localv = (v)this.ate.get(i);
      if ((localv.aus.getParent() == this) && (!localv.lP()))
      {
        int j = localv.auH;
        if (j != -1)
        {
          u.p(localv.aus, j);
          localv.auH = -1;
        }
      }
      i -= 1;
    }
    this.ate.clear();
  }
  
  private void m(int[] paramArrayOfInt)
  {
    int i2 = this.mChildHelper.getChildCount();
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
      v localv = bv(this.mChildHelper.getChildAt(n));
      m = i;
      if (localv.lP()) {
        break label122;
      }
      int i1 = localv.lQ();
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
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    if (this.asc == null) {}
    for (;;)
    {
      return;
      if (!this.asn)
      {
        if (!this.asc.canScrollHorizontally()) {
          paramInt1 = 0;
        }
        if (!this.asc.canScrollVertically()) {
          paramInt2 = i;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          u localu = this.asO;
          i = localu.az(paramInt1, paramInt2);
          Interpolator localInterpolator = paramInterpolator;
          if (paramInterpolator == null) {
            localInterpolator = atg;
          }
          localu.b(paramInt1, paramInt2, i, localInterpolator);
          return;
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    if (this.asc != null) {
      this.asc.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.ase.isEmpty()) {
      setWillNotDraw(false);
    }
    this.ase.add(paramh);
    lo();
    requestLayout();
  }
  
  public final void a(i parami)
  {
    if (this.ass == null) {
      this.ass = new ArrayList();
    }
    this.ass.add(parami);
  }
  
  public final void a(k paramk)
  {
    this.asf.add(paramk);
  }
  
  public final void a(l paraml)
  {
    if (this.asT == null) {
      this.asT = new ArrayList();
    }
    this.asT.add(paraml);
  }
  
  final void a(v paramv, RecyclerView.f.c paramc)
  {
    paramv.setFlags(0, 8192);
    if ((this.asR.auf) && (paramv.mh()) && (!paramv.isRemoved()) && (!paramv.lP()))
    {
      long l = g(paramv);
      this.arY.a(l, paramv);
    }
    this.arY.b(paramv, paramc);
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
    if ((this.asc == null) || (!this.asc.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean ak(int paramInt1, int paramInt2)
  {
    if (this.asc == null) {}
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
        } while (this.asn);
        bool2 = this.asc.canScrollHorizontally();
        bool3 = this.asc.canScrollVertically();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.asJ) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.asJ) {}
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
        if ((this.asI == null) || (!this.asI.av(i, j))) {
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
      paramInt1 = Math.max(-this.asK, Math.min(i, this.asK));
      paramInt2 = Math.max(-this.asK, Math.min(j, this.asK));
      u localu = this.asO;
      localu.ati.setScrollState(2);
      localu.aup = 0;
      localu.auo = 0;
      localu.UD.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localu.lM();
      return true;
    }
  }
  
  final void al(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.asy != null)
    {
      bool1 = bool2;
      if (!this.asy.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.asy.onRelease();
          bool1 = this.asy.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.asA != null)
    {
      bool2 = bool1;
      if (!this.asA.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.asA.onRelease();
          bool2 = bool1 | this.asA.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.asz != null)
    {
      bool1 = bool2;
      if (!this.asz.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.asz.onRelease();
          bool1 = bool2 | this.asz.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.asB != null)
    {
      bool2 = bool1;
      if (!this.asB.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.asB.onRelease();
          bool2 = bool1 | this.asB.isFinished();
        }
      }
    }
    if (bool2) {
      u.X(this);
    }
  }
  
  final void am(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      kT();
      this.asy.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      kV();
      this.asz.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        u.X(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      kU();
      this.asA.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        kW();
        this.asB.onAbsorb(paramInt2);
      }
    }
  }
  
  final void an(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), u.af(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), u.ag(this)));
  }
  
  final void ap(int paramInt1, int paramInt2)
  {
    this.asw += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.asS != null) {
      this.asS.onScrolled(this, paramInt1, paramInt2);
    }
    if (this.asT != null)
    {
      i = this.asT.size() - 1;
      while (i >= 0)
      {
        ((l)this.asT.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.asw -= 1;
  }
  
  final void ar(boolean paramBoolean)
  {
    if (this.asl <= 0) {
      this.asl = 1;
    }
    if ((!paramBoolean) && (!this.asn)) {
      this.asm = false;
    }
    if (this.asl == 1)
    {
      if ((paramBoolean) && (this.asm) && (!this.asn) && (this.asc != null) && (this.adj != null)) {
        lh();
      }
      if (!this.asn) {
        this.asm = false;
      }
    }
    this.asl -= 1;
  }
  
  final void as(boolean paramBoolean)
  {
    this.asv -= 1;
    if (this.asv <= 0)
    {
      this.asv = 0;
      if (paramBoolean)
      {
        lc();
        lu();
      }
    }
  }
  
  final void assertInLayoutOrScroll(String paramString)
  {
    if (!ld())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + kL());
      }
      throw new IllegalStateException(paramString + kL());
    }
  }
  
  final void assertNotInLayoutOrScroll(String paramString)
  {
    if (ld())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + kL());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.asw > 0) {
      new IllegalStateException(kL());
    }
  }
  
  final void at(boolean paramBoolean)
  {
    this.asu |= paramBoolean;
    this.ast = true;
    lr();
  }
  
  final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    kP();
    la();
    e.beginSection("RV Scroll");
    f(this.asR);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.asc.scrollHorizontallyBy(paramInt1, this.arV, this.asR);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.asc.scrollVerticallyBy(paramInt2, this.arV, this.asR);; paramInt2 = 0)
      {
        e.endSection();
        int j = this.mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.mChildHelper.getChildAt(i);
          Object localObject = bi(localView);
          if ((localObject != null) && (((v)localObject).auz != null))
          {
            localObject = ((v)localObject).auz.aus;
            int k = localView.getLeft();
            int m = localView.getTop();
            if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
              ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
            }
          }
          i += 1;
        }
        as(true);
        ar(false);
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
  
  public final void b(k paramk)
  {
    this.asf.remove(paramk);
    if (this.asg == paramk) {
      this.asg = null;
    }
  }
  
  public final void b(l paraml)
  {
    if (this.asT != null) {
      this.asT.remove(paraml);
    }
  }
  
  final boolean b(v paramv, int paramInt)
  {
    if (ld())
    {
      paramv.auH = paramInt;
      this.ate.add(paramv);
      return false;
    }
    u.p(paramv.aus, paramInt);
    return true;
  }
  
  final void bA(View paramView)
  {
    v localv = bv(paramView);
    if ((this.adj != null) && (localv != null)) {
      this.adj.l(localv);
    }
    if (this.ass != null)
    {
      int i = this.ass.size() - 1;
      while (i >= 0)
      {
        ((i)this.ass.get(i)).bE(paramView);
        i -= 1;
      }
    }
  }
  
  public final v bi(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return bv(paramView);
  }
  
  public final v bu(View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    return bi(paramView);
  }
  
  final Rect by(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.atx) {
      return localLayoutParams.apS;
    }
    if ((this.asR.aue) && ((localLayoutParams.atw.mh()) || (localLayoutParams.atw.isInvalid()))) {
      return localLayoutParams.apS;
    }
    Rect localRect = localLayoutParams.apS;
    localRect.set(0, 0, 0, 0);
    int j = this.ase.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((h)this.ase.get(i)).a(this.mTempRect, paramView, this, this.asR);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.atx = false;
    return localRect;
  }
  
  public final void c(h paramh)
  {
    if (this.asc != null) {
      this.asc.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.ase.remove(paramh);
    if (this.ase.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      lo();
      requestLayout();
      return;
    }
  }
  
  final void cf(int paramInt)
  {
    if (this.asc == null) {
      return;
    }
    LayoutManager localLayoutManager = this.asc;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, locala.axQ(), "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  public final v cg(int paramInt)
  {
    return k(paramInt, false);
  }
  
  public final v ch(int paramInt)
  {
    Object localObject = null;
    if (this.ast) {}
    int i;
    v localv;
    do
    {
      return localObject;
      int j = this.mChildHelper.jA();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localv = bv(this.mChildHelper.bM(i));
      if ((localv == null) || (localv.isRemoved()) || (i(localv) != paramInt)) {
        break label100;
      }
      localObject = localv;
    } while (!this.mChildHelper.bh(localv.aus));
    localObject = localv;
    label100:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.asc.checkLayoutParams((LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.asc == null) {}
    while (!this.asc.canScrollHorizontally()) {
      return 0;
    }
    return this.asc.computeHorizontalScrollExtent(this.asR);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.asc == null) {}
    while (!this.asc.canScrollHorizontally()) {
      return 0;
    }
    return this.asc.computeHorizontalScrollOffset(this.asR);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.asc == null) {}
    while (!this.asc.canScrollHorizontally()) {
      return 0;
    }
    return this.asc.computeHorizontalScrollRange(this.asR);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.asc == null) {}
    while (!this.asc.canScrollVertically()) {
      return 0;
    }
    return this.asc.computeVerticalScrollExtent(this.asR);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.asc == null) {}
    while (!this.asc.canScrollVertically()) {
      return 0;
    }
    return this.asc.computeVerticalScrollOffset(this.asR);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.asc == null) {}
    while (!this.asc.canScrollVertically()) {
      return 0;
    }
    return this.asc.computeVerticalScrollRange(this.asR);
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
    int j = this.ase.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.ase.get(i)).b(paramCanvas, this, this.asR);
      i += 1;
    }
    int n;
    if ((this.asy != null) && (!this.asy.isFinished()))
    {
      n = paramCanvas.save();
      if (this.arZ)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.asy == null) || (!this.asy.draw(paramCanvas))) {
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
      if (this.asz != null)
      {
        i = j;
        if (!this.asz.isFinished())
        {
          n = paramCanvas.save();
          if (this.arZ) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.asz == null) || (!this.asz.draw(paramCanvas))) {
            break label461;
          }
          i = 1;
          label202:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.asA != null)
      {
        j = i;
        if (!this.asA.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.arZ) {
            break label466;
          }
          j = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.asA == null) || (!this.asA.draw(paramCanvas))) {
            break label471;
          }
          j = 1;
          label295:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.asB != null)
      {
        i = j;
        if (!this.asB.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.arZ) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i = m;
          if (this.asB != null)
          {
            i = m;
            if (this.asB.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.asC != null) && (this.ase.size() > 0) && (this.asC.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          u.X(this);
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
    int j = this.mChildHelper.jA();
    int i = 0;
    if (i < j)
    {
      localObject = bv(this.mChildHelper.bM(i));
      if ((localObject != null) && (!((v)localObject).lP()))
      {
        if (((v)localObject).mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((v)localObject).m(-paramInt2, paramBoolean);
        this.asR.aud = true;
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
          ((v)localObject).m(k, paramBoolean);
          ((v)localObject).mPosition = (paramInt1 - 1);
          this.asR.aud = true;
        }
      }
    }
    Object localObject = this.arV;
    i = ((n)localObject).atH.size() - 1;
    if (i >= 0)
    {
      v localv = (v)((n)localObject).atH.get(i);
      if (localv != null)
      {
        if (localv.mPosition < paramInt1 + paramInt2) {
          break label200;
        }
        localv.m(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label200:
        if (localv.mPosition >= paramInt1)
        {
          localv.addFlags(8);
          ((n)localObject).cr(i);
        }
      }
    }
    requestLayout();
  }
  
  final void f(v paramv)
  {
    View localView = paramv.aus;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.arV.u(bi(localView));
      if (!paramv.mb()) {
        break;
      }
      this.mChildHelper.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.a(localView, -1, true);
      return;
    }
    paramv = this.mChildHelper;
    i = paramv.alX.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
    }
    paramv.alY.set(i);
    paramv.bf(localView);
  }
  
  public final View findContainingItemView(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    Object localObject = this.asc.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return localObject;
    }
    int i;
    label93:
    int k;
    if ((this.adj != null) && (this.asc != null) && (!ld()) && (!this.asn))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label343;
      }
      if (!this.asc.canScrollVertically()) {
        break label1003;
      }
      if (paramInt != 2) {
        break label241;
      }
      i = 130;
      if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
        break label247;
      }
      k = 1;
      label107:
      j = k;
      if (arR) {
        paramInt = i;
      }
    }
    label165:
    label173:
    label183:
    label343:
    label613:
    label998:
    label1003:
    for (int j = k;; j = 0)
    {
      int m = j;
      k = paramInt;
      if (j == 0)
      {
        m = j;
        k = paramInt;
        if (this.asc.canScrollHorizontally())
        {
          if (this.asc.getLayoutDirection() != 1) {
            break label253;
          }
          i = 1;
          if (paramInt != 2) {
            break label258;
          }
          j = 1;
          if ((j ^ i) == 0) {
            break label264;
          }
          i = 66;
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
            break label270;
          }
        }
      }
      for (j = 1;; j = 0)
      {
        m = j;
        k = paramInt;
        if (arR)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label304;
        }
        kO();
        if (findContainingItemView(paramView) != null) {
          break label276;
        }
        return null;
        i = 0;
        break;
        label241:
        i = 33;
        break label93;
        label247:
        k = 0;
        break label107;
        label253:
        i = 0;
        break label165;
        j = 0;
        break label173;
        i = 17;
        break label183;
      }
      kP();
      this.asc.onFocusSearchFailed(paramView, k, this.arV, this.asR);
      ar(false);
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
              kO();
              if (findContainingItemView(paramView) == null) {
                return null;
              }
              kP();
              localObject = this.asc.onFocusSearchFailed(paramView, paramInt, this.arV, this.asR);
              ar(false);
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
          break label457;
        }
        paramInt = n;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          return localObject;
          paramInt = n;
          if (findContainingItemView((View)localObject) != null) {
            if (paramView == null)
            {
              paramInt = 1;
            }
            else if (findContainingItemView(paramView) == null)
            {
              paramInt = 1;
            }
            else
            {
              this.mTempRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
              this.Zi.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.Zi);
              if (this.asc.getLayoutDirection() == 1)
              {
                m = -1;
                if (((this.mTempRect.left >= this.Zi.left) && (this.mTempRect.right > this.Zi.left)) || (this.mTempRect.right >= this.Zi.right)) {
                  break label767;
                }
                i = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (((this.mTempRect.top < this.Zi.top) || (this.mTempRect.bottom <= this.Zi.top)) && (this.mTempRect.bottom < this.Zi.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            throw new IllegalArgumentException("Invalid direction: " + k + kL());
            m = 1;
            break label560;
            label767:
            if (((this.mTempRect.right <= this.Zi.right) && (this.mTempRect.left < this.Zi.right)) || (this.mTempRect.left <= this.Zi.left)) {
              break label998;
            }
            i = -1;
            break label613;
            if ((this.mTempRect.bottom > this.Zi.bottom) || (this.mTempRect.top >= this.Zi.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.Zi.top) {}
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
    if (this.asc == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kL());
    }
    return this.asc.generateDefaultLayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.asc == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kL());
    }
    return this.asc.generateLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.asc == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + kL());
    }
    return this.asc.generateLayoutParams(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.adj;
  }
  
  public int getBaseline()
  {
    if (this.asc != null) {
      return this.asc.getBaseline();
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.asZ == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.asZ.au(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return this.arZ;
  }
  
  public al getCompatAccessibilityDelegate()
  {
    return this.asY;
  }
  
  public e getEdgeEffectFactory()
  {
    return this.asx;
  }
  
  public f getItemAnimator()
  {
    return this.asC;
  }
  
  public int getItemDecorationCount()
  {
    return this.ase.size();
  }
  
  public LayoutManager getLayoutManager()
  {
    return this.asc;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.asK;
  }
  
  public int getMinFlingVelocity()
  {
    return this.asJ;
  }
  
  long getNanoTime()
  {
    if (arQ) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public j getOnFlingListener()
  {
    return this.asI;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.asN;
  }
  
  public m getRecycledViewPool()
  {
    return this.arV.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  l getScrollingChildHelper()
  {
    if (this.atb == null) {
      this.atb = new l(this);
    }
    return this.atb;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().aN(0);
  }
  
  final int i(v paramv)
  {
    if ((paramv.cv(524)) || (!paramv.isBound())) {
      return -1;
    }
    return this.arX.bF(paramv.mPosition);
  }
  
  public boolean isAttachedToWindow()
  {
    return this.ash;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().PY;
  }
  
  public final v k(int paramInt, boolean paramBoolean)
  {
    int j = this.mChildHelper.jA();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      v localv = bv(this.mChildHelper.bM(i));
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
        if (localv.lQ() == paramInt)
        {
          label95:
          localObject1 = localv;
          if (!this.mChildHelper.bh(localv.aus)) {
            break label121;
          }
          localObject2 = localv;
        }
      }
    }
    label121:
    return localObject1;
  }
  
  final String kL()
  {
    return " " + super.toString() + ", adapter:" + this.adj + ", layout:" + this.asc + ", context:" + getContext();
  }
  
  final void kM()
  {
    if (this.asC != null) {
      this.asC.jF();
    }
    if (this.asc != null)
    {
      this.asc.removeAndRecycleAllViews(this.arV);
      this.asc.removeAndRecycleScrapInt(this.arV);
    }
    this.arV.clear();
  }
  
  public final void kN()
  {
    int i = getItemDecorationCount();
    if (i <= 0) {
      throw new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
    }
    i = getItemDecorationCount();
    if (i <= 0) {
      throw new IndexOutOfBoundsException("0 is an invalid index for size " + i);
    }
    c((h)this.ase.get(0));
  }
  
  final void kO()
  {
    int k = 0;
    if ((!this.ask) || (this.ast))
    {
      e.beginSection("RV FullInvalidate");
      lh();
      e.endSection();
    }
    label168:
    label175:
    do
    {
      do
      {
        return;
      } while (!this.arX.jc());
      if ((this.arX.bD(4)) && (!this.arX.bD(11)))
      {
        e.beginSection("RV PartialInvalidate");
        kP();
        la();
        this.arX.ja();
        int i;
        if (!this.asm)
        {
          int m = this.mChildHelper.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            v localv = bv(this.mChildHelper.getChildAt(i));
            if ((localv == null) || (localv.lP()) || (!localv.mh())) {
              break label168;
            }
            j = 1;
          }
          if (j == 0) {
            break label175;
          }
          lh();
        }
        for (;;)
        {
          ar(true);
          as(true);
          e.endSection();
          return;
          i += 1;
          break;
          this.arX.jb();
        }
      }
    } while (!this.arX.jc());
    e.beginSection("RV FullInvalidate");
    lh();
    e.endSection();
  }
  
  final void kP()
  {
    this.asl += 1;
    if ((this.asl == 1) && (!this.asn)) {
      this.asm = false;
    }
  }
  
  public void kQ()
  {
    setScrollState(0);
    kR();
  }
  
  final void la()
  {
    this.asv += 1;
  }
  
  final boolean lb()
  {
    return (this.asr != null) && (this.asr.isEnabled());
  }
  
  public final boolean ld()
  {
    return this.asv > 0;
  }
  
  final void le()
  {
    if ((!this.asX) && (this.ash))
    {
      u.b(this, this.atf);
      this.asX = true;
    }
  }
  
  public void lo()
  {
    int j = 0;
    int k = this.mChildHelper.jA();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.mChildHelper.bM(i).getLayoutParams()).atx = true;
      i += 1;
    }
    n localn = this.arV;
    k = localn.atH.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((v)localn.atH.get(i)).aus.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.atx = true;
      }
      i += 1;
    }
  }
  
  public final void ls()
  {
    if (this.ase.size() == 0) {
      return;
    }
    if (this.asc != null) {
      this.asc.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    lo();
    requestLayout();
  }
  
  public final boolean lt()
  {
    return (!this.ask) || (this.ast) || (this.arX.jc());
  }
  
  public final v m(long paramLong)
  {
    v localv2 = null;
    v localv1 = localv2;
    if (this.adj != null)
    {
      if (this.adj.atk) {
        break label31;
      }
      localv1 = localv2;
    }
    label31:
    int i;
    do
    {
      return localv1;
      int j = this.mChildHelper.jA();
      i = 0;
      localv1 = null;
      if (i >= j) {
        break;
      }
      localv2 = bv(this.mChildHelper.bM(i));
      if ((localv2 == null) || (localv2.isRemoved()) || (localv2.auv != paramLong)) {
        break label120;
      }
      localv1 = localv2;
    } while (!this.mChildHelper.bh(localv2.aus));
    localv1 = localv2;
    label120:
    for (;;)
    {
      i += 1;
      break;
      return localv1;
    }
  }
  
  public final View o(float paramFloat1, float paramFloat2)
  {
    int i = this.mChildHelper.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.getChildAt(i);
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
    this.asv = 0;
    this.ash = true;
    float f;
    if ((this.ask) && (!isLayoutRequested()))
    {
      this.ask = bool;
      if (this.asc != null) {
        this.asc.dispatchAttachedToWindow(this);
      }
      this.asX = false;
      if (arQ)
      {
        this.asP = ((ac)ac.anQ.get());
        if (this.asP == null)
        {
          this.asP = new ac();
          Display localDisplay = u.aF(this);
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
      this.asP.anT = ((1.0E+009F / f));
      ac.anQ.set(this.asP);
      this.asP.anR.add(this);
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
    if (this.asC != null) {
      this.asC.jF();
    }
    kQ();
    this.ash = false;
    if (this.asc != null) {
      this.asc.dispatchDetachedFromWindow(this, this.arV);
    }
    this.ate.clear();
    removeCallbacks(this.atf);
    bg.a.nn();
    if ((arQ) && (this.asP != null))
    {
      this.asP.anR.remove(this);
      this.asP = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.ase.size();
    int i = 0;
    while (i < j)
    {
      ((h)this.ase.get(i)).a(paramCanvas, this, this.asR);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.asc == null) {}
    label188:
    for (;;)
    {
      return false;
      if ((!this.asn) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f3;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.asc.canScrollVertically())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.asc.canScrollHorizontally()) {
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
          a((int)(this.asL * f1), (int)(this.asM * f2), paramMotionEvent);
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
            if (this.asc.canScrollVertically())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.asc.canScrollHorizontally())
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
    if (this.asn) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.asg = null;
    }
    int k = this.asf.size();
    int i = 0;
    if (i < k)
    {
      k localk = (k)this.asf.get(i);
      if ((localk.a(this, paramMotionEvent)) && (j != 3)) {
        this.asg = localk;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label105;
      }
      kZ();
      return true;
      i += 1;
      break;
    }
    label105:
    if (this.asc == null) {
      return false;
    }
    boolean bool1 = this.asc.canScrollHorizontally();
    boolean bool2 = this.asc.canScrollVertically();
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
      if (this.aso) {
        this.aso = false;
      }
      this.asD = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.asG = i;
      this.asE = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.asH = i;
      this.asF = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.atc;
      this.atc[1] = 0;
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
      this.asD = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.asG = j;
      this.asE = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.asH = i;
      this.asF = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.asD);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.asD).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.asE;
      int m = this.asF;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.asG = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.asH = k;
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        setScrollState(1);
        break;
        l(paramMotionEvent);
        break;
        this.mVelocityTracker.clear();
        aM(0);
        break;
        kZ();
        break;
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e.beginSection("RV OnLayout");
    lh();
    e.endSection();
    this.ask = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.asc == null) {
      an(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.asc.isAutoMeasureEnabled()) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        this.asc.onMeasure(this.arV, this.asR, paramInt1, paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
      } while ((i != 0) || (this.adj == null));
      if (this.asR.aub == 1) {
        ll();
      }
      this.asc.setMeasureSpecs(paramInt1, paramInt2);
      this.asR.aug = true;
      lm();
      this.asc.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    } while (!this.asc.shouldMeasureTwice());
    this.asc.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.asR.aug = true;
    lm();
    this.asc.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    return;
    if (this.asi)
    {
      this.asc.onMeasure(this.arV, this.asR, paramInt1, paramInt2);
      return;
    }
    if (this.asq)
    {
      kP();
      la();
      lg();
      as(true);
      if (this.asR.aui)
      {
        this.asR.aue = true;
        this.asq = false;
        ar(false);
        label272:
        if (this.adj == null) {
          break label369;
        }
      }
    }
    label369:
    for (this.asR.auc = this.adj.getItemCount();; this.asR.auc = 0)
    {
      kP();
      this.asc.onMeasure(this.arV, this.asR, paramInt1, paramInt2);
      ar(false);
      this.asR.aue = false;
      return;
      this.arX.jd();
      this.asR.aue = false;
      break;
      if (!this.asR.aui) {
        break label272;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (ld()) {
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
      this.arW = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.arW.Pm);
    } while ((this.asc == null) || (this.arW.atN == null));
    this.asc.onRestoreInstanceState(this.arW.atN);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.arW != null)
    {
      localSavedState.atN = this.arW.atN;
      return localSavedState;
    }
    if (this.asc != null)
    {
      localSavedState.atN = this.asc.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.atN = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      kX();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.asn) || (this.aso)) {}
    label146:
    label155:
    label161:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.asg != null)
      {
        if (i == 0) {
          this.asg = null;
        }
      }
      else
      {
        if (i == 0) {
          break label155;
        }
        j = this.asf.size();
        i = 0;
        if (i >= j) {
          break label155;
        }
        localObject = (k)this.asf.get(i);
        if (!((k)localObject).a(this, paramMotionEvent)) {
          break label146;
        }
        this.asg = ((k)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label161;
        }
        kZ();
        return true;
        this.asg.b(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.asg = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.asc == null);
    boolean bool1 = this.asc.canScrollHorizontally();
    boolean bool2 = this.asc.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.atc;
      this.atc[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.atc[0], this.atc[1]);
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
      this.asD = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.asG = i;
      this.asE = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.asH = i;
      this.asF = i;
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
      this.asD = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.asG = i;
      this.asE = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.asH = i;
      this.asF = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.asD);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.asD).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.asG - i3;
      k = this.asH - i4;
      j = m;
      i = k;
      if (a(m, k, this.UO, this.UN, 0))
      {
        j = m - this.UO[0];
        i = k - this.UO[1];
        ((MotionEvent)localObject).offsetLocation(this.UN[0], this.UN[1]);
        paramMotionEvent = this.atc;
        paramMotionEvent[0] += this.UN[0];
        paramMotionEvent = this.atc;
        paramMotionEvent[1] += this.UN[1];
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
        this.asG = (i3 - this.UN[0]);
        this.asH = (i4 - this.UN[1]);
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
          if (this.asP == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.asP.a(this, k, m);
          i = i2;
          break;
          j = this.mTouchSlop + j;
          break label730;
          i = this.mTouchSlop + i;
          break label780;
          i = 0;
          break label860;
        }
        l(paramMotionEvent);
        i = i2;
        break;
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.asK);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.asD);
          if (!bool2) {
            break label1087;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.asD);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!ak((int)f1, (int)f2))) {
            setScrollState(0);
          }
          kY();
          i = 1;
          break;
          f1 = 0.0F;
          break label1026;
        }
        kZ();
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
      if (!localv.mb()) {
        break label36;
      }
      localv.lZ();
    }
    label36:
    while (localv.lP())
    {
      paramView.clearAnimation();
      bA(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv + kL());
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.asc.onRequestChildFocus(this, this.asR, paramView1, paramView2)) && (paramView2 != null)) {
      f(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.asc.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.asf.size();
    int i = 0;
    while (i < j)
    {
      ((k)this.asf.get(i)).ah(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.asl == 0) && (!this.asn))
    {
      super.requestLayout();
      return;
    }
    this.asm = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.asc == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.asn);
      bool1 = this.asc.canScrollHorizontally();
      bool2 = this.asc.canScrollVertically();
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
  
  public void scrollToPosition(int paramInt)
  {
    if (this.asn) {}
    do
    {
      return;
      kQ();
    } while (this.asc == null);
    LayoutManager localLayoutManager = this.asc;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, locala.axQ(), "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    if (ld())
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
        this.asp |= i;
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
    this.asY = paramal;
    u.a(this, this.asY);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    if (this.adj != null)
    {
      this.adj.b(this.arU);
      this.adj.c(this);
    }
    kM();
    this.arX.reset();
    a locala = this.adj;
    this.adj = parama;
    if (parama != null)
    {
      parama.a(this.arU);
      parama.b(this);
    }
    if (this.asc != null) {
      this.asc.onAdapterChanged(locala, this.adj);
    }
    Object localObject = this.arV;
    parama = this.adj;
    ((n)localObject).clear();
    localObject = ((n)localObject).getRecycledViewPool();
    if (locala != null) {
      ((m)localObject).detach();
    }
    if (((m)localObject).atA == 0) {
      ((m)localObject).clear();
    }
    if (parama != null) {
      ((m)localObject).lH();
    }
    this.asR.aud = true;
    at(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.asZ) {
      return;
    }
    this.asZ = paramd;
    if (this.asZ != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.arZ) {
      kX();
    }
    this.arZ = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.ask) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(e parame)
  {
    m.checkNotNull(parame);
    this.asx = parame;
    kX();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.asi = paramBoolean;
  }
  
  public void setItemAnimator(f paramf)
  {
    if (this.asC != null)
    {
      this.asC.jF();
      this.asC.atl = null;
    }
    this.asC = paramf;
    if (this.asC != null) {
      this.asC.atl = this.asW;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    n localn = this.arV;
    localn.atJ = paramInt;
    localn.lI();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.asn)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.asn = false;
        if ((this.asm) && (this.asc != null) && (this.adj != null)) {
          requestLayout();
        }
        this.asm = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.asn = true;
    this.aso = true;
    kQ();
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.asc) {
      return;
    }
    kQ();
    if (this.asc != null)
    {
      if (this.asC != null) {
        this.asC.jF();
      }
      this.asc.removeAndRecycleAllViews(this.arV);
      this.asc.removeAndRecycleScrapInt(this.arV);
      this.arV.clear();
      if (this.ash) {
        this.asc.dispatchDetachedFromWindow(this, this.arV);
      }
      this.asc.setRecyclerView(null);
      this.asc = null;
    }
    s locals;
    for (;;)
    {
      locals = this.mChildHelper;
      for (s.a locala = locals.alY;; locala = locala.amb)
      {
        locala.ama = 0L;
        if (locala.amb == null) {
          break;
        }
      }
      this.arV.clear();
    }
    int i = locals.alZ.size() - 1;
    while (i >= 0)
    {
      locals.alX.bk((View)locals.alZ.get(i));
      locals.alZ.remove(i);
      i -= 1;
    }
    locals.alX.removeAllViews();
    this.asc = paramLayoutManager;
    if (paramLayoutManager != null)
    {
      if (paramLayoutManager.mRecyclerView != null) {
        throw new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView:" + paramLayoutManager.mRecyclerView.kL());
      }
      this.asc.setRecyclerView(this);
      if (this.ash) {
        this.asc.dispatchAttachedToWindow(this);
      }
    }
    this.arV.lI();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(j paramj)
  {
    this.asI = paramj;
  }
  
  @Deprecated
  public void setOnScrollListener(l paraml)
  {
    this.asS = paraml;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.asN = paramBoolean;
  }
  
  public void setRecycledViewPool(m paramm)
  {
    n localn = this.arV;
    if (localn.atL != null) {
      localn.atL.detach();
    }
    localn.atL = paramm;
    if ((localn.atL != null) && (localn.ati.getAdapter() != null)) {
      localn.atL.lH();
    }
  }
  
  public void setRecyclerListener(o paramo)
  {
    this.asd = paramo;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if (paramInt != 2) {
        kR();
      }
      if (this.asc != null) {
        this.asc.onScrollStateChanged(paramInt);
      }
      if (this.asS != null) {
        this.asS.onScrollStateChanged(this, paramInt);
      }
      if (this.asT != null)
      {
        int i = this.asT.size() - 1;
        while (i >= 0)
        {
          ((l)this.asT.get(i)).onScrollStateChanged(this, paramInt);
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
    this.arV.atM = paramt;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.asn) {}
    while (this.asc == null) {
      return;
    }
    this.asc.smoothScrollToPosition(this, this.asR, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().A(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().aM(0);
  }
  
  public static abstract class LayoutManager
  {
    boolean mAutoMeasure = false;
    s mChildHelper;
    private int mHeight;
    private int mHeightMode;
    bf mHorizontalBoundCheck = new bf(this.mHorizontalBoundCheckCallback);
    private final bf.b mHorizontalBoundCheckCallback = new bf.b()
    {
      public final int bB(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedLeft(paramAnonymousView) - localLayoutParams.leftMargin;
      }
      
      public final int bC(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedRight(paramAnonymousView);
        return localLayoutParams.rightMargin + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
      }
      
      public final int lE()
      {
        return RecyclerView.LayoutManager.this.getPaddingLeft();
      }
      
      public final int lF()
      {
        return RecyclerView.LayoutManager.this.getWidth() - RecyclerView.LayoutManager.this.getPaddingRight();
      }
    };
    boolean mIsAttachedToWindow = false;
    private boolean mItemPrefetchEnabled = true;
    private boolean mMeasurementCacheEnabled = true;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    protected RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations = false;
    RecyclerView.r mSmoothScroller;
    bf mVerticalBoundCheck = new bf(this.mVerticalBoundCheckCallback);
    private final bf.b mVerticalBoundCheckCallback = new bf.b()
    {
      public final int bB(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedTop(paramAnonymousView) - localLayoutParams.topMargin;
      }
      
      public final int bC(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedBottom(paramAnonymousView);
        return localLayoutParams.bottomMargin + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
      }
      
      public final int lE()
      {
        return RecyclerView.LayoutManager.this.getPaddingTop();
      }
      
      public final int lF()
      {
        return RecyclerView.LayoutManager.this.getHeight() - RecyclerView.LayoutManager.this.getPaddingBottom();
      }
    };
    private int mWidth;
    private int mWidthMode;
    
    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localv.isRemoved()))
      {
        this.mRecyclerView.arY.I(localv);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localv.lX()) && (!localv.lV())) {
          break label128;
        }
        if (!localv.lV()) {
          break label120;
        }
        localv.lW();
        label68:
        this.mChildHelper.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.aty)
        {
          localv.aus.invalidate();
          localLayoutParams.aty = false;
        }
        return;
        this.mRecyclerView.arY.J(localv);
        break;
        label120:
        localv.lY();
        break label68;
        label128:
        if (paramView.getParent() == this.mRecyclerView)
        {
          int j = this.mChildHelper.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.mChildHelper.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(paramView) + this.mRecyclerView.kL());
          }
          if (j != i) {
            this.mRecyclerView.asc.moveView(j, i);
          }
        }
        else
        {
          this.mChildHelper.a(paramView, paramInt, false);
          localLayoutParams.atx = true;
          if ((this.mSmoothScroller != null) && (this.mSmoothScroller.gc))
          {
            RecyclerView.r localr = this.mSmoothScroller;
            if (RecyclerView.bx(paramView) == localr.atO) {
              localr.atQ = paramView;
            }
          }
        }
      }
    }
    
    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
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
    
    private void detachViewInternal(int paramInt, View paramView)
    {
      this.mChildHelper.detachViewFromParent(paramInt);
    }
    
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
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
    
    @Deprecated
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int j = 1073741824;
      int i = Math.max(0, paramInt1 - paramInt2);
      if (paramBoolean) {
        if (paramInt3 >= 0)
        {
          paramInt1 = paramInt3;
          paramInt2 = j;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
        paramInt2 = 0;
        paramInt1 = 0;
        continue;
        paramInt2 = j;
        paramInt1 = paramInt3;
        if (paramInt3 < 0) {
          if (paramInt3 == -1)
          {
            paramInt1 = i;
            paramInt2 = j;
          }
          else if (paramInt3 == -2)
          {
            paramInt2 = -2147483648;
            paramInt1 = i;
          }
          else
          {
            paramInt2 = 0;
            paramInt1 = 0;
          }
        }
      }
    }
    
    private int[] getChildRectangleOnScreenScrollAmount(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      int i2 = getPaddingLeft();
      int m = getPaddingTop();
      int i3 = getWidth() - getPaddingRight();
      int i1 = getHeight();
      int i6 = getPaddingBottom();
      int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i5 = i4 + paramRect.width();
      int i7 = paramRect.height();
      int i = Math.min(0, i4 - i2);
      int j = Math.min(0, n - m);
      int k = Math.max(0, i5 - i3);
      i1 = Math.max(0, n + i7 - (i1 - i6));
      if (getLayoutDirection() == 1) {
        if (k != 0)
        {
          i = k;
          if (j == 0) {
            break label206;
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
        label206:
        j = Math.min(n - m, i1);
      }
    }
    
    public static b getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      b localb = new b();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt1, paramInt2);
      localb.orientation = paramContext.getInt(0, 1);
      localb.att = paramContext.getInt(9, 1);
      localb.atu = paramContext.getBoolean(8, false);
      localb.atv = paramContext.getBoolean(10, false);
      paramContext.recycle();
      return localb;
    }
    
    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
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
        k = getWidth();
        m = getPaddingRight();
        n = getHeight();
        i1 = getPaddingBottom();
        localRect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(paramRecyclerView, localRect);
      } while ((localRect.left - paramInt1 >= k - m) || (localRect.right - paramInt1 <= i) || (localRect.top - paramInt2 >= n - i1) || (localRect.bottom - paramInt2 <= j));
      return true;
    }
    
    private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
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
    
    private void scrapOrRecycleView(RecyclerView.n paramn, int paramInt, View paramView)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if (localv.lP()) {
        return;
      }
      if ((localv.isInvalid()) && (!localv.isRemoved()) && (!this.mRecyclerView.adj.atk))
      {
        removeViewAt(paramInt);
        paramn.t(localv);
        return;
      }
      detachViewAt(paramInt);
      paramn.bH(paramView);
      this.mRecyclerView.arY.J(localv);
    }
    
    public void addDisappearingView(View paramView)
    {
      addDisappearingView(paramView, -1);
    }
    
    public void addDisappearingView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, true);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, false);
    }
    
    public void assertInLayoutOrScroll(String paramString)
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.assertInLayoutOrScroll(paramString);
      }
    }
    
    public void assertNotInLayoutOrScroll(String paramString)
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.assertNotInLayoutOrScroll(paramString);
      }
    }
    
    public void attachView(View paramView)
    {
      attachView(paramView, -1);
    }
    
    public void attachView(View paramView, int paramInt)
    {
      attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }
    
    public void attachView(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if (localv.isRemoved()) {
        this.mRecyclerView.arY.I(localv);
      }
      for (;;)
      {
        this.mChildHelper.a(paramView, paramInt, paramLayoutParams, localv.isRemoved());
        return;
        this.mRecyclerView.arY.J(localv);
      }
    }
    
    public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      if (this.mRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.mRecyclerView.by(paramView));
    }
    
    public boolean canScrollHorizontally()
    {
      return false;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.s params, a parama) {}
    
    public void collectInitialPrefetchPositions(int paramInt, a parama) {}
    
    public int computeHorizontalScrollExtent(RecyclerView.s params)
    {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(RecyclerView.s params)
    {
      return 0;
    }
    
    public int computeHorizontalScrollRange(RecyclerView.s params)
    {
      return 0;
    }
    
    public int computeVerticalScrollExtent(RecyclerView.s params)
    {
      return 0;
    }
    
    public int computeVerticalScrollOffset(RecyclerView.s params)
    {
      return 0;
    }
    
    public int computeVerticalScrollRange(RecyclerView.s params)
    {
      return 0;
    }
    
    public void detachAndScrapAttachedViews(RecyclerView.n paramn)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        scrapOrRecycleView(paramn, i, getChildAt(i));
        i -= 1;
      }
    }
    
    public void detachAndScrapView(View paramView, RecyclerView.n paramn)
    {
      scrapOrRecycleView(paramn, this.mChildHelper.indexOfChild(paramView), paramView);
    }
    
    public void detachAndScrapViewAt(int paramInt, RecyclerView.n paramn)
    {
      scrapOrRecycleView(paramn, paramInt, getChildAt(paramInt));
    }
    
    public void detachView(View paramView)
    {
      int i = this.mChildHelper.indexOfChild(paramView);
      if (i >= 0) {
        detachViewInternal(i, paramView);
      }
    }
    
    public void detachViewAt(int paramInt)
    {
      detachViewInternal(paramInt, getChildAt(paramInt));
    }
    
    void dispatchAttachedToWindow(RecyclerView paramRecyclerView)
    {
      this.mIsAttachedToWindow = true;
      onAttachedToWindow(paramRecyclerView);
    }
    
    void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
    {
      this.mIsAttachedToWindow = false;
      onDetachedFromWindow(paramRecyclerView, paramn);
    }
    
    public void endAnimation(View paramView)
    {
      if (this.mRecyclerView.asC != null) {
        this.mRecyclerView.asC.d(RecyclerView.bv(paramView));
      }
    }
    
    public View findContainingItemView(View paramView)
    {
      if (this.mRecyclerView == null) {}
      do
      {
        return null;
        paramView = this.mRecyclerView.findContainingItemView(paramView);
      } while ((paramView == null) || (this.mChildHelper.bh(paramView)));
      return paramView;
    }
    
    public View findViewByPosition(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.v localv = RecyclerView.bv(localView);
        if ((localv != null) && (localv.lQ() == paramInt) && (!localv.lP()) && ((this.mRecyclerView.asR.aue) || (!localv.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public int getBaseline()
    {
      return -1;
    }
    
    public int getBottomDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS.bottom;
    }
    
    public View getChildAt(int paramInt)
    {
      if (this.mChildHelper != null) {
        return this.mChildHelper.getChildAt(paramInt);
      }
      return null;
    }
    
    public int getChildCount()
    {
      if (this.mChildHelper != null) {
        return this.mChildHelper.getChildCount();
      }
      return 0;
    }
    
    public boolean getClipToPadding()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.arZ);
    }
    
    public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.adj == null)) {}
      while (!canScrollHorizontally()) {
        return 1;
      }
      return this.mRecyclerView.adj.getItemCount();
    }
    
    public int getDecoratedBottom(View paramView)
    {
      return paramView.getBottom() + getBottomDecorationHeight(paramView);
    }
    
    public void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
    {
      RecyclerView.c(paramView, paramRect);
    }
    
    public int getDecoratedLeft(View paramView)
    {
      return paramView.getLeft() - getLeftDecorationWidth(paramView);
    }
    
    public int getDecoratedMeasuredHeight(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public int getDecoratedRight(View paramView)
    {
      return paramView.getRight() + getRightDecorationWidth(paramView);
    }
    
    public int getDecoratedTop(View paramView)
    {
      return paramView.getTop() - getTopDecorationHeight(paramView);
    }
    
    public View getFocusedChild()
    {
      if (this.mRecyclerView == null) {}
      View localView;
      do
      {
        return null;
        localView = this.mRecyclerView.getFocusedChild();
      } while ((localView == null) || (this.mChildHelper.bh(localView)));
      return localView;
    }
    
    public int getHeight()
    {
      return this.mHeight;
    }
    
    public int getHeightMode()
    {
      return this.mHeightMode;
    }
    
    public int getItemCount()
    {
      if (this.mRecyclerView != null) {}
      for (RecyclerView.a locala = this.mRecyclerView.getAdapter(); locala != null; locala = null) {
        return locala.getItemCount();
      }
      return 0;
    }
    
    public int getItemViewType(View paramView)
    {
      return RecyclerView.bv(paramView).auw;
    }
    
    public int getLayoutDirection()
    {
      return u.Z(this.mRecyclerView);
    }
    
    public int getLeftDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS.left;
    }
    
    public int getMinimumHeight()
    {
      return u.ag(this.mRecyclerView);
    }
    
    public int getMinimumWidth()
    {
      return u.af(this.mRecyclerView);
    }
    
    public int getPaddingBottom()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingBottom();
      }
      return 0;
    }
    
    public int getPaddingEnd()
    {
      if (this.mRecyclerView != null) {
        return u.ad(this.mRecyclerView);
      }
      return 0;
    }
    
    public int getPaddingLeft()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingLeft();
      }
      return 0;
    }
    
    public int getPaddingRight()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingRight();
      }
      return 0;
    }
    
    public int getPaddingStart()
    {
      if (this.mRecyclerView != null) {
        return u.ac(this.mRecyclerView);
      }
      return 0;
    }
    
    public int getPaddingTop()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingTop();
      }
      return 0;
    }
    
    public int getPosition(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).atw.lQ();
    }
    
    public int getRightDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS.right;
    }
    
    public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.adj == null)) {}
      while (!canScrollVertically()) {
        return 1;
      }
      return this.mRecyclerView.adj.getItemCount();
    }
    
    public int getSelectionModeForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      return 0;
    }
    
    public int getTopDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS.top;
    }
    
    public void getTransformedBoundingBox(View paramView, boolean paramBoolean, Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS;
        int i = -((Rect)localObject).left;
        int j = -((Rect)localObject).top;
        int k = paramView.getWidth();
        int m = ((Rect)localObject).right;
        int n = paramView.getHeight();
        paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
      }
      for (;;)
      {
        if (this.mRecyclerView != null)
        {
          localObject = paramView.getMatrix();
          if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
          {
            RectF localRectF = this.mRecyclerView.asb;
            localRectF.set(paramRect);
            ((Matrix)localObject).mapRect(localRectF);
            paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
          }
        }
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        return;
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
    }
    
    public int getWidth()
    {
      return this.mWidth;
    }
    
    public int getWidthMode()
    {
      return this.mWidthMode;
    }
    
    boolean hasFlexibleChildInBothOrientations()
    {
      boolean bool2 = false;
      int j = getChildCount();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
          if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
    }
    
    public boolean hasFocus()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.hasFocus());
    }
    
    public void ignoreView(View paramView)
    {
      if ((paramView.getParent() != this.mRecyclerView) || (this.mRecyclerView.indexOfChild(paramView) == -1)) {
        throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.kL());
      }
      paramView = RecyclerView.bv(paramView);
      paramView.addFlags(128);
      this.mRecyclerView.arY.K(paramView);
    }
    
    public boolean isAttachedToWindow()
    {
      return this.mIsAttachedToWindow;
    }
    
    public boolean isAutoMeasureEnabled()
    {
      return this.mAutoMeasure;
    }
    
    public boolean isFocused()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.isFocused());
    }
    
    public final boolean isItemPrefetchEnabled()
    {
      return this.mItemPrefetchEnabled;
    }
    
    public boolean isLayoutHierarchical(RecyclerView.n paramn, RecyclerView.s params)
    {
      return false;
    }
    
    public boolean isMeasurementCacheEnabled()
    {
      return this.mMeasurementCacheEnabled;
    }
    
    public boolean isSmoothScrolling()
    {
      return (this.mSmoothScroller != null) && (this.mSmoothScroller.gc);
    }
    
    public boolean isViewPartiallyVisible(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.mHorizontalBoundCheck.bR(paramView)) && (this.mVerticalBoundCheck.bR(paramView))) {}
      for (paramBoolean2 = true; paramBoolean1; paramBoolean2 = false) {
        return paramBoolean2;
      }
      return !paramBoolean2;
    }
    
    public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).apS;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.apS;
      paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public void measureChild(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.by(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), k + m + paramInt1 + (getPaddingLeft() + getPaddingRight()), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), j + i + paramInt2 + (getPaddingTop() + getPaddingBottom()), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.by(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), k + m + paramInt1 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), j + i + paramInt2 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void moveView(int paramInt1, int paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == null) {
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.mRecyclerView.toString());
      }
      detachViewAt(paramInt1);
      attachView(localView, paramInt2);
    }
    
    public void offsetChildrenHorizontal(int paramInt)
    {
      if (this.mRecyclerView != null)
      {
        RecyclerView localRecyclerView = this.mRecyclerView;
        int j = localRecyclerView.mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.mChildHelper.getChildAt(i).offsetLeftAndRight(paramInt);
          i += 1;
        }
      }
    }
    
    public void offsetChildrenVertical(int paramInt)
    {
      if (this.mRecyclerView != null)
      {
        RecyclerView localRecyclerView = this.mRecyclerView;
        int j = localRecyclerView.mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.mChildHelper.getChildAt(i).offsetTopAndBottom(paramInt);
          i += 1;
        }
      }
    }
    
    public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2) {}
    
    public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    public void onAttachedToWindow(RecyclerView paramRecyclerView) {}
    
    @Deprecated
    public void onDetachedFromWindow(RecyclerView paramRecyclerView) {}
    
    public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
    {
      onDetachedFromWindow(paramRecyclerView);
    }
    
    public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(RecyclerView.n paramn, RecyclerView.s params, AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      if ((this.mRecyclerView == null) || (paramAccessibilityEvent == null)) {
        return;
      }
      boolean bool1 = bool2;
      if (!this.mRecyclerView.canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.mRecyclerView.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.mRecyclerView.canScrollHorizontally(-1)) {
            if (!this.mRecyclerView.canScrollHorizontally(1)) {
              break label106;
            }
          }
        }
      }
      label106:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (this.mRecyclerView.adj == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.mRecyclerView.adj.getItemCount());
        return;
      }
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      onInitializeAccessibilityEvent(this.mRecyclerView.arV, this.mRecyclerView.asR, paramAccessibilityEvent);
    }
    
    void onInitializeAccessibilityNodeInfo(android.support.v4.view.a.c paramc)
    {
      onInitializeAccessibilityNodeInfo(this.mRecyclerView.arV, this.mRecyclerView.asR, paramc);
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.n paramn, RecyclerView.s params, android.support.v4.view.a.c paramc)
    {
      if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
      {
        paramc.addAction(8192);
        paramc.setScrollable(true);
      }
      if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
      {
        paramc.addAction(4096);
        paramc.setScrollable(true);
      }
      int i = getRowCountForAccessibility(paramn, params);
      int j = getColumnCountForAccessibility(paramn, params);
      boolean bool = isLayoutHierarchical(paramn, params);
      int k = getSelectionModeForAccessibility(paramn, params);
      if (Build.VERSION.SDK_INT >= 21) {
        paramn = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, bool, k));
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 19) {
          paramc.Ro.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((c.b)paramn).RY);
        }
        return;
        if (Build.VERSION.SDK_INT >= 19) {
          paramn = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, bool));
        } else {
          paramn = new c.b(null);
        }
      }
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, android.support.v4.view.a.c paramc)
    {
      int i;
      if (canScrollVertically())
      {
        i = getPosition(paramView);
        if (!canScrollHorizontally()) {
          break label50;
        }
      }
      label50:
      for (int j = getPosition(paramView);; j = 0)
      {
        paramc.H(c.c.a(i, 1, j, 1, false));
        return;
        i = 0;
        break;
      }
    }
    
    void onInitializeAccessibilityNodeInfoForItem(View paramView, android.support.v4.view.a.c paramc)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if ((localv != null) && (!localv.isRemoved()) && (!this.mChildHelper.bh(localv.aus))) {
        onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.arV, this.mRecyclerView.asR, paramView, paramc);
      }
    }
    
    public View onInterceptFocusSearch(View paramView, int paramInt)
    {
      return null;
    }
    
    public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsChanged(RecyclerView paramRecyclerView) {}
    
    public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params) {}
    
    public void onLayoutCompleted(RecyclerView.s params) {}
    
    public void onMeasure(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2)
    {
      this.mRecyclerView.an(paramInt1, paramInt2);
    }
    
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.s params, View paramView1, View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (isSmoothScrolling()) || (paramRecyclerView.ld());
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void onScrollStateChanged(int paramInt) {}
    
    void onSmoothScrollerStopped(RecyclerView.r paramr)
    {
      if (this.mSmoothScroller == paramr) {
        this.mSmoothScroller = null;
      }
    }
    
    boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
    {
      return performAccessibilityAction(this.mRecyclerView.arV, this.mRecyclerView.asR, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityAction(RecyclerView.n paramn, RecyclerView.s params, int paramInt, Bundle paramBundle)
    {
      if (this.mRecyclerView == null) {}
      int i;
      do
      {
        return false;
        switch (paramInt)
        {
        default: 
          i = 0;
          paramInt = 0;
        }
      } while ((paramInt == 0) && (i == 0));
      this.mRecyclerView.a(i, paramInt, null);
      return true;
      if (this.mRecyclerView.canScrollVertically(-1)) {}
      for (paramInt = -(getHeight() - getPaddingTop() - getPaddingBottom());; paramInt = 0)
      {
        i = paramInt;
        if (this.mRecyclerView.canScrollHorizontally(-1))
        {
          i = -(getWidth() - getPaddingLeft() - getPaddingRight());
          break;
          if (!this.mRecyclerView.canScrollVertically(1)) {
            break label196;
          }
        }
        label196:
        for (paramInt = getHeight() - getPaddingTop() - getPaddingBottom();; paramInt = 0)
        {
          i = paramInt;
          if (this.mRecyclerView.canScrollHorizontally(1))
          {
            i = getWidth() - getPaddingLeft() - getPaddingRight();
            break;
          }
          int j = 0;
          paramInt = i;
          i = j;
          break;
        }
      }
    }
    
    public boolean performAccessibilityActionForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    boolean performAccessibilityActionForItem(View paramView, int paramInt, Bundle paramBundle)
    {
      return performAccessibilityActionForItem(this.mRecyclerView.arV, this.mRecyclerView.asR, paramView, paramInt, paramBundle);
    }
    
    public void postOnAnimation(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null) {
        u.b(this.mRecyclerView, paramRunnable);
      }
    }
    
    public void removeAllViews()
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        this.mChildHelper.removeViewAt(i);
        i -= 1;
      }
    }
    
    public void removeAndRecycleAllViews(RecyclerView.n paramn)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        if (!RecyclerView.bv(getChildAt(i)).lP()) {
          removeAndRecycleViewAt(i, paramn);
        }
        i -= 1;
      }
    }
    
    void removeAndRecycleScrapInt(RecyclerView.n paramn)
    {
      int j = paramn.atF.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.v)paramn.atF.get(i)).aus;
        RecyclerView.v localv = RecyclerView.bv(localView);
        if (!localv.lP())
        {
          localv.av(false);
          if (localv.mb()) {
            this.mRecyclerView.removeDetachedView(localView, false);
          }
          if (this.mRecyclerView.asC != null) {
            this.mRecyclerView.asC.d(localv);
          }
          localv.av(true);
          paramn.bG(localView);
        }
        i -= 1;
      }
      paramn.atF.clear();
      if (paramn.atG != null) {
        paramn.atG.clear();
      }
      if (j > 0) {
        this.mRecyclerView.invalidate();
      }
    }
    
    public void removeAndRecycleView(View paramView, RecyclerView.n paramn)
    {
      removeView(paramView);
      paramn.bF(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, RecyclerView.n paramn)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramn.bF(localView);
    }
    
    public boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public void removeDetachedView(View paramView)
    {
      this.mRecyclerView.removeDetachedView(paramView, false);
    }
    
    public void removeView(View paramView)
    {
      s locals = this.mChildHelper;
      int i = locals.alX.indexOfChild(paramView);
      if (i >= 0)
      {
        if (locals.alY.remove(i)) {
          locals.bg(paramView);
        }
        locals.alX.removeViewAt(i);
      }
    }
    
    public void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.mChildHelper.removeViewAt(paramInt);
      }
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = false;
      paramView = getChildRectangleOnScreenScrollAmount(paramRecyclerView, paramView, paramRect, paramBoolean1);
      int i = paramView[0];
      int j = paramView[1];
      if (paramBoolean2)
      {
        paramBoolean2 = bool;
        if (!isFocusedChildVisibleAfterScrolling(paramRecyclerView, i, j)) {}
      }
      else if (i == 0)
      {
        paramBoolean2 = bool;
        if (j == 0) {}
      }
      else
      {
        if (!paramBoolean1) {
          break label77;
        }
        paramRecyclerView.scrollBy(i, j);
      }
      for (;;)
      {
        paramBoolean2 = true;
        return paramBoolean2;
        label77:
        paramRecyclerView.a(i, j, null);
      }
    }
    
    public void requestLayout()
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.requestLayout();
      }
    }
    
    public void requestSimpleAnimationsInNextLayout()
    {
      this.mRequestedSimpleAnimations = true;
    }
    
    public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
    {
      return 0;
    }
    
    public void scrollToPosition(int paramInt) {}
    
    public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
    {
      return 0;
    }
    
    @Deprecated
    public void setAutoMeasureEnabled(boolean paramBoolean)
    {
      this.mAutoMeasure = paramBoolean;
    }
    
    void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
    {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public final void setItemPrefetchEnabled(boolean paramBoolean)
    {
      if (paramBoolean != this.mItemPrefetchEnabled)
      {
        this.mItemPrefetchEnabled = paramBoolean;
        this.mPrefetchMaxCountObserved = 0;
        if (this.mRecyclerView != null) {
          this.mRecyclerView.arV.lI();
        }
      }
    }
    
    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.mWidthMode = View.MeasureSpec.getMode(paramInt1);
      if ((this.mWidthMode == 0) && (!RecyclerView.arO)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.mHeightMode = View.MeasureSpec.getMode(paramInt2);
      if ((this.mHeightMode == 0) && (!RecyclerView.arO)) {
        this.mHeight = 0;
      }
    }
    
    public void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      RecyclerView.b(this.mRecyclerView, paramInt1, paramInt2);
    }
    
    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, i + j + k, getMinimumWidth()), chooseSize(paramInt2, m + n + i1, getMinimumHeight()));
    }
    
    void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
    {
      int i5 = getChildCount();
      if (i5 == 0)
      {
        this.mRecyclerView.an(paramInt1, paramInt2);
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
        Rect localRect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(localView, localRect);
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
      this.mRecyclerView.mTempRect.set(i3, k, n, j);
      setMeasuredDimension(this.mRecyclerView.mTempRect, paramInt1, paramInt2);
    }
    
    public void setMeasurementCacheEnabled(boolean paramBoolean)
    {
      this.mMeasurementCacheEnabled = paramBoolean;
    }
    
    void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.mRecyclerView = null;
        this.mChildHelper = null;
        this.mWidth = 0;
      }
      for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
      {
        this.mWidthMode = 1073741824;
        this.mHeightMode = 1073741824;
        return;
        this.mRecyclerView = paramRecyclerView;
        this.mChildHelper = paramRecyclerView.mChildHelper;
        this.mWidth = paramRecyclerView.getWidth();
      }
    }
    
    boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    boolean shouldMeasureTwice()
    {
      return false;
    }
    
    boolean shouldReMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt) {}
    
    public void startSmoothScroll(RecyclerView.r paramr)
    {
      if ((this.mSmoothScroller != null) && (paramr != this.mSmoothScroller) && (this.mSmoothScroller.gc)) {
        this.mSmoothScroller.stop();
      }
      this.mSmoothScroller = paramr;
      paramr = this.mSmoothScroller;
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (paramr.mStarted) {
        new StringBuilder("An instance of ").append(paramr.getClass().getSimpleName()).append(" was started more than once. Each instance of").append(paramr.getClass().getSimpleName()).append(" is intended to only be used once. You should create a new instance for each use.");
      }
      paramr.mRecyclerView = localRecyclerView;
      paramr.arI = this;
      if (paramr.atO == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      paramr.mRecyclerView.asR.atO = paramr.atO;
      paramr.gc = true;
      paramr.atP = true;
      int i = paramr.atO;
      paramr.atQ = paramr.mRecyclerView.asc.findViewByPosition(i);
      paramr.mRecyclerView.asO.lM();
      paramr.mStarted = true;
    }
    
    public void stopIgnoringView(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      paramView.FV &= 0xFFFFFF7F;
      paramView.resetInternal();
      paramView.addFlags(4);
    }
    
    void stopSmoothScroller()
    {
      if (this.mSmoothScroller != null) {
        this.mSmoothScroller.stop();
      }
    }
    
    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }
    
    public static abstract interface a
    {
      public abstract void S(int paramInt1, int paramInt2);
    }
    
    public static final class b
    {
      public int att;
      public boolean atu;
      public boolean atv;
      public int orientation;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect apS = new Rect();
    public RecyclerView.v atw;
    boolean atx = true;
    boolean aty = false;
    
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
    
    public final int lG()
    {
      return this.atw.lR();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Parcelable atN;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader != null) {}
      for (;;)
      {
        this.atN = paramParcel.readParcelable(paramClassLoader);
        return;
        paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.atN, 0);
    }
  }
  
  public static abstract class a<VH extends RecyclerView.v>
  {
    public final RecyclerView.b atj = new RecyclerView.b();
    protected boolean atk = false;
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public void a(RecyclerView.c paramc)
    {
      this.atj.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public final void aq(int paramInt1, int paramInt2)
    {
      this.atj.aq(paramInt1, paramInt2);
    }
    
    public final void ar(int paramInt1, int paramInt2)
    {
      this.atj.ar(paramInt1, paramInt2);
    }
    
    public final void as(int paramInt1, int paramInt2)
    {
      this.atj.as(paramInt1, paramInt2);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      this.atj.at(paramInt1, paramInt2);
    }
    
    public void au(boolean paramBoolean)
    {
      if (this.atj.hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.atk = paramBoolean;
    }
    
    public final void b(int paramInt, Object paramObject)
    {
      this.atj.e(paramInt, 1, paramObject);
    }
    
    public void b(RecyclerView.c paramc)
    {
      this.atj.unregisterObserver(paramc);
    }
    
    public void b(RecyclerView paramRecyclerView) {}
    
    public void c(RecyclerView paramRecyclerView) {}
    
    public final void ci(int paramInt)
    {
      this.atj.aq(paramInt, 1);
    }
    
    public final void cj(int paramInt)
    {
      this.atj.as(paramInt, 1);
    }
    
    public final void ck(int paramInt)
    {
      this.atj.at(paramInt, 1);
    }
    
    public final VH d(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        e.beginSection("RV CreateView");
        paramViewGroup = a(paramViewGroup, paramInt);
        if (paramViewGroup.aus.getParent() != null) {
          throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        }
      }
      finally
      {
        e.endSection();
      }
      paramViewGroup.auw = paramInt;
      e.endSection();
      return paramViewGroup;
    }
    
    public final void e(int paramInt1, int paramInt2, Object paramObject)
    {
      this.atj.e(paramInt1, paramInt2, paramObject);
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
      this.atj.notifyChanged();
    }
  }
  
  public static final class b
    extends Observable<RecyclerView.c>
  {
    public final void aq(int paramInt1, int paramInt2)
    {
      e(paramInt1, paramInt2, null);
    }
    
    public final void ar(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public final void as(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void e(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
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
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2) {}
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  }
  
  public static abstract interface d
  {
    public abstract int au(int paramInt1, int paramInt2);
  }
  
  public static final class e
  {
    protected static EdgeEffect d(RecyclerView paramRecyclerView)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
  }
  
  public static abstract class f
  {
    b atl = null;
    private ArrayList<a> atm = new ArrayList();
    public long atn = 120L;
    public long ato = 120L;
    public long atp = 250L;
    public long atq = 250L;
    
    static int m(RecyclerView.v paramv)
    {
      int j = paramv.FV & 0xE;
      int i;
      if (paramv.isInvalid()) {
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
            k = paramv.auu;
            m = paramv.lR();
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
          parama.lD();
        }
      }
      else {
        return bool;
      }
      this.atm.add(parama);
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
    
    public abstract boolean isRunning();
    
    public abstract void jD();
    
    public abstract void jF();
    
    public final long lA()
    {
      return this.atq;
    }
    
    public final void lB()
    {
      this.atq = 0L;
    }
    
    public final void lC()
    {
      int j = this.atm.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.atm.get(i)).lD();
        i += 1;
      }
      this.atm.clear();
    }
    
    public final long lv()
    {
      return this.atp;
    }
    
    public final void lw()
    {
      this.atp = 0L;
    }
    
    public long lx()
    {
      return this.atn;
    }
    
    public long ly()
    {
      return this.ato;
    }
    
    public final void lz()
    {
      this.ato = 2000L;
    }
    
    public final void n(RecyclerView.v paramv)
    {
      o(paramv);
      if (this.atl != null) {
        this.atl.o(paramv);
      }
    }
    
    public void o(RecyclerView.v paramv) {}
    
    public boolean p(RecyclerView.v paramv)
    {
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void lD();
    }
    
    static abstract interface b
    {
      public abstract void o(RecyclerView.v paramv);
    }
    
    public static class c
    {
      public int atr;
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public c c(RecyclerView.v paramv, int paramInt)
      {
        paramv = paramv.aus;
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
      paramv.av(true);
      if ((paramv.auy != null) && (paramv.auz == null)) {
        paramv.auy = null;
      }
      paramv.auz = null;
      int i;
      RecyclerView localRecyclerView;
      Object localObject;
      s locals;
      if ((paramv.FV & 0x10) != 0)
      {
        i = 1;
        if (i == 0)
        {
          localRecyclerView = RecyclerView.this;
          localObject = paramv.aus;
          localRecyclerView.kP();
          locals = localRecyclerView.mChildHelper;
          i = locals.alX.indexOfChild((View)localObject);
          if (i != -1) {
            break label169;
          }
          locals.bg((View)localObject);
          i = 1;
          label99:
          if (i != 0)
          {
            localObject = RecyclerView.bv((View)localObject);
            localRecyclerView.arV.u((RecyclerView.v)localObject);
            localRecyclerView.arV.t((RecyclerView.v)localObject);
          }
          if (i != 0) {
            break label220;
          }
        }
      }
      for (;;)
      {
        localRecyclerView.ar(bool);
        if ((i == 0) && (paramv.mb())) {
          RecyclerView.this.removeDetachedView(paramv.aus, false);
        }
        return;
        i = 0;
        break;
        label169:
        if (locals.alY.get(i))
        {
          locals.alY.remove(i);
          locals.bg((View)localObject);
          locals.alX.removeViewAt(i);
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
    
    @Deprecated
    public void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      a(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).atw.lQ(), paramRecyclerView);
    }
    
    public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params) {}
  }
  
  public static abstract interface i
  {
    public abstract void bD(View paramView);
    
    public abstract void bE(View paramView);
  }
  
  public static abstract class j
  {
    public abstract boolean av(int paramInt1, int paramInt2);
  }
  
  public static abstract interface k
  {
    public abstract boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void ah(boolean paramBoolean);
    
    public abstract void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public static abstract class l
  {
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {}
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
  
  public static class m
  {
    int atA = 0;
    SparseArray<a> atz = new SparseArray();
    
    static long c(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    public final void aw(int paramInt1, int paramInt2)
    {
      Object localObject = cn(paramInt1);
      ((a)localObject).atC = paramInt2;
      localObject = ((a)localObject).atB;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
    }
    
    final boolean b(int paramInt, long paramLong1, long paramLong2)
    {
      long l = cn(paramInt).atD;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }
    
    public final int cl(int paramInt)
    {
      return cn(paramInt).atB.size();
    }
    
    public final void clear()
    {
      int i = 0;
      while (i < this.atz.size())
      {
        ((a)this.atz.valueAt(i)).atB.clear();
        i += 1;
      }
    }
    
    public RecyclerView.v cm(int paramInt)
    {
      Object localObject = (a)this.atz.get(paramInt);
      if ((localObject != null) && (!((a)localObject).atB.isEmpty()))
      {
        localObject = ((a)localObject).atB;
        return (RecyclerView.v)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      return null;
    }
    
    final a cn(int paramInt)
    {
      a locala2 = (a)this.atz.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.atz.put(paramInt, locala1);
      }
      return locala1;
    }
    
    final void d(int paramInt, long paramLong)
    {
      a locala = cn(paramInt);
      locala.atD = c(locala.atD, paramLong);
    }
    
    final void detach()
    {
      this.atA -= 1;
    }
    
    final void lH()
    {
      this.atA += 1;
    }
    
    public void q(RecyclerView.v paramv)
    {
      int i = paramv.auw;
      ArrayList localArrayList = cn(i).atB;
      if (((a)this.atz.get(i)).atC <= localArrayList.size()) {
        return;
      }
      paramv.resetInternal();
      localArrayList.add(paramv);
    }
    
    static final class a
    {
      final ArrayList<RecyclerView.v> atB = new ArrayList();
      int atC = 5;
      long atD = 0L;
      long atE = 0L;
    }
  }
  
  public final class n
  {
    final ArrayList<RecyclerView.v> atF = new ArrayList();
    ArrayList<RecyclerView.v> atG = null;
    final ArrayList<RecyclerView.v> atH = new ArrayList();
    final List<RecyclerView.v> atI = Collections.unmodifiableList(this.atF);
    int atJ = 2;
    int atK = 2;
    RecyclerView.m atL;
    RecyclerView.t atM;
    
    public n() {}
    
    private RecyclerView.v a(long paramLong, int paramInt, boolean paramBoolean)
    {
      int i = this.atF.size() - 1;
      RecyclerView.v localv;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.atF.get(i);
        if ((localv.auv == paramLong) && (!localv.lX()))
        {
          if (paramInt == localv.auw)
          {
            localv.addFlags(32);
            if ((localv.isRemoved()) && (!RecyclerView.this.asR.aue)) {
              localv.setFlags(2, 14);
            }
            return localv;
          }
          this.atF.remove(i);
          RecyclerView.this.removeDetachedView(localv.aus, false);
          bG(localv.aus);
        }
        i -= 1;
      }
      i = this.atH.size() - 1;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.atH.get(i);
        if (localv.auv == paramLong)
        {
          if (paramInt == localv.auw)
          {
            this.atH.remove(i);
            return localv;
          }
          cr(i);
          return null;
        }
        i -= 1;
      }
      return null;
    }
    
    private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, long paramLong)
    {
      paramv.auI = RecyclerView.this;
      int i = paramv.auw;
      long l1 = RecyclerView.this.getNanoTime();
      if (paramLong != 9223372036854775807L)
      {
        long l2 = this.atL.cn(i).atE;
        if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
        for (i = 1; i == 0; i = 0) {
          return false;
        }
      }
      Object localObject = RecyclerView.this.adj;
      paramv.mPosition = paramInt1;
      if (((RecyclerView.a)localObject).atk) {
        paramv.auv = ((RecyclerView.a)localObject).getItemId(paramInt1);
      }
      paramv.setFlags(1, 519);
      e.beginSection("RV OnBindView");
      ((RecyclerView.a)localObject).a(paramv, paramInt1, paramv.me());
      paramv.md();
      localObject = paramv.aus.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)localObject).atx = true;
      }
      e.endSection();
      paramLong = RecyclerView.this.getNanoTime();
      localObject = this.atL.cn(paramv.auw);
      ((RecyclerView.m.a)localObject).atE = RecyclerView.m.c(((RecyclerView.m.a)localObject).atE, paramLong - l1);
      if (RecyclerView.this.lb())
      {
        localObject = paramv.aus;
        if (u.Y((View)localObject) == 0) {
          u.p((View)localObject, 1);
        }
        if (!u.V((View)localObject))
        {
          paramv.addFlags(16384);
          u.a((View)localObject, RecyclerView.this.asY.auJ);
        }
      }
      if (RecyclerView.this.asR.aue) {
        paramv.aux = paramInt2;
      }
      return true;
    }
    
    private RecyclerView.v cs(int paramInt)
    {
      int j = 0;
      int k;
      if (this.atG != null)
      {
        k = this.atG.size();
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
        localv = (RecyclerView.v)this.atG.get(i);
        if ((!localv.lX()) && (localv.lQ() == paramInt))
        {
          localv.addFlags(32);
          return localv;
        }
        i += 1;
      }
      if (RecyclerView.this.adj.atk)
      {
        paramInt = RecyclerView.this.arX.M(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.adj.getItemCount()))
        {
          long l = RecyclerView.this.adj.getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localv = (RecyclerView.v)this.atG.get(paramInt);
            if ((!localv.lX()) && (localv.auv == l))
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
    
    private RecyclerView.v l(int paramInt, boolean paramBoolean)
    {
      int j = 0;
      int k = this.atF.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.atF.get(i);
        if ((!((RecyclerView.v)localObject1).lX()) && (((RecyclerView.v)localObject1).lQ() == paramInt) && (!((RecyclerView.v)localObject1).isInvalid()) && ((RecyclerView.this.asR.aue) || (!((RecyclerView.v)localObject1).isRemoved())))
        {
          ((RecyclerView.v)localObject1).addFlags(32);
          return localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.mChildHelper;
      k = ((s)localObject2).alZ.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((s)localObject2).alZ.get(i);
        localObject3 = ((s)localObject2).alX.bi((View)localObject1);
        if ((((RecyclerView.v)localObject3).lQ() != paramInt) || (((RecyclerView.v)localObject3).isInvalid()) || (((RecyclerView.v)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.bv((View)localObject1);
          localObject3 = RecyclerView.this.mChildHelper;
          paramInt = ((s)localObject3).alX.indexOfChild((View)localObject1);
          if (paramInt < 0)
          {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((s)localObject3).alY.get(paramInt)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
          }
          ((s)localObject3).alY.clear(paramInt);
          ((s)localObject3).bg((View)localObject1);
          paramInt = RecyclerView.this.mChildHelper.indexOfChild((View)localObject1);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + RecyclerView.this.kL());
          }
          RecyclerView.this.mChildHelper.detachViewFromParent(paramInt);
          bH((View)localObject1);
          ((RecyclerView.v)localObject2).addFlags(8224);
          return localObject2;
        }
      }
      k = this.atH.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.atH.get(i);
        if ((!((RecyclerView.v)localObject1).isInvalid()) && (((RecyclerView.v)localObject1).lQ() == paramInt))
        {
          this.atH.remove(i);
          return localObject1;
        }
        i += 1;
      }
      return null;
    }
    
    private void lJ()
    {
      int i = this.atH.size() - 1;
      while (i >= 0)
      {
        cr(i);
        i -= 1;
      }
      this.atH.clear();
      if (RecyclerView.arQ) {
        RecyclerView.this.asQ.jL();
      }
    }
    
    private boolean r(RecyclerView.v paramv)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramv.isRemoved()) {
        bool1 = RecyclerView.this.asR.aue;
      }
      do
      {
        do
        {
          return bool1;
          if ((paramv.mPosition < 0) || (paramv.mPosition >= RecyclerView.this.adj.getItemCount())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramv + RecyclerView.this.kL());
          }
          if (RecyclerView.this.asR.aue) {
            break;
          }
          bool1 = bool2;
        } while (RecyclerView.this.adj.getItemViewType(paramv.mPosition) != paramv.auw);
        if (!RecyclerView.this.adj.atk) {
          break;
        }
        bool1 = bool2;
      } while (paramv.auv != RecyclerView.this.adj.getItemId(paramv.mPosition));
      return true;
      return true;
    }
    
    private void s(RecyclerView.v paramv)
    {
      if ((paramv.aus instanceof ViewGroup)) {
        d((ViewGroup)paramv.aus, false);
      }
    }
    
    private void v(RecyclerView.v paramv)
    {
      if (RecyclerView.this.adj != null) {
        RecyclerView.this.adj.a(paramv);
      }
      if (RecyclerView.this.asR != null) {
        RecyclerView.this.arY.K(paramv);
      }
    }
    
    final void a(RecyclerView.v paramv, boolean paramBoolean)
    {
      RecyclerView.h(paramv);
      if (paramv.cv(16384))
      {
        paramv.setFlags(0, 16384);
        u.a(paramv.aus, null);
      }
      if (paramBoolean) {
        v(paramv);
      }
      paramv.auI = null;
      getRecycledViewPool().q(paramv);
    }
    
    public final void bF(View paramView)
    {
      RecyclerView.v localv = RecyclerView.bv(paramView);
      if (localv.mb()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localv.lV()) {
        localv.lW();
      }
      for (;;)
      {
        t(localv);
        return;
        if (localv.lX()) {
          localv.lY();
        }
      }
    }
    
    final void bG(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      paramView.auE = null;
      paramView.auF = false;
      paramView.lY();
      t(paramView);
    }
    
    final void bH(View paramView)
    {
      paramView = RecyclerView.bv(paramView);
      int i;
      if ((!paramView.cv(12)) && (paramView.mh()))
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.asC != null) && (!localRecyclerView.asC.a(paramView, paramView.me()))) {
          break label112;
        }
        i = 1;
      }
      while (i != 0) {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.adj.atk))
        {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.kL());
          label112:
          i = 0;
        }
        else
        {
          paramView.a(this, false);
          this.atF.add(paramView);
          return;
        }
      }
      if (this.atG == null) {
        this.atG = new ArrayList();
      }
      paramView.a(this, true);
      this.atG.add(paramView);
    }
    
    public final void clear()
    {
      this.atF.clear();
      lJ();
    }
    
    public final int co(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.asR.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.asR.getItemCount() + RecyclerView.this.kL());
      }
      if (!RecyclerView.this.asR.aue) {
        return paramInt;
      }
      return RecyclerView.this.arX.bE(paramInt);
    }
    
    public final View cp(int paramInt)
    {
      return cq(paramInt);
    }
    
    final View cq(int paramInt)
    {
      return e(paramInt, 9223372036854775807L).aus;
    }
    
    final void cr(int paramInt)
    {
      a((RecyclerView.v)this.atH.get(paramInt), true);
      this.atH.remove(paramInt);
    }
    
    final RecyclerView.v e(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.asR.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.asR.getItemCount() + RecyclerView.this.kL());
      }
      Object localObject1;
      int i;
      if (RecyclerView.this.asR.aue)
      {
        localObject1 = cs(paramInt);
        if (localObject1 != null) {
          i = 1;
        }
      }
      for (int j = i;; j = 0)
      {
        Object localObject2;
        if (localObject1 == null)
        {
          localObject2 = l(paramInt, false);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null)
          {
            if (r((RecyclerView.v)localObject2)) {
              break label322;
            }
            ((RecyclerView.v)localObject2).addFlags(4);
            if (!((RecyclerView.v)localObject2).lV()) {
              break label306;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.v)localObject2).aus, false);
            ((RecyclerView.v)localObject2).lW();
            label184:
            t((RecyclerView.v)localObject2);
            localObject1 = null;
            i = j;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int k = RecyclerView.this.arX.bE(paramInt);
            if ((k < 0) || (k >= RecyclerView.this.adj.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.asR.getItemCount() + RecyclerView.this.kL());
              i = 0;
              break;
              label306:
              if (!((RecyclerView.v)localObject2).lX()) {
                break label184;
              }
              ((RecyclerView.v)localObject2).lY();
              break label184;
              label322:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.this.adj.getItemViewType(k);
            if (RecyclerView.this.adj.atk)
            {
              localObject2 = a(RecyclerView.this.adj.getItemId(k), j, false);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.v)localObject2).mPosition = k;
                i = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject2 = getRecycledViewPool().cm(j);
                  localObject1 = localObject2;
                  if (localObject2 != null)
                  {
                    ((RecyclerView.v)localObject2).resetInternal();
                    localObject1 = localObject2;
                    if (RecyclerView.arN)
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
                  if ((paramLong != 9223372036854775807L) && (!this.atL.b(j, l1, paramLong))) {
                    return null;
                  }
                  localObject2 = RecyclerView.this.adj.d(RecyclerView.this, j);
                  if (RecyclerView.arQ)
                  {
                    localObject1 = RecyclerView.bz(((RecyclerView.v)localObject2).aus);
                    if (localObject1 != null) {
                      ((RecyclerView.v)localObject2).aut = new WeakReference(localObject1);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.atL.d(j, l2 - l1);
                }
              }
            }
          }
          for (;;)
          {
            if ((i != 0) && (!RecyclerView.this.asR.aue) && (((RecyclerView.v)localObject2).cv(8192)))
            {
              ((RecyclerView.v)localObject2).setFlags(0, 8192);
              if (RecyclerView.this.asR.auh)
              {
                j = RecyclerView.f.m((RecyclerView.v)localObject2);
                localObject1 = RecyclerView.this.asC.a(RecyclerView.this.asR, (RecyclerView.v)localObject2, j | 0x1000, ((RecyclerView.v)localObject2).me());
                RecyclerView.this.a((RecyclerView.v)localObject2, (RecyclerView.f.c)localObject1);
              }
            }
            boolean bool1;
            if ((RecyclerView.this.asR.aue) && (((RecyclerView.v)localObject2).isBound()))
            {
              ((RecyclerView.v)localObject2).aux = paramInt;
              bool1 = false;
            }
            for (;;)
            {
              localObject1 = ((RecyclerView.v)localObject2).aus.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                ((RecyclerView.v)localObject2).aus.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label740:
                ((RecyclerView.LayoutParams)localObject1).atw = ((RecyclerView.v)localObject2);
                if ((i == 0) || (!bool1)) {
                  break label868;
                }
              }
              label868:
              for (bool1 = bool2;; bool1 = false)
              {
                ((RecyclerView.LayoutParams)localObject1).aty = bool1;
                return localObject2;
                if ((((RecyclerView.v)localObject2).isBound()) && (!((RecyclerView.v)localObject2).ma()) && (!((RecyclerView.v)localObject2).isInvalid())) {
                  break label874;
                }
                bool1 = a((RecyclerView.v)localObject2, RecyclerView.this.arX.bE(paramInt), paramInt, paramLong);
                break;
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((RecyclerView.v)localObject2).aus.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  break label740;
                }
                localObject1 = (RecyclerView.LayoutParams)localObject1;
                break label740;
              }
              label874:
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
    
    final RecyclerView.m getRecycledViewPool()
    {
      if (this.atL == null) {
        this.atL = new RecyclerView.m();
      }
      return this.atL;
    }
    
    final void lI()
    {
      if (RecyclerView.this.asc != null) {}
      for (int i = RecyclerView.this.asc.mPrefetchMaxCountObserved;; i = 0)
      {
        this.atK = (i + this.atJ);
        i = this.atH.size() - 1;
        while ((i >= 0) && (this.atH.size() > this.atK))
        {
          cr(i);
          i -= 1;
        }
      }
    }
    
    final void lq()
    {
      int j = 0;
      int k = this.atH.size();
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.atH.get(i)).lN();
        i += 1;
      }
      k = this.atF.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.atF.get(i)).lN();
        i += 1;
      }
      if (this.atG != null)
      {
        k = this.atG.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.v)this.atG.get(i)).lN();
          i += 1;
        }
      }
    }
    
    final void lr()
    {
      int j = this.atH.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.v localv = (RecyclerView.v)this.atH.get(i);
        if (localv != null)
        {
          localv.addFlags(6);
          localv.O(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.adj == null) || (!RecyclerView.this.adj.atk)) {
        lJ();
      }
    }
    
    final void t(RecyclerView.v paramv)
    {
      int k = 1;
      if ((paramv.lV()) || (paramv.aus.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramv.lV()).append(" isAttached:");
        if (paramv.aus.getParent() != null) {}
        for (bool = true;; bool = false) {
          throw new IllegalArgumentException(bool + RecyclerView.this.kL());
        }
      }
      if (paramv.mb()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv + RecyclerView.this.kL());
      }
      if (paramv.lP()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.kL());
      }
      boolean bool = paramv.mg();
      int j;
      int i;
      if (paramv.mf()) {
        if ((this.atK > 0) && (!paramv.cv(526)))
        {
          j = this.atH.size();
          i = j;
          if (j >= this.atK)
          {
            i = j;
            if (j > 0)
            {
              cr(0);
              i = j - 1;
            }
          }
          j = i;
          if (RecyclerView.arQ)
          {
            j = i;
            if (i > 0)
            {
              j = i;
              if (!RecyclerView.this.asQ.bP(paramv.mPosition))
              {
                i -= 1;
                while (i >= 0)
                {
                  j = ((RecyclerView.v)this.atH.get(i)).mPosition;
                  if (!RecyclerView.this.asQ.bP(j)) {
                    break;
                  }
                  i -= 1;
                }
                j = i + 1;
              }
            }
          }
          this.atH.add(j, paramv);
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
        RecyclerView.this.arY.K(paramv);
        if ((i == 0) && (j == 0) && (bool)) {
          paramv.auI = null;
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
      if (paramv.auF) {
        this.atG.remove(paramv);
      }
      for (;;)
      {
        paramv.auE = null;
        paramv.auF = false;
        paramv.lY();
        return;
        this.atF.remove(paramv);
      }
    }
  }
  
  public static abstract interface o {}
  
  final class p
    extends RecyclerView.c
  {
    p() {}
    
    private void lK()
    {
      if ((RecyclerView.arP) && (RecyclerView.this.asi) && (RecyclerView.this.ash))
      {
        u.b(RecyclerView.this, RecyclerView.this.asa);
        return;
      }
      RecyclerView.this.asq = true;
      RecyclerView.this.requestLayout();
    }
    
    public final void onChanged()
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView.this.asR.aud = true;
      RecyclerView.this.at(true);
      if (!RecyclerView.this.arX.jc()) {
        RecyclerView.this.requestLayout();
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      d locald = RecyclerView.this.arX;
      if (paramInt2 > 0)
      {
        locald.ajS.add(locald.a(4, paramInt1, paramInt2, paramObject));
        locald.ajY |= 0x4;
        if (locald.ajS.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lK();
        }
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      d locald = RecyclerView.this.arX;
      if (paramInt2 > 0)
      {
        locald.ajS.add(locald.a(1, paramInt1, paramInt2, null));
        locald.ajY |= 0x1;
        if (locald.ajS.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lK();
        }
        return;
      }
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      d locald = RecyclerView.this.arX;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1) {
          throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        locald.ajS.add(locald.a(8, paramInt1, paramInt2, null));
        locald.ajY |= 0x8;
        if (locald.ajS.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lK();
        }
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      d locald = RecyclerView.this.arX;
      if (paramInt2 > 0)
      {
        locald.ajS.add(locald.a(2, paramInt1, paramInt2, null));
        locald.ajY |= 0x2;
        if (locald.ajS.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lK();
        }
        return;
      }
    }
  }
  
  public static abstract class r
  {
    RecyclerView.LayoutManager arI;
    public int atO = -1;
    boolean atP;
    View atQ;
    private final a atR = new a();
    boolean gc;
    RecyclerView mRecyclerView;
    boolean mStarted;
    
    protected abstract void a(int paramInt1, int paramInt2, a parama);
    
    protected abstract void a(View paramView, RecyclerView.s params, a parama);
    
    final void ax(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((!this.gc) || (this.atO == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.atP) && (this.atQ == null) && (this.arI != null))
      {
        PointF localPointF = bZ(this.atO);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.b((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.atP = false;
      if (this.atQ != null)
      {
        if (RecyclerView.bx(this.atQ) != this.atO) {
          break label233;
        }
        a(this.atQ, localRecyclerView.asR, this.atR);
        this.atR.e(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.gc)
        {
          a(paramInt1, paramInt2, this.atR);
          paramInt1 = i;
          if (this.atR.atV >= 0) {
            paramInt1 = 1;
          }
          this.atR.e(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.gc) {
              break;
            }
            this.atP = true;
            localRecyclerView.asO.lM();
          }
        }
        return;
        label233:
        this.atQ = null;
      }
      stop();
    }
    
    public PointF bZ(int paramInt)
    {
      RecyclerView.LayoutManager localLayoutManager = this.arI;
      if ((localLayoutManager instanceof b)) {
        return ((b)localLayoutManager).bZ(paramInt);
      }
      new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
      return null;
    }
    
    public final void ct(int paramInt)
    {
      this.atO = paramInt;
    }
    
    public final RecyclerView.LayoutManager getLayoutManager()
    {
      return this.arI;
    }
    
    public final boolean isRunning()
    {
      return this.gc;
    }
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.gc) {
        return;
      }
      this.gc = false;
      onStop();
      this.mRecyclerView.asR.atO = -1;
      this.atQ = null;
      this.atO = -1;
      this.atP = false;
      this.arI.onSmoothScrollerStopped(this);
      this.arI = null;
      this.mRecyclerView = null;
    }
    
    public static final class a
    {
      private int atS = 0;
      private int atT = 0;
      private int atU = -2147483648;
      int atV = -1;
      private boolean atW = false;
      private int atX = 0;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this((byte)0);
      }
      
      private a(byte paramByte) {}
      
      private void validate()
      {
        if ((this.mInterpolator != null) && (this.atU <= 0)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.atU <= 0) {
          throw new IllegalStateException("Scroll duration must be a positive number");
        }
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.atS = paramInt1;
        this.atT = paramInt2;
        this.atU = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.atW = true;
      }
      
      final void e(RecyclerView paramRecyclerView)
      {
        if (this.atV >= 0)
        {
          int i = this.atV;
          this.atV = -1;
          paramRecyclerView.cf(i);
          this.atW = false;
          return;
        }
        if (this.atW)
        {
          validate();
          if (this.mInterpolator == null) {
            if (this.atU == -2147483648) {
              paramRecyclerView.asO.ay(this.atS, this.atT);
            }
          }
          for (;;)
          {
            this.atX += 1;
            this.atW = false;
            return;
            paramRecyclerView.asO.l(this.atS, this.atT, this.atU);
            continue;
            paramRecyclerView.asO.b(this.atS, this.atT, this.atU, this.mInterpolator);
          }
        }
        this.atX = 0;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF bZ(int paramInt);
    }
  }
  
  public static final class s
  {
    int atO = -1;
    private SparseArray<Object> atY;
    int atZ = 0;
    int aua = 0;
    int aub = 1;
    int auc = 0;
    boolean aud = false;
    public boolean aue = false;
    boolean auf = false;
    boolean aug = false;
    boolean auh = false;
    public boolean aui = false;
    int auj;
    long auk;
    int aul;
    int aum;
    int aun;
    
    final void cu(int paramInt)
    {
      if ((this.aub & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.aub));
      }
    }
    
    public final int getItemCount()
    {
      if (this.aue) {
        return this.atZ - this.aua;
      }
      return this.auc;
    }
    
    public final boolean lL()
    {
      return this.aue;
    }
    
    public final String toString()
    {
      return "State{mTargetPosition=" + this.atO + ", mData=" + this.atY + ", mItemCount=" + this.auc + ", mIsMeasuring=" + this.aug + ", mPreviousLayoutItemCount=" + this.atZ + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.aua + ", mStructureChanged=" + this.aud + ", mInPreLayout=" + this.aue + ", mRunSimpleAnimations=" + this.auh + ", mRunPredictiveAnimations=" + this.aui + '}';
    }
  }
  
  public static abstract class t {}
  
  final class u
    implements Runnable
  {
    OverScroller UD = new OverScroller(RecyclerView.this.getContext(), RecyclerView.atg);
    int auo;
    int aup;
    private boolean auq = false;
    private boolean aur = false;
    Interpolator mInterpolator = RecyclerView.atg;
    
    u() {}
    
    private static float distanceInfluenceForSnapDuration(float paramFloat)
    {
      return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    }
    
    final void ay(int paramInt1, int paramInt2)
    {
      l(paramInt1, paramInt2, az(paramInt1, paramInt2));
    }
    
    final int az(int paramInt1, int paramInt2)
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
        this.UD = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.aup = 0;
      this.auo = 0;
      this.UD.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.UD.computeScrollOffset();
      }
      lM();
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      b(paramInt1, paramInt2, paramInt3, RecyclerView.atg);
    }
    
    final void lM()
    {
      if (this.auq)
      {
        this.aur = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      u.b(RecyclerView.this, this);
    }
    
    public final void run()
    {
      if (RecyclerView.this.asc == null)
      {
        stop();
        return;
      }
      this.aur = false;
      this.auq = true;
      RecyclerView.this.kO();
      OverScroller localOverScroller = this.UD;
      RecyclerView.r localr = RecyclerView.this.asc.mSmoothScroller;
      int i6;
      int i7;
      int k;
      int j;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.UO;
        i6 = localOverScroller.getCurrX();
        i7 = localOverScroller.getCurrY();
        k = i6 - this.auo;
        j = i7 - this.aup;
        this.auo = i6;
        this.aup = i7;
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
        if (RecyclerView.this.adj != null)
        {
          RecyclerView.this.b(k, j, RecyclerView.this.atd);
          i = RecyclerView.this.atd[0];
          i3 = RecyclerView.this.atd[1];
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
            if (!localr.atP)
            {
              m = i;
              n = i3;
              i1 = i4;
              i2 = i5;
              if (localr.gc)
              {
                m = RecyclerView.this.asR.getItemCount();
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
          if (!RecyclerView.this.ase.isEmpty()) {
            RecyclerView.this.invalidate();
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.al(k, j);
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
                RecyclerView.this.am(i4, i);
              }
              if (((i4 != 0) || (i1 == i6) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (i2 == i7) || (localOverScroller.getFinalY() == 0))) {
                localOverScroller.abortAnimation();
              }
              if ((m != 0) || (n != 0)) {
                RecyclerView.this.ap(m, n);
              }
              if (!RecyclerView.a(RecyclerView.this)) {
                RecyclerView.this.invalidate();
              }
              if ((j != 0) && (RecyclerView.this.asc.canScrollVertically()) && (n == j))
              {
                i = 1;
                if ((k == 0) || (!RecyclerView.this.asc.canScrollHorizontally()) || (m != k)) {
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
                if (RecyclerView.arQ) {
                  RecyclerView.this.asQ.jL();
                }
                RecyclerView.this.aM(1);
              }
              for (;;)
              {
                if (localr != null)
                {
                  if (localr.atP) {
                    localr.ax(0, 0);
                  }
                  if (!this.aur) {
                    localr.stop();
                  }
                }
                this.auq = false;
                if (!this.aur) {
                  break;
                }
                lM();
                return;
                if (localr.atO >= m) {
                  localr.atO = (m - 1);
                }
                localr.ax(k - i4, j - i5);
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
                lM();
                if (RecyclerView.this.asP != null) {
                  RecyclerView.this.asP.a(RecyclerView.this, k, j);
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
      this.UD.abortAnimation();
    }
  }
  
  public static abstract class v
  {
    private static final List<Object> auA = ;
    int FV;
    List<Object> auB = null;
    List<Object> auC = null;
    private int auD = 0;
    RecyclerView.n auE = null;
    boolean auF = false;
    int auG = 0;
    int auH = -1;
    RecyclerView auI;
    public final View aus;
    WeakReference<RecyclerView> aut;
    public int auu = -1;
    public long auv = -1L;
    public int auw = -1;
    int aux = -1;
    v auy = null;
    v auz = null;
    int mPosition = -1;
    
    public v(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.aus = paramView;
    }
    
    private void mc()
    {
      if (this.auB == null)
      {
        this.auB = new ArrayList();
        this.auC = Collections.unmodifiableList(this.auB);
      }
    }
    
    final void O(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((this.FV & 0x400) != 0) {
        return;
      }
      mc();
      this.auB.add(paramObject);
    }
    
    final void a(RecyclerView.n paramn, boolean paramBoolean)
    {
      this.auE = paramn;
      this.auF = paramBoolean;
    }
    
    final void addFlags(int paramInt)
    {
      this.FV |= paramInt;
    }
    
    public final void av(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.auD - 1;
        this.auD = i;
        if (this.auD >= 0) {
          break label53;
        }
        this.auD = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.auD + 1;
        break;
        if ((!paramBoolean) && (this.auD == 1))
        {
          this.FV |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.auD != 0));
      this.FV &= 0xFFFFFFEF;
    }
    
    final boolean cv(int paramInt)
    {
      return (this.FV & paramInt) != 0;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.aux == -1) {
        return this.mPosition;
      }
      return this.aux;
    }
    
    final boolean isBound()
    {
      return (this.FV & 0x1) != 0;
    }
    
    final boolean isInvalid()
    {
      return (this.FV & 0x4) != 0;
    }
    
    public final boolean isRemoved()
    {
      return (this.FV & 0x8) != 0;
    }
    
    final void lN()
    {
      this.auu = -1;
      this.aux = -1;
    }
    
    final void lO()
    {
      if (this.auu == -1) {
        this.auu = this.mPosition;
      }
    }
    
    final boolean lP()
    {
      return (this.FV & 0x80) != 0;
    }
    
    public final int lQ()
    {
      if (this.aux == -1) {
        return this.mPosition;
      }
      return this.aux;
    }
    
    public final int lR()
    {
      if (this.auI == null) {
        return -1;
      }
      return this.auI.i(this);
    }
    
    public final int lS()
    {
      return this.auu;
    }
    
    public final long lT()
    {
      return this.auv;
    }
    
    public final int lU()
    {
      return this.auw;
    }
    
    final boolean lV()
    {
      return this.auE != null;
    }
    
    final void lW()
    {
      this.auE.u(this);
    }
    
    final boolean lX()
    {
      return (this.FV & 0x20) != 0;
    }
    
    final void lY()
    {
      this.FV &= 0xFFFFFFDF;
    }
    
    final void lZ()
    {
      this.FV &= 0xFFFFFEFF;
    }
    
    final void m(int paramInt, boolean paramBoolean)
    {
      if (this.auu == -1) {
        this.auu = this.mPosition;
      }
      if (this.aux == -1) {
        this.aux = this.mPosition;
      }
      if (paramBoolean) {
        this.aux += paramInt;
      }
      this.mPosition += paramInt;
      if (this.aus.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.aus.getLayoutParams()).atx = true;
      }
    }
    
    final boolean ma()
    {
      return (this.FV & 0x2) != 0;
    }
    
    final boolean mb()
    {
      return (this.FV & 0x100) != 0;
    }
    
    final void md()
    {
      if (this.auB != null) {
        this.auB.clear();
      }
      this.FV &= 0xFFFFFBFF;
    }
    
    final List<Object> me()
    {
      if ((this.FV & 0x400) == 0)
      {
        if ((this.auB == null) || (this.auB.size() == 0)) {
          return auA;
        }
        return this.auC;
      }
      return auA;
    }
    
    public final boolean mf()
    {
      return ((this.FV & 0x10) == 0) && (!u.W(this.aus));
    }
    
    final boolean mg()
    {
      return ((this.FV & 0x10) == 0) && (u.W(this.aus));
    }
    
    final boolean mh()
    {
      return (this.FV & 0x2) != 0;
    }
    
    final void resetInternal()
    {
      this.FV = 0;
      this.mPosition = -1;
      this.auu = -1;
      this.auv = -1L;
      this.aux = -1;
      this.auD = 0;
      this.auy = null;
      this.auz = null;
      md();
      this.auG = 0;
      this.auH = -1;
      RecyclerView.h(this);
    }
    
    final void setFlags(int paramInt1, int paramInt2)
    {
      this.FV = (this.FV & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.auv + ", oldPos=" + this.auu + ", pLpos:" + this.aux);
      String str;
      if (lV())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.auF)
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
        if (ma()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (lP()) {
          localStringBuilder1.append(" ignored");
        }
        if (mb()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!mf()) {
          localStringBuilder1.append(" not recyclable(" + this.auD + ")");
        }
        if (((this.FV & 0x200) == 0) && (!isInvalid())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.aus.getParent() == null) {
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