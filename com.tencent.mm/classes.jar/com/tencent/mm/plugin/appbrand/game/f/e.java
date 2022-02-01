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
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.r.a.d;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class e<PAGE extends com.tencent.mm.plugin.appbrand.page.ae>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a
{
  private MagicBrushView jRW = null;
  private b jRX = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean bdO()
  {
    AppMethodBeat.i(186526);
    boolean bool = ao.w(((com.tencent.mm.plugin.appbrand.page.ae)CM()).getRuntime());
    AppMethodBeat.o(186526);
    return bool;
  }
  
  public final MagicBrushView BR()
  {
    return this.jRW;
  }
  
  public final void Cc()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void Cg()
  {
    AppMethodBeat.i(45189);
    if ((g.Hg(((com.tencent.mm.plugin.appbrand.page.ae)CM()).getAppId()) == g.d.jdc) && (this.jRX != null) && (this.jRX.bdJ())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((com.tencent.mm.plugin.appbrand.page.ae)CM()).aTU(), b.a.jRJ, 0);
    }
    super.Cg();
    AppMethodBeat.o(45189);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.lQC;
    this.jRX = new b(paramb, CO());
    if ((paramb != null) && (paramb.GgA))
    {
      ac.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.jRX;
      if ((paramb.jRM == null) || (paramb.bdK() == null) || (bs.isNullOrNil(paramb.jRM.GgI)) || (!paramb.jRM.GgA) || (paramb.jRO == null))
      {
        ac.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.bdL())
      {
        ac.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: running, trigger send event after 1 sec");
        com.tencent.mm.sdk.platformtools.ap.n(new b.1(paramb), 1000L);
        AppMethodBeat.o(45191);
        return;
      }
      ac.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: not running!");
      AppMethodBeat.o(45191);
      return;
    }
    ac.w("MicroMsg.WAGamePageViewRendererWC", "hy: no server config or do not need sample. do not do anything");
    AppMethodBeat.o(45191);
  }
  
  public final MagicBrushView ax(Context paramContext)
  {
    AppMethodBeat.i(45188);
    boolean bool = ((Boolean)n.jQG.aqp()).booleanValue();
    ac.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc, use texture view: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext);; localObject = new com.tencent.mm.plugin.appbrand.game.f.a.b(paramContext))
    {
      this.jRW = new MagicBrushView(paramContext, (MagicBrushView.b)localObject);
      paramContext = this.jRW;
      AppMethodBeat.o(45188);
      return paramContext;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(186524);
    if (bdO())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(CO().DC().ddh);
      AppMethodBeat.o(186524);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(186524);
  }
  
  public final b bdI()
  {
    return this.jRX;
  }
  
  public final void cl(View paramView)
  {
    AppMethodBeat.i(186527);
    if (!com.tencent.mm.plugin.appbrand.ae.v(((com.tencent.mm.plugin.appbrand.page.ae)CM()).getRuntime()))
    {
      AppMethodBeat.o(186527);
      return;
    }
    super.cl(paramView);
    AppMethodBeat.o(186527);
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(186523);
    super.cm(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (bdO())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(2131099726);
      this.caK.addView(paramView, this.caK.indexOfChild(this.caN), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = com.tencent.mm.ui.ap.ji(getContext()) + com.tencent.mm.cc.a.av(getContext(), 2131165742);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.caK.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.page.ae)CM()).aTU().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.Bi();
        if ((paramView.bYR != null) && (paramView.bYR.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.page.ae)CM()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void Cb()
        {
          AppMethodBeat.i(186522);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.CM()).bqy().setVisibility(0);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.CM()).lDc.setVisibility(0);
          AppMethodBeat.o(186522);
        }
        
        public final void bdP()
        {
          AppMethodBeat.i(186521);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.CM()).bqy().setVisibility(4);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.CM()).lDc.setVisibility(4);
          AppMethodBeat.o(186521);
        }
      });
      AppMethodBeat.o(186523);
      return;
      label220:
      paramView = paramView.bYR.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    String str = ((com.tencent.mm.plugin.appbrand.page.ae)CM()).getAppId();
    ac.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { str });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.jya != null)
    {
      MMToClientEvent.b(str, com.tencent.mm.plugin.appbrand.game.e.b.b.jya);
      com.tencent.mm.plugin.appbrand.game.e.b.b.jya = null;
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(186525);
    super.dispatchStart();
    if (bdO()) {
      ((com.tencent.mm.plugin.appbrand.page.b.h)Q(com.tencent.mm.plugin.appbrand.page.b.h.class)).Cl();
    }
    AppMethodBeat.o(186525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */