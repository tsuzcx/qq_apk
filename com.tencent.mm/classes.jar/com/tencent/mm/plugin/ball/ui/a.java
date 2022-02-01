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
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
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
  com.tencent.mm.plugin.ball.c.b oWG;
  public FloatBallView oXH;
  FloatMenuView oXI;
  private com.tencent.mm.plugin.ball.view.c oXJ;
  public boolean oXK;
  final com.tencent.mm.plugin.ball.e.a oXL;
  boolean oXM;
  private WindowManager windowManager;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106273);
    this.displayHeight = 0;
    this.lastOrientation = 1;
    this.oXM = false;
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.oWG = ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class));
    this.oXL = new com.tencent.mm.plugin.ball.e.a();
    this.displayHeight = com.tencent.mm.cb.a.jo(paramContext);
    this.oWG.BC(this.displayHeight);
    this.oXH = new FloatBallView(paramContext);
    this.oWG.dn(this.oXH);
    this.oXJ = new com.tencent.mm.plugin.ball.view.c(paramContext);
    this.oXH.setInnerView(this.oXJ.oZK);
    this.oXH.a(new com.tencent.mm.plugin.ball.c.g()
    {
      public final void M(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(184604);
        Log.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
        FloatMenuView localFloatMenuView = a.this.oXI;
        if (localFloatMenuView.oVp) {
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
          if ((localFloatMenuView.pcC != null) && ((localFloatMenuView.pcC.getTag() instanceof BallInfo)))
          {
            FloatMenuView.dp(localFloatMenuView.pcC);
            paramAnonymousMotionEvent = (BallInfo)localFloatMenuView.pcC.getTag();
            if (paramAnonymousMotionEvent.oWr)
            {
              Log.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
              localFloatMenuView.cjK();
            }
          }
          for (;;)
          {
            localFloatMenuView.oVp = false;
            localFloatMenuView.pcC = null;
            localFloatMenuView.pcD = -1;
            AppMethodBeat.o(184604);
            return;
            paramAnonymousMotionEvent.oWs.opType = 2;
            localFloatMenuView.M(paramAnonymousMotionEvent);
            continue;
            Log.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
            localFloatMenuView.cjK();
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
          FloatMenuView localFloatMenuView = a.this.oXI;
          localFloatMenuView.oVo = paramAnonymousBoolean2;
          if ((paramAnonymousInt1 != localFloatMenuView.pco) || (paramAnonymousInt2 != localFloatMenuView.pcp) || (paramAnonymousInt3 != localFloatMenuView.pcB))
          {
            Log.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
            localFloatMenuView.pcB = paramAnonymousInt3;
            localFloatMenuView.post(new FloatMenuView.5(localFloatMenuView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean2));
          }
          e.ciJ();
          if (paramAnonymousInt1 != e.oXw)
          {
            e.oXw = paramAnonymousInt1;
            MultiProcessMMKV.getMMKV(e.cik()).encode("pos_x", e.oXw);
          }
          if (paramAnonymousInt2 != e.oXx)
          {
            e.oXx = paramAnonymousInt2;
            MultiProcessMMKV.getMMKV(e.cik()).encode("pos_y", e.oXx);
          }
          if (paramAnonymousBoolean2 != e.oXy)
          {
            e.oXy = paramAnonymousBoolean2;
            MultiProcessMMKV.getMMKV(e.cik()).encode("dock_left", e.oXy);
          }
        }
        AppMethodBeat.o(184607);
      }
      
      public final void chY()
      {
        AppMethodBeat.i(184602);
        Log.i("MicroMsg.FloatBallContainer", "onBallClicked");
        a.this.oXL.iOB = Util.nowMilliSecond();
        a.this.oXH.b(false, null);
        a.this.oXI.setInLongPressMode(false);
        a.this.oXI.cjD();
        AppMethodBeat.o(184602);
      }
      
      public final void chZ()
      {
        AppMethodBeat.i(184603);
        Log.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
        a.this.oXL.iOB = Util.nowMilliSecond();
        a.this.oXH.b(false, null);
        a.this.oXI.setInLongPressMode(true);
        a.this.oXI.cjD();
        AppMethodBeat.o(184603);
      }
      
      public final void cia()
      {
        AppMethodBeat.i(184605);
        Log.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.oXK) });
        if (a.this.oXK) {
          a.this.chW();
        }
        AppMethodBeat.o(184605);
      }
      
      public final void cib()
      {
        AppMethodBeat.i(184606);
        Log.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", new Object[] { Boolean.valueOf(a.this.oXK) });
        if ((a.this.oXK) && (a.this.oWG != null && (!a.this.oWG.c(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(184601);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.chX();
            AppMethodBeat.o(184601);
          }
        }))) {
          a.this.chX();
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
    this.oXI = new FloatMenuView(paramContext);
    paramContext = this.oXI;
    com.tencent.mm.plugin.ball.d.c local1 = new com.tencent.mm.plugin.ball.d.c()
    {
      public final void a(BallInfo paramAnonymousBallInfo, int paramAnonymousInt)
      {
        AppMethodBeat.i(106263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousBallInfo);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, localb.axR());
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
        paramAnonymousBallInfo.oWs.opType = 9;
        a.this.oWG.l(paramAnonymousBallInfo);
        if ((!paramAnonymousBallInfo.oWr) && (a.this.oXM))
        {
          a.this.oXL.BF(4);
          a.this.oXI.setCanAddFloatBallWhenHide(true);
          a.a(a.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
        AppMethodBeat.o(106263);
      }
      
      public final void cic()
      {
        AppMethodBeat.i(106259);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
        a.this.oXL.BF(2);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
        AppMethodBeat.o(106259);
      }
      
      public final void cid()
      {
        AppMethodBeat.i(106260);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
        a.this.oXL.BF(5);
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
        AppMethodBeat.o(106260);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(106264);
        a.this.oWG.n(paramAnonymousBallInfo);
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
        localb.bm(paramAnonymousBallInfo);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, localb.axR());
        Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
        a.this.oXL.BF(3);
        a.this.oXI.e(new AnimatorListenerAdapter()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106257);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.oWG.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106257);
          }
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106258);
            super.onAnimationEnd(paramAnonymous2Animator);
            a.this.oWG.m(paramAnonymousBallInfo);
            AppMethodBeat.o(106258);
          }
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(106256);
            super.onAnimationStart(paramAnonymous2Animator);
            a.this.oXH.cjy();
            AppMethodBeat.o(106256);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
        AppMethodBeat.o(106262);
      }
    };
    paramContext.pcu.add(local1);
    this.oXI.setOnMeasuredListener(new com.tencent.mm.plugin.ball.d.d()
    {
      public final void cie()
      {
        AppMethodBeat.i(184600);
        Log.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", new Object[] { Integer.valueOf(a.this.oXI.getMeasuredHeight()) });
        if (a.this.oXI.getMeasuredHeight() != a.this.displayHeight)
        {
          a.this.displayHeight = a.this.oXI.getMeasuredHeight();
          a.this.oWG.BC(a.this.displayHeight);
        }
        AppMethodBeat.o(184600);
      }
    });
    AppMethodBeat.o(106273);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.g paramg)
  {
    AppMethodBeat.i(217046);
    if (this.oXH != null) {
      this.oXH.a(paramg);
    }
    AppMethodBeat.o(217046);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184611);
    List localList = com.tencent.mm.plugin.ball.f.d.ci(paramList);
    Object localObject;
    boolean bool2;
    boolean bool1;
    if (com.tencent.mm.plugin.ball.f.d.h(paramList))
    {
      localObject = Integer.valueOf(paramList.size());
      Log.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      if (!com.tencent.mm.plugin.ball.f.d.h(localList)) {
        break label385;
      }
      localObject = com.tencent.mm.plugin.ball.f.d.ck(localList);
      Log.d("MicroMsg.FloatBallContainer", "onFloaxtBallInfoChanged, videoBallInfo: %s", new Object[] { localObject });
      if ((localObject != null) && (localList.size() == 1))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VIDEO");
        this.oXI.cjG();
      }
      bool2 = AppForegroundDelegate.djR.cPB;
      if ((!ciT()) && (!this.oWG.chM())) {
        break label335;
      }
      bool1 = true;
      label148:
      if ((!bool2) || (bool1) || (this.oWG.chV())) {
        break label340;
      }
      Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { Boolean.valueOf(this.oXH.oYj) });
      if (!this.oXH.oYj) {
        this.oXH.cjy();
      }
      label210:
      if ((localObject != null) && (!ciT()) && (!this.oWG.chV()))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VIDEO, nonHiddenSize: %d", new Object[] { Integer.valueOf(localList.size()) });
        this.oXH.cjy();
      }
    }
    for (;;)
    {
      if (this.oXH != null) {
        this.oXH.a(paramList, paramBallInfo);
      }
      if (this.oXJ != null) {
        this.oXJ.a(paramList, paramBallInfo);
      }
      if (this.oXI != null) {
        this.oXI.a(paramList, paramBallInfo);
      }
      this.oXL.oWD = paramList;
      AppMethodBeat.o(184611);
      return;
      localObject = "0";
      break;
      label335:
      bool1 = false;
      break label148;
      label340:
      Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s, forceHideAllFloatBall: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(this.oWG.chV()) });
      break label210;
      label385:
      if (this.oXI.getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
        this.oXI.e(null);
        this.oXH.b(false, null);
      }
      else if (this.oXH.getVisibility() == 0)
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        this.oXH.b(false, null);
      }
    }
  }
  
  public final void b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217042);
    if (this.oXH != null)
    {
      Log.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.oXH.b(paramBoolean, paramAnimatorListenerAdapter);
    }
    if ((this.oXI != null) && (!this.oXI.pcE))
    {
      Log.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.oXI.e(paramAnimatorListenerAdapter);
    }
    AppMethodBeat.o(217042);
  }
  
  public final void c(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217044);
    if (this.oXI != null)
    {
      if (paramBoolean)
      {
        this.oXI.e(paramAnimatorListenerAdapter);
        AppMethodBeat.o(217044);
        return;
      }
      this.oXI.cjG();
    }
    AppMethodBeat.o(217044);
  }
  
  public final void chW()
  {
    AppMethodBeat.i(184613);
    if ((this.oXH != null) && (this.oXH.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.oXH.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        Log.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags |= 0x20000;
        this.oXH.setLayoutParams(localLayoutParams);
        Log.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184613);
  }
  
  public final void chX()
  {
    AppMethodBeat.i(184614);
    if ((this.oXH != null) && (this.oXH.getLayoutParams() != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.oXH.getLayoutParams();
      if ((localLayoutParams instanceof WindowManager.LayoutParams))
      {
        Log.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", new Object[] { Integer.valueOf(131072) });
        WindowManager.LayoutParams localLayoutParams1 = (WindowManager.LayoutParams)localLayoutParams;
        localLayoutParams1.flags &= 0xFFFDFFFF;
        this.oXH.setLayoutParams(localLayoutParams);
        Log.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", new Object[] { Integer.valueOf(((WindowManager.LayoutParams)localLayoutParams).flags) });
      }
    }
    AppMethodBeat.o(184614);
  }
  
  final void ciR()
  {
    AppMethodBeat.i(106274);
    boolean bool1 = AppForegroundDelegate.djR.cPB;
    boolean bool2 = this.oWG.chO();
    boolean bool3 = this.oWG.chM();
    Log.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((!bool3) && ((bool1) || (bool2)))
    {
      this.oXH.cjy();
      AppMethodBeat.o(106274);
      return;
    }
    Log.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
    AppMethodBeat.o(106274);
  }
  
  public final void ciS()
  {
    AppMethodBeat.i(176968);
    if (this.oXH != null)
    {
      FloatBallView localFloatBallView = this.oXH;
      if (localFloatBallView.paY != null)
      {
        localFloatBallView.paY.removeAllViews();
        localFloatBallView.vk = null;
      }
    }
    AppMethodBeat.o(176968);
  }
  
  public final boolean ciT()
  {
    AppMethodBeat.i(106275);
    if ((this.oXI != null) && (this.oXI.getVisibility() == 0))
    {
      AppMethodBeat.o(106275);
      return true;
    }
    AppMethodBeat.o(106275);
    return false;
  }
  
  /* Error */
  public final void ciU()
  {
    // Byte code:
    //   0: ldc_w 341
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 124	com/tencent/mm/plugin/ball/ui/a:oXI	Lcom/tencent/mm/plugin/ball/view/FloatMenuView;
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
    //   32: invokestatic 348	com/tencent/mm/compatible/util/d:oD	(I)Z
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
    //   85: invokestatic 382	com/tencent/mm/plugin/ball/f/d:cjg	()I
    //   88: putfield 385	android/view/WindowManager$LayoutParams:x	I
    //   91: aload_1
    //   92: invokestatic 388	com/tencent/mm/plugin/ball/f/d:cjh	()I
    //   95: putfield 391	android/view/WindowManager$LayoutParams:y	I
    //   98: aload_0
    //   99: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   102: aload_0
    //   103: getfield 124	com/tencent/mm/plugin/ball/ui/a:oXI	Lcom/tencent/mm/plugin/ball/view/FloatMenuView;
    //   106: aload_1
    //   107: invokeinterface 395 3 0
    //   112: ldc 154
    //   114: ldc_w 397
    //   117: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 96	com/tencent/mm/plugin/ball/ui/a:oXH	Lcom/tencent/mm/plugin/ball/view/FloatBallView;
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
    //   146: invokestatic 348	com/tencent/mm/compatible/util/d:oD	(I)Z
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
    //   201: invokestatic 382	com/tencent/mm/plugin/ball/f/d:cjg	()I
    //   204: putfield 385	android/view/WindowManager$LayoutParams:x	I
    //   207: aload_1
    //   208: invokestatic 388	com/tencent/mm/plugin/ball/f/d:cjh	()I
    //   211: putfield 391	android/view/WindowManager$LayoutParams:y	I
    //   214: aload_0
    //   215: getfield 66	com/tencent/mm/plugin/ball/ui/a:windowManager	Landroid/view/WindowManager;
    //   218: aload_0
    //   219: getfield 96	com/tencent/mm/plugin/ball/ui/a:oXH	Lcom/tencent/mm/plugin/ball/view/FloatBallView;
    //   222: aload_1
    //   223: invokeinterface 395 3 0
    //   228: ldc 154
    //   230: ldc_w 401
    //   233: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: getfield 76	com/tencent/mm/plugin/ball/ui/a:oWG	Lcom/tencent/mm/plugin/ball/c/b;
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
  
  public final boolean ciV()
  {
    AppMethodBeat.i(217045);
    if ((this.oXI != null) && (this.oXI.getVisibility() == 0))
    {
      AppMethodBeat.o(217045);
      return true;
    }
    AppMethodBeat.o(217045);
    return false;
  }
  
  final void ciW()
  {
    AppMethodBeat.i(217047);
    try
    {
      if (this.windowManager != null)
      {
        if (this.oXH != null) {
          this.oXH.listeners.clear();
        }
        this.windowManager.removeView(this.oXH);
        this.windowManager.removeView(this.oXI);
        if (this.oWG != null) {
          this.oWG.chU();
        }
        Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(217047);
        return;
      }
      Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(217047);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallContainer", localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(217047);
    }
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184610);
    if (this.oXH != null)
    {
      i = this.oXH.getPositionY();
      AppMethodBeat.o(184610);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.cjh();
    AppMethodBeat.o(184610);
    return i;
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(217043);
    if (this.oXH != null) {
      this.oXH.setNeedTranslateAnimation(paramBoolean);
    }
    AppMethodBeat.o(217043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.a
 * JD-Core Version:    0.7.0.1
 */