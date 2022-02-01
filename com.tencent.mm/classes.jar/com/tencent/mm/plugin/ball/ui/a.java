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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.plugin.ball.view.FloatMenuView.5;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;
import java.util.Set;

public final class a
{
  int bjY;
  private int cpv;
  com.tencent.mm.plugin.ball.c.c nLM;
  public FloatBallView nML;
  FloatMenuView nMM;
  private com.tencent.mm.plugin.ball.view.c nMN;
  public boolean nMO;
  final com.tencent.mm.plugin.ball.e.a nMP;
  boolean nMQ;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.bjY = 0;
    this.cpv = 1;
    this.nMQ = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.nLM = ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class));
    this.nMP = new com.tencent.mm.plugin.ball.e.a();
    this.bjY = com.tencent.mm.cb.a.iv(paramContext);
    this.nLM.xX(this.bjY);
    this.nML = new FloatBallView(paramContext);
    this.nLM.dw(this.nML);
    this.nMN = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.nML.setInnerView(this.nMN.nOR);
    Object localObject = this.nML;
    h local3 = new h()
    {
      public final void J(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        ae.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.nMM;
        if (localFloatMenuView.nKu) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.L(paramAnonymousMotionEvent);
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.L(paramAnonymousMotionEvent);
          if ((localFloatMenuView.nRM != null) && ((localFloatMenuView.nRM.getTag() instanceof BallInfo)))
          {
            FloatMenuView.dy(localFloatMenuView.nRM);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.nRM.getTag();
            if (paramAnonymousMotionEvent.nLu)
            {
              ae.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.bMU();
            }
          }
          for (;;)
          {
            localFloatMenuView.nKu = false;
            localFloatMenuView.nRM = null;
            localFloatMenuView.nRN = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.nLw.opType = 2;
            localFloatMenuView.J(paramAnonymousMotionEvent);
            continue;
            ae.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.bMU();
          }
          ae.i("MicroMsg.FloatMenuView", "onBallLongPressTouchEvent, CANCEL(%s, %s)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
        }
      }
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(184607);
        if (paramAnonymousBoolean1)
        {
          ae.i("MicroMsg.FloatBallContainer", "onBallSettled, x:%s, y:%s, height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          FloatMenuView localFloatMenuView = a.this.nMM;
          localFloatMenuView.nKt = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.nRy) || (paramAnonymousInt2 != localFloatMenuView.nRz) || (paramAnonymousInt3 != localFloatMenuView.nRL))
          {
            ae.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.nRL = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.5(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          e.bLU();
          if (paramAnonymousInt1 != e.nMA)
          {
            e.nMA = paramAnonymousInt1;
            ay.aRW(e.bLr()).encode("pos_x", e.nMA);
          }
          if (paramAnonymousInt2 != e.nMB)
          {
            e.nMB = paramAnonymousInt2;
            ay.aRW(e.bLr()).encode("pos_y", e.nMB);
          }
          if (paramAnonymousBoolean2 != e.nMC)
          {
            e.nMC = paramAnonymousBoolean2;
            ay.aRW(e.bLr()).encode("dock_left", e.nMC);
          }
        }
        AppMethodBeat.o(184607);
      }
      
      public final void bLe()
      {
        AppMethodBeat.i(184602);
        ae.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.nMP.nLI = bu.fpO();
        a.this.nML.b(false, null);
        a.this.nMM.setInLongPressMode(false);
        a.this.nMM.bMN();
        AppMethodBeat.o(184602);
      }
      
      public final void bLf()
      {
        AppMethodBeat.i(184603);
        ae.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.nMP.nLI = bu.fpO();
        a.this.nML.b(false, null);
        a.this.nMM.setInLongPressMode(true);
        a.this.nMM.bMN();
        AppMethodBeat.o(184603);
      }
      
      public final void bLg()
      {
        AppMethodBeat.i(184605);
        ae.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.nMO) });
        if (a.this.nMO) {
          a.this.bLc();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void bLh()
      {
        AppMethodBeat.i(184606);
        ae.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.nMO) });
        if ((a.this.nMO) && (a.this.nLM != null && (!a.this.nLM.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.bLd();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.bLd();
        }
        AppMethodBeat.o(184606);
      }
      
      public final void nO(int paramAnonymousInt)
      {
        AppMethodBeat.i(184608);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(184608);
      }
    };
    ((FloatBallView)localObject).cBA.add(local3);
    this.nMM = new FloatMenuView(paramContext);
    paramContext = this.nMM;
    localObject = new com.tencent.mm.plugin.ball.d.c()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        b localb = new b();
        localb.bd(paramAnonymousBallInfo);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.ahF());
        ae.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.nLw.opType = 9;
        a.this.nLM.m(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.nLu) && (a.this.nMQ))
        {
          a.this.nMP.ya(4);
          a.this.nMM.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void bLi()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        ae.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.nMP.ya(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void bLj()
      {
        AppMethodBeat.i(106260);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
        ae.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
        a.this.nMP.ya(5);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
        AppMethodBeat.o(106260);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106264);
        a.this.nLM.o(paramAnonymousBallInfo);
        AppMethodBeat.o(106264);
      }
      
      public final void nO(int paramAnonymousInt)
      {
        AppMethodBeat.i(106261);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(106261);
      }
      
      public final void w(final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106262);
        b localb = new b();
        localb.bd(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.ahF());
        ae.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.nMP.ya(3);
        a.this.nMM.d(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.nLM.n(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.nLM.n(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.nML.bMI();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
    };
    paramContext.nRE.add(localObject);
    this.nMM.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.d()
    {
      public final void bLk()
      {
        AppMethodBeat.i(184600);
        ae.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.nMM.getMeasuredHeight()) });
        if (a.this.nMM.getMeasuredHeight() != a.this.bjY)
        {
          a.this.bjY = a.this.nMM.getMeasuredHeight();
          a.this.nLM.xX(a.this.bjY);
        }
        AppMethodBeat.o(184600);
      }
    });
    AppMethodBeat.o(106273);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184611);
    List localList = com.tencent.mm.plugin.ball.f.d.bU(paramList);
    Object localObject;
    boolean bool2;
    boolean bool1;
    if (com.tencent.mm.plugin.ball.f.d.h(paramList))
    {
      localObject = Integer.valueOf(paramList.size());
      ae.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      if (!com.tencent.mm.plugin.ball.f.d.h(localList)) {
        break label358;
      }
      localObject = com.tencent.mm.plugin.ball.f.d.bW(localList);
      ae.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, voipBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        ae.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VOIP");
        this.nMM.bMQ();
      }
      bool2 = AppForegroundDelegate.cTA.cBB;
      if ((!bMd()) && (!this.nLM.bKU())) {
        break label323;
      }
      bool1 = true;
      label148:
      if ((!bool2) || (bool1)) {
        break label328;
      }
      ae.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.nML.nNn) });
      if (!this.nML.nNn) {
        this.nML.bMI();
      }
      label198:
      if ((localObject != null) && (!bMd()) && (!this.nLM.bLb()))
      {
        ae.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VOIP, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.nML.bMI();
      }
    }
    for (;;)
    {
      if (this.nML != null) {
        this.nML.a(paramList, paramBallInfo);
      }
      if (this.nMN != null) {
        this.nMN.a(paramList, paramBallInfo);
      }
      if (this.nMM != null) {
        this.nMM.a(paramList, paramBallInfo);
      }
      this.nMP.nLJ = paramList;
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label323:
      bool1 = false;
      break label148;
      label328:
      ae.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      break label198;
      label358:
      if (this.nMM.getVisibility() == 0)
      {
        ae.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.nMM.d(null);
        this.nML.b(false, null);
      }
      else if (this.nML.getVisibility() == 0)
      {
        ae.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.nML.b(false, null);
      }
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(209490);
    if (this.nML != null)
    {
      ae.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nML.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.nMM != null) && (!this.nMM.nRO))
    {
      ae.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nMM.d(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(209490);
  }
  
  public final void bLc()
  {
    AppMethodBeat.i(184613);
    if ((this.nML != null) && (this.nML.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.nML.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ae.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.nML.setLayoutParams(localLayoutParams);
        ae.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void bLd()
  {
    AppMethodBeat.i(184614);
    if ((this.nML != null) && (this.nML.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.nML.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ae.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.nML.setLayoutParams(localLayoutParams);
        ae.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void bMb()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.cTA.cBB;
    boolean bool2 = this.nLM.bKV();
    boolean bool3 = this.nLM.bKU();
    ae.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.nML.bMI();
      AppMethodBeat.o(106274);
      return;
    }
    ae.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void bMc()
  {
    AppMethodBeat.i(176968);
    if (this.nML != null)
    {
      FloatBallView localFloatBallView = this.nML;
      if (localFloatBallView.nQg != null) {
        localFloatBallView.nQg.removeAllViews();
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final boolean bMd()
  {
    AppMethodBeat.i(106275);
    if ((this.nMM != null) && (this.nMM.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  public final void bMe()
  {
    AppMethodBeat.i(184612);
    this.nMM.setVisibility(8);
    WindowManager.LayoutParams localLayoutParams;
    if (this.windowManager != null)
    {
      localLayoutParams = new WindowManager.LayoutParams();
      if (com.tencent.mm.compatible.util.d.lA(26))
      {
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = ak.getContext().getPackageName();
        localLayoutParams.flags = 65824;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bMq();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bMr();
      }
    }
    for (;;)
    {
      try
      {
        this.windowManager.addView(this.nMM, localLayoutParams);
        ae.i("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow success");
        this.nML.setVisibility(8);
        if (this.windowManager == null) {
          break label312;
        }
        localLayoutParams = new WindowManager.LayoutParams();
        if (!com.tencent.mm.compatible.util.d.lA(26)) {
          break label281;
        }
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = ak.getContext().getPackageName();
        localLayoutParams.flags = 196904;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -2;
        localLayoutParams.height = -2;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bMq();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bMr();
        try
        {
          this.windowManager.addView(this.nML, localLayoutParams);
          ae.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
          AppMethodBeat.o(184612);
          return;
        }
        catch (Exception localException2)
        {
          ae.printErrStackTrace("MicroMsg.FloatBallContainer", localException2, "attachFloatBallViewToWindow fail", new Object[0]);
          AppMethodBeat.o(184612);
          return;
        }
        localLayoutParams.type = 2002;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.FloatBallContainer", localException1, "attachFloatMenuViewToWindow fail", new Object[0]);
        continue;
      }
      ae.e("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow, window manager is null");
      continue;
      label281:
      localException1.type = 2002;
    }
    label312:
    ae.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
    AppMethodBeat.o(184612);
  }
  
  public final boolean bMf()
  {
    AppMethodBeat.i(209493);
    if ((this.nMM != null) && (this.nMM.getVisibility() == 0))
    {
      AppMethodBeat.o(209493);
      return true;
    }
    AppMethodBeat.o(209493);
    return false;
  }
  
  final void bMg()
  {
    AppMethodBeat.i(209494);
    try
    {
      if (this.windowManager != null)
      {
        this.windowManager.removeView(this.nML);
        this.windowManager.removeView(this.nMM);
        if (this.nLM != null) {
          this.nLM.bLa();
        }
        ae.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(209494);
        return;
      }
      ae.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(209494);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(209494);
    }
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(209492);
    if (this.nMM != null)
    {
      if (paramBoolean)
      {
        this.nMM.d(paramAnimatorListenerAdapter);
        AppMethodBeat.o(209492);
        return;
      }
      this.nMM.bMQ();
    }
    AppMethodBeat.o(209492);
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.nML != null)
    {
      i = this.nML.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bMr();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(209491);
    if (this.nML != null) {
      this.nML.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(209491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */