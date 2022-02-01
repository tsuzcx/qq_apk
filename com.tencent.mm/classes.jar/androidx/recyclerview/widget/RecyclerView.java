package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import androidx.core.c.g;
import androidx.core.g.a.b;
import androidx.core.g.a.d.b;
import androidx.core.g.a.d.c;
import androidx.core.g.aa;
import androidx.core.g.l;
import androidx.core.g.n;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements l, w
{
  private static final int[] bYj;
  private static final int[] bYk;
  static final boolean bYl;
  static final boolean bYm;
  static final boolean bYn;
  static final boolean bYo;
  private static final boolean bYp;
  private static final boolean bYq;
  private static final Class<?>[] bYr;
  static final Interpolator bZB;
  boolean bIj;
  RecyclerView.a bUp;
  private d bWO;
  LayoutManager bYA;
  o bYB;
  final ArrayList<RecyclerView.h> bYC;
  private final ArrayList<k> bYD;
  private k bYE;
  boolean bYF;
  boolean bYG;
  boolean bYH;
  private int bYI;
  boolean bYJ;
  public boolean bYK;
  private boolean bYL;
  private int bYM;
  boolean bYN;
  private final AccessibilityManager bYO;
  List<i> bYP;
  boolean bYQ;
  boolean bYR;
  private int bYS;
  private int bYT;
  private e bYU;
  private EdgeEffect bYV;
  private EdgeEffect bYW;
  private EdgeEffect bYX;
  private EdgeEffect bYY;
  f bYZ;
  private final p bYs;
  final n bYt;
  private SavedState bYu;
  a bYv;
  final z bYw;
  boolean bYx;
  final Runnable bYy;
  final RectF bYz;
  private Runnable bZA;
  private final z.b bZC;
  private int bZa;
  private int bZb;
  private int bZc;
  private int bZd;
  private int bZe;
  private RecyclerView.j bZf;
  private final int bZg;
  private float bZh;
  private float bZi;
  private boolean bZj;
  final u bZk;
  j bZl;
  j.a bZm;
  final s bZn;
  private RecyclerView.l bZo;
  private List<RecyclerView.l> bZp;
  boolean bZq;
  boolean bZr;
  private RecyclerView.f.b bZs;
  boolean bZt;
  u bZu;
  private final int[] bZv;
  private n bZw;
  private final int[] bZx;
  final int[] bZy;
  final List<v> bZz;
  private final int[] bwI;
  final int[] bwJ;
  private final Rect hy;
  e mChildHelper;
  private int mScrollState;
  final Rect mTempRect;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private final int wV;
  
  static
  {
    AppMethodBeat.i(195489);
    bYj = new int[] { 16843830 };
    bYk = new int[] { 16842987 };
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      bYl = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label179;
      }
      bool = true;
      label67:
      bYm = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label184;
      }
      bool = true;
      label81:
      bYn = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label189;
      }
      bool = true;
      label95:
      bYo = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label194;
      }
      bool = true;
      label109:
      bYp = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label199;
      }
    }
    label179:
    label184:
    label189:
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      bYq = bool;
      bYr = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      bZB = new RecyclerView.3();
      AppMethodBeat.o(195489);
      return;
      bool = false;
      break;
      bool = false;
      break label67;
      bool = false;
      break label81;
      bool = false;
      break label95;
      bool = false;
      break label109;
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
    AppMethodBeat.i(195161);
    this.bYs = new p();
    this.bYt = new n();
    this.bYw = new z();
    this.bYy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195180);
        if ((!RecyclerView.this.bYH) || (RecyclerView.this.isLayoutRequested()))
        {
          AppMethodBeat.o(195180);
          return;
        }
        if (!RecyclerView.this.bIj)
        {
          RecyclerView.this.requestLayout();
          AppMethodBeat.o(195180);
          return;
        }
        if (RecyclerView.this.bYK)
        {
          RecyclerView.this.bYJ = true;
          AppMethodBeat.o(195180);
          return;
        }
        RecyclerView.this.JM();
        AppMethodBeat.o(195180);
      }
    };
    this.mTempRect = new Rect();
    this.hy = new Rect();
    this.bYz = new RectF();
    this.bYC = new ArrayList();
    this.bYD = new ArrayList();
    this.bYI = 0;
    this.bYQ = false;
    this.bYR = false;
    this.bYS = 0;
    this.bYT = 0;
    this.bYU = new e();
    this.bYZ = new f();
    this.mScrollState = 0;
    this.bZa = -1;
    this.bZh = 1.4E-45F;
    this.bZi = 1.4E-45F;
    this.bZj = true;
    this.bZk = new u();
    Object localObject1;
    if (bYo)
    {
      localObject1 = new j.a();
      this.bZm = ((j.a)localObject1);
      this.bZn = new s();
      this.bZq = false;
      this.bZr = false;
      this.bZs = new g();
      this.bZt = false;
      this.bZv = new int[2];
      this.bwI = new int[2];
      this.bwJ = new int[2];
      this.bZx = new int[2];
      this.bZy = new int[2];
      this.bZz = new ArrayList();
      this.bZA = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195099);
          if (RecyclerView.this.bYZ != null) {
            RecyclerView.this.bYZ.IW();
          }
          RecyclerView.this.bZt = false;
          AppMethodBeat.o(195099);
        }
      };
      this.bZC = new z.b()
      {
        public final void a(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          AppMethodBeat.i(195118);
          RecyclerView.this.bYt.y(paramAnonymousv);
          RecyclerView localRecyclerView = RecyclerView.this;
          localRecyclerView.i(paramAnonymousv);
          paramAnonymousv.bg(false);
          if (localRecyclerView.bYZ.d(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.Kb();
          }
          AppMethodBeat.o(195118);
        }
        
        public final void b(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          AppMethodBeat.i(195127);
          RecyclerView localRecyclerView = RecyclerView.this;
          paramAnonymousv.bg(false);
          if (localRecyclerView.bYZ.e(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.Kb();
          }
          AppMethodBeat.o(195127);
        }
        
        public final void c(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          AppMethodBeat.i(195143);
          paramAnonymousv.bg(false);
          if (RecyclerView.this.bYQ)
          {
            if (RecyclerView.this.bYZ.a(paramAnonymousv, paramAnonymousv, paramAnonymousc1, paramAnonymousc2))
            {
              RecyclerView.this.Kb();
              AppMethodBeat.o(195143);
            }
          }
          else if (RecyclerView.this.bYZ.f(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            RecyclerView.this.Kb();
          }
          AppMethodBeat.o(195143);
        }
        
        public final void m(RecyclerView.v paramAnonymousv)
        {
          AppMethodBeat.i(195154);
          RecyclerView.this.bYA.removeAndRecycleView(paramAnonymousv.caK, RecyclerView.this.bYt);
          AppMethodBeat.o(195154);
        }
      };
      if (paramAttributeSet == null) {
        break label719;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, bYk, paramInt, 0);
      this.bYx = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label364:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.bZh = aa.a((ViewConfiguration)localObject1, paramContext);
      this.bZi = aa.b((ViewConfiguration)localObject1, paramContext);
      this.wV = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.bZg = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2) {
        break label727;
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    StateListDrawable localStateListDrawable;
    Drawable localDrawable;
    label719:
    label727:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      this.bYZ.bZG = this.bZs;
      this.bYv = new a(new a.a()
      {
        private void f(a.b paramAnonymousb)
        {
          AppMethodBeat.i(195101);
          switch (paramAnonymousb.bUl)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(195101);
            return;
            RecyclerView.this.bYA.onItemsAdded(RecyclerView.this, paramAnonymousb.bUm, paramAnonymousb.bUo);
            AppMethodBeat.o(195101);
            return;
            RecyclerView.this.bYA.onItemsRemoved(RecyclerView.this, paramAnonymousb.bUm, paramAnonymousb.bUo);
            AppMethodBeat.o(195101);
            return;
            RecyclerView.this.bYA.onItemsUpdated(RecyclerView.this, paramAnonymousb.bUm, paramAnonymousb.bUo, paramAnonymousb.bUn);
            AppMethodBeat.o(195101);
            return;
            RecyclerView.this.bYA.onItemsMoved(RecyclerView.this, paramAnonymousb.bUm, paramAnonymousb.bUo, 1);
          }
        }
        
        public final void aZ(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(195116);
          RecyclerView.this.g(paramAnonymousInt1, paramAnonymousInt2, true);
          RecyclerView.this.bZq = true;
          RecyclerView.s locals = RecyclerView.this.bZn;
          locals.cas += paramAnonymousInt2;
          AppMethodBeat.o(195116);
        }
        
        public final void ba(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(195124);
          RecyclerView.this.g(paramAnonymousInt1, paramAnonymousInt2, false);
          RecyclerView.this.bZq = true;
          AppMethodBeat.o(195124);
        }
        
        public final void bb(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(195163);
          RecyclerView localRecyclerView = RecyclerView.this;
          int j = localRecyclerView.mChildHelper.IU();
          int i = 0;
          while (i < j)
          {
            localObject = RecyclerView.bz(localRecyclerView.mChildHelper.fD(i));
            if ((localObject != null) && (!((RecyclerView.v)localObject).KH()) && (((RecyclerView.v)localObject).mPosition >= paramAnonymousInt1))
            {
              ((RecyclerView.v)localObject).y(paramAnonymousInt2, false);
              localRecyclerView.bZn.cav = true;
            }
            i += 1;
          }
          Object localObject = localRecyclerView.bYt;
          j = ((RecyclerView.n)localObject).bZZ.size();
          i = 0;
          while (i < j)
          {
            RecyclerView.v localv = (RecyclerView.v)((RecyclerView.n)localObject).bZZ.get(i);
            if ((localv != null) && (localv.mPosition >= paramAnonymousInt1)) {
              localv.y(paramAnonymousInt2, true);
            }
            i += 1;
          }
          localRecyclerView.requestLayout();
          RecyclerView.this.bZq = true;
          AppMethodBeat.o(195163);
        }
        
        public final void bc(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int n = -1;
          AppMethodBeat.i(195173);
          RecyclerView localRecyclerView = RecyclerView.this;
          int i1 = localRecyclerView.mChildHelper.IU();
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
            label40:
            if (m >= i1) {
              break label144;
            }
            localObject = RecyclerView.bz(localRecyclerView.mChildHelper.fD(m));
            if ((localObject != null) && (((RecyclerView.v)localObject).mPosition >= k) && (((RecyclerView.v)localObject).mPosition <= j))
            {
              if (((RecyclerView.v)localObject).mPosition != paramAnonymousInt1) {
                break label134;
              }
              ((RecyclerView.v)localObject).y(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            localRecyclerView.bZn.cav = true;
            m += 1;
            break label40;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label134:
            ((RecyclerView.v)localObject).y(i, false);
          }
          label144:
          Object localObject = localRecyclerView.bYt;
          label178:
          RecyclerView.v localv;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            i = n;
            n = ((RecyclerView.n)localObject).bZZ.size();
            m = 0;
            if (m >= n) {
              break label273;
            }
            localv = (RecyclerView.v)((RecyclerView.n)localObject).bZZ.get(m);
            if ((localv != null) && (localv.mPosition >= k) && (localv.mPosition <= j))
            {
              if (localv.mPosition != paramAnonymousInt1) {
                break label263;
              }
              localv.y(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            m += 1;
            break label178;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label263:
            localv.y(i, false);
          }
          label273:
          localRecyclerView.requestLayout();
          RecyclerView.this.bZq = true;
          AppMethodBeat.o(195173);
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(195134);
          Object localObject = RecyclerView.this;
          int j = ((RecyclerView)localObject).mChildHelper.IU();
          int i = 0;
          while (i < j)
          {
            View localView = ((RecyclerView)localObject).mChildHelper.fD(i);
            RecyclerView.v localv = RecyclerView.bz(localView);
            if ((localv != null) && (!localv.KH()) && (localv.mPosition >= paramAnonymousInt1) && (localv.mPosition < paramAnonymousInt1 + paramAnonymousInt2))
            {
              localv.gh(2);
              localv.aT(paramAnonymousObject);
              ((RecyclerView.LayoutParams)localView.getLayoutParams()).bZP = true;
            }
            i += 1;
          }
          paramAnonymousObject = ((RecyclerView)localObject).bYt;
          i = paramAnonymousObject.bZZ.size() - 1;
          while (i >= 0)
          {
            localObject = (RecyclerView.v)paramAnonymousObject.bZZ.get(i);
            if (localObject != null)
            {
              j = ((RecyclerView.v)localObject).mPosition;
              if ((j >= paramAnonymousInt1) && (j < paramAnonymousInt1 + paramAnonymousInt2))
              {
                ((RecyclerView.v)localObject).gh(2);
                paramAnonymousObject.gd(i);
              }
            }
            i -= 1;
          }
          RecyclerView.this.bZr = true;
          AppMethodBeat.o(195134);
        }
        
        public final void d(a.b paramAnonymousb)
        {
          AppMethodBeat.i(195141);
          f(paramAnonymousb);
          AppMethodBeat.o(195141);
        }
        
        public final void e(a.b paramAnonymousb)
        {
          AppMethodBeat.i(195150);
          f(paramAnonymousb);
          AppMethodBeat.o(195150);
        }
        
        public final RecyclerView.v fB(int paramAnonymousInt)
        {
          AppMethodBeat.i(195111);
          RecyclerView.v localv = RecyclerView.this.w(paramAnonymousInt, true);
          if (localv == null)
          {
            AppMethodBeat.o(195111);
            return null;
          }
          if (RecyclerView.this.mChildHelper.bi(localv.caK))
          {
            AppMethodBeat.o(195111);
            return null;
          }
          AppMethodBeat.o(195111);
          return localv;
        }
      });
      this.mChildHelper = new e(new e.b()
      {
        public final void addView(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(195137);
          RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
          RecyclerView localRecyclerView = RecyclerView.this;
          RecyclerView.v localv = RecyclerView.bz(paramAnonymousView);
          if ((localRecyclerView.bUp != null) && (localv != null)) {
            localRecyclerView.bUp.o(localv);
          }
          if (localRecyclerView.bYP != null)
          {
            paramAnonymousInt = localRecyclerView.bYP.size() - 1;
            while (paramAnonymousInt >= 0)
            {
              ((RecyclerView.i)localRecyclerView.bYP.get(paramAnonymousInt)).bm(paramAnonymousView);
              paramAnonymousInt -= 1;
            }
          }
          AppMethodBeat.o(195137);
        }
        
        public final void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
        {
          AppMethodBeat.i(195189);
          RecyclerView.v localv = RecyclerView.bz(paramAnonymousView);
          if (localv != null)
          {
            if ((!localv.KQ()) && (!localv.KH()))
            {
              paramAnonymousView = new IllegalArgumentException("Called attach on a child which is not detached: " + localv + RecyclerView.this.JJ());
              AppMethodBeat.o(195189);
              throw paramAnonymousView;
            }
            localv.KO();
          }
          RecyclerView.a(RecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
          AppMethodBeat.o(195189);
        }
        
        public final int bh(View paramAnonymousView)
        {
          AppMethodBeat.i(195145);
          int i = RecyclerView.this.indexOfChild(paramAnonymousView);
          AppMethodBeat.o(195145);
          return i;
        }
        
        public final RecyclerView.v bj(View paramAnonymousView)
        {
          AppMethodBeat.i(195178);
          paramAnonymousView = RecyclerView.bz(paramAnonymousView);
          AppMethodBeat.o(195178);
          return paramAnonymousView;
        }
        
        public final void bk(View paramAnonymousView)
        {
          AppMethodBeat.i(195201);
          paramAnonymousView = RecyclerView.bz(paramAnonymousView);
          RecyclerView localRecyclerView;
          if (paramAnonymousView != null)
          {
            localRecyclerView = RecyclerView.this;
            if (paramAnonymousView.caZ == -1) {
              break label48;
            }
          }
          label48:
          for (paramAnonymousView.caY = paramAnonymousView.caZ;; paramAnonymousView.caY = androidx.core.g.z.R(paramAnonymousView.caK))
          {
            localRecyclerView.c(paramAnonymousView, 4);
            AppMethodBeat.o(195201);
            return;
          }
        }
        
        public final void bl(View paramAnonymousView)
        {
          AppMethodBeat.i(195209);
          paramAnonymousView = RecyclerView.bz(paramAnonymousView);
          if (paramAnonymousView != null)
          {
            RecyclerView.this.c(paramAnonymousView, paramAnonymousView.caY);
            paramAnonymousView.caY = 0;
          }
          AppMethodBeat.o(195209);
        }
        
        public final void detachViewFromParent(int paramAnonymousInt)
        {
          AppMethodBeat.i(195194);
          Object localObject = getChildAt(paramAnonymousInt);
          if (localObject != null)
          {
            localObject = RecyclerView.bz((View)localObject);
            if (localObject != null)
            {
              if ((((RecyclerView.v)localObject).KQ()) && (!((RecyclerView.v)localObject).KH()))
              {
                localObject = new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.JJ());
                AppMethodBeat.o(195194);
                throw ((Throwable)localObject);
              }
              ((RecyclerView.v)localObject).gh(256);
            }
          }
          RecyclerView.b(RecyclerView.this, paramAnonymousInt);
          AppMethodBeat.o(195194);
        }
        
        public final View getChildAt(int paramAnonymousInt)
        {
          AppMethodBeat.i(195162);
          View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
          AppMethodBeat.o(195162);
          return localView;
        }
        
        public final int getChildCount()
        {
          AppMethodBeat.i(195126);
          int i = RecyclerView.this.getChildCount();
          AppMethodBeat.o(195126);
          return i;
        }
        
        public final void removeAllViews()
        {
          AppMethodBeat.i(195170);
          int j = RecyclerView.this.getChildCount();
          int i = 0;
          while (i < j)
          {
            View localView = getChildAt(i);
            RecyclerView.this.bE(localView);
            localView.clearAnimation();
            i += 1;
          }
          RecyclerView.this.removeAllViews();
          AppMethodBeat.o(195170);
        }
        
        public final void removeViewAt(int paramAnonymousInt)
        {
          AppMethodBeat.i(195152);
          View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
          if (localView != null)
          {
            RecyclerView.this.bE(localView);
            localView.clearAnimation();
          }
          RecyclerView.this.removeViewAt(paramAnonymousInt);
          AppMethodBeat.o(195152);
        }
      });
      if (androidx.core.g.z.J(this) == 0) {
        androidx.core.g.z.K(this);
      }
      if (androidx.core.g.z.R(this) == 0) {
        androidx.core.g.z.p(this, 1);
      }
      this.bYO = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new u(this));
      if (paramAttributeSet == null) {
        break label1352;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(a.c.RecyclerView_layoutManager);
      if (((TypedArray)localObject1).getInt(a.c.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.bYG = ((TypedArray)localObject1).getBoolean(a.c.RecyclerView_fastScrollEnabled, false);
      if (!this.bYG) {
        break label783;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollVerticalThumbDrawable);
      localObject4 = ((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollVerticalTrackDrawable);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollHorizontalThumbDrawable);
      localDrawable = ((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollHorizontalTrackDrawable);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label733;
      }
      paramContext = new IllegalArgumentException("Trying to set fast scroller without both required drawables." + JJ());
      AppMethodBeat.o(195161);
      throw paramContext;
      localObject1 = null;
      break;
      this.bYx = true;
      break label364;
    }
    label733:
    Resources localResources = getContext().getResources();
    new i(this, (StateListDrawable)localObject3, (Drawable)localObject4, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(androidx.recyclerview.a.a.fastscroll_default_thickness), localResources.getDimensionPixelSize(androidx.recyclerview.a.a.fastscroll_minimum_range), localResources.getDimensionPixelOffset(androidx.recyclerview.a.a.fastscroll_margin));
    label783:
    ((TypedArray)localObject1).recycle();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).trim();
      if (!((String)localObject1).isEmpty())
      {
        if (((String)localObject1).charAt(0) != '.') {
          break label979;
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
          localObject3 = ((Class)localObject4).getConstructor(bYr);
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
            paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Error creating LayoutManager " + (String)localObject1, paramContext);
            AppMethodBeat.o(195161);
            throw paramContext;
          }
        }
        ((Constructor)localObject3).setAccessible(true);
        setLayoutManager((LayoutManager)((Constructor)localObject3).newInstance((Object[])localObject2));
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, bYj, paramInt, 0);
          bool = paramContext.getBoolean(0, true);
          paramContext.recycle();
          setNestedScrollingEnabled(bool);
          AppMethodBeat.o(195161);
          return;
          label979:
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
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Unable to find LayoutManager " + (String)localObject1, paramContext);
        AppMethodBeat.o(195161);
        throw paramContext;
      }
      catch (InvocationTargetException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + (String)localObject1, paramContext);
        AppMethodBeat.o(195161);
        throw paramContext;
      }
      catch (InstantiationException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + (String)localObject1, paramContext);
        AppMethodBeat.o(195161);
        throw paramContext;
      }
      catch (IllegalAccessException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + (String)localObject1, paramContext);
        AppMethodBeat.o(195161);
        throw paramContext;
      }
      catch (ClassCastException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + (String)localObject1, paramContext);
        AppMethodBeat.o(195161);
        throw paramContext;
      }
      label1352:
      bool = true;
    }
  }
  
  private void JP()
  {
    AppMethodBeat.i(195184);
    this.bZk.stop();
    if (this.bYA != null) {
      this.bYA.stopSmoothScroller();
    }
    AppMethodBeat.o(195184);
  }
  
  private void JQ()
  {
    AppMethodBeat.i(195198);
    boolean bool2 = false;
    if (this.bYV != null)
    {
      this.bYV.onRelease();
      bool2 = this.bYV.isFinished();
    }
    boolean bool1 = bool2;
    if (this.bYW != null)
    {
      this.bYW.onRelease();
      bool1 = bool2 | this.bYW.isFinished();
    }
    bool2 = bool1;
    if (this.bYX != null)
    {
      this.bYX.onRelease();
      bool2 = bool1 | this.bYX.isFinished();
    }
    bool1 = bool2;
    if (this.bYY != null)
    {
      this.bYY.onRelease();
      bool1 = bool2 | this.bYY.isFinished();
    }
    if (bool1) {
      androidx.core.g.z.Q(this);
    }
    AppMethodBeat.o(195198);
  }
  
  private void JR()
  {
    AppMethodBeat.i(195205);
    if (this.bYV != null)
    {
      AppMethodBeat.o(195205);
      return;
    }
    this.bYV = e.f(this);
    if (this.bYx)
    {
      this.bYV.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      AppMethodBeat.o(195205);
      return;
    }
    this.bYV.setSize(getMeasuredHeight(), getMeasuredWidth());
    AppMethodBeat.o(195205);
  }
  
  private void JS()
  {
    AppMethodBeat.i(195212);
    if (this.bYX != null)
    {
      AppMethodBeat.o(195212);
      return;
    }
    this.bYX = e.f(this);
    if (this.bYx)
    {
      this.bYX.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      AppMethodBeat.o(195212);
      return;
    }
    this.bYX.setSize(getMeasuredHeight(), getMeasuredWidth());
    AppMethodBeat.o(195212);
  }
  
  private void JT()
  {
    AppMethodBeat.i(195219);
    if (this.bYW != null)
    {
      AppMethodBeat.o(195219);
      return;
    }
    this.bYW = e.f(this);
    if (this.bYx)
    {
      this.bYW.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      AppMethodBeat.o(195219);
      return;
    }
    this.bYW.setSize(getMeasuredWidth(), getMeasuredHeight());
    AppMethodBeat.o(195219);
  }
  
  private void JU()
  {
    AppMethodBeat.i(195224);
    if (this.bYY != null)
    {
      AppMethodBeat.o(195224);
      return;
    }
    this.bYY = e.f(this);
    if (this.bYx)
    {
      this.bYY.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      AppMethodBeat.o(195224);
      return;
    }
    this.bYY.setSize(getMeasuredWidth(), getMeasuredHeight());
    AppMethodBeat.o(195224);
  }
  
  private void JV()
  {
    this.bYY = null;
    this.bYW = null;
    this.bYX = null;
    this.bYV = null;
  }
  
  private void JW()
  {
    AppMethodBeat.i(195245);
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    em(0);
    JQ();
    AppMethodBeat.o(195245);
  }
  
  private void JX()
  {
    AppMethodBeat.i(195249);
    JW();
    setScrollState(0);
    AppMethodBeat.o(195249);
  }
  
  private void JZ()
  {
    AppMethodBeat.i(195262);
    int i = this.bYM;
    this.bYM = 0;
    if ((i != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      b.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
    AppMethodBeat.o(195262);
  }
  
  private boolean Kc()
  {
    AppMethodBeat.i(195270);
    if ((this.bYZ != null) && (this.bYA.supportsPredictiveItemAnimations()))
    {
      AppMethodBeat.o(195270);
      return true;
    }
    AppMethodBeat.o(195270);
    return false;
  }
  
  private void Kd()
  {
    boolean bool2 = true;
    AppMethodBeat.i(195277);
    if (this.bYQ)
    {
      this.bYv.reset();
      if (this.bYR) {
        this.bYA.onItemsChanged(this);
      }
    }
    int i;
    label67:
    s locals;
    if (Kc())
    {
      this.bYv.IN();
      if ((!this.bZq) && (!this.bZr)) {
        break label192;
      }
      i = 1;
      locals = this.bZn;
      if ((!this.bYH) || (this.bYZ == null) || ((!this.bYQ) && (i == 0) && (!this.bYA.mRequestedSimpleAnimations)) || ((this.bYQ) && (!this.bUp.bZF))) {
        break label197;
      }
      bool1 = true;
      label127:
      locals.caz = bool1;
      locals = this.bZn;
      if ((!this.bZn.caz) || (i == 0) || (this.bYQ) || (!Kc())) {
        break label202;
      }
    }
    label192:
    label197:
    label202:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locals.caA = bool1;
      AppMethodBeat.o(195277);
      return;
      this.bYv.IQ();
      break;
      i = 0;
      break label67;
      bool1 = false;
      break label127;
    }
  }
  
  private void Ke()
  {
    AppMethodBeat.i(195281);
    if (this.bUp == null)
    {
      AppMethodBeat.o(195281);
      return;
    }
    if (this.bYA == null)
    {
      AppMethodBeat.o(195281);
      return;
    }
    this.bZn.cay = false;
    if (this.bZn.cat == 1)
    {
      Ki();
      this.bYA.setExactMeasureSpecsFrom(this);
      Kj();
    }
    for (;;)
    {
      Kk();
      AppMethodBeat.o(195281);
      return;
      if ((this.bYv.IR()) || (this.bYA.getWidth() != getWidth()) || (this.bYA.getHeight() != getHeight()))
      {
        this.bYA.setExactMeasureSpecsFrom(this);
        Kj();
      }
      else
      {
        this.bYA.setExactMeasureSpecsFrom(this);
      }
    }
  }
  
  private void Kf()
  {
    AppMethodBeat.i(195286);
    if ((this.bZj) && (hasFocus()) && (this.bUp != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = by((View)localObject1))
      {
        Kg();
        AppMethodBeat.o(195286);
        return;
      }
      Object localObject2 = this.bZn;
      long l;
      int i;
      if (this.bUp.bZF)
      {
        l = ((v)localObject1).caN;
        ((s)localObject2).caC = l;
        localObject2 = this.bZn;
        if (!this.bYQ) {
          break label203;
        }
        i = -1;
      }
      s locals;
      for (;;)
      {
        ((s)localObject2).caB = i;
        locals = this.bZn;
        localObject1 = ((v)localObject1).caK;
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
        label203:
        if (((v)localObject1).isRemoved()) {
          i = ((v)localObject1).caM;
        } else {
          i = ((v)localObject1).KJ();
        }
      }
      locals.caD = i;
      AppMethodBeat.o(195286);
      return;
    }
  }
  
  private void Kg()
  {
    this.bZn.caC = -1L;
    this.bZn.caB = -1;
    this.bZn.caD = -1;
  }
  
  private void Kh()
  {
    View localView = null;
    AppMethodBeat.i(195300);
    if ((!this.bZj) || (this.bUp == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused())))
    {
      AppMethodBeat.o(195300);
      return;
    }
    if (!isFocused())
    {
      localObject = getFocusedChild();
      if ((bYq) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.mChildHelper.getChildCount() == 0)
        {
          requestFocus();
          AppMethodBeat.o(195300);
        }
      }
      else if (!this.mChildHelper.bi((View)localObject))
      {
        AppMethodBeat.o(195300);
        return;
      }
    }
    if ((this.bZn.caC != -1L) && (this.bUp.bZF)) {}
    for (Object localObject = bz(this.bZn.caC);; localObject = null)
    {
      int i;
      int k;
      int j;
      if ((localObject == null) || (this.mChildHelper.bi(((v)localObject).caK)) || (!((v)localObject).caK.hasFocusable()))
      {
        localObject = localView;
        if (this.mChildHelper.getChildCount() > 0)
        {
          if (this.bZn.caB != -1)
          {
            i = this.bZn.caB;
            k = this.bZn.getItemCount();
            j = i;
            label251:
            if (j >= k) {
              break label362;
            }
            localObject = fU(j);
            if (localObject == null) {
              break label362;
            }
            if (!((v)localObject).caK.hasFocusable()) {
              break label355;
            }
            localObject = ((v)localObject).caK;
          }
        }
        else {
          label286:
          if (localObject != null)
          {
            if (this.bZn.caD == -1L) {
              break label430;
            }
            localView = ((View)localObject).findViewById(this.bZn.caD);
            if ((localView == null) || (!localView.isFocusable())) {
              break label430;
            }
            localObject = localView;
          }
        }
      }
      label414:
      label430:
      for (;;)
      {
        ((View)localObject).requestFocus();
        AppMethodBeat.o(195300);
        return;
        i = 0;
        break;
        label355:
        j += 1;
        break label251;
        label362:
        i = Math.min(k, i) - 1;
        for (;;)
        {
          if (i < 0) {
            break label414;
          }
          localObject = fU(i);
          if (localObject == null) {
            break label414;
          }
          if (((v)localObject).caK.hasFocusable())
          {
            localObject = ((v)localObject).caK;
            break;
          }
          i -= 1;
        }
        localObject = null;
        break label286;
        localObject = ((v)localObject).caK;
        break label286;
      }
    }
  }
  
  private void Ki()
  {
    AppMethodBeat.i(195319);
    this.bZn.gf(1);
    f(this.bZn);
    this.bZn.cay = false;
    JN();
    this.bYw.clear();
    JY();
    Kd();
    Kf();
    Object localObject = this.bZn;
    if ((this.bZn.caz) && (this.bZr)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((s)localObject).cax = bool;
      this.bZr = false;
      this.bZq = false;
      this.bZn.caw = this.bZn.caA;
      this.bZn.cau = this.bUp.getItemCount();
      m(this.bZv);
      if (!this.bZn.caz) {
        break;
      }
      j = this.mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bz(this.mChildHelper.getChildAt(i));
        if ((!((v)localObject).KH()) && ((!((v)localObject).isInvalid()) || (this.bUp.bZF)))
        {
          localc = this.bYZ.a(this.bZn, (v)localObject, f.q((v)localObject), ((v)localObject).KT());
          this.bYw.b((v)localObject, localc);
          if ((this.bZn.cax) && (((v)localObject).KW()) && (!((v)localObject).isRemoved()) && (!((v)localObject).KH()) && (!((v)localObject).isInvalid()))
          {
            long l = j((v)localObject);
            this.bYw.a(l, (v)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.bZn.caA)
    {
      Km();
      bool = this.bZn.cav;
      this.bZn.cav = false;
      this.bYA.onLayoutChildren(this.bYt, this.bZn);
      this.bZn.cav = bool;
      i = 0;
      if (i < this.mChildHelper.getChildCount())
      {
        localObject = bz(this.mChildHelper.getChildAt(i));
        if ((!((v)localObject).KH()) && (!this.bYw.H((v)localObject)))
        {
          int k = f.q((v)localObject);
          bool = ((v)localObject).gg(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.bYZ.a(this.bZn, (v)localObject, j, ((v)localObject).KT());
          if (!bool) {
            break label477;
          }
          a((v)localObject, localc);
        }
        for (;;)
        {
          i += 1;
          break;
          label477:
          this.bYw.c((v)localObject, localc);
        }
      }
      Kn();
    }
    for (;;)
    {
      bd(true);
      bc(false);
      this.bZn.cat = 2;
      AppMethodBeat.o(195319);
      return;
      Kn();
    }
  }
  
  private void Kj()
  {
    AppMethodBeat.i(195322);
    JN();
    JY();
    this.bZn.gf(6);
    this.bYv.IQ();
    this.bZn.cau = this.bUp.getItemCount();
    this.bZn.cas = 0;
    this.bZn.caw = false;
    this.bYA.onLayoutChildren(this.bYt, this.bZn);
    this.bZn.cav = false;
    this.bYu = null;
    s locals = this.bZn;
    if ((this.bZn.caz) && (this.bYZ != null)) {}
    for (boolean bool = true;; bool = false)
    {
      locals.caz = bool;
      this.bZn.cat = 4;
      bd(true);
      bc(false);
      AppMethodBeat.o(195322);
      return;
    }
  }
  
  private void Kk()
  {
    AppMethodBeat.i(195335);
    this.bZn.gf(4);
    JN();
    JY();
    this.bZn.cat = 1;
    if (this.bZn.caz)
    {
      int i = this.mChildHelper.getChildCount() - 1;
      if (i >= 0)
      {
        v localv1 = bz(this.mChildHelper.getChildAt(i));
        RecyclerView.f.c localc2;
        v localv2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localv1.KH())
        {
          long l = j(localv1);
          localc2 = f.Kw().e(localv1, 0);
          localv2 = this.bYw.bA(l);
          if ((localv2 == null) || (localv2.KH())) {
            break label226;
          }
          bool1 = this.bYw.G(localv2);
          bool2 = this.bYw.G(localv1);
          if ((bool1) && (localv2 == localv1)) {
            break label226;
          }
          localc1 = this.bYw.f(localv2, 4);
          this.bYw.d(localv1, localc2);
          localc2 = this.bYw.f(localv1, 8);
          if (localc1 != null) {
            break label207;
          }
          a(l, localv1, localv2);
        }
        for (;;)
        {
          i -= 1;
          break;
          label207:
          a(localv2, localv1, localc1, localc2, bool1, bool2);
          continue;
          label226:
          this.bYw.d(localv1, localc2);
        }
      }
      this.bYw.a(this.bZC);
    }
    this.bYA.removeAndRecycleScrapInt(this.bYt);
    this.bZn.car = this.bZn.cau;
    this.bYQ = false;
    this.bYR = false;
    this.bZn.caz = false;
    this.bZn.caA = false;
    this.bYA.mRequestedSimpleAnimations = false;
    if (this.bYt.bZY != null) {
      this.bYt.bZY.clear();
    }
    if (this.bYA.mPrefetchMaxObservedInInitialPrefetch)
    {
      this.bYA.mPrefetchMaxCountObserved = 0;
      this.bYA.mPrefetchMaxObservedInInitialPrefetch = false;
      this.bYt.KA();
    }
    this.bYA.onLayoutCompleted(this.bZn);
    bd(true);
    bc(false);
    this.bYw.clear();
    if (bw(this.bZv[0], this.bZv[1])) {
      bx(0, 0);
    }
    Kh();
    Kg();
    AppMethodBeat.o(195335);
  }
  
  private void Km()
  {
    AppMethodBeat.i(195372);
    int j = this.mChildHelper.IU();
    int i = 0;
    while (i < j)
    {
      v localv = bz(this.mChildHelper.fD(i));
      if (!localv.KH()) {
        localv.KG();
      }
      i += 1;
    }
    AppMethodBeat.o(195372);
  }
  
  private void Kn()
  {
    AppMethodBeat.i(195380);
    int j = this.mChildHelper.IU();
    int i = 0;
    while (i < j)
    {
      v localv = bz(this.mChildHelper.fD(i));
      if (!localv.KH()) {
        localv.KF();
      }
      i += 1;
    }
    this.bYt.Kn();
    AppMethodBeat.o(195380);
  }
  
  private void Ko()
  {
    AppMethodBeat.i(195386);
    int j = this.mChildHelper.IU();
    int i = 0;
    while (i < j)
    {
      v localv = bz(this.mChildHelper.fD(i));
      if ((localv != null) && (!localv.KH())) {
        localv.gh(6);
      }
      i += 1;
    }
    Kl();
    this.bYt.Ko();
    AppMethodBeat.o(195386);
  }
  
  private void Kr()
  {
    AppMethodBeat.i(195434);
    int i = this.bZz.size() - 1;
    while (i >= 0)
    {
      v localv = (v)this.bZz.get(i);
      if ((localv.caK.getParent() == this) && (!localv.KH()))
      {
        int j = localv.caZ;
        if (j != -1)
        {
          androidx.core.g.z.p(localv.caK, j);
          localv.caZ = -1;
        }
      }
      i -= 1;
    }
    this.bZz.clear();
    AppMethodBeat.o(195434);
  }
  
  private void a(long paramLong, v paramv1, v paramv2)
  {
    AppMethodBeat.i(195342);
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      v localv = bz(this.mChildHelper.getChildAt(i));
      if ((localv != paramv1) && (j(localv) == paramLong))
      {
        if ((this.bUp != null) && (this.bUp.bZF))
        {
          paramv1 = new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + JJ());
          AppMethodBeat.o(195342);
          throw paramv1;
        }
        paramv1 = new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + JJ());
        AppMethodBeat.o(195342);
        throw paramv1;
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramv2).append(" cannot be found but it is necessary for ").append(paramv1).append(JJ());
    AppMethodBeat.o(195342);
  }
  
  private void a(v paramv1, v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195366);
    paramv1.bg(false);
    if (paramBoolean1) {
      i(paramv1);
    }
    if (paramv1 != paramv2)
    {
      if (paramBoolean2) {
        i(paramv2);
      }
      paramv1.caQ = paramv2;
      i(paramv1);
      this.bYt.y(paramv1);
      paramv2.bg(false);
      paramv2.caR = paramv1;
    }
    if (this.bYZ.a(paramv1, paramv2, paramc1, paramc2)) {
      Kb();
    }
    AppMethodBeat.o(195366);
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195176);
    JM();
    int i;
    int j;
    int k;
    int m;
    if (this.bUp != null)
    {
      d(paramInt1, paramInt2, this.bZy);
      i = this.bZy[0];
      j = this.bZy[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.bYC.isEmpty()) {
        invalidate();
      }
      if (a(i, j, k, m, this.bwI, 0))
      {
        this.bZd -= this.bwI[0];
        this.bZe -= this.bwI[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.bwI[0], this.bwI[1]);
        }
        paramMotionEvent = this.bZx;
        paramMotionEvent[0] += this.bwI[0];
        paramMotionEvent = this.bZx;
        paramMotionEvent[1] += this.bwI[1];
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          bx(i, j);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((i == 0) && (j == 0)) {
          break;
        }
        AppMethodBeat.o(195176);
        return true;
        if (getOverScrollMode() != 2)
        {
          if ((paramMotionEvent != null) && (!androidx.core.g.j.g(paramMotionEvent))) {
            f(paramMotionEvent.getX(), k, paramMotionEvent.getY(), m);
          }
          bt(paramInt1, paramInt2);
        }
      }
      AppMethodBeat.o(195176);
      return false;
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
  }
  
  private boolean az(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195442);
    boolean bool = getScrollingChildHelper().az(paramInt1, paramInt2);
    AppMethodBeat.o(195442);
    return bool;
  }
  
  public static int bA(View paramView)
  {
    AppMethodBeat.i(195399);
    paramView = bz(paramView);
    if (paramView != null)
    {
      int i = paramView.KJ();
      AppMethodBeat.o(195399);
      return i;
    }
    AppMethodBeat.o(195399);
    return -1;
  }
  
  public static int bB(View paramView)
  {
    AppMethodBeat.i(195405);
    paramView = bz(paramView);
    if (paramView != null)
    {
      int i = paramView.KI();
      AppMethodBeat.o(195405);
      return i;
    }
    AppMethodBeat.o(195405);
    return -1;
  }
  
  static RecyclerView bD(View paramView)
  {
    AppMethodBeat.i(195422);
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(195422);
      return null;
    }
    if ((paramView instanceof RecyclerView))
    {
      paramView = (RecyclerView)paramView;
      AppMethodBeat.o(195422);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView localRecyclerView = bD(paramView.getChildAt(i));
      if (localRecyclerView != null)
      {
        AppMethodBeat.o(195422);
        return localRecyclerView;
      }
      i += 1;
    }
    AppMethodBeat.o(195422);
    return null;
  }
  
  private boolean bw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195355);
    m(this.bZv);
    if ((this.bZv[0] != paramInt1) || (this.bZv[1] != paramInt2))
    {
      AppMethodBeat.o(195355);
      return true;
    }
    AppMethodBeat.o(195355);
    return false;
  }
  
  static v bz(View paramView)
  {
    AppMethodBeat.i(195393);
    if (paramView == null)
    {
      AppMethodBeat.o(195393);
      return null;
    }
    paramView = ((LayoutParams)paramView.getLayoutParams()).bXh;
    AppMethodBeat.o(195393);
    return paramView;
  }
  
  static void c(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(195418);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.bWr;
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
    AppMethodBeat.o(195418);
  }
  
  private void e(View paramView1, View paramView2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(195239);
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
        if (!((LayoutParams)localObject).bZP)
        {
          localObject = ((LayoutParams)localObject).bWr;
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
      localObject = this.bYA;
      localRect = this.mTempRect;
      if (this.bYH) {
        break label237;
      }
      bool1 = true;
      label206:
      if (paramView2 != null) {
        break label243;
      }
    }
    for (;;)
    {
      ((LayoutManager)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool1, bool2);
      AppMethodBeat.o(195239);
      return;
      localObject = paramView1;
      break;
      label237:
      bool1 = false;
      break label206;
      label243:
      bool2 = false;
    }
  }
  
  private void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    AppMethodBeat.i(195192);
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      JR();
      androidx.core.widget.d.a(this.bYV, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label153;
      }
      JT();
      androidx.core.widget.d.a(this.bYW, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        androidx.core.g.z.Q(this);
      }
      AppMethodBeat.o(195192);
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      JS();
      androidx.core.widget.d.a(this.bYX, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label153:
      if (paramFloat4 > 0.0F)
      {
        JU();
        androidx.core.widget.d.a(this.bYY, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  private void f(s params)
  {
    AppMethodBeat.i(195308);
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.bZk.bwz;
      params.caE = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      params.caF = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      AppMethodBeat.o(195308);
      return;
    }
    params.caE = 0;
    params.caF = 0;
    AppMethodBeat.o(195308);
  }
  
  public static void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(195411);
    c(paramView, paramRect);
    AppMethodBeat.o(195411);
  }
  
  private long j(v paramv)
  {
    if (this.bUp.bZF) {
      return paramv.caN;
    }
    return paramv.mPosition;
  }
  
  static void k(v paramv)
  {
    AppMethodBeat.i(195426);
    if (paramv.caL != null)
    {
      Object localObject = (View)paramv.caL.get();
      while (localObject != null)
      {
        if (localObject == paramv.caK)
        {
          AppMethodBeat.o(195426);
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      paramv.caL = null;
    }
    AppMethodBeat.o(195426);
  }
  
  private void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195255);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.bZa) {
      if (i != 0) {
        break label87;
      }
    }
    label87:
    for (i = 1;; i = 0)
    {
      this.bZa = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.bZd = j;
      this.bZb = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.bZe = i;
      this.bZc = i;
      AppMethodBeat.o(195255);
      return;
    }
  }
  
  private void m(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195350);
    int i2 = this.mChildHelper.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      AppMethodBeat.o(195350);
      return;
    }
    int i = 2147483647;
    int k = -2147483648;
    int n = 0;
    int m;
    int j;
    if (n < i2)
    {
      v localv = bz(this.mChildHelper.getChildAt(n));
      m = i;
      if (localv.KH()) {
        break label140;
      }
      int i1 = localv.KI();
      j = i;
      if (i1 < i) {
        j = i1;
      }
      m = j;
      if (i1 <= k) {
        break label140;
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
      AppMethodBeat.o(195350);
      return;
      label140:
      j = k;
      i = m;
    }
  }
  
  final String JJ()
  {
    AppMethodBeat.i(195497);
    String str = " " + super.toString() + ", adapter:" + this.bUp + ", layout:" + this.bYA + ", context:" + getContext();
    AppMethodBeat.o(195497);
    return str;
  }
  
  final void JK()
  {
    AppMethodBeat.i(195568);
    if (this.bYZ != null) {
      this.bYZ.IY();
    }
    if (this.bYA != null)
    {
      this.bYA.removeAndRecycleAllViews(this.bYt);
      this.bYA.removeAndRecycleScrapInt(this.bYt);
    }
    this.bYt.clear();
    AppMethodBeat.o(195568);
  }
  
  public final void JL()
  {
    AppMethodBeat.i(195753);
    int i = getItemDecorationCount();
    if (i <= 0)
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
      AppMethodBeat.o(195753);
      throw localIndexOutOfBoundsException;
    }
    b(fR(0));
    AppMethodBeat.o(195753);
  }
  
  final void JM()
  {
    int k = 0;
    AppMethodBeat.i(195884);
    if ((!this.bYH) || (this.bYQ))
    {
      g.ax("RV FullInvalidate");
      Ke();
      g.DS();
      AppMethodBeat.o(195884);
      return;
    }
    if (!this.bYv.IP())
    {
      AppMethodBeat.o(195884);
      return;
    }
    if ((this.bYv.fy(4)) && (!this.bYv.fy(11)))
    {
      g.ax("RV PartialInvalidate");
      JN();
      JY();
      this.bYv.IN();
      int i;
      if (!this.bYJ)
      {
        int m = this.mChildHelper.getChildCount();
        i = 0;
        int j = k;
        if (i < m)
        {
          v localv = bz(this.mChildHelper.getChildAt(i));
          if ((localv == null) || (localv.KH()) || (!localv.KW())) {
            break label193;
          }
          j = 1;
        }
        if (j == 0) {
          break label200;
        }
        Ke();
      }
      for (;;)
      {
        bc(true);
        bd(true);
        g.DS();
        AppMethodBeat.o(195884);
        return;
        label193:
        i += 1;
        break;
        label200:
        this.bYv.IO();
      }
    }
    if (this.bYv.IP())
    {
      g.ax("RV FullInvalidate");
      Ke();
      g.DS();
    }
    AppMethodBeat.o(195884);
  }
  
  final void JN()
  {
    this.bYI += 1;
    if ((this.bYI == 1) && (!this.bYK)) {
      this.bYJ = false;
    }
  }
  
  public void JO()
  {
    AppMethodBeat.i(195981);
    setScrollState(0);
    JP();
    AppMethodBeat.o(195981);
  }
  
  final void JY()
  {
    this.bYS += 1;
  }
  
  public final boolean Ka()
  {
    return this.bYS > 0;
  }
  
  final void Kb()
  {
    AppMethodBeat.i(196293);
    if ((!this.bZt) && (this.bIj))
    {
      androidx.core.g.z.b(this, this.bZA);
      this.bZt = true;
    }
    AppMethodBeat.o(196293);
  }
  
  public void Kl()
  {
    int j = 0;
    AppMethodBeat.i(196335);
    int k = this.mChildHelper.IU();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.mChildHelper.fD(i).getLayoutParams()).bZP = true;
      i += 1;
    }
    n localn = this.bYt;
    k = localn.bZZ.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((v)localn.bZZ.get(i)).caK.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.bZP = true;
      }
      i += 1;
    }
    AppMethodBeat.o(196335);
  }
  
  public final void Kp()
  {
    AppMethodBeat.i(196421);
    if (this.bYC.size() == 0)
    {
      AppMethodBeat.o(196421);
      return;
    }
    if (this.bYA != null) {
      this.bYA.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    Kl();
    requestLayout();
    AppMethodBeat.o(196421);
  }
  
  public final boolean Kq()
  {
    AppMethodBeat.i(196516);
    if ((!this.bYH) || (this.bYQ) || (this.bYv.IP()))
    {
      AppMethodBeat.o(196516);
      return true;
    }
    AppMethodBeat.o(196516);
    return false;
  }
  
  public final View Q(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(196486);
    int i = this.mChildHelper.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2))
      {
        AppMethodBeat.o(196486);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(196486);
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    AppMethodBeat.i(195965);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195965);
      return;
    }
    if (this.bYK)
    {
      AppMethodBeat.o(195965);
      return;
    }
    if (!this.bYA.canScrollHorizontally()) {
      paramInt1 = 0;
    }
    if (!this.bYA.canScrollVertically()) {
      paramInt2 = i;
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        u localu = this.bZk;
        i = localu.bG(paramInt1, paramInt2);
        Interpolator localInterpolator = paramInterpolator;
        if (paramInterpolator == null) {
          localInterpolator = bZB;
        }
        localu.b(paramInt1, paramInt2, i, localInterpolator);
      }
      AppMethodBeat.o(195965);
      return;
    }
  }
  
  public final void a(RecyclerView.h paramh)
  {
    AppMethodBeat.i(195722);
    if (this.bYA != null) {
      this.bYA.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.bYC.isEmpty()) {
      setWillNotDraw(false);
    }
    this.bYC.add(paramh);
    Kl();
    requestLayout();
    AppMethodBeat.o(195722);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(195598);
    if (this.bYP == null) {
      this.bYP = new ArrayList();
    }
    this.bYP.add(parami);
    AppMethodBeat.o(195598);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(196141);
    this.bYD.add(paramk);
    AppMethodBeat.o(196141);
  }
  
  public final void a(RecyclerView.l paraml)
  {
    AppMethodBeat.i(195795);
    if (this.bZp == null) {
      this.bZp = new ArrayList();
    }
    this.bZp.add(paraml);
    AppMethodBeat.o(195795);
  }
  
  final void a(v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(196302);
    paramv.bH(0, 8192);
    if ((this.bZn.cax) && (paramv.KW()) && (!paramv.isRemoved()) && (!paramv.KH()))
    {
      long l = j(paramv);
      this.bYw.a(l, paramv);
    }
    this.bYw.b(paramv, paramc);
    AppMethodBeat.o(196302);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    AppMethodBeat.i(196597);
    boolean bool = getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
    AppMethodBeat.o(196597);
    return bool;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    AppMethodBeat.i(196607);
    boolean bool = getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    AppMethodBeat.o(196607);
    return bool;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196064);
    if ((this.bYA == null) || (!this.bYA.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
    AppMethodBeat.o(196064);
  }
  
  final void assertInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(196121);
    if (!Ka())
    {
      if (paramString == null)
      {
        paramString = new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + JJ());
        AppMethodBeat.o(196121);
        throw paramString;
      }
      paramString = new IllegalStateException(paramString + JJ());
      AppMethodBeat.o(196121);
      throw paramString;
    }
    AppMethodBeat.o(196121);
  }
  
  final void assertNotInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(196131);
    if (Ka())
    {
      if (paramString == null)
      {
        paramString = new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + JJ());
        AppMethodBeat.o(196131);
        throw paramString;
      }
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(196131);
      throw paramString;
    }
    if (this.bYT > 0) {
      new IllegalStateException(JJ());
    }
    AppMethodBeat.o(196131);
  }
  
  public final void b(RecyclerView.h paramh)
  {
    AppMethodBeat.i(195764);
    if (this.bYA != null) {
      this.bYA.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.bYC.remove(paramh);
    if (this.bYC.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      Kl();
      requestLayout();
      AppMethodBeat.o(195764);
      return;
    }
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(196150);
    this.bYD.remove(paramk);
    if (this.bYE == paramk) {
      this.bYE = null;
    }
    AppMethodBeat.o(196150);
  }
  
  public final void b(RecyclerView.l paraml)
  {
    AppMethodBeat.i(195805);
    if (this.bZp != null) {
      this.bZp.remove(paraml);
    }
    AppMethodBeat.o(195805);
  }
  
  final Rect bC(View paramView)
  {
    AppMethodBeat.i(196498);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.bZP)
    {
      paramView = localLayoutParams.bWr;
      AppMethodBeat.o(196498);
      return paramView;
    }
    if ((this.bZn.caw) && ((localLayoutParams.bXh.KW()) || (localLayoutParams.bXh.isInvalid())))
    {
      paramView = localLayoutParams.bWr;
      AppMethodBeat.o(196498);
      return paramView;
    }
    Rect localRect = localLayoutParams.bWr;
    localRect.set(0, 0, 0, 0);
    int j = this.bYC.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((RecyclerView.h)this.bYC.get(i)).a(this.mTempRect, paramView, this, this.bZn);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.bZP = false;
    AppMethodBeat.o(196498);
    return localRect;
  }
  
  final void bE(View paramView)
  {
    AppMethodBeat.i(196532);
    v localv = bz(paramView);
    if ((this.bUp != null) && (localv != null)) {
      this.bUp.p(localv);
    }
    if (this.bYP != null)
    {
      int i = this.bYP.size() - 1;
      while (i >= 0)
      {
        ((i)this.bYP.get(i)).bn(paramView);
        i -= 1;
      }
    }
    AppMethodBeat.o(196532);
  }
  
  final void bc(boolean paramBoolean)
  {
    AppMethodBeat.i(195948);
    if (this.bYI <= 0) {
      this.bYI = 1;
    }
    if ((!paramBoolean) && (!this.bYK)) {
      this.bYJ = false;
    }
    if (this.bYI == 1)
    {
      if ((paramBoolean) && (this.bYJ) && (!this.bYK) && (this.bYA != null) && (this.bUp != null)) {
        Ke();
      }
      if (!this.bYK) {
        this.bYJ = false;
      }
    }
    this.bYI -= 1;
    AppMethodBeat.o(195948);
  }
  
  final void bd(boolean paramBoolean)
  {
    AppMethodBeat.i(196260);
    this.bYS -= 1;
    if (this.bYS <= 0)
    {
      this.bYS = 0;
      if (paramBoolean)
      {
        JZ();
        Kr();
      }
    }
    AppMethodBeat.o(196260);
  }
  
  final void be(boolean paramBoolean)
  {
    AppMethodBeat.i(196417);
    this.bYR |= paramBoolean;
    this.bYQ = true;
    Ko();
    AppMethodBeat.o(196417);
  }
  
  public final v bj(View paramView)
  {
    AppMethodBeat.i(196436);
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
      AppMethodBeat.o(196436);
      throw paramView;
    }
    paramView = bz(paramView);
    AppMethodBeat.o(196436);
    return paramView;
  }
  
  public void br(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195957);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(195957);
  }
  
  public boolean bs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195974);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195974);
      return false;
    }
    if (this.bYK)
    {
      AppMethodBeat.o(195974);
      return false;
    }
    boolean bool2 = this.bYA.canScrollHorizontally();
    boolean bool3 = this.bYA.canScrollVertically();
    int i;
    if (bool2)
    {
      i = paramInt1;
      if (Math.abs(paramInt1) >= this.wV) {}
    }
    else
    {
      i = 0;
    }
    int j;
    if (bool3)
    {
      j = paramInt2;
      if (Math.abs(paramInt2) >= this.wV) {}
    }
    else
    {
      j = 0;
    }
    if ((i == 0) && (j == 0))
    {
      AppMethodBeat.o(195974);
      return false;
    }
    if (!dispatchNestedPreFling(i, j))
    {
      if ((bool2) || (bool3)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        dispatchNestedFling(i, j, bool1);
        if ((this.bZf == null) || (!this.bZf.bC(i, j))) {
          break;
        }
        AppMethodBeat.o(195974);
        return true;
      }
      if (bool1) {
        if (!bool2) {
          break label321;
        }
      }
    }
    label321:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = paramInt1;
      if (bool3) {
        paramInt2 = paramInt1 | 0x2;
      }
      az(paramInt2, 1);
      paramInt1 = Math.max(-this.bZg, Math.min(i, this.bZg));
      paramInt2 = Math.max(-this.bZg, Math.min(j, this.bZg));
      u localu = this.bZk;
      localu.bZD.setScrollState(2);
      localu.caH = 0;
      localu.caG = 0;
      localu.bwz.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localu.KE();
      AppMethodBeat.o(195974);
      return true;
      AppMethodBeat.o(195974);
      return false;
    }
  }
  
  final void bt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195999);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bYV != null)
    {
      bool1 = bool2;
      if (!this.bYV.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.bYV.onRelease();
          bool1 = this.bYV.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.bYX != null)
    {
      bool2 = bool1;
      if (!this.bYX.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.bYX.onRelease();
          bool2 = bool1 | this.bYX.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.bYW != null)
    {
      bool1 = bool2;
      if (!this.bYW.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.bYW.onRelease();
          bool1 = bool2 | this.bYW.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.bYY != null)
    {
      bool2 = bool1;
      if (!this.bYY.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.bYY.onRelease();
          bool2 = bool1 | this.bYY.isFinished();
        }
      }
    }
    if (bool2) {
      androidx.core.g.z.Q(this);
    }
    AppMethodBeat.o(195999);
  }
  
  final void bu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196010);
    if (paramInt1 < 0)
    {
      JR();
      this.bYV.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label78;
      }
      JT();
      this.bYW.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        androidx.core.g.z.Q(this);
      }
      AppMethodBeat.o(196010);
      return;
      if (paramInt1 <= 0) {
        break;
      }
      JS();
      this.bYX.onAbsorb(paramInt1);
      break;
      label78:
      if (paramInt2 > 0)
      {
        JU();
        this.bYY.onAbsorb(paramInt2);
      }
    }
  }
  
  final void bv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196225);
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), androidx.core.g.z.aa(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), androidx.core.g.z.ab(this)));
    AppMethodBeat.o(196225);
  }
  
  final void bx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196507);
    this.bYT += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.bZo != null) {
      this.bZo.onScrolled(this, paramInt1, paramInt2);
    }
    if (this.bZp != null)
    {
      i = this.bZp.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.l)this.bZp.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.bYT -= 1;
    AppMethodBeat.o(196507);
  }
  
  public final v by(View paramView)
  {
    AppMethodBeat.i(196445);
    paramView = findContainingItemView(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(196445);
      return null;
    }
    paramView = bj(paramView);
    AppMethodBeat.o(196445);
    return paramView;
  }
  
  public final v bz(long paramLong)
  {
    AppMethodBeat.i(196477);
    if ((this.bUp == null) || (!this.bUp.bZF))
    {
      AppMethodBeat.o(196477);
      return null;
    }
    int j = this.mChildHelper.IU();
    int i = 0;
    Object localObject = null;
    v localv;
    if (i < j)
    {
      localv = bz(this.mChildHelper.fD(i));
      if ((localv == null) || (localv.isRemoved()) || (localv.caN != paramLong)) {
        break label131;
      }
      if (this.mChildHelper.bi(localv.caK)) {
        localObject = localv;
      }
    }
    label131:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(196477);
      return localv;
      AppMethodBeat.o(196477);
      return localObject;
    }
  }
  
  final boolean c(v paramv, int paramInt)
  {
    AppMethodBeat.i(196539);
    if (Ka())
    {
      paramv.caZ = paramInt;
      this.bZz.add(paramv);
      AppMethodBeat.o(196539);
      return false;
    }
    androidx.core.g.z.p(paramv.caK, paramInt);
    AppMethodBeat.o(196539);
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(196365);
    if (((paramLayoutParams instanceof LayoutParams)) && (this.bYA.checkLayoutParams((LayoutParams)paramLayoutParams)))
    {
      AppMethodBeat.o(196365);
      return true;
    }
    AppMethodBeat.o(196365);
    return false;
  }
  
  public int computeHorizontalScrollExtent()
  {
    AppMethodBeat.i(195900);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195900);
      return 0;
    }
    if (this.bYA.canScrollHorizontally())
    {
      int i = this.bYA.computeHorizontalScrollExtent(this.bZn);
      AppMethodBeat.o(195900);
      return i;
    }
    AppMethodBeat.o(195900);
    return 0;
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(195891);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195891);
      return 0;
    }
    if (this.bYA.canScrollHorizontally())
    {
      int i = this.bYA.computeHorizontalScrollOffset(this.bZn);
      AppMethodBeat.o(195891);
      return i;
    }
    AppMethodBeat.o(195891);
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(195905);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195905);
      return 0;
    }
    if (this.bYA.canScrollHorizontally())
    {
      int i = this.bYA.computeHorizontalScrollRange(this.bZn);
      AppMethodBeat.o(195905);
      return i;
    }
    AppMethodBeat.o(195905);
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(195925);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195925);
      return 0;
    }
    if (this.bYA.canScrollVertically())
    {
      int i = this.bYA.computeVerticalScrollExtent(this.bZn);
      AppMethodBeat.o(195925);
      return i;
    }
    AppMethodBeat.o(195925);
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(195914);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195914);
      return 0;
    }
    if (this.bYA.canScrollVertically())
    {
      int i = this.bYA.computeVerticalScrollOffset(this.bZn);
      AppMethodBeat.o(195914);
      return i;
    }
    AppMethodBeat.o(195914);
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(195933);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195933);
      return 0;
    }
    if (this.bYA.canScrollVertically())
    {
      int i = this.bYA.computeVerticalScrollRange(this.bZn);
      AppMethodBeat.o(195933);
      return i;
    }
    AppMethodBeat.o(195933);
    return 0;
  }
  
  final void d(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195873);
    JN();
    JY();
    g.ax("RV Scroll");
    f(this.bZn);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.bYA.scrollHorizontallyBy(paramInt1, this.bYt, this.bZn);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.bYA.scrollVerticallyBy(paramInt2, this.bYt, this.bZn);; paramInt2 = 0)
      {
        g.DS();
        int j = this.mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.mChildHelper.getChildAt(i);
          Object localObject = bj(localView);
          if ((localObject != null) && (((v)localObject).caR != null))
          {
            localObject = ((v)localObject).caR.caK;
            int k = localView.getLeft();
            int m = localView.getTop();
            if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
              ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
            }
          }
          i += 1;
        }
        bd(true);
        bc(false);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramInt1;
          paramArrayOfInt[1] = paramInt2;
        }
        AppMethodBeat.o(195873);
        return;
      }
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(196614);
    paramBoolean = getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(196614);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(196618);
    boolean bool = getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(196618);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(196602);
    boolean bool = getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(196602);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196590);
    boolean bool = getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(196590);
    return bool;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(195662);
    dispatchThawSelfOnly(paramSparseArray);
    AppMethodBeat.o(195662);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(195651);
    dispatchFreezeSelfOnly(paramSparseArray);
    AppMethodBeat.o(195651);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    AppMethodBeat.i(196346);
    super.draw(paramCanvas);
    int j = this.bYC.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.bYC.get(i)).b(paramCanvas, this, this.bZn);
      i += 1;
    }
    int n;
    if ((this.bYV != null) && (!this.bYV.isFinished()))
    {
      n = paramCanvas.save();
      if (this.bYx)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.bYV == null) || (!this.bYV.draw(paramCanvas))) {
          break label468;
        }
        j = 1;
        label134:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.bYW != null)
      {
        i = j;
        if (!this.bYW.isFinished())
        {
          n = paramCanvas.save();
          if (this.bYx) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.bYW == null) || (!this.bYW.draw(paramCanvas))) {
            break label473;
          }
          i = 1;
          label208:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.bYX != null)
      {
        j = i;
        if (!this.bYX.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.bYx) {
            break label478;
          }
          j = getPaddingTop();
          label263:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.bYX == null) || (!this.bYX.draw(paramCanvas))) {
            break label483;
          }
          j = 1;
          label301:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.bYY != null)
      {
        i = j;
        if (!this.bYY.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.bYx) {
            break label488;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label378:
          i = m;
          if (this.bYY != null)
          {
            i = m;
            if (this.bYY.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.bYZ != null) && (this.bYC.size() > 0) && (this.bYZ.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          androidx.core.g.z.Q(this);
        }
        AppMethodBeat.o(196346);
        return;
        i = 0;
        break;
        label468:
        j = 0;
        break label134;
        label473:
        i = 0;
        break label208;
        label478:
        j = 0;
        break label263;
        label483:
        j = 0;
        break label301;
        label488:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label378;
      }
      j = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(196492);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(196492);
    return bool;
  }
  
  public final void em(int paramInt)
  {
    AppMethodBeat.i(196579);
    getScrollingChildHelper().em(paramInt);
    AppMethodBeat.o(196579);
  }
  
  public final RecyclerView.h fR(int paramInt)
  {
    AppMethodBeat.i(195732);
    int i = getItemDecorationCount();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new IndexOutOfBoundsException(paramInt + " is an invalid index for size " + i);
      AppMethodBeat.o(195732);
      throw ((Throwable)localObject);
    }
    Object localObject = (RecyclerView.h)this.bYC.get(paramInt);
    AppMethodBeat.o(195732);
    return localObject;
  }
  
  final void fS(int paramInt)
  {
    AppMethodBeat.i(195830);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195830);
      return;
    }
    LayoutManager localLayoutManager = this.bYA;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aYi(), "androidx/recyclerview/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "androidx/recyclerview/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
    AppMethodBeat.o(195830);
  }
  
  public final v fT(int paramInt)
  {
    AppMethodBeat.i(196451);
    v localv = w(paramInt, false);
    AppMethodBeat.o(196451);
    return localv;
  }
  
  public final v fU(int paramInt)
  {
    AppMethodBeat.i(196460);
    if (this.bYQ)
    {
      AppMethodBeat.o(196460);
      return null;
    }
    int j = this.mChildHelper.IU();
    int i = 0;
    Object localObject = null;
    v localv;
    if (i < j)
    {
      localv = bz(this.mChildHelper.fD(i));
      if ((localv == null) || (localv.isRemoved()) || (l(localv) != paramInt)) {
        break label119;
      }
      if (this.mChildHelper.bi(localv.caK)) {
        localObject = localv;
      }
    }
    label119:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(196460);
      return localv;
      AppMethodBeat.o(196460);
      return localObject;
    }
  }
  
  public final View findContainingItemView(View paramView)
  {
    AppMethodBeat.i(196440);
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this)
    {
      AppMethodBeat.o(196440);
      return paramView;
    }
    AppMethodBeat.o(196440);
    return null;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    AppMethodBeat.i(196038);
    Object localObject = this.bYA.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null)
    {
      AppMethodBeat.o(196038);
      return localObject;
    }
    int i;
    label105:
    int k;
    if ((this.bUp != null) && (this.bYA != null) && (!Ka()) && (!this.bYK))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label369;
      }
      if (!this.bYA.canScrollVertically()) {
        break label1063;
      }
      if (paramInt != 2) {
        break label259;
      }
      i = 130;
      if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
        break label265;
      }
      k = 1;
      label119:
      j = k;
      if (bYp) {
        paramInt = i;
      }
    }
    label259:
    label265:
    label271:
    label276:
    label282:
    label288:
    label294:
    label1063:
    for (int j = k;; j = 0)
    {
      int m = j;
      k = paramInt;
      if (j == 0)
      {
        m = j;
        k = paramInt;
        if (this.bYA.canScrollHorizontally())
        {
          if (this.bYA.getLayoutDirection() != 1) {
            break label271;
          }
          i = 1;
          label177:
          if (paramInt != 2) {
            break label276;
          }
          j = 1;
          label185:
          if ((j ^ i) == 0) {
            break label282;
          }
          i = 66;
          label195:
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
            break label288;
          }
        }
      }
      for (j = 1;; j = 0)
      {
        m = j;
        k = paramInt;
        if (bYp)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label322;
        }
        JM();
        if (findContainingItemView(paramView) != null) {
          break label294;
        }
        AppMethodBeat.o(196038);
        return null;
        i = 0;
        break;
        i = 33;
        break label105;
        k = 0;
        break label119;
        i = 0;
        break label177;
        j = 0;
        break label185;
        i = 17;
        break label195;
      }
      JN();
      this.bYA.onFocusSearchFailed(paramView, k, this.bYt, this.bZn);
      bc(false);
      label322:
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
      while ((localObject != null) && (!((View)localObject).hasFocusable())) {
        if (getFocusedChild() == null)
        {
          paramView = super.focusSearch(paramView, k);
          AppMethodBeat.o(196038);
          return paramView;
          label369:
          View localView = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
          localObject = localView;
          k = paramInt;
          if (localView == null)
          {
            localObject = localView;
            k = paramInt;
            if (i != 0)
            {
              JM();
              if (findContainingItemView(paramView) == null)
              {
                AppMethodBeat.o(196038);
                return null;
              }
              JN();
              localObject = this.bYA.onFocusSearchFailed(paramView, paramInt, this.bYt, this.bZn);
              bc(false);
              k = paramInt;
            }
          }
        }
        else
        {
          e((View)localObject, null);
          AppMethodBeat.o(196038);
          return paramView;
        }
      }
      paramInt = n;
      if (localObject != null)
      {
        if (localObject != this) {
          break label501;
        }
        paramInt = n;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          AppMethodBeat.o(196038);
          return localObject;
          label501:
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
              this.hy.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.hy);
              if (this.bYA.getLayoutDirection() == 1)
              {
                m = -1;
                label604:
                if (((this.mTempRect.left >= this.hy.left) && (this.mTempRect.right > this.hy.left)) || (this.mTempRect.right >= this.hy.right)) {
                  break label819;
                }
                i = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (((this.mTempRect.top < this.hy.top) || (this.mTempRect.bottom <= this.hy.top)) && (this.mTempRect.bottom < this.hy.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            paramView = new IllegalArgumentException("Invalid direction: " + k + JJ());
            AppMethodBeat.o(196038);
            throw paramView;
            m = 1;
            break label604;
            label819:
            if (((this.mTempRect.right <= this.hy.right) && (this.mTempRect.left < this.hy.right)) || (this.mTempRect.left <= this.hy.left)) {
              break label1058;
            }
            i = -1;
            break label657;
            if ((this.mTempRect.bottom > this.hy.bottom) || (this.mTempRect.top >= this.hy.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.hy.top) {}
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
        paramView = super.focusSearch(paramView, k);
        AppMethodBeat.o(196038);
        return paramView;
        i = 0;
      }
    }
  }
  
  final void g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(196405);
    int j = this.mChildHelper.IU();
    int i = 0;
    if (i < j)
    {
      localObject = bz(this.mChildHelper.fD(i));
      if ((localObject != null) && (!((v)localObject).KH()))
      {
        if (((v)localObject).mPosition < paramInt1 + paramInt2) {
          break label88;
        }
        ((v)localObject).y(-paramInt2, paramBoolean);
        this.bZn.cav = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label88:
        if (((v)localObject).mPosition >= paramInt1)
        {
          int k = -paramInt2;
          ((v)localObject).gh(8);
          ((v)localObject).y(k, paramBoolean);
          ((v)localObject).mPosition = (paramInt1 - 1);
          this.bZn.cav = true;
        }
      }
    }
    Object localObject = this.bYt;
    i = ((n)localObject).bZZ.size() - 1;
    if (i >= 0)
    {
      v localv = (v)((n)localObject).bZZ.get(i);
      if (localv != null)
      {
        if (localv.mPosition < paramInt1 + paramInt2) {
          break label206;
        }
        localv.y(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label206:
        if (localv.mPosition >= paramInt1)
        {
          localv.gh(8);
          ((n)localObject).gd(i);
        }
      }
    }
    requestLayout();
    AppMethodBeat.o(196405);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(196372);
    if (this.bYA == null)
    {
      localObject = new IllegalStateException("RecyclerView has no LayoutManager" + JJ());
      AppMethodBeat.o(196372);
      throw ((Throwable)localObject);
    }
    Object localObject = this.bYA.generateDefaultLayoutParams();
    AppMethodBeat.o(196372);
    return localObject;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(196381);
    if (this.bYA == null)
    {
      paramAttributeSet = new IllegalStateException("RecyclerView has no LayoutManager" + JJ());
      AppMethodBeat.o(196381);
      throw paramAttributeSet;
    }
    paramAttributeSet = this.bYA.generateLayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(196381);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(196391);
    if (this.bYA == null)
    {
      paramLayoutParams = new IllegalStateException("RecyclerView has no LayoutManager" + JJ());
      AppMethodBeat.o(196391);
      throw paramLayoutParams;
    }
    paramLayoutParams = this.bYA.generateLayoutParams(paramLayoutParams);
    AppMethodBeat.o(196391);
    return paramLayoutParams;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.bUp;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(195588);
    if (this.bYA != null)
    {
      i = this.bYA.getBaseline();
      AppMethodBeat.o(195588);
      return i;
    }
    int i = super.getBaseline();
    AppMethodBeat.o(195588);
    return i;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196623);
    if (this.bWO == null)
    {
      paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
      AppMethodBeat.o(196623);
      return paramInt1;
    }
    paramInt1 = this.bWO.bi(paramInt1, paramInt2);
    AppMethodBeat.o(196623);
    return paramInt1;
  }
  
  public boolean getClipToPadding()
  {
    return this.bYx;
  }
  
  public u getCompatAccessibilityDelegate()
  {
    return this.bZu;
  }
  
  public e getEdgeEffectFactory()
  {
    return this.bYU;
  }
  
  public f getItemAnimator()
  {
    return this.bYZ;
  }
  
  public int getItemDecorationCount()
  {
    AppMethodBeat.i(195740);
    int i = this.bYC.size();
    AppMethodBeat.o(195740);
    return i;
  }
  
  public LayoutManager getLayoutManager()
  {
    return this.bYA;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.bZg;
  }
  
  public int getMinFlingVelocity()
  {
    return this.wV;
  }
  
  long getNanoTime()
  {
    AppMethodBeat.i(196522);
    if (bYo)
    {
      long l = System.nanoTime();
      AppMethodBeat.o(196522);
      return l;
    }
    AppMethodBeat.o(196522);
    return 0L;
  }
  
  public RecyclerView.j getOnFlingListener()
  {
    return this.bZf;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.bZj;
  }
  
  public RecyclerView.m getRecycledViewPool()
  {
    AppMethodBeat.i(195683);
    RecyclerView.m localm = this.bYt.getRecycledViewPool();
    AppMethodBeat.o(195683);
    return localm;
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  n getScrollingChildHelper()
  {
    AppMethodBeat.i(196627);
    if (this.bZw == null) {
      this.bZw = new n(this);
    }
    n localn = this.bZw;
    AppMethodBeat.o(196627);
    return localn;
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(196585);
    boolean bool = getScrollingChildHelper().hasNestedScrollingParent();
    AppMethodBeat.o(196585);
    return bool;
  }
  
  final void i(v paramv)
  {
    AppMethodBeat.i(195673);
    View localView = paramv.caK;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.bYt.y(bj(localView));
      if (!paramv.KQ()) {
        break;
      }
      this.mChildHelper.a(localView, -1, localView.getLayoutParams(), true);
      AppMethodBeat.o(195673);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.c(localView, -1, true);
      AppMethodBeat.o(195673);
      return;
    }
    paramv = this.mChildHelper;
    i = paramv.bUz.bh(localView);
    if (i < 0)
    {
      paramv = new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
      AppMethodBeat.o(195673);
      throw paramv;
    }
    paramv.bUA.set(i);
    paramv.bf(localView);
    AppMethodBeat.o(195673);
  }
  
  final boolean isAccessibilityEnabled()
  {
    AppMethodBeat.i(196265);
    if ((this.bYO != null) && (this.bYO.isEnabled()))
    {
      AppMethodBeat.o(196265);
      return true;
    }
    AppMethodBeat.o(196265);
    return false;
  }
  
  public boolean isAttachedToWindow()
  {
    return this.bIj;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(196563);
    boolean bool = getScrollingChildHelper().isNestedScrollingEnabled();
    AppMethodBeat.o(196563);
    return bool;
  }
  
  final int l(v paramv)
  {
    AppMethodBeat.i(196546);
    if ((paramv.gg(524)) || (!paramv.isBound()))
    {
      AppMethodBeat.o(196546);
      return -1;
    }
    int i = this.bYv.fA(paramv.mPosition);
    AppMethodBeat.o(196546);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool = true;
    AppMethodBeat.i(196090);
    super.onAttachedToWindow();
    this.bYS = 0;
    this.bIj = true;
    float f;
    if ((this.bYH) && (!isLayoutRequested()))
    {
      this.bYH = bool;
      if (this.bYA != null) {
        this.bYA.dispatchAttachedToWindow(this);
      }
      this.bZt = false;
      if (bYo)
      {
        this.bZl = ((j)j.bVX.get());
        if (this.bZl == null)
        {
          this.bZl = new j();
          Display localDisplay = androidx.core.g.z.aA(this);
          if ((isInEditMode()) || (localDisplay == null)) {
            break label174;
          }
          f = localDisplay.getRefreshRate();
          if (f < 30.0F) {
            break label174;
          }
        }
      }
    }
    for (;;)
    {
      this.bZl.bWa = ((1.0E+009F / f));
      j.bVX.set(this.bZl);
      this.bZl.bVY.add(this);
      AppMethodBeat.o(196090);
      return;
      bool = false;
      break;
      label174:
      f = 60.0F;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(196102);
    super.onDetachedFromWindow();
    if (this.bYZ != null) {
      this.bYZ.IY();
    }
    JO();
    this.bIj = false;
    if (this.bYA != null) {
      this.bYA.dispatchDetachedFromWindow(this, this.bYt);
    }
    this.bZz.clear();
    removeCallbacks(this.bZA);
    z.a.Lt();
    if ((bYo) && (this.bZl != null))
    {
      this.bZl.bVY.remove(this);
      this.bZl = null;
    }
    AppMethodBeat.o(196102);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196355);
    super.onDraw(paramCanvas);
    int j = this.bYC.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.bYC.get(i)).a(paramCanvas, this, this.bZn);
      i += 1;
    }
    AppMethodBeat.o(196355);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196207);
    if (this.bYA == null)
    {
      AppMethodBeat.o(196207);
      return false;
    }
    if (this.bYK)
    {
      AppMethodBeat.o(196207);
      return false;
    }
    float f1;
    float f3;
    float f2;
    if (paramMotionEvent.getAction() == 8)
    {
      if ((paramMotionEvent.getSource() & 0x2) == 0) {
        break label151;
      }
      if (!this.bYA.canScrollVertically()) {
        break label135;
      }
      f1 = -paramMotionEvent.getAxisValue(9);
      if (!this.bYA.canScrollHorizontally()) {
        break label140;
      }
      f3 = paramMotionEvent.getAxisValue(10);
      f2 = f1;
      f1 = f3;
    }
    for (;;)
    {
      if ((f2 != 0.0F) || (f1 != 0.0F)) {
        a((int)(this.bZh * f1), (int)(this.bZi * f2), paramMotionEvent);
      }
      AppMethodBeat.o(196207);
      return false;
      label135:
      f1 = 0.0F;
      break;
      label140:
      f3 = 0.0F;
      f2 = f1;
      f1 = f3;
      continue;
      label151:
      if ((paramMotionEvent.getSource() & 0x400000) != 0)
      {
        f1 = paramMotionEvent.getAxisValue(26);
        if (this.bYA.canScrollVertically())
        {
          f2 = -f1;
          f1 = 0.0F;
        }
        else if (this.bYA.canScrollHorizontally())
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
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196164);
    if (this.bYK)
    {
      AppMethodBeat.o(196164);
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.bYE = null;
    }
    int k = this.bYD.size();
    int i = 0;
    if (i < k)
    {
      k localk = (k)this.bYD.get(i);
      if ((localk.a(this, paramMotionEvent)) && (j != 3)) {
        this.bYE = localk;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label123;
      }
      JX();
      AppMethodBeat.o(196164);
      return true;
      i += 1;
      break;
    }
    label123:
    if (this.bYA == null)
    {
      AppMethodBeat.o(196164);
      return false;
    }
    boolean bool1 = this.bYA.canScrollHorizontally();
    boolean bool2 = this.bYA.canScrollVertically();
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
      if (this.mScrollState == 1)
      {
        AppMethodBeat.o(196164);
        return true;
      }
      break;
    case 0: 
      if (this.bYL) {
        this.bYL = false;
      }
      this.bZa = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.bZd = i;
      this.bZb = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.bZe = i;
      this.bZc = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.bZx;
      this.bZx[1] = 0;
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
      az(j, 0);
      break;
      this.bZa = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.bZd = j;
      this.bZb = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.bZe = i;
      this.bZc = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.bZa);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.bZa).append(" not found. Did any MotionEvents get skipped?");
        AppMethodBeat.o(196164);
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.bZb;
      int m = this.bZc;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.bZd = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.bZe = k;
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
        em(0);
        break;
        JX();
        break;
        AppMethodBeat.o(196164);
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196316);
    g.ax("RV OnLayout");
    Ke();
    g.DS();
    this.bYH = true;
    AppMethodBeat.o(196316);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(196218);
    if (this.bYA == null)
    {
      bv(paramInt1, paramInt2);
      AppMethodBeat.o(196218);
      return;
    }
    if (this.bYA.isAutoMeasureEnabled())
    {
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      this.bYA.onMeasure(this.bYt, this.bZn, paramInt1, paramInt2);
      int i = j;
      if (k == 1073741824)
      {
        i = j;
        if (m == 1073741824) {
          i = 1;
        }
      }
      if ((i != 0) || (this.bUp == null))
      {
        AppMethodBeat.o(196218);
        return;
      }
      if (this.bZn.cat == 1) {
        Ki();
      }
      this.bYA.setMeasureSpecs(paramInt1, paramInt2);
      this.bZn.cay = true;
      Kj();
      this.bYA.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      if (this.bYA.shouldMeasureTwice())
      {
        this.bYA.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.bZn.cay = true;
        Kj();
        this.bYA.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      }
      AppMethodBeat.o(196218);
      return;
    }
    if (this.bYF)
    {
      this.bYA.onMeasure(this.bYt, this.bZn, paramInt1, paramInt2);
      AppMethodBeat.o(196218);
      return;
    }
    if (this.bYN)
    {
      JN();
      JY();
      Kd();
      bd(true);
      if (this.bZn.caA)
      {
        this.bZn.caw = true;
        this.bYN = false;
        bc(false);
        label303:
        if (this.bUp == null) {
          break label412;
        }
      }
    }
    label412:
    for (this.bZn.cau = this.bUp.getItemCount();; this.bZn.cau = 0)
    {
      JN();
      this.bYA.onMeasure(this.bYt, this.bZn, paramInt1, paramInt2);
      bc(false);
      this.bZn.caw = false;
      AppMethodBeat.o(196218);
      return;
      this.bYv.IQ();
      this.bZn.caw = false;
      break;
      if (!this.bZn.caA) {
        break label303;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      AppMethodBeat.o(196218);
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(196076);
    if (Ka())
    {
      AppMethodBeat.o(196076);
      return false;
    }
    boolean bool = super.onRequestFocusInDescendants(paramInt, paramRect);
    AppMethodBeat.o(196076);
    return bool;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(195641);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(195641);
      return;
    }
    this.bYu = ((SavedState)paramParcelable);
    super.onRestoreInstanceState(this.bYu.bxs);
    if ((this.bYA != null) && (this.bYu.caf != null)) {
      this.bYA.onRestoreInstanceState(this.bYu.caf);
    }
    AppMethodBeat.o(195641);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(195631);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.bYu != null) {
      localSavedState.caf = this.bYu.caf;
    }
    for (;;)
    {
      AppMethodBeat.o(195631);
      return localSavedState;
      if (this.bYA != null) {
        localSavedState.caf = this.bYA.onSaveInstanceState();
      } else {
        localSavedState.caf = null;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196235);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      JV();
    }
    AppMethodBeat.o(196235);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    AppMethodBeat.i(196198);
    if ((this.bYK) || (this.bYL))
    {
      AppMethodBeat.o(196198);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (this.bYE != null)
    {
      if (i == 0) {
        this.bYE = null;
      }
    }
    else
    {
      if (i == 0) {
        break label173;
      }
      j = this.bYD.size();
      i = 0;
      if (i >= j) {
        break label173;
      }
      localObject = (k)this.bYD.get(i);
      if (!((k)localObject).a(this, paramMotionEvent)) {
        break label164;
      }
      this.bYE = ((k)localObject);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label179;
      }
      JX();
      AppMethodBeat.o(196198);
      return true;
      this.bYE.b(this, paramMotionEvent);
      if ((i == 3) || (i == 1)) {
        this.bYE = null;
      }
      i = 1;
      continue;
      label164:
      i += 1;
      break;
      label173:
      i = 0;
    }
    label179:
    if (this.bYA == null)
    {
      AppMethodBeat.o(196198);
      return false;
    }
    boolean bool1 = this.bYA.canScrollHorizontally();
    boolean bool2 = this.bYA.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.bZx;
      this.bZx[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.bZx[0], this.bZx[1]);
    i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      AppMethodBeat.o(196198);
      return true;
    case 0: 
      this.bZa = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.bZd = i;
      this.bZb = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.bZe = i;
      this.bZc = i;
      if (!bool1) {
        break;
      }
    }
    label770:
    label820:
    label976:
    label988:
    label1127:
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      az(j, 0);
      i = i2;
      break;
      this.bZa = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.bZd = i;
      this.bZb = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.bZe = i;
      this.bZc = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.bZa);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.bZa).append(" not found. Did any MotionEvents get skipped?");
        AppMethodBeat.o(196198);
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.bZd - i3;
      k = this.bZe - i4;
      j = m;
      i = k;
      if (a(m, k, this.bwJ, this.bwI, 0))
      {
        j = m - this.bwJ[0];
        i = k - this.bwJ[1];
        ((MotionEvent)localObject).offsetLocation(this.bwI[0], this.bwI[1]);
        paramMotionEvent = this.bZx;
        paramMotionEvent[0] += this.bwI[0];
        paramMotionEvent = this.bZx;
        paramMotionEvent[1] += this.bwI[1];
      }
      k = j;
      m = i;
      if (this.mScrollState != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.mTouchSlop)) {
          break label1143;
        }
        if (j <= 0) {
          break label976;
        }
        j -= this.mTouchSlop;
      }
      label1006:
      label1143:
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
              break label988;
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
        this.bZd = (i3 - this.bwI[0]);
        this.bZe = (i4 - this.bwI[1]);
        if (bool1)
        {
          i = k;
          if (!bool2) {
            break label1006;
          }
        }
        for (j = m;; j = 0)
        {
          if (a(i, j, (MotionEvent)localObject)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          i = i2;
          if (this.bZl == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.bZl.a(this, k, m);
          i = i2;
          break;
          j = this.mTouchSlop + j;
          break label770;
          i = this.mTouchSlop + i;
          break label820;
          i = 0;
          break label900;
        }
        l(paramMotionEvent);
        i = i2;
        break;
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.bZg);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.bZa);
          if (!bool2) {
            break label1127;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.bZa);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!bs((int)f1, (int)f2))) {
            setScrollState(0);
          }
          JW();
          i = 1;
          break;
          f1 = 0.0F;
          break label1066;
        }
        JX();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(196309);
    v localv = bz(paramView);
    if (localv != null)
    {
      if (!localv.KQ()) {
        break label48;
      }
      localv.KO();
    }
    label48:
    while (localv.KH())
    {
      paramView.clearAnimation();
      bE(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      AppMethodBeat.o(196309);
      return;
    }
    paramView = new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv + JJ());
    AppMethodBeat.o(196309);
    throw paramView;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    AppMethodBeat.i(196048);
    if ((!this.bYA.onRequestChildFocus(this, this.bZn, paramView1, paramView2)) && (paramView2 != null)) {
      e(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
    AppMethodBeat.o(196048);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(196057);
    paramBoolean = this.bYA.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
    AppMethodBeat.o(196057);
    return paramBoolean;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(196171);
    int j = this.bYD.size();
    int i = 0;
    while (i < j)
    {
      ((k)this.bYD.get(i)).aX(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(196171);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(196323);
    if ((this.bYI == 0) && (!this.bYK))
    {
      super.requestLayout();
      AppMethodBeat.o(196323);
      return;
    }
    this.bYJ = true;
    AppMethodBeat.o(196323);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195856);
    if (this.bYA == null)
    {
      AppMethodBeat.o(195856);
      return;
    }
    if (this.bYK)
    {
      AppMethodBeat.o(195856);
      return;
    }
    boolean bool1 = this.bYA.canScrollHorizontally();
    boolean bool2 = this.bYA.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        break label84;
      }
      if (!bool2) {
        break label89;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, null);
      AppMethodBeat.o(195856);
      return;
      label84:
      paramInt1 = 0;
      break;
      label89:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {}
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(195819);
    if (this.bYK)
    {
      AppMethodBeat.o(195819);
      return;
    }
    JO();
    if (this.bYA == null)
    {
      AppMethodBeat.o(195819);
      return;
    }
    LayoutManager localLayoutManager = this.bYA;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aYi(), "androidx/recyclerview/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "androidx/recyclerview/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
    AppMethodBeat.o(195819);
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(196280);
    if (Ka()) {
      if (paramAccessibilityEvent == null) {
        break label70;
      }
    }
    label70:
    for (i = b.b(paramAccessibilityEvent);; i = 0)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.bYM = (i | this.bYM);
        i = 1;
        if (i != 0)
        {
          AppMethodBeat.o(196280);
          return;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        AppMethodBeat.o(196280);
        return;
      }
    }
  }
  
  public void setAccessibilityDelegateCompat(u paramu)
  {
    AppMethodBeat.i(195511);
    this.bZu = paramu;
    androidx.core.g.z.a(this, this.bZu);
    AppMethodBeat.o(195511);
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    AppMethodBeat.i(195563);
    setLayoutFrozen(false);
    if (this.bUp != null)
    {
      this.bUp.b(this.bYs);
      this.bUp.e(this);
    }
    JK();
    this.bYv.reset();
    RecyclerView.a locala = this.bUp;
    this.bUp = parama;
    if (parama != null)
    {
      parama.a(this.bYs);
      parama.d(this);
    }
    if (this.bYA != null) {
      this.bYA.onAdapterChanged(locala, this.bUp);
    }
    Object localObject = this.bYt;
    parama = this.bUp;
    ((n)localObject).clear();
    localObject = ((n)localObject).getRecycledViewPool();
    if (locala != null) {
      ((RecyclerView.m)localObject).detach();
    }
    if (((RecyclerView.m)localObject).bZS == 0) {
      ((RecyclerView.m)localObject).clear();
    }
    if (parama != null) {
      ((RecyclerView.m)localObject).vX();
    }
    this.bZn.cav = true;
    be(false);
    requestLayout();
    AppMethodBeat.o(195563);
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    AppMethodBeat.i(195774);
    if (paramd == this.bWO)
    {
      AppMethodBeat.o(195774);
      return;
    }
    this.bWO = paramd;
    if (this.bWO != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      AppMethodBeat.o(195774);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(195531);
    if (paramBoolean != this.bYx) {
      JV();
    }
    this.bYx = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.bYH) {
      requestLayout();
    }
    AppMethodBeat.o(195531);
  }
  
  public void setEdgeEffectFactory(e parame)
  {
    AppMethodBeat.i(196015);
    androidx.core.f.f.checkNotNull(parame);
    this.bYU = parame;
    JV();
    AppMethodBeat.o(196015);
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.bYF = paramBoolean;
  }
  
  public void setItemAnimator(f paramf)
  {
    AppMethodBeat.i(196246);
    if (this.bYZ != null)
    {
      this.bYZ.IY();
      this.bYZ.bZG = null;
    }
    this.bYZ = paramf;
    if (this.bYZ != null) {
      this.bYZ.bZG = this.bZs;
    }
    AppMethodBeat.o(196246);
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    AppMethodBeat.i(195699);
    n localn = this.bYt;
    localn.cab = paramInt;
    localn.KA();
    AppMethodBeat.o(195699);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(195954);
    if (paramBoolean != this.bYK)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.bYK = false;
        if ((this.bYJ) && (this.bYA != null) && (this.bUp != null)) {
          requestLayout();
        }
        this.bYJ = false;
        AppMethodBeat.o(195954);
        return;
      }
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      this.bYK = true;
      this.bYL = true;
      JO();
    }
    AppMethodBeat.o(195954);
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(195609);
    if (paramLayoutManager == this.bYA)
    {
      AppMethodBeat.o(195609);
      return;
    }
    JO();
    if (this.bYA != null)
    {
      if (this.bYZ != null) {
        this.bYZ.IY();
      }
      this.bYA.removeAndRecycleAllViews(this.bYt);
      this.bYA.removeAndRecycleScrapInt(this.bYt);
      this.bYt.clear();
      if (this.bIj) {
        this.bYA.dispatchDetachedFromWindow(this, this.bYt);
      }
      this.bYA.setRecyclerView(null);
      this.bYA = null;
    }
    e locale;
    for (;;)
    {
      locale = this.mChildHelper;
      for (e.a locala = locale.bUA;; locala = locala.bUD)
      {
        locala.bUC = 0L;
        if (locala.bUD == null) {
          break;
        }
      }
      this.bYt.clear();
    }
    int i = locale.bUB.size() - 1;
    while (i >= 0)
    {
      locale.bUz.bl((View)locale.bUB.get(i));
      locale.bUB.remove(i);
      i -= 1;
    }
    locale.bUz.removeAllViews();
    this.bYA = paramLayoutManager;
    if (paramLayoutManager != null)
    {
      if (paramLayoutManager.mRecyclerView != null)
      {
        paramLayoutManager = new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView:" + paramLayoutManager.mRecyclerView.JJ());
        AppMethodBeat.o(195609);
        throw paramLayoutManager;
      }
      this.bYA.setRecyclerView(this);
      if (this.bIj) {
        this.bYA.dispatchAttachedToWindow(this);
      }
    }
    this.bYt.KA();
    requestLayout();
    AppMethodBeat.o(195609);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(196553);
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(196553);
  }
  
  public void setOnFlingListener(RecyclerView.j paramj)
  {
    this.bZf = paramj;
  }
  
  @Deprecated
  public void setOnScrollListener(RecyclerView.l paraml)
  {
    this.bZo = paraml;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.bZj = paramBoolean;
  }
  
  public void setRecycledViewPool(RecyclerView.m paramm)
  {
    AppMethodBeat.i(195687);
    n localn = this.bYt;
    if (localn.cad != null) {
      localn.cad.detach();
    }
    localn.cad = paramm;
    if ((localn.cad != null) && (localn.bZD.getAdapter() != null)) {
      localn.cad.vX();
    }
    AppMethodBeat.o(195687);
  }
  
  public void setRecyclerListener(o paramo)
  {
    this.bYB = paramo;
  }
  
  void setScrollState(int paramInt)
  {
    AppMethodBeat.i(195713);
    if (paramInt == this.mScrollState)
    {
      AppMethodBeat.o(195713);
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      JP();
    }
    if (this.bYA != null) {
      this.bYA.onScrollStateChanged(paramInt);
    }
    if (this.bZo != null) {
      this.bZo.onScrollStateChanged(this, paramInt);
    }
    if (this.bZp != null)
    {
      int i = this.bZp.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.l)this.bZp.get(i)).onScrollStateChanged(this, paramInt);
        i -= 1;
      }
    }
    AppMethodBeat.o(195713);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    AppMethodBeat.i(195553);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      new StringBuilder("setScrollingTouchSlop(): bad argument constant ").append(paramInt).append("; using default value");
    case 0: 
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      AppMethodBeat.o(195553);
      return;
    }
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
    AppMethodBeat.o(195553);
  }
  
  public void setViewCacheExtension(t paramt)
  {
    this.bYt.cae = paramt;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(195841);
    if (this.bYK)
    {
      AppMethodBeat.o(195841);
      return;
    }
    if (this.bYA == null)
    {
      AppMethodBeat.o(195841);
      return;
    }
    this.bYA.smoothScrollToPosition(this, this.bZn, paramInt);
    AppMethodBeat.o(195841);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(196570);
    boolean bool = getScrollingChildHelper().startNestedScroll(paramInt);
    AppMethodBeat.o(196570);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(196573);
    getScrollingChildHelper().stopNestedScroll();
    AppMethodBeat.o(196573);
  }
  
  public final v w(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196470);
    int j = this.mChildHelper.IU();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      v localv = bz(this.mChildHelper.fD(i));
      Object localObject2 = localObject1;
      if (localv != null)
      {
        localObject2 = localObject1;
        if (!localv.isRemoved())
        {
          if (!paramBoolean) {
            break label88;
          }
          if (localv.mPosition == paramInt) {
            break label101;
          }
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label88:
        localObject2 = localObject1;
        if (localv.KI() == paramInt)
        {
          label101:
          if (!this.mChildHelper.bi(localv.caK)) {
            break label123;
          }
          localObject2 = localv;
        }
      }
      label123:
      AppMethodBeat.o(196470);
      return localv;
    }
    AppMethodBeat.o(196470);
    return localObject1;
  }
  
  public static abstract class LayoutManager
  {
    boolean mAutoMeasure = false;
    e mChildHelper;
    private int mHeight;
    private int mHeightMode;
    y mHorizontalBoundCheck = new y(this.mHorizontalBoundCheckCallback);
    private final y.b mHorizontalBoundCheckCallback = new y.b()
    {
      public final int Ky()
      {
        AppMethodBeat.i(195164);
        int i = RecyclerView.LayoutManager.this.getPaddingLeft();
        AppMethodBeat.o(195164);
        return i;
      }
      
      public final int Kz()
      {
        AppMethodBeat.i(195171);
        int i = RecyclerView.LayoutManager.this.getWidth();
        int j = RecyclerView.LayoutManager.this.getPaddingRight();
        AppMethodBeat.o(195171);
        return i - j;
      }
      
      public final int bF(View paramAnonymousView)
      {
        AppMethodBeat.i(195179);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedLeft(paramAnonymousView);
        int j = localLayoutParams.leftMargin;
        AppMethodBeat.o(195179);
        return i - j;
      }
      
      public final int bG(View paramAnonymousView)
      {
        AppMethodBeat.i(195187);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedRight(paramAnonymousView);
        int j = localLayoutParams.rightMargin;
        AppMethodBeat.o(195187);
        return j + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        AppMethodBeat.i(195153);
        View localView = RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
        AppMethodBeat.o(195153);
        return localView;
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
    y mVerticalBoundCheck = new y(this.mVerticalBoundCheckCallback);
    private final y.b mVerticalBoundCheckCallback = new y.b()
    {
      public final int Ky()
      {
        AppMethodBeat.i(195197);
        int i = RecyclerView.LayoutManager.this.getPaddingTop();
        AppMethodBeat.o(195197);
        return i;
      }
      
      public final int Kz()
      {
        AppMethodBeat.i(195213);
        int i = RecyclerView.LayoutManager.this.getHeight();
        int j = RecyclerView.LayoutManager.this.getPaddingBottom();
        AppMethodBeat.o(195213);
        return i - j;
      }
      
      public final int bF(View paramAnonymousView)
      {
        AppMethodBeat.i(195221);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedTop(paramAnonymousView);
        int j = localLayoutParams.topMargin;
        AppMethodBeat.o(195221);
        return i - j;
      }
      
      public final int bG(View paramAnonymousView)
      {
        AppMethodBeat.i(195228);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedBottom(paramAnonymousView);
        int j = localLayoutParams.bottomMargin;
        AppMethodBeat.o(195228);
        return j + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        AppMethodBeat.i(195190);
        View localView = RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
        AppMethodBeat.o(195190);
        return localView;
      }
    };
    private int mWidth;
    private int mWidthMode;
    
    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.v localv = RecyclerView.bz(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localv.isRemoved()))
      {
        this.mRecyclerView.bYw.I(localv);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localv.KM()) && (!localv.KK())) {
          break label128;
        }
        if (!localv.KK()) {
          break label120;
        }
        localv.KL();
        label68:
        this.mChildHelper.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.bZQ)
        {
          localv.caK.invalidate();
          localLayoutParams.bZQ = false;
        }
        return;
        this.mRecyclerView.bYw.J(localv);
        break;
        label120:
        localv.KN();
        break label68;
        label128:
        if (paramView.getParent() == this.mRecyclerView)
        {
          int j = this.mChildHelper.bh(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.mChildHelper.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(paramView) + this.mRecyclerView.JJ());
          }
          if (j != i) {
            this.mRecyclerView.bYA.moveView(j, i);
          }
        }
        else
        {
          this.mChildHelper.c(paramView, paramInt, false);
          localLayoutParams.bZP = true;
          if ((this.mSmoothScroller != null) && (this.mSmoothScroller.bzr))
          {
            RecyclerView.r localr = this.mSmoothScroller;
            if (RecyclerView.bB(paramView) == localr.cag) {
              localr.cai = paramView;
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.RecyclerView, paramInt1, paramInt2);
      localb.orientation = paramContext.getInt(a.c.RecyclerView_android_orientation, 1);
      localb.spanCount = paramContext.getInt(a.c.RecyclerView_spanCount, 1);
      localb.agn = paramContext.getBoolean(a.c.RecyclerView_reverseLayout, false);
      localb.bZO = paramContext.getBoolean(a.c.RecyclerView_stackFromEnd, false);
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
      RecyclerView.v localv = RecyclerView.bz(paramView);
      if (localv.KH()) {
        return;
      }
      if ((localv.isInvalid()) && (!localv.isRemoved()) && (!this.mRecyclerView.bUp.bZF))
      {
        removeViewAt(paramInt);
        paramn.x(localv);
        return;
      }
      detachViewAt(paramInt);
      paramn.bJ(paramView);
      this.mRecyclerView.bYw.J(localv);
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
      RecyclerView.v localv = RecyclerView.bz(paramView);
      if (localv.isRemoved()) {
        this.mRecyclerView.bYw.I(localv);
      }
      for (;;)
      {
        this.mChildHelper.a(paramView, paramInt, paramLayoutParams, localv.isRemoved());
        return;
        this.mRecyclerView.bYw.J(localv);
      }
    }
    
    public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      if (this.mRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.mRecyclerView.bC(paramView));
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
      scrapOrRecycleView(paramn, this.mChildHelper.bh(paramView), paramView);
    }
    
    public void detachAndScrapViewAt(int paramInt, RecyclerView.n paramn)
    {
      scrapOrRecycleView(paramn, paramInt, getChildAt(paramInt));
    }
    
    public void detachView(View paramView)
    {
      int i = this.mChildHelper.bh(paramView);
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
      if (this.mRecyclerView.bYZ != null) {
        this.mRecyclerView.bYZ.c(RecyclerView.bz(paramView));
      }
    }
    
    public View findContainingItemView(View paramView)
    {
      if (this.mRecyclerView == null) {}
      do
      {
        return null;
        paramView = this.mRecyclerView.findContainingItemView(paramView);
      } while ((paramView == null) || (this.mChildHelper.bi(paramView)));
      return paramView;
    }
    
    public View findViewByPosition(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.v localv = RecyclerView.bz(localView);
        if ((localv != null) && (localv.KI() == paramInt) && (!localv.KH()) && ((this.mRecyclerView.bZn.caw) || (!localv.isRemoved()))) {
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr.bottom;
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
      return (this.mRecyclerView != null) && (this.mRecyclerView.bYx);
    }
    
    public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.bUp == null)) {}
      while (!canScrollHorizontally()) {
        return 1;
      }
      return this.mRecyclerView.bUp.getItemCount();
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
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr;
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
      } while ((localView == null) || (this.mChildHelper.bi(localView)));
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
      return RecyclerView.bz(paramView).caO;
    }
    
    public int getLayoutDirection()
    {
      return androidx.core.g.z.U(this.mRecyclerView);
    }
    
    public int getLeftDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr.left;
    }
    
    public int getMinimumHeight()
    {
      return androidx.core.g.z.ab(this.mRecyclerView);
    }
    
    public int getMinimumWidth()
    {
      return androidx.core.g.z.aa(this.mRecyclerView);
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
        return androidx.core.g.z.Y(this.mRecyclerView);
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
        return androidx.core.g.z.X(this.mRecyclerView);
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bXh.KI();
    }
    
    public int getRightDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr.right;
    }
    
    public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.bUp == null)) {}
      while (!canScrollVertically()) {
        return 1;
      }
      return this.mRecyclerView.bUp.getItemCount();
    }
    
    public int getSelectionModeForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      return 0;
    }
    
    public int getTopDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr.top;
    }
    
    public void getTransformedBoundingBox(View paramView, boolean paramBoolean, Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr;
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
            RectF localRectF = this.mRecyclerView.bYz;
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
        throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.JJ());
      }
      paramView = RecyclerView.bz(paramView);
      paramView.gh(128);
      this.mRecyclerView.bYw.K(paramView);
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
      return (this.mSmoothScroller != null) && (this.mSmoothScroller.bzr);
    }
    
    public boolean isViewPartiallyVisible(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.mHorizontalBoundCheck.bO(paramView)) && (this.mVerticalBoundCheck.bO(paramView))) {}
      for (paramBoolean2 = true; paramBoolean1; paramBoolean2 = false) {
        return paramBoolean2;
      }
      return !paramBoolean2;
    }
    
    public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bWr;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.bWr;
      paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public void measureChild(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.bC(paramView);
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
      Rect localRect = this.mRecyclerView.bC(paramView);
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
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      onInitializeAccessibilityEvent(this.mRecyclerView.bYt, this.mRecyclerView.bZn, paramAccessibilityEvent);
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
        if (this.mRecyclerView.bUp == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.mRecyclerView.bUp.getItemCount());
        return;
      }
    }
    
    void onInitializeAccessibilityNodeInfo(androidx.core.g.a.d paramd)
    {
      onInitializeAccessibilityNodeInfo(this.mRecyclerView.bYt, this.mRecyclerView.bZn, paramd);
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.n paramn, RecyclerView.s params, androidx.core.g.a.d paramd)
    {
      if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
      {
        paramd.eu(8192);
        paramd.aH(true);
      }
      if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
      {
        paramd.eu(4096);
        paramd.aH(true);
      }
      paramd.aB(d.b.a(getRowCountForAccessibility(paramn, params), getColumnCountForAccessibility(paramn, params), isLayoutHierarchical(paramn, params), getSelectionModeForAccessibility(paramn, params)));
    }
    
    void onInitializeAccessibilityNodeInfoForItem(View paramView, androidx.core.g.a.d paramd)
    {
      RecyclerView.v localv = RecyclerView.bz(paramView);
      if ((localv != null) && (!localv.isRemoved()) && (!this.mChildHelper.bi(localv.caK))) {
        onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.bYt, this.mRecyclerView.bZn, paramView, paramd);
      }
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, androidx.core.g.a.d paramd)
    {
      int i;
      if (canScrollVertically())
      {
        i = getPosition(paramView);
        if (!canScrollHorizontally()) {
          break label51;
        }
      }
      label51:
      for (int j = getPosition(paramView);; j = 0)
      {
        paramd.aC(d.c.a(i, 1, j, 1, false, false));
        return;
        i = 0;
        break;
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
      this.mRecyclerView.bv(paramInt1, paramInt2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (isSmoothScrolling()) || (paramRecyclerView.Ka());
    }
    
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.s params, View paramView1, View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
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
      return performAccessibilityAction(this.mRecyclerView.bYt, this.mRecyclerView.bZn, paramInt, paramBundle);
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
      this.mRecyclerView.br(i, paramInt);
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
            break label195;
          }
        }
        label195:
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
    
    boolean performAccessibilityActionForItem(View paramView, int paramInt, Bundle paramBundle)
    {
      return performAccessibilityActionForItem(this.mRecyclerView.bYt, this.mRecyclerView.bZn, paramView, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityActionForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void postOnAnimation(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null) {
        androidx.core.g.z.b(this.mRecyclerView, paramRunnable);
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
        if (!RecyclerView.bz(getChildAt(i)).KH()) {
          removeAndRecycleViewAt(i, paramn);
        }
        i -= 1;
      }
    }
    
    void removeAndRecycleScrapInt(RecyclerView.n paramn)
    {
      int j = paramn.bZX.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.v)paramn.bZX.get(i)).caK;
        RecyclerView.v localv = RecyclerView.bz(localView);
        if (!localv.KH())
        {
          localv.bg(false);
          if (localv.KQ()) {
            this.mRecyclerView.removeDetachedView(localView, false);
          }
          if (this.mRecyclerView.bYZ != null) {
            this.mRecyclerView.bYZ.c(localv);
          }
          localv.bg(true);
          paramn.bI(localView);
        }
        i -= 1;
      }
      paramn.bZX.clear();
      if (paramn.bZY != null) {
        paramn.bZY.clear();
      }
      if (j > 0) {
        this.mRecyclerView.invalidate();
      }
    }
    
    public void removeAndRecycleView(View paramView, RecyclerView.n paramn)
    {
      removeView(paramView);
      paramn.bH(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, RecyclerView.n paramn)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramn.bH(localView);
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
      e locale = this.mChildHelper;
      int i = locale.bUz.bh(paramView);
      if (i >= 0)
      {
        if (locale.bUA.remove(i)) {
          locale.bg(paramView);
        }
        locale.bUz.removeViewAt(i);
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
        paramRecyclerView.br(i, j);
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
          this.mRecyclerView.bYt.KA();
        }
      }
    }
    
    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.mWidthMode = View.MeasureSpec.getMode(paramInt1);
      if ((this.mWidthMode == 0) && (!RecyclerView.bYm)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.mHeightMode = View.MeasureSpec.getMode(paramInt2);
      if ((this.mHeightMode == 0) && (!RecyclerView.bYm)) {
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
        this.mRecyclerView.bv(paramInt1, paramInt2);
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
      if ((this.mSmoothScroller != null) && (paramr != this.mSmoothScroller) && (this.mSmoothScroller.bzr)) {
        this.mSmoothScroller.stop();
      }
      this.mSmoothScroller = paramr;
      this.mSmoothScroller.a(this.mRecyclerView, this);
    }
    
    public void stopIgnoringView(View paramView)
    {
      paramView = RecyclerView.bz(paramView);
      paramView.cN &= 0xFFFFFF7F;
      paramView.resetInternal();
      paramView.gh(4);
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
      public abstract void bd(int paramInt1, int paramInt2);
    }
    
    public static class b
    {
      public boolean agn;
      public boolean bZO;
      public int orientation;
      public int spanCount;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect bWr;
    public RecyclerView.v bXh;
    boolean bZP;
    boolean bZQ;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(195240);
      this.bWr = new Rect();
      this.bZP = true;
      this.bZQ = false;
      AppMethodBeat.o(195240);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(195234);
      this.bWr = new Rect();
      this.bZP = true;
      this.bZQ = false;
      AppMethodBeat.o(195234);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(195251);
      this.bWr = new Rect();
      this.bZP = true;
      this.bZQ = false;
      AppMethodBeat.o(195251);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      AppMethodBeat.i(195247);
      this.bWr = new Rect();
      this.bZP = true;
      this.bZQ = false;
      AppMethodBeat.o(195247);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(195257);
      this.bWr = new Rect();
      this.bZP = true;
      this.bZQ = false;
      AppMethodBeat.o(195257);
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    Parcelable caf;
    
    static
    {
      AppMethodBeat.i(194645);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(194645);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(194626);
      if (paramClassLoader != null) {}
      for (;;)
      {
        this.caf = paramParcel.readParcelable(paramClassLoader);
        AppMethodBeat.o(194626);
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
      AppMethodBeat.i(194657);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.caf, 0);
      AppMethodBeat.o(194657);
    }
  }
  
  public static abstract interface d
  {
    public abstract int bi(int paramInt1, int paramInt2);
  }
  
  public static class e
  {
    protected static EdgeEffect f(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(195003);
      paramRecyclerView = new EdgeEffect(paramRecyclerView.getContext());
      AppMethodBeat.o(195003);
      return paramRecyclerView;
    }
  }
  
  public static abstract class f
  {
    b bZG = null;
    private ArrayList<a> bZH = new ArrayList();
    public long bZI = 120L;
    public long bZJ = 120L;
    public long bZK = 250L;
    public long bZL = 250L;
    
    public static RecyclerView.f.c Kw()
    {
      return new RecyclerView.f.c();
    }
    
    static int q(RecyclerView.v paramv)
    {
      int j = paramv.cN & 0xE;
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
            k = paramv.caM;
            m = paramv.KJ();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    public abstract void IW();
    
    public abstract void IY();
    
    public long Kt()
    {
      return this.bZI;
    }
    
    public long Ku()
    {
      return this.bZJ;
    }
    
    public final void Kv()
    {
      int j = this.bZH.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.bZH.get(i)).Kx();
        i += 1;
      }
      this.bZH.clear();
    }
    
    public RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      return new RecyclerView.f.c().e(paramv, 0);
    }
    
    public final boolean a(a parama)
    {
      boolean bool = isRunning();
      if (parama != null)
      {
        if (!bool) {
          parama.Kx();
        }
      }
      else {
        return bool;
      }
      this.bZH.add(parama);
      return bool;
    }
    
    public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public boolean a(RecyclerView.v paramv, List<Object> paramList)
    {
      return t(paramv);
    }
    
    public abstract void c(RecyclerView.v paramv);
    
    public abstract boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract boolean isRunning();
    
    public final void r(RecyclerView.v paramv)
    {
      s(paramv);
      if (this.bZG != null) {
        this.bZG.s(paramv);
      }
    }
    
    public void s(RecyclerView.v paramv) {}
    
    public boolean t(RecyclerView.v paramv)
    {
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void Kx();
    }
    
    static abstract interface b
    {
      public abstract void s(RecyclerView.v paramv);
    }
  }
  
  final class g
    implements RecyclerView.f.b
  {
    g() {}
    
    public final void s(RecyclerView.v paramv)
    {
      boolean bool = true;
      AppMethodBeat.i(195014);
      paramv.bg(true);
      if ((paramv.caQ != null) && (paramv.caR == null)) {
        paramv.caQ = null;
      }
      paramv.caR = null;
      int i;
      RecyclerView localRecyclerView;
      Object localObject;
      e locale;
      if ((paramv.cN & 0x10) != 0)
      {
        i = 1;
        if (i == 0)
        {
          localRecyclerView = RecyclerView.this;
          localObject = paramv.caK;
          localRecyclerView.JN();
          locale = localRecyclerView.mChildHelper;
          i = locale.bUz.bh((View)localObject);
          if (i != -1) {
            break label179;
          }
          locale.bg((View)localObject);
          i = 1;
          label104:
          if (i != 0)
          {
            localObject = RecyclerView.bz((View)localObject);
            localRecyclerView.bYt.y((RecyclerView.v)localObject);
            localRecyclerView.bYt.x((RecyclerView.v)localObject);
          }
          if (i != 0) {
            break label230;
          }
        }
      }
      for (;;)
      {
        localRecyclerView.bc(bool);
        if ((i == 0) && (paramv.KQ())) {
          RecyclerView.this.removeDetachedView(paramv.caK, false);
        }
        AppMethodBeat.o(195014);
        return;
        i = 0;
        break;
        label179:
        if (locale.bUA.cr(i))
        {
          locale.bUA.remove(i);
          locale.bg((View)localObject);
          locale.bUz.removeViewAt(i);
          i = 1;
          break label104;
        }
        i = 0;
        break label104;
        label230:
        bool = false;
      }
    }
  }
  
  public static abstract interface i
  {
    public abstract void bm(View paramView);
    
    public abstract void bn(View paramView);
  }
  
  public static abstract interface k
  {
    public abstract boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void aX(boolean paramBoolean);
    
    public abstract void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public final class n
  {
    final ArrayList<RecyclerView.v> bZX;
    ArrayList<RecyclerView.v> bZY;
    final ArrayList<RecyclerView.v> bZZ;
    final List<RecyclerView.v> caa;
    int cab;
    int cac;
    RecyclerView.m cad;
    RecyclerView.t cae;
    
    public n()
    {
      AppMethodBeat.i(195055);
      this.bZX = new ArrayList();
      this.bZY = null;
      this.bZZ = new ArrayList();
      this.caa = Collections.unmodifiableList(this.bZX);
      this.cab = 2;
      this.cac = 2;
      AppMethodBeat.o(195055);
    }
    
    private void KB()
    {
      AppMethodBeat.i(195095);
      int i = this.bZZ.size() - 1;
      while (i >= 0)
      {
        gd(i);
        i -= 1;
      }
      this.bZZ.clear();
      if (RecyclerView.bYo) {
        RecyclerView.this.bZm.Jc();
      }
      AppMethodBeat.o(195095);
    }
    
    private void a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      AppMethodBeat.i(195090);
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          a((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean)
      {
        AppMethodBeat.o(195090);
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        AppMethodBeat.o(195090);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
      AppMethodBeat.o(195090);
    }
    
    private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(195075);
      paramv.cba = RecyclerView.this;
      int i = paramv.caO;
      long l1 = RecyclerView.this.getNanoTime();
      if (paramLong != 9223372036854775807L)
      {
        long l2 = this.cad.fZ(i).bZW;
        if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(195075);
          return false;
        }
      }
      Object localObject = RecyclerView.this.bUp;
      paramv.mPosition = paramInt1;
      if (((RecyclerView.a)localObject).bZF) {
        paramv.caN = ((RecyclerView.a)localObject).getItemId(paramInt1);
      }
      paramv.bH(1, 519);
      g.ax("RV OnBindView");
      ((RecyclerView.a)localObject).a(paramv, paramInt1, paramv.KT());
      paramv.KS();
      localObject = paramv.caK.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)localObject).bZP = true;
      }
      g.DS();
      paramLong = RecyclerView.this.getNanoTime();
      localObject = this.cad.fZ(paramv.caO);
      ((RecyclerView.m.a)localObject).bZW = RecyclerView.m.v(((RecyclerView.m.a)localObject).bZW, paramLong - l1);
      if (RecyclerView.this.isAccessibilityEnabled())
      {
        localObject = paramv.caK;
        if (androidx.core.g.z.R((View)localObject) == 0) {
          androidx.core.g.z.p((View)localObject, 1);
        }
        if (!androidx.core.g.z.L((View)localObject))
        {
          paramv.gh(16384);
          androidx.core.g.z.a((View)localObject, RecyclerView.this.bZu.cbb);
        }
      }
      if (RecyclerView.this.bZn.caw) {
        paramv.caP = paramInt2;
      }
      AppMethodBeat.o(195075);
      return true;
    }
    
    private RecyclerView.v b(long paramLong, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(195131);
      int i = this.bZX.size() - 1;
      RecyclerView.v localv;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.bZX.get(i);
        if ((localv.caN == paramLong) && (!localv.KM()))
        {
          if (paramInt == localv.caO)
          {
            localv.gh(32);
            if ((localv.isRemoved()) && (!RecyclerView.this.bZn.caw)) {
              localv.bH(2, 14);
            }
            AppMethodBeat.o(195131);
            return localv;
          }
          this.bZX.remove(i);
          RecyclerView.this.removeDetachedView(localv.caK, false);
          bI(localv.caK);
        }
        i -= 1;
      }
      i = this.bZZ.size() - 1;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.bZZ.get(i);
        if (localv.caN == paramLong)
        {
          if (paramInt == localv.caO)
          {
            this.bZZ.remove(i);
            AppMethodBeat.o(195131);
            return localv;
          }
          gd(i);
          AppMethodBeat.o(195131);
          return null;
        }
        i -= 1;
      }
      AppMethodBeat.o(195131);
      return null;
    }
    
    private RecyclerView.v ge(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(195105);
      int k;
      if (this.bZY != null)
      {
        k = this.bZY.size();
        if (k != 0) {}
      }
      else
      {
        AppMethodBeat.o(195105);
        return null;
      }
      int i = 0;
      RecyclerView.v localv;
      while (i < k)
      {
        localv = (RecyclerView.v)this.bZY.get(i);
        if ((!localv.KM()) && (localv.KI() == paramInt))
        {
          localv.gh(32);
          AppMethodBeat.o(195105);
          return localv;
        }
        i += 1;
      }
      if (RecyclerView.this.bUp.bZF)
      {
        paramInt = RecyclerView.this.bYv.aY(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.bUp.getItemCount()))
        {
          long l = RecyclerView.this.bUp.getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localv = (RecyclerView.v)this.bZY.get(paramInt);
            if ((!localv.KM()) && (localv.caN == l))
            {
              localv.gh(32);
              AppMethodBeat.o(195105);
              return localv;
            }
            paramInt += 1;
          }
        }
      }
      AppMethodBeat.o(195105);
      return null;
    }
    
    private boolean v(RecyclerView.v paramv)
    {
      AppMethodBeat.i(195062);
      if (paramv.isRemoved())
      {
        boolean bool = RecyclerView.this.bZn.caw;
        AppMethodBeat.o(195062);
        return bool;
      }
      if ((paramv.mPosition < 0) || (paramv.mPosition >= RecyclerView.this.bUp.getItemCount()))
      {
        paramv = new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramv + RecyclerView.this.JJ());
        AppMethodBeat.o(195062);
        throw paramv;
      }
      if ((!RecyclerView.this.bZn.caw) && (RecyclerView.this.bUp.getItemViewType(paramv.mPosition) != paramv.caO))
      {
        AppMethodBeat.o(195062);
        return false;
      }
      if (RecyclerView.this.bUp.bZF)
      {
        if (paramv.caN == RecyclerView.this.bUp.getItemId(paramv.mPosition))
        {
          AppMethodBeat.o(195062);
          return true;
        }
        AppMethodBeat.o(195062);
        return false;
      }
      AppMethodBeat.o(195062);
      return true;
    }
    
    private void w(RecyclerView.v paramv)
    {
      AppMethodBeat.i(195081);
      if ((paramv.caK instanceof ViewGroup)) {
        a((ViewGroup)paramv.caK, false);
      }
      AppMethodBeat.o(195081);
    }
    
    private RecyclerView.v x(int paramInt, boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(195120);
      int k = this.bZX.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.bZX.get(i);
        if ((!((RecyclerView.v)localObject1).KM()) && (((RecyclerView.v)localObject1).KI() == paramInt) && (!((RecyclerView.v)localObject1).isInvalid()) && ((RecyclerView.this.bZn.caw) || (!((RecyclerView.v)localObject1).isRemoved())))
        {
          ((RecyclerView.v)localObject1).gh(32);
          AppMethodBeat.o(195120);
          return localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.mChildHelper;
      k = ((e)localObject2).bUB.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((e)localObject2).bUB.get(i);
        localObject3 = ((e)localObject2).bUz.bj((View)localObject1);
        if ((((RecyclerView.v)localObject3).KI() != paramInt) || (((RecyclerView.v)localObject3).isInvalid()) || (((RecyclerView.v)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.bz((View)localObject1);
          localObject3 = RecyclerView.this.mChildHelper;
          paramInt = ((e)localObject3).bUz.bh((View)localObject1);
          if (paramInt < 0)
          {
            localObject1 = new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(195120);
            throw ((Throwable)localObject1);
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((e)localObject3).bUA.cr(paramInt))
          {
            localObject1 = new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(195120);
            throw ((Throwable)localObject1);
          }
          ((e)localObject3).bUA.clear(paramInt);
          ((e)localObject3).bg((View)localObject1);
          paramInt = RecyclerView.this.mChildHelper.bh((View)localObject1);
          if (paramInt == -1)
          {
            localObject1 = new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + RecyclerView.this.JJ());
            AppMethodBeat.o(195120);
            throw ((Throwable)localObject1);
          }
          RecyclerView.this.mChildHelper.detachViewFromParent(paramInt);
          bJ((View)localObject1);
          ((RecyclerView.v)localObject2).gh(8224);
          AppMethodBeat.o(195120);
          return localObject2;
        }
      }
      k = this.bZZ.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.bZZ.get(i);
        if ((!((RecyclerView.v)localObject1).isInvalid()) && (((RecyclerView.v)localObject1).KI() == paramInt))
        {
          this.bZZ.remove(i);
          AppMethodBeat.o(195120);
          return localObject1;
        }
        i += 1;
      }
      AppMethodBeat.o(195120);
      return null;
    }
    
    private void z(RecyclerView.v paramv)
    {
      AppMethodBeat.i(195139);
      if (RecyclerView.this.bUp != null) {
        RecyclerView.this.bUp.n(paramv);
      }
      if (RecyclerView.this.bZn != null) {
        RecyclerView.this.bYw.K(paramv);
      }
      AppMethodBeat.o(195139);
    }
    
    final void KA()
    {
      AppMethodBeat.i(195158);
      if (RecyclerView.this.bYA != null) {}
      for (int i = RecyclerView.this.bYA.mPrefetchMaxCountObserved;; i = 0)
      {
        this.cac = (i + this.cab);
        i = this.bZZ.size() - 1;
        while ((i >= 0) && (this.bZZ.size() > this.cac))
        {
          gd(i);
          i -= 1;
        }
      }
      AppMethodBeat.o(195158);
    }
    
    final void Kn()
    {
      int j = 0;
      AppMethodBeat.i(195272);
      int k = this.bZZ.size();
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.bZZ.get(i)).KF();
        i += 1;
      }
      k = this.bZX.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.bZX.get(i)).KF();
        i += 1;
      }
      if (this.bZY != null)
      {
        k = this.bZY.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.v)this.bZY.get(i)).KF();
          i += 1;
        }
      }
      AppMethodBeat.o(195272);
    }
    
    final void Ko()
    {
      AppMethodBeat.i(195261);
      int j = this.bZZ.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.v localv = (RecyclerView.v)this.bZZ.get(i);
        if (localv != null)
        {
          localv.gh(6);
          localv.aT(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.bUp == null) || (!RecyclerView.this.bUp.bZF)) {
        KB();
      }
      AppMethodBeat.o(195261);
    }
    
    final void b(RecyclerView.v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(195231);
      RecyclerView.k(paramv);
      if (paramv.gg(16384))
      {
        paramv.bH(0, 16384);
        androidx.core.g.z.a(paramv.caK, null);
      }
      if (paramBoolean) {
        z(paramv);
      }
      paramv.cba = null;
      getRecycledViewPool().u(paramv);
      AppMethodBeat.o(195231);
    }
    
    public final void bH(View paramView)
    {
      AppMethodBeat.i(195211);
      RecyclerView.v localv = RecyclerView.bz(paramView);
      if (localv.KQ()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localv.KK()) {
        localv.KL();
      }
      for (;;)
      {
        x(localv);
        AppMethodBeat.o(195211);
        return;
        if (localv.KM()) {
          localv.KN();
        }
      }
    }
    
    final void bI(View paramView)
    {
      AppMethodBeat.i(195237);
      paramView = RecyclerView.bz(paramView);
      paramView.caW = null;
      paramView.caX = false;
      paramView.KN();
      x(paramView);
      AppMethodBeat.o(195237);
    }
    
    final void bJ(View paramView)
    {
      AppMethodBeat.i(195242);
      paramView = RecyclerView.bz(paramView);
      int i;
      if ((!paramView.gg(12)) && (paramView.KW()))
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.bYZ != null) && (!localRecyclerView.bYZ.a(paramView, paramView.KT()))) {
          break label126;
        }
        i = 1;
      }
      while (i != 0) {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.bUp.bZF))
        {
          paramView = new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.JJ());
          AppMethodBeat.o(195242);
          throw paramView;
          label126:
          i = 0;
        }
        else
        {
          paramView.a(this, false);
          this.bZX.add(paramView);
          AppMethodBeat.o(195242);
          return;
        }
      }
      if (this.bZY == null) {
        this.bZY = new ArrayList();
      }
      paramView.a(this, true);
      this.bZY.add(paramView);
      AppMethodBeat.o(195242);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(195149);
      this.bZX.clear();
      KB();
      AppMethodBeat.o(195149);
    }
    
    final RecyclerView.v e(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      AppMethodBeat.i(195203);
      Object localObject1;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.bZn.getItemCount()))
      {
        localObject1 = new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.bZn.getItemCount() + RecyclerView.this.JJ());
        AppMethodBeat.o(195203);
        throw ((Throwable)localObject1);
      }
      int i;
      if (RecyclerView.this.bZn.caw)
      {
        localObject1 = ge(paramInt);
        if (localObject1 != null) {
          i = 1;
        }
      }
      for (int j = i;; j = 0)
      {
        Object localObject2;
        if (localObject1 == null)
        {
          localObject2 = x(paramInt, false);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null)
          {
            if (v((RecyclerView.v)localObject2)) {
              break label348;
            }
            ((RecyclerView.v)localObject2).gh(4);
            if (!((RecyclerView.v)localObject2).KK()) {
              break label332;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.v)localObject2).caK, false);
            ((RecyclerView.v)localObject2).KL();
            label200:
            x((RecyclerView.v)localObject2);
            localObject1 = null;
            i = j;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int k = RecyclerView.this.bYv.fz(paramInt);
            if ((k < 0) || (k >= RecyclerView.this.bUp.getItemCount()))
            {
              localObject1 = new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.bZn.getItemCount() + RecyclerView.this.JJ());
              AppMethodBeat.o(195203);
              throw ((Throwable)localObject1);
              i = 0;
              break;
              label332:
              if (!((RecyclerView.v)localObject2).KM()) {
                break label200;
              }
              ((RecyclerView.v)localObject2).KN();
              break label200;
              label348:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.this.bUp.getItemViewType(k);
            if (RecyclerView.this.bUp.bZF)
            {
              localObject2 = b(RecyclerView.this.bUp.getItemId(k), j, false);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.v)localObject2).mPosition = k;
                i = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (this.cae != null)
                  {
                    View localView = this.cae.KD();
                    localObject1 = localObject2;
                    if (localView != null)
                    {
                      localObject2 = RecyclerView.this.bj(localView);
                      if (localObject2 == null)
                      {
                        localObject1 = new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.JJ());
                        AppMethodBeat.o(195203);
                        throw ((Throwable)localObject1);
                      }
                      localObject1 = localObject2;
                      if (((RecyclerView.v)localObject2).KH())
                      {
                        localObject1 = new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.JJ());
                        AppMethodBeat.o(195203);
                        throw ((Throwable)localObject1);
                      }
                    }
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  localObject1 = getRecycledViewPool().fY(j);
                  localObject2 = localObject1;
                  if (localObject1 != null)
                  {
                    ((RecyclerView.v)localObject1).resetInternal();
                    localObject2 = localObject1;
                    if (RecyclerView.bYl)
                    {
                      w((RecyclerView.v)localObject1);
                      localObject2 = localObject1;
                    }
                  }
                }
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  long l1 = RecyclerView.this.getNanoTime();
                  if ((paramLong != 9223372036854775807L) && (!this.cad.b(j, l1, paramLong)))
                  {
                    AppMethodBeat.o(195203);
                    return null;
                  }
                  localObject1 = RecyclerView.this.bUp.c(RecyclerView.this, j);
                  if (RecyclerView.bYo)
                  {
                    localObject2 = RecyclerView.bD(((RecyclerView.v)localObject1).caK);
                    if (localObject2 != null) {
                      ((RecyclerView.v)localObject1).caL = new WeakReference(localObject2);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.cad.d(j, l2 - l1);
                }
              }
            }
          }
          for (localObject2 = localObject1;; localObject2 = localObject1)
          {
            if ((i != 0) && (!RecyclerView.this.bZn.caw) && (((RecyclerView.v)localObject2).gg(8192)))
            {
              ((RecyclerView.v)localObject2).bH(0, 8192);
              if (RecyclerView.this.bZn.caz)
              {
                j = RecyclerView.f.q((RecyclerView.v)localObject2);
                localObject1 = RecyclerView.this.bYZ.a(RecyclerView.this.bZn, (RecyclerView.v)localObject2, j | 0x1000, ((RecyclerView.v)localObject2).KT());
                RecyclerView.this.a((RecyclerView.v)localObject2, (RecyclerView.f.c)localObject1);
              }
            }
            boolean bool1;
            if ((RecyclerView.this.bZn.caw) && (((RecyclerView.v)localObject2).isBound()))
            {
              ((RecyclerView.v)localObject2).caP = paramInt;
              bool1 = false;
            }
            for (;;)
            {
              localObject1 = ((RecyclerView.v)localObject2).caK.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                ((RecyclerView.v)localObject2).caK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label924:
                ((RecyclerView.LayoutParams)localObject1).bXh = ((RecyclerView.v)localObject2);
                if ((i == 0) || (!bool1)) {
                  break label1058;
                }
              }
              label1058:
              for (bool1 = bool2;; bool1 = false)
              {
                ((RecyclerView.LayoutParams)localObject1).bZQ = bool1;
                AppMethodBeat.o(195203);
                return localObject2;
                if ((((RecyclerView.v)localObject2).isBound()) && (!((RecyclerView.v)localObject2).KP()) && (!((RecyclerView.v)localObject2).isInvalid())) {
                  break label1064;
                }
                bool1 = a((RecyclerView.v)localObject2, RecyclerView.this.bYv.fz(paramInt), paramInt, paramLong);
                break;
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((RecyclerView.v)localObject2).caK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  break label924;
                }
                localObject1 = (RecyclerView.LayoutParams)localObject1;
                break label924;
              }
              label1064:
              bool1 = false;
            }
            localObject2 = localObject1;
            break;
          }
          i = j;
        }
        localObject1 = null;
      }
    }
    
    public final int ga(int paramInt)
    {
      AppMethodBeat.i(195167);
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.bZn.getItemCount()))
      {
        IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.bZn.getItemCount() + RecyclerView.this.JJ());
        AppMethodBeat.o(195167);
        throw localIndexOutOfBoundsException;
      }
      if (!RecyclerView.this.bZn.caw)
      {
        AppMethodBeat.o(195167);
        return paramInt;
      }
      paramInt = RecyclerView.this.bYv.fz(paramInt);
      AppMethodBeat.o(195167);
      return paramInt;
    }
    
    public final View gb(int paramInt)
    {
      AppMethodBeat.i(369498);
      View localView = gc(paramInt);
      AppMethodBeat.o(369498);
      return localView;
    }
    
    final View gc(int paramInt)
    {
      AppMethodBeat.i(195181);
      View localView = e(paramInt, 9223372036854775807L).caK;
      AppMethodBeat.o(195181);
      return localView;
    }
    
    final void gd(int paramInt)
    {
      AppMethodBeat.i(195218);
      b((RecyclerView.v)this.bZZ.get(paramInt), true);
      this.bZZ.remove(paramInt);
      AppMethodBeat.o(195218);
    }
    
    final RecyclerView.m getRecycledViewPool()
    {
      AppMethodBeat.i(195256);
      if (this.cad == null) {
        this.cad = new RecyclerView.m();
      }
      RecyclerView.m localm = this.cad;
      AppMethodBeat.o(195256);
      return localm;
    }
    
    final void x(RecyclerView.v paramv)
    {
      int k = 1;
      AppMethodBeat.i(195226);
      if ((paramv.KK()) || (paramv.caK.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramv.KK()).append(" isAttached:");
        if (paramv.caK.getParent() != null) {}
        for (bool = true;; bool = false)
        {
          paramv = new IllegalArgumentException(bool + RecyclerView.this.JJ());
          AppMethodBeat.o(195226);
          throw paramv;
        }
      }
      if (paramv.KQ())
      {
        paramv = new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv + RecyclerView.this.JJ());
        AppMethodBeat.o(195226);
        throw paramv;
      }
      if (paramv.KH())
      {
        paramv = new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.JJ());
        AppMethodBeat.o(195226);
        throw paramv;
      }
      boolean bool = paramv.KV();
      int i;
      if ((RecyclerView.this.bUp != null) && (bool) && (RecyclerView.a.Ks())) {
        i = 1;
      }
      int j;
      for (;;)
      {
        if ((i != 0) || (paramv.KU())) {
          if ((this.cac > 0) && (!paramv.gg(526)))
          {
            j = this.bZZ.size();
            i = j;
            if (j >= this.cac)
            {
              i = j;
              if (j > 0)
              {
                gd(0);
                i = j - 1;
              }
            }
            j = i;
            if (RecyclerView.bYo)
            {
              j = i;
              if (i > 0)
              {
                j = i;
                if (!RecyclerView.this.bZm.fG(paramv.mPosition))
                {
                  i -= 1;
                  for (;;)
                  {
                    if (i >= 0)
                    {
                      j = ((RecyclerView.v)this.bZZ.get(i)).mPosition;
                      if (RecyclerView.this.bZm.fG(j))
                      {
                        i -= 1;
                        continue;
                        i = 0;
                        break;
                      }
                    }
                  }
                  j = i + 1;
                }
              }
            }
            this.bZZ.add(j, paramv);
            i = 1;
            if (i == 0)
            {
              b(paramv, true);
              j = k;
            }
          }
        }
      }
      for (;;)
      {
        RecyclerView.this.bYw.K(paramv);
        if ((i == 0) && (j == 0) && (bool)) {
          paramv.cba = null;
        }
        AppMethodBeat.o(195226);
        return;
        j = 0;
        continue;
        i = 0;
        break;
        j = 0;
        i = 0;
      }
    }
    
    final void y(RecyclerView.v paramv)
    {
      AppMethodBeat.i(195250);
      if (paramv.caX) {
        this.bZY.remove(paramv);
      }
      for (;;)
      {
        paramv.caW = null;
        paramv.caX = false;
        paramv.KN();
        AppMethodBeat.o(195250);
        return;
        this.bZX.remove(paramv);
      }
    }
  }
  
  public static abstract interface o {}
  
  final class p
    extends RecyclerView.c
  {
    p() {}
    
    private void KC()
    {
      AppMethodBeat.i(195059);
      if ((RecyclerView.bYn) && (RecyclerView.this.bYF) && (RecyclerView.this.bIj))
      {
        androidx.core.g.z.b(RecyclerView.this, RecyclerView.this.bYy);
        AppMethodBeat.o(195059);
        return;
      }
      RecyclerView.this.bYN = true;
      RecyclerView.this.requestLayout();
      AppMethodBeat.o(195059);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(195070);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView.this.bZn.cav = true;
      RecyclerView.this.be(true);
      if (!RecyclerView.this.bYv.IP()) {
        RecyclerView.this.requestLayout();
      }
      AppMethodBeat.o(195070);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      AppMethodBeat.i(195083);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      a locala = RecyclerView.this.bYv;
      if (paramInt2 > 0)
      {
        locala.bUe.add(locala.a(4, paramInt1, paramInt2, paramObject));
        locala.bUk |= 0x4;
        if (locala.bUe.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          KC();
        }
        AppMethodBeat.o(195083);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = 1;
      AppMethodBeat.i(195091);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      a locala = RecyclerView.this.bYv;
      if (paramInt2 > 0)
      {
        locala.bUe.add(locala.a(1, paramInt1, paramInt2, null));
        locala.bUk |= 0x1;
        if (locala.bUe.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          KC();
        }
        AppMethodBeat.o(195091);
        return;
      }
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      AppMethodBeat.i(195117);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      Object localObject = RecyclerView.this.bYv;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1)
        {
          localObject = new IllegalArgumentException("Moving more than 1 item is not supported yet");
          AppMethodBeat.o(195117);
          throw ((Throwable)localObject);
        }
        ((a)localObject).bUe.add(((a)localObject).a(8, paramInt1, paramInt2, null));
        ((a)localObject).bUk |= 0x8;
        if (((a)localObject).bUe.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          KC();
        }
        AppMethodBeat.o(195117);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = 1;
      AppMethodBeat.i(195103);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      a locala = RecyclerView.this.bYv;
      if (paramInt2 > 0)
      {
        locala.bUe.add(locala.a(2, paramInt1, paramInt2, null));
        locala.bUk |= 0x2;
        if (locala.bUe.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          KC();
        }
        AppMethodBeat.o(195103);
        return;
      }
    }
  }
  
  public static abstract class r
  {
    private RecyclerView.LayoutManager bYg;
    public boolean bzr;
    public int cag = -1;
    boolean cah;
    View cai;
    private final a caj = new a();
    private RecyclerView mRecyclerView;
    private boolean mStarted;
    
    protected abstract void a(int paramInt1, int paramInt2, a parama);
    
    protected abstract void a(View paramView, RecyclerView.s params, a parama);
    
    final void a(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
    {
      if (this.mStarted) {
        new StringBuilder("An instance of ").append(getClass().getSimpleName()).append(" was started more than once. Each instance of").append(getClass().getSimpleName()).append(" is intended to only be used once. You should create a new instance for each use.");
      }
      this.mRecyclerView = paramRecyclerView;
      this.bYg = paramLayoutManager;
      if (this.cag == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      this.mRecyclerView.bZn.cag = this.cag;
      this.bzr = true;
      this.cah = true;
      int i = this.cag;
      this.cai = this.mRecyclerView.bYA.findViewByPosition(i);
      onStart();
      this.mRecyclerView.bZk.KE();
      this.mStarted = true;
    }
    
    final void bE(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((!this.bzr) || (this.cag == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.cah) && (this.cai == null) && (this.bYg != null))
      {
        PointF localPointF = fM(this.cag);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.d((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.cah = false;
      if (this.cai != null)
      {
        if (RecyclerView.bB(this.cai) != this.cag) {
          break label233;
        }
        a(this.cai, localRecyclerView.bZn, this.caj);
        this.caj.g(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.bzr)
        {
          a(paramInt1, paramInt2, this.caj);
          paramInt1 = i;
          if (this.caj.can >= 0) {
            paramInt1 = 1;
          }
          this.caj.g(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.bzr) {
              break;
            }
            this.cah = true;
            localRecyclerView.bZk.KE();
          }
        }
        return;
        label233:
        this.cai = null;
      }
      stop();
    }
    
    public PointF fM(int paramInt)
    {
      RecyclerView.LayoutManager localLayoutManager = this.bYg;
      if ((localLayoutManager instanceof RecyclerView.r.b)) {
        return ((RecyclerView.r.b)localLayoutManager).fM(paramInt);
      }
      new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(RecyclerView.r.b.class.getCanonicalName());
      return null;
    }
    
    public final int getChildCount()
    {
      return this.mRecyclerView.bYA.getChildCount();
    }
    
    public final RecyclerView.LayoutManager getLayoutManager()
    {
      return this.bYg;
    }
    
    protected abstract void onStart();
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.bzr) {
        return;
      }
      this.bzr = false;
      onStop();
      this.mRecyclerView.bZn.cag = -1;
      this.cai = null;
      this.cag = -1;
      this.cah = false;
      this.bYg.onSmoothScrollerStopped(this);
      this.bYg = null;
      this.mRecyclerView = null;
    }
    
    public static final class a
    {
      private int cak = 0;
      private int cal = 0;
      private int cam = -2147483648;
      int can = -1;
      private boolean cao = false;
      private int cap = 0;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this((byte)0);
      }
      
      private a(byte paramByte) {}
      
      private void Dl()
      {
        AppMethodBeat.i(195254);
        IllegalStateException localIllegalStateException;
        if ((this.mInterpolator != null) && (this.cam <= 0))
        {
          localIllegalStateException = new IllegalStateException("If you provide an interpolator, you must set a positive duration");
          AppMethodBeat.o(195254);
          throw localIllegalStateException;
        }
        if (this.cam <= 0)
        {
          localIllegalStateException = new IllegalStateException("Scroll duration must be a positive number");
          AppMethodBeat.o(195254);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(195254);
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.cak = paramInt1;
        this.cal = paramInt2;
        this.cam = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.cao = true;
      }
      
      final void g(RecyclerView paramRecyclerView)
      {
        AppMethodBeat.i(195263);
        if (this.can >= 0)
        {
          int i = this.can;
          this.can = -1;
          paramRecyclerView.fS(i);
          this.cao = false;
          AppMethodBeat.o(195263);
          return;
        }
        if (this.cao)
        {
          Dl();
          if (this.mInterpolator == null) {
            if (this.cam == -2147483648) {
              paramRecyclerView.bZk.bF(this.cak, this.cal);
            }
          }
          for (;;)
          {
            this.cap += 1;
            this.cao = false;
            AppMethodBeat.o(195263);
            return;
            paramRecyclerView.bZk.x(this.cak, this.cal, this.cam);
            continue;
            paramRecyclerView.bZk.b(this.cak, this.cal, this.cam, this.mInterpolator);
          }
        }
        this.cap = 0;
        AppMethodBeat.o(195263);
      }
    }
  }
  
  public static class s
  {
    public boolean caA = false;
    int caB;
    long caC;
    int caD;
    int caE;
    int caF;
    int cag = -1;
    private SparseArray<Object> caq;
    int car = 0;
    int cas = 0;
    int cat = 1;
    int cau = 0;
    boolean cav = false;
    public boolean caw = false;
    boolean cax = false;
    public boolean cay = false;
    boolean caz = false;
    
    public final int getItemCount()
    {
      if (this.caw) {
        return this.car - this.cas;
      }
      return this.cau;
    }
    
    final void gf(int paramInt)
    {
      AppMethodBeat.i(195050);
      if ((this.cat & paramInt) == 0)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.cat));
        AppMethodBeat.o(195050);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(195050);
    }
    
    public String toString()
    {
      AppMethodBeat.i(195068);
      String str = "State{mTargetPosition=" + this.cag + ", mData=" + this.caq + ", mItemCount=" + this.cau + ", mIsMeasuring=" + this.cay + ", mPreviousLayoutItemCount=" + this.car + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.cas + ", mStructureChanged=" + this.cav + ", mInPreLayout=" + this.caw + ", mRunSimpleAnimations=" + this.caz + ", mRunPredictiveAnimations=" + this.caA + '}';
      AppMethodBeat.o(195068);
      return str;
    }
  }
  
  public static abstract class t
  {
    public abstract View KD();
  }
  
  final class u
    implements Runnable
  {
    OverScroller bwz;
    int caG;
    int caH;
    private boolean caI;
    private boolean caJ;
    Interpolator mInterpolator;
    
    u()
    {
      AppMethodBeat.i(195054);
      this.mInterpolator = RecyclerView.bZB;
      this.caI = false;
      this.caJ = false;
      this.bwz = new OverScroller(RecyclerView.this.getContext(), RecyclerView.bZB);
      AppMethodBeat.o(195054);
    }
    
    private static float distanceInfluenceForSnapDuration(float paramFloat)
    {
      AppMethodBeat.i(195063);
      paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
      AppMethodBeat.o(195063);
      return paramFloat;
    }
    
    final void KE()
    {
      AppMethodBeat.i(195097);
      if (this.caI)
      {
        this.caJ = true;
        AppMethodBeat.o(195097);
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      androidx.core.g.z.b(RecyclerView.this, this);
      AppMethodBeat.o(195097);
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      AppMethodBeat.i(195147);
      if (this.mInterpolator != paramInterpolator)
      {
        this.mInterpolator = paramInterpolator;
        this.bwz = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.caH = 0;
      this.caG = 0;
      this.bwz.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.bwz.computeScrollOffset();
      }
      KE();
      AppMethodBeat.o(195147);
    }
    
    final void bF(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195106);
      x(paramInt1, paramInt2, bG(paramInt1, paramInt2));
      AppMethodBeat.o(195106);
    }
    
    final int bG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195123);
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
          break label143;
        }
      }
      label143:
      for (paramInt1 = RecyclerView.this.getWidth();; paramInt1 = RecyclerView.this.getHeight())
      {
        int n = paramInt1 / 2;
        float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
        float f1 = n;
        float f2 = n;
        f3 = distanceInfluenceForSnapDuration(f3);
        if (m <= 0) {
          break label154;
        }
        paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / m)) * 4;
        paramInt1 = Math.min(paramInt1, 2000);
        AppMethodBeat.o(195123);
        return paramInt1;
        i = 0;
        break;
      }
      label154:
      if (i != 0) {}
      for (paramInt2 = j;; paramInt2 = k)
      {
        paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
        break;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(195088);
      if (RecyclerView.this.bYA == null)
      {
        stop();
        AppMethodBeat.o(195088);
        return;
      }
      this.caJ = false;
      this.caI = true;
      RecyclerView.this.JM();
      OverScroller localOverScroller = this.bwz;
      RecyclerView.r localr = RecyclerView.this.bYA.mSmoothScroller;
      int i6;
      int i7;
      int k;
      int j;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.bwJ;
        i6 = localOverScroller.getCurrX();
        i7 = localOverScroller.getCurrY();
        k = i6 - this.caG;
        j = i7 - this.caH;
        this.caG = i6;
        this.caH = i7;
        if (!RecyclerView.this.a(k, j, arrayOfInt, null, 1)) {
          break label864;
        }
        i = arrayOfInt[0];
        j -= arrayOfInt[1];
        k -= i;
      }
      label406:
      label425:
      label579:
      label598:
      label864:
      for (;;)
      {
        int i3;
        int i4;
        int i5;
        int m;
        int n;
        int i1;
        int i2;
        if (RecyclerView.this.bUp != null)
        {
          RecyclerView.this.d(k, j, RecyclerView.this.bZy);
          i = RecyclerView.this.bZy[0];
          i3 = RecyclerView.this.bZy[1];
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
            if (!localr.cah)
            {
              m = i;
              n = i3;
              i1 = i4;
              i2 = i5;
              if (localr.bzr)
              {
                m = RecyclerView.this.bZn.getItemCount();
                if (m != 0) {
                  break label710;
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
          if (!RecyclerView.this.bYC.isEmpty()) {
            RecyclerView.this.invalidate();
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.bt(k, j);
          }
          if ((!RecyclerView.this.a(m, n, i1, i2, null, 1)) && ((i1 != 0) || (i2 != 0)))
          {
            i3 = (int)localOverScroller.getCurrVelocity();
            if (i1 == i6) {
              break label843;
            }
            if (i1 >= 0) {
              break label760;
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
                RecyclerView.this.bu(i4, i);
              }
              if (((i4 != 0) || (i1 == i6) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (i2 == i7) || (localOverScroller.getFinalY() == 0))) {
                localOverScroller.abortAnimation();
              }
              if ((m != 0) || (n != 0)) {
                RecyclerView.this.bx(m, n);
              }
              if (!RecyclerView.c(RecyclerView.this)) {
                RecyclerView.this.invalidate();
              }
              if ((j != 0) && (RecyclerView.this.bYA.canScrollVertically()) && (n == j))
              {
                i = 1;
                if ((k == 0) || (!RecyclerView.this.bYA.canScrollHorizontally()) || (m != k)) {
                  break label794;
                }
                m = 1;
                if (((k != 0) || (j != 0)) && (m == 0) && (i == 0)) {
                  break label800;
                }
                i = 1;
                if ((!localOverScroller.isFinished()) && ((i != 0) || (RecyclerView.this.getScrollingChildHelper().en(1)))) {
                  break label805;
                }
                RecyclerView.this.setScrollState(0);
                if (RecyclerView.bYo) {
                  RecyclerView.this.bZm.Jc();
                }
                RecyclerView.this.em(1);
              }
              for (;;)
              {
                if (localr != null)
                {
                  if (localr.cah) {
                    localr.bE(0, 0);
                  }
                  if (!this.caJ) {
                    localr.stop();
                  }
                }
                this.caI = false;
                if (this.caJ) {
                  KE();
                }
                AppMethodBeat.o(195088);
                return;
                if (localr.cag >= m) {
                  localr.cag = (m - 1);
                }
                localr.bE(k - i4, j - i5);
                m = i;
                n = i3;
                i1 = i4;
                i2 = i5;
                break;
                label760:
                if (i1 > 0)
                {
                  i = i3;
                  break label406;
                }
                i = 0;
                break label406;
                i = i3;
                if (i2 > 0) {
                  break label425;
                }
                i = 0;
                break label425;
                i = 0;
                break label553;
                m = 0;
                break label579;
                i = 0;
                break label598;
                KE();
                if (RecyclerView.this.bZl != null) {
                  RecyclerView.this.bZl.a(RecyclerView.this, k, j);
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
      AppMethodBeat.i(195156);
      RecyclerView.this.removeCallbacks(this);
      this.bwz.abortAnimation();
      AppMethodBeat.o(195156);
    }
    
    public final void x(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195133);
      b(paramInt1, paramInt2, paramInt3, RecyclerView.bZB);
      AppMethodBeat.o(195133);
    }
  }
  
  public static abstract class v
  {
    private static final List<Object> caS = ;
    int cN;
    public final View caK;
    WeakReference<RecyclerView> caL;
    public int caM = -1;
    public long caN = -1L;
    public int caO = -1;
    int caP = -1;
    v caQ = null;
    v caR = null;
    List<Object> caT = null;
    List<Object> caU = null;
    private int caV = 0;
    RecyclerView.n caW = null;
    boolean caX = false;
    int caY = 0;
    int caZ = -1;
    RecyclerView cba;
    int mPosition = -1;
    
    public v(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.caK = paramView;
    }
    
    private void KR()
    {
      if (this.caT == null)
      {
        this.caT = new ArrayList();
        this.caU = Collections.unmodifiableList(this.caT);
      }
    }
    
    final void KF()
    {
      this.caM = -1;
      this.caP = -1;
    }
    
    final void KG()
    {
      if (this.caM == -1) {
        this.caM = this.mPosition;
      }
    }
    
    final boolean KH()
    {
      return (this.cN & 0x80) != 0;
    }
    
    public final int KI()
    {
      if (this.caP == -1) {
        return this.mPosition;
      }
      return this.caP;
    }
    
    public final int KJ()
    {
      if (this.cba == null) {
        return -1;
      }
      return this.cba.l(this);
    }
    
    final boolean KK()
    {
      return this.caW != null;
    }
    
    final void KL()
    {
      this.caW.y(this);
    }
    
    final boolean KM()
    {
      return (this.cN & 0x20) != 0;
    }
    
    final void KN()
    {
      this.cN &= 0xFFFFFFDF;
    }
    
    final void KO()
    {
      this.cN &= 0xFFFFFEFF;
    }
    
    final boolean KP()
    {
      return (this.cN & 0x2) != 0;
    }
    
    final boolean KQ()
    {
      return (this.cN & 0x100) != 0;
    }
    
    final void KS()
    {
      if (this.caT != null) {
        this.caT.clear();
      }
      this.cN &= 0xFFFFFBFF;
    }
    
    final List<Object> KT()
    {
      if ((this.cN & 0x400) == 0)
      {
        if ((this.caT == null) || (this.caT.size() == 0)) {
          return caS;
        }
        return this.caU;
      }
      return caS;
    }
    
    public final boolean KU()
    {
      return ((this.cN & 0x10) == 0) && (!androidx.core.g.z.P(this.caK));
    }
    
    final boolean KV()
    {
      return ((this.cN & 0x10) == 0) && (androidx.core.g.z.P(this.caK));
    }
    
    final boolean KW()
    {
      return (this.cN & 0x2) != 0;
    }
    
    final void a(RecyclerView.n paramn, boolean paramBoolean)
    {
      this.caW = paramn;
      this.caX = paramBoolean;
    }
    
    final void aT(Object paramObject)
    {
      if (paramObject == null) {
        gh(1024);
      }
      while ((this.cN & 0x400) != 0) {
        return;
      }
      KR();
      this.caT.add(paramObject);
    }
    
    final void bH(int paramInt1, int paramInt2)
    {
      this.cN = (this.cN & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public final void bg(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.caV - 1;
        this.caV = i;
        if (this.caV >= 0) {
          break label53;
        }
        this.caV = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.caV + 1;
        break;
        if ((!paramBoolean) && (this.caV == 1))
        {
          this.cN |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.caV != 0));
      this.cN &= 0xFFFFFFEF;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.caP == -1) {
        return this.mPosition;
      }
      return this.caP;
    }
    
    final boolean gg(int paramInt)
    {
      return (this.cN & paramInt) != 0;
    }
    
    final void gh(int paramInt)
    {
      this.cN |= paramInt;
    }
    
    final boolean isBound()
    {
      return (this.cN & 0x1) != 0;
    }
    
    final boolean isInvalid()
    {
      return (this.cN & 0x4) != 0;
    }
    
    public final boolean isRemoved()
    {
      return (this.cN & 0x8) != 0;
    }
    
    final void resetInternal()
    {
      this.cN = 0;
      this.mPosition = -1;
      this.caM = -1;
      this.caN = -1L;
      this.caP = -1;
      this.caV = 0;
      this.caQ = null;
      this.caR = null;
      KS();
      this.caY = 0;
      this.caZ = -1;
      RecyclerView.k(this);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.caN + ", oldPos=" + this.caM + ", pLpos:" + this.caP);
      String str;
      if (KK())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.caX)
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
        if (KP()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (KH()) {
          localStringBuilder1.append(" ignored");
        }
        if (KQ()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!KU()) {
          localStringBuilder1.append(" not recyclable(" + this.caV + ")");
        }
        if (((this.cN & 0x200) == 0) && (!isInvalid())) {
          break label301;
        }
      }
      label301:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.caK.getParent() == null) {
          localStringBuilder1.append(" no parent");
        }
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
        str = "[attachedScrap]";
        break;
      }
    }
    
    final void y(int paramInt, boolean paramBoolean)
    {
      if (this.caM == -1) {
        this.caM = this.mPosition;
      }
      if (this.caP == -1) {
        this.caP = this.mPosition;
      }
      if (paramBoolean) {
        this.caP += paramInt;
      }
      this.mPosition += paramInt;
      if (this.caK.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.caK.getLayoutParams()).bZP = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */