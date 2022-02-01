package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.f;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.o;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b.2;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopView
  extends DragRecyclerView
  implements c.a
{
  private int aNI;
  private int aNJ;
  private RecyclerView.a aaj;
  public int amN;
  private RecyclerView.r aqy;
  private int ard;
  boolean dqc;
  private boolean dvt;
  private RecyclerView.m frd;
  private ArrayList<c> hIH;
  boolean isPaused;
  HeaderContainer lRJ;
  private AppBrandDesktopDragView.b lTN;
  private int lUA;
  int lUB;
  private int lUC;
  private int lUD;
  private int lUE;
  private int lUF;
  private int lUG;
  private boolean lUH;
  private View lUI;
  private int lUJ;
  private boolean lUK;
  private String lUL;
  private View lUM;
  private int lUN;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b lUO;
  boolean lUP;
  private boolean lUQ;
  boolean lUR;
  boolean lUS;
  boolean lUT;
  boolean lUU;
  int lUV;
  final AppBrandDesktopView.b lUW;
  final AppBrandDesktopView.b lUX;
  boolean lUY;
  boolean lUZ;
  private ArrayList<c> lUk;
  int lUl;
  boolean lUm;
  boolean lUn;
  private AppBrandDesktopView.j lUo;
  private boolean lUp;
  private RelativeLayout lUq;
  RecentAppBrandViewContainer lUr;
  private RecentAppBrandView lUs;
  private AppBrandDesktopDragView lUt;
  int lUu;
  private int lUv;
  private boolean lUw;
  private boolean lUx;
  Runnable lUy;
  Runnable lUz;
  int lVa;
  private int lVb;
  private float lVc;
  private float lVd;
  private boolean lVe;
  private boolean lVf;
  private final Runnable lVg;
  int lVh;
  private int lVi;
  private boolean lVj;
  private boolean lVk;
  int lgU;
  Context mContext;
  private Interpolator mInterpolator;
  private int mTouchSlop;
  private Animator.AnimatorListener tX;
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.amN = 4;
    this.hIH = new ArrayList();
    this.lUk = new ArrayList();
    this.lUl = 0;
    this.lUm = false;
    this.lUn = false;
    this.lUo = null;
    this.lUp = false;
    this.ard = 0;
    this.aNI = 0;
    this.aNJ = 0;
    this.lUu = 0;
    this.lUv = 0;
    this.lUw = false;
    this.lUx = false;
    this.lUy = null;
    this.lUz = null;
    this.dvt = false;
    this.lUE = 0;
    this.lUF = 0;
    this.lUG = 0;
    this.lUH = false;
    this.lUJ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 80);
    this.lUK = true;
    this.lUL = "";
    this.lUN = 0;
    this.lgU = 0;
    this.lUO = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.lUP = false;
    this.lUQ = false;
    this.isPaused = false;
    this.lUR = false;
    this.lUS = false;
    this.lUT = false;
    this.lUU = false;
    this.lUV = 0;
    this.lUW = new AppBrandDesktopView.b(this, 1);
    this.lUX = new AppBrandDesktopView.b(this, 2);
    this.lUY = false;
    this.lUZ = false;
    this.lVa = 0;
    this.dqc = false;
    this.lTN = new AppBrandDesktopDragView.b()
    {
      public final void cJ(Object paramAnonymousObject)
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
          if (localc.lVq != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            ad.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.lVq.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).NX(localc.lVq.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cK(Object paramAnonymousObject)
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
          if ((localc.type == 1) && (localc.lVq != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.lXD.bsy();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.aT(localc.lVq.username, localc.lVq.gXn)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.lVq.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).NW(localc.lVq.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cL(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.lVq != null)
        {
          ad.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.lVq.username, Integer.valueOf(paramAnonymousObject.lVq.gXn) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.lXD.bsx();
          if (locale != null) {
            bool = locale.aU(paramAnonymousObject.lVq.username, paramAnonymousObject.lVq.gXn);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.lVq != null) && (!bt.isNullOrNil(paramAnonymousObject.lVq.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).NV(paramAnonymousObject.lVq.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            ad.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.d(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
            if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.e(AppBrandDesktopView.this).getAdapter().ck(paramAnonymousObject.position);
            }
          }
        }
        AppMethodBeat.o(49566);
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        AppBrandDesktopView.a(AppBrandDesktopView.this, true);
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).lVq != null) && (!bt.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).lVq.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).lVq.appId;
          ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.mkV += 1;
          localb.mlb.append(paramAnonymousObject + ":");
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
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).lVq.appId;
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.mkU += 1;
            localb.mla.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.lVb = 0;
    this.lVc = 0.0F;
    this.lVd = 0.0F;
    this.lVe = false;
    this.lVf = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.tX = new AppBrandDesktopView.8(this);
    this.lVg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49580);
        AppBrandDesktopView.a(AppBrandDesktopView.this, false);
        c.lXD.bsy().aRu();
        AppMethodBeat.o(49580);
      }
    };
    this.lVh = 0;
    this.lVi = -1;
    this.lVj = false;
    this.lVk = true;
    this.frd = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.U(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.V(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.W(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).jO();
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
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
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
            AppBrandDesktopView.b(AppBrandDesktopView.this).buD();
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
    this.amN = 4;
    this.hIH = new ArrayList();
    this.lUk = new ArrayList();
    this.lUl = 0;
    this.lUm = false;
    this.lUn = false;
    this.lUo = null;
    this.lUp = false;
    this.ard = 0;
    this.aNI = 0;
    this.aNJ = 0;
    this.lUu = 0;
    this.lUv = 0;
    this.lUw = false;
    this.lUx = false;
    this.lUy = null;
    this.lUz = null;
    this.dvt = false;
    this.lUE = 0;
    this.lUF = 0;
    this.lUG = 0;
    this.lUH = false;
    this.lUJ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 80);
    this.lUK = true;
    this.lUL = "";
    this.lUN = 0;
    this.lgU = 0;
    this.lUO = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.lUP = false;
    this.lUQ = false;
    this.isPaused = false;
    this.lUR = false;
    this.lUS = false;
    this.lUT = false;
    this.lUU = false;
    this.lUV = 0;
    this.lUW = new AppBrandDesktopView.b(this, 1);
    this.lUX = new AppBrandDesktopView.b(this, 2);
    this.lUY = false;
    this.lUZ = false;
    this.lVa = 0;
    this.dqc = false;
    this.lTN = new AppBrandDesktopDragView.b()
    {
      public final void cJ(Object paramAnonymousObject)
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
          if (localc.lVq != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            ad.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.lVq.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).NX(localc.lVq.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cK(Object paramAnonymousObject)
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
          if ((localc.type == 1) && (localc.lVq != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.lXD.bsy();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.aT(localc.lVq.username, localc.lVq.gXn)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!bt.isNullOrNil(localc.lVq.appId))) {
              AppBrandDesktopView.b(AppBrandDesktopView.this).NW(localc.lVq.appId);
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cL(Object paramAnonymousObject)
      {
        boolean bool = false;
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        if (paramAnonymousObject.lVq != null)
        {
          ad.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.lVq.username, Integer.valueOf(paramAnonymousObject.lVq.gXn) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.lXD.bsx();
          if (locale != null) {
            bool = locale.aU(paramAnonymousObject.lVq.username, paramAnonymousObject.lVq.gXn);
          }
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.lVq != null) && (!bt.isNullOrNil(paramAnonymousObject.lVq.appId))) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).NV(paramAnonymousObject.lVq.appId);
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            ad.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.d(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
            if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.e(AppBrandDesktopView.this).getAdapter().ck(paramAnonymousObject.position);
            }
          }
        }
        AppMethodBeat.o(49566);
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        AppBrandDesktopView.a(AppBrandDesktopView.this, true);
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).lVq != null) && (!bt.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).lVq.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localb = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).lVq.appId;
          ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.mkV += 1;
          localb.mlb.append(paramAnonymousObject + ":");
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
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).lVq.appId;
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.mkU += 1;
            localb.mla.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(aj.getContext()).getScaledTouchSlop();
    this.lVb = 0;
    this.lVc = 0.0F;
    this.lVd = 0.0F;
    this.lVe = false;
    this.lVf = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.tX = new AppBrandDesktopView.8(this);
    this.lVg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49580);
        AppBrandDesktopView.a(AppBrandDesktopView.this, false);
        c.lXD.bsy().aRu();
        AppMethodBeat.o(49580);
      }
    };
    this.lVh = 0;
    this.lVi = -1;
    this.lVj = false;
    this.lVk = true;
    this.frd = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49573);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.U(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.V(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.W(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).jO();
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
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$14", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.I(AppBrandDesktopView.this)) });
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
            AppBrandDesktopView.b(AppBrandDesktopView.this).buD();
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
      if ((localc.lVq != null) && (!bt.isNullOrNil(localc.lVq.appId))) {
        localArrayList.add(localc.lVq.appId);
      }
    }
    AppMethodBeat.o(49619);
    return localArrayList;
  }
  
  private void brQ()
  {
    AppMethodBeat.i(49602);
    this.hIH.clear();
    this.hIH.add(new c(6));
    this.hIH.add(new c(9));
    this.hIH.add(new c(3));
    this.lUm = false;
    this.lUn = false;
    this.lUH = false;
    this.aaj.aql.notifyChanged();
    hv(true);
    AppMethodBeat.o(49602);
  }
  
  private void brR()
  {
    int i = 0;
    AppMethodBeat.i(49603);
    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.lUG), Integer.valueOf(this.hIH.size() - 4), Integer.valueOf(1) });
    while (i <= 0)
    {
      this.hIH.add(new c(7));
      i += 1;
    }
    this.lUG = 1;
    AppMethodBeat.o(49603);
  }
  
  private void brS()
  {
    AppMethodBeat.i(49609);
    this.lUv = getItemPadding();
    AppMethodBeat.o(49609);
  }
  
  private void brU()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    AppMethodBeat.o(49614);
  }
  
  private void brV()
  {
    AppMethodBeat.i(49615);
    long l = System.currentTimeMillis();
    this.hIH.clear();
    this.lUk.clear();
    this.lUG = 0;
    this.lUH = false;
    this.hIH.add(new c(6));
    Object localObject1 = c.lXD.bsx();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject1).qL(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.lXG.count);; localObject1 = null)
    {
      Object localObject2 = c.lXD.bsy();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject2).a(com.tencent.mm.plugin.appbrand.widget.desktop.b.d.lXF.count, com.tencent.mm.plugin.appbrand.widget.desktop.b.d.lXF.iVS);; localObject2 = null)
      {
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          this.lUm = false;
          this.lUl = 2;
          if (this.lUt != null) {
            this.lUt.setCollectionStartPosition(this.lUl);
          }
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label248;
          }
        }
        label248:
        for (this.lUn = false;; this.lUn = true)
        {
          if ((this.lUm) || (this.lUn)) {
            break label256;
          }
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
          this.hIH.add(new c(9));
          this.hIH.add(new c(3));
          AppMethodBeat.o(49615);
          return;
          this.lUm = true;
          this.lUl = 4;
          break;
        }
        label256:
        new c(0);
        int i;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          c localc = new c(10);
          this.hIH.add(localc);
          this.hIH.add(new c(2));
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localc = new c(2);
            localc.lVq = ((LocalUsageInfo)((List)localObject1).get(i));
            this.lUk.add(localc);
            i += 1;
          }
        }
        this.hIH.add(new c(11));
        if (localObject2 != null)
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = new c(1);
            ((c)localObject1).lVq = ((LocalUsageInfo)((List)localObject2).get(i));
            this.hIH.add(localObject1);
            i += 1;
          }
        }
        brR();
        if (!this.lUn)
        {
          this.hIH.add(new c(8));
          this.lUH = true;
        }
        this.hIH.add(new c(3));
        if (this.lUt != null)
        {
          this.lUt.setCopyList(this.lUk);
          this.lUt.setList(this.hIH);
        }
        ad.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused) });
        if (this.apo) {
          this.dvt = true;
        }
        this.aaj.aql.notifyChanged();
        if (this.lUr != null)
        {
          ad.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
          this.lUr.setDataList(this.lUk);
          this.lUr.notifyDataSetChanged();
        }
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", new Object[] { Integer.valueOf(this.hIH.size()), Integer.valueOf(this.lUk.size()), Integer.valueOf(this.hIH.size() - this.lUl) });
        AppMethodBeat.o(49615);
        return;
      }
    }
  }
  
  private void brY()
  {
    AppMethodBeat.i(49623);
    if (this.lUI != null)
    {
      EditText localEditText = (EditText)this.lUI.findViewById(2131296709);
      if ((localEditText != null) && (!bt.isNullOrNil(this.lUL)))
      {
        ad.v("MicroMsg.AppBrandDesktopView", "alvinluo initSearchView searchWording: %s", new Object[] { this.lUL });
        localEditText.setHint(this.lUL);
      }
    }
    AppMethodBeat.o(49623);
  }
  
  private void brZ()
  {
    AppMethodBeat.i(49624);
    if (this.lRJ != null)
    {
      View localView = this.lRJ.getBackgroundGLSurfaceView();
      if ((localView != null) && (this.lUq != null))
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
        this.lUq.removeView(localView);
      }
    }
    AppMethodBeat.o(49624);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49613);
    int i = d.dQ(getContext());
    AppMethodBeat.o(49613);
    return i;
  }
  
  private void hv(boolean paramBoolean)
  {
    AppMethodBeat.i(49627);
    RecyclerView.r localr;
    if (this.aqy != null)
    {
      localr = this.aqy;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 1)
    {
      localr.ard = i;
      this.lUo.a(this.aqy);
      AppMethodBeat.o(49627);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    this.lUF = 0;
    this.lUE = this.lUF;
    b.init(this.mContext);
    this.amN = b.getCompletelyCountPerPage();
    brS();
    brU();
    this.lUo = new AppBrandDesktopView.j(this, this.amN);
    this.lUo.amS = new AppBrandDesktopView.10(this);
    setLayoutManager(this.lUo);
    setOverScrollMode(2);
    a(this.frd);
    this.aaj = new e((byte)0);
    setAdapter(this.aaj);
    brV();
    brT();
    aq.n(new AppBrandDesktopView.11(this), 200L);
    ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.lUJ) });
    this.lVa = com.tencent.mm.cd.a.fromDPToPix(paramContext, 200);
    this.lVh = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
    this.lVb = com.tencent.mm.cd.a.fromDPToPix(paramContext, 100);
    this.aqy = new AppBrandDesktopView.12(this, getContext());
    AppMethodBeat.o(49611);
  }
  
  private void setIgnoreNotify(boolean paramBoolean)
  {
    if (this.lUX != null) {
      this.lUX.lUQ = paramBoolean;
    }
    if (this.lUW != null) {
      this.lUW.lUQ = paramBoolean;
    }
  }
  
  private boolean uE(int paramInt)
  {
    AppMethodBeat.i(49601);
    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.hIH.size())
    {
      localObject = (c)this.hIH.get(i);
      if ((((c)localObject).type == 1) && (((c)localObject).lVq != null)) {
        localArrayList.add(((c)localObject).lVq);
      }
      i += 1;
    }
    Object localObject = c.lXD.bsy();
    if (localObject == null)
    {
      AppMethodBeat.o(49601);
      return false;
    }
    boolean bool = ((ah)localObject).g(localArrayList, paramInt);
    if (!bool) {
      ad.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
    }
    AppMethodBeat.o(49601);
    return bool;
  }
  
  final void aG(float paramFloat)
  {
    AppMethodBeat.i(49626);
    RecyclerView.v localv;
    if (this.lUm)
    {
      localv = cj(1);
      if ((localv != null) && (localv.arI != null)) {
        localv.arI.setAlpha(paramFloat);
      }
    }
    if (this.lUm) {}
    for (int i = 3;; i = 1)
    {
      localv = cj(i);
      if ((localv != null) && (localv.arI != null)) {
        localv.arI.setAlpha(paramFloat);
      }
      ad.v("MicroMsg.AppBrandDesktopView", "alvinluo updateTitleAlpha hasRecentData: %b, hasMyData: %b, alpha: %f", new Object[] { Boolean.valueOf(this.lUm), Boolean.valueOf(this.lUn), Float.valueOf(paramFloat) });
      AppMethodBeat.o(49626);
      return;
    }
  }
  
  final void brT()
  {
    AppMethodBeat.i(49612);
    if (this.lUY)
    {
      AppMethodBeat.o(49612);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.desktop.b.e locale = c.lXD.bsx();
    com.tencent.mm.plugin.appbrand.widget.desktop.b.b localb = c.lXD.bsy();
    if ((locale == null) || (localb == null))
    {
      AppMethodBeat.o(49612);
      return;
    }
    this.lUY = true;
    locale.remove(this.lUX);
    locale.add(this.lUX);
    localb.remove(this.lUW);
    localb.add(this.lUW);
    AppMethodBeat.o(49612);
  }
  
  public final void brW()
  {
    AppMethodBeat.i(49618);
    ad.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
    if (!this.lUP)
    {
      setIgnoreNotify(true);
      c.lXD.bsy();
      removeCallbacks(this.lVg);
      postDelayed(this.lVg, 600L);
      k.Mv(k.bmk());
      Object localObject1 = this.lUL;
      Object localObject2 = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnD, null);
      if ((localObject2 instanceof String)) {
        this.lUL = bt.by((String)localObject2, this.lUL);
      }
      ad.d("MicroMsg.AppBrandDesktopView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.lUL });
      brY();
      if ((this.lUO != null) && (this.lUs != null))
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", new Object[] { Integer.valueOf(this.lUs.getShowCount()), Integer.valueOf(getCollectionDataSize()) });
        this.lUO.ev(this.lUs.getShowCount(), getCollectionDataSize());
        this.lUO.buD();
        if (this.lUO != null)
        {
          if (this.lUs != null) {
            this.lUO.mlg = TextUtils.join(":", bF(this.lUs.getShowList()));
          }
          localObject1 = new ArrayList();
          localObject2 = this.hIH.iterator();
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
          this.lUO.mlh = TextUtils.join(":", bF((List)localObject1));
        }
        com.tencent.e.h.Iye.aP(new Runnable()
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
                if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).lVq != null))
                {
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).lVq);
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
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recentview.a(((AppBrandDesktopView.c)localObject2).lVq);
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
      this.lUP = true;
      this.lUS = true;
      this.lUT = true;
      aa.cj(42, com.tencent.mm.modelappbrand.b.atH());
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(49618);
  }
  
  public final void brX()
  {
    AppMethodBeat.i(49622);
    brW();
    AppMethodBeat.o(49622);
  }
  
  final void bsa()
  {
    AppMethodBeat.i(49625);
    Object localObject;
    if (!this.lUR)
    {
      if ((this.lRJ != null) && (b.aaf()))
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.lRJ.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.lRJ.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(1.0F);
        }
        if ((this.lRJ.getBackgroundGLSurfaceView() instanceof DynamicBackgroundGLSurfaceView)) {
          this.lUZ = true;
        }
        AppMethodBeat.o(49625);
      }
    }
    else
    {
      this.lUZ = false;
      if ((this.lRJ != null) && (b.aaf()))
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.lRJ.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101053));
        }
        localObject = this.lRJ.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setAlpha(1.0F);
          ((View)localObject).setVisibility(0);
        }
        brZ();
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
    if (this.lVP)
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
      this.lVc = paramMotionEvent.getRawY();
      this.lUx = true;
    }
    for (;;)
    {
      this.lVd = 0.0F;
      this.lVe = false;
      this.lVf = false;
      break;
      ad.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.lVe), Float.valueOf(this.lVd), Integer.valueOf(this.mTouchSlop) });
      if ((this.lUo != null) && (this.hIH != null))
      {
        i = this.lUo.jR();
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.hIH.size()) });
        if (i == this.hIH.size() - 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && (!this.lVe))
        {
          if (!this.lVf)
          {
            this.lVc = paramMotionEvent.getRawY();
            this.lVd = 0.0F;
            this.lVf = true;
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          this.lVd = ((paramMotionEvent.getRawY() - this.lVc) * 0.55F);
          if (this.lVd >= -this.mTouchSlop) {
            break;
          }
          this.lVe = true;
          break;
        }
      }
      if (!this.lVe) {
        break;
      }
      this.lVd = ((paramMotionEvent.getRawY() - this.lVc) * 0.55F);
      if (this.lVd > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      int i = (int)Math.abs(this.lVd);
      ad.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(49607);
      return true;
      if (this.lVe)
      {
        this.lUx = false;
        if ((Math.abs(this.lVd) >= this.lVb) && (this.lRJ != null))
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.lRJ.k(0L, 15);
        }
        animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.tX).start();
      }
    }
  }
  
  int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    if (!this.lUn)
    {
      AppMethodBeat.o(49617);
      return 0;
    }
    int i = this.hIH.size();
    int j = this.lUl;
    int k = this.lUG;
    AppMethodBeat.o(49617);
    return i - j - k - 1;
  }
  
  public int getLeftRightMargin()
  {
    AppMethodBeat.i(49610);
    int j = d.dR(getContext()) - this.lUv;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lUv) });
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
    this.lUt = ((AppBrandDesktopDragView)localView.findViewById(2131299233));
    if (this.lUt == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", new Object[] { Boolean.valueOf(bool) });
      this.lUt.setRecyclerView(this);
      this.lUt.setCopyList(this.lUk);
      this.lUt.setList(this.hIH);
      this.lUt.setHeaderContainer(this.lRJ);
      this.lUt.setCollectionCallback(this.lTN);
      this.lUt.setItemPadding(this.lUv);
      this.lUt.setAppBrandCounter(new a((byte)0));
      this.lUt.setViewWidth(this.aNI);
      this.lUt.setRecyclerViewScrollComputer(new g()
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
              int m = AppBrandDesktopView.j(AppBrandDesktopView.this).jO();
              int i = -(int)AppBrandDesktopView.j(AppBrandDesktopView.this).bY(m).getY();
              ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", new Object[] { Integer.valueOf(i) });
              j = 0;
              if (j < m)
              {
                AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.m(AppBrandDesktopView.this).get(j);
                if (localc != null)
                {
                  int k = localc.type;
                  ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
                  if ((k == 10) || (k == 11))
                  {
                    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.n(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 6)
                  {
                    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.o(AppBrandDesktopView.this) + i;
                  }
                  else if (k == 2)
                  {
                    k = AppBrandDesktopView.p(AppBrandDesktopView.this);
                    if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null) {
                      k = AppBrandDesktopView.p(AppBrandDesktopView.this) * AppBrandDesktopView.c(AppBrandDesktopView.this).getShowLines();
                    }
                    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", new Object[] { Integer.valueOf(k) });
                    i = k + i;
                  }
                  else if ((k == 1) && ((j - AppBrandDesktopView.f(AppBrandDesktopView.this)) % 4 == 0))
                  {
                    ad.d("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)) });
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
              ad.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo compute exception", new Object[0]);
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
      this.lVW = this.lUt;
      if ((this.lUt != null) && ((this.lUt.getParent() instanceof RelativeLayout)))
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
        this.lUq = ((RelativeLayout)this.lUt.getParent());
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
    this.aNI = paramInt1;
    this.aNJ = paramInt2;
    paramInt1 = d.b(this.aNI, getContext());
    if (paramInt1 != this.lUv)
    {
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", new Object[] { Integer.valueOf(this.lUv), Integer.valueOf(paramInt1) });
      b.init(getContext());
      this.lUv = paramInt1;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", new Object[] { Integer.valueOf(this.lUv) });
      if (this.lUr != null)
      {
        this.lUr.setItemPadding(this.lUv);
        if (this.lUs != null) {
          this.lUs.bsd();
        }
      }
      if (this.aaj != null) {
        this.aaj.aql.notifyChanged();
      }
      if (this.lRJ != null) {
        this.lRJ.brI();
      }
      if (this.lUt != null) {
        this.lUt.setItemPadding(paramInt1);
      }
    }
    if (this.lUt != null) {
      this.lUt.setViewWidth(this.aNI);
    }
    if ((!this.lVP) && (this.lRJ != null) && (this.lUu != this.lRJ.getViewHeight()))
    {
      this.lUu = this.lRJ.getViewHeight();
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.lUu), Integer.valueOf(this.lRJ.getMeasuredHeight()) });
    }
    AppMethodBeat.o(49616);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(49606);
    super.onVisibilityChanged(paramView, paramInt);
    ad.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.lUU) && (this.lRJ != null))
      {
        this.lRJ.l(100L, this.lUV);
        this.lUV = 0;
        this.lUU = false;
      }
      if (this.dvt)
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
        this.dvt = false;
        if (this.lUz != null) {
          removeCallbacks(this.lUz);
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
        this.lUz = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(49606);
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.lRJ = paramHeaderContainer;
  }
  
  public final void uF(int paramInt)
  {
    AppMethodBeat.i(49620);
    ad.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader] reason: %d", new Object[] { Integer.valueOf(paramInt) });
    removeCallbacks(this.lVg);
    if (this.lUP)
    {
      if ((this.lUO != null) && (this.lUs != null))
      {
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb = this.lUO;
        boolean bool = b.aaf();
        localb.mlf = bool;
        ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", new Object[] { Boolean.valueOf(bool) });
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", new Object[] { Integer.valueOf(this.lUs.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(paramInt) });
        localb = this.lUO;
        int i = b.brF();
        int j = this.lUs.getShowLines();
        int k = b.getCompletelyCountPerPage();
        localb.mkI = i;
        localb.mkJ = j;
        localb.mkK = k;
        localb = this.lUO;
        i = this.lUs.getShowCount();
        j = getCollectionDataSize();
        localb.mkE = i;
        localb.mkQ = j;
        localb.mkB = paramInt;
        com.tencent.e.h.Iye.aP(new b.2(localb));
        if (localb.mlg == null) {
          localb.mlg = "";
        }
        if (localb.mlh == null) {
          localb.mlh = "";
        }
        ad.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportShowAppIdList openSession: %d, recentShowAppIdList: %s, %d, starShowAppIdList: %s, %d", new Object[] { Integer.valueOf(localb.mkA), localb.mlg, Integer.valueOf(localb.mlg.length()), localb.mlh, Integer.valueOf(localb.mlh.length()) });
        com.tencent.mm.plugin.report.service.h.vKh.f(18446, new Object[] { Integer.valueOf(localb.mkA), localb.mlg, localb.mlh });
      }
      this.lUP = false;
      this.lUS = false;
      this.lUT = false;
      if ((paramInt != 9) && (paramInt != 13)) {
        break label459;
      }
      if (this.lUW != null) {
        this.lUW.lUQ = false;
      }
    }
    for (;;)
    {
      if (this.lUX != null) {
        this.lUX.lUQ = false;
      }
      postDelayed(new AppBrandDesktopView.2(this), 300L);
      uE(1);
      AppMethodBeat.o(49620);
      return;
      label459:
      if (this.lUW != null) {
        this.lUW.lUQ = true;
      }
    }
  }
  
  public final void uG(int paramInt)
  {
    AppMethodBeat.i(49621);
    uF(paramInt);
    AppMethodBeat.o(49621);
  }
  
  final class a
    implements AppBrandDesktopDragView.a
  {
    private a() {}
    
    public final int brP()
    {
      AppMethodBeat.i(49582);
      int i = AppBrandDesktopView.g(AppBrandDesktopView.this);
      AppMethodBeat.o(49582);
      return i;
    }
  }
  
  public static final class c
  {
    public LocalUsageInfo lVq;
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
    
    private AppBrandDesktopView.c uH(int paramInt)
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
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(49589);
      if (paramInt == 1)
      {
        paramViewGroup = new e(y.js(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false));
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 2)
      {
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
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
            public final void a(RecyclerView.v paramAnonymousv, AppBrandDesktopView.c paramAnonymousc)
            {
              AppMethodBeat.i(49586);
              AppBrandDesktopView.v(AppBrandDesktopView.this);
              AppBrandDesktopView.w(AppBrandDesktopView.this);
              AppBrandDesktopView.x(AppBrandDesktopView.this);
              AppBrandDesktopView.this.setLayoutFrozen(true);
              if (paramAnonymousc != null) {
                AppBrandDesktopView.a(AppBrandDesktopView.this, 1089, 2, paramAnonymousc.lVq, paramAnonymousv.ln());
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
            for (int i = AppBrandDesktopView.b(AppBrandDesktopView.this).mkA;; i = 0)
            {
              localp.b(paramAnonymousView, 13, i);
              AppMethodBeat.o(49587);
              return;
            }
          }
        });
        paramViewGroup = new RecyclerView.v(AppBrandDesktopView.c(AppBrandDesktopView.this)) {};
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
          AppBrandDesktopView.a(AppBrandDesktopView.this, y.js(AppBrandDesktopView.this.getContext()).inflate(2131492989, paramViewGroup, false));
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.z(AppBrandDesktopView.this));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
        catch (Exception paramViewGroup)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandDesktopView", paramViewGroup, "alvinluo init searchView exception", new Object[0]);
          paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, new View(AppBrandDesktopView.this.getContext()));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
      }
      if (paramInt == 7)
      {
        paramViewGroup = y.js(AppBrandDesktopView.this.getContext()).inflate(2131493104, paramViewGroup, false);
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
        paramViewGroup = y.js(AppBrandDesktopView.this.getContext()).inflate(2131492981, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.f(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 9)
      {
        paramViewGroup = y.js(AppBrandDesktopView.this.getContext()).inflate(2131492984, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.d(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      paramViewGroup = y.js(AppBrandDesktopView.this.getContext()).inflate(2131494989, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.h(AppBrandDesktopView.this, paramViewGroup);
      AppMethodBeat.o(49589);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(49591);
      int j = paramv.arM;
      Object localObject1;
      if (j == 3)
      {
        paramInt = AppBrandDesktopView.l(AppBrandDesktopView.this);
        if (AppBrandDesktopView.B(AppBrandDesktopView.this) == 0) {
          AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.C(AppBrandDesktopView.this).getViewHeight());
        }
        i = AppBrandDesktopView.B(AppBrandDesktopView.this) - com.tencent.mm.cd.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 56) - com.tencent.mm.cd.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 48);
        j = AppBrandDesktopView.k(AppBrandDesktopView.this);
        if (j > AppBrandDesktopView.o(AppBrandDesktopView.this) + i) {
          AppBrandDesktopView.h(AppBrandDesktopView.this, AppBrandDesktopView.D(AppBrandDesktopView.this));
        }
        for (;;)
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)), Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)), Integer.valueOf(j), Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)), Integer.valueOf(paramInt), Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
          paramv.arI.setVisibility(4);
          localObject1 = (RecyclerView.LayoutParams)paramv.arI.getLayoutParams();
          ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.l(AppBrandDesktopView.this);
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)) });
          paramv.arI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
        if (paramv == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        localObject1 = paramv.arI;
        paramInt = AppBrandDesktopView.u(AppBrandDesktopView.this) + (int)(com.tencent.mm.cd.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8) * d.dT(AppBrandDesktopView.this.getContext()));
        localObject2 = new RecyclerView.LayoutParams(-1, -2);
        ((RecyclerView.LayoutParams)localObject2).setMargins(((RecyclerView.LayoutParams)localObject2).leftMargin + paramInt, ((RecyclerView.LayoutParams)localObject2).topMargin, paramInt + ((RecyclerView.LayoutParams)localObject2).rightMargin, ((RecyclerView.LayoutParams)localObject2).bottomMargin);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject1 = paramv.arI;
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", new Object[] { Integer.valueOf(((View)localObject1).getMeasuredHeight()), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
          AppBrandDesktopView.d(AppBrandDesktopView.this, ((View)localObject1).getMeasuredHeight());
        }
        paramv = ((AppBrandDesktopView.h)paramv).titleTv;
        if (j == 10) {}
        for (paramInt = 2131762214;; paramInt = 2131761482)
        {
          paramv.setText(paramInt);
          AppMethodBeat.o(49591);
          return;
        }
      }
      if (j == 8)
      {
        paramv = (AppBrandDesktopView.f)paramv;
        boolean bool;
        if (!AppBrandDesktopView.r(AppBrandDesktopView.this))
        {
          bool = true;
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(AppBrandDesktopView.p(paramv.lVl)) });
          if (!bool) {
            break label693;
          }
        }
        label693:
        for (paramInt = i;; paramInt = 4)
        {
          if ((AppBrandDesktopView.G(paramv.lVl) != null) && (bool)) {
            AppBrandDesktopView.G(paramv.lVl).getLayoutParams().height = AppBrandDesktopView.p(paramv.lVl);
          }
          if (paramv.arI != null) {
            paramv.arI.setVisibility(paramInt);
          }
          AppMethodBeat.o(49591);
          return;
          bool = false;
          break;
        }
      }
      if (j == 6)
      {
        AppBrandDesktopView.c(AppBrandDesktopView.this, paramv.arI);
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
        localObject1 = (e)paramv;
        ((e)localObject1).arI.setPadding(AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cd.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.u(AppBrandDesktopView.this), com.tencent.mm.cd.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
        i = (int)d.dS(AppBrandDesktopView.this.getContext());
        ((e)localObject1).lVz.getLayoutParams().width = ((int)(com.tencent.mm.cd.a.ap(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.dT(AppBrandDesktopView.this.getContext())) + i);
        ((e)localObject1).lVz.getLayoutParams().height = ((int)(com.tencent.mm.cd.a.ap(AppBrandDesktopView.this.getContext(), 2131165568) * 2 * d.dT(AppBrandDesktopView.this.getContext())) + i);
        ((e)localObject1).kXS.getLayoutParams().width = i;
        ((e)localObject1).kXS.getLayoutParams().height = i;
        ((e)localObject1).lVy.getLayoutParams().width = i;
        ((e)localObject1).lVy.getLayoutParams().height = i;
        paramv.arI.setVisibility(0);
        if (AppBrandDesktopView.p(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramv.arI;
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
          AppBrandDesktopView.e(AppBrandDesktopView.this, ((View)localObject2).getMeasuredHeight());
        }
        if (j == 7)
        {
          paramv.arI.setVisibility(4);
          if (((paramInt - AppBrandDesktopView.f(AppBrandDesktopView.this) + 1) % 4 == 1) && (paramInt > AppBrandDesktopView.f(AppBrandDesktopView.this)))
          {
            paramv.arI.getLayoutParams().height = 1;
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramv.arI.getLayoutParams().height);
            ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", new Object[] { Integer.valueOf(paramv.arI.getLayoutParams().height) });
            AppMethodBeat.o(49591);
            return;
          }
          if (AppBrandDesktopView.A(AppBrandDesktopView.this) == 0)
          {
            paramv = paramv.arI;
            paramv.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder emptyItemHeight: %d", new Object[] { Integer.valueOf(paramv.getMeasuredHeight()) });
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramv.getMeasuredHeight());
          }
          AppMethodBeat.o(49591);
          return;
        }
        localObject2 = uH(paramInt);
        if (localObject2 == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        ((AppBrandDesktopView.c)localObject2).position = paramInt;
        ((e)localObject1).lVC = ((AppBrandDesktopView.c)localObject2);
        if (((AppBrandDesktopView.c)localObject2).lVq == null) {
          break label1619;
        }
        if (bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).lVq.cfp)) {
          break label1456;
        }
        ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.NB(((AppBrandDesktopView.c)localObject2).lVq.cfp));
        ((e)localObject1).titleTv.setVisibility(0);
        ((e)localObject1).lVy.setVisibility(0);
        if (bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).lVq.iVP)) {
          break label1592;
        }
        com.tencent.mm.modelappbrand.a.b.aub().a(((e)localObject1).kXS, ((AppBrandDesktopView.c)localObject2).lVq.iVP, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
        label1339:
        if (bt.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.qC(((AppBrandDesktopView.c)localObject2).lVq.gXn))) {
          break label1606;
        }
        ((e)localObject1).lVA.setVisibility(0);
        ((e)localObject1).lVA.setText(com.tencent.mm.plugin.appbrand.appcache.e.qC(((AppBrandDesktopView.c)localObject2).lVq.gXn));
        label1384:
        ((e)localObject1).arI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49588);
            AppBrandDesktopView.v(AppBrandDesktopView.this);
            AppBrandDesktopView.w(AppBrandDesktopView.this);
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.this.setLayoutFrozen(true);
            AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, this.lVs.lVq, this.lVt.ln());
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
            if (((DragFeatureView)localObject1).lVH == paramInt)
            {
              paramv.arI.setVisibility(4);
              AppMethodBeat.o(49591);
              return;
              label1456:
              if (!bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).lVq.nickname))
              {
                ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.NB(((AppBrandDesktopView.c)localObject2).lVq.nickname));
                ((e)localObject1).titleTv.setVisibility(0);
                break;
              }
              if (!bt.isNullOrNil(((AppBrandDesktopView.c)localObject2).lVq.username))
              {
                ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.d.b.NB(((AppBrandDesktopView.c)localObject2).lVq.nickname));
                ((e)localObject1).titleTv.setVisibility(0);
                break;
              }
              ad.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { ((AppBrandDesktopView.c)localObject2).lVq.username, ((AppBrandDesktopView.c)localObject2).lVq.appId });
              ((e)localObject1).titleTv.setVisibility(4);
              break;
              label1592:
              ((e)localObject1).kXS.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aua());
              break label1339;
              label1606:
              ((e)localObject1).lVA.setVisibility(8);
              break label1384;
              label1619:
              com.tencent.mm.modelappbrand.a.b.aub().a(((e)localObject1).kXS, "", com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
              ((e)localObject1).titleTv.setVisibility(0);
              ((e)localObject1).lVA.setVisibility(8);
              ((e)localObject1).titleTv.setText("");
              continue;
            }
            paramv.arI.setVisibility(0);
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
      AppBrandDesktopView.c localc = uH(paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */