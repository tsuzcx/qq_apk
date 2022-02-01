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
import android.os.Parcelable;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.g.a.b;
import androidx.core.g.a.d.b;
import androidx.core.g.a.d.c;
import androidx.core.g.l;
import androidx.core.g.n;
import androidx.core.g.x;
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
  implements l
{
  private static final int[] ajG;
  private static final int[] ajH;
  static final boolean ajI;
  static final boolean ajJ;
  static final boolean ajK;
  static final boolean ajL;
  private static final boolean ajM;
  private static final boolean ajN;
  private static final Class<?>[] ajO;
  static final Interpolator akZ;
  private final int[] Qr;
  final int[] Qs;
  RecyclerView.a afJ;
  private d aij;
  private final p ajP;
  final n ajQ;
  private RecyclerView.SavedState ajR;
  a ajS;
  final ab ajT;
  boolean ajU;
  final Runnable ajV;
  final RectF ajW;
  LayoutManager ajX;
  o ajY;
  final ArrayList<RecyclerView.h> ajZ;
  private int akA;
  private int akB;
  private int akC;
  private RecyclerView.j akD;
  private final int akE;
  private float akF;
  private float akG;
  private boolean akH;
  final u akI;
  k akJ;
  k.a akK;
  final s akL;
  private RecyclerView.l akM;
  private List<RecyclerView.l> akN;
  boolean akO;
  boolean akP;
  private RecyclerView.f.b akQ;
  boolean akR;
  w akS;
  private final int[] akT;
  private n akU;
  private final int[] akV;
  final int[] akW;
  final List<v> akX;
  private Runnable akY;
  private final ArrayList<k> aka;
  private k akb;
  boolean akc;
  boolean akd;
  boolean ake;
  boolean akf;
  private int akg;
  boolean akh;
  public boolean aki;
  private boolean akj;
  private int akk;
  boolean akl;
  private final AccessibilityManager akm;
  List<i> akn;
  boolean ako;
  boolean akp;
  private int akq;
  private int akr;
  private RecyclerView.e aks;
  private EdgeEffect akt;
  private EdgeEffect aku;
  private EdgeEffect akv;
  private EdgeEffect akw;
  f akx;
  private int aky;
  private int akz;
  private final ab.b ala;
  private final Rect gD;
  f mChildHelper;
  private int mScrollState;
  final Rect mTempRect;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private final int vZ;
  
  static
  {
    AppMethodBeat.i(262758);
    ajG = new int[] { 16843830 };
    ajH = new int[] { 16842987 };
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      ajI = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label179;
      }
      bool = true;
      label67:
      ajJ = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label184;
      }
      bool = true;
      label81:
      ajK = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label189;
      }
      bool = true;
      label95:
      ajL = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label194;
      }
      bool = true;
      label109:
      ajM = bool;
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
      ajN = bool;
      ajO = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      akZ = new Interpolator()
      {
        public final float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
      AppMethodBeat.o(262758);
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
    AppMethodBeat.i(262474);
    this.ajP = new p();
    this.ajQ = new n();
    this.ajT = new ab();
    this.ajV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261991);
        if ((!RecyclerView.this.akf) || (RecyclerView.this.isLayoutRequested()))
        {
          AppMethodBeat.o(261991);
          return;
        }
        if (!RecyclerView.this.akc)
        {
          RecyclerView.this.requestLayout();
          AppMethodBeat.o(261991);
          return;
        }
        if (RecyclerView.this.aki)
        {
          RecyclerView.this.akh = true;
          AppMethodBeat.o(261991);
          return;
        }
        RecyclerView.this.lb();
        AppMethodBeat.o(261991);
      }
    };
    this.mTempRect = new Rect();
    this.gD = new Rect();
    this.ajW = new RectF();
    this.ajZ = new ArrayList();
    this.aka = new ArrayList();
    this.akg = 0;
    this.ako = false;
    this.akp = false;
    this.akq = 0;
    this.akr = 0;
    this.aks = new RecyclerView.e();
    this.akx = new g();
    this.mScrollState = 0;
    this.aky = -1;
    this.akF = 1.4E-45F;
    this.akG = 1.4E-45F;
    this.akH = true;
    this.akI = new u();
    Object localObject1;
    if (ajL)
    {
      localObject1 = new k.a();
      this.akK = ((k.a)localObject1);
      this.akL = new s();
      this.akO = false;
      this.akP = false;
      this.akQ = new g();
      this.akR = false;
      this.akT = new int[2];
      this.Qr = new int[2];
      this.Qs = new int[2];
      this.akV = new int[2];
      this.akW = new int[2];
      this.akX = new ArrayList();
      this.akY = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(261998);
          if (RecyclerView.this.akx != null) {
            RecyclerView.this.akx.kl();
          }
          RecyclerView.this.akR = false;
          AppMethodBeat.o(261998);
        }
      };
      this.ala = new ab.b()
      {
        public final void a(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          AppMethodBeat.i(262016);
          RecyclerView.this.ajQ.x(paramAnonymousv);
          RecyclerView localRecyclerView = RecyclerView.this;
          localRecyclerView.h(paramAnonymousv);
          paramAnonymousv.ax(false);
          if (localRecyclerView.akx.d(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.lr();
          }
          AppMethodBeat.o(262016);
        }
        
        public final void b(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          AppMethodBeat.i(262019);
          RecyclerView localRecyclerView = RecyclerView.this;
          paramAnonymousv.ax(false);
          if (localRecyclerView.akx.e(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            localRecyclerView.lr();
          }
          AppMethodBeat.o(262019);
        }
        
        public final void c(RecyclerView.v paramAnonymousv, RecyclerView.f.c paramAnonymousc1, RecyclerView.f.c paramAnonymousc2)
        {
          AppMethodBeat.i(262023);
          paramAnonymousv.ax(false);
          if (RecyclerView.this.ako)
          {
            if (RecyclerView.this.akx.a(paramAnonymousv, paramAnonymousv, paramAnonymousc1, paramAnonymousc2))
            {
              RecyclerView.this.lr();
              AppMethodBeat.o(262023);
            }
          }
          else if (RecyclerView.this.akx.f(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
            RecyclerView.this.lr();
          }
          AppMethodBeat.o(262023);
        }
        
        public final void l(RecyclerView.v paramAnonymousv)
        {
          AppMethodBeat.i(262024);
          RecyclerView.this.ajX.removeAndRecycleView(paramAnonymousv.amk, RecyclerView.this.ajQ);
          AppMethodBeat.o(262024);
        }
      };
      if (paramAttributeSet == null) {
        break label719;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, ajH, paramInt, 0);
      this.ajU = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
      label364:
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject1 = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
      this.akF = x.a((ViewConfiguration)localObject1, paramContext);
      this.akG = x.b((ViewConfiguration)localObject1, paramContext);
      this.vZ = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
      this.akE = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
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
      this.akx.ale = this.akQ;
      this.ajS = new a(new a.a()
      {
        private void f(a.b paramAnonymousb)
        {
          AppMethodBeat.i(262068);
          switch (paramAnonymousb.Vh)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(262068);
            return;
            RecyclerView.this.ajX.onItemsAdded(RecyclerView.this, paramAnonymousb.afG, paramAnonymousb.afI);
            AppMethodBeat.o(262068);
            return;
            RecyclerView.this.ajX.onItemsRemoved(RecyclerView.this, paramAnonymousb.afG, paramAnonymousb.afI);
            AppMethodBeat.o(262068);
            return;
            RecyclerView.this.ajX.onItemsUpdated(RecyclerView.this, paramAnonymousb.afG, paramAnonymousb.afI, paramAnonymousb.afH);
            AppMethodBeat.o(262068);
            return;
            RecyclerView.this.ajX.onItemsMoved(RecyclerView.this, paramAnonymousb.afG, paramAnonymousb.afI, 1);
          }
        }
        
        public final void ag(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(262058);
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, true);
          RecyclerView.this.akO = true;
          RecyclerView.s locals = RecyclerView.this.akL;
          locals.alS += paramAnonymousInt2;
          AppMethodBeat.o(262058);
        }
        
        public final void ah(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(262060);
          RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2, false);
          RecyclerView.this.akO = true;
          AppMethodBeat.o(262060);
        }
        
        public final void ai(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(262076);
          RecyclerView localRecyclerView = RecyclerView.this;
          int j = localRecyclerView.mChildHelper.kj();
          int i = 0;
          while (i < j)
          {
            localObject = RecyclerView.bg(localRecyclerView.mChildHelper.cq(i));
            if ((localObject != null) && (!((RecyclerView.v)localObject).mb()) && (((RecyclerView.v)localObject).mPosition >= paramAnonymousInt1))
            {
              ((RecyclerView.v)localObject).k(paramAnonymousInt2, false);
              localRecyclerView.akL.alV = true;
            }
            i += 1;
          }
          Object localObject = localRecyclerView.ajQ;
          j = ((RecyclerView.n)localObject).alz.size();
          i = 0;
          while (i < j)
          {
            RecyclerView.v localv = (RecyclerView.v)((RecyclerView.n)localObject).alz.get(i);
            if ((localv != null) && (localv.mPosition >= paramAnonymousInt1)) {
              localv.k(paramAnonymousInt2, true);
            }
            i += 1;
          }
          localRecyclerView.requestLayout();
          RecyclerView.this.akO = true;
          AppMethodBeat.o(262076);
        }
        
        public final void aj(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          int n = -1;
          AppMethodBeat.i(262079);
          RecyclerView localRecyclerView = RecyclerView.this;
          int i1 = localRecyclerView.mChildHelper.kj();
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
            localObject = RecyclerView.bg(localRecyclerView.mChildHelper.cq(m));
            if ((localObject != null) && (((RecyclerView.v)localObject).mPosition >= k) && (((RecyclerView.v)localObject).mPosition <= j))
            {
              if (((RecyclerView.v)localObject).mPosition != paramAnonymousInt1) {
                break label134;
              }
              ((RecyclerView.v)localObject).k(paramAnonymousInt2 - paramAnonymousInt1, false);
            }
          }
          for (;;)
          {
            localRecyclerView.akL.alV = true;
            m += 1;
            break label40;
            i = 1;
            j = paramAnonymousInt1;
            k = paramAnonymousInt2;
            break;
            label134:
            ((RecyclerView.v)localObject).k(i, false);
          }
          label144:
          Object localObject = localRecyclerView.ajQ;
          label178:
          RecyclerView.v localv;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            j = paramAnonymousInt2;
            k = paramAnonymousInt1;
            i = n;
            n = ((RecyclerView.n)localObject).alz.size();
            m = 0;
            if (m >= n) {
              break label273;
            }
            localv = (RecyclerView.v)((RecyclerView.n)localObject).alz.get(m);
            if ((localv != null) && (localv.mPosition >= k) && (localv.mPosition <= j))
            {
              if (localv.mPosition != paramAnonymousInt1) {
                break label263;
              }
              localv.k(paramAnonymousInt2 - paramAnonymousInt1, false);
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
            localv.k(i, false);
          }
          label273:
          localRecyclerView.requestLayout();
          RecyclerView.this.akO = true;
          AppMethodBeat.o(262079);
        }
        
        public final RecyclerView.v co(int paramAnonymousInt)
        {
          AppMethodBeat.i(262056);
          RecyclerView.v localv = RecyclerView.this.i(paramAnonymousInt, true);
          if (localv == null)
          {
            AppMethodBeat.o(262056);
            return null;
          }
          if (RecyclerView.this.mChildHelper.aP(localv.amk))
          {
            AppMethodBeat.o(262056);
            return null;
          }
          AppMethodBeat.o(262056);
          return localv;
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(262063);
          Object localObject = RecyclerView.this;
          int j = ((RecyclerView)localObject).mChildHelper.kj();
          int i = 0;
          while (i < j)
          {
            View localView = ((RecyclerView)localObject).mChildHelper.cq(i);
            RecyclerView.v localv = RecyclerView.bg(localView);
            if ((localv != null) && (!localv.mb()) && (localv.mPosition >= paramAnonymousInt1) && (localv.mPosition < paramAnonymousInt1 + paramAnonymousInt2))
            {
              localv.cY(2);
              localv.Q(paramAnonymousObject);
              ((RecyclerView.LayoutParams)localView.getLayoutParams()).alp = true;
            }
            i += 1;
          }
          paramAnonymousObject = ((RecyclerView)localObject).ajQ;
          i = paramAnonymousObject.alz.size() - 1;
          while (i >= 0)
          {
            localObject = (RecyclerView.v)paramAnonymousObject.alz.get(i);
            if (localObject != null)
            {
              j = ((RecyclerView.v)localObject).mPosition;
              if ((j >= paramAnonymousInt1) && (j < paramAnonymousInt1 + paramAnonymousInt2))
              {
                ((RecyclerView.v)localObject).cY(2);
                paramAnonymousObject.cT(i);
              }
            }
            i -= 1;
          }
          RecyclerView.this.akP = true;
          AppMethodBeat.o(262063);
        }
        
        public final void d(a.b paramAnonymousb)
        {
          AppMethodBeat.i(262066);
          f(paramAnonymousb);
          AppMethodBeat.o(262066);
        }
        
        public final void e(a.b paramAnonymousb)
        {
          AppMethodBeat.i(262072);
          f(paramAnonymousb);
          AppMethodBeat.o(262072);
        }
      });
      this.mChildHelper = new f(new f.b()
      {
        public final int aO(View paramAnonymousView)
        {
          AppMethodBeat.i(262038);
          int i = RecyclerView.this.indexOfChild(paramAnonymousView);
          AppMethodBeat.o(262038);
          return i;
        }
        
        public final RecyclerView.v aQ(View paramAnonymousView)
        {
          AppMethodBeat.i(262044);
          paramAnonymousView = RecyclerView.bg(paramAnonymousView);
          AppMethodBeat.o(262044);
          return paramAnonymousView;
        }
        
        public final void aR(View paramAnonymousView)
        {
          AppMethodBeat.i(262049);
          paramAnonymousView = RecyclerView.bg(paramAnonymousView);
          RecyclerView localRecyclerView;
          if (paramAnonymousView != null)
          {
            localRecyclerView = RecyclerView.this;
            if (paramAnonymousView.amz == -1) {
              break label48;
            }
          }
          label48:
          for (paramAnonymousView.amy = paramAnonymousView.amz;; paramAnonymousView.amy = androidx.core.g.w.H(paramAnonymousView.amk))
          {
            localRecyclerView.c(paramAnonymousView, 4);
            AppMethodBeat.o(262049);
            return;
          }
        }
        
        public final void aS(View paramAnonymousView)
        {
          AppMethodBeat.i(262052);
          paramAnonymousView = RecyclerView.bg(paramAnonymousView);
          if (paramAnonymousView != null)
          {
            RecyclerView.this.c(paramAnonymousView, paramAnonymousView.amy);
            paramAnonymousView.amy = 0;
          }
          AppMethodBeat.o(262052);
        }
        
        public final void addView(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(262037);
          RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
          RecyclerView localRecyclerView = RecyclerView.this;
          RecyclerView.v localv = RecyclerView.bg(paramAnonymousView);
          if ((localRecyclerView.afJ != null) && (localv != null)) {
            localRecyclerView.afJ.n(localv);
          }
          if (localRecyclerView.akn != null)
          {
            paramAnonymousInt = localRecyclerView.akn.size() - 1;
            while (paramAnonymousInt >= 0)
            {
              ((RecyclerView.i)localRecyclerView.akn.get(paramAnonymousInt)).aT(paramAnonymousView);
              paramAnonymousInt -= 1;
            }
          }
          AppMethodBeat.o(262037);
        }
        
        public final void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
        {
          AppMethodBeat.i(262046);
          RecyclerView.v localv = RecyclerView.bg(paramAnonymousView);
          if (localv != null)
          {
            if ((!localv.mn()) && (!localv.mb()))
            {
              paramAnonymousView = new IllegalArgumentException("Called attach on a child which is not detached: " + localv + RecyclerView.this.kY());
              AppMethodBeat.o(262046);
              throw paramAnonymousView;
            }
            localv.ml();
          }
          RecyclerView.a(RecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
          AppMethodBeat.o(262046);
        }
        
        public final void detachViewFromParent(int paramAnonymousInt)
        {
          AppMethodBeat.i(262047);
          Object localObject = getChildAt(paramAnonymousInt);
          if (localObject != null)
          {
            localObject = RecyclerView.bg((View)localObject);
            if (localObject != null)
            {
              if ((((RecyclerView.v)localObject).mn()) && (!((RecyclerView.v)localObject).mb()))
              {
                localObject = new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.kY());
                AppMethodBeat.o(262047);
                throw ((Throwable)localObject);
              }
              ((RecyclerView.v)localObject).cY(256);
            }
          }
          RecyclerView.b(RecyclerView.this, paramAnonymousInt);
          AppMethodBeat.o(262047);
        }
        
        public final View getChildAt(int paramAnonymousInt)
        {
          AppMethodBeat.i(262041);
          View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
          AppMethodBeat.o(262041);
          return localView;
        }
        
        public final int getChildCount()
        {
          AppMethodBeat.i(262033);
          int i = RecyclerView.this.getChildCount();
          AppMethodBeat.o(262033);
          return i;
        }
        
        public final void removeAllViews()
        {
          AppMethodBeat.i(262043);
          int j = RecyclerView.this.getChildCount();
          int i = 0;
          while (i < j)
          {
            View localView = getChildAt(i);
            RecyclerView.this.bl(localView);
            localView.clearAnimation();
            i += 1;
          }
          RecyclerView.this.removeAllViews();
          AppMethodBeat.o(262043);
        }
        
        public final void removeViewAt(int paramAnonymousInt)
        {
          AppMethodBeat.i(262039);
          View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
          if (localView != null)
          {
            RecyclerView.this.bl(localView);
            localView.clearAnimation();
          }
          RecyclerView.this.removeViewAt(paramAnonymousInt);
          AppMethodBeat.o(262039);
        }
      });
      if (androidx.core.g.w.A(this) == 0) {
        androidx.core.g.w.B(this);
      }
      if (androidx.core.g.w.H(this) == 0) {
        androidx.core.g.w.p(this, 1);
      }
      this.akm = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new w(this));
      if (paramAttributeSet == null) {
        break label1352;
      }
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.RecyclerView, paramInt, 0);
      localObject2 = ((TypedArray)localObject1).getString(a.c.RecyclerView_layoutManager);
      if (((TypedArray)localObject1).getInt(a.c.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.ake = ((TypedArray)localObject1).getBoolean(a.c.RecyclerView_fastScrollEnabled, false);
      if (!this.ake) {
        break label783;
      }
      localObject3 = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollVerticalThumbDrawable);
      localObject4 = ((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollVerticalTrackDrawable);
      localStateListDrawable = (StateListDrawable)((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollHorizontalThumbDrawable);
      localDrawable = ((TypedArray)localObject1).getDrawable(a.c.RecyclerView_fastScrollHorizontalTrackDrawable);
      if ((localObject3 != null) && (localObject4 != null) && (localStateListDrawable != null) && (localDrawable != null)) {
        break label733;
      }
      paramContext = new IllegalArgumentException("Trying to set fast scroller without both required drawables." + kY());
      AppMethodBeat.o(262474);
      throw paramContext;
      localObject1 = null;
      break;
      this.ajU = true;
      break label364;
    }
    label733:
    Resources localResources = getContext().getResources();
    new j(this, (StateListDrawable)localObject3, (Drawable)localObject4, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(androidx.recyclerview.a.a.fastscroll_default_thickness), localResources.getDimensionPixelSize(androidx.recyclerview.a.a.fastscroll_minimum_range), localResources.getDimensionPixelOffset(androidx.recyclerview.a.a.fastscroll_margin));
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
          localObject3 = ((Class)localObject4).getConstructor(ajO);
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
            AppMethodBeat.o(262474);
            throw paramContext;
          }
        }
        ((Constructor)localObject3).setAccessible(true);
        setLayoutManager((LayoutManager)((Constructor)localObject3).newInstance((Object[])localObject2));
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ajG, paramInt, 0);
          bool = paramContext.getBoolean(0, true);
          paramContext.recycle();
          setNestedScrollingEnabled(bool);
          AppMethodBeat.o(262474);
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
        AppMethodBeat.o(262474);
        throw paramContext;
      }
      catch (InvocationTargetException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + (String)localObject1, paramContext);
        AppMethodBeat.o(262474);
        throw paramContext;
      }
      catch (InstantiationException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + (String)localObject1, paramContext);
        AppMethodBeat.o(262474);
        throw paramContext;
      }
      catch (IllegalAccessException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + (String)localObject1, paramContext);
        AppMethodBeat.o(262474);
        throw paramContext;
      }
      catch (ClassCastException paramContext)
      {
        paramContext = new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + (String)localObject1, paramContext);
        AppMethodBeat.o(262474);
        throw paramContext;
      }
      label1352:
      bool = true;
    }
  }
  
  private boolean E(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262736);
    boolean bool = getScrollingChildHelper().E(paramInt1, paramInt2);
    AppMethodBeat.o(262736);
    return bool;
  }
  
  private void a(long paramLong, v paramv1, v paramv2)
  {
    AppMethodBeat.i(262659);
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      v localv = bg(this.mChildHelper.getChildAt(i));
      if ((localv != paramv1) && (i(localv) == paramLong))
      {
        if ((this.afJ != null) && (this.afJ.ald))
        {
          paramv1 = new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + kY());
          AppMethodBeat.o(262659);
          throw paramv1;
        }
        paramv1 = new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1 + kY());
        AppMethodBeat.o(262659);
        throw paramv1;
      }
      i += 1;
    }
    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(paramv2).append(" cannot be found but it is necessary for ").append(paramv1).append(kY());
    AppMethodBeat.o(262659);
  }
  
  private void a(v paramv1, v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(262666);
    paramv1.ax(false);
    if (paramBoolean1) {
      h(paramv1);
    }
    if (paramv1 != paramv2)
    {
      if (paramBoolean2) {
        h(paramv2);
      }
      paramv1.amq = paramv2;
      h(paramv1);
      this.ajQ.x(paramv1);
      paramv2.ax(false);
      paramv2.amr = paramv1;
    }
    if (this.akx.a(paramv1, paramv2, paramc1, paramc2)) {
      lr();
    }
    AppMethodBeat.o(262666);
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(262548);
    lb();
    int i;
    int j;
    int k;
    int m;
    if (this.afJ != null)
    {
      d(paramInt1, paramInt2, this.akW);
      i = this.akW[0];
      j = this.akW[1];
      k = paramInt1 - i;
      m = paramInt2 - j;
    }
    for (;;)
    {
      if (!this.ajZ.isEmpty()) {
        invalidate();
      }
      if (a(i, j, k, m, this.Qr, 0))
      {
        this.akB -= this.Qr[0];
        this.akC -= this.Qr[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.Qr[0], this.Qr[1]);
        }
        paramMotionEvent = this.akV;
        paramMotionEvent[0] += this.Qr[0];
        paramMotionEvent = this.akV;
        paramMotionEvent[1] += this.Qr[1];
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          aD(i, j);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((i == 0) && (j == 0)) {
          break;
        }
        AppMethodBeat.o(262548);
        return true;
        if (getOverScrollMode() != 2)
        {
          if ((paramMotionEvent != null) && (!androidx.core.g.j.g(paramMotionEvent))) {
            b(paramMotionEvent.getX(), k, paramMotionEvent.getY(), m);
          }
          az(paramInt1, paramInt2);
        }
      }
      AppMethodBeat.o(262548);
      return false;
      j = 0;
      i = 0;
      m = 0;
      k = 0;
    }
  }
  
  private boolean aC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262664);
    j(this.akT);
    if ((this.akT[0] != paramInt1) || (this.akT[1] != paramInt2))
    {
      AppMethodBeat.o(262664);
      return true;
    }
    AppMethodBeat.o(262664);
    return false;
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    AppMethodBeat.i(262572);
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      lg();
      androidx.core.widget.d.a(this.akt, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label153;
      }
      li();
      androidx.core.widget.d.a(this.aku, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        androidx.core.g.w.G(this);
      }
      AppMethodBeat.o(262572);
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      lh();
      androidx.core.widget.d.a(this.akv, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label153:
      if (paramFloat4 > 0.0F)
      {
        lj();
        androidx.core.widget.d.a(this.akw, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  static v bg(View paramView)
  {
    AppMethodBeat.i(262693);
    if (paramView == null)
    {
      AppMethodBeat.o(262693);
      return null;
    }
    paramView = ((LayoutParams)paramView.getLayoutParams()).aiC;
    AppMethodBeat.o(262693);
    return paramView;
  }
  
  public static int bh(View paramView)
  {
    AppMethodBeat.i(262694);
    paramView = bg(paramView);
    if (paramView != null)
    {
      int i = paramView.md();
      AppMethodBeat.o(262694);
      return i;
    }
    AppMethodBeat.o(262694);
    return -1;
  }
  
  public static int bi(View paramView)
  {
    AppMethodBeat.i(262696);
    paramView = bg(paramView);
    if (paramView != null)
    {
      int i = paramView.mc();
      AppMethodBeat.o(262696);
      return i;
    }
    AppMethodBeat.o(262696);
    return -1;
  }
  
  static RecyclerView bk(View paramView)
  {
    AppMethodBeat.i(262714);
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(262714);
      return null;
    }
    if ((paramView instanceof RecyclerView))
    {
      paramView = (RecyclerView)paramView;
      AppMethodBeat.o(262714);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView localRecyclerView = bk(paramView.getChildAt(i));
      if (localRecyclerView != null)
      {
        AppMethodBeat.o(262714);
        return localRecyclerView;
      }
      i += 1;
    }
    AppMethodBeat.o(262714);
    return null;
  }
  
  static void c(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(262707);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.ahL;
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
    AppMethodBeat.o(262707);
  }
  
  private void e(View paramView1, View paramView2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(262592);
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
        if (!((LayoutParams)localObject).alp)
        {
          localObject = ((LayoutParams)localObject).ahL;
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
      localObject = this.ajX;
      localRect = this.mTempRect;
      if (this.akf) {
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
      AppMethodBeat.o(262592);
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
  
  private void f(s params)
  {
    AppMethodBeat.i(262651);
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.akI.Qi;
      params.ame = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      params.amf = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      AppMethodBeat.o(262651);
      return;
    }
    params.ame = 0;
    params.amf = 0;
    AppMethodBeat.o(262651);
  }
  
  public static void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(262705);
    c(paramView, paramRect);
    AppMethodBeat.o(262705);
  }
  
  private long i(v paramv)
  {
    if (this.afJ.ald) {
      return paramv.amn;
    }
    return paramv.mPosition;
  }
  
  static void j(v paramv)
  {
    AppMethodBeat.i(262717);
    if (paramv.aml != null)
    {
      Object localObject = (View)paramv.aml.get();
      while (localObject != null)
      {
        if (localObject == paramv.amk)
        {
          AppMethodBeat.o(262717);
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      paramv.aml = null;
    }
    AppMethodBeat.o(262717);
  }
  
  private void j(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(262662);
    int i2 = this.mChildHelper.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      AppMethodBeat.o(262662);
      return;
    }
    int i = 2147483647;
    int k = -2147483648;
    int n = 0;
    int m;
    int j;
    if (n < i2)
    {
      v localv = bg(this.mChildHelper.getChildAt(n));
      m = i;
      if (localv.mb()) {
        break label140;
      }
      int i1 = localv.mc();
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
      AppMethodBeat.o(262662);
      return;
      label140:
      j = k;
      i = m;
    }
  }
  
  private void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(262624);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.aky) {
      if (i != 0) {
        break label87;
      }
    }
    label87:
    for (i = 1;; i = 0)
    {
      this.aky = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.akB = j;
      this.akz = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.akC = i;
      this.akA = i;
      AppMethodBeat.o(262624);
      return;
    }
  }
  
  private void lA()
  {
    AppMethodBeat.i(262658);
    this.akL.cW(4);
    lc();
    ln();
    this.akL.alT = 1;
    if (this.akL.alZ)
    {
      int i = this.mChildHelper.getChildCount() - 1;
      if (i >= 0)
      {
        v localv1 = bg(this.mChildHelper.getChildAt(i));
        RecyclerView.f.c localc2;
        v localv2;
        boolean bool1;
        boolean bool2;
        RecyclerView.f.c localc1;
        if (!localv1.mb())
        {
          long l = i(localv1);
          localc2 = f.lN().e(localv1, 0);
          localv2 = this.ajT.o(l);
          if ((localv2 == null) || (localv2.mb())) {
            break label226;
          }
          bool1 = this.ajT.J(localv2);
          bool2 = this.ajT.J(localv1);
          if ((bool1) && (localv2 == localv1)) {
            break label226;
          }
          localc1 = this.ajT.f(localv2, 4);
          this.ajT.d(localv1, localc2);
          localc2 = this.ajT.f(localv1, 8);
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
          this.ajT.d(localv1, localc2);
        }
      }
      this.ajT.a(this.ala);
    }
    this.ajX.removeAndRecycleScrapInt(this.ajQ);
    this.akL.alR = this.akL.alU;
    this.ako = false;
    this.akp = false;
    this.akL.alZ = false;
    this.akL.ama = false;
    this.ajX.mRequestedSimpleAnimations = false;
    if (this.ajQ.aly != null) {
      this.ajQ.aly.clear();
    }
    if (this.ajX.mPrefetchMaxObservedInInitialPrefetch)
    {
      this.ajX.mPrefetchMaxCountObserved = 0;
      this.ajX.mPrefetchMaxObservedInInitialPrefetch = false;
      this.ajQ.lU();
    }
    this.ajX.onLayoutCompleted(this.akL);
    au(true);
    at(false);
    this.ajT.clear();
    if (aC(this.akT[0], this.akT[1])) {
      aD(0, 0);
    }
    lx();
    lw();
    AppMethodBeat.o(262658);
  }
  
  private void lC()
  {
    AppMethodBeat.i(262680);
    int j = this.mChildHelper.kj();
    int i = 0;
    while (i < j)
    {
      v localv = bg(this.mChildHelper.cq(i));
      if (!localv.mb()) {
        localv.ma();
      }
      i += 1;
    }
    AppMethodBeat.o(262680);
  }
  
  private void lD()
  {
    AppMethodBeat.i(262681);
    int j = this.mChildHelper.kj();
    int i = 0;
    while (i < j)
    {
      v localv = bg(this.mChildHelper.cq(i));
      if (!localv.mb()) {
        localv.lZ();
      }
      i += 1;
    }
    this.ajQ.lD();
    AppMethodBeat.o(262681);
  }
  
  private void lE()
  {
    AppMethodBeat.i(262685);
    int j = this.mChildHelper.kj();
    int i = 0;
    while (i < j)
    {
      v localv = bg(this.mChildHelper.cq(i));
      if ((localv != null) && (!localv.mb())) {
        localv.cY(6);
      }
      i += 1;
    }
    lB();
    this.ajQ.lE();
    AppMethodBeat.o(262685);
  }
  
  private void lH()
  {
    AppMethodBeat.i(262728);
    int i = this.akX.size() - 1;
    while (i >= 0)
    {
      v localv = (v)this.akX.get(i);
      if ((localv.amk.getParent() == this) && (!localv.mb()))
      {
        int j = localv.amz;
        if (j != -1)
        {
          androidx.core.g.w.p(localv.amk, j);
          localv.amz = -1;
        }
      }
      i -= 1;
    }
    this.akX.clear();
    AppMethodBeat.o(262728);
  }
  
  private void le()
  {
    AppMethodBeat.i(262570);
    this.akI.stop();
    if (this.ajX != null) {
      this.ajX.stopSmoothScroller();
    }
    AppMethodBeat.o(262570);
  }
  
  private void lf()
  {
    AppMethodBeat.i(262574);
    boolean bool2 = false;
    if (this.akt != null)
    {
      this.akt.onRelease();
      bool2 = this.akt.isFinished();
    }
    boolean bool1 = bool2;
    if (this.aku != null)
    {
      this.aku.onRelease();
      bool1 = bool2 | this.aku.isFinished();
    }
    bool2 = bool1;
    if (this.akv != null)
    {
      this.akv.onRelease();
      bool2 = bool1 | this.akv.isFinished();
    }
    bool1 = bool2;
    if (this.akw != null)
    {
      this.akw.onRelease();
      bool1 = bool2 | this.akw.isFinished();
    }
    if (bool1) {
      androidx.core.g.w.G(this);
    }
    AppMethodBeat.o(262574);
  }
  
  private void lg()
  {
    AppMethodBeat.i(262579);
    if (this.akt != null)
    {
      AppMethodBeat.o(262579);
      return;
    }
    this.akt = RecyclerView.e.f(this);
    if (this.ajU)
    {
      this.akt.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      AppMethodBeat.o(262579);
      return;
    }
    this.akt.setSize(getMeasuredHeight(), getMeasuredWidth());
    AppMethodBeat.o(262579);
  }
  
  private void lh()
  {
    AppMethodBeat.i(262580);
    if (this.akv != null)
    {
      AppMethodBeat.o(262580);
      return;
    }
    this.akv = RecyclerView.e.f(this);
    if (this.ajU)
    {
      this.akv.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      AppMethodBeat.o(262580);
      return;
    }
    this.akv.setSize(getMeasuredHeight(), getMeasuredWidth());
    AppMethodBeat.o(262580);
  }
  
  private void li()
  {
    AppMethodBeat.i(262582);
    if (this.aku != null)
    {
      AppMethodBeat.o(262582);
      return;
    }
    this.aku = RecyclerView.e.f(this);
    if (this.ajU)
    {
      this.aku.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      AppMethodBeat.o(262582);
      return;
    }
    this.aku.setSize(getMeasuredWidth(), getMeasuredHeight());
    AppMethodBeat.o(262582);
  }
  
  private void lj()
  {
    AppMethodBeat.i(262583);
    if (this.akw != null)
    {
      AppMethodBeat.o(262583);
      return;
    }
    this.akw = RecyclerView.e.f(this);
    if (this.ajU)
    {
      this.akw.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      AppMethodBeat.o(262583);
      return;
    }
    this.akw.setSize(getMeasuredWidth(), getMeasuredHeight());
    AppMethodBeat.o(262583);
  }
  
  private void lk()
  {
    this.akw = null;
    this.aku = null;
    this.akv = null;
    this.akt = null;
  }
  
  private void ll()
  {
    AppMethodBeat.i(262622);
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    bw(0);
    lf();
    AppMethodBeat.o(262622);
  }
  
  private void lm()
  {
    AppMethodBeat.i(262623);
    ll();
    setScrollState(0);
    AppMethodBeat.o(262623);
  }
  
  private void lp()
  {
    AppMethodBeat.i(262637);
    int i = this.akk;
    this.akk = 0;
    if ((i != 0) && (lo()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      b.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
    AppMethodBeat.o(262637);
  }
  
  private boolean ls()
  {
    AppMethodBeat.i(262643);
    if ((this.akx != null) && (this.ajX.supportsPredictiveItemAnimations()))
    {
      AppMethodBeat.o(262643);
      return true;
    }
    AppMethodBeat.o(262643);
    return false;
  }
  
  private void lt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(262645);
    if (this.ako)
    {
      this.ajS.reset();
      if (this.akp) {
        this.ajX.onItemsChanged(this);
      }
    }
    int i;
    label67:
    s locals;
    if (ls())
    {
      this.ajS.kc();
      if ((!this.akO) && (!this.akP)) {
        break label192;
      }
      i = 1;
      locals = this.akL;
      if ((!this.akf) || (this.akx == null) || ((!this.ako) && (i == 0) && (!this.ajX.mRequestedSimpleAnimations)) || ((this.ako) && (!this.afJ.ald))) {
        break label197;
      }
      bool1 = true;
      label127:
      locals.alZ = bool1;
      locals = this.akL;
      if ((!this.akL.alZ) || (i == 0) || (this.ako) || (!ls())) {
        break label202;
      }
    }
    label192:
    label197:
    label202:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locals.ama = bool1;
      AppMethodBeat.o(262645);
      return;
      this.ajS.kf();
      break;
      i = 0;
      break label67;
      bool1 = false;
      break label127;
    }
  }
  
  private void lu()
  {
    AppMethodBeat.i(262647);
    if (this.afJ == null)
    {
      AppMethodBeat.o(262647);
      return;
    }
    if (this.ajX == null)
    {
      AppMethodBeat.o(262647);
      return;
    }
    this.akL.alY = false;
    if (this.akL.alT == 1)
    {
      ly();
      this.ajX.setExactMeasureSpecsFrom(this);
      lz();
    }
    for (;;)
    {
      lA();
      AppMethodBeat.o(262647);
      return;
      if ((this.ajS.kg()) || (this.ajX.getWidth() != getWidth()) || (this.ajX.getHeight() != getHeight()))
      {
        this.ajX.setExactMeasureSpecsFrom(this);
        lz();
      }
      else
      {
        this.ajX.setExactMeasureSpecsFrom(this);
      }
    }
  }
  
  private void lv()
  {
    AppMethodBeat.i(262648);
    if ((this.akH) && (hasFocus()) && (this.afJ != null)) {}
    for (Object localObject1 = getFocusedChild();; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = bf((View)localObject1))
      {
        lw();
        AppMethodBeat.o(262648);
        return;
      }
      Object localObject2 = this.akL;
      long l;
      int i;
      if (this.afJ.ald)
      {
        l = ((v)localObject1).amn;
        ((s)localObject2).amc = l;
        localObject2 = this.akL;
        if (!this.ako) {
          break label203;
        }
        i = -1;
      }
      s locals;
      for (;;)
      {
        ((s)localObject2).amb = i;
        locals = this.akL;
        localObject1 = ((v)localObject1).amk;
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
          i = ((v)localObject1).amm;
        } else {
          i = ((v)localObject1).md();
        }
      }
      locals.amd = i;
      AppMethodBeat.o(262648);
      return;
    }
  }
  
  private void lw()
  {
    this.akL.amc = -1L;
    this.akL.amb = -1;
    this.akL.amd = -1;
  }
  
  private void lx()
  {
    View localView = null;
    AppMethodBeat.i(262650);
    if ((!this.akH) || (this.afJ == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused())))
    {
      AppMethodBeat.o(262650);
      return;
    }
    if (!isFocused())
    {
      localObject = getFocusedChild();
      if ((ajN) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.mChildHelper.getChildCount() == 0)
        {
          requestFocus();
          AppMethodBeat.o(262650);
        }
      }
      else if (!this.mChildHelper.aP((View)localObject))
      {
        AppMethodBeat.o(262650);
        return;
      }
    }
    if ((this.akL.amc != -1L) && (this.afJ.ald)) {}
    for (Object localObject = k(this.akL.amc);; localObject = null)
    {
      int i;
      int k;
      int j;
      if ((localObject == null) || (this.mChildHelper.aP(((v)localObject).amk)) || (!((v)localObject).amk.hasFocusable()))
      {
        localObject = localView;
        if (this.mChildHelper.getChildCount() > 0)
        {
          if (this.akL.amb != -1)
          {
            i = this.akL.amb;
            k = this.akL.getItemCount();
            j = i;
            label251:
            if (j >= k) {
              break label362;
            }
            localObject = cK(j);
            if (localObject == null) {
              break label362;
            }
            if (!((v)localObject).amk.hasFocusable()) {
              break label355;
            }
            localObject = ((v)localObject).amk;
          }
        }
        else {
          label286:
          if (localObject != null)
          {
            if (this.akL.amd == -1L) {
              break label430;
            }
            localView = ((View)localObject).findViewById(this.akL.amd);
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
        AppMethodBeat.o(262650);
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
          localObject = cK(i);
          if (localObject == null) {
            break label414;
          }
          if (((v)localObject).amk.hasFocusable())
          {
            localObject = ((v)localObject).amk;
            break;
          }
          i -= 1;
        }
        localObject = null;
        break label286;
        localObject = ((v)localObject).amk;
        break label286;
      }
    }
  }
  
  private void ly()
  {
    AppMethodBeat.i(262653);
    this.akL.cW(1);
    f(this.akL);
    this.akL.alY = false;
    lc();
    this.ajT.clear();
    ln();
    lt();
    lv();
    Object localObject = this.akL;
    if ((this.akL.alZ) && (this.akP)) {}
    int j;
    int i;
    RecyclerView.f.c localc;
    for (boolean bool = true;; bool = false)
    {
      ((s)localObject).alX = bool;
      this.akP = false;
      this.akO = false;
      this.akL.alW = this.akL.ama;
      this.akL.alU = this.afJ.getItemCount();
      j(this.akT);
      if (!this.akL.alZ) {
        break;
      }
      j = this.mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = bg(this.mChildHelper.getChildAt(i));
        if ((!((v)localObject).mb()) && ((!((v)localObject).isInvalid()) || (this.afJ.ald)))
        {
          localc = this.akx.a(this.akL, (v)localObject, f.p((v)localObject), ((v)localObject).mq());
          this.ajT.b((v)localObject, localc);
          if ((this.akL.alX) && (((v)localObject).mt()) && (!((v)localObject).isRemoved()) && (!((v)localObject).mb()) && (!((v)localObject).isInvalid()))
          {
            long l = i((v)localObject);
            this.ajT.a(l, (v)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.akL.ama)
    {
      lC();
      bool = this.akL.alV;
      this.akL.alV = false;
      this.ajX.onLayoutChildren(this.ajQ, this.akL);
      this.akL.alV = bool;
      i = 0;
      if (i < this.mChildHelper.getChildCount())
      {
        localObject = bg(this.mChildHelper.getChildAt(i));
        if ((!((v)localObject).mb()) && (!this.ajT.K((v)localObject)))
        {
          int k = f.p((v)localObject);
          bool = ((v)localObject).cX(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localc = this.akx.a(this.akL, (v)localObject, j, ((v)localObject).mq());
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
          this.ajT.c((v)localObject, localc);
        }
      }
      lD();
    }
    for (;;)
    {
      au(true);
      at(false);
      this.akL.alT = 2;
      AppMethodBeat.o(262653);
      return;
      lD();
    }
  }
  
  private void lz()
  {
    AppMethodBeat.i(262655);
    lc();
    ln();
    this.akL.cW(6);
    this.ajS.kf();
    this.akL.alU = this.afJ.getItemCount();
    this.akL.alS = 0;
    this.akL.alW = false;
    this.ajX.onLayoutChildren(this.ajQ, this.akL);
    this.akL.alV = false;
    this.ajR = null;
    s locals = this.akL;
    if ((this.akL.alZ) && (this.akx != null)) {}
    for (boolean bool = true;; bool = false)
    {
      locals.alZ = bool;
      this.akL.alT = 4;
      au(true);
      at(false);
      AppMethodBeat.o(262655);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    AppMethodBeat.i(262566);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262566);
      return;
    }
    if (this.aki)
    {
      AppMethodBeat.o(262566);
      return;
    }
    if (!this.ajX.canScrollHorizontally()) {
      paramInt1 = 0;
    }
    if (!this.ajX.canScrollVertically()) {
      paramInt2 = i;
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        u localu = this.akI;
        i = localu.aM(paramInt1, paramInt2);
        Interpolator localInterpolator = paramInterpolator;
        if (paramInterpolator == null) {
          localInterpolator = akZ;
        }
        localu.b(paramInt1, paramInt2, i, localInterpolator);
      }
      AppMethodBeat.o(262566);
      return;
    }
  }
  
  public final void a(RecyclerView.h paramh)
  {
    AppMethodBeat.i(262519);
    if (this.ajX != null) {
      this.ajX.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.ajZ.isEmpty()) {
      setWillNotDraw(false);
    }
    this.ajZ.add(paramh);
    lB();
    requestLayout();
    AppMethodBeat.o(262519);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(262488);
    if (this.akn == null) {
      this.akn = new ArrayList();
    }
    this.akn.add(parami);
    AppMethodBeat.o(262488);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(262607);
    this.aka.add(paramk);
    AppMethodBeat.o(262607);
  }
  
  public final void a(RecyclerView.l paraml)
  {
    AppMethodBeat.i(262531);
    if (this.akN == null) {
      this.akN = new ArrayList();
    }
    this.akN.add(paraml);
    AppMethodBeat.o(262531);
  }
  
  final void a(v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(262660);
    paramv.aN(0, 8192);
    if ((this.akL.alX) && (paramv.mt()) && (!paramv.isRemoved()) && (!paramv.mb()))
    {
      long l = i(paramv);
      this.ajT.a(l, paramv);
    }
    this.ajT.b(paramv, paramc);
    AppMethodBeat.o(262660);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    AppMethodBeat.i(262743);
    boolean bool = getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
    AppMethodBeat.o(262743);
    return bool;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    AppMethodBeat.i(262747);
    boolean bool = getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    AppMethodBeat.o(262747);
    return bool;
  }
  
  final void aA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262577);
    if (paramInt1 < 0)
    {
      lg();
      this.akt.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label78;
      }
      li();
      this.aku.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        androidx.core.g.w.G(this);
      }
      AppMethodBeat.o(262577);
      return;
      if (paramInt1 <= 0) {
        break;
      }
      lh();
      this.akv.onAbsorb(paramInt1);
      break;
      label78:
      if (paramInt2 > 0)
      {
        lj();
        this.akw.onAbsorb(paramInt2);
      }
    }
  }
  
  final void aB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262629);
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), androidx.core.g.w.O(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), androidx.core.g.w.P(this)));
    AppMethodBeat.o(262629);
  }
  
  final void aD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262710);
    this.akr += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.akM != null) {
      this.akM.onScrolled(this, paramInt1, paramInt2);
    }
    if (this.akN != null)
    {
      i = this.akN.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.l)this.akN.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.akr -= 1;
    AppMethodBeat.o(262710);
  }
  
  public final v aQ(View paramView)
  {
    AppMethodBeat.i(262688);
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this))
    {
      paramView = new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
      AppMethodBeat.o(262688);
      throw paramView;
    }
    paramView = bg(paramView);
    AppMethodBeat.o(262688);
    return paramView;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262596);
    if ((this.ajX == null) || (!this.ajX.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
    AppMethodBeat.o(262596);
  }
  
  final void assertInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(262605);
    if (!lq())
    {
      if (paramString == null)
      {
        paramString = new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + kY());
        AppMethodBeat.o(262605);
        throw paramString;
      }
      paramString = new IllegalStateException(paramString + kY());
      AppMethodBeat.o(262605);
      throw paramString;
    }
    AppMethodBeat.o(262605);
  }
  
  final void assertNotInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(262606);
    if (lq())
    {
      if (paramString == null)
      {
        paramString = new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + kY());
        AppMethodBeat.o(262606);
        throw paramString;
      }
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(262606);
      throw paramString;
    }
    if (this.akr > 0) {
      new IllegalStateException(kY());
    }
    AppMethodBeat.o(262606);
  }
  
  final void at(boolean paramBoolean)
  {
    AppMethodBeat.i(262562);
    if (this.akg <= 0) {
      this.akg = 1;
    }
    if ((!paramBoolean) && (!this.aki)) {
      this.akh = false;
    }
    if (this.akg == 1)
    {
      if ((paramBoolean) && (this.akh) && (!this.aki) && (this.ajX != null) && (this.afJ != null)) {
        lu();
      }
      if (!this.aki) {
        this.akh = false;
      }
    }
    this.akg -= 1;
    AppMethodBeat.o(262562);
  }
  
  final void au(boolean paramBoolean)
  {
    AppMethodBeat.i(262633);
    this.akq -= 1;
    if (this.akq <= 0)
    {
      this.akq = 0;
      if (paramBoolean)
      {
        lp();
        lH();
      }
    }
    AppMethodBeat.o(262633);
  }
  
  final void av(boolean paramBoolean)
  {
    AppMethodBeat.i(262684);
    this.akp |= paramBoolean;
    this.ako = true;
    lE();
    AppMethodBeat.o(262684);
  }
  
  public final void ax(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262565);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(262565);
  }
  
  public boolean ay(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262567);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262567);
      return false;
    }
    if (this.aki)
    {
      AppMethodBeat.o(262567);
      return false;
    }
    boolean bool2 = this.ajX.canScrollHorizontally();
    boolean bool3 = this.ajX.canScrollVertically();
    int i;
    if (bool2)
    {
      i = paramInt1;
      if (Math.abs(paramInt1) >= this.vZ) {}
    }
    else
    {
      i = 0;
    }
    int j;
    if (bool3)
    {
      j = paramInt2;
      if (Math.abs(paramInt2) >= this.vZ) {}
    }
    else
    {
      j = 0;
    }
    if ((i == 0) && (j == 0))
    {
      AppMethodBeat.o(262567);
      return false;
    }
    if (!dispatchNestedPreFling(i, j))
    {
      if ((bool2) || (bool3)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        dispatchNestedFling(i, j, bool1);
        if ((this.akD == null) || (!this.akD.aI(i, j))) {
          break;
        }
        AppMethodBeat.o(262567);
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
      E(paramInt2, 1);
      paramInt1 = Math.max(-this.akE, Math.min(i, this.akE));
      paramInt2 = Math.max(-this.akE, Math.min(j, this.akE));
      u localu = this.akI;
      localu.alb.setScrollState(2);
      localu.amh = 0;
      localu.amg = 0;
      localu.Qi.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
      localu.lY();
      AppMethodBeat.o(262567);
      return true;
      AppMethodBeat.o(262567);
      return false;
    }
  }
  
  final void az(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262576);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.akt != null)
    {
      bool1 = bool2;
      if (!this.akt.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.akt.onRelease();
          bool1 = this.akt.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.akv != null)
    {
      bool2 = bool1;
      if (!this.akv.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.akv.onRelease();
          bool2 = bool1 | this.akv.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.aku != null)
    {
      bool1 = bool2;
      if (!this.aku.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.aku.onRelease();
          bool1 = bool2 | this.aku.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.akw != null)
    {
      bool2 = bool1;
      if (!this.akw.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.akw.onRelease();
          bool2 = bool1 | this.akw.isFinished();
        }
      }
    }
    if (bool2) {
      androidx.core.g.w.G(this);
    }
    AppMethodBeat.o(262576);
  }
  
  public final void b(RecyclerView.h paramh)
  {
    AppMethodBeat.i(293122);
    a(paramh);
    AppMethodBeat.o(293122);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(262608);
    this.aka.remove(paramk);
    if (this.akb == paramk) {
      this.akb = null;
    }
    AppMethodBeat.o(262608);
  }
  
  public final void b(RecyclerView.l paraml)
  {
    AppMethodBeat.i(262532);
    if (this.akN != null) {
      this.akN.remove(paraml);
    }
    AppMethodBeat.o(262532);
  }
  
  public final v bf(View paramView)
  {
    AppMethodBeat.i(262691);
    paramView = findContainingItemView(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(262691);
      return null;
    }
    paramView = aQ(paramView);
    AppMethodBeat.o(262691);
    return paramView;
  }
  
  final Rect bj(View paramView)
  {
    AppMethodBeat.i(262709);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.alp)
    {
      paramView = localLayoutParams.ahL;
      AppMethodBeat.o(262709);
      return paramView;
    }
    if ((this.akL.alW) && ((localLayoutParams.aiC.mt()) || (localLayoutParams.aiC.isInvalid())))
    {
      paramView = localLayoutParams.ahL;
      AppMethodBeat.o(262709);
      return paramView;
    }
    Rect localRect = localLayoutParams.ahL;
    localRect.set(0, 0, 0, 0);
    int j = this.ajZ.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((RecyclerView.h)this.ajZ.get(i)).a(this.mTempRect, paramView, this, this.akL);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.alp = false;
    AppMethodBeat.o(262709);
    return localRect;
  }
  
  final void bl(View paramView)
  {
    AppMethodBeat.i(262722);
    v localv = bg(paramView);
    if ((this.afJ != null) && (localv != null)) {
      this.afJ.o(localv);
    }
    if (this.akn != null)
    {
      int i = this.akn.size() - 1;
      while (i >= 0)
      {
        ((i)this.akn.get(i)).aU(paramView);
        i -= 1;
      }
    }
    AppMethodBeat.o(262722);
  }
  
  public final void bw(int paramInt)
  {
    AppMethodBeat.i(262739);
    getScrollingChildHelper().bw(paramInt);
    AppMethodBeat.o(262739);
  }
  
  public final void c(RecyclerView.h paramh)
  {
    AppMethodBeat.i(262527);
    if (this.ajX != null) {
      this.ajX.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.ajZ.remove(paramh);
    if (this.ajZ.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      lB();
      requestLayout();
      AppMethodBeat.o(262527);
      return;
    }
  }
  
  final boolean c(v paramv, int paramInt)
  {
    AppMethodBeat.i(262725);
    if (lq())
    {
      paramv.amz = paramInt;
      this.akX.add(paramv);
      AppMethodBeat.o(262725);
      return false;
    }
    androidx.core.g.w.p(paramv.amk, paramInt);
    AppMethodBeat.o(262725);
    return true;
  }
  
  public final RecyclerView.h cH(int paramInt)
  {
    AppMethodBeat.i(262522);
    int i = getItemDecorationCount();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new IndexOutOfBoundsException(paramInt + " is an invalid index for size " + i);
      AppMethodBeat.o(262522);
      throw ((Throwable)localObject);
    }
    Object localObject = (RecyclerView.h)this.ajZ.get(paramInt);
    AppMethodBeat.o(262522);
    return localObject;
  }
  
  final void cI(int paramInt)
  {
    AppMethodBeat.i(262535);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262535);
      return;
    }
    LayoutManager localLayoutManager = this.ajX;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aFh(), "androidx/recyclerview/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "androidx/recyclerview/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
    AppMethodBeat.o(262535);
  }
  
  public final v cJ(int paramInt)
  {
    AppMethodBeat.i(262698);
    v localv = i(paramInt, false);
    AppMethodBeat.o(262698);
    return localv;
  }
  
  public final v cK(int paramInt)
  {
    AppMethodBeat.i(262700);
    if (this.ako)
    {
      AppMethodBeat.o(262700);
      return null;
    }
    int j = this.mChildHelper.kj();
    int i = 0;
    Object localObject = null;
    v localv;
    if (i < j)
    {
      localv = bg(this.mChildHelper.cq(i));
      if ((localv == null) || (localv.isRemoved()) || (k(localv) != paramInt)) {
        break label119;
      }
      if (this.mChildHelper.aP(localv.amk)) {
        localObject = localv;
      }
    }
    label119:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(262700);
      return localv;
      AppMethodBeat.o(262700);
      return localObject;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(262674);
    if (((paramLayoutParams instanceof LayoutParams)) && (this.ajX.checkLayoutParams((LayoutParams)paramLayoutParams)))
    {
      AppMethodBeat.o(262674);
      return true;
    }
    AppMethodBeat.o(262674);
    return false;
  }
  
  public int computeHorizontalScrollExtent()
  {
    AppMethodBeat.i(262551);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262551);
      return 0;
    }
    if (this.ajX.canScrollHorizontally())
    {
      int i = this.ajX.computeHorizontalScrollExtent(this.akL);
      AppMethodBeat.o(262551);
      return i;
    }
    AppMethodBeat.o(262551);
    return 0;
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(262549);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262549);
      return 0;
    }
    if (this.ajX.canScrollHorizontally())
    {
      int i = this.ajX.computeHorizontalScrollOffset(this.akL);
      AppMethodBeat.o(262549);
      return i;
    }
    AppMethodBeat.o(262549);
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(262552);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262552);
      return 0;
    }
    if (this.ajX.canScrollHorizontally())
    {
      int i = this.ajX.computeHorizontalScrollRange(this.akL);
      AppMethodBeat.o(262552);
      return i;
    }
    AppMethodBeat.o(262552);
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(262554);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262554);
      return 0;
    }
    if (this.ajX.canScrollVertically())
    {
      int i = this.ajX.computeVerticalScrollExtent(this.akL);
      AppMethodBeat.o(262554);
      return i;
    }
    AppMethodBeat.o(262554);
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(262553);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262553);
      return 0;
    }
    if (this.ajX.canScrollVertically())
    {
      int i = this.ajX.computeVerticalScrollOffset(this.akL);
      AppMethodBeat.o(262553);
      return i;
    }
    AppMethodBeat.o(262553);
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(262558);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262558);
      return 0;
    }
    if (this.ajX.canScrollVertically())
    {
      int i = this.ajX.computeVerticalScrollRange(this.akL);
      AppMethodBeat.o(262558);
      return i;
    }
    AppMethodBeat.o(262558);
    return 0;
  }
  
  final void d(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(262543);
    lc();
    ln();
    androidx.core.c.d.D("RV Scroll");
    f(this.akL);
    if (paramInt1 != 0) {}
    for (paramInt1 = this.ajX.scrollHorizontallyBy(paramInt1, this.ajQ, this.akL);; paramInt1 = 0)
    {
      if (paramInt2 != 0) {}
      for (paramInt2 = this.ajX.scrollVerticallyBy(paramInt2, this.ajQ, this.akL);; paramInt2 = 0)
      {
        androidx.core.c.d.gH();
        int j = this.mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = this.mChildHelper.getChildAt(i);
          Object localObject = aQ(localView);
          if ((localObject != null) && (((v)localObject).amr != null))
          {
            localObject = ((v)localObject).amr.amk;
            int k = localView.getLeft();
            int m = localView.getTop();
            if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
              ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
            }
          }
          i += 1;
        }
        au(true);
        at(false);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramInt1;
          paramArrayOfInt[1] = paramInt2;
        }
        AppMethodBeat.o(262543);
        return;
      }
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(262748);
    paramBoolean = getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(262748);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(262749);
    boolean bool = getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(262749);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(262746);
    boolean bool = getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(262746);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(262742);
    boolean bool = getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(262742);
    return bool;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(262502);
    dispatchThawSelfOnly(paramSparseArray);
    AppMethodBeat.o(262502);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(262500);
    dispatchFreezeSelfOnly(paramSparseArray);
    AppMethodBeat.o(262500);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    AppMethodBeat.i(262671);
    super.draw(paramCanvas);
    int j = this.ajZ.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.ajZ.get(i)).b(paramCanvas, this, this.akL);
      i += 1;
    }
    int n;
    if ((this.akt != null) && (!this.akt.isFinished()))
    {
      n = paramCanvas.save();
      if (this.ajU)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.akt == null) || (!this.akt.draw(paramCanvas))) {
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
      if (this.aku != null)
      {
        i = j;
        if (!this.aku.isFinished())
        {
          n = paramCanvas.save();
          if (this.ajU) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.aku == null) || (!this.aku.draw(paramCanvas))) {
            break label473;
          }
          i = 1;
          label208:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.akv != null)
      {
        j = i;
        if (!this.akv.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.ajU) {
            break label478;
          }
          j = getPaddingTop();
          label263:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.akv == null) || (!this.akv.draw(paramCanvas))) {
            break label483;
          }
          j = 1;
          label301:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.akw != null)
      {
        i = j;
        if (!this.akw.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.ajU) {
            break label488;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label378:
          i = m;
          if (this.akw != null)
          {
            i = m;
            if (this.akw.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.akx != null) && (this.ajZ.size() > 0) && (this.akx.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          androidx.core.g.w.G(this);
        }
        AppMethodBeat.o(262671);
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
    AppMethodBeat.i(262704);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(262704);
    return bool;
  }
  
  final void e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(262683);
    int j = this.mChildHelper.kj();
    int i = 0;
    if (i < j)
    {
      localObject = bg(this.mChildHelper.cq(i));
      if ((localObject != null) && (!((v)localObject).mb()))
      {
        if (((v)localObject).mPosition < paramInt1 + paramInt2) {
          break label88;
        }
        ((v)localObject).k(-paramInt2, paramBoolean);
        this.akL.alV = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label88:
        if (((v)localObject).mPosition >= paramInt1)
        {
          int k = -paramInt2;
          ((v)localObject).cY(8);
          ((v)localObject).k(k, paramBoolean);
          ((v)localObject).mPosition = (paramInt1 - 1);
          this.akL.alV = true;
        }
      }
    }
    Object localObject = this.ajQ;
    i = ((n)localObject).alz.size() - 1;
    if (i >= 0)
    {
      v localv = (v)((n)localObject).alz.get(i);
      if (localv != null)
      {
        if (localv.mPosition < paramInt1 + paramInt2) {
          break label206;
        }
        localv.k(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label206:
        if (localv.mPosition >= paramInt1)
        {
          localv.cY(8);
          ((n)localObject).cT(i);
        }
      }
    }
    requestLayout();
    AppMethodBeat.o(262683);
  }
  
  public final View findContainingItemView(View paramView)
  {
    AppMethodBeat.i(262689);
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this)
    {
      AppMethodBeat.o(262689);
      return paramView;
    }
    AppMethodBeat.o(262689);
    return null;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int i1 = -1;
    int n = 0;
    AppMethodBeat.i(262589);
    Object localObject = this.ajX.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null)
    {
      AppMethodBeat.o(262589);
      return localObject;
    }
    int i;
    label105:
    int k;
    if ((this.afJ != null) && (this.ajX != null) && (!lq()) && (!this.aki))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label369;
      }
      if (!this.ajX.canScrollVertically()) {
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
      if (ajM) {
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
        if (this.ajX.canScrollHorizontally())
        {
          if (this.ajX.getLayoutDirection() != 1) {
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
        if (ajM)
        {
          k = i;
          m = j;
        }
        if (m == 0) {
          break label322;
        }
        lb();
        if (findContainingItemView(paramView) != null) {
          break label294;
        }
        AppMethodBeat.o(262589);
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
      lc();
      this.ajX.onFocusSearchFailed(paramView, k, this.ajQ, this.akL);
      at(false);
      label322:
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
      while ((localObject != null) && (!((View)localObject).hasFocusable())) {
        if (getFocusedChild() == null)
        {
          paramView = super.focusSearch(paramView, k);
          AppMethodBeat.o(262589);
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
              lb();
              if (findContainingItemView(paramView) == null)
              {
                AppMethodBeat.o(262589);
                return null;
              }
              lc();
              localObject = this.ajX.onFocusSearchFailed(paramView, paramInt, this.ajQ, this.akL);
              at(false);
              k = paramInt;
            }
          }
        }
        else
        {
          e((View)localObject, null);
          AppMethodBeat.o(262589);
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
          AppMethodBeat.o(262589);
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
              this.gD.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              offsetDescendantRectToMyCoords(paramView, this.mTempRect);
              offsetDescendantRectToMyCoords((View)localObject, this.gD);
              if (this.ajX.getLayoutDirection() == 1)
              {
                m = -1;
                label604:
                if (((this.mTempRect.left >= this.gD.left) && (this.mTempRect.right > this.gD.left)) || (this.mTempRect.right >= this.gD.right)) {
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
        if (((this.mTempRect.top < this.gD.top) || (this.mTempRect.bottom <= this.gD.top)) && (this.mTempRect.bottom < this.gD.bottom)) {
          j = 1;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            paramView = new IllegalArgumentException("Invalid direction: " + k + kY());
            AppMethodBeat.o(262589);
            throw paramView;
            m = 1;
            break label604;
            label819:
            if (((this.mTempRect.right <= this.gD.right) && (this.mTempRect.left < this.gD.right)) || (this.mTempRect.left <= this.gD.left)) {
              break label1058;
            }
            i = -1;
            break label657;
            if ((this.mTempRect.bottom > this.gD.bottom) || (this.mTempRect.top >= this.gD.bottom))
            {
              j = i1;
              if (this.mTempRect.top > this.gD.top) {}
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
        AppMethodBeat.o(262589);
        return paramView;
        i = 0;
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(262676);
    if (this.ajX == null)
    {
      localObject = new IllegalStateException("RecyclerView has no LayoutManager" + kY());
      AppMethodBeat.o(262676);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ajX.generateDefaultLayoutParams();
    AppMethodBeat.o(262676);
    return localObject;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(262678);
    if (this.ajX == null)
    {
      paramAttributeSet = new IllegalStateException("RecyclerView has no LayoutManager" + kY());
      AppMethodBeat.o(262678);
      throw paramAttributeSet;
    }
    paramAttributeSet = this.ajX.generateLayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(262678);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(262679);
    if (this.ajX == null)
    {
      paramLayoutParams = new IllegalStateException("RecyclerView has no LayoutManager" + kY());
      AppMethodBeat.o(262679);
      throw paramLayoutParams;
    }
    paramLayoutParams = this.ajX.generateLayoutParams(paramLayoutParams);
    AppMethodBeat.o(262679);
    return paramLayoutParams;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.afJ;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(262486);
    if (this.ajX != null)
    {
      i = this.ajX.getBaseline();
      AppMethodBeat.o(262486);
      return i;
    }
    int i = super.getBaseline();
    AppMethodBeat.o(262486);
    return i;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262751);
    if (this.aij == null)
    {
      paramInt1 = super.getChildDrawingOrder(paramInt1, paramInt2);
      AppMethodBeat.o(262751);
      return paramInt1;
    }
    paramInt1 = this.aij.ap(paramInt1, paramInt2);
    AppMethodBeat.o(262751);
    return paramInt1;
  }
  
  public boolean getClipToPadding()
  {
    return this.ajU;
  }
  
  public w getCompatAccessibilityDelegate()
  {
    return this.akS;
  }
  
  public RecyclerView.e getEdgeEffectFactory()
  {
    return this.aks;
  }
  
  public f getItemAnimator()
  {
    return this.akx;
  }
  
  public int getItemDecorationCount()
  {
    AppMethodBeat.i(262524);
    int i = this.ajZ.size();
    AppMethodBeat.o(262524);
    return i;
  }
  
  public LayoutManager getLayoutManager()
  {
    return this.ajX;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.akE;
  }
  
  public int getMinFlingVelocity()
  {
    return this.vZ;
  }
  
  long getNanoTime()
  {
    AppMethodBeat.i(262720);
    if (ajL)
    {
      long l = System.nanoTime();
      AppMethodBeat.o(262720);
      return l;
    }
    AppMethodBeat.o(262720);
    return 0L;
  }
  
  public RecyclerView.j getOnFlingListener()
  {
    return this.akD;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.akH;
  }
  
  public m getRecycledViewPool()
  {
    AppMethodBeat.i(262508);
    m localm = this.ajQ.getRecycledViewPool();
    AppMethodBeat.o(262508);
    return localm;
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  n getScrollingChildHelper()
  {
    AppMethodBeat.i(262753);
    if (this.akU == null) {
      this.akU = new n(this);
    }
    n localn = this.akU;
    AppMethodBeat.o(262753);
    return localn;
  }
  
  public final View h(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(262703);
    int i = this.mChildHelper.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2))
      {
        AppMethodBeat.o(262703);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(262703);
    return null;
  }
  
  final void h(v paramv)
  {
    AppMethodBeat.i(262504);
    View localView = paramv.amk;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.ajQ.x(aQ(localView));
      if (!paramv.mn()) {
        break;
      }
      this.mChildHelper.a(localView, -1, localView.getLayoutParams(), true);
      AppMethodBeat.o(262504);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.b(localView, -1, true);
      AppMethodBeat.o(262504);
      return;
    }
    paramv = this.mChildHelper;
    i = paramv.afT.aO(localView);
    if (i < 0)
    {
      paramv = new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localView)));
      AppMethodBeat.o(262504);
      throw paramv;
    }
    paramv.afU.set(i);
    paramv.aM(localView);
    AppMethodBeat.o(262504);
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(262741);
    boolean bool = getScrollingChildHelper().bx(0);
    AppMethodBeat.o(262741);
    return bool;
  }
  
  public final v i(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(262701);
    int j = this.mChildHelper.kj();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      v localv = bg(this.mChildHelper.cq(i));
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
        if (localv.mc() == paramInt)
        {
          label101:
          if (!this.mChildHelper.aP(localv.amk)) {
            break label123;
          }
          localObject2 = localv;
        }
      }
      label123:
      AppMethodBeat.o(262701);
      return localv;
    }
    AppMethodBeat.o(262701);
    return localObject1;
  }
  
  public boolean isAttachedToWindow()
  {
    return this.akc;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(262734);
    boolean bool = getScrollingChildHelper().Np;
    AppMethodBeat.o(262734);
    return bool;
  }
  
  final int k(v paramv)
  {
    AppMethodBeat.i(262731);
    if ((paramv.cX(524)) || (!paramv.isBound()))
    {
      AppMethodBeat.o(262731);
      return -1;
    }
    int i = this.ajS.cn(paramv.mPosition);
    AppMethodBeat.o(262731);
    return i;
  }
  
  public final v k(long paramLong)
  {
    AppMethodBeat.i(262702);
    if ((this.afJ == null) || (!this.afJ.ald))
    {
      AppMethodBeat.o(262702);
      return null;
    }
    int j = this.mChildHelper.kj();
    int i = 0;
    Object localObject = null;
    v localv;
    if (i < j)
    {
      localv = bg(this.mChildHelper.cq(i));
      if ((localv == null) || (localv.isRemoved()) || (localv.amn != paramLong)) {
        break label131;
      }
      if (this.mChildHelper.aP(localv.amk)) {
        localObject = localv;
      }
    }
    label131:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(262702);
      return localv;
      AppMethodBeat.o(262702);
      return localObject;
    }
  }
  
  final String kY()
  {
    AppMethodBeat.i(262475);
    String str = " " + super.toString() + ", adapter:" + this.afJ + ", layout:" + this.ajX + ", context:" + getContext();
    AppMethodBeat.o(262475);
    return str;
  }
  
  final void kZ()
  {
    AppMethodBeat.i(262484);
    if (this.akx != null) {
      this.akx.kn();
    }
    if (this.ajX != null)
    {
      this.ajX.removeAndRecycleAllViews(this.ajQ);
      this.ajX.removeAndRecycleScrapInt(this.ajQ);
    }
    this.ajQ.clear();
    AppMethodBeat.o(262484);
  }
  
  public void lB()
  {
    int j = 0;
    AppMethodBeat.i(262669);
    int k = this.mChildHelper.kj();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.mChildHelper.cq(i).getLayoutParams()).alp = true;
      i += 1;
    }
    n localn = this.ajQ;
    k = localn.alz.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((v)localn.alz.get(i)).amk.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.alp = true;
      }
      i += 1;
    }
    AppMethodBeat.o(262669);
  }
  
  public final void lF()
  {
    AppMethodBeat.i(262687);
    if (this.ajZ.size() == 0)
    {
      AppMethodBeat.o(262687);
      return;
    }
    if (this.ajX != null) {
      this.ajX.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    lB();
    requestLayout();
    AppMethodBeat.o(262687);
  }
  
  public final boolean lG()
  {
    AppMethodBeat.i(262712);
    if ((!this.akf) || (this.ako) || (this.ajS.ke()))
    {
      AppMethodBeat.o(262712);
      return true;
    }
    AppMethodBeat.o(262712);
    return false;
  }
  
  public final void la()
  {
    AppMethodBeat.i(262526);
    int i = getItemDecorationCount();
    if (i <= 0)
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
      AppMethodBeat.o(262526);
      throw localIndexOutOfBoundsException;
    }
    c(cH(0));
    AppMethodBeat.o(262526);
  }
  
  final void lb()
  {
    int k = 0;
    AppMethodBeat.i(262545);
    if ((!this.akf) || (this.ako))
    {
      androidx.core.c.d.D("RV FullInvalidate");
      lu();
      androidx.core.c.d.gH();
      AppMethodBeat.o(262545);
      return;
    }
    if (!this.ajS.ke())
    {
      AppMethodBeat.o(262545);
      return;
    }
    if ((this.ajS.cl(4)) && (!this.ajS.cl(11)))
    {
      androidx.core.c.d.D("RV PartialInvalidate");
      lc();
      ln();
      this.ajS.kc();
      int i;
      if (!this.akh)
      {
        int m = this.mChildHelper.getChildCount();
        i = 0;
        int j = k;
        if (i < m)
        {
          v localv = bg(this.mChildHelper.getChildAt(i));
          if ((localv == null) || (localv.mb()) || (!localv.mt())) {
            break label193;
          }
          j = 1;
        }
        if (j == 0) {
          break label200;
        }
        lu();
      }
      for (;;)
      {
        at(true);
        au(true);
        androidx.core.c.d.gH();
        AppMethodBeat.o(262545);
        return;
        label193:
        i += 1;
        break;
        label200:
        this.ajS.kd();
      }
    }
    if (this.ajS.ke())
    {
      androidx.core.c.d.D("RV FullInvalidate");
      lu();
      androidx.core.c.d.gH();
    }
    AppMethodBeat.o(262545);
  }
  
  final void lc()
  {
    this.akg += 1;
    if ((this.akg == 1) && (!this.aki)) {
      this.akh = false;
    }
  }
  
  public void ld()
  {
    AppMethodBeat.i(262569);
    setScrollState(0);
    le();
    AppMethodBeat.o(262569);
  }
  
  final void ln()
  {
    this.akq += 1;
  }
  
  final boolean lo()
  {
    AppMethodBeat.i(262635);
    if ((this.akm != null) && (this.akm.isEnabled()))
    {
      AppMethodBeat.o(262635);
      return true;
    }
    AppMethodBeat.o(262635);
    return false;
  }
  
  public final boolean lq()
  {
    return this.akq > 0;
  }
  
  final void lr()
  {
    AppMethodBeat.i(262642);
    if ((!this.akR) && (this.akc))
    {
      androidx.core.g.w.a(this, this.akY);
      this.akR = true;
    }
    AppMethodBeat.o(262642);
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool = true;
    AppMethodBeat.i(262600);
    super.onAttachedToWindow();
    this.akq = 0;
    this.akc = true;
    float f;
    if ((this.akf) && (!isLayoutRequested()))
    {
      this.akf = bool;
      if (this.ajX != null) {
        this.ajX.dispatchAttachedToWindow(this);
      }
      this.akR = false;
      if (ajL)
      {
        this.akJ = ((k)k.ahr.get());
        if (this.akJ == null)
        {
          this.akJ = new k();
          Display localDisplay = androidx.core.g.w.an(this);
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
      this.akJ.ahu = ((1.0E+009F / f));
      k.ahr.set(this.akJ);
      this.akJ.ahs.add(this);
      AppMethodBeat.o(262600);
      return;
      bool = false;
      break;
      label174:
      f = 60.0F;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(262603);
    super.onDetachedFromWindow();
    if (this.akx != null) {
      this.akx.kn();
    }
    ld();
    this.akc = false;
    if (this.ajX != null) {
      this.ajX.dispatchDetachedFromWindow(this, this.ajQ);
    }
    this.akX.clear();
    removeCallbacks(this.akY);
    ab.a.mR();
    if ((ajL) && (this.akJ != null))
    {
      this.akJ.ahs.remove(this);
      this.akJ = null;
    }
    AppMethodBeat.o(262603);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(262673);
    super.onDraw(paramCanvas);
    int j = this.ajZ.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.h)this.ajZ.get(i)).a(paramCanvas, this, this.akL);
      i += 1;
    }
    AppMethodBeat.o(262673);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(262625);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262625);
      return false;
    }
    if (this.aki)
    {
      AppMethodBeat.o(262625);
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
      if (!this.ajX.canScrollVertically()) {
        break label135;
      }
      f1 = -paramMotionEvent.getAxisValue(9);
      if (!this.ajX.canScrollHorizontally()) {
        break label140;
      }
      f3 = paramMotionEvent.getAxisValue(10);
      f2 = f1;
      f1 = f3;
    }
    for (;;)
    {
      if ((f2 != 0.0F) || (f1 != 0.0F)) {
        a((int)(this.akF * f1), (int)(this.akG * f2), paramMotionEvent);
      }
      AppMethodBeat.o(262625);
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
        if (this.ajX.canScrollVertically())
        {
          f2 = -f1;
          f1 = 0.0F;
        }
        else if (this.ajX.canScrollHorizontally())
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
    AppMethodBeat.i(262611);
    if (this.aki)
    {
      AppMethodBeat.o(262611);
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.akb = null;
    }
    int k = this.aka.size();
    int i = 0;
    if (i < k)
    {
      k localk = (k)this.aka.get(i);
      if ((localk.a(this, paramMotionEvent)) && (j != 3)) {
        this.akb = localk;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label123;
      }
      lm();
      AppMethodBeat.o(262611);
      return true;
      i += 1;
      break;
    }
    label123:
    if (this.ajX == null)
    {
      AppMethodBeat.o(262611);
      return false;
    }
    boolean bool1 = this.ajX.canScrollHorizontally();
    boolean bool2 = this.ajX.canScrollVertically();
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
        AppMethodBeat.o(262611);
        return true;
      }
      break;
    case 0: 
      if (this.akj) {
        this.akj = false;
      }
      this.aky = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.akB = i;
      this.akz = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.akC = i;
      this.akA = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.akV;
      this.akV[1] = 0;
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
      E(j, 0);
      break;
      this.aky = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.akB = j;
      this.akz = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.akC = i;
      this.akA = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.aky);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.aky).append(" not found. Did any MotionEvents get skipped?");
        AppMethodBeat.o(262611);
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.akz;
      int m = this.akA;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.akB = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.akC = k;
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
        bw(0);
        break;
        lm();
        break;
        AppMethodBeat.o(262611);
        return false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(262667);
    androidx.core.c.d.D("RV OnLayout");
    lu();
    androidx.core.c.d.gH();
    this.akf = true;
    AppMethodBeat.o(262667);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(262628);
    if (this.ajX == null)
    {
      aB(paramInt1, paramInt2);
      AppMethodBeat.o(262628);
      return;
    }
    if (this.ajX.isAutoMeasureEnabled())
    {
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      this.ajX.onMeasure(this.ajQ, this.akL, paramInt1, paramInt2);
      int i = j;
      if (k == 1073741824)
      {
        i = j;
        if (m == 1073741824) {
          i = 1;
        }
      }
      if ((i != 0) || (this.afJ == null))
      {
        AppMethodBeat.o(262628);
        return;
      }
      if (this.akL.alT == 1) {
        ly();
      }
      this.ajX.setMeasureSpecs(paramInt1, paramInt2);
      this.akL.alY = true;
      lz();
      this.ajX.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      if (this.ajX.shouldMeasureTwice())
      {
        this.ajX.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.akL.alY = true;
        lz();
        this.ajX.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      }
      AppMethodBeat.o(262628);
      return;
    }
    if (this.akd)
    {
      this.ajX.onMeasure(this.ajQ, this.akL, paramInt1, paramInt2);
      AppMethodBeat.o(262628);
      return;
    }
    if (this.akl)
    {
      lc();
      ln();
      lt();
      au(true);
      if (this.akL.ama)
      {
        this.akL.alW = true;
        this.akl = false;
        at(false);
        label303:
        if (this.afJ == null) {
          break label412;
        }
      }
    }
    label412:
    for (this.akL.alU = this.afJ.getItemCount();; this.akL.alU = 0)
    {
      lc();
      this.ajX.onMeasure(this.ajQ, this.akL, paramInt1, paramInt2);
      at(false);
      this.akL.alW = false;
      AppMethodBeat.o(262628);
      return;
      this.ajS.kf();
      this.akL.alW = false;
      break;
      if (!this.akL.ama) {
        break label303;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      AppMethodBeat.o(262628);
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(262597);
    if (lq())
    {
      AppMethodBeat.o(262597);
      return false;
    }
    boolean bool = super.onRequestFocusInDescendants(paramInt, paramRect);
    AppMethodBeat.o(262597);
    return bool;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(262496);
    if (!(paramParcelable instanceof RecyclerView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(262496);
      return;
    }
    this.ajR = ((RecyclerView.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.ajR.Rb);
    if ((this.ajX != null) && (this.ajR.alF != null)) {
      this.ajX.onRestoreInstanceState(this.ajR.alF);
    }
    AppMethodBeat.o(262496);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(262493);
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.ajR != null) {
      localSavedState.alF = this.ajR.alF;
    }
    for (;;)
    {
      AppMethodBeat.o(262493);
      return localSavedState;
      if (this.ajX != null) {
        localSavedState.alF = this.ajX.onSaveInstanceState();
      } else {
        localSavedState.alF = null;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(262630);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      lk();
    }
    AppMethodBeat.o(262630);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    AppMethodBeat.i(262620);
    if ((this.aki) || (this.akj))
    {
      AppMethodBeat.o(262620);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (this.akb != null)
    {
      if (i == 0) {
        this.akb = null;
      }
    }
    else
    {
      if (i == 0) {
        break label173;
      }
      j = this.aka.size();
      i = 0;
      if (i >= j) {
        break label173;
      }
      localObject = (k)this.aka.get(i);
      if (!((k)localObject).a(this, paramMotionEvent)) {
        break label164;
      }
      this.akb = ((k)localObject);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label179;
      }
      lm();
      AppMethodBeat.o(262620);
      return true;
      this.akb.b(this, paramMotionEvent);
      if ((i == 3) || (i == 1)) {
        this.akb = null;
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
    if (this.ajX == null)
    {
      AppMethodBeat.o(262620);
      return false;
    }
    boolean bool1 = this.ajX.canScrollHorizontally();
    boolean bool2 = this.ajX.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.akV;
      this.akV[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.akV[0], this.akV[1]);
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
      AppMethodBeat.o(262620);
      return true;
    case 0: 
      this.aky = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.akB = i;
      this.akz = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.akC = i;
      this.akA = i;
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
      E(j, 0);
      i = i2;
      break;
      this.aky = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.akB = i;
      this.akz = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.akC = i;
      this.akA = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.aky);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.aky).append(" not found. Did any MotionEvents get skipped?");
        AppMethodBeat.o(262620);
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.akB - i3;
      k = this.akC - i4;
      j = m;
      i = k;
      if (a(m, k, this.Qs, this.Qr, 0))
      {
        j = m - this.Qs[0];
        i = k - this.Qs[1];
        ((MotionEvent)localObject).offsetLocation(this.Qr[0], this.Qr[1]);
        paramMotionEvent = this.akV;
        paramMotionEvent[0] += this.Qr[0];
        paramMotionEvent = this.akV;
        paramMotionEvent[1] += this.Qr[1];
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
        this.akB = (i3 - this.Qr[0]);
        this.akC = (i4 - this.Qr[1]);
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
          if (this.akJ == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.akJ.a(this, k, m);
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
        this.mVelocityTracker.computeCurrentVelocity(1000, this.akE);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.aky);
          if (!bool2) {
            break label1127;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.aky);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!ay((int)f1, (int)f2))) {
            setScrollState(0);
          }
          ll();
          i = 1;
          break;
          f1 = 0.0F;
          break label1066;
        }
        lm();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(262665);
    v localv = bg(paramView);
    if (localv != null)
    {
      if (!localv.mn()) {
        break label48;
      }
      localv.ml();
    }
    label48:
    while (localv.mb())
    {
      paramView.clearAnimation();
      bl(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      AppMethodBeat.o(262665);
      return;
    }
    paramView = new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv + kY());
    AppMethodBeat.o(262665);
    throw paramView;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    AppMethodBeat.i(262591);
    if ((!this.ajX.onRequestChildFocus(this, this.akL, paramView1, paramView2)) && (paramView2 != null)) {
      e(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
    AppMethodBeat.o(262591);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(262594);
    paramBoolean = this.ajX.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
    AppMethodBeat.o(262594);
    return paramBoolean;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(262612);
    int j = this.aka.size();
    int i = 0;
    while (i < j)
    {
      ((k)this.aka.get(i)).ao(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(262612);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(262668);
    if ((this.akg == 0) && (!this.aki))
    {
      super.requestLayout();
      AppMethodBeat.o(262668);
      return;
    }
    this.akh = true;
    AppMethodBeat.o(262668);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262539);
    if (this.ajX == null)
    {
      AppMethodBeat.o(262539);
      return;
    }
    if (this.aki)
    {
      AppMethodBeat.o(262539);
      return;
    }
    boolean bool1 = this.ajX.canScrollHorizontally();
    boolean bool2 = this.ajX.canScrollVertically();
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
      AppMethodBeat.o(262539);
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
    AppMethodBeat.i(262533);
    if (this.aki)
    {
      AppMethodBeat.o(262533);
      return;
    }
    ld();
    if (this.ajX == null)
    {
      AppMethodBeat.o(262533);
      return;
    }
    LayoutManager localLayoutManager = this.ajX;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aFh(), "androidx/recyclerview/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "androidx/recyclerview/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    awakenScrollBars();
    AppMethodBeat.o(262533);
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(262640);
    if (lq())
    {
      if (paramAccessibilityEvent == null) {
        break label83;
      }
      if (Build.VERSION.SDK_INT < 19) {
        break label63;
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
        this.akk |= i;
        i = 1;
        if (i != 0)
        {
          AppMethodBeat.o(262640);
          return;
          label63:
          i = 0;
          break;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        AppMethodBeat.o(262640);
        return;
      }
      label83:
      i = 0;
    }
  }
  
  public void setAccessibilityDelegateCompat(w paramw)
  {
    AppMethodBeat.i(262477);
    this.akS = paramw;
    androidx.core.g.w.a(this, this.akS);
    AppMethodBeat.o(262477);
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    AppMethodBeat.i(262483);
    setLayoutFrozen(false);
    if (this.afJ != null)
    {
      this.afJ.b(this.ajP);
      this.afJ.e(this);
    }
    kZ();
    this.ajS.reset();
    RecyclerView.a locala = this.afJ;
    this.afJ = parama;
    if (parama != null)
    {
      parama.a(this.ajP);
      parama.d(this);
    }
    if (this.ajX != null) {
      this.ajX.onAdapterChanged(locala, this.afJ);
    }
    Object localObject = this.ajQ;
    parama = this.afJ;
    ((n)localObject).clear();
    localObject = ((n)localObject).getRecycledViewPool();
    if (locala != null) {
      ((m)localObject).detach();
    }
    if (((m)localObject).als == 0) {
      ((m)localObject).clear();
    }
    if (parama != null) {
      ((m)localObject).lT();
    }
    this.akL.alV = true;
    av(false);
    requestLayout();
    AppMethodBeat.o(262483);
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    AppMethodBeat.i(262530);
    if (paramd == this.aij)
    {
      AppMethodBeat.o(262530);
      return;
    }
    this.aij = paramd;
    if (this.aij != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      AppMethodBeat.o(262530);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(262479);
    if (paramBoolean != this.ajU) {
      lk();
    }
    this.ajU = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.akf) {
      requestLayout();
    }
    AppMethodBeat.o(262479);
  }
  
  public void setEdgeEffectFactory(RecyclerView.e parame)
  {
    AppMethodBeat.i(262584);
    androidx.core.f.g.checkNotNull(parame);
    this.aks = parame;
    lk();
    AppMethodBeat.o(262584);
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.akd = paramBoolean;
  }
  
  public void setItemAnimator(f paramf)
  {
    AppMethodBeat.i(262631);
    if (this.akx != null)
    {
      this.akx.kn();
      this.akx.ale = null;
    }
    this.akx = paramf;
    if (this.akx != null) {
      this.akx.ale = this.akQ;
    }
    AppMethodBeat.o(262631);
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    AppMethodBeat.i(262513);
    n localn = this.ajQ;
    localn.alB = paramInt;
    localn.lU();
    AppMethodBeat.o(262513);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(262563);
    if (paramBoolean != this.aki)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.aki = false;
        if ((this.akh) && (this.ajX != null) && (this.afJ != null)) {
          requestLayout();
        }
        this.akh = false;
        AppMethodBeat.o(262563);
        return;
      }
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      this.aki = true;
      this.akj = true;
      ld();
    }
    AppMethodBeat.o(262563);
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(262489);
    if (paramLayoutManager == this.ajX)
    {
      AppMethodBeat.o(262489);
      return;
    }
    ld();
    if (this.ajX != null)
    {
      if (this.akx != null) {
        this.akx.kn();
      }
      this.ajX.removeAndRecycleAllViews(this.ajQ);
      this.ajX.removeAndRecycleScrapInt(this.ajQ);
      this.ajQ.clear();
      if (this.akc) {
        this.ajX.dispatchDetachedFromWindow(this, this.ajQ);
      }
      this.ajX.setRecyclerView(null);
      this.ajX = null;
    }
    f localf;
    for (;;)
    {
      localf = this.mChildHelper;
      for (f.a locala = localf.afU;; locala = locala.afX)
      {
        locala.afW = 0L;
        if (locala.afX == null) {
          break;
        }
      }
      this.ajQ.clear();
    }
    int i = localf.afV.size() - 1;
    while (i >= 0)
    {
      localf.afT.aS((View)localf.afV.get(i));
      localf.afV.remove(i);
      i -= 1;
    }
    localf.afT.removeAllViews();
    this.ajX = paramLayoutManager;
    if (paramLayoutManager != null)
    {
      if (paramLayoutManager.mRecyclerView != null)
      {
        paramLayoutManager = new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView:" + paramLayoutManager.mRecyclerView.kY());
        AppMethodBeat.o(262489);
        throw paramLayoutManager;
      }
      this.ajX.setRecyclerView(this);
      if (this.akc) {
        this.ajX.dispatchAttachedToWindow(this);
      }
    }
    this.ajQ.lU();
    requestLayout();
    AppMethodBeat.o(262489);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(262732);
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(262732);
  }
  
  public void setOnFlingListener(RecyclerView.j paramj)
  {
    this.akD = paramj;
  }
  
  @Deprecated
  public void setOnScrollListener(RecyclerView.l paraml)
  {
    this.akM = paraml;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.akH = paramBoolean;
  }
  
  public void setRecycledViewPool(m paramm)
  {
    AppMethodBeat.i(262511);
    n localn = this.ajQ;
    if (localn.alD != null) {
      localn.alD.detach();
    }
    localn.alD = paramm;
    if ((localn.alD != null) && (localn.alb.getAdapter() != null)) {
      localn.alD.lT();
    }
    AppMethodBeat.o(262511);
  }
  
  public void setRecyclerListener(o paramo)
  {
    this.ajY = paramo;
  }
  
  void setScrollState(int paramInt)
  {
    AppMethodBeat.i(262516);
    if (paramInt == this.mScrollState)
    {
      AppMethodBeat.o(262516);
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      le();
    }
    if (this.ajX != null) {
      this.ajX.onScrollStateChanged(paramInt);
    }
    if (this.akM != null) {
      this.akM.onScrollStateChanged(this, paramInt);
    }
    if (this.akN != null)
    {
      int i = this.akN.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.l)this.akN.get(i)).onScrollStateChanged(this, paramInt);
        i -= 1;
      }
    }
    AppMethodBeat.o(262516);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    AppMethodBeat.i(262480);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      new StringBuilder("setScrollingTouchSlop(): bad argument constant ").append(paramInt).append("; using default value");
    case 0: 
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      AppMethodBeat.o(262480);
      return;
    }
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
    AppMethodBeat.o(262480);
  }
  
  public void setViewCacheExtension(RecyclerView.t paramt)
  {
    this.ajQ.alE = paramt;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(262536);
    if (this.aki)
    {
      AppMethodBeat.o(262536);
      return;
    }
    if (this.ajX == null)
    {
      AppMethodBeat.o(262536);
      return;
    }
    this.ajX.smoothScrollToPosition(this, this.akL, paramInt);
    AppMethodBeat.o(262536);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(262735);
    boolean bool = getScrollingChildHelper().E(paramInt, 0);
    AppMethodBeat.o(262735);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(262737);
    getScrollingChildHelper().bw(0);
    AppMethodBeat.o(262737);
  }
  
  public static abstract class LayoutManager
  {
    boolean mAutoMeasure = false;
    f mChildHelper;
    private int mHeight;
    private int mHeightMode;
    aa mHorizontalBoundCheck = new aa(this.mHorizontalBoundCheckCallback);
    private final aa.b mHorizontalBoundCheckCallback = new aa.b()
    {
      public final int bm(View paramAnonymousView)
      {
        AppMethodBeat.i(262137);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedLeft(paramAnonymousView);
        int j = localLayoutParams.leftMargin;
        AppMethodBeat.o(262137);
        return i - j;
      }
      
      public final int bn(View paramAnonymousView)
      {
        AppMethodBeat.i(262138);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedRight(paramAnonymousView);
        int j = localLayoutParams.rightMargin;
        AppMethodBeat.o(262138);
        return j + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        AppMethodBeat.i(262134);
        View localView = RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
        AppMethodBeat.o(262134);
        return localView;
      }
      
      public final int lP()
      {
        AppMethodBeat.i(262135);
        int i = RecyclerView.LayoutManager.this.getPaddingLeft();
        AppMethodBeat.o(262135);
        return i;
      }
      
      public final int lQ()
      {
        AppMethodBeat.i(262136);
        int i = RecyclerView.LayoutManager.this.getWidth();
        int j = RecyclerView.LayoutManager.this.getPaddingRight();
        AppMethodBeat.o(262136);
        return i - j;
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
    aa mVerticalBoundCheck = new aa(this.mVerticalBoundCheckCallback);
    private final aa.b mVerticalBoundCheckCallback = new aa.b()
    {
      public final int bm(View paramAnonymousView)
      {
        AppMethodBeat.i(262144);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedTop(paramAnonymousView);
        int j = localLayoutParams.topMargin;
        AppMethodBeat.o(262144);
        return i - j;
      }
      
      public final int bn(View paramAnonymousView)
      {
        AppMethodBeat.i(262145);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.LayoutManager.this.getDecoratedBottom(paramAnonymousView);
        int j = localLayoutParams.bottomMargin;
        AppMethodBeat.o(262145);
        return j + i;
      }
      
      public final View getChildAt(int paramAnonymousInt)
      {
        AppMethodBeat.i(262141);
        View localView = RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
        AppMethodBeat.o(262141);
        return localView;
      }
      
      public final int lP()
      {
        AppMethodBeat.i(262142);
        int i = RecyclerView.LayoutManager.this.getPaddingTop();
        AppMethodBeat.o(262142);
        return i;
      }
      
      public final int lQ()
      {
        AppMethodBeat.i(262143);
        int i = RecyclerView.LayoutManager.this.getHeight();
        int j = RecyclerView.LayoutManager.this.getPaddingBottom();
        AppMethodBeat.o(262143);
        return i - j;
      }
    };
    private int mWidth;
    private int mWidthMode;
    
    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.v localv = RecyclerView.bg(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localv.isRemoved()))
      {
        this.mRecyclerView.ajT.L(localv);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localv.mj()) && (!localv.mh())) {
          break label128;
        }
        if (!localv.mh()) {
          break label120;
        }
        localv.mi();
        label68:
        this.mChildHelper.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.alq)
        {
          localv.amk.invalidate();
          localLayoutParams.alq = false;
        }
        return;
        this.mRecyclerView.ajT.M(localv);
        break;
        label120:
        localv.mk();
        break label68;
        label128:
        if (paramView.getParent() == this.mRecyclerView)
        {
          int j = this.mChildHelper.aO(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.mChildHelper.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(paramView) + this.mRecyclerView.kY());
          }
          if (j != i) {
            this.mRecyclerView.ajX.moveView(j, i);
          }
        }
        else
        {
          this.mChildHelper.b(paramView, paramInt, false);
          localLayoutParams.alp = true;
          if ((this.mSmoothScroller != null) && (this.mSmoothScroller.Tb))
          {
            RecyclerView.r localr = this.mSmoothScroller;
            if (RecyclerView.bi(paramView) == localr.alG) {
              localr.alI = paramView;
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
      localb.FO = paramContext.getInt(a.c.RecyclerView_android_orientation, 1);
      localb.spanCount = paramContext.getInt(a.c.RecyclerView_spanCount, 1);
      localb.aln = paramContext.getBoolean(a.c.RecyclerView_reverseLayout, false);
      localb.alo = paramContext.getBoolean(a.c.RecyclerView_stackFromEnd, false);
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
      RecyclerView.v localv = RecyclerView.bg(paramView);
      if (localv.mb()) {
        return;
      }
      if ((localv.isInvalid()) && (!localv.isRemoved()) && (!this.mRecyclerView.afJ.ald))
      {
        removeViewAt(paramInt);
        paramn.w(localv);
        return;
      }
      detachViewAt(paramInt);
      paramn.bq(paramView);
      this.mRecyclerView.ajT.M(localv);
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
      RecyclerView.v localv = RecyclerView.bg(paramView);
      if (localv.isRemoved()) {
        this.mRecyclerView.ajT.L(localv);
      }
      for (;;)
      {
        this.mChildHelper.a(paramView, paramInt, paramLayoutParams, localv.isRemoved());
        return;
        this.mRecyclerView.ajT.M(localv);
      }
    }
    
    public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      if (this.mRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.mRecyclerView.bj(paramView));
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
      scrapOrRecycleView(paramn, this.mChildHelper.aO(paramView), paramView);
    }
    
    public void detachAndScrapViewAt(int paramInt, RecyclerView.n paramn)
    {
      scrapOrRecycleView(paramn, paramInt, getChildAt(paramInt));
    }
    
    public void detachView(View paramView)
    {
      int i = this.mChildHelper.aO(paramView);
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
      if (this.mRecyclerView.akx != null) {
        this.mRecyclerView.akx.c(RecyclerView.bg(paramView));
      }
    }
    
    public View findContainingItemView(View paramView)
    {
      if (this.mRecyclerView == null) {}
      do
      {
        return null;
        paramView = this.mRecyclerView.findContainingItemView(paramView);
      } while ((paramView == null) || (this.mChildHelper.aP(paramView)));
      return paramView;
    }
    
    public View findViewByPosition(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.v localv = RecyclerView.bg(localView);
        if ((localv != null) && (localv.mc() == paramInt) && (!localv.mb()) && ((this.mRecyclerView.akL.alW) || (!localv.isRemoved()))) {
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL.bottom;
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
      return (this.mRecyclerView != null) && (this.mRecyclerView.ajU);
    }
    
    public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.afJ == null)) {}
      while (!canScrollHorizontally()) {
        return 1;
      }
      return this.mRecyclerView.afJ.getItemCount();
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
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL;
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
      } while ((localView == null) || (this.mChildHelper.aP(localView)));
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
      return RecyclerView.bg(paramView).amo;
    }
    
    public int getLayoutDirection()
    {
      return androidx.core.g.w.I(this.mRecyclerView);
    }
    
    public int getLeftDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL.left;
    }
    
    public int getMinimumHeight()
    {
      return androidx.core.g.w.P(this.mRecyclerView);
    }
    
    public int getMinimumWidth()
    {
      return androidx.core.g.w.O(this.mRecyclerView);
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
        return androidx.core.g.w.M(this.mRecyclerView);
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
        return androidx.core.g.w.L(this.mRecyclerView);
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
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aiC.mc();
    }
    
    public int getRightDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL.right;
    }
    
    public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      if ((this.mRecyclerView == null) || (this.mRecyclerView.afJ == null)) {}
      while (!canScrollVertically()) {
        return 1;
      }
      return this.mRecyclerView.afJ.getItemCount();
    }
    
    public int getSelectionModeForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
    {
      return 0;
    }
    
    public int getTopDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL.top;
    }
    
    public void getTransformedBoundingBox(View paramView, boolean paramBoolean, Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL;
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
            RectF localRectF = this.mRecyclerView.ajW;
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
        throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.kY());
      }
      paramView = RecyclerView.bg(paramView);
      paramView.cY(128);
      this.mRecyclerView.ajT.N(paramView);
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
      return (this.mSmoothScroller != null) && (this.mSmoothScroller.Tb);
    }
    
    public boolean isViewPartiallyVisible(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.mHorizontalBoundCheck.bv(paramView)) && (this.mVerticalBoundCheck.bv(paramView))) {}
      for (paramBoolean2 = true; paramBoolean1; paramBoolean2 = false) {
        return paramBoolean2;
      }
      return !paramBoolean2;
    }
    
    public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahL;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.ahL;
      paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public void measureChild(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.bj(paramView);
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
      Rect localRect = this.mRecyclerView.bj(paramView);
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
      onInitializeAccessibilityEvent(this.mRecyclerView.ajQ, this.mRecyclerView.akL, paramAccessibilityEvent);
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
        if (this.mRecyclerView.afJ == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.mRecyclerView.afJ.getItemCount());
        return;
      }
    }
    
    void onInitializeAccessibilityNodeInfo(androidx.core.g.a.d paramd)
    {
      onInitializeAccessibilityNodeInfo(this.mRecyclerView.ajQ, this.mRecyclerView.akL, paramd);
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.n paramn, RecyclerView.s params, androidx.core.g.a.d paramd)
    {
      if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
      {
        paramd.bA(8192);
        paramd.ab(true);
      }
      if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
      {
        paramd.bA(4096);
        paramd.ab(true);
      }
      int i = getRowCountForAccessibility(paramn, params);
      int j = getColumnCountForAccessibility(paramn, params);
      boolean bool = isLayoutHierarchical(paramn, params);
      int k = getSelectionModeForAccessibility(paramn, params);
      if (Build.VERSION.SDK_INT >= 21) {
        paramn = new d.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, bool, k));
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 19) {
          paramd.Ov.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((d.b)paramn).Pq);
        }
        return;
        if (Build.VERSION.SDK_INT >= 19) {
          paramn = new d.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, bool));
        } else {
          paramn = new d.b(null);
        }
      }
    }
    
    void onInitializeAccessibilityNodeInfoForItem(View paramView, androidx.core.g.a.d paramd)
    {
      RecyclerView.v localv = RecyclerView.bg(paramView);
      if ((localv != null) && (!localv.isRemoved()) && (!this.mChildHelper.aP(localv.amk))) {
        onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.ajQ, this.mRecyclerView.akL, paramView, paramd);
      }
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, androidx.core.g.a.d paramd)
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
        paramd.D(d.c.a(i, 1, j, 1, false));
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
      this.mRecyclerView.aB(paramInt1, paramInt2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (isSmoothScrolling()) || (paramRecyclerView.lq());
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
      return performAccessibilityAction(this.mRecyclerView.ajQ, this.mRecyclerView.akL, paramInt, paramBundle);
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
    
    boolean performAccessibilityActionForItem(View paramView, int paramInt, Bundle paramBundle)
    {
      return performAccessibilityActionForItem(this.mRecyclerView.ajQ, this.mRecyclerView.akL, paramView, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityActionForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void postOnAnimation(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null) {
        androidx.core.g.w.a(this.mRecyclerView, paramRunnable);
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
        if (!RecyclerView.bg(getChildAt(i)).mb()) {
          removeAndRecycleViewAt(i, paramn);
        }
        i -= 1;
      }
    }
    
    void removeAndRecycleScrapInt(RecyclerView.n paramn)
    {
      int j = paramn.alx.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.v)paramn.alx.get(i)).amk;
        RecyclerView.v localv = RecyclerView.bg(localView);
        if (!localv.mb())
        {
          localv.ax(false);
          if (localv.mn()) {
            this.mRecyclerView.removeDetachedView(localView, false);
          }
          if (this.mRecyclerView.akx != null) {
            this.mRecyclerView.akx.c(localv);
          }
          localv.ax(true);
          paramn.bp(localView);
        }
        i -= 1;
      }
      paramn.alx.clear();
      if (paramn.aly != null) {
        paramn.aly.clear();
      }
      if (j > 0) {
        this.mRecyclerView.invalidate();
      }
    }
    
    public void removeAndRecycleView(View paramView, RecyclerView.n paramn)
    {
      removeView(paramView);
      paramn.bo(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, RecyclerView.n paramn)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramn.bo(localView);
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
      f localf = this.mChildHelper;
      int i = localf.afT.aO(paramView);
      if (i >= 0)
      {
        if (localf.afU.remove(i)) {
          localf.aN(paramView);
        }
        localf.afT.removeViewAt(i);
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
          this.mRecyclerView.ajQ.lU();
        }
      }
    }
    
    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.mWidthMode = View.MeasureSpec.getMode(paramInt1);
      if ((this.mWidthMode == 0) && (!RecyclerView.ajJ)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.mHeightMode = View.MeasureSpec.getMode(paramInt2);
      if ((this.mHeightMode == 0) && (!RecyclerView.ajJ)) {
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
        this.mRecyclerView.aB(paramInt1, paramInt2);
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
      if ((this.mSmoothScroller != null) && (paramr != this.mSmoothScroller) && (this.mSmoothScroller.Tb)) {
        this.mSmoothScroller.stop();
      }
      this.mSmoothScroller = paramr;
      this.mSmoothScroller.a(this.mRecyclerView, this);
    }
    
    public void stopIgnoringView(View paramView)
    {
      paramView = RecyclerView.bg(paramView);
      paramView.cN &= 0xFFFFFF7F;
      paramView.resetInternal();
      paramView.cY(4);
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
      public abstract void ak(int paramInt1, int paramInt2);
    }
    
    public static class b
    {
      public int FO;
      public boolean aln;
      public boolean alo;
      public int spanCount;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect ahL;
    public RecyclerView.v aiC;
    boolean alp;
    boolean alq;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(262238);
      this.ahL = new Rect();
      this.alp = true;
      this.alq = false;
      AppMethodBeat.o(262238);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(262234);
      this.ahL = new Rect();
      this.alp = true;
      this.alq = false;
      AppMethodBeat.o(262234);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(262241);
      this.ahL = new Rect();
      this.alp = true;
      this.alq = false;
      AppMethodBeat.o(262241);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      AppMethodBeat.i(262239);
      this.ahL = new Rect();
      this.alp = true;
      this.alq = false;
      AppMethodBeat.o(262239);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(262242);
      this.ahL = new Rect();
      this.alp = true;
      this.alq = false;
      AppMethodBeat.o(262242);
    }
    
    public final int lR()
    {
      AppMethodBeat.i(293119);
      int i = this.aiC.mc();
      AppMethodBeat.o(293119);
      return i;
    }
    
    public final int lS()
    {
      AppMethodBeat.i(262245);
      int i = this.aiC.md();
      AppMethodBeat.o(262245);
      return i;
    }
  }
  
  public static abstract interface d
  {
    public abstract int ap(int paramInt1, int paramInt2);
  }
  
  public static abstract class f
  {
    b ale = null;
    private ArrayList<RecyclerView.f.a> alf = new ArrayList();
    public long alg = 120L;
    public long alh = 120L;
    public long ali = 250L;
    public long alj = 250L;
    
    public static RecyclerView.f.c lN()
    {
      return new RecyclerView.f.c();
    }
    
    static int p(RecyclerView.v paramv)
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
            k = paramv.amm;
            m = paramv.md();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    public RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      return new RecyclerView.f.c().e(paramv, 0);
    }
    
    public final boolean a(RecyclerView.f.a parama)
    {
      boolean bool = isRunning();
      if (parama != null)
      {
        if (!bool) {
          parama.lO();
        }
      }
      else {
        return bool;
      }
      this.alf.add(parama);
      return bool;
    }
    
    public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public boolean a(RecyclerView.v paramv, List<Object> paramList)
    {
      return s(paramv);
    }
    
    public abstract void c(RecyclerView.v paramv);
    
    public abstract boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract boolean isRunning();
    
    public abstract void kl();
    
    public abstract void kn();
    
    public final void l(long paramLong)
    {
      this.ali = 0L;
    }
    
    public final long lI()
    {
      return this.ali;
    }
    
    public long lJ()
    {
      return this.alg;
    }
    
    public long lK()
    {
      return this.alh;
    }
    
    public final long lL()
    {
      return this.alj;
    }
    
    public final void lM()
    {
      int j = this.alf.size();
      int i = 0;
      while (i < j)
      {
        ((RecyclerView.f.a)this.alf.get(i)).lO();
        i += 1;
      }
      this.alf.clear();
    }
    
    public final void m(long paramLong)
    {
      this.alh = 2000L;
    }
    
    public final void n(long paramLong)
    {
      this.alj = 0L;
    }
    
    public final void q(RecyclerView.v paramv)
    {
      r(paramv);
      if (this.ale != null) {
        this.ale.r(paramv);
      }
    }
    
    public void r(RecyclerView.v paramv) {}
    
    public boolean s(RecyclerView.v paramv)
    {
      return true;
    }
    
    static abstract interface b
    {
      public abstract void r(RecyclerView.v paramv);
    }
  }
  
  final class g
    implements RecyclerView.f.b
  {
    g() {}
    
    public final void r(RecyclerView.v paramv)
    {
      boolean bool = true;
      AppMethodBeat.i(262133);
      paramv.ax(true);
      if ((paramv.amq != null) && (paramv.amr == null)) {
        paramv.amq = null;
      }
      paramv.amr = null;
      int i;
      RecyclerView localRecyclerView;
      Object localObject;
      f localf;
      if ((paramv.cN & 0x10) != 0)
      {
        i = 1;
        if (i == 0)
        {
          localRecyclerView = RecyclerView.this;
          localObject = paramv.amk;
          localRecyclerView.lc();
          localf = localRecyclerView.mChildHelper;
          i = localf.afT.aO((View)localObject);
          if (i != -1) {
            break label179;
          }
          localf.aN((View)localObject);
          i = 1;
          label104:
          if (i != 0)
          {
            localObject = RecyclerView.bg((View)localObject);
            localRecyclerView.ajQ.x((RecyclerView.v)localObject);
            localRecyclerView.ajQ.w((RecyclerView.v)localObject);
          }
          if (i != 0) {
            break label230;
          }
        }
      }
      for (;;)
      {
        localRecyclerView.at(bool);
        if ((i == 0) && (paramv.mn())) {
          RecyclerView.this.removeDetachedView(paramv.amk, false);
        }
        AppMethodBeat.o(262133);
        return;
        i = 0;
        break;
        label179:
        if (localf.afU.cr(i))
        {
          localf.afU.remove(i);
          localf.aN((View)localObject);
          localf.afT.removeViewAt(i);
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
    public abstract void aT(View paramView);
    
    public abstract void aU(View paramView);
  }
  
  public static abstract interface k
  {
    public abstract boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void ao(boolean paramBoolean);
    
    public abstract void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public static class m
  {
    SparseArray<a> alr;
    int als;
    
    public m()
    {
      AppMethodBeat.i(262260);
      this.alr = new SparseArray();
      this.als = 0;
      AppMethodBeat.o(262260);
    }
    
    static long c(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    public final void aJ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262262);
      Object localObject = cP(paramInt1);
      ((a)localObject).alu = paramInt2;
      localObject = ((a)localObject).alt;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      AppMethodBeat.o(262262);
    }
    
    final boolean b(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(262267);
      long l = cP(paramInt).alv;
      if ((l == 0L) || (l + paramLong1 < paramLong2))
      {
        AppMethodBeat.o(262267);
        return true;
      }
      AppMethodBeat.o(262267);
      return false;
    }
    
    public RecyclerView.v cO(int paramInt)
    {
      AppMethodBeat.i(262263);
      Object localObject = (a)this.alr.get(paramInt);
      if ((localObject != null) && (!((a)localObject).alt.isEmpty()))
      {
        localObject = ((a)localObject).alt;
        localObject = (RecyclerView.v)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
        AppMethodBeat.o(262263);
        return localObject;
      }
      AppMethodBeat.o(262263);
      return null;
    }
    
    final a cP(int paramInt)
    {
      AppMethodBeat.i(262270);
      a locala2 = (a)this.alr.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.alr.put(paramInt, locala1);
      }
      AppMethodBeat.o(262270);
      return locala1;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(262261);
      int i = 0;
      while (i < this.alr.size())
      {
        ((a)this.alr.valueAt(i)).alt.clear();
        i += 1;
      }
      AppMethodBeat.o(262261);
    }
    
    final void d(int paramInt, long paramLong)
    {
      AppMethodBeat.i(262265);
      a locala = cP(paramInt);
      locala.alv = c(locala.alv, paramLong);
      AppMethodBeat.o(262265);
    }
    
    final void detach()
    {
      this.als -= 1;
    }
    
    final void lT()
    {
      this.als += 1;
    }
    
    public void t(RecyclerView.v paramv)
    {
      AppMethodBeat.i(262264);
      int i = paramv.amo;
      ArrayList localArrayList = cP(i).alt;
      if (((a)this.alr.get(i)).alu <= localArrayList.size())
      {
        AppMethodBeat.o(262264);
        return;
      }
      paramv.resetInternal();
      localArrayList.add(paramv);
      AppMethodBeat.o(262264);
    }
    
    static final class a
    {
      final ArrayList<RecyclerView.v> alt;
      int alu;
      long alv;
      long alw;
      
      a()
      {
        AppMethodBeat.i(262253);
        this.alt = new ArrayList();
        this.alu = 5;
        this.alv = 0L;
        this.alw = 0L;
        AppMethodBeat.o(262253);
      }
    }
  }
  
  public final class n
  {
    final List<RecyclerView.v> alA;
    int alB;
    int alC;
    RecyclerView.m alD;
    RecyclerView.t alE;
    final ArrayList<RecyclerView.v> alx;
    ArrayList<RecyclerView.v> aly;
    final ArrayList<RecyclerView.v> alz;
    
    public n()
    {
      AppMethodBeat.i(262275);
      this.alx = new ArrayList();
      this.aly = null;
      this.alz = new ArrayList();
      this.alA = Collections.unmodifiableList(this.alx);
      this.alB = 2;
      this.alC = 2;
      AppMethodBeat.o(262275);
    }
    
    private RecyclerView.v a(long paramLong, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(262343);
      int i = this.alx.size() - 1;
      RecyclerView.v localv;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.alx.get(i);
        if ((localv.amn == paramLong) && (!localv.mj()))
        {
          if (paramInt == localv.amo)
          {
            localv.cY(32);
            if ((localv.isRemoved()) && (!RecyclerView.this.akL.alW)) {
              localv.aN(2, 14);
            }
            AppMethodBeat.o(262343);
            return localv;
          }
          this.alx.remove(i);
          RecyclerView.this.removeDetachedView(localv.amk, false);
          bp(localv.amk);
        }
        i -= 1;
      }
      i = this.alz.size() - 1;
      while (i >= 0)
      {
        localv = (RecyclerView.v)this.alz.get(i);
        if (localv.amn == paramLong)
        {
          if (paramInt == localv.amo)
          {
            this.alz.remove(i);
            AppMethodBeat.o(262343);
            return localv;
          }
          cT(i);
          AppMethodBeat.o(262343);
          return null;
        }
        i -= 1;
      }
      AppMethodBeat.o(262343);
      return null;
    }
    
    private void a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      AppMethodBeat.i(262302);
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
        AppMethodBeat.o(262302);
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        AppMethodBeat.o(262302);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
      AppMethodBeat.o(262302);
    }
    
    private boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(262279);
      paramv.amA = RecyclerView.this;
      int i = paramv.amo;
      long l1 = RecyclerView.this.getNanoTime();
      if (paramLong != 9223372036854775807L)
      {
        long l2 = this.alD.cP(i).alw;
        if ((l2 == 0L) || (l2 + l1 < paramLong)) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(262279);
          return false;
        }
      }
      Object localObject = RecyclerView.this.afJ;
      paramv.mPosition = paramInt1;
      if (((RecyclerView.a)localObject).ald) {
        paramv.amn = ((RecyclerView.a)localObject).getItemId(paramInt1);
      }
      paramv.aN(1, 519);
      androidx.core.c.d.D("RV OnBindView");
      ((RecyclerView.a)localObject).a(paramv, paramInt1, paramv.mq());
      paramv.mp();
      localObject = paramv.amk.getLayoutParams();
      if ((localObject instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)localObject).alp = true;
      }
      androidx.core.c.d.gH();
      paramLong = RecyclerView.this.getNanoTime();
      localObject = this.alD.cP(paramv.amo);
      ((RecyclerView.m.a)localObject).alw = RecyclerView.m.c(((RecyclerView.m.a)localObject).alw, paramLong - l1);
      if (RecyclerView.this.lo())
      {
        localObject = paramv.amk;
        if (androidx.core.g.w.H((View)localObject) == 0) {
          androidx.core.g.w.p((View)localObject, 1);
        }
        if (!androidx.core.g.w.C((View)localObject))
        {
          paramv.cY(16384);
          androidx.core.g.w.a((View)localObject, RecyclerView.this.akS.amB);
        }
      }
      if (RecyclerView.this.akL.alW) {
        paramv.amp = paramInt2;
      }
      AppMethodBeat.o(262279);
      return true;
    }
    
    private RecyclerView.v cU(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(262336);
      int k;
      if (this.aly != null)
      {
        k = this.aly.size();
        if (k != 0) {}
      }
      else
      {
        AppMethodBeat.o(262336);
        return null;
      }
      int i = 0;
      RecyclerView.v localv;
      while (i < k)
      {
        localv = (RecyclerView.v)this.aly.get(i);
        if ((!localv.mj()) && (localv.mc() == paramInt))
        {
          localv.cY(32);
          AppMethodBeat.o(262336);
          return localv;
        }
        i += 1;
      }
      if (RecyclerView.this.afJ.ald)
      {
        paramInt = RecyclerView.this.ajS.af(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.afJ.getItemCount()))
        {
          long l = RecyclerView.this.afJ.getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localv = (RecyclerView.v)this.aly.get(paramInt);
            if ((!localv.mj()) && (localv.amn == l))
            {
              localv.cY(32);
              AppMethodBeat.o(262336);
              return localv;
            }
            paramInt += 1;
          }
        }
      }
      AppMethodBeat.o(262336);
      return null;
    }
    
    private RecyclerView.v j(int paramInt, boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(262341);
      int k = this.alx.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.alx.get(i);
        if ((!((RecyclerView.v)localObject1).mj()) && (((RecyclerView.v)localObject1).mc() == paramInt) && (!((RecyclerView.v)localObject1).isInvalid()) && ((RecyclerView.this.akL.alW) || (!((RecyclerView.v)localObject1).isRemoved())))
        {
          ((RecyclerView.v)localObject1).cY(32);
          AppMethodBeat.o(262341);
          return localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.mChildHelper;
      k = ((f)localObject2).afV.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((f)localObject2).afV.get(i);
        localObject3 = ((f)localObject2).afT.aQ((View)localObject1);
        if ((((RecyclerView.v)localObject3).mc() != paramInt) || (((RecyclerView.v)localObject3).isInvalid()) || (((RecyclerView.v)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.bg((View)localObject1);
          localObject3 = RecyclerView.this.mChildHelper;
          paramInt = ((f)localObject3).afT.aO((View)localObject1);
          if (paramInt < 0)
          {
            localObject1 = new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(262341);
            throw ((Throwable)localObject1);
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((f)localObject3).afU.cr(paramInt))
          {
            localObject1 = new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(262341);
            throw ((Throwable)localObject1);
          }
          ((f)localObject3).afU.clear(paramInt);
          ((f)localObject3).aN((View)localObject1);
          paramInt = RecyclerView.this.mChildHelper.aO((View)localObject1);
          if (paramInt == -1)
          {
            localObject1 = new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2 + RecyclerView.this.kY());
            AppMethodBeat.o(262341);
            throw ((Throwable)localObject1);
          }
          RecyclerView.this.mChildHelper.detachViewFromParent(paramInt);
          bq((View)localObject1);
          ((RecyclerView.v)localObject2).cY(8224);
          AppMethodBeat.o(262341);
          return localObject2;
        }
      }
      k = this.alz.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.v)this.alz.get(i);
        if ((!((RecyclerView.v)localObject1).isInvalid()) && (((RecyclerView.v)localObject1).mc() == paramInt))
        {
          this.alz.remove(i);
          AppMethodBeat.o(262341);
          return localObject1;
        }
        i += 1;
      }
      AppMethodBeat.o(262341);
      return null;
    }
    
    private void lV()
    {
      AppMethodBeat.i(262309);
      int i = this.alz.size() - 1;
      while (i >= 0)
      {
        cT(i);
        i -= 1;
      }
      this.alz.clear();
      if (RecyclerView.ajL) {
        RecyclerView.this.akK.kr();
      }
      AppMethodBeat.o(262309);
    }
    
    private boolean u(RecyclerView.v paramv)
    {
      AppMethodBeat.i(262278);
      if (paramv.isRemoved())
      {
        boolean bool = RecyclerView.this.akL.alW;
        AppMethodBeat.o(262278);
        return bool;
      }
      if ((paramv.mPosition < 0) || (paramv.mPosition >= RecyclerView.this.afJ.getItemCount()))
      {
        paramv = new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramv + RecyclerView.this.kY());
        AppMethodBeat.o(262278);
        throw paramv;
      }
      if ((!RecyclerView.this.akL.alW) && (RecyclerView.this.afJ.getItemViewType(paramv.mPosition) != paramv.amo))
      {
        AppMethodBeat.o(262278);
        return false;
      }
      if (RecyclerView.this.afJ.ald)
      {
        if (paramv.amn == RecyclerView.this.afJ.getItemId(paramv.mPosition))
        {
          AppMethodBeat.o(262278);
          return true;
        }
        AppMethodBeat.o(262278);
        return false;
      }
      AppMethodBeat.o(262278);
      return true;
    }
    
    private void v(RecyclerView.v paramv)
    {
      AppMethodBeat.i(262298);
      if ((paramv.amk instanceof ViewGroup)) {
        a((ViewGroup)paramv.amk, false);
      }
      AppMethodBeat.o(262298);
    }
    
    private void y(RecyclerView.v paramv)
    {
      AppMethodBeat.i(262346);
      if (RecyclerView.this.afJ != null) {
        RecyclerView.this.afJ.m(paramv);
      }
      if (RecyclerView.this.akL != null) {
        RecyclerView.this.ajT.N(paramv);
      }
      AppMethodBeat.o(262346);
    }
    
    final void b(RecyclerView.v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(262323);
      RecyclerView.j(paramv);
      if (paramv.cX(16384))
      {
        paramv.aN(0, 16384);
        androidx.core.g.w.a(paramv.amk, null);
      }
      if (paramBoolean) {
        y(paramv);
      }
      paramv.amA = null;
      getRecycledViewPool().t(paramv);
      AppMethodBeat.o(262323);
    }
    
    public final void bo(View paramView)
    {
      AppMethodBeat.i(262305);
      RecyclerView.v localv = RecyclerView.bg(paramView);
      if (localv.mn()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localv.mh()) {
        localv.mi();
      }
      for (;;)
      {
        w(localv);
        AppMethodBeat.o(262305);
        return;
        if (localv.mj()) {
          localv.mk();
        }
      }
    }
    
    final void bp(View paramView)
    {
      AppMethodBeat.i(262327);
      paramView = RecyclerView.bg(paramView);
      paramView.amw = null;
      paramView.amx = false;
      paramView.mk();
      w(paramView);
      AppMethodBeat.o(262327);
    }
    
    final void bq(View paramView)
    {
      AppMethodBeat.i(262331);
      paramView = RecyclerView.bg(paramView);
      int i;
      if ((!paramView.cX(12)) && (paramView.mt()))
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.akx != null) && (!localRecyclerView.akx.a(paramView, paramView.mq()))) {
          break label126;
        }
        i = 1;
      }
      while (i != 0) {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.afJ.ald))
        {
          paramView = new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.kY());
          AppMethodBeat.o(262331);
          throw paramView;
          label126:
          i = 0;
        }
        else
        {
          paramView.a(this, false);
          this.alx.add(paramView);
          AppMethodBeat.o(262331);
          return;
        }
      }
      if (this.aly == null) {
        this.aly = new ArrayList();
      }
      paramView.a(this, true);
      this.aly.add(paramView);
      AppMethodBeat.o(262331);
    }
    
    public final int cQ(int paramInt)
    {
      AppMethodBeat.i(262282);
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.akL.getItemCount()))
      {
        IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.akL.getItemCount() + RecyclerView.this.kY());
        AppMethodBeat.o(262282);
        throw localIndexOutOfBoundsException;
      }
      if (!RecyclerView.this.akL.alW)
      {
        AppMethodBeat.o(262282);
        return paramInt;
      }
      paramInt = RecyclerView.this.ajS.cm(paramInt);
      AppMethodBeat.o(262282);
      return paramInt;
    }
    
    public final View cR(int paramInt)
    {
      AppMethodBeat.i(293120);
      View localView = cS(paramInt);
      AppMethodBeat.o(293120);
      return localView;
    }
    
    final View cS(int paramInt)
    {
      AppMethodBeat.i(262287);
      View localView = e(paramInt, 9223372036854775807L).amk;
      AppMethodBeat.o(262287);
      return localView;
    }
    
    final void cT(int paramInt)
    {
      AppMethodBeat.i(262314);
      b((RecyclerView.v)this.alz.get(paramInt), true);
      this.alz.remove(paramInt);
      AppMethodBeat.o(262314);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(262276);
      this.alx.clear();
      lV();
      AppMethodBeat.o(262276);
    }
    
    final RecyclerView.v e(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      AppMethodBeat.i(262293);
      Object localObject1;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.akL.getItemCount()))
      {
        localObject1 = new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.akL.getItemCount() + RecyclerView.this.kY());
        AppMethodBeat.o(262293);
        throw ((Throwable)localObject1);
      }
      int i;
      if (RecyclerView.this.akL.alW)
      {
        localObject1 = cU(paramInt);
        if (localObject1 != null) {
          i = 1;
        }
      }
      for (int j = i;; j = 0)
      {
        Object localObject2;
        if (localObject1 == null)
        {
          localObject2 = j(paramInt, false);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null)
          {
            if (u((RecyclerView.v)localObject2)) {
              break label348;
            }
            ((RecyclerView.v)localObject2).cY(4);
            if (!((RecyclerView.v)localObject2).mh()) {
              break label332;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.v)localObject2).amk, false);
            ((RecyclerView.v)localObject2).mi();
            label200:
            w((RecyclerView.v)localObject2);
            localObject1 = null;
            i = j;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int k = RecyclerView.this.ajS.cm(paramInt);
            if ((k < 0) || (k >= RecyclerView.this.afJ.getItemCount()))
            {
              localObject1 = new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.akL.getItemCount() + RecyclerView.this.kY());
              AppMethodBeat.o(262293);
              throw ((Throwable)localObject1);
              i = 0;
              break;
              label332:
              if (!((RecyclerView.v)localObject2).mj()) {
                break label200;
              }
              ((RecyclerView.v)localObject2).mk();
              break label200;
              label348:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.this.afJ.getItemViewType(k);
            if (RecyclerView.this.afJ.ald)
            {
              localObject2 = a(RecyclerView.this.afJ.getItemId(k), j, false);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.v)localObject2).mPosition = k;
                i = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject2 = getRecycledViewPool().cO(j);
                  localObject1 = localObject2;
                  if (localObject2 != null)
                  {
                    ((RecyclerView.v)localObject2).resetInternal();
                    localObject1 = localObject2;
                    if (RecyclerView.ajI)
                    {
                      v((RecyclerView.v)localObject2);
                      localObject1 = localObject2;
                    }
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  long l1 = RecyclerView.this.getNanoTime();
                  if ((paramLong != 9223372036854775807L) && (!this.alD.b(j, l1, paramLong)))
                  {
                    AppMethodBeat.o(262293);
                    return null;
                  }
                  localObject2 = RecyclerView.this.afJ.c(RecyclerView.this, j);
                  if (RecyclerView.ajL)
                  {
                    localObject1 = RecyclerView.bk(((RecyclerView.v)localObject2).amk);
                    if (localObject1 != null) {
                      ((RecyclerView.v)localObject2).aml = new WeakReference(localObject1);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.alD.d(j, l2 - l1);
                }
              }
            }
          }
          for (;;)
          {
            if ((i != 0) && (!RecyclerView.this.akL.alW) && (((RecyclerView.v)localObject2).cX(8192)))
            {
              ((RecyclerView.v)localObject2).aN(0, 8192);
              if (RecyclerView.this.akL.alZ)
              {
                j = RecyclerView.f.p((RecyclerView.v)localObject2);
                localObject1 = RecyclerView.this.akx.a(RecyclerView.this.akL, (RecyclerView.v)localObject2, j | 0x1000, ((RecyclerView.v)localObject2).mq());
                RecyclerView.this.a((RecyclerView.v)localObject2, (RecyclerView.f.c)localObject1);
              }
            }
            boolean bool1;
            if ((RecyclerView.this.akL.alW) && (((RecyclerView.v)localObject2).isBound()))
            {
              ((RecyclerView.v)localObject2).amp = paramInt;
              bool1 = false;
            }
            for (;;)
            {
              localObject1 = ((RecyclerView.v)localObject2).amk.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                ((RecyclerView.v)localObject2).amk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label772:
                ((RecyclerView.LayoutParams)localObject1).aiC = ((RecyclerView.v)localObject2);
                if ((i == 0) || (!bool1)) {
                  break label906;
                }
              }
              label906:
              for (bool1 = bool2;; bool1 = false)
              {
                ((RecyclerView.LayoutParams)localObject1).alq = bool1;
                AppMethodBeat.o(262293);
                return localObject2;
                if ((((RecyclerView.v)localObject2).isBound()) && (!((RecyclerView.v)localObject2).mm()) && (!((RecyclerView.v)localObject2).isInvalid())) {
                  break label912;
                }
                bool1 = a((RecyclerView.v)localObject2, RecyclerView.this.ajS.cm(paramInt), paramInt, paramLong);
                break;
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((RecyclerView.v)localObject2).amk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  break label772;
                }
                localObject1 = (RecyclerView.LayoutParams)localObject1;
                break label772;
              }
              label912:
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
      AppMethodBeat.i(262349);
      if (this.alD == null) {
        this.alD = new RecyclerView.m();
      }
      RecyclerView.m localm = this.alD;
      AppMethodBeat.o(262349);
      return localm;
    }
    
    final void lD()
    {
      int j = 0;
      AppMethodBeat.i(262354);
      int k = this.alz.size();
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.alz.get(i)).lZ();
        i += 1;
      }
      k = this.alx.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.v)this.alx.get(i)).lZ();
        i += 1;
      }
      if (this.aly != null)
      {
        k = this.aly.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.v)this.aly.get(i)).lZ();
          i += 1;
        }
      }
      AppMethodBeat.o(262354);
    }
    
    final void lE()
    {
      AppMethodBeat.i(262351);
      int j = this.alz.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.v localv = (RecyclerView.v)this.alz.get(i);
        if (localv != null)
        {
          localv.cY(6);
          localv.Q(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.afJ == null) || (!RecyclerView.this.afJ.ald)) {
        lV();
      }
      AppMethodBeat.o(262351);
    }
    
    final void lU()
    {
      AppMethodBeat.i(262277);
      if (RecyclerView.this.ajX != null) {}
      for (int i = RecyclerView.this.ajX.mPrefetchMaxCountObserved;; i = 0)
      {
        this.alC = (i + this.alB);
        i = this.alz.size() - 1;
        while ((i >= 0) && (this.alz.size() > this.alC))
        {
          cT(i);
          i -= 1;
        }
      }
      AppMethodBeat.o(262277);
    }
    
    final void w(RecyclerView.v paramv)
    {
      int k = 1;
      AppMethodBeat.i(262320);
      if ((paramv.mh()) || (paramv.amk.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramv.mh()).append(" isAttached:");
        if (paramv.amk.getParent() != null) {}
        for (bool = true;; bool = false)
        {
          paramv = new IllegalArgumentException(bool + RecyclerView.this.kY());
          AppMethodBeat.o(262320);
          throw paramv;
        }
      }
      if (paramv.mn())
      {
        paramv = new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv + RecyclerView.this.kY());
        AppMethodBeat.o(262320);
        throw paramv;
      }
      if (paramv.mb())
      {
        paramv = new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.kY());
        AppMethodBeat.o(262320);
        throw paramv;
      }
      boolean bool = paramv.ms();
      int j;
      int i;
      if (paramv.mr()) {
        if ((this.alC > 0) && (!paramv.cX(526)))
        {
          j = this.alz.size();
          i = j;
          if (j >= this.alC)
          {
            i = j;
            if (j > 0)
            {
              cT(0);
              i = j - 1;
            }
          }
          j = i;
          if (RecyclerView.ajL)
          {
            j = i;
            if (i > 0)
            {
              j = i;
              if (!RecyclerView.this.akK.cu(paramv.mPosition))
              {
                i -= 1;
                while (i >= 0)
                {
                  j = ((RecyclerView.v)this.alz.get(i)).mPosition;
                  if (!RecyclerView.this.akK.cu(j)) {
                    break;
                  }
                  i -= 1;
                }
                j = i + 1;
              }
            }
          }
          this.alz.add(j, paramv);
          i = 1;
          if (i == 0)
          {
            b(paramv, true);
            j = k;
          }
        }
      }
      for (;;)
      {
        RecyclerView.this.ajT.N(paramv);
        if ((i == 0) && (j == 0) && (bool)) {
          paramv.amA = null;
        }
        AppMethodBeat.o(262320);
        return;
        j = 0;
        continue;
        i = 0;
        break;
        j = 0;
        i = 0;
      }
    }
    
    final void x(RecyclerView.v paramv)
    {
      AppMethodBeat.i(262332);
      if (paramv.amx) {
        this.aly.remove(paramv);
      }
      for (;;)
      {
        paramv.amw = null;
        paramv.amx = false;
        paramv.mk();
        AppMethodBeat.o(262332);
        return;
        this.alx.remove(paramv);
      }
    }
  }
  
  public static abstract interface o {}
  
  final class p
    extends RecyclerView.c
  {
    p() {}
    
    private void lW()
    {
      AppMethodBeat.i(262386);
      if ((RecyclerView.ajK) && (RecyclerView.this.akd) && (RecyclerView.this.akc))
      {
        androidx.core.g.w.a(RecyclerView.this, RecyclerView.this.ajV);
        AppMethodBeat.o(262386);
        return;
      }
      RecyclerView.this.akl = true;
      RecyclerView.this.requestLayout();
      AppMethodBeat.o(262386);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(262373);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView.this.akL.alV = true;
      RecyclerView.this.av(true);
      if (!RecyclerView.this.ajS.ke()) {
        RecyclerView.this.requestLayout();
      }
      AppMethodBeat.o(262373);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      AppMethodBeat.i(262376);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      a locala = RecyclerView.this.ajS;
      if (paramInt2 > 0)
      {
        locala.afz.add(locala.a(4, paramInt1, paramInt2, paramObject));
        locala.afF |= 0x4;
        if (locala.afz.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lW();
        }
        AppMethodBeat.o(262376);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = 1;
      AppMethodBeat.i(262378);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      a locala = RecyclerView.this.ajS;
      if (paramInt2 > 0)
      {
        locala.afz.add(locala.a(1, paramInt1, paramInt2, null));
        locala.afF |= 0x1;
        if (locala.afz.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lW();
        }
        AppMethodBeat.o(262378);
        return;
      }
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      AppMethodBeat.i(262384);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      Object localObject = RecyclerView.this.ajS;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1)
        {
          localObject = new IllegalArgumentException("Moving more than 1 item is not supported yet");
          AppMethodBeat.o(262384);
          throw ((Throwable)localObject);
        }
        ((a)localObject).afz.add(((a)localObject).a(8, paramInt1, paramInt2, null));
        ((a)localObject).afF |= 0x8;
        if (((a)localObject).afz.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lW();
        }
        AppMethodBeat.o(262384);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = 1;
      AppMethodBeat.i(262381);
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      a locala = RecyclerView.this.ajS;
      if (paramInt2 > 0)
      {
        locala.afz.add(locala.a(2, paramInt1, paramInt2, null));
        locala.afF |= 0x2;
        if (locala.afz.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          lW();
        }
        AppMethodBeat.o(262381);
        return;
      }
    }
  }
  
  public static abstract class r
  {
    boolean Tb;
    private RecyclerView.LayoutManager ajD;
    public int alG = -1;
    boolean alH;
    View alI;
    private final a alJ = new a();
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
      this.ajD = paramLayoutManager;
      if (this.alG == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      this.mRecyclerView.akL.alG = this.alG;
      this.Tb = true;
      this.alH = true;
      int i = this.alG;
      this.alI = this.mRecyclerView.ajX.findViewByPosition(i);
      onStart();
      this.mRecyclerView.akI.lY();
      this.mStarted = true;
    }
    
    final void aK(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((!this.Tb) || (this.alG == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.alH) && (this.alI == null) && (this.ajD != null))
      {
        PointF localPointF = cB(this.alG);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.d((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.alH = false;
      if (this.alI != null)
      {
        if (RecyclerView.bi(this.alI) != this.alG) {
          break label233;
        }
        a(this.alI, localRecyclerView.akL, this.alJ);
        this.alJ.g(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.Tb)
        {
          a(paramInt1, paramInt2, this.alJ);
          paramInt1 = i;
          if (this.alJ.alN >= 0) {
            paramInt1 = 1;
          }
          this.alJ.g(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.Tb) {
              break;
            }
            this.alH = true;
            localRecyclerView.akI.lY();
          }
        }
        return;
        label233:
        this.alI = null;
      }
      stop();
    }
    
    public PointF cB(int paramInt)
    {
      RecyclerView.LayoutManager localLayoutManager = this.ajD;
      if ((localLayoutManager instanceof RecyclerView.r.b)) {
        return ((RecyclerView.r.b)localLayoutManager).cB(paramInt);
      }
      new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(RecyclerView.r.b.class.getCanonicalName());
      return null;
    }
    
    public final void cV(int paramInt)
    {
      this.alG = paramInt;
    }
    
    public final int getChildCount()
    {
      return this.mRecyclerView.ajX.getChildCount();
    }
    
    public final RecyclerView.LayoutManager getLayoutManager()
    {
      return this.ajD;
    }
    
    public final boolean isRunning()
    {
      return this.Tb;
    }
    
    protected abstract void onStart();
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.Tb) {
        return;
      }
      this.Tb = false;
      onStop();
      this.mRecyclerView.akL.alG = -1;
      this.alI = null;
      this.alG = -1;
      this.alH = false;
      this.ajD.onSmoothScrollerStopped(this);
      this.ajD = null;
      this.mRecyclerView = null;
    }
    
    public static final class a
    {
      private int alK = 0;
      private int alL = 0;
      private int alM = -2147483648;
      int alN = -1;
      private boolean alO = false;
      private int alP = 0;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this((byte)0);
      }
      
      private a(byte paramByte) {}
      
      private void validate()
      {
        AppMethodBeat.i(262407);
        IllegalStateException localIllegalStateException;
        if ((this.mInterpolator != null) && (this.alM <= 0))
        {
          localIllegalStateException = new IllegalStateException("If you provide an interpolator, you must set a positive duration");
          AppMethodBeat.o(262407);
          throw localIllegalStateException;
        }
        if (this.alM <= 0)
        {
          localIllegalStateException = new IllegalStateException("Scroll duration must be a positive number");
          AppMethodBeat.o(262407);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(262407);
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.alK = paramInt1;
        this.alL = paramInt2;
        this.alM = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.alO = true;
      }
      
      final void g(RecyclerView paramRecyclerView)
      {
        AppMethodBeat.i(262406);
        if (this.alN >= 0)
        {
          int i = this.alN;
          this.alN = -1;
          paramRecyclerView.cI(i);
          this.alO = false;
          AppMethodBeat.o(262406);
          return;
        }
        if (this.alO)
        {
          validate();
          if (this.mInterpolator == null) {
            if (this.alM == -2147483648) {
              paramRecyclerView.akI.aL(this.alK, this.alL);
            }
          }
          for (;;)
          {
            this.alP += 1;
            this.alO = false;
            AppMethodBeat.o(262406);
            return;
            paramRecyclerView.akI.i(this.alK, this.alL, this.alM);
            continue;
            paramRecyclerView.akI.b(this.alK, this.alL, this.alM, this.mInterpolator);
          }
        }
        this.alP = 0;
        AppMethodBeat.o(262406);
      }
    }
  }
  
  public static class s
  {
    int alG = -1;
    private SparseArray<Object> alQ;
    int alR = 0;
    int alS = 0;
    int alT = 1;
    int alU = 0;
    boolean alV = false;
    public boolean alW = false;
    boolean alX = false;
    boolean alY = false;
    boolean alZ = false;
    public boolean ama = false;
    int amb;
    long amc;
    int amd;
    int ame;
    int amf;
    
    final void cW(int paramInt)
    {
      AppMethodBeat.i(262410);
      if ((this.alT & paramInt) == 0)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.alT));
        AppMethodBeat.o(262410);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(262410);
    }
    
    public final int getItemCount()
    {
      if (this.alW) {
        return this.alR - this.alS;
      }
      return this.alU;
    }
    
    public final boolean lX()
    {
      return this.alW;
    }
    
    public String toString()
    {
      AppMethodBeat.i(262411);
      String str = "State{mTargetPosition=" + this.alG + ", mData=" + this.alQ + ", mItemCount=" + this.alU + ", mIsMeasuring=" + this.alY + ", mPreviousLayoutItemCount=" + this.alR + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.alS + ", mStructureChanged=" + this.alV + ", mInPreLayout=" + this.alW + ", mRunSimpleAnimations=" + this.alZ + ", mRunPredictiveAnimations=" + this.ama + '}';
      AppMethodBeat.o(262411);
      return str;
    }
  }
  
  final class u
    implements Runnable
  {
    OverScroller Qi;
    int amg;
    int amh;
    private boolean ami;
    private boolean amj;
    Interpolator mInterpolator;
    
    u()
    {
      AppMethodBeat.i(262413);
      this.mInterpolator = RecyclerView.akZ;
      this.ami = false;
      this.amj = false;
      this.Qi = new OverScroller(RecyclerView.this.getContext(), RecyclerView.akZ);
      AppMethodBeat.o(262413);
    }
    
    private static float distanceInfluenceForSnapDuration(float paramFloat)
    {
      AppMethodBeat.i(262418);
      paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
      AppMethodBeat.o(262418);
      return paramFloat;
    }
    
    final void aL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262417);
      i(paramInt1, paramInt2, aM(paramInt1, paramInt2));
      AppMethodBeat.o(262417);
    }
    
    final int aM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262419);
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
        AppMethodBeat.o(262419);
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
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      AppMethodBeat.i(262423);
      if (this.mInterpolator != paramInterpolator)
      {
        this.mInterpolator = paramInterpolator;
        this.Qi = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.amh = 0;
      this.amg = 0;
      this.Qi.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.Qi.computeScrollOffset();
      }
      lY();
      AppMethodBeat.o(262423);
    }
    
    public final void i(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262421);
      b(paramInt1, paramInt2, paramInt3, RecyclerView.akZ);
      AppMethodBeat.o(262421);
    }
    
    final void lY()
    {
      AppMethodBeat.i(262416);
      if (this.ami)
      {
        this.amj = true;
        AppMethodBeat.o(262416);
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      androidx.core.g.w.a(RecyclerView.this, this);
      AppMethodBeat.o(262416);
    }
    
    public final void run()
    {
      AppMethodBeat.i(262414);
      if (RecyclerView.this.ajX == null)
      {
        stop();
        AppMethodBeat.o(262414);
        return;
      }
      this.amj = false;
      this.ami = true;
      RecyclerView.this.lb();
      OverScroller localOverScroller = this.Qi;
      RecyclerView.r localr = RecyclerView.this.ajX.mSmoothScroller;
      int i6;
      int i7;
      int k;
      int j;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.Qs;
        i6 = localOverScroller.getCurrX();
        i7 = localOverScroller.getCurrY();
        k = i6 - this.amg;
        j = i7 - this.amh;
        this.amg = i6;
        this.amh = i7;
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
        if (RecyclerView.this.afJ != null)
        {
          RecyclerView.this.d(k, j, RecyclerView.this.akW);
          i = RecyclerView.this.akW[0];
          i3 = RecyclerView.this.akW[1];
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
            if (!localr.alH)
            {
              m = i;
              n = i3;
              i1 = i4;
              i2 = i5;
              if (localr.Tb)
              {
                m = RecyclerView.this.akL.getItemCount();
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
          if (!RecyclerView.this.ajZ.isEmpty()) {
            RecyclerView.this.invalidate();
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.az(k, j);
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
                RecyclerView.this.aA(i4, i);
              }
              if (((i4 != 0) || (i1 == i6) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (i2 == i7) || (localOverScroller.getFinalY() == 0))) {
                localOverScroller.abortAnimation();
              }
              if ((m != 0) || (n != 0)) {
                RecyclerView.this.aD(m, n);
              }
              if (!RecyclerView.c(RecyclerView.this)) {
                RecyclerView.this.invalidate();
              }
              if ((j != 0) && (RecyclerView.this.ajX.canScrollVertically()) && (n == j))
              {
                i = 1;
                if ((k == 0) || (!RecyclerView.this.ajX.canScrollHorizontally()) || (m != k)) {
                  break label794;
                }
                m = 1;
                if (((k != 0) || (j != 0)) && (m == 0) && (i == 0)) {
                  break label800;
                }
                i = 1;
                if ((!localOverScroller.isFinished()) && ((i != 0) || (RecyclerView.this.getScrollingChildHelper().bx(1)))) {
                  break label805;
                }
                RecyclerView.this.setScrollState(0);
                if (RecyclerView.ajL) {
                  RecyclerView.this.akK.kr();
                }
                RecyclerView.this.bw(1);
              }
              for (;;)
              {
                if (localr != null)
                {
                  if (localr.alH) {
                    localr.aK(0, 0);
                  }
                  if (!this.amj) {
                    localr.stop();
                  }
                }
                this.ami = false;
                if (this.amj) {
                  lY();
                }
                AppMethodBeat.o(262414);
                return;
                if (localr.alG >= m) {
                  localr.alG = (m - 1);
                }
                localr.aK(k - i4, j - i5);
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
                lY();
                if (RecyclerView.this.akJ != null) {
                  RecyclerView.this.akJ.a(RecyclerView.this, k, j);
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
      AppMethodBeat.i(262424);
      RecyclerView.this.removeCallbacks(this);
      this.Qi.abortAnimation();
      AppMethodBeat.o(262424);
    }
  }
  
  public static abstract class v
  {
    private static final List<Object> ams = ;
    RecyclerView amA;
    public final View amk;
    WeakReference<RecyclerView> aml;
    public int amm = -1;
    public long amn = -1L;
    public int amo = -1;
    int amp = -1;
    v amq = null;
    v amr = null;
    List<Object> amt = null;
    List<Object> amu = null;
    private int amv = 0;
    RecyclerView.n amw = null;
    boolean amx = false;
    int amy = 0;
    int amz = -1;
    int cN;
    int mPosition = -1;
    
    public v(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.amk = paramView;
    }
    
    private void mo()
    {
      if (this.amt == null)
      {
        this.amt = new ArrayList();
        this.amu = Collections.unmodifiableList(this.amt);
      }
    }
    
    final void Q(Object paramObject)
    {
      if (paramObject == null) {
        cY(1024);
      }
      while ((this.cN & 0x400) != 0) {
        return;
      }
      mo();
      this.amt.add(paramObject);
    }
    
    final void a(RecyclerView.n paramn, boolean paramBoolean)
    {
      this.amw = paramn;
      this.amx = paramBoolean;
    }
    
    final void aN(int paramInt1, int paramInt2)
    {
      this.cN = (this.cN & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public final void ax(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.amv - 1;
        this.amv = i;
        if (this.amv >= 0) {
          break label53;
        }
        this.amv = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.amv + 1;
        break;
        if ((!paramBoolean) && (this.amv == 1))
        {
          this.cN |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.amv != 0));
      this.cN &= 0xFFFFFFEF;
    }
    
    final boolean cX(int paramInt)
    {
      return (this.cN & paramInt) != 0;
    }
    
    final void cY(int paramInt)
    {
      this.cN |= paramInt;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.amp == -1) {
        return this.mPosition;
      }
      return this.amp;
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
    
    final void k(int paramInt, boolean paramBoolean)
    {
      if (this.amm == -1) {
        this.amm = this.mPosition;
      }
      if (this.amp == -1) {
        this.amp = this.mPosition;
      }
      if (paramBoolean) {
        this.amp += paramInt;
      }
      this.mPosition += paramInt;
      if (this.amk.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.amk.getLayoutParams()).alp = true;
      }
    }
    
    final void lZ()
    {
      this.amm = -1;
      this.amp = -1;
    }
    
    final void ma()
    {
      if (this.amm == -1) {
        this.amm = this.mPosition;
      }
    }
    
    final boolean mb()
    {
      return (this.cN & 0x80) != 0;
    }
    
    public final int mc()
    {
      if (this.amp == -1) {
        return this.mPosition;
      }
      return this.amp;
    }
    
    public final int md()
    {
      if (this.amA == null) {
        return -1;
      }
      return this.amA.k(this);
    }
    
    public final int me()
    {
      return this.amm;
    }
    
    public final long mf()
    {
      return this.amn;
    }
    
    public final int mg()
    {
      return this.amo;
    }
    
    final boolean mh()
    {
      return this.amw != null;
    }
    
    final void mi()
    {
      this.amw.x(this);
    }
    
    final boolean mj()
    {
      return (this.cN & 0x20) != 0;
    }
    
    final void mk()
    {
      this.cN &= 0xFFFFFFDF;
    }
    
    final void ml()
    {
      this.cN &= 0xFFFFFEFF;
    }
    
    final boolean mm()
    {
      return (this.cN & 0x2) != 0;
    }
    
    final boolean mn()
    {
      return (this.cN & 0x100) != 0;
    }
    
    final void mp()
    {
      if (this.amt != null) {
        this.amt.clear();
      }
      this.cN &= 0xFFFFFBFF;
    }
    
    final List<Object> mq()
    {
      if ((this.cN & 0x400) == 0)
      {
        if ((this.amt == null) || (this.amt.size() == 0)) {
          return ams;
        }
        return this.amu;
      }
      return ams;
    }
    
    public final boolean mr()
    {
      return ((this.cN & 0x10) == 0) && (!androidx.core.g.w.F(this.amk));
    }
    
    final boolean ms()
    {
      return ((this.cN & 0x10) == 0) && (androidx.core.g.w.F(this.amk));
    }
    
    final boolean mt()
    {
      return (this.cN & 0x2) != 0;
    }
    
    final void resetInternal()
    {
      this.cN = 0;
      this.mPosition = -1;
      this.amm = -1;
      this.amn = -1L;
      this.amp = -1;
      this.amv = 0;
      this.amq = null;
      this.amr = null;
      mp();
      this.amy = 0;
      this.amz = -1;
      RecyclerView.j(this);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.amn + ", oldPos=" + this.amm + ", pLpos:" + this.amp);
      String str;
      if (mh())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.amx)
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
        if (mm()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (mb()) {
          localStringBuilder1.append(" ignored");
        }
        if (mn()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!mr()) {
          localStringBuilder1.append(" not recyclable(" + this.amv + ")");
        }
        if (((this.cN & 0x200) == 0) && (!isInvalid())) {
          break label305;
        }
      }
      label305:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.amk.getParent() == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */