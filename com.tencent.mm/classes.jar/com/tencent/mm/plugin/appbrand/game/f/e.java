package com.tencent.mm.plugin.appbrand.game.f;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.game.page.WAGamePageViewContainerLayout;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;

public class e<PAGE extends ag>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a
{
  private MagicBrushView ltj = null;
  private b ltk = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean bDp()
  {
    AppMethodBeat.i(226623);
    boolean bool = bb.r(((ag)NN()).getRuntime());
    AppMethodBeat.o(226623);
    return bool;
  }
  
  public final MagicBrushView MQ()
  {
    return this.ltj;
  }
  
  public final void Nb()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void Ne()
  {
    AppMethodBeat.i(45189);
    if ((com.tencent.mm.plugin.appbrand.h.Uc(((ag)NN()).getAppId()) == h.d.kzP) && (this.ltk != null) && (this.ltk.bDk())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((ag)NN()).bsE(), b.a.lsW, 0);
    }
    super.Ne();
    AppMethodBeat.o(45189);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.nGe;
    this.ltk = new b(paramb, NP());
    if ((paramb != null) && (paramb.NyX))
    {
      Log.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.ltk;
      if ((paramb.lsZ == null) || (paramb.bDl() == null) || (Util.isNullOrNil(paramb.lsZ.Nzf)) || (!paramb.lsZ.NyX) || (paramb.ltb == null))
      {
        Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.bDm())
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
  
  public final MagicBrushView aH(Context paramContext)
  {
    AppMethodBeat.i(45188);
    long l1 = Util.currentTicks();
    boolean bool = ((Boolean)s.lrT.aLT()).booleanValue();
    Log.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc, use texture view: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext);; localObject = new com.tencent.mm.plugin.appbrand.game.f.a.b(paramContext))
    {
      this.ltj = new MagicBrushView(paramContext, (MagicBrushView.b)localObject);
      long l2 = Util.currentTicks();
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreateMagicBrushView, "", l1, l2);
      paramContext = this.ltj;
      AppMethodBeat.o(45188);
      return paramContext;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(226621);
    if (bDp())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(NP().ON().brandName);
      AppMethodBeat.o(226621);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(226621);
  }
  
  public final b bDj()
  {
    return this.ltk;
  }
  
  public final void ca(View paramView)
  {
    AppMethodBeat.i(226624);
    if (!af.p(((ag)NN()).getRuntime()))
    {
      AppMethodBeat.o(226624);
      return;
    }
    super.ca(paramView);
    AppMethodBeat.o(226624);
  }
  
  public final void cb(View paramView)
  {
    AppMethodBeat.i(226620);
    super.cb(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (bDp())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(2131099740);
      this.cwY.addView(paramView, this.cwY.indexOfChild(this.cxb), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = au.getStatusBarHeight(getContext()) + com.tencent.mm.cb.a.aH(getContext(), 2131165761);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.cwY.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((ag)NN()).bsE().S(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.Mg();
        if ((paramView.cvh != null) && (paramView.cvh.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((ag)NN()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void Na()
        {
          AppMethodBeat.i(226619);
          ((ag)e.this.NN()).bRi().setVisibility(0);
          ((ag)e.this.NN()).nrv.setVisibility(0);
          AppMethodBeat.o(226619);
        }
        
        public final void bDq()
        {
          AppMethodBeat.i(226618);
          ((ag)e.this.NN()).bRi().setVisibility(4);
          ((ag)e.this.NN()).nrv.setVisibility(4);
          AppMethodBeat.o(226618);
        }
      });
      AppMethodBeat.o(226620);
      return;
      label220:
      paramView = paramView.cvh.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    String str = ((ag)NN()).getAppId();
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { str });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.kYj != null)
    {
      MMToClientEvent.b(str, com.tencent.mm.plugin.appbrand.game.e.b.b.kYj);
      com.tencent.mm.plugin.appbrand.game.e.b.b.kYj = null;
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(226622);
    super.dispatchStart();
    if (bDp()) {
      ((com.tencent.mm.plugin.appbrand.page.a.h)S(com.tencent.mm.plugin.appbrand.page.a.h.class)).Nj();
    }
    AppMethodBeat.o(226622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */