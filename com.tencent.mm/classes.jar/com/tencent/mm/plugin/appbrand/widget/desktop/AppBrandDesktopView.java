package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.f;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.o;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b.2;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopView
  extends DragRecyclerView
  implements c.a
{
  private int aOy;
  private int aOz;
  private RecyclerView.a abe;
  public int anI;
  private int arZ;
  private RecyclerView.s aru;
  boolean dnN;
  private boolean dtf;
  private RecyclerView.m fuK;
  int guA;
  private ArrayList<c> ijj;
  boolean isPaused;
  Context mContext;
  private Interpolator mInterpolator;
  private int mTouchSlop;
  HeaderContainer mtL;
  private AppBrandDesktopDragView.b mvP;
  Runnable mwA;
  Runnable mwB;
  private int mwC;
  int mwD;
  private int mwE;
  private int mwF;
  private int mwG;
  private int mwH;
  private int mwI;
  private boolean mwJ;
  private View mwK;
  private int mwL;
  private boolean mwM;
  private String mwN;
  private View mwO;
  private int mwP;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mwQ;
  boolean mwR;
  private boolean mwS;
  boolean mwT;
  boolean mwU;
  boolean mwV;
  boolean mwW;
  int mwX;
  final AppBrandDesktopView.b mwY;
  final AppBrandDesktopView.b mwZ;
  private ArrayList<c> mwm;
  int mwn;
  boolean mwo;
  boolean mwp;
  private j mwq;
  private boolean mwr;
  private RelativeLayout mws;
  RecentAppBrandViewContainer mwt;
  private RecentAppBrandView mwu;
  private AppBrandDesktopDragView mwv;
  int mww;
  private int mwx;
  private boolean mwy;
  private boolean mwz;
  boolean mxa;
  boolean mxb;
  int mxc;
  private int mxd;
  private float mxe;
  private float mxf;
  private boolean mxg;
  private boolean mxh;
  private final Runnable mxi;
  int mxj;
  private int mxk;
  private boolean mxl;
  private boolean mxm;
  private Animator.AnimatorListener uY;
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.anI = 4;
    this.ijj = new ArrayList();
    this.mwm = new ArrayList();
    this.mwn = 0;
    this.mwo = false;
    this.mwp = false;
    this.mwq = null;
    this.mwr = false;
    this.arZ = 0;
    this.aOy = 0;
    this.aOz = 0;
    this.mww = 0;
    this.mwx = 0;
    this.mwy = false;
    this.mwz = false;
    this.mwA = null;
    this.mwB = null;
    this.dtf = false;
    this.mwG = 0;
    this.mwH = 0;
    this.mwI = 0;
    this.mwJ = false;
    this.mwL = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 80);
    this.mwM = true;
    this.mwN = "";
    this.mwP = 0;
    this.guA = 0;
    this.mwQ = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.mwR = false;
    this.mwS = false;
    this.isPaused = false;
    this.mwT = false;
    this.mwU = false;
    this.mwV = false;
    this.mwW = false;
    this.mwX = 0;
    this.mwY = new AppBrandDesktopView.b(this, 1);
    this.mwZ = new AppBrandDesktopView.b(this, 2);
    this.mxa = false;
    this.mxb = false;
    this.mxc = 0;
    this.dnN = false;
    this.mvP = new AppBrandDesktopDragView.b()
    {
      public final void cI(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49564);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if (localc.mxs != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            ac.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bs.isNullOrNil(localc.mxs.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Sg(localc.mxs.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cJ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49565);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49565);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if ((localc.type == 1) && (localc.mxs != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.mzF.bzy();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.aX(localc.mxs.username, localc.mxs.hxM)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bs.isNullOrNil(localc.mxs.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Sf(localc.mxs.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cK(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.mxs != null)
        {
          ac.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.mxs.username, Integer.valueOf(paramAnonymousObject.mxs.hxM) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.mzF.bzx();
          if (locale != null) {
            bool = locale.aY(paramAnonymousObject.mxs.username, paramAnonymousObject.mxs.hxM);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.mxs != null) && (!bs.isNullOrNil(paramAnonymousObject.mxs.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).Se(paramAnonymousObject.mxs.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            ac.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.d(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
            if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.e(AppBrandDesktopView.this).getAdapter().cj(paramAnonymousObject.position);
            }
          }
        }
        AppMethodBeat.o(49566);
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        AppBrandDesktopView.a(AppBrandDesktopView.this, true);
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).mxs != null) && (!bs.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).mxs.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mxs.appId;
          ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.mMW += 1;
          localb.mNc.append(paramAnonymousObject + ":");
        }
        for (;;)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.f(AppBrandDesktopView.this));
          AppMethodBeat.o(49567);
          return;
          label194:
          if (paramAnonymousInt1 > paramAnonymousInt2)
          {
            localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mxs.appId;
            ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.mMV += 1;
            localb.mNb.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(com.tencent.mm.sdk.platformtools.ai.getContext()).getScaledTouchSlop();
    this.mxd = 0;
    this.mxe = 0.0F;
    this.mxf = 0.0F;
    this.mxg = false;
    this.mxh = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.uY = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.mxi = new AppBrandDesktopView.13(this);
    this.mxj = 0;
    this.mxk = -1;
    this.mxl = false;
    this.mxm = true;
    this.fuK = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.U(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.V(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.W(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).jW();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < AppBrandDesktopView.this.getChildCount()))
            {
              paramAnonymousInt1 = AppBrandDesktopView.this.getChildAt(paramAnonymousInt1).getTop();
              AppBrandDesktopView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(49573);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(49572);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
        if ((!AppBrandDesktopView.J(AppBrandDesktopView.this)) && (AppBrandDesktopView.I(AppBrandDesktopView.this)) && (paramAnonymousInt == 0))
        {
          AppBrandDesktopView.K(AppBrandDesktopView.this);
          AppBrandDesktopView.L(AppBrandDesktopView.this);
        }
        if (paramAnonymousInt == 0)
        {
          if (!AppBrandDesktopView.M(AppBrandDesktopView.this)) {
            break label214;
          }
          AppBrandDesktopView.N(AppBrandDesktopView.this);
          if (!AppBrandDesktopView.Q(AppBrandDesktopView.this)) {
            break label246;
          }
          if ((AppBrandDesktopView.R(AppBrandDesktopView.this)) && (!AppBrandDesktopView.S(AppBrandDesktopView.this)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null)) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).bBA();
          }
        }
        for (;;)
        {
          AppBrandDesktopView.k(AppBrandDesktopView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(49572);
          return;
          label214:
          if ((AppBrandDesktopView.O(AppBrandDesktopView.this) != 1) && (AppBrandDesktopView.O(AppBrandDesktopView.this) != 2)) {
            break;
          }
          AppBrandDesktopView.P(AppBrandDesktopView.this);
          break;
          label246:
          AppBrandDesktopView.T(AppBrandDesktopView.this);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(49604);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49605);
    this.anI = 4;
    this.ijj = new ArrayList();
    this.mwm = new ArrayList();
    this.mwn = 0;
    this.mwo = false;
    this.mwp = false;
    this.mwq = null;
    this.mwr = false;
    this.arZ = 0;
    this.aOy = 0;
    this.aOz = 0;
    this.mww = 0;
    this.mwx = 0;
    this.mwy = false;
    this.mwz = false;
    this.mwA = null;
    this.mwB = null;
    this.dtf = false;
    this.mwG = 0;
    this.mwH = 0;
    this.mwI = 0;
    this.mwJ = false;
    this.mwL = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 80);
    this.mwM = true;
    this.mwN = "";
    this.mwP = 0;
    this.guA = 0;
    this.mwQ = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.mwR = false;
    this.mwS = false;
    this.isPaused = false;
    this.mwT = false;
    this.mwU = false;
    this.mwV = false;
    this.mwW = false;
    this.mwX = 0;
    this.mwY = new AppBrandDesktopView.b(this, 1);
    this.mwZ = new AppBrandDesktopView.b(this, 2);
    this.mxa = false;
    this.mxb = false;
    this.mxc = 0;
    this.dnN = false;
    this.mvP = new AppBrandDesktopDragView.b()
    {
      public final void cI(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49564);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if (localc.mxs != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            ac.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bs.isNullOrNil(localc.mxs.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Sg(localc.mxs.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cJ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49565);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49565);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if ((localc.type == 1) && (localc.mxs != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.mzF.bzy();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.aX(localc.mxs.username, localc.mxs.hxM)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bs.isNullOrNil(localc.mxs.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Sf(localc.mxs.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cK(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.mxs != null)
        {
          ac.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.mxs.username, Integer.valueOf(paramAnonymousObject.mxs.hxM) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.mzF.bzx();
          if (locale != null) {
            bool = locale.aY(paramAnonymousObject.mxs.username, paramAnonymousObject.mxs.hxM);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.mxs != null) && (!bs.isNullOrNil(paramAnonymousObject.mxs.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).Se(paramAnonymousObject.mxs.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            ac.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.d(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
            if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.e(AppBrandDesktopView.this).getAdapter().cj(paramAnonymousObject.position);
            }
          }
        }
        AppMethodBeat.o(49566);
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        AppBrandDesktopView.a(AppBrandDesktopView.this, true);
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).mxs != null) && (!bs.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).mxs.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mxs.appId;
          ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.mMW += 1;
          localb.mNc.append(paramAnonymousObject + ":");
        }
        for (;;)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.f(AppBrandDesktopView.this));
          AppMethodBeat.o(49567);
          return;
          label194:
          if (paramAnonymousInt1 > paramAnonymousInt2)
          {
            localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mxs.appId;
            ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.mMV += 1;
            localb.mNb.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(com.tencent.mm.sdk.platformtools.ai.getContext()).getScaledTouchSlop();
    this.mxd = 0;
    this.mxe = 0.0F;
    this.mxf = 0.0F;
    this.mxg = false;
    this.mxh = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.uY = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.mxi = new AppBrandDesktopView.13(this);
    this.mxj = 0;
    this.mxk = -1;
    this.mxl = false;
    this.mxm = true;
    this.fuK = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.U(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.V(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.W(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).jW();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < AppBrandDesktopView.this.getChildCount()))
            {
              paramAnonymousInt1 = AppBrandDesktopView.this.getChildAt(paramAnonymousInt1).getTop();
              AppBrandDesktopView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(49573);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(49572);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
        if ((!AppBrandDesktopView.J(AppBrandDesktopView.this)) && (AppBrandDesktopView.I(AppBrandDesktopView.this)) && (paramAnonymousInt == 0))
        {
          AppBrandDesktopView.K(AppBrandDesktopView.this);
          AppBrandDesktopView.L(AppBrandDesktopView.this);
        }
        if (paramAnonymousInt == 0)
        {
          if (!AppBrandDesktopView.M(AppBrandDesktopView.this)) {
            break label214;
          }
          AppBrandDesktopView.N(AppBrandDesktopView.this);
          if (!AppBrandDesktopView.Q(AppBrandDesktopView.this)) {
            break label246;
          }
          if ((AppBrandDesktopView.R(AppBrandDesktopView.this)) && (!AppBrandDesktopView.S(AppBrandDesktopView.this)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null)) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).bBA();
          }
        }
        for (;;)
        {
          AppBrandDesktopView.k(AppBrandDesktopView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(49572);
          return;
          label214:
          if ((AppBrandDesktopView.O(AppBrandDesktopView.this) != 1) && (AppBrandDesktopView.O(AppBrandDesktopView.this) != 2)) {
            break;
          }
          AppBrandDesktopView.P(AppBrandDesktopView.this);
          break;
          label246:
          AppBrandDesktopView.T(AppBrandDesktopView.this);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(49605);
  }
  
  private static ArrayList<String> bF(List<c> paramList)
  {
    AppMethodBeat.i(49619);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(49619);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      if ((localc.mxs != null) && (!bs.isNullOrNil(localc.mxs.appId))) {
        localArrayList.add(localc.mxs.appId);
      }
    }
    AppMethodBeat.o(49619);
    return localArrayList;
  }
  
  private void byQ()
  {
    AppMethodBeat.i(49602);
    this.ijj.clear();
    this.ijj.add(new c(6));
    this.ijj.add(new c(9));
    this.ijj.add(new c(3));
    this.mwo = false;
    this.mwp = false;
    this.mwJ = false;
    this.abe.arg.notifyChanged();
    hT(true);
    AppMethodBeat.o(49602);
  }
  
  private void byR()
  {
    int i = 0;
    AppMethodBeat.i(49603);
    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.mwI), Integer.valueOf(this.ijj.size() - 4), Integer.valueOf(1) });
    while (i <= 0)
    {
      this.ijj.add(new c(7));
      i += 1;
    }
    this.mwI = 1;
    AppMethodBeat.o(49603);
  }
  
  private void byS()
  {
    AppMethodBeat.i(49609);
    this.mwx = getItemPadding();
    AppMethodBeat.o(49609);
  }
  
  private void byU()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    AppMethodBeat.o(49614);
  }
  
  private void byV()
  {
    AppMethodBeat.i(49615);
    long l = System.currentTimeMillis();
    this.ijj.clear();
    this.mwm.clear();
    this.mwI = 0;
    this.mwJ = false;
    this.ijj.add(new c(6));
    Object localObject1 = c.mzF.bzx();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject1).ry(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.mzI.count);; localObject1 = null)
    {
      Object localObject2 = c.mzF.bzy();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject2).a(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.mzH.count, com.tencent.mm.plugin.appbrand.widget.desktop.b.d.mzH.jwi);; localObject2 = null)
      {
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          this.mwo = false;
          this.mwn = 2;
          if (this.mwv != null) {
            this.mwv.setCollectionStartPosition(this.mwn);
          }
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label248;
          }
        }
        label248:
        for (this.mwp = false;; this.mwp = true)
        {
          if ((this.mwo) || (this.mwp)) {
            break label256;
          }
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
          this.ijj.add(new c(9));
          this.ijj.add(new c(3));
          AppMethodBeat.o(49615);
          return;
          this.mwo = true;
          this.mwn = 4;
          break;
        }
        label256:
        new c(0);
        int i;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          c localc = new c(10);
          this.ijj.add(localc);
          this.ijj.add(new c(2));
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localc = new c(2);
            localc.mxs = ((LocalUsageInfo)((List)localObject1).get(i));
            this.mwm.add(localc);
            i += 1;
          }
        }
        this.ijj.add(new c(11));
        if (localObject2 != null)
        {
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = new c(1);
            ((c)localObject1).mxs = ((LocalUsageInfo)((List)localObject2).get(i));
            this.ijj.add(localObject1);
            i += 1;
          }
        }
        byR();
        if (!this.mwp)
        {
          this.ijj.add(new c(8));
          this.mwJ = true;
        }
        this.ijj.add(new c(3));
        if (this.mwv != null)
        {
          this.mwv.setCopyList(this.mwm);
          this.mwv.setList(this.ijj);
        }
        ac.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused) });
        if (this.aqk) {
          this.dtf = true;
        }
        this.abe.arg.notifyChanged();
        if (this.mwt != null)
        {
          ac.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
          this.mwt.setDataList(this.mwm);
          this.mwt.notifyDataSetChanged();
        }
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", new Object[] { Integer.valueOf(this.ijj.size()), Integer.valueOf(this.mwm.size()), Integer.valueOf(this.ijj.size() - this.mwn) });
        AppMethodBeat.o(49615);
        return;
      }
    }
  }
  
  private void byY()
  {
    AppMethodBeat.i(49623);
    if (this.mwK != null)
    {
      EditText localEditText = (EditText)this.mwK.findViewById(2131296709);
      if ((localEditText != null) && (!bs.isNullOrNil(this.mwN)))
      {
        ac.v("MicroMsg.AppBrandDesktopView", "alvinluo initSearchView searchWording: %s", new Object[] { this.mwN });
        localEditText.setHint(this.mwN);
      }
    }
    AppMethodBeat.o(49623);
  }
  
  private void byZ()
  {
    AppMethodBeat.i(49624);
    if (this.mtL != null)
    {
      View localView = this.mtL.getBackgroundGLSurfaceView();
      if ((localView != null) && (this.mws != null))
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
        this.mws.removeView(localView);
      }
    }
    AppMethodBeat.o(49624);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49613);
    int i = d.dY(getContext());
    AppMethodBeat.o(49613);
    return i;
  }
  
  private void hT(boolean paramBoolean)
  {
    AppMethodBeat.i(49627);
    RecyclerView.s locals;
    if (this.aru != null)
    {
      locals = this.aru;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 1)
    {
      locals.arZ = i;
      this.mwq.a(this.aru);
      AppMethodBeat.o(49627);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    this.mwH = 0;
    this.mwG = this.mwH;
    b.init(this.mContext);
    this.anI = b.getCompletelyCountPerPage();
    byS();
    byU();
    this.mwq = new j(this.anI);
    this.mwq.anN = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(49577);
        paramAnonymousInt = AppBrandDesktopView.this.getAdapter().getItemViewType(paramAnonymousInt);
        if ((paramAnonymousInt == 3) || (paramAnonymousInt == 11) || (paramAnonymousInt == 10) || (paramAnonymousInt == 2) || (paramAnonymousInt == 6) || (paramAnonymousInt == 8) || (paramAnonymousInt == 9))
        {
          paramAnonymousInt = AppBrandDesktopView.this.anI;
          AppMethodBeat.o(49577);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(49577);
        return 1;
      }
    };
    setLayoutManager(this.mwq);
    setOverScrollMode(2);
    a(this.fuK);
    this.abe = new e((byte)0);
    setAdapter(this.abe);
    byV();
    byT();
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49578);
        AppBrandDesktopView.q(AppBrandDesktopView.this);
        AppMethodBeat.o(49578);
      }
    }, 200L);
    ac.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mwL) });
    this.mxc = com.tencent.mm.cc.a.fromDPToPix(paramContext, 200);
    this.mxj = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
    this.mxd = com.tencent.mm.cc.a.fromDPToPix(paramContext, 100);
    this.aru = new android.support.v7.widget.ae(getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 20.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF bZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(49579);
        PointF localPointF = AppBrandDesktopView.j(AppBrandDesktopView.this).bZ(paramAnonymousInt);
        AppMethodBeat.o(49579);
        return localPointF;
      }
      
      public final int ke()
      {
        return -1;
      }
    };
    AppMethodBeat.o(49611);
  }
  
  private void setIgnoreNotify(boolean paramBoolean)
  {
    if (this.mwZ != null) {
      this.mwZ.mwS = paramBoolean;
    }
    if (this.mwY != null) {
      this.mwY.mwS = paramBoolean;
    }
  }
  
  private boolean vv(int paramInt)
  {
    AppMethodBeat.i(49601);
    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ijj.size())
    {
      localObject = (c)this.ijj.get(i);
      if ((((c)localObject).type == 1) && (((c)localObject).mxs != null)) {
        localArrayList.add(((c)localObject).mxs);
      }
      i += 1;
    }
    Object localObject = c.mzF.bzy();
    if (localObject == null)
    {
      AppMethodBeat.o(49601);
      return false;
    }
    boolean bool = ((ah)localObject).g(localArrayList, paramInt);
    if (!bool) {
      ac.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
    }
    AppMethodBeat.o(49601);
    return bool;
  }
  
  final void aK(float paramFloat)
  {
    AppMethodBeat.i(49626);
    RecyclerView.w localw;
    if (this.mwo)
    {
      localw = ci(1);
      if ((localw != null) && (localw.asD != null)) {
        localw.asD.setAlpha(paramFloat);
      }
    }
    if (this.mwo) {}
    for (int i = 3;; i = 1)
    {
      localw = ci(i);
      if ((localw != null) && (localw.asD != null)) {
        localw.asD.setAlpha(paramFloat);
      }
      ac.v("MicroMsg.AppBrandDesktopView", "alvinluo updateTitleAlpha hasRecentData: %b, hasMyData: %b, alpha: %f", new Object[] { Boolean.valueOf(this.mwo), Boolean.valueOf(this.mwp), Float.valueOf(paramFloat) });
      AppMethodBeat.o(49626);
      return;
    }
  }
  
  final void byT()
  {
    AppMethodBeat.i(49612);
    if (this.mxa)
    {
      AppMethodBeat.o(49612);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.mzF.bzx();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.mzF.bzy();
    if ((locale == null) || (localb == null))
    {
      AppMethodBeat.o(49612);
      return;
    }
    this.mxa = true;
    locale.remove(this.mwZ);
    locale.add(this.mwZ);
    localb.remove(this.mwY);
    localb.add(this.mwY);
    AppMethodBeat.o(49612);
  }
  
  public final void byW()
  {
    AppMethodBeat.i(49618);
    ac.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
    if (!this.mwR)
    {
      setIgnoreNotify(true);
      c.mzF.bzy();
      removeCallbacks(this.mxi);
      postDelayed(this.mxi, 600L);
      j.QE(j.btg());
      Object localObject1 = this.mwN;
      Object localObject2 = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLs, null);
      if ((localObject2 instanceof String)) {
        this.mwN = bs.bG((String)localObject2, this.mwN);
      }
      ac.d("MicroMsg.AppBrandDesktopView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.mwN });
      byY();
      if ((this.mwQ != null) && (this.mwu != null))
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", new Object[] { Integer.valueOf(this.mwu.getShowCount()), Integer.valueOf(getCollectionDataSize()) });
        this.mwQ.ey(this.mwu.getShowCount(), getCollectionDataSize());
        this.mwQ.bBA();
        if (this.mwQ != null)
        {
          if (this.mwu != null) {
            this.mwQ.mNh = TextUtils.join(":", bF(this.mwu.getShowList()));
          }
          localObject1 = new ArrayList();
          localObject2 = this.ijj.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            c localc = (c)((Iterator)localObject2).next();
            if (localc.type == 1) {
              ((List)localObject1).add(localc);
            }
          } while (((List)localObject1).size() < 20);
          this.mwQ.mNi = TextUtils.join(":", bF((List)localObject1));
        }
        com.tencent.e.h.JZN.aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49581);
            if ((AppBrandDesktopView.r(AppBrandDesktopView.this)) && (AppBrandDesktopView.s(AppBrandDesktopView.this)))
            {
              if (AppBrandDesktopView.e(AppBrandDesktopView.this) == null)
              {
                AppMethodBeat.o(49581);
                return;
              }
              Object localObject1 = AppBrandDesktopView.e(AppBrandDesktopView.this).getShowList();
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              Object localObject2;
              while (i < ((List)localObject1).size())
              {
                localObject2 = (AppBrandDesktopView.c)((List)localObject1).get(i);
                if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).mxs != null))
                {
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).mxs);
                  ((com.tencent.mm.plugin.appbrand.widget.recentview.a)localObject2).position = i;
                  localArrayList.add(localObject2);
                }
                i += 1;
              }
              localObject1 = new ArrayList();
              i = AppBrandDesktopView.f(AppBrandDesktopView.this);
              while (i < AppBrandDesktopView.m(AppBrandDesktopView.this).size())
              {
                localObject2 = (AppBrandDesktopView.c)AppBrandDesktopView.m(AppBrandDesktopView.this).get(i);
                if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).type == 1))
                {
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).mxs);
                  ((com.tencent.mm.plugin.appbrand.widget.recentview.a)localObject2).position = i;
                  ((List)localObject1).add(localObject2);
                }
                i += 1;
              }
              com.tencent.mm.plugin.appbrand.widget.recentview.b.j(localArrayList, (List)localObject1);
            }
            AppMethodBeat.o(49581);
          }
        });
      }
      this.mwR = true;
      this.mwU = true;
      this.mwV = true;
      com.tencent.mm.modelappbrand.b.aAy();
      com.tencent.mm.plugin.websearch.api.z.uT(0L);
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(49618);
  }
  
  public final void byX()
  {
    AppMethodBeat.i(49622);
    byW();
    AppMethodBeat.o(49622);
  }
  
  final void bza()
  {
    AppMethodBeat.i(49625);
    Object localObject;
    if (!this.mwT)
    {
      if ((this.mtL != null) && (b.abe()))
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.mtL.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.mtL.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(1.0F);
        }
        if ((this.mtL.getBackgroundGLSurfaceView() instanceof DynamicBackgroundGLSurfaceView)) {
          this.mxb = true;
        }
        AppMethodBeat.o(49625);
      }
    }
    else
    {
      this.mxb = false;
      if ((this.mtL != null) && (b.abe()))
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.mtL.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.mtL.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setAlpha(1.0F);
          ((View)localObject).setVisibility(0);
        }
        byZ();
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49569);
            AppBrandDesktopView.t(AppBrandDesktopView.this);
            AppMethodBeat.o(49569);
          }
        }, 200L);
      }
    }
    AppMethodBeat.o(49625);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49607);
    boolean bool;
    if (this.mxR)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(49607);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(49607);
      return bool;
    case 0: 
      this.mxe = paramMotionEvent.getRawY();
      this.mwz = true;
    }
    for (;;)
    {
      this.mxf = 0.0F;
      this.mxg = false;
      this.mxh = false;
      break;
      ac.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.mxg), Float.valueOf(this.mxf), Integer.valueOf(this.mTouchSlop) });
      if ((this.mwq != null) && (this.ijj != null))
      {
        i = this.mwq.jZ();
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ijj.size()) });
        if (i == this.ijj.size() - 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && (!this.mxg))
        {
          if (!this.mxh)
          {
            this.mxe = paramMotionEvent.getRawY();
            this.mxf = 0.0F;
            this.mxh = true;
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          this.mxf = ((paramMotionEvent.getRawY() - this.mxe) * 0.55F);
          if (this.mxf >= -this.mTouchSlop) {
            break;
          }
          this.mxg = true;
          break;
        }
      }
      if (!this.mxg) {
        break;
      }
      this.mxf = ((paramMotionEvent.getRawY() - this.mxe) * 0.55F);
      if (this.mxf > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      int i = (int)Math.abs(this.mxf);
      ac.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(49607);
      return true;
      if (this.mxg)
      {
        this.mwz = false;
        if ((Math.abs(this.mxf) >= this.mxd) && (this.mtL != null))
        {
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.mtL.l(0L, 15);
        }
        animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.uY).start();
      }
    }
  }
  
  int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    if (!this.mwp)
    {
      AppMethodBeat.o(49617);
      return 0;
    }
    int i = this.ijj.size();
    int j = this.mwn;
    int k = this.mwI;
    AppMethodBeat.o(49617);
    return i - j - k - 1;
  }
  
  public int getLeftRightMargin()
  {
    AppMethodBeat.i(49610);
    int j = d.dZ(getContext()) - this.mwx;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mwx) });
    AppMethodBeat.o(49610);
    return i;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(49608);
    super.onAttachedToWindow();
    View localView = getRootView();
    if (localView == null)
    {
      AppMethodBeat.o(49608);
      return;
    }
    this.mwv = ((AppBrandDesktopDragView)localView.findViewById(2131299233));
    if (this.mwv == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", new Object[] { Boolean.valueOf(bool) });
      this.mwv.setRecyclerView(this);
      this.mwv.setCopyList(this.mwm);
      this.mwv.setList(this.ijj);
      this.mwv.setHeaderContainer(this.mtL);
      this.mwv.setCollectionCallback(this.mvP);
      this.mwv.setItemPadding(this.mwx);
      this.mwv.setAppBrandCounter(new a((byte)0));
      this.mwv.setViewWidth(this.aOy);
      this.mwv.setRecyclerViewScrollComputer(new g()
      {
        public final int computeVerticalScrollOffset()
        {
          AppMethodBeat.i(49576);
          if (AppBrandDesktopView.this.getChildCount() == 0)
          {
            AppMethodBeat.o(49576);
            return 0;
          }
          for (;;)
          {
            int j;
            try
            {
              int m = AppBrandDesktopView.j(AppBrandDesktopView.this).jW();
              int i = -(int)AppBrandDesktopView.j(AppBrandDesktopView.this).bY(m).getY();
              ac.d("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", new Object[] { Integer.valueOf(i) });
              j = 0;
              if (j < m)
              {
                AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.m(AppBrandDesktopView.this).get(j);
                if (localc != null)
                {
                  int k = localc.type;
                  ac.d("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
                  if ((k == 10) || (k == 11))
                  {
                    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.n(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 6)
                  {
                    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.o(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 2)
                  {
                    k = AppBrandDesktopView.p(AppBrandDesktopView.this);
                    if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null) {
                      k = AppBrandDesktopView.p(AppBrandDesktopView.this) * AppBrandDesktopView.c(AppBrandDesktopView.this).getShowLines();
                    }
                    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", new Object[] { Integer.valueOf(k) });
                    i = k + i;
                  }
                  else if ((k == 1) && ((j - AppBrandDesktopView.f(AppBrandDesktopView.this)) % 4 == 0))
                  {
                    ac.d("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)) });
                    k = AppBrandDesktopView.p(AppBrandDesktopView.this);
                    i = k + i;
                  }
                }
              }
              else
              {
                AppMethodBeat.o(49576);
                return i;
              }
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo compute exception", new Object[0]);
              AppMethodBeat.o(49576);
              return 0;
            }
            j += 1;
          }
        }
        
        public final int computeVerticalScrollRange()
        {
          AppMethodBeat.i(49575);
          int i = AppBrandDesktopView.k(AppBrandDesktopView.this);
          int j = AppBrandDesktopView.l(AppBrandDesktopView.this);
          AppMethodBeat.o(49575);
          return i + j;
        }
      });
      this.mxY = this.mwv;
      if ((this.mwv != null) && ((this.mwv.getParent() instanceof RelativeLayout)))
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
        this.mws = ((RelativeLayout)this.mwv.getParent());
      }
      AppMethodBeat.o(49608);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49616);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    this.aOy = paramInt1;
    this.aOz = paramInt2;
    paramInt1 = d.b(this.aOy, getContext());
    if (paramInt1 != this.mwx)
    {
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", new Object[] { Integer.valueOf(this.mwx), Integer.valueOf(paramInt1) });
      b.init(getContext());
      this.mwx = paramInt1;
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", new Object[] { Integer.valueOf(this.mwx) });
      if (this.mwt != null)
      {
        this.mwt.setItemPadding(this.mwx);
        if (this.mwu != null) {
          this.mwu.bzd();
        }
      }
      if (this.abe != null) {
        this.abe.arg.notifyChanged();
      }
      if (this.mtL != null) {
        this.mtL.byI();
      }
      if (this.mwv != null) {
        this.mwv.setItemPadding(paramInt1);
      }
    }
    if (this.mwv != null) {
      this.mwv.setViewWidth(this.aOy);
    }
    if ((!this.mxR) && (this.mtL != null) && (this.mww != this.mtL.getViewHeight()))
    {
      this.mww = this.mtL.getViewHeight();
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.mww), Integer.valueOf(this.mtL.getMeasuredHeight()) });
    }
    AppMethodBeat.o(49616);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(49606);
    super.onVisibilityChanged(paramView, paramInt);
    ac.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.mwW) && (this.mtL != null))
      {
        this.mtL.m(100L, this.mwX);
        this.mwX = 0;
        this.mwW = false;
      }
      if (this.dtf)
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
        this.dtf = false;
        if (this.mwB != null) {
          removeCallbacks(this.mwB);
        }
        paramView = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49574);
            AppBrandDesktopView.this.setLayoutFrozen(false);
            AppMethodBeat.o(49574);
          }
        };
        this.mwB = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(49606);
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.mtL = paramHeaderContainer;
  }
  
  public final void vw(int paramInt)
  {
    AppMethodBeat.i(49620);
    ac.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader] reason: %d", new Object[] { Integer.valueOf(paramInt) });
    removeCallbacks(this.mxi);
    if (this.mwR)
    {
      if ((this.mwQ != null) && (this.mwu != null))
      {
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb = this.mwQ;
        boolean bool = b.abe();
        localb.mNg = bool;
        ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", new Object[] { Boolean.valueOf(bool) });
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", new Object[] { Integer.valueOf(this.mwu.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(paramInt) });
        localb = this.mwQ;
        int i = b.byF();
        int j = this.mwu.getShowLines();
        int k = b.getCompletelyCountPerPage();
        localb.mMJ = i;
        localb.mMK = j;
        localb.mML = k;
        localb = this.mwQ;
        i = this.mwu.getShowCount();
        j = getCollectionDataSize();
        localb.mMF = i;
        localb.mMR = j;
        localb.mMC = paramInt;
        com.tencent.e.h.JZN.aS(new b.2(localb));
        if (localb.mNh == null) {
          localb.mNh = "";
        }
        if (localb.mNi == null) {
          localb.mNi = "";
        }
        ac.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportShowAppIdList openSession: %d, recentShowAppIdList: %s, %d, starShowAppIdList: %s, %d", new Object[] { Integer.valueOf(localb.mMB), localb.mNh, Integer.valueOf(localb.mNh.length()), localb.mNi, Integer.valueOf(localb.mNi.length()) });
        com.tencent.mm.plugin.report.service.h.wUl.f(18446, new Object[] { Integer.valueOf(localb.mMB), localb.mNh, localb.mNi });
      }
      this.mwR = false;
      this.mwU = false;
      this.mwV = false;
      if ((paramInt != 9) && (paramInt != 13)) {
        break label459;
      }
      if (this.mwY != null) {
        this.mwY.mwS = false;
      }
    }
    for (;;)
    {
      if (this.mwZ != null) {
        this.mwZ.mwS = false;
      }
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49568);
          AppBrandDesktopView.q(AppBrandDesktopView.this);
          AppMethodBeat.o(49568);
        }
      }, 300L);
      vv(1);
      AppMethodBeat.o(49620);
      return;
      label459:
      if (this.mwY != null) {
        this.mwY.mwS = true;
      }
    }
  }
  
  public final void vx(int paramInt)
  {
    AppMethodBeat.i(49621);
    vw(paramInt);
    AppMethodBeat.o(49621);
  }
  
  final class a
    implements AppBrandDesktopDragView.a
  {
    private a() {}
    
    public final int byP()
    {
      AppMethodBeat.i(49582);
      int i = AppBrandDesktopView.g(AppBrandDesktopView.this);
      AppMethodBeat.o(49582);
      return i;
    }
  }
  
  public static final class c
  {
    public LocalUsageInfo mxs;
    public int position;
    public int type;
    
    public c(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  final class e
    extends RecyclerView.a
  {
    private e() {}
    
    private AppBrandDesktopView.c vy(int paramInt)
    {
      AppMethodBeat.i(49593);
      if ((paramInt < AppBrandDesktopView.m(AppBrandDesktopView.this).size()) && (paramInt >= 0))
      {
        AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.m(AppBrandDesktopView.this).get(paramInt);
        AppMethodBeat.o(49593);
        return localc;
      }
      AppMethodBeat.o(49593);
      return null;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(49589);
      if (paramInt == 1)
      {
        paramViewGroup = new e(com.tencent.mm.ui.z.jD(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false));
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 2)
      {
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
        AppBrandDesktopView.a(AppBrandDesktopView.this, new RecentAppBrandViewContainer(AppBrandDesktopView.this.getContext()));
        paramViewGroup = new RecyclerView.LayoutParams(-1, -2);
        AppBrandDesktopView.c(AppBrandDesktopView.this).setLayoutParams(paramViewGroup);
        AppBrandDesktopView.c(AppBrandDesktopView.this).setItemPadding(AppBrandDesktopView.u(AppBrandDesktopView.this));
        AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.c(AppBrandDesktopView.this).getRecentView());
        if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null)
        {
          AppBrandDesktopView.e(AppBrandDesktopView.this).setReporter(AppBrandDesktopView.b(AppBrandDesktopView.this));
          AppBrandDesktopView.e(AppBrandDesktopView.this).setOnItemClickListener(new RecentAppBrandView.b()
          {
            public final void a(RecyclerView.w paramAnonymousw, AppBrandDesktopView.c paramAnonymousc)
            {
              AppMethodBeat.i(49586);
              AppBrandDesktopView.v(AppBrandDesktopView.this);
              AppBrandDesktopView.w(AppBrandDesktopView.this);
              AppBrandDesktopView.x(AppBrandDesktopView.this);
              AppBrandDesktopView.this.setLayoutFrozen(true);
              if (paramAnonymousc != null) {
                AppBrandDesktopView.a(AppBrandDesktopView.this, 1089, 2, paramAnonymousc.mxs, paramAnonymousw.lv());
              }
              AppMethodBeat.o(49586);
            }
          });
        }
        AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
        AppBrandDesktopView.c(AppBrandDesktopView.this).setOnMoreClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49587);
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.y(AppBrandDesktopView.this);
            AppBrandDesktopView.c(AppBrandDesktopView.this, 9);
            p localp = (p)com.tencent.mm.kernel.g.ab(p.class);
            paramAnonymousView = paramAnonymousView.getContext();
            if (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) {}
            for (int i = AppBrandDesktopView.b(AppBrandDesktopView.this).mMB;; i = 0)
            {
              localp.d(paramAnonymousView, 13, i);
              AppMethodBeat.o(49587);
              return;
            }
          }
        });
        paramViewGroup = new RecyclerView.w(AppBrandDesktopView.c(AppBrandDesktopView.this)) {};
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      RecyclerView.LayoutParams localLayoutParams;
      if (paramInt == 3)
      {
        paramViewGroup = new View(AppBrandDesktopView.this.getContext());
        localLayoutParams = new RecyclerView.LayoutParams(-1, AppBrandDesktopView.l(AppBrandDesktopView.this));
        localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), localLayoutParams.bottomMargin);
        paramViewGroup.setLayoutParams(localLayoutParams);
        paramViewGroup = new AppBrandDesktopView.h(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 6) {
        try
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, com.tencent.mm.ui.z.jD(AppBrandDesktopView.this.getContext()).inflate(2131492989, paramViewGroup, false));
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.z(AppBrandDesktopView.this));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
        catch (Exception paramViewGroup)
        {
          ac.printErrStackTrace("MicroMsg.AppBrandDesktopView", paramViewGroup, "alvinluo init searchView exception", new Object[0]);
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, new View(AppBrandDesktopView.this.getContext()));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
      }
      if (paramInt == 7)
      {
        paramViewGroup = com.tencent.mm.ui.z.jD(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false);
        localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
        localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), localLayoutParams.bottomMargin);
        paramViewGroup.setLayoutParams(localLayoutParams);
        AppBrandDesktopView.b(AppBrandDesktopView.this, paramViewGroup);
        paramViewGroup = new e(paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 8)
      {
        paramViewGroup = com.tencent.mm.ui.z.jD(AppBrandDesktopView.this.getContext()).inflate(2131492981, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.f(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 9)
      {
        paramViewGroup = com.tencent.mm.ui.z.jD(AppBrandDesktopView.this.getContext()).inflate(2131492984, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.d(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      paramViewGroup = com.tencent.mm.ui.z.jD(AppBrandDesktopView.this.getContext()).inflate(2131494989, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.h(AppBrandDesktopView.this, paramViewGroup);
      AppMethodBeat.o(49589);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(49591);
      int j = paramw.asH;
      Object localObject1;
      if (j == 3)
      {
        paramInt = AppBrandDesktopView.l(AppBrandDesktopView.this);
        if (AppBrandDesktopView.B(AppBrandDesktopView.this) == 0) {
          AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.C(AppBrandDesktopView.this).getViewHeight());
        }
        i = AppBrandDesktopView.B(AppBrandDesktopView.this) - com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 56) - com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 48);
        j = AppBrandDesktopView.k(AppBrandDesktopView.this);
        if (j > AppBrandDesktopView.o(AppBrandDesktopView.this) + i) {
          AppBrandDesktopView.h(AppBrandDesktopView.this, AppBrandDesktopView.D(AppBrandDesktopView.this));
        }
        for (;;)
        {
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)), Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)), Integer.valueOf(j), Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)), Integer.valueOf(paramInt), Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
          paramw.asD.setVisibility(4);
          localObject1 = (RecyclerView.LayoutParams)paramw.asD.getLayoutParams();
          ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.l(AppBrandDesktopView.this);
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)) });
          paramw.asD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          AppMethodBeat.o(49591);
          return;
          if (j > i) {
            AppBrandDesktopView.h(AppBrandDesktopView.this, AppBrandDesktopView.o(AppBrandDesktopView.this) - (j - i));
          } else {
            AppBrandDesktopView.h(AppBrandDesktopView.this, i - j + AppBrandDesktopView.o(AppBrandDesktopView.this));
          }
        }
      }
      Object localObject2;
      if ((j == 10) || (j == 11))
      {
        if (paramw == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        localObject1 = paramw.asD;
        paramInt = AppBrandDesktopView.u(AppBrandDesktopView.this) + (int)(com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8) * d.eb(AppBrandDesktopView.this.getContext()));
        localObject2 = new RecyclerView.LayoutParams(-1, -2);
        ((RecyclerView.LayoutParams)localObject2).setMargins(((RecyclerView.LayoutParams)localObject2).leftMargin + paramInt, ((RecyclerView.LayoutParams)localObject2).topMargin, paramInt + ((RecyclerView.LayoutParams)localObject2).rightMargin, ((RecyclerView.LayoutParams)localObject2).bottomMargin);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject1 = paramw.asD;
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", new Object[] { Integer.valueOf(((View)localObject1).getMeasuredHeight()), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
          AppBrandDesktopView.d(AppBrandDesktopView.this, ((View)localObject1).getMeasuredHeight());
        }
        paramw = ((AppBrandDesktopView.h)paramw).titleTv;
        if (j == 10) {}
        for (paramInt = 2131762214;; paramInt = 2131761482)
        {
          paramw.setText(paramInt);
          AppMethodBeat.o(49591);
          return;
        }
      }
      if (j == 8)
      {
        paramw = (AppBrandDesktopView.f)paramw;
        boolean bool;
        if (!AppBrandDesktopView.r(AppBrandDesktopView.this))
        {
          bool = true;
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(AppBrandDesktopView.p(paramw.mxn)) });
          if (!bool) {
            break label693;
          }
        }
        label693:
        for (paramInt = i;; paramInt = 4)
        {
          if ((AppBrandDesktopView.G(paramw.mxn) != null) && (bool)) {
            AppBrandDesktopView.G(paramw.mxn).getLayoutParams().height = AppBrandDesktopView.p(paramw.mxn);
          }
          if (paramw.asD != null) {
            paramw.asD.setVisibility(paramInt);
          }
          AppMethodBeat.o(49591);
          return;
          bool = false;
          break;
        }
      }
      if (j == 6)
      {
        AppBrandDesktopView.c(AppBrandDesktopView.this, paramw.asD);
        AppMethodBeat.o(49591);
        return;
      }
      if ((j == 2) || (j == 9))
      {
        AppMethodBeat.o(49591);
        return;
      }
      if ((j == 1) || (j == 7))
      {
        localObject1 = (e)paramw;
        ((e)localObject1).asD.setPadding(AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
        i = (int)d.ea(AppBrandDesktopView.this.getContext());
        ((e)localObject1).mxB.getLayoutParams().width = ((int)(com.tencent.mm.cc.a.av(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.eb(AppBrandDesktopView.this.getContext())) + i);
        ((e)localObject1).mxB.getLayoutParams().height = ((int)(com.tencent.mm.cc.a.av(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.eb(AppBrandDesktopView.this.getContext())) + i);
        ((e)localObject1).lzC.getLayoutParams().width = i;
        ((e)localObject1).lzC.getLayoutParams().height = i;
        ((e)localObject1).mxA.getLayoutParams().width = i;
        ((e)localObject1).mxA.getLayoutParams().height = i;
        paramw.asD.setVisibility(0);
        if (AppBrandDesktopView.p(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramw.asD;
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
          AppBrandDesktopView.e(AppBrandDesktopView.this, ((View)localObject2).getMeasuredHeight());
        }
        if (j == 7)
        {
          paramw.asD.setVisibility(4);
          if (((paramInt - AppBrandDesktopView.f(AppBrandDesktopView.this) + 1) % 4 == 1) && (paramInt > AppBrandDesktopView.f(AppBrandDesktopView.this)))
          {
            paramw.asD.getLayoutParams().height = 1;
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramw.asD.getLayoutParams().height);
            ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", new Object[] { Integer.valueOf(paramw.asD.getLayoutParams().height) });
            AppMethodBeat.o(49591);
            return;
          }
          if (AppBrandDesktopView.A(AppBrandDesktopView.this) == 0)
          {
            paramw = paramw.asD;
            paramw.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder emptyItemHeight: %d", new Object[] { Integer.valueOf(paramw.getMeasuredHeight()) });
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramw.getMeasuredHeight());
          }
          AppMethodBeat.o(49591);
          return;
        }
        localObject2 = vy(paramInt);
        if (localObject2 == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        ((AppBrandDesktopView.c)localObject2).position = paramInt;
        ((e)localObject1).mxE = ((AppBrandDesktopView.c)localObject2);
        if (((AppBrandDesktopView.c)localObject2).mxs == null) {
          break label1619;
        }
        if (bs.isNullOrNil(((AppBrandDesktopView.c)localObject2).mxs.ccm)) {
          break label1456;
        }
        ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.RK(((AppBrandDesktopView.c)localObject2).mxs.ccm));
        ((e)localObject1).titleTv.setVisibility(0);
        ((e)localObject1).mxA.setVisibility(0);
        if (bs.isNullOrNil(((AppBrandDesktopView.c)localObject2).mxs.jwf)) {
          break label1592;
        }
        com.tencent.mm.modelappbrand.a.b.aAS().a(((e)localObject1).lzC, ((AppBrandDesktopView.c)localObject2).mxs.jwf, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
        label1339:
        if (bs.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.rp(((AppBrandDesktopView.c)localObject2).mxs.hxM))) {
          break label1606;
        }
        ((e)localObject1).mxC.setVisibility(0);
        ((e)localObject1).mxC.setText(com.tencent.mm.plugin.appbrand.appcache.e.rp(((AppBrandDesktopView.c)localObject2).mxs.hxM));
        label1384:
        ((e)localObject1).asD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49588);
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.this.setLayoutFrozen(true);
            AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, this.mxu.mxs, this.mxv.lv());
            AppMethodBeat.o(49588);
          }
        });
      }
      for (;;)
      {
        if (AppBrandDesktopView.this.getDragRubbishView() != null)
        {
          localObject1 = AppBrandDesktopView.this.getDragRubbishView();
          if (((DragFeatureView)localObject1).getVisibility() != 8)
          {
            if (((DragFeatureView)localObject1).mxJ == paramInt)
            {
              paramw.asD.setVisibility(4);
              AppMethodBeat.o(49591);
              return;
              label1456:
              if (!bs.isNullOrNil(((AppBrandDesktopView.c)localObject2).mxs.nickname))
              {
                ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.RK(((AppBrandDesktopView.c)localObject2).mxs.nickname));
                ((e)localObject1).titleTv.setVisibility(0);
                break;
              }
              if (!bs.isNullOrNil(((AppBrandDesktopView.c)localObject2).mxs.username))
              {
                ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.RK(((AppBrandDesktopView.c)localObject2).mxs.nickname));
                ((e)localObject1).titleTv.setVisibility(0);
                break;
              }
              ac.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { ((AppBrandDesktopView.c)localObject2).mxs.username, ((AppBrandDesktopView.c)localObject2).mxs.appId });
              ((e)localObject1).titleTv.setVisibility(4);
              break;
              label1592:
              ((e)localObject1).lzC.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aAR());
              break label1339;
              label1606:
              ((e)localObject1).mxC.setVisibility(8);
              break label1384;
              label1619:
              com.tencent.mm.modelappbrand.a.b.aAS().a(((e)localObject1).lzC, "", com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
              ((e)localObject1).titleTv.setVisibility(0);
              ((e)localObject1).mxC.setVisibility(8);
              ((e)localObject1).titleTv.setText("");
              continue;
            }
            paramw.asD.setVisibility(0);
          }
        }
      }
      AppMethodBeat.o(49591);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(49592);
      int i = AppBrandDesktopView.m(AppBrandDesktopView.this).size();
      AppMethodBeat.o(49592);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(49590);
      AppBrandDesktopView.c localc = vy(paramInt);
      if (localc != null)
      {
        paramInt = localc.type;
        AppMethodBeat.o(49590);
        return paramInt;
      }
      AppMethodBeat.o(49590);
      return 0;
    }
  }
  
  public final class f
    extends RecyclerView.w
  {
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(49594);
      AppBrandDesktopView.i(AppBrandDesktopView.this, AppBrandDesktopView.p(AppBrandDesktopView.this));
      if ((AppBrandDesktopView.F(AppBrandDesktopView.this) == 0) && (this.asD != null))
      {
        this.asD.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.asD.getMeasuredHeight()), Integer.valueOf(this.asD.getMeasuredWidth()) });
        AppBrandDesktopView.i(AppBrandDesktopView.this, this.asD.getMeasuredHeight());
      }
      this$1 = new RecyclerView.LayoutParams(-1, -2);
      AppBrandDesktopView.this.setMargins(AppBrandDesktopView.this.leftMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), AppBrandDesktopView.this.topMargin - AppBrandDesktopView.F(AppBrandDesktopView.this), AppBrandDesktopView.this.rightMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), AppBrandDesktopView.this.bottomMargin);
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.this.topMargin) });
      if (this.asD != null) {
        this.asD.setLayoutParams(AppBrandDesktopView.this);
      }
      AppMethodBeat.o(49594);
    }
  }
  
  public final class g
    extends RecyclerView.w
  {
    protected EditText mxw;
    private long mxx;
    
    public g(View paramView)
    {
      super();
      AppMethodBeat.i(49596);
      this.mxx = 0L;
      this.mxw = ((EditText)paramView.findViewById(2131296709));
      if (this.mxw != null)
      {
        this.mxw.setFocusable(false);
        this.mxw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49595);
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            paramAnonymousView = AppBrandDesktopView.this;
            if ((paramAnonymousView.mtL != null) && (paramAnonymousView.mwR))
            {
              DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = (DynamicBackgroundGLSurfaceView)paramAnonymousView.mtL.getBackgroundGLSurfaceView();
              if (localDynamicBackgroundGLSurfaceView != null)
              {
                localDynamicBackgroundGLSurfaceView.onPause();
                paramAnonymousView.mwV = true;
                paramAnonymousView.mxb = true;
              }
            }
            ac.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
            long l = System.currentTimeMillis();
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && ((AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) == 0L) || (l - AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) > 1000L)))
            {
              AppBrandDesktopView.g.a(AppBrandDesktopView.g.this, l);
              paramAnonymousView = AppBrandDesktopView.b(AppBrandDesktopView.this);
              paramAnonymousView.mNf += 1;
              ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", new Object[] { Integer.valueOf(paramAnonymousView.mNf) });
            }
            paramAnonymousView = (com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class);
            if (paramAnonymousView != null) {
              paramAnonymousView.a(AppBrandDesktopView.i(AppBrandDesktopView.this), 42, AppBrandDesktopView.E(AppBrandDesktopView.this), "");
            }
            AppMethodBeat.o(49595);
          }
        });
      }
      AppMethodBeat.o(49596);
    }
  }
  
  final class i
    extends android.support.v7.widget.ae
  {
    i(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      return 300.0F / paramDisplayMetrics.densityDpi;
    }
    
    public final PointF bZ(int paramInt)
    {
      AppMethodBeat.i(49598);
      PointF localPointF = AppBrandDesktopView.j(AppBrandDesktopView.this).bZ(paramInt);
      AppMethodBeat.o(49598);
      return localPointF;
    }
    
    public final int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return paramInt3 - paramInt1;
    }
  }
  
  final class j
    extends GridLayoutManager
  {
    public j(int paramInt)
    {
      super(1);
    }
    
    public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
    {
      AppMethodBeat.i(49600);
      paramRecyclerView = new AppBrandDesktopView.i(AppBrandDesktopView.this, AppBrandDesktopView.i(AppBrandDesktopView.this));
      paramRecyclerView.arZ = paramInt;
      a(paramRecyclerView);
      AppMethodBeat.o(49600);
    }
    
    public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
    {
      AppMethodBeat.i(49599);
      try
      {
        super.c(paramo, paramt);
        AppMethodBeat.o(49599);
        return;
      }
      catch (IndexOutOfBoundsException paramo)
      {
        ac.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
        AppMethodBeat.o(49599);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */