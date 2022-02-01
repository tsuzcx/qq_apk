package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.plugin.ball.view.FloatMenuView.4;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import java.util.Set;

public final class a
{
  int aYR;
  private int iHo;
  com.tencent.mm.plugin.ball.c.c mDJ;
  public FloatBallView mEI;
  FloatMenuView mEJ;
  private com.tencent.mm.plugin.ball.view.c mEK;
  public boolean mEL;
  final com.tencent.mm.plugin.ball.e.a mEM;
  boolean mEN;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.aYR = 0;
    this.iHo = 1;
    this.mEN = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.mDJ = ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class));
    this.mEM = new com.tencent.mm.plugin.ball.e.a();
    this.aYR = com.tencent.mm.cd.a.hW(paramContext);
    this.mDJ.wv(this.aYR);
    this.mEI = new FloatBallView(paramContext);
    this.mDJ.ds(this.mEI);
    this.mEK = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.mEI.setInnerView(this.mEK.mGN);
    Object localObject = this.mEI;
    com.tencent.mm.plugin.ball.d.b local3 = new com.tencent.mm.plugin.ball.d.b()
    {
      public final void P(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        ad.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.mEJ;
        if (localFloatMenuView.mCB) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.R(paramAnonymousMotionEvent);
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.R(paramAnonymousMotionEvent);
          if ((localFloatMenuView.mJx != null) && ((localFloatMenuView.mJx.getTag() instanceof BallInfo)))
          {
            FloatMenuView.du(localFloatMenuView.mJx);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.mJx.getTag();
            if (paramAnonymousMotionEvent.mDu)
            {
              ad.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.bAP();
            }
          }
          for (;;)
          {
            localFloatMenuView.mCB = false;
            localFloatMenuView.mJx = null;
            localFloatMenuView.mJy = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.mDw.opType = 2;
            localFloatMenuView.G(paramAnonymousMotionEvent);
            continue;
            ad.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.bAP();
          }
          ad.i("MicroMsg.FloatMenuView", "onBallLongPressTouchEvent, CANCEL(%s, %s)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
        }
      }
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(184607);
        if (paramAnonymousBoolean1)
        {
          ad.i("MicroMsg.FloatBallContainer", "onBallSettled, x:%s, y:%s, height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          FloatMenuView localFloatMenuView = a.this.mEJ;
          localFloatMenuView.mCA = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.mJj) || (paramAnonymousInt2 != localFloatMenuView.mJk) || (paramAnonymousInt3 != localFloatMenuView.mJw))
          {
            ad.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.mJw = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.4(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          com.tencent.mm.plugin.ball.service.e.bzR();
          if (paramAnonymousInt1 != com.tencent.mm.plugin.ball.service.e.mEx)
          {
            com.tencent.mm.plugin.ball.service.e.mEx = paramAnonymousInt1;
            ax.aFC(com.tencent.mm.plugin.ball.service.e.bzn()).encode("pos_x", com.tencent.mm.plugin.ball.service.e.mEx);
          }
          if (paramAnonymousInt2 != com.tencent.mm.plugin.ball.service.e.mEy)
          {
            com.tencent.mm.plugin.ball.service.e.mEy = paramAnonymousInt2;
            ax.aFC(com.tencent.mm.plugin.ball.service.e.bzn()).encode("pos_y", com.tencent.mm.plugin.ball.service.e.mEy);
          }
        }
        AppMethodBeat.o(184607);
      }
      
      public final void bza()
      {
        AppMethodBeat.i(184602);
        ad.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.mEM.mDF = bt.eGO();
        a.this.mEI.b(false, null);
        a.this.mEJ.setInLongPressMode(false);
        a.this.mEJ.bAI();
        AppMethodBeat.o(184602);
      }
      
      public final void bzb()
      {
        AppMethodBeat.i(184603);
        ad.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.mEM.mDF = bt.eGO();
        a.this.mEI.b(false, null);
        a.this.mEJ.setInLongPressMode(true);
        a.this.mEJ.bAI();
        AppMethodBeat.o(184603);
      }
      
      public final void bzc()
      {
        AppMethodBeat.i(184605);
        ad.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.mEL) });
        if (a.this.mEL) {
          a.this.byY();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void bzd()
      {
        AppMethodBeat.i(184606);
        ad.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.mEL) });
        if ((a.this.mEL) && (a.this.mDJ != null && (!a.this.mDJ.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.byZ();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.byZ();
        }
        AppMethodBeat.o(184606);
      }
      
      public final void wy(int paramAnonymousInt)
      {
        AppMethodBeat.i(184608);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(184608);
      }
    };
    ((FloatBallView)localObject).csT.add(local3);
    this.mEJ = new FloatMenuView(paramContext);
    paramContext = this.mEJ;
    localObject = new com.tencent.mm.plugin.ball.d.d()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousBallInfo);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.ado());
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.mDw.opType = 9;
        a.this.mDJ.k(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.mDu) && (a.this.mEN))
        {
          a.this.mEJ.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void bze()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.mEM.wz(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void bzf()
      {
        AppMethodBeat.i(106260);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
        AppMethodBeat.o(106260);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106264);
        a.this.mDJ.m(paramAnonymousBallInfo);
        AppMethodBeat.o(106264);
      }
      
      public final void t(final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.ado());
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.mEM.wz(3);
        a.this.mEJ.d(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.mDJ.l(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.mDJ.l(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.mEI.bAF();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
      
      public final void wy(int paramAnonymousInt)
      {
        AppMethodBeat.i(106261);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(106261);
      }
    };
    paramContext.mJp.add(localObject);
    this.mEJ.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.e()
    {
      public final void bzg()
      {
        AppMethodBeat.i(184600);
        ad.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.mEJ.getMeasuredHeight()) });
        if (a.this.mEJ.getMeasuredHeight() != a.this.aYR)
        {
          a.this.aYR = a.this.mEJ.getMeasuredHeight();
          a.this.mDJ.wv(a.this.aYR);
        }
        AppMethodBeat.o(184600);
      }
    });
    AppMethodBeat.o(106273);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184611);
    List localList = com.tencent.mm.plugin.ball.f.d.bR(paramList);
    Object localObject;
    boolean bool2;
    boolean bool1;
    if (com.tencent.mm.plugin.ball.f.d.h(paramList))
    {
      localObject = Integer.valueOf(paramList.size());
      ad.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      if (!com.tencent.mm.plugin.ball.f.d.h(localList)) {
        break label430;
      }
      localObject = com.tencent.mm.plugin.ball.f.d.bT(localList);
      ad.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, voipBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VOIP");
        this.mEJ.bAL();
      }
      bool2 = AppForegroundDelegate.cKE.csU;
      if ((!bAa()) && (!this.mDJ.byQ())) {
        break label325;
      }
      bool1 = true;
      label149:
      if ((!bool2) || (bool1)) {
        break label331;
      }
      ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.mEI.mFj) });
      if (!this.mEI.mFj) {
        this.mEI.bAF();
      }
      label200:
      if ((localObject != null) && (!bAa()) && (!this.mDJ.byX()))
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VOIP, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.mEI.bAF();
      }
    }
    for (;;)
    {
      if (this.mEI != null) {
        this.mEI.a(paramList, paramBallInfo);
      }
      if (this.mEK != null) {
        this.mEK.a(paramList, paramBallInfo);
      }
      if (this.mEJ != null) {
        this.mEJ.a(paramList, paramBallInfo);
      }
      this.mEM.mDG = paramList;
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label325:
      bool1 = false;
      break label149;
      label331:
      ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) || (this.mEI.getVisibility() != 0) || (this.mDJ.byR())) {
        break label200;
      }
      ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide when wechat not in foreground & not in QB file view page");
      if (FloatBallView.wR(this.mEI.mHc)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label428;
        }
        this.mEI.b(false, null);
        break;
      }
      label428:
      break label200;
      label430:
      if (this.mEJ.getVisibility() == 0)
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.mEJ.d(null);
        this.mEI.b(false, null);
      }
      else if (this.mEI.getVisibility() == 0)
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.mEI.b(false, null);
      }
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(190651);
    if (this.mEI != null)
    {
      ad.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mEI.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.mEJ != null) && (!this.mEJ.mJz))
    {
      ad.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mEJ.d(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(190651);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(106275);
    if ((this.mEJ != null) && (this.mEJ.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  public final void bAb()
  {
    AppMethodBeat.i(184612);
    this.mEJ.setVisibility(8);
    WindowManager.LayoutParams localLayoutParams;
    if (this.windowManager != null)
    {
      localLayoutParams = new WindowManager.LayoutParams();
      if (com.tencent.mm.compatible.util.d.lf(26))
      {
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = aj.getContext().getPackageName();
        localLayoutParams.flags = 65824;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bAn();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bAo();
      }
    }
    for (;;)
    {
      try
      {
        this.windowManager.addView(this.mEJ, localLayoutParams);
        ad.i("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow success");
        this.mEI.setVisibility(8);
        if (this.windowManager == null) {
          break label312;
        }
        localLayoutParams = new WindowManager.LayoutParams();
        if (!com.tencent.mm.compatible.util.d.lf(26)) {
          break label281;
        }
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = aj.getContext().getPackageName();
        localLayoutParams.flags = 196904;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -2;
        localLayoutParams.height = -2;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bAn();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bAo();
        try
        {
          this.windowManager.addView(this.mEI, localLayoutParams);
          ad.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
          AppMethodBeat.o(184612);
          return;
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("MicroMsg.FloatBallContainer", localException2, "attachFloatBallViewToWindow fail", new Object[0]);
          AppMethodBeat.o(184612);
          return;
        }
        localLayoutParams.type = 2002;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.FloatBallContainer", localException1, "attachFloatMenuViewToWindow fail", new Object[0]);
        continue;
      }
      ad.e("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow, window manager is null");
      continue;
      label281:
      localException1.type = 2002;
    }
    label312:
    ad.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
    AppMethodBeat.o(184612);
  }
  
  public final boolean bAc()
  {
    AppMethodBeat.i(190654);
    if ((this.mEJ != null) && (this.mEJ.getVisibility() == 0))
    {
      AppMethodBeat.o(190654);
      return true;
    }
    AppMethodBeat.o(190654);
    return false;
  }
  
  final void bAd()
  {
    AppMethodBeat.i(190655);
    try
    {
      if (this.windowManager != null)
      {
        this.windowManager.removeView(this.mEI);
        this.windowManager.removeView(this.mEJ);
        if (this.mDJ != null) {
          this.mDJ.byW();
        }
        ad.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(190655);
        return;
      }
      ad.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(190655);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(190655);
    }
  }
  
  public final void byY()
  {
    AppMethodBeat.i(184613);
    if ((this.mEI != null) && (this.mEI.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.mEI.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ad.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.mEI.setLayoutParams(localLayoutParams);
        ad.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void byZ()
  {
    AppMethodBeat.i(184614);
    if ((this.mEI != null) && (this.mEI.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.mEI.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ad.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.mEI.setLayoutParams(localLayoutParams);
        ad.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void bzY()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.cKE.csU;
    boolean bool2 = this.mDJ.byR();
    boolean bool3 = this.mDJ.byQ();
    ad.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.mEI.bAF();
      AppMethodBeat.o(106274);
      return;
    }
    ad.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void bzZ()
  {
    AppMethodBeat.i(176968);
    if (this.mEI != null)
    {
      FloatBallView localFloatBallView = this.mEI;
      if (localFloatBallView.mHZ != null) {
        localFloatBallView.mHZ.removeAllViews();
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(190653);
    if (this.mEJ != null)
    {
      if (paramBoolean)
      {
        this.mEJ.d(paramAnimatorListenerAdapter);
        AppMethodBeat.o(190653);
        return;
      }
      this.mEJ.bAL();
    }
    AppMethodBeat.o(190653);
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.mEI != null)
    {
      i = this.mEI.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bAo();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(190652);
    if (this.mEI != null) {
      this.mEI.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(190652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */