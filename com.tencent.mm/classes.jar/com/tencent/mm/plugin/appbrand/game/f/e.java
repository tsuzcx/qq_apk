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
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.game.g.b.f;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.gamelive.c.e;
import com.tencent.mm.protocal.protobuf.foo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;

public class e<PAGE extends ah>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a, c.e
{
  private MagicBrushView oog = null;
  private b ooh = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean bON()
  {
    AppMethodBeat.i(272585);
    boolean bool = bd.s(((ah)QK()).getRuntime());
    AppMethodBeat.o(272585);
    return bool;
  }
  
  public final MagicBrushView PI()
  {
    return this.oog;
  }
  
  public final void PT()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void PV()
  {
    AppMethodBeat.i(272582);
    super.PV();
    if (getAppId() != null) {
      ((com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.c.class)).a(QM(), getContext(), getAppId(), ((ah)QK()).getRuntime().ntz.cBI);
    }
    AppMethodBeat.o(272582);
  }
  
  public final void PW()
  {
    AppMethodBeat.i(45189);
    if ((k.abM(((ah)QK()).getAppId()) == k.d.ntb) && (this.ooh != null) && (this.ooh.bOH())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((ah)QK()).bDA(), b.a.onT, 0);
    }
    super.PW();
    if (getAppId() != null) {
      ((com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.c.class)).l(getContext(), getAppId(), ((ah)QK()).getRuntime().ntz.cBI);
    }
    AppMethodBeat.o(45189);
  }
  
  public final void Z(Runnable paramRunnable)
  {
    AppMethodBeat.i(272578);
    this.oog.getMagicBrush().UJ();
    this.oog.a(false, 0, new e.3(this, paramRunnable));
    AppMethodBeat.o(272578);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.qIq;
    this.ooh = new b(paramb, QM());
    if ((paramb != null) && (paramb.UMB))
    {
      Log.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.ooh;
      if ((paramb.onW == null) || (paramb.bOI() == null) || (Util.isNullOrNil(paramb.onW.UMJ)) || (!paramb.onW.UMB) || (paramb.onY == null))
      {
        Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.bOJ())
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
  
  public final MagicBrushView aE(Context paramContext)
  {
    AppMethodBeat.i(45188);
    long l1 = Util.currentTicks();
    this.oog = new MagicBrushView(paramContext, new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext));
    long l2 = Util.currentTicks();
    com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreateMagicBrushView, "", l1, l2);
    ((com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.c.class)).a(this);
    paramContext = this.oog;
    AppMethodBeat.o(45188);
    return paramContext;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(272580);
    if (bON())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(QM().Sk().fzM);
      AppMethodBeat.o(272580);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(272580);
  }
  
  public final b bOG()
  {
    return this.ooh;
  }
  
  public final void bOM()
  {
    AppMethodBeat.i(272577);
    com.tencent.mm.plugin.appbrand.game.g.b localb = com.tencent.mm.plugin.appbrand.game.g.b.agF(getAppId());
    if (localb != null)
    {
      Log.i("MicroMsg.WAGamePageViewRendererWC", "stop running recorder");
      localb.g(new com.tencent.mm.plugin.appbrand.game.g.d() {});
      new com.tencent.mm.plugin.appbrand.game.e.a.a().a(((ah)QK()).bDA(), 112, "game is living, not support record now");
    }
    this.oog.a(false, 2, new kotlin.g.a.b() {});
    AppMethodBeat.o(272577);
  }
  
  public final void cs(View paramView)
  {
    AppMethodBeat.i(272586);
    if (!ai.q(((ah)QK()).getRuntime()))
    {
      AppMethodBeat.o(272586);
      return;
    }
    super.cs(paramView);
    AppMethodBeat.o(272586);
  }
  
  public final void ct(View paramView)
  {
    AppMethodBeat.i(272579);
    super.ct(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (bON())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(au.c.Dark_0);
      this.cvD.addView(paramView, this.cvD.indexOfChild(this.cvG), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = ax.getStatusBarHeight(getContext()) + com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_actionbar_height);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.cvD.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((ah)QK()).bDA().R(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.OY();
        if ((paramView.ctv != null) && (paramView.ctv.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((ah)QK()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void PS()
        {
          AppMethodBeat.i(249811);
          ((ah)e.this.QK()).cdY().setVisibility(0);
          ((ah)e.this.QK()).qtn.setVisibility(0);
          AppMethodBeat.o(249811);
        }
        
        public final void bOO()
        {
          AppMethodBeat.i(249810);
          ((ah)e.this.QK()).cdY().setVisibility(4);
          ((ah)e.this.QK()).qtn.setVisibility(4);
          AppMethodBeat.o(249810);
        }
      });
      AppMethodBeat.o(272579);
      return;
      label220:
      paramView = paramView.ctv.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    Object localObject = ((ah)QK()).getAppId();
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { localObject });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.nSv != null)
    {
      MMToClientEvent.b((String)localObject, com.tencent.mm.plugin.appbrand.game.e.b.b.nSv);
      com.tencent.mm.plugin.appbrand.game.e.b.b.nSv = null;
    }
    ((com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.c.class)).eAG();
    if (getAppId() != null)
    {
      localObject = (com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.c.class);
      getContext();
      ((com.tencent.mm.plugin.gamelive.c)localObject).eK(getAppId(), ((ah)QK()).getRuntime().ntz.cBI);
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(272581);
    super.dispatchStart();
    if (bON()) {
      ((com.tencent.mm.plugin.appbrand.page.a.h)R(com.tencent.mm.plugin.appbrand.page.a.h.class)).Qb();
    }
    AppMethodBeat.o(272581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */