package com.tencent.mm.plugin.appbrand.game.f;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.game.page.WAGamePageViewContainerLayout;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.an;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.gamelive.b.g;
import com.tencent.mm.protocal.protobuf.glo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;

public class e<PAGE extends ah>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a, b.g
{
  private MagicBrushView rrP = null;
  private b rrQ = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean cpb()
  {
    AppMethodBeat.i(318436);
    boolean bool = bj.x(((ah)aqX()).getRuntime());
    AppMethodBeat.o(318436);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.tMW;
    this.rrQ = new b(paramb, aqZ());
    if ((paramb != null) && (paramb.acgV))
    {
      Log.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.rrQ;
      if ((paramb.rrF == null) || (paramb.coW() == null) || (Util.isNullOrNil(paramb.rrF.ache)) || (!paramb.rrF.acgV) || (paramb.rrH == null))
      {
        Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.coX())
      {
        Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: running, trigger send event after 1 sec");
        MMHandlerThread.postToMainThreadDelayed(new b.1(paramb), 1000L);
        AppMethodBeat.o(45191);
        return;
      }
      Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: not running!");
      AppMethodBeat.o(45191);
      return;
    }
    Log.w("MicroMsg.WAGamePageViewRendererWC", "hy: no server config or do not need sample. do not do anything");
    AppMethodBeat.o(45191);
  }
  
  public final void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(318447);
    this.rrP.getMagicBrush().avm();
    this.rrP.a(false, 0, new e.3(this, paramRunnable));
    AppMethodBeat.o(318447);
  }
  
  public final MagicBrushView apS()
  {
    return this.rrP;
  }
  
  public final void aqc()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void aqe()
  {
    AppMethodBeat.i(318455);
    super.aqe();
    if (getAppId() != null) {
      ((com.tencent.mm.plugin.gamelive.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.b.class)).a(aqZ(), getContext(), getAppId(), ((ah)aqX()).getRuntime().qsh.eul);
    }
    AppMethodBeat.o(318455);
  }
  
  public final void aqf()
  {
    AppMethodBeat.i(45189);
    if ((k.Uo(((ah)aqX()).getAppId()) == k.d.qrG) && (this.rrQ != null) && (this.rrQ.coV())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((ah)aqX()).ccO(), b.a.rrC, 0);
    }
    super.aqf();
    if (getAppId() != null) {
      ((com.tencent.mm.plugin.gamelive.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.b.class)).n(getContext(), getAppId(), ((ah)aqX()).getRuntime().qsh.eul);
    }
    AppMethodBeat.o(45189);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(318452);
    if (cpb())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(aqZ().asA().hEy);
      AppMethodBeat.o(318452);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(318452);
  }
  
  public final MagicBrushView bn(Context paramContext)
  {
    AppMethodBeat.i(45188);
    long l1 = Util.currentTicks();
    this.rrP = new MagicBrushView(paramContext, new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext));
    long l2 = Util.currentTicks();
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreateMagicBrushView, "", l1, l2);
    ((com.tencent.mm.plugin.gamelive.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.b.class)).a(this);
    paramContext = this.rrP;
    AppMethodBeat.o(45188);
    return paramContext;
  }
  
  public final void cO(View paramView)
  {
    AppMethodBeat.i(318477);
    if ((aqX() == null) || (((ah)aqX()).getRuntime() == null))
    {
      AppMethodBeat.o(318477);
      return;
    }
    if (!an.u(((ah)aqX()).getRuntime()))
    {
      AppMethodBeat.o(318477);
      return;
    }
    super.cO(paramView);
    AppMethodBeat.o(318477);
  }
  
  public final b coU()
  {
    return this.rrQ;
  }
  
  public final void cpa()
  {
    AppMethodBeat.i(318444);
    com.tencent.mm.plugin.appbrand.game.g.b localb = com.tencent.mm.plugin.appbrand.game.g.b.ZB(getAppId());
    if (localb != null)
    {
      Log.i("MicroMsg.WAGamePageViewRendererWC", "stop running recorder");
      localb.g(new e.1(this));
      new com.tencent.mm.plugin.appbrand.game.e.a.a().a(((ah)aqX()).ccO(), 112, "game is living, not support record now");
    }
    this.rrP.a(false, 2, new e.2(this));
    AppMethodBeat.o(318444);
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    Object localObject = ((ah)aqX()).getAppId();
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { localObject });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.qSg != null)
    {
      MMToClientEvent.b((String)localObject, com.tencent.mm.plugin.appbrand.game.e.b.b.qSg);
      com.tencent.mm.plugin.appbrand.game.e.b.b.qSg = null;
    }
    ((com.tencent.mm.plugin.gamelive.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.b.class)).fIH();
    if (getAppId() != null)
    {
      localObject = (com.tencent.mm.plugin.gamelive.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.b.class);
      getContext();
      ((com.tencent.mm.plugin.gamelive.b)localObject).fA(getAppId(), ((ah)aqX()).getRuntime().qsh.eul);
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(318454);
    super.dispatchStart();
    if (cpb()) {
      ((com.tencent.mm.plugin.appbrand.page.a.h)aa(com.tencent.mm.plugin.appbrand.page.a.h.class)).aql();
    }
    AppMethodBeat.o(318454);
  }
  
  public final void onViewCreated(View paramView)
  {
    AppMethodBeat.i(318449);
    super.onViewCreated(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (cpb())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(ba.c.Dark_0);
      this.enB.addView(paramView, this.enB.indexOfChild(this.enE), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = bf.getStatusBarHeight(getContext()) + com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_actionbar_height);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.enB.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((ah)aqX()).ccO().aa(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.apg();
        if ((paramView.elq != null) && (paramView.elq.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((ah)aqX()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void aqb()
        {
          AppMethodBeat.i(318483);
          ((ah)e.this.aqX()).cEC().setVisibility(0);
          ((ah)e.this.aqX()).txT.setVisibility(0);
          AppMethodBeat.o(318483);
        }
        
        public final void cpc()
        {
          AppMethodBeat.i(318470);
          ((ah)e.this.aqX()).cEC().setVisibility(4);
          ((ah)e.this.aqX()).txT.setVisibility(4);
          AppMethodBeat.o(318470);
        }
      });
      AppMethodBeat.o(318449);
      return;
      label220:
      paramView = paramView.elq.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */