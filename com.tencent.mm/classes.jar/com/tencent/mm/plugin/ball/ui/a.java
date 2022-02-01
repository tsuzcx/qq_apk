package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.h;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.plugin.ball.view.FloatMenuView.5;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Set;

public final class a
{
  int displayHeight;
  private int lastOrientation;
  com.tencent.mm.plugin.ball.c.b vjX;
  public FloatBallView vla;
  FloatMenuView vlb;
  private com.tencent.mm.plugin.ball.view.c vlc;
  public boolean vld;
  final com.tencent.mm.plugin.ball.e.a vle;
  boolean vlf;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.displayHeight = 0;
    this.lastOrientation = 1;
    this.vlf = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.vjX = ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class));
    this.vle = new com.tencent.mm.plugin.ball.e.a();
    this.displayHeight = com.tencent.mm.cd.a.mt(paramContext);
    this.vjX.FE(this.displayHeight);
    this.vla = new FloatBallView(paramContext);
    this.vjX.ex(this.vla);
    this.vlc = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.vla.setInnerView(this.vlc.vnd);
    this.vla.a(new g()
    {
      public final void V(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        Log.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.vlb;
        if (localFloatMenuView.viF) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.Y(paramAnonymousMotionEvent);
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.Y(paramAnonymousMotionEvent);
          if ((localFloatMenuView.vqs != null) && ((localFloatMenuView.vqs.getTag() instanceof BallInfo)))
          {
            FloatMenuView.ez(localFloatMenuView.vqs);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.vqs.getTag();
            if (paramAnonymousMotionEvent.vjH)
            {
              Log.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.cZM();
            }
          }
          for (;;)
          {
            localFloatMenuView.viF = false;
            localFloatMenuView.vqs = null;
            localFloatMenuView.vqt = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.vjI.opType = 2;
            localFloatMenuView.Q(paramAnonymousMotionEvent);
            continue;
            Log.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.cZM();
          }
          Log.i("MicroMsg.FloatMenuView", "onBallLongPressTouchEvent, CANCEL(%s, %s)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
        }
      }
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt4)
      {
        AppMethodBeat.i(288292);
        if (paramAnonymousBoolean1)
        {
          Log.i("MicroMsg.FloatBallContainer", "onBallSettled, x:%s, y:%s, height:%s, isDockLeft: %s, collapseState: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Boolean.valueOf(paramAnonymousBoolean2), Integer.valueOf(paramAnonymousInt4) });
          FloatMenuView localFloatMenuView = a.this.vlb;
          localFloatMenuView.viE = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.vqe) || (paramAnonymousInt2 != localFloatMenuView.vqf) || (paramAnonymousInt3 != localFloatMenuView.vqr))
          {
            Log.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.vqr = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.5(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          com.tencent.mm.plugin.ball.service.d.cYL();
          if (paramAnonymousInt1 != com.tencent.mm.plugin.ball.service.d.vkM)
          {
            com.tencent.mm.plugin.ball.service.d.vkM = paramAnonymousInt1;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cYh()).encode("pos_x", com.tencent.mm.plugin.ball.service.d.vkM);
          }
          if (paramAnonymousInt2 != com.tencent.mm.plugin.ball.service.d.vkN)
          {
            com.tencent.mm.plugin.ball.service.d.vkN = paramAnonymousInt2;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cYh()).encode("pos_y", com.tencent.mm.plugin.ball.service.d.vkN);
          }
          if (paramAnonymousBoolean2 != com.tencent.mm.plugin.ball.service.d.vkP)
          {
            com.tencent.mm.plugin.ball.service.d.vkP = paramAnonymousBoolean2;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cYh()).encode("dock_left", com.tencent.mm.plugin.ball.service.d.vkP);
          }
          if (com.tencent.mm.plugin.ball.service.d.vkO != paramAnonymousInt4)
          {
            com.tencent.mm.plugin.ball.service.d.vkO = paramAnonymousInt4;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cYh()).encode("collapse_state", com.tencent.mm.plugin.ball.service.d.vkO);
          }
        }
        AppMethodBeat.o(288292);
      }
      
      public final void cXV()
      {
        AppMethodBeat.i(184602);
        Log.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.vle.owx = Util.nowMilliSecond();
        a.this.vla.b(false, null);
        a.this.vlb.setInLongPressMode(false);
        a.this.vlb.cZF();
        AppMethodBeat.o(184602);
      }
      
      public final void cXW()
      {
        AppMethodBeat.i(184603);
        Log.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.vle.owx = Util.nowMilliSecond();
        a.this.vla.b(false, null);
        a.this.vlb.setInLongPressMode(true);
        a.this.vlb.cZF();
        AppMethodBeat.o(184603);
      }
      
      public final void cXX()
      {
        AppMethodBeat.i(184605);
        Log.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.vld) });
        if (a.this.vld) {
          a.this.cXS();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void cXY()
      {
        AppMethodBeat.i(184606);
        Log.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.vld) });
        if ((a.this.vld) && (a.this.vjX != null && (!a.this.vjX.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.cXT();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.cXT();
        }
        AppMethodBeat.o(184606);
      }
      
      public final void onOrientationChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(184608);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(184608);
      }
    });
    this.vlb = new FloatMenuView(paramContext);
    paramContext = this.vlb;
    com.tencent.mm.plugin.ball.d.c local1 = new com.tencent.mm.plugin.ball.d.c()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousBallInfo);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.aYj());
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.vjI.opType = 9;
        a.this.vjX.l(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.vjH) && (a.this.vlf))
        {
          a.this.vle.FH(4);
          a.this.vlb.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void cXZ()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.vle.FH(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void cYa()
      {
        AppMethodBeat.i(106260);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
        a.this.vle.FH(5);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
        AppMethodBeat.o(106260);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106264);
        a.this.vjX.n(paramAnonymousBallInfo);
        AppMethodBeat.o(106264);
      }
      
      public final void onOrientationChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(106261);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(106261);
      }
      
      public final void v(final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.aYj());
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.vle.FH(3);
        a.this.vlb.e(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.vjX.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.vjX.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.vla.cZA();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
    };
    paramContext.vqk.add(local1);
    this.vlb.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.d()
    {
      public final void cYb()
      {
        AppMethodBeat.i(184600);
        Log.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.vlb.getMeasuredHeight()) });
        if (a.this.vlb.getMeasuredHeight() != a.this.displayHeight)
        {
          a.this.displayHeight = a.this.vlb.getMeasuredHeight();
          a.this.vjX.FE(a.this.displayHeight);
        }
        AppMethodBeat.o(184600);
      }
    });
    AppMethodBeat.o(106273);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(288361);
    if (this.vla != null) {
      this.vla.a(paramg);
    }
    AppMethodBeat.o(288361);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184611);
    List localList = com.tencent.mm.plugin.ball.f.d.dW(paramList);
    Object localObject;
    boolean bool2;
    boolean bool1;
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(paramList))
    {
      localObject = Integer.valueOf(paramList.size());
      Log.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(localList)) {
        break label398;
      }
      localObject = com.tencent.mm.plugin.ball.f.d.dY(localList);
      Log.d("MicroMsg.FloatBallContainer", "onFloaxtBallInfoChanged, videoBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VIDEO");
        this.vlb.cZI();
      }
      bool2 = AppForegroundDelegate.heY.eLx;
      if ((!cYV()) && (!this.vjX.cXG())) {
        break label348;
      }
      bool1 = true;
      label148:
      if ((!bool2) || (bool1) || (this.vjX.cXR())) {
        break label353;
      }
      Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.vla.vlB) });
      if (!this.vla.vlB) {
        this.vla.cZA();
      }
      label210:
      if ((localObject != null) && (!cYV()) && (!this.vjX.cXR()))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VIDEO, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.vla.cZA();
      }
    }
    for (;;)
    {
      if (this.vla != null) {
        this.vla.a(paramList, paramBallInfo);
      }
      if (this.vlc != null) {
        this.vlc.a(paramList, paramBallInfo);
      }
      if (this.vlb != null) {
        this.vlb.a(paramList, paramBallInfo);
      }
      this.vle.vjU = paramList;
      if ((paramList != null) && (paramList.size() != 0)) {
        break label466;
      }
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label348:
      bool1 = false;
      break label148;
      label353:
      Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s, forceHideAllFloatBall: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(this.vjX.cXR()) });
      break label210;
      label398:
      if (this.vlb.getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.vlb.e(null);
        this.vla.b(false, null);
      }
      else if (this.vla.getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.vla.b(false, null);
      }
    }
    label466:
    switch (((BallInfo)paramList.get(0)).cIh)
    {
    default: 
      paramBallInfo = MMApplicationContext.getResources().getString(a.h.talkback_float_ball);
    }
    for (;;)
    {
      if (paramList.size() > 1) {
        paramBallInfo = MMApplicationContext.getResources().getString(a.h.talkback_multi_type);
      }
      this.vla.vos.setContentDescription(paramBallInfo);
      AppMethodBeat.o(184611);
      return;
      paramBallInfo = MMApplicationContext.getResources().getString(a.h.talkback_music_video);
      continue;
      paramBallInfo = MMApplicationContext.getResources().getString(a.h.talkback_music);
      continue;
      paramBallInfo = MMApplicationContext.getResources().getString(a.h.talkback_article);
      continue;
      paramBallInfo = MMApplicationContext.getResources().getString(a.h.talkback_download);
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288310);
    if (this.vla != null)
    {
      Log.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.vla.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.vlb != null) && (!this.vlb.vqu))
    {
      Log.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.vlb.e(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(288310);
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288342);
    if (this.vlb != null)
    {
      if (paramBoolean)
      {
        this.vlb.e(paramAnimatorListenerAdapter);
        AppMethodBeat.o(288342);
        return;
      }
      this.vlb.cZI();
    }
    AppMethodBeat.o(288342);
  }
  
  public final void cXS()
  {
    AppMethodBeat.i(184613);
    if ((this.vla != null) && (this.vla.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.vla.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        Log.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.vla.setLayoutParams(localLayoutParams);
        Log.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void cXT()
  {
    AppMethodBeat.i(184614);
    if ((this.vla != null) && (this.vla.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.vla.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        Log.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.vla.setLayoutParams(localLayoutParams);
        Log.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void cYT()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.heY.eLx;
    boolean bool2 = this.vjX.cXI();
    boolean bool3 = this.vjX.cXG();
    Log.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.vla.cZA();
      AppMethodBeat.o(106274);
      return;
    }
    Log.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void cYU()
  {
    AppMethodBeat.i(176968);
    if (this.vla != null)
    {
      FloatBallView localFloatBallView = this.vla;
      if (localFloatBallView.vov != null)
      {
        localFloatBallView.vov.removeAllViews();
        localFloatBallView.dyK = null;
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final boolean cYV()
  {
    AppMethodBeat.i(106275);
    if ((this.vlb != null) && (this.vlb.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  /* Error */
  public final void cYW()
  {
    // Byte code:
    //   0: ldc_w 389
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 124	com/tencent/mm/plugin/ball/ui/a:vlb	Lcom/tencent/mm/plugin/ball/view/FloatMenuView;
    //   10: bipush 8
    //   12: invokevirtual 177	com/tencent/mm/plugin/ball/view/FloatMenuView:setVisibility	(I)V
    //   15: aload_0
    //   16: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   19: ifnull +310 -> 329
    //   22: new 345	android/view/WindowManager$LayoutParams
    //   25: dup
    //   26: invokespecial 390	android/view/WindowManager$LayoutParams:<init>	()V
    //   29: astore_1
    //   30: bipush 26
    //   32: invokestatic 396	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   35: ifeq +267 -> 302
    //   38: aload_1
    //   39: sipush 2038
    //   42: putfield 399	android/view/WindowManager$LayoutParams:type	I
    //   45: aload_1
    //   46: iconst_1
    //   47: putfield 402	android/view/WindowManager$LayoutParams:format	I
    //   50: aload_1
    //   51: invokestatic 406	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 410	android/content/Context:getPackageName	()Ljava/lang/String;
    //   57: putfield 414	android/view/WindowManager$LayoutParams:packageName	Ljava/lang/String;
    //   60: aload_1
    //   61: ldc_w 415
    //   64: putfield 351	android/view/WindowManager$LayoutParams:flags	I
    //   67: aload_1
    //   68: ldc_w 416
    //   71: putfield 419	android/view/WindowManager$LayoutParams:gravity	I
    //   74: aload_1
    //   75: iconst_m1
    //   76: putfield 422	android/view/WindowManager$LayoutParams:width	I
    //   79: aload_1
    //   80: iconst_m1
    //   81: putfield 425	android/view/WindowManager$LayoutParams:height	I
    //   84: aload_1
    //   85: invokestatic 428	com/tencent/mm/plugin/ball/f/d:cZh	()I
    //   88: putfield 431	android/view/WindowManager$LayoutParams:x	I
    //   91: aload_1
    //   92: invokestatic 434	com/tencent/mm/plugin/ball/f/d:cZi	()I
    //   95: putfield 437	android/view/WindowManager$LayoutParams:y	I
    //   98: aload_0
    //   99: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   102: aload_0
    //   103: getfield 124	com/tencent/mm/plugin/ball/ui/a:vlb	Lcom/tencent/mm/plugin/ball/view/FloatMenuView;
    //   106: aload_1
    //   107: invokeinterface 441 3 0
    //   112: ldc 154
    //   114: ldc_w 443
    //   117: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 96	com/tencent/mm/plugin/ball/ui/a:vla	Lcom/tencent/mm/plugin/ball/view/FloatBallView;
    //   124: bipush 8
    //   126: invokevirtual 444	com/tencent/mm/plugin/ball/view/FloatBallView:setVisibility	(I)V
    //   129: aload_0
    //   130: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   133: ifnull +234 -> 367
    //   136: new 345	android/view/WindowManager$LayoutParams
    //   139: dup
    //   140: invokespecial 390	android/view/WindowManager$LayoutParams:<init>	()V
    //   143: astore_1
    //   144: bipush 26
    //   146: invokestatic 396	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   149: ifeq +191 -> 340
    //   152: aload_1
    //   153: sipush 2038
    //   156: putfield 399	android/view/WindowManager$LayoutParams:type	I
    //   159: aload_1
    //   160: iconst_1
    //   161: putfield 402	android/view/WindowManager$LayoutParams:format	I
    //   164: aload_1
    //   165: invokestatic 406	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   168: invokevirtual 410	android/content/Context:getPackageName	()Ljava/lang/String;
    //   171: putfield 414	android/view/WindowManager$LayoutParams:packageName	Ljava/lang/String;
    //   174: aload_1
    //   175: ldc_w 445
    //   178: putfield 351	android/view/WindowManager$LayoutParams:flags	I
    //   181: aload_1
    //   182: ldc_w 416
    //   185: putfield 419	android/view/WindowManager$LayoutParams:gravity	I
    //   188: aload_1
    //   189: bipush 254
    //   191: putfield 422	android/view/WindowManager$LayoutParams:width	I
    //   194: aload_1
    //   195: bipush 254
    //   197: putfield 425	android/view/WindowManager$LayoutParams:height	I
    //   200: aload_1
    //   201: invokestatic 428	com/tencent/mm/plugin/ball/f/d:cZh	()I
    //   204: putfield 431	android/view/WindowManager$LayoutParams:x	I
    //   207: aload_1
    //   208: invokestatic 434	com/tencent/mm/plugin/ball/f/d:cZi	()I
    //   211: putfield 437	android/view/WindowManager$LayoutParams:y	I
    //   214: aload_0
    //   215: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   218: aload_0
    //   219: getfield 96	com/tencent/mm/plugin/ball/ui/a:vla	Lcom/tencent/mm/plugin/ball/view/FloatBallView;
    //   222: aload_1
    //   223: invokeinterface 441 3 0
    //   228: ldc 154
    //   230: ldc_w 447
    //   233: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: getfield 76	com/tencent/mm/plugin/ball/ui/a:vjX	Lcom/tencent/mm/plugin/ball/c/b;
    //   240: invokeinterface 451 1 0
    //   245: astore_1
    //   246: ldc 154
    //   248: ldc_w 453
    //   251: iconst_1
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_1
    //   258: invokeinterface 454 1 0
    //   263: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: aastore
    //   267: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_1
    //   271: invokeinterface 458 1 0
    //   276: astore_1
    //   277: aload_1
    //   278: invokeinterface 463 1 0
    //   283: ifeq +95 -> 378
    //   286: aload_0
    //   287: aload_1
    //   288: invokeinterface 467 1 0
    //   293: checkcast 469	com/tencent/mm/plugin/ball/c/g
    //   296: invokevirtual 470	com/tencent/mm/plugin/ball/ui/a:a	(Lcom/tencent/mm/plugin/ball/c/g;)V
    //   299: goto -22 -> 277
    //   302: aload_1
    //   303: sipush 2002
    //   306: putfield 399	android/view/WindowManager$LayoutParams:type	I
    //   309: goto -264 -> 45
    //   312: astore_1
    //   313: ldc 154
    //   315: aload_1
    //   316: ldc_w 472
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 476	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: goto -206 -> 120
    //   329: ldc 154
    //   331: ldc_w 478
    //   334: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: goto -217 -> 120
    //   340: aload_1
    //   341: sipush 2002
    //   344: putfield 399	android/view/WindowManager$LayoutParams:type	I
    //   347: goto -188 -> 159
    //   350: astore_1
    //   351: ldc 154
    //   353: aload_1
    //   354: ldc_w 482
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 476	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -128 -> 236
    //   367: ldc 154
    //   369: ldc_w 484
    //   372: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: goto -139 -> 236
    //   378: ldc_w 389
    //   381: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	a
    //   29	274	1	localObject	Object
    //   312	29	1	localException1	Exception
    //   350	4	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   98	120	312	java/lang/Exception
    //   214	236	350	java/lang/Exception
  }
  
  public final boolean cYX()
  {
    AppMethodBeat.i(288346);
    if ((this.vlb != null) && (this.vlb.getVisibility() == 0))
    {
      AppMethodBeat.o(288346);
      return true;
    }
    AppMethodBeat.o(288346);
    return false;
  }
  
  final void cYY()
  {
    AppMethodBeat.i(288364);
    try
    {
      if (this.windowManager != null)
      {
        if (this.vla != null) {
          this.vla.listeners.clear();
        }
        this.windowManager.removeView(this.vla);
        this.windowManager.removeView(this.vlb);
        if (this.vjX != null) {
          this.vjX.cXQ();
        }
        Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(288364);
        return;
      }
      Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(288364);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(288364);
    }
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.vla != null)
    {
      i = this.vla.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.cZi();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(288337);
    if (this.vla != null) {
      this.vla.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(288337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */