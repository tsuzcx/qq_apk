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
import com.tencent.mm.plugin.ball.view.FloatMenuView.5;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;
import java.util.Set;

public final class a
{
  int aZD;
  private int gud;
  com.tencent.mm.plugin.ball.c.c nfP;
  public FloatBallView ngN;
  FloatMenuView ngO;
  private com.tencent.mm.plugin.ball.view.c ngP;
  public boolean ngQ;
  final com.tencent.mm.plugin.ball.e.a ngR;
  boolean ngS;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.aZD = 0;
    this.gud = 1;
    this.ngS = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.nfP = ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class));
    this.ngR = new com.tencent.mm.plugin.ball.e.a();
    this.aZD = com.tencent.mm.cc.a.ih(paramContext);
    this.nfP.xn(this.aZD);
    this.ngN = new FloatBallView(paramContext);
    this.nfP.du(this.ngN);
    this.ngP = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.ngN.setInnerView(this.ngP.niS);
    Object localObject = this.ngN;
    com.tencent.mm.plugin.ball.d.b local3 = new com.tencent.mm.plugin.ball.d.b()
    {
      public final void N(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        ac.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.ngO;
        if (localFloatMenuView.neD) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.P(paramAnonymousMotionEvent);
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.P(paramAnonymousMotionEvent);
          if ((localFloatMenuView.nlA != null) && ((localFloatMenuView.nlA.getTag() instanceof BallInfo)))
          {
            FloatMenuView.dw(localFloatMenuView.nlA);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.nlA.getTag();
            if (paramAnonymousMotionEvent.nfB)
            {
              ac.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.bHL();
            }
          }
          for (;;)
          {
            localFloatMenuView.neD = false;
            localFloatMenuView.nlA = null;
            localFloatMenuView.nlB = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.nfD.opType = 2;
            localFloatMenuView.G(paramAnonymousMotionEvent);
            continue;
            ac.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.bHL();
          }
          ac.i("MicroMsg.FloatMenuView", "onBallLongPressTouchEvent, CANCEL(%s, %s)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
        }
      }
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(184607);
        if (paramAnonymousBoolean1)
        {
          ac.i("MicroMsg.FloatBallContainer", "onBallSettled, x:%s, y:%s, height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          FloatMenuView localFloatMenuView = a.this.ngO;
          localFloatMenuView.neC = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.nlm) || (paramAnonymousInt2 != localFloatMenuView.nln) || (paramAnonymousInt3 != localFloatMenuView.nlz))
          {
            ac.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.nlz = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.5(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          com.tencent.mm.plugin.ball.service.e.bGN();
          if (paramAnonymousInt1 != com.tencent.mm.plugin.ball.service.e.ngC)
          {
            com.tencent.mm.plugin.ball.service.e.ngC = paramAnonymousInt1;
            aw.aKT(com.tencent.mm.plugin.ball.service.e.bGj()).encode("pos_x", com.tencent.mm.plugin.ball.service.e.ngC);
          }
          if (paramAnonymousInt2 != com.tencent.mm.plugin.ball.service.e.ngD)
          {
            com.tencent.mm.plugin.ball.service.e.ngD = paramAnonymousInt2;
            aw.aKT(com.tencent.mm.plugin.ball.service.e.bGj()).encode("pos_y", com.tencent.mm.plugin.ball.service.e.ngD);
          }
        }
        AppMethodBeat.o(184607);
      }
      
      public final void bFW()
      {
        AppMethodBeat.i(184602);
        ac.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.ngR.nfL = bs.eWj();
        a.this.ngN.b(false, null);
        a.this.ngO.setInLongPressMode(false);
        a.this.ngO.bHE();
        AppMethodBeat.o(184602);
      }
      
      public final void bFX()
      {
        AppMethodBeat.i(184603);
        ac.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.ngR.nfL = bs.eWj();
        a.this.ngN.b(false, null);
        a.this.ngO.setInLongPressMode(true);
        a.this.ngO.bHE();
        AppMethodBeat.o(184603);
      }
      
      public final void bFY()
      {
        AppMethodBeat.i(184605);
        ac.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.ngQ) });
        if (a.this.ngQ) {
          a.this.bFU();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void bFZ()
      {
        AppMethodBeat.i(184606);
        ac.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.ngQ) });
        if ((a.this.ngQ) && (a.this.nfP != null && (!a.this.nfP.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.bFV();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.bFV();
        }
        AppMethodBeat.o(184606);
      }
      
      public final void nm(int paramAnonymousInt)
      {
        AppMethodBeat.i(184608);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(184608);
      }
    };
    ((FloatBallView)localObject).cqb.add(local3);
    this.ngO = new FloatMenuView(paramContext);
    paramContext = this.ngO;
    localObject = new com.tencent.mm.plugin.ball.d.d()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousBallInfo);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.aeE());
        ac.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.nfD.opType = 9;
        a.this.nfP.l(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.nfB) && (a.this.ngS))
        {
          a.this.ngO.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void bGa()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        ac.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.ngR.xq(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void bGb()
      {
        AppMethodBeat.i(106260);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
        ac.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
        AppMethodBeat.o(106260);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106264);
        a.this.nfP.n(paramAnonymousBallInfo);
        AppMethodBeat.o(106264);
      }
      
      public final void nm(int paramAnonymousInt)
      {
        AppMethodBeat.i(106261);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(106261);
      }
      
      public final void t(final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.aeE());
        ac.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.ngR.xq(3);
        a.this.ngO.d(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.nfP.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.nfP.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.ngN.bHB();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
    };
    paramContext.nls.add(localObject);
    this.ngO.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.e()
    {
      public final void bGc()
      {
        AppMethodBeat.i(184600);
        ac.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.ngO.getMeasuredHeight()) });
        if (a.this.ngO.getMeasuredHeight() != a.this.aZD)
        {
          a.this.aZD = a.this.ngO.getMeasuredHeight();
          a.this.nfP.xn(a.this.aZD);
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
      ac.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      if (!com.tencent.mm.plugin.ball.f.d.h(localList)) {
        break label430;
      }
      localObject = com.tencent.mm.plugin.ball.f.d.bT(localList);
      ac.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, voipBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VOIP");
        this.ngO.bHH();
      }
      bool2 = AppForegroundDelegate.cHM.cqc;
      if ((!bGW()) && (!this.nfP.bFM())) {
        break label325;
      }
      bool1 = true;
      label149:
      if ((!bool2) || (bool1)) {
        break label331;
      }
      ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.ngN.nho) });
      if (!this.ngN.nho) {
        this.ngN.bHB();
      }
      label200:
      if ((localObject != null) && (!bGW()) && (!this.nfP.bFT()))
      {
        ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VOIP, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.ngN.bHB();
      }
    }
    for (;;)
    {
      if (this.ngN != null) {
        this.ngN.a(paramList, paramBallInfo);
      }
      if (this.ngP != null) {
        this.ngP.a(paramList, paramBallInfo);
      }
      if (this.ngO != null) {
        this.ngO.a(paramList, paramBallInfo);
      }
      this.ngR.nfM = paramList;
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label325:
      bool1 = false;
      break label149;
      label331:
      ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) || (this.ngN.getVisibility() != 0) || (this.nfP.bFN())) {
        break label200;
      }
      ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide when wechat not in foreground & not in QB file view page");
      if (FloatBallView.xJ(this.ngN.njh)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label428;
        }
        this.ngN.b(false, null);
        break;
      }
      label428:
      break label200;
      label430:
      if (this.ngO.getVisibility() == 0)
      {
        ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.ngO.d(null);
        this.ngN.b(false, null);
      }
      else if (this.ngN.getVisibility() == 0)
      {
        ac.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.ngN.b(false, null);
      }
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(208016);
    if (this.ngN != null)
    {
      ac.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.ngN.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.ngO != null) && (!this.ngO.nlC))
    {
      ac.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.ngO.d(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(208016);
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(184613);
    if ((this.ngN != null) && (this.ngN.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.ngN.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ac.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.ngN.setLayoutParams(localLayoutParams);
        ac.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void bFV()
  {
    AppMethodBeat.i(184614);
    if ((this.ngN != null) && (this.ngN.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.ngN.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ac.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.ngN.setLayoutParams(localLayoutParams);
        ac.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void bGU()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.cHM.cqc;
    boolean bool2 = this.nfP.bFN();
    boolean bool3 = this.nfP.bFM();
    ac.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.ngN.bHB();
      AppMethodBeat.o(106274);
      return;
    }
    ac.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void bGV()
  {
    AppMethodBeat.i(176968);
    if (this.ngN != null)
    {
      FloatBallView localFloatBallView = this.ngN;
      if (localFloatBallView.nke != null) {
        localFloatBallView.nke.removeAllViews();
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final boolean bGW()
  {
    AppMethodBeat.i(106275);
    if ((this.ngO != null) && (this.ngO.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  public final void bGX()
  {
    AppMethodBeat.i(184612);
    this.ngO.setVisibility(8);
    WindowManager.LayoutParams localLayoutParams;
    if (this.windowManager != null)
    {
      localLayoutParams = new WindowManager.LayoutParams();
      if (com.tencent.mm.compatible.util.d.kZ(26))
      {
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = ai.getContext().getPackageName();
        localLayoutParams.flags = 65824;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bHj();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bHk();
      }
    }
    for (;;)
    {
      try
      {
        this.windowManager.addView(this.ngO, localLayoutParams);
        ac.i("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow success");
        this.ngN.setVisibility(8);
        if (this.windowManager == null) {
          break label312;
        }
        localLayoutParams = new WindowManager.LayoutParams();
        if (!com.tencent.mm.compatible.util.d.kZ(26)) {
          break label281;
        }
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = ai.getContext().getPackageName();
        localLayoutParams.flags = 196904;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -2;
        localLayoutParams.height = -2;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bHj();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bHk();
        try
        {
          this.windowManager.addView(this.ngN, localLayoutParams);
          ac.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
          AppMethodBeat.o(184612);
          return;
        }
        catch (Exception localException2)
        {
          ac.printErrStackTrace("MicroMsg.FloatBallContainer", localException2, "attachFloatBallViewToWindow fail", new Object[0]);
          AppMethodBeat.o(184612);
          return;
        }
        localLayoutParams.type = 2002;
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.FloatBallContainer", localException1, "attachFloatMenuViewToWindow fail", new Object[0]);
        continue;
      }
      ac.e("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow, window manager is null");
      continue;
      label281:
      localException1.type = 2002;
    }
    label312:
    ac.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
    AppMethodBeat.o(184612);
  }
  
  public final boolean bGY()
  {
    AppMethodBeat.i(208019);
    if ((this.ngO != null) && (this.ngO.getVisibility() == 0))
    {
      AppMethodBeat.o(208019);
      return true;
    }
    AppMethodBeat.o(208019);
    return false;
  }
  
  final void bGZ()
  {
    AppMethodBeat.i(208020);
    try
    {
      if (this.windowManager != null)
      {
        this.windowManager.removeView(this.ngN);
        this.windowManager.removeView(this.ngO);
        if (this.nfP != null) {
          this.nfP.bFS();
        }
        ac.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(208020);
        return;
      }
      ac.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(208020);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(208020);
    }
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(208018);
    if (this.ngO != null)
    {
      if (paramBoolean)
      {
        this.ngO.d(paramAnimatorListenerAdapter);
        AppMethodBeat.o(208018);
        return;
      }
      this.ngO.bHH();
    }
    AppMethodBeat.o(208018);
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.ngN != null)
    {
      i = this.ngN.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bHk();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(208017);
    if (this.ngN != null) {
      this.ngN.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(208017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */