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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.o;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b.2;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  boolean dAG;
  private boolean dGm;
  private RecyclerView.m fPN;
  int gQT;
  boolean isPaused;
  Context mContext;
  private ArrayList<c> mDataList;
  private Interpolator mInterpolator;
  private int mTouchSlop;
  HeaderContainer mZy;
  private AppBrandDesktopDragView.b nbA;
  private ArrayList<c> nbX;
  int nbY;
  boolean nbZ;
  private int ncA;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b ncB;
  boolean ncC;
  private boolean ncD;
  boolean ncE;
  boolean ncF;
  boolean ncG;
  boolean ncH;
  int ncI;
  final b ncJ;
  final b ncK;
  boolean ncL;
  boolean ncM;
  int ncN;
  private int ncO;
  private float ncP;
  private float ncQ;
  private boolean ncR;
  private boolean ncS;
  private final Runnable ncT;
  int ncU;
  private int ncV;
  private boolean ncW;
  private boolean ncX;
  boolean nca;
  private j ncb;
  private boolean ncc;
  private RelativeLayout ncd;
  RecentAppBrandViewContainer nce;
  private RecentAppBrandView ncf;
  private AppBrandDesktopDragView ncg;
  int nch;
  private int nci;
  private boolean ncj;
  private boolean nck;
  Runnable ncl;
  Runnable ncm;
  private int ncn;
  int nco;
  private int ncp;
  private int ncq;
  private int ncr;
  private int ncs;
  private int nct;
  private boolean ncu;
  private View ncv;
  private int ncw;
  private boolean ncx;
  private String ncy;
  private View ncz;
  private Animator.AnimatorListener wR;
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.apA = 4;
    this.mDataList = new ArrayList();
    this.nbX = new ArrayList();
    this.nbY = 0;
    this.nbZ = false;
    this.nca = false;
    this.ncb = null;
    this.ncc = false;
    this.atQ = 0;
    this.aYS = 0;
    this.aYT = 0;
    this.nch = 0;
    this.nci = 0;
    this.ncj = false;
    this.nck = false;
    this.ncl = null;
    this.ncm = null;
    this.dGm = false;
    this.ncr = 0;
    this.ncs = 0;
    this.nct = 0;
    this.ncu = false;
    this.ncw = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 80);
    this.ncx = true;
    this.ncy = "";
    this.ncA = 0;
    this.gQT = 0;
    this.ncB = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.ncC = false;
    this.ncD = false;
    this.isPaused = false;
    this.ncE = false;
    this.ncF = false;
    this.ncG = false;
    this.ncH = false;
    this.ncI = 0;
    this.ncJ = new b(this, 1);
    this.ncK = new b(this, 2);
    this.ncL = false;
    this.ncM = false;
    this.ncN = 0;
    this.dAG = false;
    this.nbA = new AppBrandDesktopDragView.b()
    {
      public final void cL(Object paramAnonymousObject)
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
          if (localc.ndd != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bu.isNullOrNil(localc.ndd.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Wp(localc.ndd.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cM(Object paramAnonymousObject)
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
          if ((localc.type == 1) && (localc.ndd != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.nfv.bEu();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.bc(localc.ndd.username, localc.ndd.hSZ)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bu.isNullOrNil(localc.ndd.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Wo(localc.ndd.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cN(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.ndd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.ndd.username, Integer.valueOf(paramAnonymousObject.ndd.hSZ) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.nfv.bEt();
          if (locale != null) {
            bool = locale.bd(paramAnonymousObject.ndd.username, paramAnonymousObject.ndd.hSZ);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.ndd != null) && (!bu.isNullOrNil(paramAnonymousObject.ndd.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).Wn(paramAnonymousObject.ndd.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).ndd != null) && (!bu.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).ndd.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ndd.appId;
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.nsC += 1;
          localb.nsI.append(paramAnonymousObject + ":");
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
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ndd.appId;
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.nsB += 1;
            localb.nsH.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(ak.getContext()).getScaledTouchSlop();
    this.ncO = 0;
    this.ncP = 0.0F;
    this.ncQ = 0.0F;
    this.ncR = false;
    this.ncS = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wR = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.ncT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49580);
        AppBrandDesktopView.a(AppBrandDesktopView.this, false);
        c.nfv.bEu().bcr();
        AppMethodBeat.o(49580);
      }
    };
    this.ncU = 0;
    this.ncV = -1;
    this.ncW = false;
    this.ncX = true;
    this.fPN = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
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
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
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
            AppBrandDesktopView.b(AppBrandDesktopView.this).bGx();
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
    this.nbX = new ArrayList();
    this.nbY = 0;
    this.nbZ = false;
    this.nca = false;
    this.ncb = null;
    this.ncc = false;
    this.atQ = 0;
    this.aYS = 0;
    this.aYT = 0;
    this.nch = 0;
    this.nci = 0;
    this.ncj = false;
    this.nck = false;
    this.ncl = null;
    this.ncm = null;
    this.dGm = false;
    this.ncr = 0;
    this.ncs = 0;
    this.nct = 0;
    this.ncu = false;
    this.ncw = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 80);
    this.ncx = true;
    this.ncy = "";
    this.ncA = 0;
    this.gQT = 0;
    this.ncB = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.ncC = false;
    this.ncD = false;
    this.isPaused = false;
    this.ncE = false;
    this.ncF = false;
    this.ncG = false;
    this.ncH = false;
    this.ncI = 0;
    this.ncJ = new b(this, 1);
    this.ncK = new b(this, 2);
    this.ncL = false;
    this.ncM = false;
    this.ncN = 0;
    this.dAG = false;
    this.nbA = new AppBrandDesktopDragView.b()
    {
      public final void cL(Object paramAnonymousObject)
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
          if (localc.ndd != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bu.isNullOrNil(localc.ndd.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Wp(localc.ndd.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cM(Object paramAnonymousObject)
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
          if ((localc.type == 1) && (localc.ndd != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.nfv.bEu();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.bc(localc.ndd.username, localc.ndd.hSZ)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bu.isNullOrNil(localc.ndd.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).Wo(localc.ndd.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cN(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.ndd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.ndd.username, Integer.valueOf(paramAnonymousObject.ndd.hSZ) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.nfv.bEt();
          if (locale != null) {
            bool = locale.bd(paramAnonymousObject.ndd.username, paramAnonymousObject.ndd.hSZ);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.ndd != null) && (!bu.isNullOrNil(paramAnonymousObject.ndd.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).Wn(paramAnonymousObject.ndd.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).ndd != null) && (!bu.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).ndd.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ndd.appId;
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.nsC += 1;
          localb.nsI.append(paramAnonymousObject + ":");
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
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ndd.appId;
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.nsB += 1;
            localb.nsH.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(ak.getContext()).getScaledTouchSlop();
    this.ncO = 0;
    this.ncP = 0.0F;
    this.ncQ = 0.0F;
    this.ncR = false;
    this.ncS = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wR = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.ncT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49580);
        AppBrandDesktopView.a(AppBrandDesktopView.this, false);
        c.nfv.bEu().bcr();
        AppMethodBeat.o(49580);
      }
    };
    this.ncU = 0;
    this.ncV = -1;
    this.ncW = false;
    this.ncX = true;
    this.fPN = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
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
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
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
            AppBrandDesktopView.b(AppBrandDesktopView.this).bGx();
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
  
  private void bDL()
  {
    AppMethodBeat.i(49602);
    this.mDataList.clear();
    this.mDataList.add(new c(6));
    this.mDataList.add(new c(9));
    this.mDataList.add(new c(3));
    this.nbZ = false;
    this.nca = false;
    this.ncu = false;
    this.acW.asY.notifyChanged();
    ib(true);
    AppMethodBeat.o(49602);
  }
  
  private void bDM()
  {
    int i = 0;
    AppMethodBeat.i(49603);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.nct), Integer.valueOf(this.mDataList.size() - 4), Integer.valueOf(1) });
    while (i <= 0)
    {
      this.mDataList.add(new c(7));
      i += 1;
    }
    this.nct = 1;
    AppMethodBeat.o(49603);
  }
  
  private void bDN()
  {
    AppMethodBeat.i(49609);
    this.nci = getItemPadding();
    AppMethodBeat.o(49609);
  }
  
  private void bDP()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    AppMethodBeat.o(49614);
  }
  
  private void bDQ()
  {
    AppMethodBeat.i(49615);
    long l = System.currentTimeMillis();
    this.mDataList.clear();
    this.nbX.clear();
    this.nct = 0;
    this.ncu = false;
    this.mDataList.add(new c(6));
    Object localObject1 = c.nfv.bEt();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject1).sb(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.nfy.count);; localObject1 = null)
    {
      Object localObject2 = c.nfv.bEu();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject2).a(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.nfx.count, com.tencent.mm.plugin.appbrand.widget.desktop.b.d.nfx.jTw);; localObject2 = null)
      {
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          this.nbZ = false;
          this.nbY = 2;
          if (this.ncg != null) {
            this.ncg.setCollectionStartPosition(this.nbY);
          }
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label248;
          }
        }
        label248:
        for (this.nca = false;; this.nca = true)
        {
          if ((this.nbZ) || (this.nca)) {
            break label256;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
          this.mDataList.add(new c(9));
          this.mDataList.add(new c(3));
          AppMethodBeat.o(49615);
          return;
          this.nbZ = true;
          this.nbY = 4;
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
            localc.ndd = ((LocalUsageInfo)((List)localObject1).get(i));
            this.nbX.add(localc);
            i += 1;
          }
        }
        this.mDataList.add(new c(11));
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = new c(1);
            ((c)localObject1).ndd = ((LocalUsageInfo)((List)localObject2).get(i));
            this.mDataList.add(localObject1);
            i += 1;
          }
        }
        bDM();
        if (!this.nca)
        {
          this.mDataList.add(new c(8));
          this.ncu = true;
        }
        this.mDataList.add(new c(3));
        if (this.ncg != null)
        {
          this.ncg.setCopyList(this.nbX);
          this.ncg.setList(this.mDataList);
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused) });
        if (this.asc) {
          this.dGm = true;
        }
        this.acW.asY.notifyChanged();
        if (this.nce != null)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
          this.nce.setDataList(this.nbX);
          this.nce.notifyDataSetChanged();
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", new Object[] { Integer.valueOf(this.mDataList.size()), Integer.valueOf(this.nbX.size()), Integer.valueOf(this.mDataList.size() - this.nbY) });
        AppMethodBeat.o(49615);
        return;
      }
    }
  }
  
  private void bDT()
  {
    AppMethodBeat.i(49623);
    if (this.ncv != null)
    {
      EditText localEditText = (EditText)this.ncv.findViewById(2131296709);
      if ((localEditText != null) && (!bu.isNullOrNil(this.ncy)))
      {
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandDesktopView", "alvinluo initSearchView searchWording: %s", new Object[] { this.ncy });
        localEditText.setHint(this.ncy);
      }
    }
    AppMethodBeat.o(49623);
  }
  
  private void bDU()
  {
    AppMethodBeat.i(49624);
    if (this.mZy != null)
    {
      View localView = this.mZy.getBackgroundGLSurfaceView();
      if ((localView != null) && (this.ncd != null))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
        this.ncd.removeView(localView);
      }
    }
    AppMethodBeat.o(49624);
  }
  
  private static ArrayList<String> bJ(List<c> paramList)
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
      if ((localc.ndd != null) && (!bu.isNullOrNil(localc.ndd.appId))) {
        localArrayList.add(localc.ndd.appId);
      }
    }
    AppMethodBeat.o(49619);
    return localArrayList;
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49613);
    int i = d.ec(getContext());
    AppMethodBeat.o(49613);
    return i;
  }
  
  private void ib(boolean paramBoolean)
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
      this.ncb.a(this.atl);
      AppMethodBeat.o(49627);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    this.ncs = 0;
    this.ncr = this.ncs;
    b.init(this.mContext);
    this.apA = b.getCompletelyCountPerPage();
    bDN();
    bDP();
    this.ncb = new j(this.apA);
    this.ncb.apF = new GridLayoutManager.b()
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
    setLayoutManager(this.ncb);
    setOverScrollMode(2);
    a(this.fPN);
    this.acW = new e((byte)0);
    setAdapter(this.acW);
    bDQ();
    bDO();
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49578);
        AppBrandDesktopView.q(AppBrandDesktopView.this);
        AppMethodBeat.o(49578);
      }
    }, 200L);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.ncw) });
    this.ncN = com.tencent.mm.cb.a.fromDPToPix(paramContext, 200);
    this.ncU = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    this.ncO = com.tencent.mm.cb.a.fromDPToPix(paramContext, 100);
    this.atl = new android.support.v7.widget.ae(getContext())
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
    if (this.ncK != null) {
      this.ncK.ncD = paramBoolean;
    }
    if (this.ncJ != null) {
      this.ncJ.ncD = paramBoolean;
    }
  }
  
  private boolean wg(int paramInt)
  {
    AppMethodBeat.i(49601);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mDataList.size())
    {
      localObject = (c)this.mDataList.get(i);
      if ((((c)localObject).type == 1) && (((c)localObject).ndd != null)) {
        localArrayList.add(((c)localObject).ndd);
      }
      i += 1;
    }
    Object localObject = c.nfv.bEu();
    if (localObject == null)
    {
      AppMethodBeat.o(49601);
      return false;
    }
    boolean bool = ((ah)localObject).g(localArrayList, paramInt);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
    }
    AppMethodBeat.o(49601);
    return bool;
  }
  
  final void aN(float paramFloat)
  {
    AppMethodBeat.i(49626);
    RecyclerView.w localw;
    if (this.nbZ)
    {
      localw = ci(1);
      if ((localw != null) && (localw.auu != null)) {
        localw.auu.setAlpha(paramFloat);
      }
    }
    if (this.nbZ) {}
    for (int i = 3;; i = 1)
    {
      localw = ci(i);
      if ((localw != null) && (localw.auu != null)) {
        localw.auu.setAlpha(paramFloat);
      }
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandDesktopView", "alvinluo updateTitleAlpha hasRecentData: %b, hasMyData: %b, alpha: %f", new Object[] { Boolean.valueOf(this.nbZ), Boolean.valueOf(this.nca), Float.valueOf(paramFloat) });
      AppMethodBeat.o(49626);
      return;
    }
  }
  
  final void bDO()
  {
    AppMethodBeat.i(49612);
    if (this.ncL)
    {
      AppMethodBeat.o(49612);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.nfv.bEt();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.nfv.bEu();
    if ((locale == null) || (localb == null))
    {
      AppMethodBeat.o(49612);
      return;
    }
    this.ncL = true;
    locale.remove(this.ncK);
    locale.add(this.ncK);
    localb.remove(this.ncJ);
    localb.add(this.ncJ);
    AppMethodBeat.o(49612);
  }
  
  public final void bDR()
  {
    AppMethodBeat.i(49618);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
    if (!this.ncC)
    {
      setIgnoreNotify(true);
      c.nfv.bEu();
      removeCallbacks(this.ncT);
      postDelayed(this.ncT, 600L);
      k.UV(k.bye());
      Object localObject1 = this.ncy;
      Object localObject2 = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISi, null);
      if ((localObject2 instanceof String)) {
        this.ncy = bu.bI((String)localObject2, this.ncy);
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.ncy });
      bDT();
      if ((this.ncB != null) && (this.ncf != null))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", new Object[] { Integer.valueOf(this.ncf.getShowCount()), Integer.valueOf(getCollectionDataSize()) });
        this.ncB.eB(this.ncf.getShowCount(), getCollectionDataSize());
        this.ncB.bGx();
        if (this.ncB != null)
        {
          if (this.ncf != null) {
            this.ncB.nsN = TextUtils.join(":", bJ(this.ncf.getShowList()));
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
          this.ncB.nsO = TextUtils.join(":", bJ((List)localObject1));
        }
        com.tencent.e.h.MqF.aO(new Runnable()
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
                if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).ndd != null))
                {
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).ndd);
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
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).ndd);
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
      this.ncC = true;
      this.ncF = true;
      this.ncG = true;
      com.tencent.mm.modelappbrand.b.aDR();
      ad.CJ(0L);
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(49618);
  }
  
  public final void bDS()
  {
    AppMethodBeat.i(49622);
    bDR();
    AppMethodBeat.o(49622);
  }
  
  final void bDV()
  {
    AppMethodBeat.i(49625);
    Object localObject;
    if (!this.ncE)
    {
      if ((this.mZy != null) && (b.adU()))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.mZy.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.mZy.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(1.0F);
        }
        if ((this.mZy.getBackgroundGLSurfaceView() instanceof DynamicBackgroundGLSurfaceView)) {
          this.ncM = true;
        }
        AppMethodBeat.o(49625);
      }
    }
    else
    {
      this.ncM = false;
      if ((this.mZy != null) && (b.adU()))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.mZy.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.mZy.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setAlpha(1.0F);
          ((View)localObject).setVisibility(0);
        }
        bDU();
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
    if (this.ndG)
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
      this.ncP = paramMotionEvent.getRawY();
      this.nck = true;
    }
    for (;;)
    {
      this.ncQ = 0.0F;
      this.ncR = false;
      this.ncS = false;
      break;
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.ncR), Float.valueOf(this.ncQ), Integer.valueOf(this.mTouchSlop) });
      if ((this.ncb != null) && (this.mDataList != null))
      {
        i = this.ncb.kp();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mDataList.size()) });
        if (i == this.mDataList.size() - 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && (!this.ncR))
        {
          if (!this.ncS)
          {
            this.ncP = paramMotionEvent.getRawY();
            this.ncQ = 0.0F;
            this.ncS = true;
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          this.ncQ = ((paramMotionEvent.getRawY() - this.ncP) * 0.55F);
          if (this.ncQ >= -this.mTouchSlop) {
            break;
          }
          this.ncR = true;
          break;
        }
      }
      if (!this.ncR) {
        break;
      }
      this.ncQ = ((paramMotionEvent.getRawY() - this.ncP) * 0.55F);
      if (this.ncQ > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      int i = (int)Math.abs(this.ncQ);
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(49607);
      return true;
      if (this.ncR)
      {
        this.nck = false;
        if ((Math.abs(this.ncQ) >= this.ncO) && (this.mZy != null))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.mZy.l(0L, 15);
        }
        animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.wR).start();
      }
    }
  }
  
  int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    if (!this.nca)
    {
      AppMethodBeat.o(49617);
      return 0;
    }
    int i = this.mDataList.size();
    int j = this.nbY;
    int k = this.nct;
    AppMethodBeat.o(49617);
    return i - j - k - 1;
  }
  
  public int getLeftRightMargin()
  {
    AppMethodBeat.i(49610);
    int j = d.ed(getContext()) - this.nci;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.nci) });
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
    this.ncg = ((AppBrandDesktopDragView)localView.findViewById(2131299233));
    if (this.ncg == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", new Object[] { Boolean.valueOf(bool) });
      this.ncg.setRecyclerView(this);
      this.ncg.setCopyList(this.nbX);
      this.ncg.setList(this.mDataList);
      this.ncg.setHeaderContainer(this.mZy);
      this.ncg.setCollectionCallback(this.nbA);
      this.ncg.setItemPadding(this.nci);
      this.ncg.setAppBrandCounter(new a((byte)0));
      this.ncg.setViewWidth(this.aYS);
      this.ncg.setRecyclerViewScrollComputer(new h()
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
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", new Object[] { Integer.valueOf(i) });
              j = 0;
              if (j < m)
              {
                AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.m(AppBrandDesktopView.this).get(j);
                if (localc != null)
                {
                  int k = localc.type;
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
                  if ((k == 10) || (k == 11))
                  {
                    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.n(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 6)
                  {
                    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.o(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 2)
                  {
                    k = AppBrandDesktopView.p(AppBrandDesktopView.this);
                    if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null) {
                      k = AppBrandDesktopView.p(AppBrandDesktopView.this) * AppBrandDesktopView.c(AppBrandDesktopView.this).getShowLines();
                    }
                    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", new Object[] { Integer.valueOf(k) });
                    i = k + i;
                  }
                  else if ((k == 1) && ((j - AppBrandDesktopView.f(AppBrandDesktopView.this)) % 4 == 0))
                  {
                    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)) });
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
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo compute exception", new Object[0]);
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
      this.ndN = this.ncg;
      if ((this.ncg != null) && ((this.ncg.getParent() instanceof RelativeLayout)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
        this.ncd = ((RelativeLayout)this.ncg.getParent());
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
    if (paramInt1 != this.nci)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", new Object[] { Integer.valueOf(this.nci), Integer.valueOf(paramInt1) });
      b.init(getContext());
      this.nci = paramInt1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", new Object[] { Integer.valueOf(this.nci) });
      if (this.nce != null)
      {
        this.nce.setItemPadding(this.nci);
        if (this.ncf != null) {
          this.ncf.bDZ();
        }
      }
      if (this.acW != null) {
        this.acW.asY.notifyChanged();
      }
      if (this.mZy != null) {
        this.mZy.bDF();
      }
      if (this.ncg != null) {
        this.ncg.setItemPadding(paramInt1);
      }
    }
    if (this.ncg != null) {
      this.ncg.setViewWidth(this.aYS);
    }
    if ((!this.ndG) && (this.mZy != null) && (this.nch != this.mZy.getViewHeight()))
    {
      this.nch = this.mZy.getViewHeight();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.nch), Integer.valueOf(this.mZy.getMeasuredHeight()) });
    }
    AppMethodBeat.o(49616);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(49606);
    super.onVisibilityChanged(paramView, paramInt);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.ncH) && (this.mZy != null))
      {
        this.mZy.m(100L, this.ncI);
        this.ncI = 0;
        this.ncH = false;
      }
      if (this.dGm)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
        this.dGm = false;
        if (this.ncm != null) {
          removeCallbacks(this.ncm);
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
        this.ncm = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(49606);
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.mZy = paramHeaderContainer;
  }
  
  public final void wh(int paramInt)
  {
    AppMethodBeat.i(49620);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader] reason: %d", new Object[] { Integer.valueOf(paramInt) });
    removeCallbacks(this.ncT);
    if (this.ncC)
    {
      if ((this.ncB != null) && (this.ncf != null))
      {
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb = this.ncB;
        boolean bool = b.adU();
        localb.nsM = bool;
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", new Object[] { Integer.valueOf(this.ncf.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(paramInt) });
        localb = this.ncB;
        int i = b.bDC();
        int j = this.ncf.getShowLines();
        int k = b.getCompletelyCountPerPage();
        localb.nsp = i;
        localb.nsq = j;
        localb.nsr = k;
        localb = this.ncB;
        i = this.ncf.getShowCount();
        j = getCollectionDataSize();
        localb.nsl = i;
        localb.nsx = j;
        localb.nsi = paramInt;
        com.tencent.e.h.MqF.aO(new b.2(localb));
        if (localb.nsN == null) {
          localb.nsN = "";
        }
        if (localb.nsO == null) {
          localb.nsO = "";
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportShowAppIdList openSession: %d, recentShowAppIdList: %s, %d, starShowAppIdList: %s, %d", new Object[] { Integer.valueOf(localb.nsh), localb.nsN, Integer.valueOf(localb.nsN.length()), localb.nsO, Integer.valueOf(localb.nsO.length()) });
        com.tencent.mm.plugin.report.service.g.yxI.f(18446, new Object[] { Integer.valueOf(localb.nsh), localb.nsN, localb.nsO });
      }
      this.ncC = false;
      this.ncF = false;
      this.ncG = false;
      if ((paramInt != 9) && (paramInt != 13)) {
        break label459;
      }
      if (this.ncJ != null) {
        this.ncJ.ncD = false;
      }
    }
    for (;;)
    {
      if (this.ncK != null) {
        this.ncK.ncD = false;
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
      wg(1);
      AppMethodBeat.o(49620);
      return;
      label459:
      if (this.ncJ != null) {
        this.ncJ.ncD = true;
      }
    }
  }
  
  public final void wi(int paramInt)
  {
    AppMethodBeat.i(49621);
    wh(paramInt);
    AppMethodBeat.o(49621);
  }
  
  final class a
    implements AppBrandDesktopDragView.a
  {
    private a() {}
    
    public final int bDK()
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
    boolean ncD;
    private WeakReference<AppBrandDesktopView> ndc;
    
    public b(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
    {
      AppMethodBeat.i(49583);
      this.ncD = false;
      this.mType = paramInt;
      this.ndc = new WeakReference(paramAppBrandDesktopView);
      AppMethodBeat.o(49583);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(49584);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", new Object[] { Integer.valueOf(this.mType), Boolean.valueOf(this.ncD), Integer.valueOf(paramm.duP) });
      if (paramm.duP == -1)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", new Object[] { Integer.valueOf(paramm.duP) });
        AppMethodBeat.o(49584);
        return;
      }
      if (this.ncD)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
        this.ncD = false;
        AppMethodBeat.o(49584);
        return;
      }
      paramString = (AppBrandDesktopView)this.ndc.get();
      if (paramString != null) {
        AppBrandDesktopView.h(paramString);
      }
      AppMethodBeat.o(49584);
    }
  }
  
  public static final class c
  {
    public LocalUsageInfo ndd;
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.auu.getMeasuredHeight()), Integer.valueOf(this.auu.getMeasuredWidth()) });
        AppBrandDesktopView.j(AppBrandDesktopView.this, this.auu.getMeasuredHeight());
      }
      AppMethodBeat.o(49585);
    }
  }
  
  final class e
    extends RecyclerView.a
  {
    private e() {}
    
    private AppBrandDesktopView.c wj(int paramInt)
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
        paramViewGroup = new f(z.jV(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false));
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 2)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
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
                AppBrandDesktopView.a(AppBrandDesktopView.this, 1089, 2, paramAnonymousc.ndd, paramAnonymousw.lN());
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.y(AppBrandDesktopView.this);
            AppBrandDesktopView.c(AppBrandDesktopView.this, 9);
            localObject = (r)com.tencent.mm.kernel.g.ab(r.class);
            paramAnonymousView = paramAnonymousView.getContext();
            if (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) {}
            for (int i = AppBrandDesktopView.b(AppBrandDesktopView.this).nsh;; i = 0)
            {
              ((r)localObject).d(paramAnonymousView, 13, i);
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
          AppBrandDesktopView.a(AppBrandDesktopView.this, z.jV(AppBrandDesktopView.this.getContext()).inflate(2131492989, paramViewGroup, false));
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.z(AppBrandDesktopView.this));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
        catch (Exception paramViewGroup)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.AppBrandDesktopView", paramViewGroup, "alvinluo init searchView exception", new Object[0]);
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, new View(AppBrandDesktopView.this.getContext()));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
      }
      if (paramInt == 7)
      {
        paramViewGroup = z.jV(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false);
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
        paramViewGroup = z.jV(AppBrandDesktopView.this.getContext()).inflate(2131492981, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.f(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 9)
      {
        paramViewGroup = z.jV(AppBrandDesktopView.this.getContext()).inflate(2131492984, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.d(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      paramViewGroup = z.jV(AppBrandDesktopView.this.getContext()).inflate(2131494989, paramViewGroup, false);
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
        i = AppBrandDesktopView.B(AppBrandDesktopView.this) - com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 56) - com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 48);
        j = AppBrandDesktopView.k(AppBrandDesktopView.this);
        if (j > AppBrandDesktopView.o(AppBrandDesktopView.this) + i) {
          AppBrandDesktopView.h(AppBrandDesktopView.this, AppBrandDesktopView.D(AppBrandDesktopView.this));
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)), Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)), Integer.valueOf(j), Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)), Integer.valueOf(paramInt), Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
          paramw.auu.setVisibility(4);
          localObject1 = (RecyclerView.LayoutParams)paramw.auu.getLayoutParams();
          ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.l(AppBrandDesktopView.this);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)) });
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
        paramInt = AppBrandDesktopView.u(AppBrandDesktopView.this) + (int)(com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8) * d.ef(AppBrandDesktopView.this.getContext()));
        localObject2 = new RecyclerView.LayoutParams(-1, -2);
        ((RecyclerView.LayoutParams)localObject2).setMargins(((RecyclerView.LayoutParams)localObject2).leftMargin + paramInt, ((RecyclerView.LayoutParams)localObject2).topMargin, paramInt + ((RecyclerView.LayoutParams)localObject2).rightMargin, ((RecyclerView.LayoutParams)localObject2).bottomMargin);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject1 = paramw.auu;
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", new Object[] { Integer.valueOf(((View)localObject1).getMeasuredHeight()), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(AppBrandDesktopView.p(paramw.ncY)) });
          if (!bool) {
            break label693;
          }
        }
        label693:
        for (paramInt = i;; paramInt = 4)
        {
          if ((AppBrandDesktopView.G(paramw.ncY) != null) && (bool)) {
            AppBrandDesktopView.G(paramw.ncY).getLayoutParams().height = AppBrandDesktopView.p(paramw.ncY);
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
        ((f)localObject1).auu.setPadding(AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
        i = (int)d.ee(AppBrandDesktopView.this.getContext());
        ((f)localObject1).ndp.getLayoutParams().width = ((int)(com.tencent.mm.cb.a.ay(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.ef(AppBrandDesktopView.this.getContext())) + i);
        ((f)localObject1).ndp.getLayoutParams().height = ((int)(com.tencent.mm.cb.a.ay(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.ef(AppBrandDesktopView.this.getContext())) + i);
        ((f)localObject1).mdt.getLayoutParams().width = i;
        ((f)localObject1).mdt.getLayoutParams().height = i;
        ((f)localObject1).ndo.getLayoutParams().width = i;
        ((f)localObject1).ndo.getLayoutParams().height = i;
        paramw.auu.setVisibility(0);
        if (AppBrandDesktopView.p(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramw.auu;
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
          AppBrandDesktopView.e(AppBrandDesktopView.this, ((View)localObject2).getMeasuredHeight());
        }
        if (j == 7)
        {
          paramw.auu.setVisibility(4);
          if (((paramInt - AppBrandDesktopView.f(AppBrandDesktopView.this) + 1) % 4 == 1) && (paramInt > AppBrandDesktopView.f(AppBrandDesktopView.this)))
          {
            paramw.auu.getLayoutParams().height = 1;
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramw.auu.getLayoutParams().height);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", new Object[] { Integer.valueOf(paramw.auu.getLayoutParams().height) });
            AppMethodBeat.o(49591);
            return;
          }
          if (AppBrandDesktopView.A(AppBrandDesktopView.this) == 0)
          {
            paramw = paramw.auu;
            paramw.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder emptyItemHeight: %d", new Object[] { Integer.valueOf(paramw.getMeasuredHeight()) });
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramw.getMeasuredHeight());
          }
          AppMethodBeat.o(49591);
          return;
        }
        localObject2 = wj(paramInt);
        if (localObject2 == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        ((AppBrandDesktopView.c)localObject2).position = paramInt;
        ((f)localObject1).ndt = ((AppBrandDesktopView.c)localObject2);
        if (((AppBrandDesktopView.c)localObject2).ndd == null) {
          break label1619;
        }
        if (bu.isNullOrNil(((AppBrandDesktopView.c)localObject2).ndd.cmF)) {
          break label1456;
        }
        ((f)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.Wb(((AppBrandDesktopView.c)localObject2).ndd.cmF));
        ((f)localObject1).titleTv.setVisibility(0);
        ((f)localObject1).ndo.setVisibility(0);
        if (bu.isNullOrNil(((AppBrandDesktopView.c)localObject2).ndd.jTr)) {
          break label1592;
        }
        com.tencent.mm.modelappbrand.a.b.aEl().a(((f)localObject1).mdt, ((AppBrandDesktopView.c)localObject2).ndd.jTr, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
        label1339:
        if (bu.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.rS(((AppBrandDesktopView.c)localObject2).ndd.hSZ))) {
          break label1606;
        }
        ((f)localObject1).ndq.setVisibility(0);
        ((f)localObject1).ndq.setText(com.tencent.mm.plugin.appbrand.appcache.e.rS(((AppBrandDesktopView.c)localObject2).ndd.hSZ));
        label1384:
        ((f)localObject1).auu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49588);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.this.setLayoutFrozen(true);
            AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, this.ndf.ndd, this.ndg.lN());
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
            if (((DragFeatureView)localObject1).ndy == paramInt)
            {
              paramw.auu.setVisibility(4);
              AppMethodBeat.o(49591);
              return;
              label1456:
              if (!bu.isNullOrNil(((AppBrandDesktopView.c)localObject2).ndd.nickname))
              {
                ((f)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.Wb(((AppBrandDesktopView.c)localObject2).ndd.nickname));
                ((f)localObject1).titleTv.setVisibility(0);
                break;
              }
              if (!bu.isNullOrNil(((AppBrandDesktopView.c)localObject2).ndd.username))
              {
                ((f)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.Wb(((AppBrandDesktopView.c)localObject2).ndd.nickname));
                ((f)localObject1).titleTv.setVisibility(0);
                break;
              }
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { ((AppBrandDesktopView.c)localObject2).ndd.username, ((AppBrandDesktopView.c)localObject2).ndd.appId });
              ((f)localObject1).titleTv.setVisibility(4);
              break;
              label1592:
              ((f)localObject1).mdt.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aEk());
              break label1339;
              label1606:
              ((f)localObject1).ndq.setVisibility(8);
              break label1384;
              label1619:
              com.tencent.mm.modelappbrand.a.b.aEl().a(((f)localObject1).mdt, "", com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
              ((f)localObject1).titleTv.setVisibility(0);
              ((f)localObject1).ndq.setVisibility(8);
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
      AppBrandDesktopView.c localc = wj(paramInt);
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.auu.getMeasuredHeight()), Integer.valueOf(this.auu.getMeasuredWidth()) });
        AppBrandDesktopView.i(AppBrandDesktopView.this, this.auu.getMeasuredHeight());
      }
      this$1 = new RecyclerView.LayoutParams(-1, -2);
      AppBrandDesktopView.this.setMargins(AppBrandDesktopView.this.leftMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), AppBrandDesktopView.this.topMargin - AppBrandDesktopView.F(AppBrandDesktopView.this), AppBrandDesktopView.this.rightMargin + AppBrandDesktopView.u(AppBrandDesktopView.this), AppBrandDesktopView.this.bottomMargin);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.this.topMargin) });
      if (this.auu != null) {
        this.auu.setLayoutParams(AppBrandDesktopView.this);
      }
      AppMethodBeat.o(49594);
    }
  }
  
  public final class g
    extends RecyclerView.w
  {
    protected EditText ndh;
    private long ndi;
    
    public g(View paramView)
    {
      super();
      AppMethodBeat.i(49596);
      this.ndi = 0L;
      this.ndh = ((EditText)paramView.findViewById(2131296709));
      if (this.ndh != null)
      {
        this.ndh.setFocusable(false);
        this.ndh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49595);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            paramAnonymousView = AppBrandDesktopView.this;
            if ((paramAnonymousView.mZy != null) && (paramAnonymousView.ncC))
            {
              localObject = (DynamicBackgroundGLSurfaceView)paramAnonymousView.mZy.getBackgroundGLSurfaceView();
              if (localObject != null)
              {
                ((DynamicBackgroundGLSurfaceView)localObject).onPause();
                paramAnonymousView.ncG = true;
                paramAnonymousView.ncM = true;
              }
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
            long l = System.currentTimeMillis();
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && ((AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) == 0L) || (l - AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) > 1000L)))
            {
              AppBrandDesktopView.g.a(AppBrandDesktopView.g.this, l);
              paramAnonymousView = AppBrandDesktopView.b(AppBrandDesktopView.this);
              paramAnonymousView.nsL += 1;
              com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", new Object[] { Integer.valueOf(paramAnonymousView.nsL) });
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
        AppMethodBeat.o(49599);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */