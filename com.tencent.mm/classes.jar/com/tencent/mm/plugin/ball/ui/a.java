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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.plugin.ball.view.FloatMenuView.5;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Set;

public final class a
{
  int displayHeight;
  private int lastOrientation;
  com.tencent.mm.plugin.ball.c.b rYG;
  public FloatBallView rZJ;
  FloatMenuView rZK;
  private com.tencent.mm.plugin.ball.view.c rZL;
  public boolean rZM;
  final com.tencent.mm.plugin.ball.e.a rZN;
  boolean rZO;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.displayHeight = 0;
    this.lastOrientation = 1;
    this.rZO = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.rYG = ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class));
    this.rZN = new com.tencent.mm.plugin.ball.e.a();
    this.displayHeight = com.tencent.mm.ci.a.ks(paramContext);
    this.rYG.Fd(this.displayHeight);
    this.rZJ = new FloatBallView(paramContext);
    this.rYG.dK(this.rZJ);
    this.rZL = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.rZJ.setInnerView(this.rZL.sbL);
    this.rZJ.a(new g()
    {
      public final void T(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        Log.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.rZK;
        if (localFloatMenuView.rXo) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.W(paramAnonymousMotionEvent);
          AppMethodBeat.o(184604);
          return;
          localFloatMenuView.W(paramAnonymousMotionEvent);
          if ((localFloatMenuView.seE != null) && ((localFloatMenuView.seE.getTag() instanceof BallInfo)))
          {
            FloatMenuView.dM(localFloatMenuView.seE);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.seE.getTag();
            if (paramAnonymousMotionEvent.rYr)
            {
              Log.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.cxb();
            }
          }
          for (;;)
          {
            localFloatMenuView.rXo = false;
            localFloatMenuView.seE = null;
            localFloatMenuView.seF = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.rYs.opType = 2;
            localFloatMenuView.N(paramAnonymousMotionEvent);
            continue;
            Log.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.cxb();
          }
          Log.i("MicroMsg.FloatMenuView", "onBallLongPressTouchEvent, CANCEL(%s, %s)", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
        }
      }
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(184607);
        if (paramAnonymousBoolean1)
        {
          Log.i("MicroMsg.FloatBallContainer", "onBallSettled, x:%s, y:%s, height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          FloatMenuView localFloatMenuView = a.this.rZK;
          localFloatMenuView.rXn = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.seo) || (paramAnonymousInt2 != localFloatMenuView.sep) || (paramAnonymousInt3 != localFloatMenuView.seD))
          {
            Log.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.seD = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.5(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          com.tencent.mm.plugin.ball.service.d.cwb();
          if (paramAnonymousInt1 != com.tencent.mm.plugin.ball.service.d.rZw)
          {
            com.tencent.mm.plugin.ball.service.d.rZw = paramAnonymousInt1;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cvw()).encode("pos_x", com.tencent.mm.plugin.ball.service.d.rZw);
          }
          if (paramAnonymousInt2 != com.tencent.mm.plugin.ball.service.d.rZx)
          {
            com.tencent.mm.plugin.ball.service.d.rZx = paramAnonymousInt2;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cvw()).encode("pos_y", com.tencent.mm.plugin.ball.service.d.rZx);
          }
          if (paramAnonymousBoolean2 != com.tencent.mm.plugin.ball.service.d.rZy)
          {
            com.tencent.mm.plugin.ball.service.d.rZy = paramAnonymousBoolean2;
            MultiProcessMMKV.getMMKV(com.tencent.mm.plugin.ball.service.d.cvw()).encode("dock_left", com.tencent.mm.plugin.ball.service.d.rZy);
          }
        }
        AppMethodBeat.o(184607);
      }
      
      public final void cvk()
      {
        AppMethodBeat.i(184602);
        Log.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.rZN.lER = Util.nowMilliSecond();
        a.this.rZJ.b(false, null);
        a.this.rZK.setInLongPressMode(false);
        a.this.rZK.cwU();
        AppMethodBeat.o(184602);
      }
      
      public final void cvl()
      {
        AppMethodBeat.i(184603);
        Log.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.rZN.lER = Util.nowMilliSecond();
        a.this.rZJ.b(false, null);
        a.this.rZK.setInLongPressMode(true);
        a.this.rZK.cwU();
        AppMethodBeat.o(184603);
      }
      
      public final void cvm()
      {
        AppMethodBeat.i(184605);
        Log.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.rZM) });
        if (a.this.rZM) {
          a.this.cvi();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void cvn()
      {
        AppMethodBeat.i(184606);
        Log.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.rZM) });
        if ((a.this.rZM) && (a.this.rYG != null && (!a.this.rYG.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.cvj();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.cvj();
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
    this.rZK = new FloatMenuView(paramContext);
    paramContext = this.rZK;
    com.tencent.mm.plugin.ball.d.c local1 = new com.tencent.mm.plugin.ball.d.c()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousBallInfo);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.aFi());
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.rYs.opType = 9;
        a.this.rYG.l(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.rYr) && (a.this.rZO))
        {
          a.this.rZN.Fg(4);
          a.this.rZK.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void cvo()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.rZN.Fg(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void cvp()
      {
        AppMethodBeat.i(106260);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
        a.this.rZN.Fg(5);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
        AppMethodBeat.o(106260);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106264);
        a.this.rYG.n(paramAnonymousBallInfo);
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
        localb.bn(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.aFi());
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.rZN.Fg(3);
        a.this.rZK.e(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.rYG.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.rYG.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.rZJ.cwP();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
    };
    paramContext.sev.add(local1);
    this.rZK.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.d()
    {
      public final void cvq()
      {
        AppMethodBeat.i(184600);
        Log.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.rZK.getMeasuredHeight()) });
        if (a.this.rZK.getMeasuredHeight() != a.this.displayHeight)
        {
          a.this.displayHeight = a.this.rZK.getMeasuredHeight();
          a.this.rYG.Fd(a.this.displayHeight);
        }
        AppMethodBeat.o(184600);
      }
    });
    AppMethodBeat.o(106273);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(188549);
    if (this.rZJ != null) {
      this.rZJ.a(paramg);
    }
    AppMethodBeat.o(188549);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184611);
    List localList = com.tencent.mm.plugin.ball.f.d.ce(paramList);
    Object localObject;
    boolean bool2;
    boolean bool1;
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(paramList))
    {
      localObject = Integer.valueOf(paramList.size());
      Log.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(localList)) {
        break label385;
      }
      localObject = com.tencent.mm.plugin.ball.f.d.cg(localList);
      Log.d("MicroMsg.FloatBallContainer", "onFloaxtBallInfoChanged, videoBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VIDEO");
        this.rZK.cwX();
      }
      bool2 = AppForegroundDelegate.fby.cQt;
      if ((!cwl()) && (!this.rYG.cuW())) {
        break label335;
      }
      bool1 = true;
      label148:
      if ((!bool2) || (bool1) || (this.rYG.cvh())) {
        break label340;
      }
      Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.rZJ.sak) });
      if (!this.rZJ.sak) {
        this.rZJ.cwP();
      }
      label210:
      if ((localObject != null) && (!cwl()) && (!this.rYG.cvh()))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VIDEO, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.rZJ.cwP();
      }
    }
    for (;;)
    {
      if (this.rZJ != null) {
        this.rZJ.a(paramList, paramBallInfo);
      }
      if (this.rZL != null) {
        this.rZL.a(paramList, paramBallInfo);
      }
      if (this.rZK != null) {
        this.rZK.a(paramList, paramBallInfo);
      }
      this.rZN.rYD = paramList;
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label335:
      bool1 = false;
      break label148;
      label340:
      Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s, forceHideAllFloatBall: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(this.rYG.cvh()) });
      break label210;
      label385:
      if (this.rZK.getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.rZK.e(null);
        this.rZJ.b(false, null);
      }
      else if (this.rZJ.getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.rZJ.b(false, null);
      }
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(188530);
    if (this.rZJ != null)
    {
      Log.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.rZJ.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.rZK != null) && (!this.rZK.seG))
    {
      Log.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.rZK.e(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(188530);
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(188537);
    if (this.rZK != null)
    {
      if (paramBoolean)
      {
        this.rZK.e(paramAnimatorListenerAdapter);
        AppMethodBeat.o(188537);
        return;
      }
      this.rZK.cwX();
    }
    AppMethodBeat.o(188537);
  }
  
  public final void cvi()
  {
    AppMethodBeat.i(184613);
    if ((this.rZJ != null) && (this.rZJ.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.rZJ.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        Log.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.rZJ.setLayoutParams(localLayoutParams);
        Log.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(184614);
    if ((this.rZJ != null) && (this.rZJ.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.rZJ.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        Log.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.rZJ.setLayoutParams(localLayoutParams);
        Log.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void cwj()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.fby.cQt;
    boolean bool2 = this.rYG.cuY();
    boolean bool3 = this.rYG.cuW();
    Log.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.rZJ.cwP();
      AppMethodBeat.o(106274);
      return;
    }
    Log.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void cwk()
  {
    AppMethodBeat.i(176968);
    if (this.rZJ != null)
    {
      FloatBallView localFloatBallView = this.rZJ;
      if (localFloatBallView.scY != null)
      {
        localFloatBallView.scY.removeAllViews();
        localFloatBallView.bFK = null;
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final boolean cwl()
  {
    AppMethodBeat.i(106275);
    if ((this.rZK != null) && (this.rZK.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  /* Error */
  public final void cwm()
  {
    // Byte code:
    //   0: ldc_w 341
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 124	com/tencent/mm/plugin/ball/ui/a:rZK	Lcom/tencent/mm/plugin/ball/view/FloatMenuView;
    //   10: bipush 8
    //   12: invokevirtual 177	com/tencent/mm/plugin/ball/view/FloatMenuView:setVisibility	(I)V
    //   15: aload_0
    //   16: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   19: ifnull +310 -> 329
    //   22: new 294	android/view/WindowManager$LayoutParams
    //   25: dup
    //   26: invokespecial 342	android/view/WindowManager$LayoutParams:<init>	()V
    //   29: astore_1
    //   30: bipush 26
    //   32: invokestatic 348	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   35: ifeq +267 -> 302
    //   38: aload_1
    //   39: sipush 2038
    //   42: putfield 351	android/view/WindowManager$LayoutParams:type	I
    //   45: aload_1
    //   46: iconst_1
    //   47: putfield 354	android/view/WindowManager$LayoutParams:format	I
    //   50: aload_1
    //   51: invokestatic 360	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 364	android/content/Context:getPackageName	()Ljava/lang/String;
    //   57: putfield 368	android/view/WindowManager$LayoutParams:packageName	Ljava/lang/String;
    //   60: aload_1
    //   61: ldc_w 369
    //   64: putfield 300	android/view/WindowManager$LayoutParams:flags	I
    //   67: aload_1
    //   68: ldc_w 370
    //   71: putfield 373	android/view/WindowManager$LayoutParams:gravity	I
    //   74: aload_1
    //   75: iconst_m1
    //   76: putfield 376	android/view/WindowManager$LayoutParams:width	I
    //   79: aload_1
    //   80: iconst_m1
    //   81: putfield 379	android/view/WindowManager$LayoutParams:height	I
    //   84: aload_1
    //   85: invokestatic 382	com/tencent/mm/plugin/ball/f/d:cwy	()I
    //   88: putfield 385	android/view/WindowManager$LayoutParams:x	I
    //   91: aload_1
    //   92: invokestatic 388	com/tencent/mm/plugin/ball/f/d:cwz	()I
    //   95: putfield 391	android/view/WindowManager$LayoutParams:y	I
    //   98: aload_0
    //   99: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   102: aload_0
    //   103: getfield 124	com/tencent/mm/plugin/ball/ui/a:rZK	Lcom/tencent/mm/plugin/ball/view/FloatMenuView;
    //   106: aload_1
    //   107: invokeinterface 395 3 0
    //   112: ldc 154
    //   114: ldc_w 397
    //   117: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 96	com/tencent/mm/plugin/ball/ui/a:rZJ	Lcom/tencent/mm/plugin/ball/view/FloatBallView;
    //   124: bipush 8
    //   126: invokevirtual 398	com/tencent/mm/plugin/ball/view/FloatBallView:setVisibility	(I)V
    //   129: aload_0
    //   130: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   133: ifnull +234 -> 367
    //   136: new 294	android/view/WindowManager$LayoutParams
    //   139: dup
    //   140: invokespecial 342	android/view/WindowManager$LayoutParams:<init>	()V
    //   143: astore_1
    //   144: bipush 26
    //   146: invokestatic 348	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   149: ifeq +191 -> 340
    //   152: aload_1
    //   153: sipush 2038
    //   156: putfield 351	android/view/WindowManager$LayoutParams:type	I
    //   159: aload_1
    //   160: iconst_1
    //   161: putfield 354	android/view/WindowManager$LayoutParams:format	I
    //   164: aload_1
    //   165: invokestatic 360	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   168: invokevirtual 364	android/content/Context:getPackageName	()Ljava/lang/String;
    //   171: putfield 368	android/view/WindowManager$LayoutParams:packageName	Ljava/lang/String;
    //   174: aload_1
    //   175: ldc_w 399
    //   178: putfield 300	android/view/WindowManager$LayoutParams:flags	I
    //   181: aload_1
    //   182: ldc_w 370
    //   185: putfield 373	android/view/WindowManager$LayoutParams:gravity	I
    //   188: aload_1
    //   189: bipush 254
    //   191: putfield 376	android/view/WindowManager$LayoutParams:width	I
    //   194: aload_1
    //   195: bipush 254
    //   197: putfield 379	android/view/WindowManager$LayoutParams:height	I
    //   200: aload_1
    //   201: invokestatic 382	com/tencent/mm/plugin/ball/f/d:cwy	()I
    //   204: putfield 385	android/view/WindowManager$LayoutParams:x	I
    //   207: aload_1
    //   208: invokestatic 388	com/tencent/mm/plugin/ball/f/d:cwz	()I
    //   211: putfield 391	android/view/WindowManager$LayoutParams:y	I
    //   214: aload_0
    //   215: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   218: aload_0
    //   219: getfield 96	com/tencent/mm/plugin/ball/ui/a:rZJ	Lcom/tencent/mm/plugin/ball/view/FloatBallView;
    //   222: aload_1
    //   223: invokeinterface 395 3 0
    //   228: ldc 154
    //   230: ldc_w 401
    //   233: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: getfield 76	com/tencent/mm/plugin/ball/ui/a:rYG	Lcom/tencent/mm/plugin/ball/c/b;
    //   240: invokeinterface 405 1 0
    //   245: astore_1
    //   246: ldc 154
    //   248: ldc_w 407
    //   251: iconst_1
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_1
    //   258: invokeinterface 408 1 0
    //   263: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: aastore
    //   267: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_1
    //   271: invokeinterface 412 1 0
    //   276: astore_1
    //   277: aload_1
    //   278: invokeinterface 417 1 0
    //   283: ifeq +95 -> 378
    //   286: aload_0
    //   287: aload_1
    //   288: invokeinterface 421 1 0
    //   293: checkcast 423	com/tencent/mm/plugin/ball/c/g
    //   296: invokevirtual 424	com/tencent/mm/plugin/ball/ui/a:a	(Lcom/tencent/mm/plugin/ball/c/g;)V
    //   299: goto -22 -> 277
    //   302: aload_1
    //   303: sipush 2002
    //   306: putfield 351	android/view/WindowManager$LayoutParams:type	I
    //   309: goto -264 -> 45
    //   312: astore_1
    //   313: ldc 154
    //   315: aload_1
    //   316: ldc_w 426
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 430	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: goto -206 -> 120
    //   329: ldc 154
    //   331: ldc_w 432
    //   334: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: goto -217 -> 120
    //   340: aload_1
    //   341: sipush 2002
    //   344: putfield 351	android/view/WindowManager$LayoutParams:type	I
    //   347: goto -188 -> 159
    //   350: astore_1
    //   351: ldc 154
    //   353: aload_1
    //   354: ldc_w 436
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 430	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -128 -> 236
    //   367: ldc 154
    //   369: ldc_w 438
    //   372: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: goto -139 -> 236
    //   378: ldc_w 341
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
  
  public final boolean cwn()
  {
    AppMethodBeat.i(188539);
    if ((this.rZK != null) && (this.rZK.getVisibility() == 0))
    {
      AppMethodBeat.o(188539);
      return true;
    }
    AppMethodBeat.o(188539);
    return false;
  }
  
  final void cwo()
  {
    AppMethodBeat.i(188553);
    try
    {
      if (this.windowManager != null)
      {
        if (this.rZJ != null) {
          this.rZJ.listeners.clear();
        }
        this.windowManager.removeView(this.rZJ);
        this.windowManager.removeView(this.rZK);
        if (this.rYG != null) {
          this.rYG.cvg();
        }
        Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(188553);
        return;
      }
      Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(188553);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(188553);
    }
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.rZJ != null)
    {
      i = this.rZJ.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.cwz();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(188535);
    if (this.rZJ != null) {
      this.rZJ.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(188535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */