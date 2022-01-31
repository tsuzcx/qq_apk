package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b.2;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopView
  extends DragRecyclerView
  implements c.a
{
  private RecyclerView.a Tg;
  public int afG;
  private int ajQ;
  private RecyclerView.r ajo;
  private int asY;
  private int asZ;
  boolean czT;
  private int ef;
  private RecyclerView.m egc;
  int iAy;
  private ArrayList<AppBrandDesktopView.c> iVH;
  boolean isPaused;
  HeaderContainer jbP;
  private AppBrandDesktopDragView.b jdN;
  private boolean jeA;
  int jeB;
  private int jeC;
  private int jeD;
  private int jeE;
  private int jeF;
  private boolean jeG;
  private View jeH;
  private int jeI;
  private View jeJ;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b jeK;
  boolean jeL;
  private boolean jeM;
  boolean jeN;
  boolean jeO;
  boolean jeP;
  boolean jeQ;
  int jeR;
  AppBrandDesktopView.b jeS;
  AppBrandDesktopView.b jeT;
  boolean jeU;
  boolean jeV;
  int jeW;
  private int jeX;
  private float jeY;
  private float jeZ;
  private ArrayList<AppBrandDesktopView.c> jek;
  int jel;
  boolean jem;
  boolean jen;
  private AppBrandDesktopView.j jeo;
  private boolean jep;
  private RelativeLayout jeq;
  RecentAppBrandViewContainer jer;
  private RecentAppBrandView jes;
  private AppBrandDesktopDragView jet;
  int jeu;
  private int jev;
  private boolean jew;
  private boolean jex;
  Runnable jey;
  Runnable jez;
  private boolean jfa;
  private boolean jfb;
  int jfc;
  private int jfd;
  private boolean jfe;
  private boolean jff;
  Context mContext;
  private Interpolator mInterpolator;
  private int mTouchSlop;
  private Animator.AnimatorListener nx;
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133861);
    this.afG = 4;
    this.iVH = new ArrayList();
    this.jek = new ArrayList();
    this.jel = 0;
    this.jem = false;
    this.jen = false;
    this.jeo = null;
    this.jep = false;
    this.ajQ = 0;
    this.asY = 0;
    this.asZ = 0;
    this.jeu = 0;
    this.jev = 0;
    this.jew = false;
    this.jex = false;
    this.jey = null;
    this.jez = null;
    this.jeA = false;
    this.jeD = 0;
    this.jeE = 0;
    this.jeF = 0;
    this.jeG = false;
    this.jeI = a.fromDPToPix(ah.getContext(), 80);
    this.iAy = 0;
    this.jeK = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.jeL = false;
    this.jeM = false;
    this.isPaused = false;
    this.jeN = false;
    this.jeO = false;
    this.jeP = false;
    this.jeQ = false;
    this.jeR = 0;
    this.jeS = new AppBrandDesktopView.b(this, 1);
    this.jeT = new AppBrandDesktopView.b(this, 2);
    this.jeU = false;
    this.jeV = false;
    this.jeW = 0;
    this.czT = false;
    this.jdN = new AppBrandDesktopDragView.b()
    {
      public final void bx(Object paramAnonymousObject)
      {
        AppMethodBeat.i(133821);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(133821);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if (localc.jfk != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this);
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.b(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (!bo.isNullOrNil(localc.jfk.appId))) {
              AppBrandDesktopView.c(AppBrandDesktopView.this).Ga(localc.jfk.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(133821);
      }
      
      public final void by(Object paramAnonymousObject)
      {
        AppMethodBeat.i(133822);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(133822);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if ((localc.type == 1) && (localc.jfk != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this);
            af localaf = (af)com.tencent.mm.kernel.g.E(af.class);
            if (localaf == null)
            {
              AppMethodBeat.o(133822);
              return;
            }
            if (localaf.aE(localc.jfk.username, localc.jfk.hcr)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (!bo.isNullOrNil(localc.jfk.appId))) {
              AppBrandDesktopView.c(AppBrandDesktopView.this).FZ(localc.jfk.appId);
            }
          }
        }
        AppMethodBeat.o(133822);
      }
      
      public final void bz(Object paramAnonymousObject)
      {
        AppMethodBeat.i(133823);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(133823);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        ag localag;
        if (paramAnonymousObject.jfk != null)
        {
          ab.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.jfk.username, Integer.valueOf(paramAnonymousObject.jfk.hcr) });
          AppBrandDesktopView.a(AppBrandDesktopView.this);
          localag = (ag)com.tencent.mm.kernel.g.E(ag.class);
          if (localag == null) {
            break label257;
          }
        }
        label257:
        for (boolean bool = localag.aF(paramAnonymousObject.jfk.username, paramAnonymousObject.jfk.hcr);; bool = false)
        {
          if ((AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (paramAnonymousObject.jfk != null) && (!bo.isNullOrNil(paramAnonymousObject.jfk.appId))) {
            AppBrandDesktopView.c(AppBrandDesktopView.this).FY(paramAnonymousObject.jfk.appId);
          }
          if (AppBrandDesktopView.d(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(133823);
              return;
            }
            ab.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.e(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.d(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.e(AppBrandDesktopView.this));
            if (AppBrandDesktopView.f(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.f(AppBrandDesktopView.this).getAdapter().bR(paramAnonymousObject.position);
            }
          }
          AppMethodBeat.o(133823);
          return;
        }
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(133824);
        AppBrandDesktopView.a(AppBrandDesktopView.this);
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.b(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).jfk != null) && (!bo.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).jfk.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label193;
          }
          localb = AppBrandDesktopView.c(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).jfk.appId;
          ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.juL += 1;
          localb.juR.append(paramAnonymousObject + ":");
        }
        for (;;)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.g(AppBrandDesktopView.this));
          AppMethodBeat.o(133824);
          return;
          label193:
          if (paramAnonymousInt1 > paramAnonymousInt2)
          {
            localb = AppBrandDesktopView.c(AppBrandDesktopView.this);
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).jfk.appId;
            ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.juK += 1;
            localb.juQ.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(ah.getContext()).getScaledTouchSlop();
    this.jeX = 0;
    this.jeY = 0.0F;
    this.jeZ = 0.0F;
    this.jfa = false;
    this.jfb = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.nx = new AppBrandDesktopView.7(this);
    this.jfc = 0;
    this.jfd = -1;
    this.jfe = false;
    this.jff = false;
    this.egc = new AppBrandDesktopView.5(this);
    init(paramContext);
    AppMethodBeat.o(133861);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133862);
    this.afG = 4;
    this.iVH = new ArrayList();
    this.jek = new ArrayList();
    this.jel = 0;
    this.jem = false;
    this.jen = false;
    this.jeo = null;
    this.jep = false;
    this.ajQ = 0;
    this.asY = 0;
    this.asZ = 0;
    this.jeu = 0;
    this.jev = 0;
    this.jew = false;
    this.jex = false;
    this.jey = null;
    this.jez = null;
    this.jeA = false;
    this.jeD = 0;
    this.jeE = 0;
    this.jeF = 0;
    this.jeG = false;
    this.jeI = a.fromDPToPix(ah.getContext(), 80);
    this.iAy = 0;
    this.jeK = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    this.jeL = false;
    this.jeM = false;
    this.isPaused = false;
    this.jeN = false;
    this.jeO = false;
    this.jeP = false;
    this.jeQ = false;
    this.jeR = 0;
    this.jeS = new AppBrandDesktopView.b(this, 1);
    this.jeT = new AppBrandDesktopView.b(this, 2);
    this.jeU = false;
    this.jeV = false;
    this.jeW = 0;
    this.czT = false;
    this.jdN = new AppBrandDesktopDragView.b()
    {
      public final void bx(Object paramAnonymousObject)
      {
        AppMethodBeat.i(133821);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(133821);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if (localc.jfk != null)
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this);
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", new Object[] { Boolean.valueOf(AppBrandDesktopView.b(AppBrandDesktopView.this)) });
            if ((AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (!bo.isNullOrNil(localc.jfk.appId))) {
              AppBrandDesktopView.c(AppBrandDesktopView.this).Ga(localc.jfk.appId);
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
          }
        }
        AppMethodBeat.o(133821);
      }
      
      public final void by(Object paramAnonymousObject)
      {
        AppMethodBeat.i(133822);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(133822);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          AppBrandDesktopView.c localc = (AppBrandDesktopView.c)paramAnonymousObject;
          if ((localc.type == 1) && (localc.jfk != null))
          {
            AppBrandDesktopView.a(AppBrandDesktopView.this);
            af localaf = (af)com.tencent.mm.kernel.g.E(af.class);
            if (localaf == null)
            {
              AppMethodBeat.o(133822);
              return;
            }
            if (localaf.aE(localc.jfk.username, localc.jfk.hcr)) {
              AppBrandDesktopView.a(AppBrandDesktopView.this, ((AppBrandDesktopView.c)paramAnonymousObject).position);
            }
            if ((AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (!bo.isNullOrNil(localc.jfk.appId))) {
              AppBrandDesktopView.c(AppBrandDesktopView.this).FZ(localc.jfk.appId);
            }
          }
        }
        AppMethodBeat.o(133822);
      }
      
      public final void bz(Object paramAnonymousObject)
      {
        AppMethodBeat.i(133823);
        if (paramAnonymousObject == null)
        {
          AppMethodBeat.o(133823);
          return;
        }
        paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
        ag localag;
        if (paramAnonymousObject.jfk != null)
        {
          ab.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.jfk.username, Integer.valueOf(paramAnonymousObject.jfk.hcr) });
          AppBrandDesktopView.a(AppBrandDesktopView.this);
          localag = (ag)com.tencent.mm.kernel.g.E(ag.class);
          if (localag == null) {
            break label257;
          }
        }
        label257:
        for (boolean bool = localag.aF(paramAnonymousObject.jfk.username, paramAnonymousObject.jfk.hcr);; bool = false)
        {
          if ((AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (paramAnonymousObject.jfk != null) && (!bo.isNullOrNil(paramAnonymousObject.jfk.appId))) {
            AppBrandDesktopView.c(AppBrandDesktopView.this).FY(paramAnonymousObject.jfk.appId);
          }
          if (AppBrandDesktopView.d(AppBrandDesktopView.this) != null)
          {
            if (bool)
            {
              AppBrandDesktopView.b(AppBrandDesktopView.this, paramAnonymousObject.position);
              AppMethodBeat.o(133823);
              return;
            }
            ab.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
            paramAnonymousObject.type = 2;
            AppBrandDesktopView.e(AppBrandDesktopView.this).add(paramAnonymousObject.position, paramAnonymousObject);
            AppBrandDesktopView.d(AppBrandDesktopView.this).setDataList(AppBrandDesktopView.e(AppBrandDesktopView.this));
            if (AppBrandDesktopView.f(AppBrandDesktopView.this) != null) {
              AppBrandDesktopView.f(AppBrandDesktopView.this).getAdapter().bR(paramAnonymousObject.position);
            }
          }
          AppMethodBeat.o(133823);
          return;
        }
      }
      
      public final void g(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(133824);
        AppBrandDesktopView.a(AppBrandDesktopView.this);
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", new Object[] { Boolean.valueOf(AppBrandDesktopView.b(AppBrandDesktopView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopView.c(AppBrandDesktopView.this) != null) && (((AppBrandDesktopView.c)paramAnonymousObject).jfk != null) && (!bo.isNullOrNil(((AppBrandDesktopView.c)paramAnonymousObject).jfk.appId)))
        {
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label193;
          }
          localb = AppBrandDesktopView.c(AppBrandDesktopView.this);
          paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).jfk.appId;
          ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", new Object[] { paramAnonymousObject });
          localb.juL += 1;
          localb.juR.append(paramAnonymousObject + ":");
        }
        for (;;)
        {
          AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.g(AppBrandDesktopView.this));
          AppMethodBeat.o(133824);
          return;
          label193:
          if (paramAnonymousInt1 > paramAnonymousInt2)
          {
            localb = AppBrandDesktopView.c(AppBrandDesktopView.this);
            paramAnonymousObject = ((AppBrandDesktopView.c)paramAnonymousObject).jfk.appId;
            ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", new Object[] { paramAnonymousObject });
            localb.juK += 1;
            localb.juQ.append(paramAnonymousObject + ":");
          }
        }
      }
    };
    this.mTouchSlop = ViewConfiguration.get(ah.getContext()).getScaledTouchSlop();
    this.jeX = 0;
    this.jeY = 0.0F;
    this.jeZ = 0.0F;
    this.jfa = false;
    this.jfb = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.nx = new AppBrandDesktopView.7(this);
    this.jfc = 0;
    this.jfd = -1;
    this.jfe = false;
    this.jff = false;
    this.egc = new AppBrandDesktopView.5(this);
    init(paramContext);
    AppMethodBeat.o(133862);
  }
  
  private void aPr()
  {
    AppMethodBeat.i(133858);
    this.iVH.clear();
    this.iVH.add(new AppBrandDesktopView.c(6));
    this.iVH.add(new AppBrandDesktopView.c(9));
    this.iVH.add(new AppBrandDesktopView.c(3));
    this.jem = false;
    this.jen = false;
    this.jeG = false;
    this.Tg.ajb.notifyChanged();
    fh(true);
    AppMethodBeat.o(133858);
  }
  
  private void aPs()
  {
    int i = 0;
    AppMethodBeat.i(133859);
    ab.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.jeF), Integer.valueOf(this.iVH.size() - 4), Integer.valueOf(1) });
    while (i <= 0)
    {
      this.iVH.add(new AppBrandDesktopView.c(7));
      i += 1;
    }
    this.jeF = 1;
    AppMethodBeat.o(133859);
  }
  
  private void aPt()
  {
    AppMethodBeat.i(133865);
    this.jev = getItemPadding();
    AppMethodBeat.o(133865);
  }
  
  private void aPv()
  {
    AppMethodBeat.i(133870);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131690605));
    AppMethodBeat.o(133870);
  }
  
  private void aPw()
  {
    AppMethodBeat.i(133871);
    long l = System.currentTimeMillis();
    this.iVH.clear();
    this.jek.clear();
    this.jeF = 0;
    this.jeG = false;
    this.iVH.add(new AppBrandDesktopView.c(6));
    if (com.tencent.mm.kernel.g.E(ag.class) != null) {}
    for (Object localObject = ((ag)com.tencent.mm.kernel.g.E(ag.class)).nu(50);; localObject = null)
    {
      if (com.tencent.mm.kernel.g.E(af.class) != null) {}
      for (List localList = ((af)com.tencent.mm.kernel.g.E(af.class)).a(2147483647, af.a.hcJ);; localList = null)
      {
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          this.jem = false;
          this.jel = 2;
          if (this.jet != null) {
            this.jet.setCollectionStartPosition(this.jel);
          }
          if ((localList != null) && (localList.size() != 0)) {
            break label248;
          }
        }
        label248:
        for (this.jen = false;; this.jen = true)
        {
          if ((this.jem) || (this.jen)) {
            break label256;
          }
          ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
          this.iVH.add(new AppBrandDesktopView.c(9));
          this.iVH.add(new AppBrandDesktopView.c(3));
          AppMethodBeat.o(133871);
          return;
          this.jem = true;
          this.jel = 4;
          break;
        }
        label256:
        new AppBrandDesktopView.c(0);
        int i;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          AppBrandDesktopView.c localc = new AppBrandDesktopView.c(10);
          this.iVH.add(localc);
          this.iVH.add(new AppBrandDesktopView.c(2));
          i = 0;
          while (i < ((List)localObject).size())
          {
            localc = new AppBrandDesktopView.c(2);
            localc.jfk = ((LocalUsageInfo)((List)localObject).get(i));
            this.jek.add(localc);
            i += 1;
          }
        }
        this.iVH.add(new AppBrandDesktopView.c(11));
        if (localList != null)
        {
          ab.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(localList.size()) });
          i = 0;
          while (i < localList.size())
          {
            localObject = new AppBrandDesktopView.c(1);
            ((AppBrandDesktopView.c)localObject).jfk = ((LocalUsageInfo)localList.get(i));
            this.iVH.add(localObject);
            i += 1;
          }
        }
        aPs();
        if (!this.jen)
        {
          this.iVH.add(new AppBrandDesktopView.c(8));
          this.jeG = true;
        }
        this.iVH.add(new AppBrandDesktopView.c(3));
        if (this.jet != null)
        {
          this.jet.setCopyList(this.jek);
          this.jet.setList(this.iVH);
        }
        ab.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused) });
        if (this.aih) {
          this.jeA = true;
        }
        this.Tg.ajb.notifyChanged();
        if (this.jer != null)
        {
          ab.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
          this.jer.setDataList(this.jek);
          this.jer.notifyDataSetChanged();
        }
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", new Object[] { Integer.valueOf(this.iVH.size()), Integer.valueOf(this.jek.size()), Integer.valueOf(this.iVH.size() - this.jel) });
        AppMethodBeat.o(133871);
        return;
      }
    }
  }
  
  private void aPz()
  {
    AppMethodBeat.i(156586);
    if (this.jbP != null)
    {
      View localView = this.jbP.getBackgroundGLSurfaceView();
      if ((localView != null) && (this.jeq != null))
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo removeDynamicBackgroundView");
        this.jeq.removeView(localView);
      }
    }
    AppMethodBeat.o(156586);
  }
  
  private void fh(boolean paramBoolean)
  {
    AppMethodBeat.i(133879);
    RecyclerView.r localr;
    if (this.ajo != null)
    {
      localr = this.ajo;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 1)
    {
      localr.ajQ = i;
      this.jeo.a(this.ajo);
      AppMethodBeat.o(133879);
      return;
    }
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(133869);
    int i = d.jdMethod_do(getContext());
    AppMethodBeat.o(133869);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(133867);
    this.mContext = paramContext;
    this.jeE = 0;
    this.jeD = this.jeE;
    b.init(this.mContext);
    this.afG = b.getCompletelyCountPerPage();
    aPt();
    aPv();
    this.jeo = new AppBrandDesktopView.j(this, this.afG);
    this.jeo.afL = new GridLayoutManager.b()
    {
      public final int bF(int paramAnonymousInt)
      {
        AppMethodBeat.i(154869);
        paramAnonymousInt = AppBrandDesktopView.this.getAdapter().getItemViewType(paramAnonymousInt);
        if ((paramAnonymousInt == 3) || (paramAnonymousInt == 11) || (paramAnonymousInt == 10) || (paramAnonymousInt == 2) || (paramAnonymousInt == 6) || (paramAnonymousInt == 8) || (paramAnonymousInt == 9))
        {
          paramAnonymousInt = AppBrandDesktopView.this.afG;
          AppMethodBeat.o(154869);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(154869);
        return 1;
      }
    };
    setLayoutManager(this.jeo);
    setOverScrollMode(2);
    a(this.egc);
    this.Tg = new AppBrandDesktopView.e(this, (byte)0);
    setAdapter(this.Tg);
    aPw();
    aPu();
    al.p(new AppBrandDesktopView.10(this), 200L);
    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.jeI) });
    this.jeW = a.fromDPToPix(paramContext, 200);
    this.jfc = a.fromDPToPix(paramContext, 24);
    this.jeX = a.fromDPToPix(paramContext, 100);
    this.ajo = new AppBrandDesktopView.11(this, getContext());
    AppMethodBeat.o(133867);
  }
  
  private boolean qa(int paramInt)
  {
    AppMethodBeat.i(133857);
    ab.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.iVH.size())
    {
      localObject = (AppBrandDesktopView.c)this.iVH.get(i);
      if ((((AppBrandDesktopView.c)localObject).type == 1) && (((AppBrandDesktopView.c)localObject).jfk != null)) {
        localArrayList.add(((AppBrandDesktopView.c)localObject).jfk);
      }
      i += 1;
    }
    Object localObject = (af)com.tencent.mm.kernel.g.E(af.class);
    if (localObject == null)
    {
      AppMethodBeat.o(133857);
      return false;
    }
    boolean bool = ((af)localObject).g(localArrayList, paramInt);
    if (!bool) {
      ab.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
    }
    AppMethodBeat.o(133857);
    return bool;
  }
  
  private void setIgnoreNotify(boolean paramBoolean)
  {
    if (this.jeT != null) {
      this.jeT.jeM = paramBoolean;
    }
    if (this.jeS != null) {
      this.jeS.jeM = paramBoolean;
    }
  }
  
  final void aD(float paramFloat)
  {
    AppMethodBeat.i(156588);
    RecyclerView.v localv;
    if (this.jem)
    {
      localv = bQ(1);
      if ((localv != null) && (localv.aku != null)) {
        localv.aku.setAlpha(paramFloat);
      }
    }
    if (this.jem) {}
    for (int i = 3;; i = 1)
    {
      localv = bQ(i);
      if ((localv != null) && (localv.aku != null)) {
        localv.aku.setAlpha(paramFloat);
      }
      ab.v("MicroMsg.AppBrandDesktopView", "alvinluo updateTitleAlpha hasRecentData: %b, hasMyData: %b, alpha: %f", new Object[] { Boolean.valueOf(this.jem), Boolean.valueOf(this.jen), Float.valueOf(paramFloat) });
      AppMethodBeat.o(156588);
      return;
    }
  }
  
  final void aPA()
  {
    AppMethodBeat.i(156587);
    Object localObject;
    if (!this.jeN)
    {
      if ((this.jbP != null) && (b.aPg()))
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.jbP.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131690605));
        }
        localObject = this.jbP.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(1.0F);
        }
        localObject = this.jbP.getBackgroundGLSurfaceView();
        if ((localObject instanceof DynamicBackgroundGLSurfaceView))
        {
          ((View)localObject).setVisibility(8);
          this.jeV = true;
        }
        AppMethodBeat.o(156587);
      }
    }
    else
    {
      this.jeV = false;
      if ((this.jbP != null) && (b.aPg()))
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToGradientBackgroundView");
        localObject = this.jbP.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131690605));
        }
        localObject = this.jbP.getBackgroundGradientView();
        if (localObject != null)
        {
          ((View)localObject).setAlpha(1.0F);
          ((View)localObject).setVisibility(0);
        }
        aPz();
        postDelayed(new AppBrandDesktopView.2(this), 200L);
      }
    }
    AppMethodBeat.o(156587);
  }
  
  final void aPu()
  {
    AppMethodBeat.i(133868);
    if (this.jeU)
    {
      AppMethodBeat.o(133868);
      return;
    }
    ag localag = (ag)com.tencent.mm.kernel.g.E(ag.class);
    af localaf = (af)com.tencent.mm.kernel.g.E(af.class);
    if ((localag == null) || (localaf == null))
    {
      AppMethodBeat.o(133868);
      return;
    }
    this.jeU = true;
    localag.remove(this.jeT);
    localag.add(this.jeT);
    localaf.remove(this.jeS);
    localaf.add(this.jeS);
    AppMethodBeat.o(133868);
  }
  
  public final void aPx()
  {
    AppMethodBeat.i(133875);
    ab.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
    if (!this.jeL)
    {
      h.EF(h.aKY());
      if ((this.jeK != null) && (this.jes != null))
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", new Object[] { Integer.valueOf(this.jes.getShowCount()), Integer.valueOf(getCollectionDataSize()) });
        this.jeK.dB(this.jes.getShowCount(), getCollectionDataSize());
        com.tencent.mm.sdk.g.d.ysm.execute(new AppBrandDesktopView.12(this));
      }
      this.jeL = true;
      this.jeO = true;
      this.jeP = true;
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(133875);
  }
  
  public final void aPy()
  {
    AppMethodBeat.i(133878);
    aPx();
    AppMethodBeat.o(133878);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143661);
    boolean bool;
    if (this.jfJ)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143661);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143661);
      return bool;
    case 0: 
      this.jeY = paramMotionEvent.getRawY();
      this.jex = true;
    }
    for (;;)
    {
      this.jeZ = 0.0F;
      this.jfa = false;
      this.jfb = false;
      break;
      ab.v("MicroMsg.AppBrandDesktopView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.jfa), Float.valueOf(this.jeZ), Integer.valueOf(this.mTouchSlop) });
      if ((this.jeo != null) && (this.iVH != null))
      {
        i = this.jeo.iw();
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo isAtBottom last: %d, data list size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.iVH.size()) });
        if (i == this.iVH.size() - 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && (!this.jfa))
        {
          if (!this.jfb)
          {
            this.jeY = paramMotionEvent.getRawY();
            this.jeZ = 0.0F;
            this.jfb = true;
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          this.jeZ = ((paramMotionEvent.getRawY() - this.jeY) * 0.55F);
          if (this.jeZ >= -this.mTouchSlop) {
            break;
          }
          this.jfa = true;
          break;
        }
      }
      if (!this.jfa) {
        break;
      }
      this.jeZ = ((paramMotionEvent.getRawY() - this.jeY) * 0.55F);
      if (this.jeZ > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143661);
        return bool;
      }
      int i = (int)Math.abs(this.jeZ);
      ab.v("MicroMsg.AppBrandDesktopView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(143661);
      return true;
      if (this.jfa)
      {
        this.jex = false;
        if ((Math.abs(this.jeZ) >= this.jeX) && (this.jbP != null))
        {
          ab.i("MicroMsg.AppBrandDesktopView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.jbP.j(0L, 15);
        }
        animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.nx).start();
      }
    }
  }
  
  int getCollectionDataSize()
  {
    AppMethodBeat.i(133874);
    if (!this.jen)
    {
      AppMethodBeat.o(133874);
      return 0;
    }
    int i = this.iVH.size();
    int j = this.jel;
    int k = this.jeF;
    AppMethodBeat.o(133874);
    return i - j - k - 1;
  }
  
  public int getLeftRightMargin()
  {
    AppMethodBeat.i(133866);
    int j = d.dp(getContext()) - this.jev;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ab.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jev) });
    AppMethodBeat.o(133866);
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
    AppMethodBeat.i(133864);
    super.onAttachedToWindow();
    View localView = getRootView();
    if (localView == null)
    {
      AppMethodBeat.o(133864);
      return;
    }
    this.jet = ((AppBrandDesktopDragView)localView.findViewById(2131820594));
    if (this.jet == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow mDragFeatureView == null: %b", new Object[] { Boolean.valueOf(bool) });
      this.jet.setRecyclerView(this);
      this.jet.setCopyList(this.jek);
      this.jet.setList(this.iVH);
      this.jet.setHeaderContainer(this.jbP);
      this.jet.setCollectionCallback(this.jdN);
      this.jet.setItemPadding(this.jev);
      this.jet.setAppBrandCounter(new AppBrandDesktopView.a(this, (byte)0));
      this.jet.setViewWidth(this.asY);
      this.jet.setRecyclerViewScrollComputer(new g()
      {
        public final int computeVerticalScrollOffset()
        {
          AppMethodBeat.i(154868);
          if (AppBrandDesktopView.this.getChildCount() == 0)
          {
            AppMethodBeat.o(154868);
            return 0;
          }
          for (;;)
          {
            int j;
            try
            {
              int k = AppBrandDesktopView.k(AppBrandDesktopView.this).it();
              int i = -(int)AppBrandDesktopView.k(AppBrandDesktopView.this).bH(k).getY();
              ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", new Object[] { Integer.valueOf(i) });
              j = 0;
              if (j < k)
              {
                AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.n(AppBrandDesktopView.this).get(j);
                if (localc != null)
                {
                  int m = localc.type;
                  ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
                  if ((m == 10) || (m == 11))
                  {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.o(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.o(AppBrandDesktopView.this) + i;
                  }
                  else if (m == 6)
                  {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.p(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.p(AppBrandDesktopView.this) + i;
                  }
                  else if (m == 2)
                  {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.q(AppBrandDesktopView.this)) });
                    i = AppBrandDesktopView.q(AppBrandDesktopView.this) + i;
                  }
                  else if ((m == 1) && ((j - AppBrandDesktopView.g(AppBrandDesktopView.this)) % 4 == 0))
                  {
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", new Object[] { Integer.valueOf(AppBrandDesktopView.q(AppBrandDesktopView.this)) });
                    m = AppBrandDesktopView.q(AppBrandDesktopView.this);
                    i = m + i;
                  }
                }
              }
              else
              {
                AppMethodBeat.o(154868);
                return i;
              }
            }
            catch (Exception localException)
            {
              ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo compute exception", new Object[0]);
              AppMethodBeat.o(154868);
              return 0;
            }
            j += 1;
          }
        }
        
        public final int computeVerticalScrollRange()
        {
          AppMethodBeat.i(154867);
          int i = AppBrandDesktopView.l(AppBrandDesktopView.this);
          int j = AppBrandDesktopView.m(AppBrandDesktopView.this);
          AppMethodBeat.o(154867);
          return i + j;
        }
      });
      this.jfQ = this.jet;
      if ((this.jet != null) && ((this.jet.getParent() instanceof RelativeLayout)))
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
        this.jeq = ((RelativeLayout)this.jet.getParent());
      }
      AppMethodBeat.o(133864);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133872);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    this.asY = paramInt1;
    this.asZ = paramInt2;
    paramInt1 = d.c(this.asY, getContext());
    if (paramInt1 != this.jev)
    {
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", new Object[] { Integer.valueOf(this.jev), Integer.valueOf(paramInt1) });
      b.init(getContext());
      this.jev = paramInt1;
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", new Object[] { Integer.valueOf(this.jev) });
      if (this.jer != null)
      {
        this.jer.setItemPadding(this.jev);
        if (this.jes != null) {
          this.jes.aPD();
        }
      }
      if (this.Tg != null) {
        this.Tg.ajb.notifyChanged();
      }
      if (this.jbP != null) {
        this.jbP.aPm();
      }
      if (this.jet != null) {
        this.jet.setItemPadding(paramInt1);
      }
    }
    if (this.jet != null) {
      this.jet.setViewWidth(this.asY);
    }
    if ((!this.jfJ) && (this.jbP != null) && (this.jeu != this.jbP.getViewHeight()))
    {
      this.jeu = this.jbP.getViewHeight();
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.jeu), Integer.valueOf(this.jbP.getMeasuredHeight()) });
    }
    AppMethodBeat.o(133872);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(133863);
    super.onVisibilityChanged(paramView, paramInt);
    ab.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.jeQ) && (this.jbP != null))
      {
        this.jbP.k(100L, this.jeR);
        this.jeR = 0;
        this.jeQ = false;
      }
      if (this.jeA)
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
        this.jeA = false;
        if (this.jez != null) {
          removeCallbacks(this.jez);
        }
        paramView = new AppBrandDesktopView.6(this);
        this.jez = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(133863);
  }
  
  public final void qb(int paramInt)
  {
    AppMethodBeat.i(133876);
    ab.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader]");
    if (this.jeL)
    {
      if ((this.jeK != null) && (this.jes != null))
      {
        com.tencent.mm.plugin.appbrand.widget.recentview.b localb = this.jeK;
        boolean bool = b.aPg();
        localb.juV = bool;
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", new Object[] { Boolean.valueOf(bool) });
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", new Object[] { Integer.valueOf(this.jes.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(paramInt) });
        localb = this.jeK;
        int i = this.jes.getShowCount();
        int j = getCollectionDataSize();
        localb.jux = i;
        localb.juG = j;
        localb.juu = paramInt;
        com.tencent.mm.sdk.g.d.ysm.execute(new b.2(localb));
      }
      this.jeL = false;
      this.jeO = false;
      this.jeP = false;
      if (paramInt != 9) {
        break label237;
      }
      if (this.jeS != null) {
        this.jeS.jeM = false;
      }
    }
    for (;;)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133838);
          AppBrandDesktopView.r(AppBrandDesktopView.this);
          AppMethodBeat.o(133838);
        }
      }, 300L);
      qa(1);
      AppMethodBeat.o(133876);
      return;
      label237:
      if (this.jeS != null) {
        this.jeS.jeM = true;
      }
    }
  }
  
  public final void qc(int paramInt)
  {
    AppMethodBeat.i(133877);
    qb(paramInt);
    AppMethodBeat.o(133877);
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.jbP = paramHeaderContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */