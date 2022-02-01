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
import android.support.v7.widget.ae;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b.2;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopView
  extends DragRecyclerView
  implements c.a
{
  private int aYS;
  private int aYT;
  private RecyclerView.a acW;
  public int apA;
  private int atQ;
  private RecyclerView.s atl;
  private boolean dFh;
  boolean dzB;
  private RecyclerView.m fNG;
  int gOl;
  boolean isPaused;
  Context mContext;
  private ArrayList<c> mDataList;
  private Interpolator mInterpolator;
  private int mItemHeight;
  private int mTouchSlop;
  HeaderContainer mUr;
  private ArrayList<c> mWR;
  int mWS;
  boolean mWT;
  boolean mWU;
  private j mWV;
  private boolean mWW;
  private RelativeLayout mWX;
  RecentAppBrandViewContainer mWY;
  private RecentAppBrandView mWZ;
  private AppBrandDesktopDragView.b mWu;
  boolean mXA;
  int mXB;
  final b mXC;
  final b mXD;
  boolean mXE;
  boolean mXF;
  int mXG;
  private int mXH;
  private float mXI;
  private float mXJ;
  private boolean mXK;
  private boolean mXL;
  private final Runnable mXM;
  int mXN;
  private int mXO;
  private boolean mXP;
  private boolean mXQ;
  private AppBrandDesktopDragView mXa;
  int mXb;
  private int mXc;
  private boolean mXd;
  private boolean mXe;
  Runnable mXf;
  Runnable mXg;
  int mXh;
  private int mXi;
  private int mXj;
  private int mXk;
  private int mXl;
  private int mXm;
  private boolean mXn;
  private View mXo;
  private int mXp;
  private boolean mXq;
  private String mXr;
  private View mXs;
  private int mXt;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mXu;
  boolean mXv;
  private boolean mXw;
  boolean mXx;
  boolean mXy;
  boolean mXz;
  private Animator.AnimatorListener wR;
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.apA = 4;
    this.mDataList = new ArrayList();
    this.mWR = new ArrayList();
    this.mWS = 0;
    this.mWT = false;
    this.mWU = false;
    this.mWV = null;
    this.mWW = false;
    this.atQ = 0;
    this.aYS = 0;
    this.aYT = 0;
    this.mXb = 0;
    this.mXc = 0;
    this.mXd = false;
    this.mXe = false;
    this.mXf = null;
    this.mXg = null;
    this.dFh = false;
    this.mXk = 0;
    this.mXl = 0;
    this.mXm = 0;
    this.mXn = false;
    this.mXp = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 80);
    this.mXq = true;
    this.mXr = "";
    this.mXt = 0;
    this.gOl = 0;
    this.mXu = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.mXv = false;
    this.mXw = false;
    this.isPaused = false;
    this.mXx = false;
    this.mXy = false;
    this.mXz = false;
    this.mXA = false;
    this.mXB = 0;
    this.mXC = new b(this, 1);
    this.mXD = new b(this, 2);
    this.mXE = false;
    this.mXF = false;
    this.mXG = 0;
    this.dzB = false;
    this.mWu = new AppBrandDesktopDragView.b()
    {
      public final void cK(Object paramAnonymousObject)
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
          if (localc.mXW != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.mXW.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).VD(localc.mXW.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cL(Object paramAnonymousObject)
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
          if ((localc.type == 1) && (localc.mXW != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.nan.bDC();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.aZ(localc.mXW.username, localc.mXW.hQh)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.mXW.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).VC(localc.mXW.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cM(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.mXW != null)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.mXW.username, Integer.valueOf(paramAnonymousObject.mXW.hQh) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.nan.bDB();
          if (locale != null) {
            bool = locale.ba(paramAnonymousObject.mXW.username, paramAnonymousObject.mXW.hQh);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.mXW != null) && (!bt.isNullOrNil(paramAnonymousObject.mXW.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).VB(paramAnonymousObject.mXW.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).mXW != null) && (!bt.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).mXW.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mXW.appId;
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.nns += 1;
          localb.nny.append(paramAnonymousObject + ":");
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
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mXW.appId;
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.nnr += 1;
            localb.nnx.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.mXH = 0;
    this.mXI = 0.0F;
    this.mXJ = 0.0F;
    this.mXK = false;
    this.mXL = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wR = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.mXM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49580);
        AppBrandDesktopView.a(AppBrandDesktopView.this, false);
        c.nan.bDC().bbN();
        AppMethodBeat.o(49580);
      }
    };
    this.mXN = 0;
    this.mXO = -1;
    this.mXP = false;
    this.mXQ = true;
    this.fNG = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.U(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.V(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.W(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).km();
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
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
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
            AppBrandDesktopView.b(AppBrandDesktopView.this).bFC();
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
    this.apA = 4;
    this.mDataList = new ArrayList();
    this.mWR = new ArrayList();
    this.mWS = 0;
    this.mWT = false;
    this.mWU = false;
    this.mWV = null;
    this.mWW = false;
    this.atQ = 0;
    this.aYS = 0;
    this.aYT = 0;
    this.mXb = 0;
    this.mXc = 0;
    this.mXd = false;
    this.mXe = false;
    this.mXf = null;
    this.mXg = null;
    this.dFh = false;
    this.mXk = 0;
    this.mXl = 0;
    this.mXm = 0;
    this.mXn = false;
    this.mXp = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 80);
    this.mXq = true;
    this.mXr = "";
    this.mXt = 0;
    this.gOl = 0;
    this.mXu = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.mXv = false;
    this.mXw = false;
    this.isPaused = false;
    this.mXx = false;
    this.mXy = false;
    this.mXz = false;
    this.mXA = false;
    this.mXB = 0;
    this.mXC = new b(this, 1);
    this.mXD = new b(this, 2);
    this.mXE = false;
    this.mXF = false;
    this.mXG = 0;
    this.dzB = false;
    this.mWu = new AppBrandDesktopDragView.b()
    {
      public final void cK(Object paramAnonymousObject)
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
          if (localc.mXW != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.mXW.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).VD(localc.mXW.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cL(Object paramAnonymousObject)
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
          if ((localc.type == 1) && (localc.mXW != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.nan.bDC();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.aZ(localc.mXW.username, localc.mXW.hQh)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.mXW.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).VC(localc.mXW.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cM(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.mXW != null)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.mXW.username, Integer.valueOf(paramAnonymousObject.mXW.hQh) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.nan.bDB();
          if (locale != null) {
            bool = locale.ba(paramAnonymousObject.mXW.username, paramAnonymousObject.mXW.hQh);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.mXW != null) && (!bt.isNullOrNil(paramAnonymousObject.mXW.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).VB(paramAnonymousObject.mXW.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).mXW != null) && (!bt.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).mXW.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mXW.appId;
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.nns += 1;
          localb.nny.append(paramAnonymousObject + ":");
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
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).mXW.appId;
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.nnr += 1;
            localb.nnx.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.mXH = 0;
    this.mXI = 0.0F;
    this.mXJ = 0.0F;
    this.mXK = false;
    this.mXL = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wR = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.mXM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49580);
        AppBrandDesktopView.a(AppBrandDesktopView.this, false);
        c.nan.bDC().bbN();
        AppMethodBeat.o(49580);
      }
    };
    this.mXN = 0;
    this.mXO = -1;
    this.mXP = false;
    this.mXQ = true;
    this.fNG = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.U(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.V(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.W(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).km();
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
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
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
            AppBrandDesktopView.b(AppBrandDesktopView.this).bFC();
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
  
  private void bCT()
  {
    AppMethodBeat.i(49602);
    this.mDataList.clear();
    this.mDataList.add(new c(6));
    this.mDataList.add(new c(9));
    this.mDataList.add(new c(3));
    this.mWT = false;
    this.mWU = false;
    this.mXn = false;
    this.acW.asY.notifyChanged();
    id(true);
    AppMethodBeat.o(49602);
  }
  
  private void bCU()
  {
    int i = 0;
    AppMethodBeat.i(49603);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.mXm), Integer.valueOf(this.mDataList.size() - 4), Integer.valueOf(1) });
    while (i <= 0)
    {
      this.mDataList.add(new c(7));
      i += 1;
    }
    this.mXm = 1;
    AppMethodBeat.o(49603);
  }
  
  private void bCV()
  {
    AppMethodBeat.i(49609);
    this.mXc = getItemPadding();
    AppMethodBeat.o(49609);
  }
  
  private void bCX()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    AppMethodBeat.o(49614);
  }
  
  private void bCY()
  {
    AppMethodBeat.i(49615);
    long l = System.currentTimeMillis();
    this.mDataList.clear();
    this.mWR.clear();
    this.mXm = 0;
    this.mXn = false;
    this.mDataList.add(new c(6));
    Object localObject1 = c.nan.bDB();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject1).rY(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.naq.count);; localObject1 = null)
    {
      Object localObject2 = c.nan.bDC();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject2).a(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.nap.count, com.tencent.mm.plugin.appbrand.widget.desktop.b.d.nap.jQe);; localObject2 = null)
      {
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          this.mWT = false;
          this.mWS = 2;
          if (this.mXa != null) {
            this.mXa.setCollectionStartPosition(this.mWS);
          }
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label248;
          }
        }
        label248:
        for (this.mWU = false;; this.mWU = true)
        {
          if ((this.mWT) || (this.mWU)) {
            break label256;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
          this.mDataList.add(new c(9));
          this.mDataList.add(new c(3));
          AppMethodBeat.o(49615);
          return;
          this.mWT = true;
          this.mWS = 4;
          break;
        }
        label256:
        new c(0);
        int i;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          c localc = new c(10);
          this.mDataList.add(localc);
          this.mDataList.add(new c(2));
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localc = new c(2);
            localc.mXW = ((LocalUsageInfo)((List)localObject1).get(i));
            this.mWR.add(localc);
            i += 1;
          }
        }
        this.mDataList.add(new c(11));
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = new c(1);
            ((c)localObject1).mXW = ((LocalUsageInfo)((List)localObject2).get(i));
            this.mDataList.add(localObject1);
            i += 1;
          }
        }
        bCU();
        if (!this.mWU)
        {
          this.mDataList.add(new c(8));
          this.mXn = true;
        }
        this.mDataList.add(new c(3));
        if (this.mXa != null)
        {
          this.mXa.setCopyList(this.mWR);
          this.mXa.setList(this.mDataList);
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused) });
        if (this.asc) {
          this.dFh = true;
        }
        this.acW.asY.notifyChanged();
        if (this.mWY != null)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
          this.mWY.setDataList(this.mWR);
          this.mWY.notifyDataSetChanged();
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", new Object[] { Integer.valueOf(this.mDataList.size()), Integer.valueOf(this.mWR.size()), Integer.valueOf(this.mDataList.size() - this.mWS) });
        AppMethodBeat.o(49615);
        return;
      }
    }
  }
  
  private void bDb()
  {
    AppMethodBeat.i(49623);
    if (this.mXo != null)
    {
      EditText localEditText = (EditText)this.mXo.findViewById(2131296709);
      if ((localEditText != null) && (!bt.isNullOrNil(this.mXr)))
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandDesktopView", "alvinluo initSearchView searchWording: %s", new Object[] { this.mXr });
        localEditText.setHint(this.mXr);
      }
    }
    AppMethodBeat.o(49623);
  }
  
  private void bDc()
  {
    AppMethodBeat.i(49624);
    if (this.mUr != null)
    {
      View localView = this.mUr.getBackgroundGLSurfaceView();
      if ((localView != null) && (this.mWX != null))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
        this.mWX.removeView(localView);
      }
    }
    AppMethodBeat.o(49624);
  }
  
  private static ArrayList<String> bH(List<c> paramList)
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
      if ((localc.mXW != null) && (!bt.isNullOrNil(localc.mXW.appId))) {
        localArrayList.add(localc.mXW.appId);
      }
    }
    AppMethodBeat.o(49619);
    return localArrayList;
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49613);
    int i = d.dY(getContext());
    AppMethodBeat.o(49613);
    return i;
  }
  
  private void id(boolean paramBoolean)
  {
    AppMethodBeat.i(49627);
    RecyclerView.s locals;
    if (this.atl != null)
    {
      locals = this.atl;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 1)
    {
      locals.atQ = i;
      this.mWV.a(this.atl);
      AppMethodBeat.o(49627);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    this.mXl = 0;
    this.mXk = this.mXl;
    b.init(this.mContext);
    this.apA = b.getCompletelyCountPerPage();
    bCV();
    bCX();
    this.mWV = new j(this.apA);
    this.mWV.apF = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(49577);
        paramAnonymousInt = AppBrandDesktopView.this.getAdapter().getItemViewType(paramAnonymousInt);
        if ((paramAnonymousInt == 3) || (paramAnonymousInt == 11) || (paramAnonymousInt == 10) || (paramAnonymousInt == 2) || (paramAnonymousInt == 6) || (paramAnonymousInt == 8) || (paramAnonymousInt == 9))
        {
          paramAnonymousInt = AppBrandDesktopView.this.apA;
          AppMethodBeat.o(49577);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(49577);
        return 1;
      }
    };
    setLayoutManager(this.mWV);
    setOverScrollMode(2);
    a(this.fNG);
    this.acW = new e((byte)0);
    setAdapter(this.acW);
    bCY();
    bCW();
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49578);
        AppBrandDesktopView.q(AppBrandDesktopView.this);
        AppMethodBeat.o(49578);
      }
    }, 200L);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mXp) });
    this.mXG = com.tencent.mm.cc.a.fromDPToPix(paramContext, 200);
    this.mXN = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
    this.mXH = com.tencent.mm.cc.a.fromDPToPix(paramContext, 100);
    this.atl = new ae(getContext())
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
      
      public final int ku()
      {
        return -1;
      }
    };
    AppMethodBeat.o(49611);
  }
  
  private void setIgnoreNotify(boolean paramBoolean)
  {
    if (this.mXD != null) {
      this.mXD.mXw = paramBoolean;
    }
    if (this.mXC != null) {
      this.mXC.mXw = paramBoolean;
    }
  }
  
  private boolean wb(int paramInt)
  {
    AppMethodBeat.i(49601);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mDataList.size())
    {
      localObject = (c)this.mDataList.get(i);
      if ((((c)localObject).type == 1) && (((c)localObject).mXW != null)) {
        localArrayList.add(((c)localObject).mXW);
      }
      i += 1;
    }
    Object localObject = c.nan.bDC();
    if (localObject == null)
    {
      AppMethodBeat.o(49601);
      return false;
    }
    boolean bool = ((ah)localObject).g(localArrayList, paramInt);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
    }
    AppMethodBeat.o(49601);
    return bool;
  }
  
  final void aN(float paramFloat)
  {
    AppMethodBeat.i(49626);
    RecyclerView.w localw;
    if (this.mWT)
    {
      localw = ci(1);
      if ((localw != null) && (localw.auu != null)) {
        localw.auu.setAlpha(paramFloat);
      }
    }
    if (this.mWT) {}
    for (int i = 3;; i = 1)
    {
      localw = ci(i);
      if ((localw != null) && (localw.auu != null)) {
        localw.auu.setAlpha(paramFloat);
      }
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandDesktopView", "alvinluo updateTitleAlpha hasRecentData: %b, hasMyData: %b, alpha: %f", new Object[] { Boolean.valueOf(this.mWT), Boolean.valueOf(this.mWU), Float.valueOf(paramFloat) });
      AppMethodBeat.o(49626);
      return;
    }
  }
  
  final void bCW()
  {
    AppMethodBeat.i(49612);
    if (this.mXE)
    {
      AppMethodBeat.o(49612);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.nan.bDB();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.nan.bDC();
    if ((locale == null) || (localb == null))
    {
      AppMethodBeat.o(49612);
      return;
    }
    this.mXE = true;
    locale.remove(this.mXD);
    locale.add(this.mXD);
    localb.remove(this.mXC);
    localb.add(this.mXC);
    AppMethodBeat.o(49612);
  }
  
  public final void bCZ()
  {
    AppMethodBeat.i(49618);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
    if (!this.mXv)
    {
      setIgnoreNotify(true);
      c.nan.bDC();
      removeCallbacks(this.mXM);
      postDelayed(this.mXM, 600L);
      k.Uk(k.bxl());
      Object localObject1 = this.mXr;
      Object localObject2 = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxK, null);
      if ((localObject2 instanceof String)) {
        this.mXr = bt.bI((String)localObject2, this.mXr);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.mXr });
      bDb();
      if ((this.mXu != null) && (this.mWZ != null))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", new Object[] { Integer.valueOf(this.mWZ.getShowCount()), Integer.valueOf(getCollectionDataSize()) });
        this.mXu.eB(this.mWZ.getShowCount(), getCollectionDataSize());
        this.mXu.bFC();
        if (this.mXu != null)
        {
          if (this.mWZ != null) {
            this.mXu.nnD = TextUtils.join(":", bH(this.mWZ.getShowList()));
          }
          localObject1 = new ArrayList();
          localObject2 = this.mDataList.iterator();
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
          this.mXu.nnE = TextUtils.join(":", bH((List)localObject1));
        }
        com.tencent.e.h.LTJ.aR(new Runnable()
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
                if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).mXW != null))
                {
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).mXW);
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
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).mXW);
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
      this.mXv = true;
      this.mXy = true;
      this.mXz = true;
      com.tencent.mm.modelappbrand.b.aDB();
      com.tencent.mm.plugin.websearch.api.ad.Cl(0L);
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(49618);
  }
  
  public final void bDa()
  {
    AppMethodBeat.i(49622);
    bCZ();
    AppMethodBeat.o(49622);
  }
  
  final void bDd()
  {
    AppMethodBeat.i(49625);
    Object localObject;
    if (!this.mXx)
    {
      if ((this.mUr != null) && (b.adI()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.mUr.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.mUr.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(1.0F);
        }
        if ((this.mUr.getBackgroundGLSurfaceView() instanceof DynamicBackgroundGLSurfaceView)) {
          this.mXF = true;
        }
        AppMethodBeat.o(49625);
      }
    }
    else
    {
      this.mXF = false;
      if ((this.mUr != null) && (b.adI()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.mUr.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.mUr.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setAlpha(1.0F);
          ((View)localObject).setVisibility(0);
        }
        bDc();
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
    if (this.mYz)
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
      this.mXI = paramMotionEvent.getRawY();
      this.mXe = true;
    }
    for (;;)
    {
      this.mXJ = 0.0F;
      this.mXK = false;
      this.mXL = false;
      break;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.mXK), Float.valueOf(this.mXJ), Integer.valueOf(this.mTouchSlop) });
      if ((this.mWV != null) && (this.mDataList != null))
      {
        i = this.mWV.kp();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mDataList.size()) });
        if (i == this.mDataList.size() - 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && (!this.mXK))
        {
          if (!this.mXL)
          {
            this.mXI = paramMotionEvent.getRawY();
            this.mXJ = 0.0F;
            this.mXL = true;
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          this.mXJ = ((paramMotionEvent.getRawY() - this.mXI) * 0.55F);
          if (this.mXJ >= -this.mTouchSlop) {
            break;
          }
          this.mXK = true;
          break;
        }
      }
      if (!this.mXK) {
        break;
      }
      this.mXJ = ((paramMotionEvent.getRawY() - this.mXI) * 0.55F);
      if (this.mXJ > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      int i = (int)Math.abs(this.mXJ);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(49607);
      return true;
      if (this.mXK)
      {
        this.mXe = false;
        if ((Math.abs(this.mXJ) >= this.mXH) && (this.mUr != null))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.mUr.l(0L, 15);
        }
        animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.wR).start();
      }
    }
  }
  
  int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    if (!this.mWU)
    {
      AppMethodBeat.o(49617);
      return 0;
    }
    int i = this.mDataList.size();
    int j = this.mWS;
    int k = this.mXm;
    AppMethodBeat.o(49617);
    return i - j - k - 1;
  }
  
  public int getLeftRightMargin()
  {
    AppMethodBeat.i(49610);
    int j = d.dZ(getContext()) - this.mXc;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mXc) });
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
    this.mXa = ((AppBrandDesktopDragView)localView.findViewById(2131299233));
    if (this.mXa == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", new Object[] { Boolean.valueOf(bool) });
      this.mXa.setRecyclerView(this);
      this.mXa.setCopyList(this.mWR);
      this.mXa.setList(this.mDataList);
      this.mXa.setHeaderContainer(this.mUr);
      this.mXa.setCollectionCallback(this.mWu);
      this.mXa.setItemPadding(this.mXc);
      this.mXa.setAppBrandCounter(new a((byte)0));
      this.mXa.setViewWidth(this.aYS);
      this.mXa.setRecyclerViewScrollComputer(new h()
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
              int m = AppBrandDesktopView.j(AppBrandDesktopView.this).km();
              int i = -(int)AppBrandDesktopView.j(AppBrandDesktopView.this).bY(m).getY();
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", new Object[] { Integer.valueOf(i) });
              j = 0;
              if (j < m)
              {
                AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.m(AppBrandDesktopView.this).get(j);
                if (localc != null)
                {
                  int k = localc.type;
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
                  if ((k == 10) || (k == 11))
                  {
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.n(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 6)
                  {
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.o(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 2)
                  {
                    k = AppBrandDesktopView.p(AppBrandDesktopView.this);
                    if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null) {
                      k = AppBrandDesktopView.p(AppBrandDesktopView.this) * AppBrandDesktopView.c(AppBrandDesktopView.this).getShowLines();
                    }
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", new Object[] { Integer.valueOf(k) });
                    i = k + i;
                  }
                  else if ((k == 1) && ((j - AppBrandDesktopView.f(AppBrandDesktopView.this)) % 4 == 0))
                  {
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)) });
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
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo compute exception", new Object[0]);
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
      this.mYG = this.mXa;
      if ((this.mXa != null) && ((this.mXa.getParent() instanceof RelativeLayout)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
        this.mWX = ((RelativeLayout)this.mXa.getParent());
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
    this.aYS = paramInt1;
    this.aYT = paramInt2;
    paramInt1 = d.b(this.aYS, getContext());
    if (paramInt1 != this.mXc)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", new Object[] { Integer.valueOf(this.mXc), Integer.valueOf(paramInt1) });
      b.init(getContext());
      this.mXc = paramInt1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", new Object[] { Integer.valueOf(this.mXc) });
      if (this.mWY != null)
      {
        this.mWY.setItemPadding(this.mXc);
        if (this.mWZ != null) {
          this.mWZ.bDh();
        }
      }
      if (this.acW != null) {
        this.acW.asY.notifyChanged();
      }
      if (this.mUr != null) {
        this.mUr.bCN();
      }
      if (this.mXa != null) {
        this.mXa.setItemPadding(paramInt1);
      }
    }
    if (this.mXa != null) {
      this.mXa.setViewWidth(this.aYS);
    }
    if ((!this.mYz) && (this.mUr != null) && (this.mXb != this.mUr.getViewHeight()))
    {
      this.mXb = this.mUr.getViewHeight();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.mXb), Integer.valueOf(this.mUr.getMeasuredHeight()) });
    }
    AppMethodBeat.o(49616);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(49606);
    super.onVisibilityChanged(paramView, paramInt);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.mXA) && (this.mUr != null))
      {
        this.mUr.m(100L, this.mXB);
        this.mXB = 0;
        this.mXA = false;
      }
      if (this.dFh)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
        this.dFh = false;
        if (this.mXg != null) {
          removeCallbacks(this.mXg);
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
        this.mXg = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(49606);
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.mUr = paramHeaderContainer;
  }
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(49620);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader] reason: %d", new Object[] { Integer.valueOf(paramInt) });
    removeCallbacks(this.mXM);
    if (this.mXv)
    {
      if ((this.mXu != null) && (this.mWZ != null))
      {
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb = this.mXu;
        boolean bool = b.adI();
        localb.nnC = bool;
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", new Object[] { Integer.valueOf(this.mWZ.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(paramInt) });
        localb = this.mXu;
        int i = b.bCK();
        int j = this.mWZ.getShowLines();
        int k = b.getCompletelyCountPerPage();
        localb.nnf = i;
        localb.nng = j;
        localb.nnh = k;
        localb = this.mXu;
        i = this.mWZ.getShowCount();
        j = getCollectionDataSize();
        localb.nnb = i;
        localb.nnn = j;
        localb.nmY = paramInt;
        com.tencent.e.h.LTJ.aR(new b.2(localb));
        if (localb.nnD == null) {
          localb.nnD = "";
        }
        if (localb.nnE == null) {
          localb.nnE = "";
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportShowAppIdList openSession: %d, recentShowAppIdList: %s, %d, starShowAppIdList: %s, %d", new Object[] { Integer.valueOf(localb.nmX), localb.nnD, Integer.valueOf(localb.nnD.length()), localb.nnE, Integer.valueOf(localb.nnE.length()) });
        com.tencent.mm.plugin.report.service.g.yhR.f(18446, new Object[] { Integer.valueOf(localb.nmX), localb.nnD, localb.nnE });
      }
      this.mXv = false;
      this.mXy = false;
      this.mXz = false;
      if ((paramInt != 9) && (paramInt != 13)) {
        break label459;
      }
      if (this.mXC != null) {
        this.mXC.mXw = false;
      }
    }
    for (;;)
    {
      if (this.mXD != null) {
        this.mXD.mXw = false;
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
      wb(1);
      AppMethodBeat.o(49620);
      return;
      label459:
      if (this.mXC != null) {
        this.mXC.mXw = true;
      }
    }
  }
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(49621);
    wc(paramInt);
    AppMethodBeat.o(49621);
  }
  
  final class a
    implements AppBrandDesktopDragView.a
  {
    private a() {}
    
    public final int bCS()
    {
      AppMethodBeat.i(49582);
      int i = AppBrandDesktopView.g(AppBrandDesktopView.this);
      AppMethodBeat.o(49582);
      return i;
    }
  }
  
  static final class b
    implements k.a
  {
    private int mType;
    private WeakReference<AppBrandDesktopView> mXV;
    boolean mXw;
    
    public b(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
    {
      AppMethodBeat.i(49583);
      this.mXw = false;
      this.mType = paramInt;
      this.mXV = new WeakReference(paramAppBrandDesktopView);
      AppMethodBeat.o(49583);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(49584);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", new Object[] { Integer.valueOf(this.mType), Boolean.valueOf(this.mXw), Integer.valueOf(paramm.dtK) });
      if (paramm.dtK == -1)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", new Object[] { Integer.valueOf(paramm.dtK) });
        AppMethodBeat.o(49584);
        return;
      }
      if (this.mXw)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
        this.mXw = false;
        AppMethodBeat.o(49584);
        return;
      }
      paramString = (AppBrandDesktopView)this.mXV.get();
      if (paramString != null) {
        AppBrandDesktopView.h(paramString);
      }
      AppMethodBeat.o(49584);
    }
  }
  
  public static final class c
  {
    public LocalUsageInfo mXW;
    public int position;
    public int type;
    
    public c(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  public final class d
    extends RecyclerView.w
  {
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(49585);
      if ((AppBrandDesktopView.H(AppBrandDesktopView.this) == 0) && (this.auu != null))
      {
        this.auu.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.auu.getMeasuredHeight()), Integer.valueOf(this.auu.getMeasuredWidth()) });
        AppBrandDesktopView.j(AppBrandDesktopView.this, this.auu.getMeasuredHeight());
      }
      AppMethodBeat.o(49585);
    }
  }
  
  final class e
    extends RecyclerView.a
  {
    private e() {}
    
    private AppBrandDesktopView.c we(int paramInt)
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
        paramViewGroup = new f(z.jO(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false));
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 2)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
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
                AppBrandDesktopView.a(AppBrandDesktopView.this, 1089, 2, paramAnonymousc.mXW, paramAnonymousw.lN());
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
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.y(AppBrandDesktopView.this);
            AppBrandDesktopView.c(AppBrandDesktopView.this, 9);
            localObject = (q)com.tencent.mm.kernel.g.ab(q.class);
            paramAnonymousView = paramAnonymousView.getContext();
            if (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) {}
            for (int i = AppBrandDesktopView.b(AppBrandDesktopView.this).nmX;; i = 0)
            {
              ((q)localObject).d(paramAnonymousView, 13, i);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
          AppBrandDesktopView.a(AppBrandDesktopView.this, z.jO(AppBrandDesktopView.this.getContext()).inflate(2131492989, paramViewGroup, false));
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.z(AppBrandDesktopView.this));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
        catch (Exception paramViewGroup)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandDesktopView", paramViewGroup, "alvinluo init searchView exception", new Object[0]);
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, new View(AppBrandDesktopView.this.getContext()));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
      }
      if (paramInt == 7)
      {
        paramViewGroup = z.jO(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false);
        localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
        localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), localLayoutParams.bottomMargin);
        paramViewGroup.setLayoutParams(localLayoutParams);
        AppBrandDesktopView.b(AppBrandDesktopView.this, paramViewGroup);
        paramViewGroup = new f(paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 8)
      {
        paramViewGroup = z.jO(AppBrandDesktopView.this.getContext()).inflate(2131492981, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.f(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 9)
      {
        paramViewGroup = z.jO(AppBrandDesktopView.this.getContext()).inflate(2131492984, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.d(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      paramViewGroup = z.jO(AppBrandDesktopView.this.getContext()).inflate(2131494989, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.h(AppBrandDesktopView.this, paramViewGroup);
      AppMethodBeat.o(49589);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(49591);
      int j = paramw.auy;
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)), Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)), Integer.valueOf(j), Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)), Integer.valueOf(paramInt), Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
          paramw.auu.setVisibility(4);
          localObject1 = (RecyclerView.LayoutParams)paramw.auu.getLayoutParams();
          ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.l(AppBrandDesktopView.this);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)) });
          paramw.auu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
        localObject1 = paramw.auu;
        paramInt = AppBrandDesktopView.u(AppBrandDesktopView.this) + (int)(com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8) * d.eb(AppBrandDesktopView.this.getContext()));
        localObject2 = new RecyclerView.LayoutParams(-1, -2);
        ((RecyclerView.LayoutParams)localObject2).setMargins(((RecyclerView.LayoutParams)localObject2).leftMargin + paramInt, ((RecyclerView.LayoutParams)localObject2).topMargin, paramInt + ((RecyclerView.LayoutParams)localObject2).rightMargin, ((RecyclerView.LayoutParams)localObject2).bottomMargin);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject1 = paramw.auu;
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", new Object[] { Integer.valueOf(((View)localObject1).getMeasuredHeight()), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(AppBrandDesktopView.p(paramw.mXR)) });
          if (!bool) {
            break label693;
          }
        }
        label693:
        for (paramInt = i;; paramInt = 4)
        {
          if ((AppBrandDesktopView.G(paramw.mXR) != null) && (bool)) {
            AppBrandDesktopView.G(paramw.mXR).getLayoutParams().height = AppBrandDesktopView.p(paramw.mXR);
          }
          if (paramw.auu != null) {
            paramw.auu.setVisibility(paramInt);
          }
          AppMethodBeat.o(49591);
          return;
          bool = false;
          break;
        }
      }
      if (j == 6)
      {
        AppBrandDesktopView.c(AppBrandDesktopView.this, paramw.auu);
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
        localObject1 = (f)paramw;
        ((f)localObject1).auu.setPadding(AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cc.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
        i = (int)d.ea(AppBrandDesktopView.this.getContext());
        ((f)localObject1).mYi.getLayoutParams().width = ((int)(com.tencent.mm.cc.a.ay(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.eb(AppBrandDesktopView.this.getContext())) + i);
        ((f)localObject1).mYi.getLayoutParams().height = ((int)(com.tencent.mm.cc.a.ay(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.eb(AppBrandDesktopView.this.getContext())) + i);
        ((f)localObject1).lZa.getLayoutParams().width = i;
        ((f)localObject1).lZa.getLayoutParams().height = i;
        ((f)localObject1).mYh.getLayoutParams().width = i;
        ((f)localObject1).mYh.getLayoutParams().height = i;
        paramw.auu.setVisibility(0);
        if (AppBrandDesktopView.p(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramw.auu;
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
          AppBrandDesktopView.e(AppBrandDesktopView.this, ((View)localObject2).getMeasuredHeight());
        }
        if (j == 7)
        {
          paramw.auu.setVisibility(4);
          if (((paramInt - AppBrandDesktopView.f(AppBrandDesktopView.this) + 1) % 4 == 1) && (paramInt > AppBrandDesktopView.f(AppBrandDesktopView.this)))
          {
            paramw.auu.getLayoutParams().height = 1;
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramw.auu.getLayoutParams().height);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", new Object[] { Integer.valueOf(paramw.auu.getLayoutParams().height) });
            AppMethodBeat.o(49591);
            return;
          }
          if (AppBrandDesktopView.A(AppBrandDesktopView.this) == 0)
          {
            paramw = paramw.auu;
            paramw.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder emptyItemHeight: %d", new Object[] { Integer.valueOf(paramw.getMeasuredHeight()) });
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramw.getMeasuredHeight());
          }
          AppMethodBeat.o(49591);
          return;
        }
        localObject2 = we(paramInt);
        if (localObject2 == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        ((AppBrandDesktopView.c)localObject2).position = paramInt;
        ((f)localObject1).mYm = ((AppBrandDesktopView.c)localObject2);
        if (((AppBrandDesktopView.c)localObject2).mXW == null) {
          break label1619;
        }
        if (bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).mXW.cmD)) {
          break label1456;
        }
        ((f)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.Vp(((AppBrandDesktopView.c)localObject2).mXW.cmD));
        ((f)localObject1).titleTv.setVisibility(0);
        ((f)localObject1).mYh.setVisibility(0);
        if (bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).mXW.jPZ)) {
          break label1592;
        }
        com.tencent.mm.modelappbrand.a.b.aDV().a(((f)localObject1).lZa, ((AppBrandDesktopView.c)localObject2).mXW.jPZ, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
        label1339:
        if (bt.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.rP(((AppBrandDesktopView.c)localObject2).mXW.hQh))) {
          break label1606;
        }
        ((f)localObject1).mYj.setVisibility(0);
        ((f)localObject1).mYj.setText(com.tencent.mm.plugin.appbrand.appcache.e.rP(((AppBrandDesktopView.c)localObject2).mXW.hQh));
        label1384:
        ((f)localObject1).auu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49588);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.this.setLayoutFrozen(true);
            AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, this.mXY.mXW, this.mXZ.lN());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
            if (((DragFeatureView)localObject1).mYr == paramInt)
            {
              paramw.auu.setVisibility(4);
              AppMethodBeat.o(49591);
              return;
              label1456:
              if (!bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).mXW.nickname))
              {
                ((f)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.Vp(((AppBrandDesktopView.c)localObject2).mXW.nickname));
                ((f)localObject1).titleTv.setVisibility(0);
                break;
              }
              if (!bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).mXW.username))
              {
                ((f)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.Vp(((AppBrandDesktopView.c)localObject2).mXW.nickname));
                ((f)localObject1).titleTv.setVisibility(0);
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { ((AppBrandDesktopView.c)localObject2).mXW.username, ((AppBrandDesktopView.c)localObject2).mXW.appId });
              ((f)localObject1).titleTv.setVisibility(4);
              break;
              label1592:
              ((f)localObject1).lZa.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aDU());
              break label1339;
              label1606:
              ((f)localObject1).mYj.setVisibility(8);
              break label1384;
              label1619:
              com.tencent.mm.modelappbrand.a.b.aDV().a(((f)localObject1).lZa, "", com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
              ((f)localObject1).titleTv.setVisibility(0);
              ((f)localObject1).mYj.setVisibility(8);
              ((f)localObject1).titleTv.setText("");
              continue;
            }
            paramw.auu.setVisibility(0);
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
      AppBrandDesktopView.c localc = we(paramInt);
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
      if ((AppBrandDesktopView.F(AppBrandDesktopView.this) == 0) && (this.auu != null))
      {
        this.auu.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.auu.getMeasuredHeight()), Integer.valueOf(this.auu.getMeasuredWidth()) });
        AppBrandDesktopView.i(AppBrandDesktopView.this, this.auu.getMeasuredHeight());
      }
      this$1 = new RecyclerView.LayoutParams(-1, -2);
      AppBrandDesktopView.this.setMargins(AppBrandDesktopView.this.leftMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), AppBrandDesktopView.this.topMargin - AppBrandDesktopView.F(AppBrandDesktopView.this), AppBrandDesktopView.this.rightMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), AppBrandDesktopView.this.bottomMargin);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.this.topMargin) });
      if (this.auu != null) {
        this.auu.setLayoutParams(AppBrandDesktopView.this);
      }
      AppMethodBeat.o(49594);
    }
  }
  
  public final class g
    extends RecyclerView.w
  {
    protected EditText mYa;
    private long mYb;
    
    public g(View paramView)
    {
      super();
      AppMethodBeat.i(49596);
      this.mYb = 0L;
      this.mYa = ((EditText)paramView.findViewById(2131296709));
      if (this.mYa != null)
      {
        this.mYa.setFocusable(false);
        this.mYa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49595);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            paramAnonymousView = AppBrandDesktopView.this;
            if ((paramAnonymousView.mUr != null) && (paramAnonymousView.mXv))
            {
              localObject = (DynamicBackgroundGLSurfaceView)paramAnonymousView.mUr.getBackgroundGLSurfaceView();
              if (localObject != null)
              {
                ((DynamicBackgroundGLSurfaceView)localObject).onPause();
                paramAnonymousView.mXz = true;
                paramAnonymousView.mXF = true;
              }
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
            long l = System.currentTimeMillis();
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && ((AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) == 0L) || (l - AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) > 1000L)))
            {
              AppBrandDesktopView.g.a(AppBrandDesktopView.g.this, l);
              paramAnonymousView = AppBrandDesktopView.b(AppBrandDesktopView.this);
              paramAnonymousView.nnB += 1;
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", new Object[] { Integer.valueOf(paramAnonymousView.nnB) });
            }
            paramAnonymousView = (com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class);
            if (paramAnonymousView != null) {
              paramAnonymousView.a(AppBrandDesktopView.i(AppBrandDesktopView.this), 42, AppBrandDesktopView.E(AppBrandDesktopView.this), "");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(49595);
          }
        });
      }
      AppMethodBeat.o(49596);
    }
  }
  
  public final class h
    extends RecyclerView.w
  {
    protected TextView titleTv;
    
    public h(View paramView)
    {
      super();
      AppMethodBeat.i(49597);
      this.titleTv = ((TextView)paramView.findViewById(2131305748));
      AppMethodBeat.o(49597);
    }
  }
  
  final class i
    extends ae
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
    
    public final int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
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
      paramRecyclerView.atQ = paramInt;
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
        AppMethodBeat.o(49599);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */