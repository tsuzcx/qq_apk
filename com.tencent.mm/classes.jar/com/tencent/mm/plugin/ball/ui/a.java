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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import java.util.Set;

public final class a
{
  int bjY;
  private int gNO;
  com.tencent.mm.plugin.ball.c.c nGl;
  public FloatBallView nHj;
  FloatMenuView nHk;
  private com.tencent.mm.plugin.ball.view.c nHl;
  public boolean nHm;
  final com.tencent.mm.plugin.ball.e.a nHn;
  boolean nHo;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.bjY = 0;
    this.gNO = 1;
    this.nHo = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.nGl = ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class));
    this.nHn = new com.tencent.mm.plugin.ball.e.a();
    this.bjY = com.tencent.mm.cc.a.iq(paramContext);
    this.nGl.xT(this.bjY);
    this.nHj = new FloatBallView(paramContext);
    this.nGl.dw(this.nHj);
    this.nHl = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.nHj.setInnerView(this.nHl.nJo);
    Object localObject = this.nHj;
    com.tencent.mm.plugin.ball.d.b local3 = new com.tencent.mm.plugin.ball.d.b()
    {
      public final void L(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        ad.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.nHk;
        if (localFloatMenuView.nEZ) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.N(paramAnonymousMotionEvent);
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.N(paramAnonymousMotionEvent);
          if ((localFloatMenuView.nMh != null) && ((localFloatMenuView.nMh.getTag() instanceof BallInfo)))
          {
            FloatMenuView.dy(localFloatMenuView.nMh);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.nMh.getTag();
            if (paramAnonymousMotionEvent.nFX)
            {
              ad.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.bLW();
            }
          }
          for (;;)
          {
            localFloatMenuView.nEZ = false;
            localFloatMenuView.nMh = null;
            localFloatMenuView.nMi = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.nFZ.opType = 2;
            localFloatMenuView.H(paramAnonymousMotionEvent);
            continue;
            ad.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.bLW();
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
          FloatMenuView localFloatMenuView = a.this.nHk;
          localFloatMenuView.nEY = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.nLT) || (paramAnonymousInt2 != localFloatMenuView.nLU) || (paramAnonymousInt3 != localFloatMenuView.nMg))
          {
            ad.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.nMg = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.5(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          com.tencent.mm.plugin.ball.service.e.bKX();
          if (paramAnonymousInt1 != com.tencent.mm.plugin.ball.service.e.nGY)
          {
            com.tencent.mm.plugin.ball.service.e.nGY = paramAnonymousInt1;
            ax.aQz(com.tencent.mm.plugin.ball.service.e.bKu()).encode("pos_x", com.tencent.mm.plugin.ball.service.e.nGY);
          }
          if (paramAnonymousInt2 != com.tencent.mm.plugin.ball.service.e.nGZ)
          {
            com.tencent.mm.plugin.ball.service.e.nGZ = paramAnonymousInt2;
            ax.aQz(com.tencent.mm.plugin.ball.service.e.bKu()).encode("pos_y", com.tencent.mm.plugin.ball.service.e.nGZ);
          }
        }
        AppMethodBeat.o(184607);
      }
      
      public final void bKh()
      {
        AppMethodBeat.i(184602);
        ad.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.nHn.nGh = bt.flT();
        a.this.nHj.b(false, null);
        a.this.nHk.setInLongPressMode(false);
        a.this.nHk.bLP();
        AppMethodBeat.o(184602);
      }
      
      public final void bKi()
      {
        AppMethodBeat.i(184603);
        ad.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.nHn.nGh = bt.flT();
        a.this.nHj.b(false, null);
        a.this.nHk.setInLongPressMode(true);
        a.this.nHk.bLP();
        AppMethodBeat.o(184603);
      }
      
      public final void bKj()
      {
        AppMethodBeat.i(184605);
        ad.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.nHm) });
        if (a.this.nHm) {
          a.this.bKe();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void bKk()
      {
        AppMethodBeat.i(184606);
        ad.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.nHm) });
        if ((a.this.nHm) && (a.this.nGl != null && (!a.this.nGl.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.bKf();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.bKf();
        }
        AppMethodBeat.o(184606);
      }
      
      public final void nL(int paramAnonymousInt)
      {
        AppMethodBeat.i(184608);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(184608);
      }
    };
    ((FloatBallView)localObject).cAT.add(local3);
    this.nHk = new FloatMenuView(paramContext);
    paramContext = this.nHk;
    localObject = new com.tencent.mm.plugin.ball.d.d()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousBallInfo);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.ahq());
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.nFZ.opType = 9;
        a.this.nGl.m(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.nFX) && (a.this.nHo))
        {
          a.this.nHk.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void bKl()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.nHn.xW(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void bKm()
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
        a.this.nGl.o(paramAnonymousBallInfo);
        AppMethodBeat.o(106264);
      }
      
      public final void nL(int paramAnonymousInt)
      {
        AppMethodBeat.i(106261);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(106261);
      }
      
      public final void u(final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.ahq());
        ad.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.nHn.xW(3);
        a.this.nHk.d(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.nGl.n(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.nGl.n(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.nHj.bLL();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
    };
    paramContext.nLZ.add(localObject);
    this.nHk.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.e()
    {
      public final void bKn()
      {
        AppMethodBeat.i(184600);
        ad.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.nHk.getMeasuredHeight()) });
        if (a.this.nHk.getMeasuredHeight() != a.this.bjY)
        {
          a.this.bjY = a.this.nHk.getMeasuredHeight();
          a.this.nGl.xT(a.this.bjY);
        }
        AppMethodBeat.o(184600);
      }
    });
    AppMethodBeat.o(106273);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184611);
    List localList = com.tencent.mm.plugin.ball.f.d.bS(paramList);
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
      localObject = com.tencent.mm.plugin.ball.f.d.bU(localList);
      ad.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, voipBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VOIP");
        this.nHk.bLS();
      }
      bool2 = AppForegroundDelegate.cSQ.cAU;
      if ((!bLg()) && (!this.nGl.bJW())) {
        break label325;
      }
      bool1 = true;
      label149:
      if ((!bool2) || (bool1)) {
        break label331;
      }
      ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.nHj.nHK) });
      if (!this.nHj.nHK) {
        this.nHj.bLL();
      }
      label200:
      if ((localObject != null) && (!bLg()) && (!this.nGl.bKd()))
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VOIP, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.nHj.bLL();
      }
    }
    for (;;)
    {
      if (this.nHj != null) {
        this.nHj.a(paramList, paramBallInfo);
      }
      if (this.nHl != null) {
        this.nHl.a(paramList, paramBallInfo);
      }
      if (this.nHk != null) {
        this.nHk.a(paramList, paramBallInfo);
      }
      this.nHn.nGi = paramList;
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label325:
      bool1 = false;
      break label149;
      label331:
      ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) || (this.nHj.getVisibility() != 0) || (this.nGl.bJX())) {
        break label200;
      }
      ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide when wechat not in foreground & not in QB file view page");
      if (FloatBallView.ys(this.nHj.nJD)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label428;
        }
        this.nHj.b(false, null);
        break;
      }
      label428:
      break label200;
      label430:
      if (this.nHk.getVisibility() == 0)
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.nHk.d(null);
        this.nHj.b(false, null);
      }
      else if (this.nHj.getVisibility() == 0)
      {
        ad.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.nHj.b(false, null);
      }
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217300);
    if (this.nHj != null)
    {
      ad.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nHj.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.nHk != null) && (!this.nHk.nMj))
    {
      ad.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nHk.d(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(217300);
  }
  
  public final void bKe()
  {
    AppMethodBeat.i(184613);
    if ((this.nHj != null) && (this.nHj.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.nHj.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ad.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.nHj.setLayoutParams(localLayoutParams);
        ad.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void bKf()
  {
    AppMethodBeat.i(184614);
    if ((this.nHj != null) && (this.nHj.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.nHj.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        ad.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.nHj.setLayoutParams(localLayoutParams);
        ad.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void bLe()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.cSQ.cAU;
    boolean bool2 = this.nGl.bJX();
    boolean bool3 = this.nGl.bJW();
    ad.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.nHj.bLL();
      AppMethodBeat.o(106274);
      return;
    }
    ad.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void bLf()
  {
    AppMethodBeat.i(176968);
    if (this.nHj != null)
    {
      FloatBallView localFloatBallView = this.nHj;
      if (localFloatBallView.nKB != null) {
        localFloatBallView.nKB.removeAllViews();
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final boolean bLg()
  {
    AppMethodBeat.i(106275);
    if ((this.nHk != null) && (this.nHk.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  public final void bLh()
  {
    AppMethodBeat.i(184612);
    this.nHk.setVisibility(8);
    WindowManager.LayoutParams localLayoutParams;
    if (this.windowManager != null)
    {
      localLayoutParams = new WindowManager.LayoutParams();
      if (com.tencent.mm.compatible.util.d.ly(26))
      {
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = aj.getContext().getPackageName();
        localLayoutParams.flags = 65824;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bLt();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bLu();
      }
    }
    for (;;)
    {
      try
      {
        this.windowManager.addView(this.nHk, localLayoutParams);
        ad.i("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow success");
        this.nHj.setVisibility(8);
        if (this.windowManager == null) {
          break label312;
        }
        localLayoutParams = new WindowManager.LayoutParams();
        if (!com.tencent.mm.compatible.util.d.ly(26)) {
          break label281;
        }
        localLayoutParams.type = 2038;
        localLayoutParams.format = 1;
        localLayoutParams.packageName = aj.getContext().getPackageName();
        localLayoutParams.flags = 196904;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.width = -2;
        localLayoutParams.height = -2;
        localLayoutParams.x = com.tencent.mm.plugin.ball.f.d.bLt();
        localLayoutParams.y = com.tencent.mm.plugin.ball.f.d.bLu();
        try
        {
          this.windowManager.addView(this.nHj, localLayoutParams);
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
  
  public final boolean bLi()
  {
    AppMethodBeat.i(217303);
    if ((this.nHk != null) && (this.nHk.getVisibility() == 0))
    {
      AppMethodBeat.o(217303);
      return true;
    }
    AppMethodBeat.o(217303);
    return false;
  }
  
  final void bLj()
  {
    AppMethodBeat.i(217304);
    try
    {
      if (this.windowManager != null)
      {
        this.windowManager.removeView(this.nHj);
        this.windowManager.removeView(this.nHk);
        if (this.nGl != null) {
          this.nGl.bKc();
        }
        ad.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(217304);
        return;
      }
      ad.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(217304);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(217304);
    }
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217302);
    if (this.nHk != null)
    {
      if (paramBoolean)
      {
        this.nHk.d(paramAnimatorListenerAdapter);
        AppMethodBeat.o(217302);
        return;
      }
      this.nHk.bLS();
    }
    AppMethodBeat.o(217302);
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.nHj != null)
    {
      i = this.nHj.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bLu();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(217301);
    if (this.nHj != null) {
      this.nHj.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(217301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */