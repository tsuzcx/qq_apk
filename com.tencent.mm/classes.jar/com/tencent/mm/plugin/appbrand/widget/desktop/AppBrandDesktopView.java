package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.widget.recent.c;
import com.tencent.mm.plugin.appbrand.widget.recent.g.2;
import com.tencent.mm.plugin.appbrand.widget.recent.j;
import com.tencent.mm.plugin.appbrand.widget.recent.k;
import com.tencent.mm.plugin.appbrand.widget.recent.o;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandDesktopView
  extends DragRecyclerView
  implements b.a
{
  private int aYN;
  private int aYO;
  private RecyclerView.a adj;
  public int apM;
  private int atO;
  private boolean dSv;
  private boolean dXX;
  private RecyclerView.l guX;
  private int hIX;
  private boolean iCn;
  private boolean isPaused;
  private Context mContext;
  private ArrayList<c> mDataList;
  private Interpolator mInterpolator;
  private int mLastState;
  private RecyclerView.r mSmoothScroller;
  private int mTouchSlop;
  private int ocu;
  private AppBrandDesktopDragView.b omR;
  private int onA;
  private int onB;
  private boolean onC;
  private View onD;
  private int onE;
  private boolean onF;
  private String onG;
  private View onH;
  private int onI;
  private com.tencent.mm.plugin.appbrand.widget.recent.g onJ;
  private boolean onK;
  private boolean onL;
  private boolean onM;
  private boolean onN;
  private boolean onO;
  private int onP;
  public final AppBrandDesktopView.b onQ;
  public final AppBrandDesktopView.b onR;
  public boolean onS;
  private boolean onT;
  private int onU;
  private int onV;
  private float onW;
  private float onX;
  private boolean onY;
  private boolean onZ;
  private i onc;
  private ArrayList<c> ond;
  private int one;
  private boolean onf;
  private boolean ong;
  private HeaderContainer onh;
  private l oni;
  private boolean onj;
  private boolean onk;
  private RelativeLayout onl;
  public RecentAppBrandViewContainer onm;
  private RecentAppBrandView onn;
  private AppBrandDesktopDragView ono;
  private int onp;
  private int onq;
  private boolean onr;
  private boolean ons;
  public Runnable ont;
  public Runnable onu;
  private int onv;
  private int onw;
  private int onx;
  private int ony;
  private int onz;
  private final Runnable ooa;
  private int oob;
  private boolean ooc;
  private boolean ood;
  private Animator.AnimatorListener wY;
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49604);
    this.apM = 4;
    this.mDataList = new ArrayList();
    this.ond = new ArrayList();
    this.one = 0;
    this.onf = false;
    this.ong = false;
    this.oni = null;
    this.onj = false;
    this.atO = 0;
    this.onk = true;
    this.aYN = 0;
    this.aYO = 0;
    this.onp = 0;
    this.onq = 0;
    this.onr = false;
    this.ons = false;
    this.ont = null;
    this.onu = null;
    this.dXX = false;
    this.onz = 0;
    this.onA = 0;
    this.onB = 0;
    this.onC = false;
    this.onE = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 80);
    this.onF = true;
    this.onG = "";
    this.onI = 0;
    this.hIX = 0;
    this.onJ = new com.tencent.mm.plugin.appbrand.widget.recent.g();
    this.onK = false;
    this.onL = false;
    this.isPaused = false;
    this.onM = false;
    this.onN = false;
    this.onO = false;
    this.onP = 0;
    this.onQ = new AppBrandDesktopView.b(this, 1);
    this.onR = new AppBrandDesktopView.b(this, 2);
    this.onS = false;
    this.onT = false;
    this.onU = 0;
    this.dSv = false;
    this.omR = new AppBrandDesktopDragView.b()
    {
      public final void cU(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49564);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          Object localObject = (AppBrandDesktopView.c)paramAnonymousObject;
          if (((AppBrandDesktopView.c)localObject).ooj != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!Util.isNullOrNil(((AppBrandDesktopView.c)localObject).ooj.appId)))
            {
              com.tencent.mm.plugin.appbrand.widget.recent.g localg = AppBrandDesktopView.b(AppBrandDesktopView.this);
              localObject = ((AppBrandDesktopView.c)localObject).ooj.appId;
              Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { localObject });
              localg.oCj += 1;
              localg.oCq.append((String)localObject + ":");
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cV(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49565);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49565);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          Object localObject = (AppBrandDesktopView.c)paramAnonymousObject;
          if ((((AppBrandDesktopView.c)localObject).type == 1) && (((AppBrandDesktopView.c)localObject).ooj != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.recent.b localb = c.oBT.ccQ();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.bh(((AppBrandDesktopView.c)localObject).ooj.username, ((AppBrandDesktopView.c)localObject).ooj.iOo)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!Util.isNullOrNil(((AppBrandDesktopView.c)localObject).ooj.appId)))
            {
              paramAnonymousObject = AppBrandDesktopView.b(AppBrandDesktopView.this);
              localObject = ((AppBrandDesktopView.c)localObject).ooj.appId;
              Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { localObject });
              paramAnonymousObject.oCu += 1;
              paramAnonymousObject.oCz.append((String)localObject + ":");
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        Object localObject;
        if (paramAnonymousObject.ooj != null)
        {
          Log.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.ooj.username, Integer.valueOf(paramAnonymousObject.ooj.iOo) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          localObject = c.oBT.ccP();
          if (localObject == null) {
            break label310;
          }
        }
        label310:
        for (boolean bool = ((ah)localObject).bi(paramAnonymousObject.ooj.username, paramAnonymousObject.ooj.iOo);; bool = false)
        {
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.ooj != null) && (!Util.isNullOrNil(paramAnonymousObject.ooj.appId)))
          {
            localObject = AppBrandDesktopView.b(AppBrandDesktopView.this);
            String str = paramAnonymousObject.ooj.appId;
            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { str });
            ((com.tencent.mm.plugin.appbrand.widget.recent.g)localObject).oCi += 1;
            ((com.tencent.mm.plugin.appbrand.widget.recent.g)localObject).oCo.append(str + ":");
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            Log.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.d(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
            if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.e(AppBrandDesktopView.this).getAdapter().ci(paramAnonymousObject.position);
            }
          }
          AppMethodBeat.o(49566);
          return;
        }
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        AppBrandDesktopView.a(AppBrandDesktopView.this, true);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recent.g localg;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).ooj != null) && (!Util.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).ooj.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localg = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ooj.appId;
          Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localg.oCx += 1;
          localg.oCD.append(paramAnonymousObject + ":");
        }
        for (;;)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.f(AppBrandDesktopView.this));
          AppMethodBeat.o(49567);
          return;
          label194:
          if (paramAnonymousInt1 > paramAnonymousInt2)
          {
            localg = AppBrandDesktopView.b(AppBrandDesktopView.this);
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ooj.appId;
            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localg.oCw += 1;
            localg.oCC.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.onV = 0;
    this.onW = 0.0F;
    this.onX = 0.0F;
    this.onY = false;
    this.onZ = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wY = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.ooa = new AppBrandDesktopView.10(this);
    this.oob = 0;
    this.mLastState = -1;
    this.ooc = false;
    this.ood = true;
    this.guX = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(227756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.J(AppBrandDesktopView.this)) });
        if ((!AppBrandDesktopView.K(AppBrandDesktopView.this)) && (AppBrandDesktopView.J(AppBrandDesktopView.this)) && (paramAnonymousInt == 0))
        {
          AppBrandDesktopView.L(AppBrandDesktopView.this);
          AppBrandDesktopView.M(AppBrandDesktopView.this);
        }
        if (paramAnonymousInt == 0)
        {
          if (!AppBrandDesktopView.N(AppBrandDesktopView.this)) {
            break label214;
          }
          AppBrandDesktopView.O(AppBrandDesktopView.this);
          if (!AppBrandDesktopView.R(AppBrandDesktopView.this)) {
            break label246;
          }
          if ((AppBrandDesktopView.S(AppBrandDesktopView.this)) && (!AppBrandDesktopView.T(AppBrandDesktopView.this)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null)) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).ccU();
          }
        }
        for (;;)
        {
          AppBrandDesktopView.k(AppBrandDesktopView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(227756);
          return;
          label214:
          if ((AppBrandDesktopView.P(AppBrandDesktopView.this) != 1) && (AppBrandDesktopView.P(AppBrandDesktopView.this) != 2)) {
            break;
          }
          AppBrandDesktopView.Q(AppBrandDesktopView.this);
          break;
          label246:
          AppBrandDesktopView.U(AppBrandDesktopView.this);
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(227757);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.V(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.W(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.X(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).ks();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < AppBrandDesktopView.this.getChildCount()))
            {
              paramAnonymousInt1 = AppBrandDesktopView.this.getChildAt(paramAnonymousInt1).getTop();
              AppBrandDesktopView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(227757);
      }
    };
    init(paramContext);
    AppMethodBeat.o(49604);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49605);
    this.apM = 4;
    this.mDataList = new ArrayList();
    this.ond = new ArrayList();
    this.one = 0;
    this.onf = false;
    this.ong = false;
    this.oni = null;
    this.onj = false;
    this.atO = 0;
    this.onk = true;
    this.aYN = 0;
    this.aYO = 0;
    this.onp = 0;
    this.onq = 0;
    this.onr = false;
    this.ons = false;
    this.ont = null;
    this.onu = null;
    this.dXX = false;
    this.onz = 0;
    this.onA = 0;
    this.onB = 0;
    this.onC = false;
    this.onE = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 80);
    this.onF = true;
    this.onG = "";
    this.onI = 0;
    this.hIX = 0;
    this.onJ = new com.tencent.mm.plugin.appbrand.widget.recent.g();
    this.onK = false;
    this.onL = false;
    this.isPaused = false;
    this.onM = false;
    this.onN = false;
    this.onO = false;
    this.onP = 0;
    this.onQ = new AppBrandDesktopView.b(this, 1);
    this.onR = new AppBrandDesktopView.b(this, 2);
    this.onS = false;
    this.onT = false;
    this.onU = 0;
    this.dSv = false;
    this.omR = new AppBrandDesktopDragView.b()
    {
      public final void cU(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49564);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49564);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          Object localObject = (AppBrandDesktopView.c)paramAnonymousObject;
          if (((AppBrandDesktopView.c)localObject).ooj != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!Util.isNullOrNil(((AppBrandDesktopView.c)localObject).ooj.appId)))
            {
              com.tencent.mm.plugin.appbrand.widget.recent.g localg = AppBrandDesktopView.b(AppBrandDesktopView.this);
              localObject = ((AppBrandDesktopView.c)localObject).ooj.appId;
              Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { localObject });
              localg.oCj += 1;
              localg.oCq.append((String)localObject + ":");
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(49564);
      }
      
      public final void cV(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49565);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49565);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          Object localObject = (AppBrandDesktopView.c)paramAnonymousObject;
          if ((((AppBrandDesktopView.c)localObject).type == 1) && (((AppBrandDesktopView.c)localObject).ooj != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this, true);
            com.tencent.mm.plugin.appbrand.widget.recent.b localb = c.oBT.ccQ();
            if (localb == null)
            {
              AppMethodBeat.o(49565);
              return;
            }
            if (localb.bh(((AppBrandDesktopView.c)localObject).ooj.username, ((AppBrandDesktopView.c)localObject).ooj.iOo)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (!Util.isNullOrNil(((AppBrandDesktopView.c)localObject).ooj.appId)))
            {
              paramAnonymousObject = AppBrandDesktopView.b(AppBrandDesktopView.this);
              localObject = ((AppBrandDesktopView.c)localObject).ooj.appId;
              Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { localObject });
              paramAnonymousObject.oCu += 1;
              paramAnonymousObject.oCz.append((String)localObject + ":");
            }
          }
        }
        AppMethodBeat.o(49565);
      }
      
      public final void cW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49566);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(49566);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        Object localObject;
        if (paramAnonymousObject.ooj != null)
        {
          Log.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.ooj.username, Integer.valueOf(paramAnonymousObject.ooj.iOo) });
          AppBrandDesktopView.a(AppBrandDesktopView.this, true);
          localObject = c.oBT.ccP();
          if (localObject == null) {
            break label310;
          }
        }
        label310:
        for (boolean bool = ((ah)localObject).bi(paramAnonymousObject.ooj.username, paramAnonymousObject.ooj.iOo);; bool = false)
        {
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (paramAnonymousObject.ooj != null) && (!Util.isNullOrNil(paramAnonymousObject.ooj.appId)))
          {
            localObject = AppBrandDesktopView.b(AppBrandDesktopView.this);
            String str = paramAnonymousObject.ooj.appId;
            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { str });
            ((com.tencent.mm.plugin.appbrand.widget.recent.g)localObject).oCi += 1;
            ((com.tencent.mm.plugin.appbrand.widget.recent.g)localObject).oCo.append(str + ":");
          }
          if (AppBrandDesktopView.c(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(49566);
              return;
            }
            Log.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.d(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.c(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.d(AppBrandDesktopView.this));
            if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.e(AppBrandDesktopView.this).getAdapter().ci(paramAnonymousObject.position);
            }
          }
          AppMethodBeat.o(49566);
          return;
        }
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(49567);
        AppBrandDesktopView.a(AppBrandDesktopView.this, true);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.a(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recent.g localg;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).ooj != null) && (!Util.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).ooj.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label194;
          }
          localg = AppBrandDesktopView.b(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ooj.appId;
          Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localg.oCx += 1;
          localg.oCD.append(paramAnonymousObject + ":");
        }
        for (;;)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.f(AppBrandDesktopView.this));
          AppMethodBeat.o(49567);
          return;
          label194:
          if (paramAnonymousInt1 > paramAnonymousInt2)
          {
            localg = AppBrandDesktopView.b(AppBrandDesktopView.this);
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).ooj.appId;
            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localg.oCw += 1;
            localg.oCC.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.onV = 0;
    this.onW = 0.0F;
    this.onX = 0.0F;
    this.onY = false;
    this.onZ = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wY = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.ooa = new AppBrandDesktopView.10(this);
    this.oob = 0;
    this.mLastState = -1;
    this.ooc = false;
    this.ood = true;
    this.guX = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(227756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(AppBrandDesktopView.J(AppBrandDesktopView.this)) });
        if ((!AppBrandDesktopView.K(AppBrandDesktopView.this)) && (AppBrandDesktopView.J(AppBrandDesktopView.this)) && (paramAnonymousInt == 0))
        {
          AppBrandDesktopView.L(AppBrandDesktopView.this);
          AppBrandDesktopView.M(AppBrandDesktopView.this);
        }
        if (paramAnonymousInt == 0)
        {
          if (!AppBrandDesktopView.N(AppBrandDesktopView.this)) {
            break label214;
          }
          AppBrandDesktopView.O(AppBrandDesktopView.this);
          if (!AppBrandDesktopView.R(AppBrandDesktopView.this)) {
            break label246;
          }
          if ((AppBrandDesktopView.S(AppBrandDesktopView.this)) && (!AppBrandDesktopView.T(AppBrandDesktopView.this)) && (AppBrandDesktopView.b(AppBrandDesktopView.this) != null)) {
            AppBrandDesktopView.b(AppBrandDesktopView.this).ccU();
          }
        }
        for (;;)
        {
          AppBrandDesktopView.k(AppBrandDesktopView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(227756);
          return;
          label214:
          if ((AppBrandDesktopView.P(AppBrandDesktopView.this) != 1) && (AppBrandDesktopView.P(AppBrandDesktopView.this) != 2)) {
            break;
          }
          AppBrandDesktopView.Q(AppBrandDesktopView.this);
          break;
          label246:
          AppBrandDesktopView.U(AppBrandDesktopView.this);
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(227757);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopView.V(AppBrandDesktopView.this))
        {
          AppBrandDesktopView.W(AppBrandDesktopView.this);
          if (AppBrandDesktopView.j(AppBrandDesktopView.this) != null)
          {
            paramAnonymousInt1 = AppBrandDesktopView.X(AppBrandDesktopView.this) - AppBrandDesktopView.j(AppBrandDesktopView.this).ks();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < AppBrandDesktopView.this.getChildCount()))
            {
              paramAnonymousInt1 = AppBrandDesktopView.this.getChildAt(paramAnonymousInt1).getTop();
              AppBrandDesktopView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$12", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(227757);
      }
    };
    init(paramContext);
    AppMethodBeat.o(49605);
  }
  
  private boolean a(LocalUsageInfo paramLocalUsageInfo, WxaAttributes.a parama)
  {
    if ((parama.serviceType != 0) && (parama.serviceType != 4)) {}
    do
    {
      return true;
      if (this.ocu == 0) {
        return paramLocalUsageInfo.kWa;
      }
    } while (this.ocu != 2);
    return false;
  }
  
  private static ArrayList<String> bW(List<c> paramList)
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
      if ((localc.ooj != null) && (!Util.isNullOrNil(localc.ooj.appId))) {
        localArrayList.add(localc.ooj.appId);
      }
    }
    AppMethodBeat.o(49619);
    return localArrayList;
  }
  
  private void caA()
  {
    AppMethodBeat.i(49615);
    long l = System.currentTimeMillis();
    this.mDataList.clear();
    this.ond.clear();
    this.onB = 0;
    this.onC = false;
    if (this.onk) {
      this.mDataList.add(new c(6));
    }
    Object localObject1 = c.oBT.ccP();
    if (localObject1 != null) {}
    for (localObject1 = ((j)localObject1).vW(com.tencent.mm.plugin.appbrand.widget.recent.i.oCT.count);; localObject1 = null)
    {
      Object localObject2 = c.oBT.ccQ();
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject2).a(com.tencent.mm.plugin.appbrand.widget.recent.i.oCS.count, com.tencent.mm.plugin.appbrand.widget.recent.i.oCS.kWk);; localObject2 = null)
      {
        boolean bool;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          bool = true;
          this.onf = bool;
          caw();
          if (this.ono != null) {
            this.ono.setCollectionStartPosition(this.one);
          }
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            break label251;
          }
        }
        label251:
        for (this.ong = false;; this.ong = true)
        {
          if ((this.onf) || (this.ong)) {
            break label259;
          }
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
          this.mDataList.add(new c(9));
          this.mDataList.add(new c(3));
          AppMethodBeat.o(49615);
          return;
          bool = false;
          break;
        }
        label259:
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
            localc.ooj = ((LocalUsageInfo)((List)localObject1).get(i));
            this.ond.add(localc);
            i += 1;
          }
        }
        this.mDataList.add(new c(11));
        if (localObject2 != null)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = new c(1);
            ((c)localObject1).ooj = ((LocalUsageInfo)((List)localObject2).get(i));
            this.mDataList.add(localObject1);
            i += 1;
          }
        }
        cas();
        if (!this.ong)
        {
          this.mDataList.add(new c(8));
          this.onC = true;
        }
        this.mDataList.add(new c(3));
        if (this.ono != null)
        {
          this.ono.setCopyList(this.ond);
          this.ono.setList(this.mDataList);
        }
        Log.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused) });
        if (this.asn) {
          this.dXX = true;
        }
        this.adj.atj.notifyChanged();
        if (this.onm != null)
        {
          Log.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
          this.onm.setDataList(this.ond);
          this.onm.notifyDataSetChanged();
        }
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", new Object[] { Integer.valueOf(this.mDataList.size()), Integer.valueOf(this.ond.size()), Integer.valueOf(this.mDataList.size() - this.one) });
        AppMethodBeat.o(49615);
        return;
      }
    }
  }
  
  private void caD()
  {
    AppMethodBeat.i(49623);
    if (this.onD != null)
    {
      EditText localEditText = (EditText)this.onD.findViewById(2131296791);
      if ((localEditText != null) && (!Util.isNullOrNil(this.onG)))
      {
        Log.v("MicroMsg.AppBrandDesktopView", "alvinluo initSearchView searchWording: %s", new Object[] { this.onG });
        localEditText.setHint(this.onG);
      }
    }
    AppMethodBeat.o(49623);
  }
  
  private void car()
  {
    AppMethodBeat.i(49602);
    this.mDataList.clear();
    this.mDataList.add(new c(6));
    this.mDataList.add(new c(9));
    this.mDataList.add(new c(3));
    this.onf = false;
    this.ong = false;
    this.onC = false;
    this.adj.atj.notifyChanged();
    jc(true);
    AppMethodBeat.o(49602);
  }
  
  private void cas()
  {
    int i = 0;
    AppMethodBeat.i(49603);
    Log.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.onB), Integer.valueOf(this.mDataList.size() - 4), Integer.valueOf(1) });
    while (i <= 0)
    {
      this.mDataList.add(new c(7));
      i += 1;
    }
    this.onB = 1;
    AppMethodBeat.o(49603);
  }
  
  private void cat()
  {
    AppMethodBeat.i(49609);
    this.onq = getItemPadding();
    AppMethodBeat.o(49609);
  }
  
  private void caw()
  {
    AppMethodBeat.i(227766);
    if (this.onf)
    {
      if (this.onk) {}
      for (i = 4;; i = 3)
      {
        this.one = i;
        Log.i("MicroMsg.AppBrandDesktopView", "alvinuo updateMyAppBrandStartPosition: %d", new Object[] { Integer.valueOf(this.one) });
        AppMethodBeat.o(227766);
        return;
      }
    }
    if (this.onk) {}
    for (int i = 2;; i = 1)
    {
      this.one = i;
      break;
    }
  }
  
  private void cax()
  {
    AppMethodBeat.i(227767);
    if (this.adj != null) {
      this.adj.atj.notifyChanged();
    }
    AppMethodBeat.o(227767);
  }
  
  private void cay()
  {
    AppMethodBeat.i(49612);
    if (this.onS)
    {
      AppMethodBeat.o(49612);
      return;
    }
    j localj = c.oBT.ccP();
    com.tencent.mm.plugin.appbrand.widget.recent.b localb = c.oBT.ccQ();
    if ((localj == null) || (localb == null))
    {
      AppMethodBeat.o(49612);
      return;
    }
    this.onS = true;
    localj.remove(this.onR);
    localj.add(this.onR);
    localb.remove(this.onQ);
    localb.add(this.onQ);
    AppMethodBeat.o(49612);
  }
  
  private void caz()
  {
    AppMethodBeat.i(49614);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131101287));
    AppMethodBeat.o(49614);
  }
  
  private int getCollectionDataSize()
  {
    AppMethodBeat.i(49617);
    if (!this.ong)
    {
      AppMethodBeat.o(49617);
      return 0;
    }
    int i = this.mDataList.size();
    int j = this.one;
    int k = this.onB;
    AppMethodBeat.o(49617);
    return i - j - k - 1;
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49613);
    int i = b.ew(getContext());
    AppMethodBeat.o(49613);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49611);
    this.mContext = paramContext;
    this.onA = 0;
    this.onz = this.onA;
    cau();
    jb(false);
    a.init(this.mContext);
    this.apM = a.getCompletelyCountPerPage();
    cat();
    caz();
    this.oni = new l(this.apM);
    this.oni.apR = new AppBrandDesktopView.7(this);
    setLayoutManager(this.oni);
    setOverScrollMode(2);
    a(this.guX);
    this.adj = new e((byte)0);
    setAdapter(this.adj);
    caA();
    cay();
    MMHandlerThread.postToMainThreadDelayed(new AppBrandDesktopView.8(this), 200L);
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.onE) });
    this.onU = com.tencent.mm.cb.a.fromDPToPix(paramContext, 200);
    this.oob = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    this.onV = com.tencent.mm.cb.a.fromDPToPix(paramContext, 100);
    this.mSmoothScroller = new ae(getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 20.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF bZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(227760);
        PointF localPointF = AppBrandDesktopView.j(AppBrandDesktopView.this).bZ(paramAnonymousInt);
        AppMethodBeat.o(227760);
        return localPointF;
      }
      
      public final int kA()
      {
        return -1;
      }
    };
    AppMethodBeat.o(49611);
  }
  
  private void jc(boolean paramBoolean)
  {
    AppMethodBeat.i(49627);
    RecyclerView.r localr;
    if (this.mSmoothScroller != null)
    {
      localr = this.mSmoothScroller;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 1)
    {
      localr.atO = i;
      this.oni.startSmoothScroll(this.mSmoothScroller);
      AppMethodBeat.o(49627);
      return;
    }
  }
  
  private void setIgnoreNotify(boolean paramBoolean)
  {
    if (this.onR != null) {
      this.onR.onL = paramBoolean;
    }
    if (this.onQ != null) {
      this.onQ.onL = paramBoolean;
    }
  }
  
  private boolean zS(int paramInt)
  {
    AppMethodBeat.i(49601);
    Log.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mDataList.size())
    {
      localObject = (c)this.mDataList.get(i);
      if ((((c)localObject).type == 1) && (((c)localObject).ooj != null)) {
        localArrayList.add(((c)localObject).ooj);
      }
      i += 1;
    }
    Object localObject = c.oBT.ccQ();
    if (localObject == null)
    {
      AppMethodBeat.o(49601);
      return false;
    }
    boolean bool = ((ag)localObject).g(localArrayList, paramInt);
    if (!bool) {
      Log.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
    }
    AppMethodBeat.o(49601);
    return bool;
  }
  
  public final void caB()
  {
    AppMethodBeat.i(49618);
    Log.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
    if (!this.onK)
    {
      setIgnoreNotify(true);
      c.oBT.ccQ();
      removeCallbacks(this.ooa);
      postDelayed(this.ooa, 600L);
      l.aeK(l.bUv());
      Object localObject1 = this.onG;
      Object localObject2 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oak, null);
      if ((localObject2 instanceof String)) {
        this.onG = Util.nullAs((String)localObject2, this.onG);
      }
      Log.d("MicroMsg.AppBrandDesktopView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.onG });
      caD();
      if ((this.onJ != null) && (this.onn != null))
      {
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", new Object[] { Integer.valueOf(this.onn.getShowCount()), Integer.valueOf(getCollectionDataSize()) });
        this.onJ.eO(this.onn.getShowCount(), getCollectionDataSize());
        this.onJ.ccU();
        if (this.onJ != null)
        {
          if (this.onn != null) {
            this.onJ.oCI = TextUtils.join(":", bW(this.onn.getShowList()));
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
          this.onJ.oCJ = TextUtils.join(":", bW((List)localObject1));
        }
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49580);
            if ((AppBrandDesktopView.r(AppBrandDesktopView.this)) && (AppBrandDesktopView.s(AppBrandDesktopView.this)))
            {
              if (AppBrandDesktopView.e(AppBrandDesktopView.this) == null)
              {
                AppMethodBeat.o(49580);
                return;
              }
              Object localObject1 = AppBrandDesktopView.e(AppBrandDesktopView.this).getShowList();
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              Object localObject2;
              while (i < ((List)localObject1).size())
              {
                localObject2 = (AppBrandDesktopView.c)((List)localObject1).get(i);
                if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).ooj != null))
                {
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recent.e(((AppBrandDesktopView.c)localObject2).ooj);
                  ((com.tencent.mm.plugin.appbrand.widget.recent.e)localObject2).position = i;
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
                  localObject2 = new com.tencent.mm.plugin.appbrand.widget.recent.e(((AppBrandDesktopView.c)localObject2).ooj);
                  ((com.tencent.mm.plugin.appbrand.widget.recent.e)localObject2).position = i;
                  ((List)localObject1).add(localObject2);
                }
                i += 1;
              }
              com.tencent.mm.plugin.appbrand.widget.recent.g.k(localArrayList, (List)localObject1);
            }
            AppMethodBeat.o(49580);
          }
        });
      }
      this.onK = true;
      this.onN = true;
      this.onO = true;
      com.tencent.mm.modelappbrand.b.aXE();
      ai.LX(0L);
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(49618);
  }
  
  public final void caC()
  {
    AppMethodBeat.i(49622);
    caB();
    AppMethodBeat.o(49622);
  }
  
  public final void cau()
  {
    AppMethodBeat.i(227763);
    this.iCn = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
    this.ocu = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
    Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu) });
    AppMethodBeat.o(227763);
  }
  
  public final void cav()
  {
    boolean bool2 = true;
    AppMethodBeat.i(227765);
    AppBrandDesktopDragView localAppBrandDesktopDragView;
    if (this.ono != null)
    {
      localAppBrandDesktopDragView = this.ono;
      bool1 = bool2;
      if (this.iCn) {
        if (this.ocu != 1) {
          break label51;
        }
      }
    }
    label51:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAppBrandDesktopDragView.setRecentListDragEnable(bool1);
      AppMethodBeat.o(227765);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49607);
    boolean bool;
    if (this.ooU)
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
      this.onW = paramMotionEvent.getRawY();
      this.ons = true;
    }
    for (;;)
    {
      this.onX = 0.0F;
      this.onY = false;
      this.onZ = false;
      break;
      Log.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.onY), Float.valueOf(this.onX), Integer.valueOf(this.mTouchSlop) });
      if ((this.oni != null) && (this.mDataList != null))
      {
        i = this.oni.kv();
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mDataList.size()) });
        if (i == this.mDataList.size() - 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && (!this.onY))
        {
          if (!this.onZ)
          {
            this.onW = paramMotionEvent.getRawY();
            this.onX = 0.0F;
            this.onZ = true;
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          this.onX = ((paramMotionEvent.getRawY() - this.onW) * 0.55F);
          if (this.onX >= -this.mTouchSlop) {
            break;
          }
          this.onY = true;
          break;
        }
      }
      if (!this.onY) {
        break;
      }
      this.onX = ((paramMotionEvent.getRawY() - this.onW) * 0.55F);
      if (this.onX > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49607);
        return bool;
      }
      int i = (int)Math.abs(this.onX);
      Log.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(49607);
      return true;
      if (this.onY)
      {
        this.ons = false;
        if ((Math.abs(this.onX) >= this.onV) && (this.onh != null))
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.onh.ac(0L, 15);
        }
        animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.wY).start();
      }
    }
  }
  
  public final void eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227768);
    Log.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader] reason: %d", new Object[] { Integer.valueOf(paramInt1) });
    removeCallbacks(this.ooa);
    if (this.onK)
    {
      if ((this.onJ != null) && (this.onn != null))
      {
        this.onJ.oCH = false;
        Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", new Object[] { Boolean.FALSE });
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", new Object[] { Integer.valueOf(this.onn.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(paramInt1) });
        com.tencent.mm.plugin.appbrand.widget.recent.g localg = this.onJ;
        paramInt2 = a.cal();
        int i = this.onn.getShowLines();
        int j = a.getCompletelyCountPerPage();
        localg.oCk = paramInt2;
        localg.oCl = i;
        localg.oCm = j;
        localg = this.onJ;
        paramInt2 = this.onn.getShowCount();
        i = getCollectionDataSize();
        localg.oCg = paramInt2;
        localg.oCs = i;
        localg.oCd = paramInt1;
        com.tencent.f.h.RTc.aX(new g.2(localg));
        if (localg.oCI == null) {
          localg.oCI = "";
        }
        if (localg.oCJ == null) {
          localg.oCJ = "";
        }
        Log.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportShowAppIdList openSession: %d, recentShowAppIdList: %s, %d, starShowAppIdList: %s, %d", new Object[] { Integer.valueOf(localg.oCc), localg.oCI, Integer.valueOf(localg.oCI.length()), localg.oCJ, Integer.valueOf(localg.oCJ.length()) });
        com.tencent.mm.plugin.report.service.h.CyF.a(18446, new Object[] { Integer.valueOf(localg.oCc), localg.oCI, localg.oCJ });
      }
      this.onK = false;
      this.onN = false;
      this.onO = false;
      if ((paramInt1 != 9) && (paramInt1 != 13)) {
        break label447;
      }
      if (this.onQ != null) {
        this.onQ.onL = false;
      }
    }
    for (;;)
    {
      if (this.onR != null) {
        this.onR.onL = false;
      }
      postDelayed(new AppBrandDesktopView.12(this), 300L);
      zS(1);
      AppMethodBeat.o(227768);
      return;
      label447:
      if (this.onQ != null) {
        this.onQ.onL = true;
      }
    }
  }
  
  public int getLeftRightMargin()
  {
    AppMethodBeat.i(49610);
    int j = b.ex(getContext()) - this.onq;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.onq) });
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
  
  public final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(227764);
    boolean bool2 = this.onk;
    if ((!this.iCn) || (this.ocu == 1)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.onk = bool1;
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateShowSearchStatus showSearch: %b, lastShow: %b, updateSearchView: %b", new Object[] { Boolean.valueOf(this.onk), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        break;
      }
      AppMethodBeat.o(227764);
      return;
    }
    if (this.onk != bool2)
    {
      c localc;
      if (this.onk)
      {
        if (this.mDataList.size() == 0)
        {
          this.mDataList.add(0, new c(6));
          cax();
          AppMethodBeat.o(227764);
          return;
        }
        localc = (c)this.mDataList.get(0);
        if ((localc == null) || (localc.type != 6))
        {
          this.mDataList.add(0, new c(6));
          cax();
        }
        AppMethodBeat.o(227764);
        return;
      }
      if (this.mDataList.size() > 0)
      {
        localc = (c)this.mDataList.get(0);
        if ((localc != null) && (localc.type == 6))
        {
          this.mDataList.remove(0);
          cax();
        }
      }
    }
    AppMethodBeat.o(227764);
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
    this.ono = ((AppBrandDesktopDragView)localView.findViewById(2131299799));
    if (this.ono == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", new Object[] { Boolean.valueOf(bool) });
      cav();
      this.ono.setRecyclerView(this);
      this.ono.setCopyList(this.ond);
      this.ono.setList(this.mDataList);
      this.ono.setCollectionCallback(this.omR);
      this.ono.setItemPadding(this.onq);
      this.ono.setAppBrandCounter(new a((byte)0));
      this.ono.setViewWidth(this.aYN);
      this.ono.setRecyclerViewScrollComputer(new f() {});
      this.opb = this.ono;
      if ((this.ono != null) && ((this.ono.getParent() instanceof RelativeLayout)))
      {
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
        this.onl = ((RelativeLayout)this.ono.getParent());
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
    this.aYN = paramInt1;
    this.aYO = paramInt2;
    Log.i("MicroMsg.AppBrandDesktopView", "[onMeasure] appbrand desktop view container width: %d", new Object[] { Integer.valueOf(this.aYN) });
    paramInt1 = b.b(this.aYN, getContext());
    if (paramInt1 != this.onq)
    {
      paramInt2 = this.aYN;
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", new Object[] { Integer.valueOf(this.onq), Integer.valueOf(paramInt1) });
      a.init(getContext());
      this.onq = paramInt1;
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", new Object[] { Integer.valueOf(this.onq) });
      if (this.onm != null)
      {
        this.onm.eH(this.onq, paramInt2);
        if (this.onn != null) {
          this.onn.cax();
        }
      }
      if (this.adj != null) {
        this.adj.atj.notifyChanged();
      }
      if (this.ono != null) {
        this.ono.setItemPadding(paramInt1);
      }
    }
    if (this.ono != null) {
      this.ono.setViewWidth(this.aYN);
    }
    if ((!this.ooU) && (this.onh != null) && (this.onp != this.onh.getViewHeight()))
    {
      this.onp = this.onh.getViewHeight();
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.onp), Integer.valueOf(this.onh.getMeasuredHeight()) });
    }
    AppMethodBeat.o(49616);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(49606);
    super.onVisibilityChanged(paramView, paramInt);
    Log.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(49606);
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.onh = paramHeaderContainer;
  }
  
  public void setTaskBarCallback(i parami)
  {
    this.onc = parami;
  }
  
  public final void zT(int paramInt)
  {
    AppMethodBeat.i(49621);
    eG(paramInt, 0);
    AppMethodBeat.o(49621);
  }
  
  final class a
    implements AppBrandDesktopDragView.a
  {
    private a() {}
    
    public final int caq()
    {
      AppMethodBeat.i(49582);
      int i = AppBrandDesktopView.g(AppBrandDesktopView.this);
      AppMethodBeat.o(49582);
      return i;
    }
  }
  
  public static final class c
  {
    public LocalUsageInfo ooj;
    public int position;
    public int type;
    
    public c(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(49585);
      if ((AppBrandDesktopView.I(AppBrandDesktopView.this) == 0) && (this.aus != null))
      {
        this.aus.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.aus.getMeasuredHeight()), Integer.valueOf(this.aus.getMeasuredWidth()) });
        AppBrandDesktopView.j(AppBrandDesktopView.this, this.aus.getMeasuredHeight());
      }
      AppMethodBeat.o(49585);
    }
  }
  
  final class e
    extends RecyclerView.a
  {
    private e() {}
    
    private AppBrandDesktopView.c zU(int paramInt)
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
        paramViewGroup = new d(aa.jQ(AppBrandDesktopView.this.getContext()).inflate(2131493146, paramViewGroup, false));
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 2)
      {
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
        AppBrandDesktopView.a(AppBrandDesktopView.this, new RecentAppBrandViewContainer(AppBrandDesktopView.this.getContext()));
        paramViewGroup = new RecyclerView.LayoutParams(-1, -2);
        AppBrandDesktopView.c(AppBrandDesktopView.this).setLayoutParams(paramViewGroup);
        AppBrandDesktopView.c(AppBrandDesktopView.this).eH(AppBrandDesktopView.v(AppBrandDesktopView.this), AppBrandDesktopView.w(AppBrandDesktopView.this));
        AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.c(AppBrandDesktopView.this).getRecentView());
        if (AppBrandDesktopView.e(AppBrandDesktopView.this) != null)
        {
          AppBrandDesktopView.e(AppBrandDesktopView.this).setReporter(AppBrandDesktopView.b(AppBrandDesktopView.this));
          AppBrandDesktopView.e(AppBrandDesktopView.this).setOnItemClickListener(new RecentAppBrandView.b()
          {
            public final void a(final RecyclerView.v paramAnonymousv, final AppBrandDesktopView.c paramAnonymousc)
            {
              AppMethodBeat.i(49586);
              if (paramAnonymousc == null)
              {
                AppMethodBeat.o(49586);
                return;
              }
              AppBrandDesktopView.a(AppBrandDesktopView.this, paramAnonymousc.ooj, new AppBrandDesktopView.f()
              {
                public final void dQ(boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(227762);
                  Log.i("MicroMsg.AppBrandDesktopView", "checkLaunchAppBrand checkOk: %b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                  if (!paramAnonymous2Boolean)
                  {
                    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(AppBrandDesktopView.i(AppBrandDesktopView.this));
                    if (paramAnonymousc.ooj != null) {
                      com.tencent.mm.plugin.appbrand.launching.f.a.aco(paramAnonymousc.ooj.username);
                    }
                    AppMethodBeat.o(227762);
                    return;
                  }
                  AppBrandDesktopView.x(AppBrandDesktopView.this);
                  AppBrandDesktopView.y(AppBrandDesktopView.this);
                  AppBrandDesktopView.z(AppBrandDesktopView.this);
                  AppBrandDesktopView.this.setLayoutFrozen(true);
                  AppBrandDesktopView.a(AppBrandDesktopView.this, 1089, 2, paramAnonymousc.ooj, paramAnonymousv.lR());
                  AppMethodBeat.o(227762);
                }
              });
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.y(AppBrandDesktopView.this);
            AppBrandDesktopView.z(AppBrandDesktopView.this);
            AppBrandDesktopView.u(AppBrandDesktopView.this).jd(false);
            AppBrandDesktopView.c(AppBrandDesktopView.this, 9);
            AppBrandDesktopView.u(AppBrandDesktopView.this).setCloseReason(AppBrandDesktopView.t(AppBrandDesktopView.this));
            localObject = (t)com.tencent.mm.kernel.g.af(t.class);
            paramAnonymousView = paramAnonymousView.getContext();
            if (AppBrandDesktopView.b(AppBrandDesktopView.this) != null) {}
            for (int i = AppBrandDesktopView.b(AppBrandDesktopView.this).oCc;; i = 0)
            {
              ((t)localObject).L(paramAnonymousView, i);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.v(AppBrandDesktopView.this), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.v(AppBrandDesktopView.this), localLayoutParams.bottomMargin);
        paramViewGroup.setLayoutParams(localLayoutParams);
        paramViewGroup = new AppBrandDesktopView.j(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 6) {
        try
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, aa.jQ(AppBrandDesktopView.this.getContext()).inflate(2131493025, paramViewGroup, false));
          paramViewGroup = new AppBrandDesktopView.h(AppBrandDesktopView.this, AppBrandDesktopView.A(AppBrandDesktopView.this));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
        catch (Exception paramViewGroup)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandDesktopView", paramViewGroup, "alvinluo init searchView exception", new Object[0]);
          paramViewGroup = new AppBrandDesktopView.h(AppBrandDesktopView.this, new View(AppBrandDesktopView.this.getContext()));
          AppMethodBeat.o(49589);
          return paramViewGroup;
        }
      }
      if (paramInt == 7)
      {
        paramViewGroup = aa.jQ(AppBrandDesktopView.this.getContext()).inflate(2131493146, paramViewGroup, false);
        localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
        localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.v(AppBrandDesktopView.this), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.v(AppBrandDesktopView.this), localLayoutParams.bottomMargin);
        paramViewGroup.setLayoutParams(localLayoutParams);
        AppBrandDesktopView.b(AppBrandDesktopView.this, paramViewGroup);
        paramViewGroup = new d(paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 8)
      {
        paramViewGroup = aa.jQ(AppBrandDesktopView.this.getContext()).inflate(2131493021, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.g(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      if (paramInt == 9)
      {
        paramViewGroup = aa.jQ(AppBrandDesktopView.this.getContext()).inflate(2131493023, paramViewGroup, false);
        paramViewGroup = new AppBrandDesktopView.d(AppBrandDesktopView.this, paramViewGroup);
        AppMethodBeat.o(49589);
        return paramViewGroup;
      }
      paramViewGroup = aa.jQ(AppBrandDesktopView.this.getContext()).inflate(2131495803, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.j(AppBrandDesktopView.this, paramViewGroup);
      AppMethodBeat.o(49589);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(49591);
      int j = paramv.auw;
      Object localObject1;
      if (j == 3)
      {
        paramInt = AppBrandDesktopView.l(AppBrandDesktopView.this);
        if (AppBrandDesktopView.C(AppBrandDesktopView.this) == 0) {
          AppBrandDesktopView.g(AppBrandDesktopView.this, AppBrandDesktopView.D(AppBrandDesktopView.this).getViewHeight());
        }
        i = AppBrandDesktopView.C(AppBrandDesktopView.this) - com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 56) - com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 48) - com.tencent.mm.ui.ao.getStatusBarHeight(AppBrandDesktopView.this.getContext());
        j = AppBrandDesktopView.k(AppBrandDesktopView.this);
        if (j > AppBrandDesktopView.o(AppBrandDesktopView.this) + i) {
          AppBrandDesktopView.h(AppBrandDesktopView.this, AppBrandDesktopView.E(AppBrandDesktopView.this));
        }
        for (;;)
        {
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(AppBrandDesktopView.n(AppBrandDesktopView.this)), Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)), Integer.valueOf(j), Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)), Integer.valueOf(paramInt), Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
          paramv.aus.setVisibility(4);
          localObject1 = (RecyclerView.LayoutParams)paramv.aus.getLayoutParams();
          ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.l(AppBrandDesktopView.this);
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.l(AppBrandDesktopView.this)) });
          paramv.aus.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
        localObject1 = paramv.aus;
        paramInt = AppBrandDesktopView.v(AppBrandDesktopView.this) + (int)(com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8) * b.ez(AppBrandDesktopView.this.getContext()));
        localObject2 = new RecyclerView.LayoutParams(-1, -2);
        ((RecyclerView.LayoutParams)localObject2).setMargins(((RecyclerView.LayoutParams)localObject2).leftMargin + paramInt, ((RecyclerView.LayoutParams)localObject2).topMargin, paramInt + ((RecyclerView.LayoutParams)localObject2).rightMargin, ((RecyclerView.LayoutParams)localObject2).bottomMargin);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (AppBrandDesktopView.n(AppBrandDesktopView.this) == 0)
        {
          localObject1 = paramv.aus;
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", new Object[] { Integer.valueOf(((View)localObject1).getMeasuredHeight()), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
          AppBrandDesktopView.d(AppBrandDesktopView.this, ((View)localObject1).getMeasuredHeight());
        }
        paramv = ((AppBrandDesktopView.j)paramv).titleTv;
        if (j == 10) {}
        for (paramInt = 2131764236;; paramInt = 2131763423)
        {
          paramv.setText(paramInt);
          AppMethodBeat.o(49591);
          return;
        }
      }
      if (j == 8)
      {
        paramv = (AppBrandDesktopView.g)paramv;
        boolean bool;
        if (!AppBrandDesktopView.r(AppBrandDesktopView.this))
        {
          bool = true;
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(AppBrandDesktopView.p(paramv.ooe)) });
          if (!bool) {
            break label704;
          }
        }
        label704:
        for (paramInt = i;; paramInt = 4)
        {
          if ((AppBrandDesktopView.H(paramv.ooe) != null) && (bool)) {
            AppBrandDesktopView.H(paramv.ooe).getLayoutParams().height = AppBrandDesktopView.p(paramv.ooe);
          }
          if (paramv.aus != null) {
            paramv.aus.setVisibility(paramInt);
          }
          AppMethodBeat.o(49591);
          return;
          bool = false;
          break;
        }
      }
      if (j == 6)
      {
        AppBrandDesktopView.c(AppBrandDesktopView.this, paramv.aus);
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
        localObject1 = (d)paramv;
        ((d)localObject1).aus.setPadding(AppBrandDesktopView.v(AppBrandDesktopView.this), com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.v(AppBrandDesktopView.this), com.tencent.mm.cb.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
        i = (int)b.ey(AppBrandDesktopView.this.getContext());
        ((d)localObject1).ooC.getLayoutParams().width = ((int)(com.tencent.mm.cb.a.aH(AppBrandDesktopView.this.getContext(), 2131165586) * 2 * b.ez(AppBrandDesktopView.this.getContext())) + i);
        ((d)localObject1).ooC.getLayoutParams().height = ((int)(com.tencent.mm.cb.a.aH(AppBrandDesktopView.this.getContext(), 2131165586) * 2 * b.ez(AppBrandDesktopView.this.getContext())) + i);
        ((d)localObject1).nnL.getLayoutParams().width = i;
        ((d)localObject1).nnL.getLayoutParams().height = i;
        ((d)localObject1).ooB.getLayoutParams().width = i;
        ((d)localObject1).ooB.getLayoutParams().height = i;
        paramv.aus.setVisibility(0);
        if (AppBrandDesktopView.p(AppBrandDesktopView.this) == 0)
        {
          localObject2 = paramv.aus;
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
          AppBrandDesktopView.e(AppBrandDesktopView.this, ((View)localObject2).getMeasuredHeight());
        }
        if (j == 7)
        {
          paramv.aus.setVisibility(4);
          if (((paramInt - AppBrandDesktopView.f(AppBrandDesktopView.this) + 1) % 4 == 1) && (paramInt > AppBrandDesktopView.f(AppBrandDesktopView.this)))
          {
            paramv.aus.getLayoutParams().height = 1;
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramv.aus.getLayoutParams().height);
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", new Object[] { Integer.valueOf(paramv.aus.getLayoutParams().height) });
            AppMethodBeat.o(49591);
            return;
          }
          if (AppBrandDesktopView.B(AppBrandDesktopView.this) == 0)
          {
            paramv = paramv.aus;
            paramv.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            Log.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder emptyItemHeight: %d", new Object[] { Integer.valueOf(paramv.getMeasuredHeight()) });
            AppBrandDesktopView.f(AppBrandDesktopView.this, paramv.getMeasuredHeight());
          }
          AppMethodBeat.o(49591);
          return;
        }
        localObject2 = zU(paramInt);
        if (localObject2 == null)
        {
          AppMethodBeat.o(49591);
          return;
        }
        ((AppBrandDesktopView.c)localObject2).position = paramInt;
        ((d)localObject1).ooG = ((AppBrandDesktopView.c)localObject2);
        if (((AppBrandDesktopView.c)localObject2).ooj == null) {
          break label1630;
        }
        if (Util.isNullOrNil(((AppBrandDesktopView.c)localObject2).ooj.cyB)) {
          break label1467;
        }
        ((d)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(((AppBrandDesktopView.c)localObject2).ooj.cyB));
        ((d)localObject1).titleTv.setVisibility(0);
        ((d)localObject1).ooB.setVisibility(0);
        if (Util.isNullOrNil(((AppBrandDesktopView.c)localObject2).ooj.kVZ)) {
          break label1603;
        }
        com.tencent.mm.modelappbrand.a.b.aXY().a(((d)localObject1).nnL, ((AppBrandDesktopView.c)localObject2).ooj.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
        label1350:
        if (Util.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.e.vO(((AppBrandDesktopView.c)localObject2).ooj.iOo))) {
          break label1617;
        }
        ((d)localObject1).ooD.setVisibility(0);
        ((d)localObject1).ooD.setText(com.tencent.mm.plugin.appbrand.appcache.e.vO(((AppBrandDesktopView.c)localObject2).ooj.iOo));
        label1395:
        ((d)localObject1).aus.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(49588);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$ItemAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            AppBrandDesktopView.x(AppBrandDesktopView.this);
            AppBrandDesktopView.y(AppBrandDesktopView.this);
            AppBrandDesktopView.z(AppBrandDesktopView.this);
            AppBrandDesktopView.this.setLayoutFrozen(true);
            AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, this.ool.ooj, this.oon.lR());
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
            if (((DragFeatureView)localObject1).ooL == paramInt)
            {
              paramv.aus.setVisibility(4);
              AppMethodBeat.o(49591);
              return;
              label1467:
              if (!Util.isNullOrNil(((AppBrandDesktopView.c)localObject2).ooj.nickname))
              {
                ((d)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(((AppBrandDesktopView.c)localObject2).ooj.nickname));
                ((d)localObject1).titleTv.setVisibility(0);
                break;
              }
              if (!Util.isNullOrNil(((AppBrandDesktopView.c)localObject2).ooj.username))
              {
                ((d)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.b.a.afX(((AppBrandDesktopView.c)localObject2).ooj.nickname));
                ((d)localObject1).titleTv.setVisibility(0);
                break;
              }
              Log.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { ((AppBrandDesktopView.c)localObject2).ooj.username, ((AppBrandDesktopView.c)localObject2).ooj.appId });
              ((d)localObject1).titleTv.setVisibility(4);
              break;
              label1603:
              ((d)localObject1).nnL.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
              break label1350;
              label1617:
              ((d)localObject1).ooD.setVisibility(8);
              break label1395;
              label1630:
              com.tencent.mm.modelappbrand.a.b.aXY().a(((d)localObject1).nnL, "", com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
              ((d)localObject1).titleTv.setVisibility(0);
              ((d)localObject1).ooD.setVisibility(8);
              ((d)localObject1).titleTv.setText("");
              continue;
            }
            paramv.aus.setVisibility(0);
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
      AppBrandDesktopView.c localc = zU(paramInt);
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
  
  static abstract interface f
  {
    public abstract void dQ(boolean paramBoolean);
  }
  
  public final class g
    extends RecyclerView.v
  {
    public g(View paramView)
    {
      super();
      AppMethodBeat.i(49594);
      AppBrandDesktopView.i(AppBrandDesktopView.this, AppBrandDesktopView.p(AppBrandDesktopView.this));
      if ((AppBrandDesktopView.G(AppBrandDesktopView.this) == 0) && (this.aus != null))
      {
        this.aus.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Log.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.aus.getMeasuredHeight()), Integer.valueOf(this.aus.getMeasuredWidth()) });
        AppBrandDesktopView.i(AppBrandDesktopView.this, this.aus.getMeasuredHeight());
      }
      this$1 = new RecyclerView.LayoutParams(-1, -2);
      AppBrandDesktopView.this.setMargins(AppBrandDesktopView.this.leftMargin + AppBrandDesktopView.v(AppBrandDesktopView.this), AppBrandDesktopView.this.topMargin - AppBrandDesktopView.G(AppBrandDesktopView.this), AppBrandDesktopView.this.rightMargin + AppBrandDesktopView.v(AppBrandDesktopView.this), AppBrandDesktopView.this.bottomMargin);
      Log.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.this.topMargin) });
      if (this.aus != null) {
        this.aus.setLayoutParams(AppBrandDesktopView.this);
      }
      AppMethodBeat.o(49594);
    }
  }
  
  public final class h
    extends RecyclerView.v
  {
    private View.OnClickListener ko;
    private long lastClickTime;
    protected EditText ooo;
    
    public h(View paramView)
    {
      super();
      AppMethodBeat.i(49596);
      this.lastClickTime = 0L;
      this.ko = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49595);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          AppBrandDesktopView.x(AppBrandDesktopView.this);
          AppBrandDesktopView.y(AppBrandDesktopView.this);
          AppBrandDesktopView.z(AppBrandDesktopView.this);
          Log.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
          long l = System.currentTimeMillis();
          if ((AppBrandDesktopView.b(AppBrandDesktopView.this) != null) && ((AppBrandDesktopView.h.a(AppBrandDesktopView.h.this) == 0L) || (l - AppBrandDesktopView.h.a(AppBrandDesktopView.h.this) > 1000L)))
          {
            AppBrandDesktopView.h.a(AppBrandDesktopView.h.this, l);
            paramAnonymousView = AppBrandDesktopView.b(AppBrandDesktopView.this);
            paramAnonymousView.oCG += 1;
            Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", new Object[] { Integer.valueOf(paramAnonymousView.oCG) });
          }
          paramAnonymousView = (com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.b(AppBrandDesktopView.i(AppBrandDesktopView.this), 42, AppBrandDesktopView.F(AppBrandDesktopView.this), "");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(49595);
        }
      };
      this.ooo = ((EditText)paramView.findViewById(2131296791));
      if (this.ooo != null)
      {
        this.ooo.setFocusable(false);
        this.ooo.setOnClickListener(this.ko);
      }
      paramView.setOnClickListener(this.ko);
      AppMethodBeat.o(49596);
    }
  }
  
  public static abstract interface i
  {
    public abstract void jd(boolean paramBoolean);
    
    public abstract void setCloseReason(int paramInt);
  }
  
  public final class j
    extends RecyclerView.v
  {
    protected TextView titleTv;
    
    public j(View paramView)
    {
      super();
      AppMethodBeat.i(49597);
      this.titleTv = ((TextView)paramView.findViewById(2131309017));
      AppMethodBeat.o(49597);
    }
  }
  
  final class k
    extends ae
  {
    k(Context paramContext)
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
  
  final class l
    extends GridLayoutManager
  {
    public l(int paramInt)
    {
      super(1);
    }
    
    public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
    {
      AppMethodBeat.i(49599);
      try
      {
        super.onLayoutChildren(paramn, params);
        AppMethodBeat.o(49599);
        return;
      }
      catch (IndexOutOfBoundsException paramn)
      {
        Log.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
        AppMethodBeat.o(49599);
      }
    }
    
    public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
    {
      AppMethodBeat.i(49600);
      paramRecyclerView = new AppBrandDesktopView.k(AppBrandDesktopView.this, AppBrandDesktopView.i(AppBrandDesktopView.this));
      paramRecyclerView.atO = paramInt;
      startSmoothScroll(paramRecyclerView);
      AppMethodBeat.o(49600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */