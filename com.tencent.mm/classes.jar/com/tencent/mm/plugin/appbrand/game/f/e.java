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
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.s.a.d;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ap;

public class e<PAGE extends com.tencent.mm.plugin.appbrand.page.ae>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a
{
  private MagicBrushView jrE = null;
  private b jrF = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean aWQ()
  {
    AppMethodBeat.i(195774);
    boolean bool = com.tencent.mm.plugin.appbrand.ao.w(((com.tencent.mm.plugin.appbrand.page.ae)Dj()).getRuntime());
    AppMethodBeat.o(195774);
    return bool;
  }
  
  public final void CC()
  {
    AppMethodBeat.i(45189);
    if ((g.Dd(((com.tencent.mm.plugin.appbrand.page.ae)Dj()).getAppId()) == g.d.iDc) && (this.jrF != null) && (this.jrF.aWL())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((com.tencent.mm.plugin.appbrand.page.ae)Dj()).aNe(), b.a.jrr, 0);
    }
    super.CC();
    AppMethodBeat.o(45189);
  }
  
  public final MagicBrushView Cn()
  {
    return this.jrE;
  }
  
  public final void Cy()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.loC;
    this.jrF = new b(paramb, Dl());
    if ((paramb != null) && (paramb.EJo))
    {
      ad.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.jrF;
      if ((paramb.jru == null) || (paramb.aWM() == null) || (bt.isNullOrNil(paramb.jru.EJw)) || (!paramb.jru.EJo) || (paramb.jrw == null))
      {
        ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.aWN())
      {
        ad.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: running, trigger send event after 1 sec");
        aq.n(new b.1(paramb), 1000L);
        AppMethodBeat.o(45191);
        return;
      }
      ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: not running!");
      AppMethodBeat.o(45191);
      return;
    }
    ad.w("MicroMsg.WAGamePageViewRendererWC", "hy: no server config or do not need sample. do not do anything");
    AppMethodBeat.o(45191);
  }
  
  public final b aWK()
  {
    return this.jrF;
  }
  
  public final MagicBrushView aw(Context paramContext)
  {
    AppMethodBeat.i(45188);
    boolean bool = ((Boolean)l.jqp.ajp()).booleanValue();
    ad.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc, use texture view: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext);; localObject = new com.tencent.mm.plugin.appbrand.game.f.a.b(paramContext))
    {
      this.jrE = new MagicBrushView(paramContext, (MagicBrushView.b)localObject);
      paramContext = this.jrE;
      AppMethodBeat.o(45188);
      return paramContext;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(195772);
    if (aWQ())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(Dl().DZ().dfM);
      AppMethodBeat.o(195772);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(195772);
  }
  
  public final void cl(View paramView)
  {
    AppMethodBeat.i(195775);
    if (!com.tencent.mm.plugin.appbrand.ae.v(((com.tencent.mm.plugin.appbrand.page.ae)Dj()).getRuntime()))
    {
      AppMethodBeat.o(195775);
      return;
    }
    super.cl(paramView);
    AppMethodBeat.o(195775);
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(195771);
    super.cm(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (aWQ())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(2131099726);
      this.cdN.addView(paramView, this.cdN.indexOfChild(this.cdQ), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = ap.iX(getContext()) + com.tencent.mm.cd.a.ap(getContext(), 2131165742);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.cdN.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.page.ae)Dj()).aNe().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.BE();
        if ((paramView.cbU != null) && (paramView.cbU.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.page.ae)Dj()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.s.a.b()
      {
        public final void Cx()
        {
          AppMethodBeat.i(195770);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.Dj()).bjH().setVisibility(0);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.Dj()).lbD.setVisibility(0);
          AppMethodBeat.o(195770);
        }
        
        public final void aWR()
        {
          AppMethodBeat.i(195769);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.Dj()).bjH().setVisibility(4);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.Dj()).lbD.setVisibility(4);
          AppMethodBeat.o(195769);
        }
      });
      AppMethodBeat.o(195771);
      return;
      label220:
      paramView = paramView.cbU.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    String str = ((com.tencent.mm.plugin.appbrand.page.ae)Dj()).getAppId();
    ad.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { str });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.iXK != null)
    {
      MMToClientEvent.b(str, com.tencent.mm.plugin.appbrand.game.e.b.b.iXK);
      com.tencent.mm.plugin.appbrand.game.e.b.b.iXK = null;
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(195773);
    super.dispatchStart();
    if (aWQ()) {
      ((com.tencent.mm.plugin.appbrand.page.b.h)Q(com.tencent.mm.plugin.appbrand.page.b.h.class)).CH();
    }
    AppMethodBeat.o(195773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */