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
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.game.a.q;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.r.a.d;
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ar;

public class e<PAGE extends com.tencent.mm.plugin.appbrand.page.ae>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a
{
  private MagicBrushView kmk = null;
  private b kml = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean bhs()
  {
    AppMethodBeat.i(188225);
    boolean bool = ap.n(((com.tencent.mm.plugin.appbrand.page.ae)El()).getRuntime());
    AppMethodBeat.o(188225);
    return bool;
  }
  
  public final void DB()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void DF()
  {
    AppMethodBeat.i(45189);
    if ((g.Kv(((com.tencent.mm.plugin.appbrand.page.ae)El()).getAppId()) == g.d.jwl) && (this.kml != null) && (this.kml.bhn())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((com.tencent.mm.plugin.appbrand.page.ae)El()).aXe(), b.a.klX, 0);
    }
    super.DF();
    AppMethodBeat.o(45189);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.mqs;
    this.kml = new b(paramb, En());
    if ((paramb != null) && (paramb.HRN))
    {
      ad.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.kml;
      if ((paramb.kma == null) || (paramb.bho() == null) || (bt.isNullOrNil(paramb.kma.HRV)) || (!paramb.kma.HRN) || (paramb.kmc == null))
      {
        ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.bhp())
      {
        ad.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: running, trigger send event after 1 sec");
        aq.o(new b.1(paramb), 1000L);
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
  
  public final MagicBrushView ax(Context paramContext)
  {
    AppMethodBeat.i(45188);
    boolean bool = ((Boolean)q.kkV.ate()).booleanValue();
    ad.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc, use texture view: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext);; localObject = new com.tencent.mm.plugin.appbrand.game.f.a.b(paramContext))
    {
      this.kmk = new MagicBrushView(paramContext, (MagicBrushView.b)localObject);
      paramContext = this.kmk;
      AppMethodBeat.o(45188);
      return paramContext;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(188223);
    if (bhs())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(En().Fb().doD);
      AppMethodBeat.o(188223);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(188223);
  }
  
  public final b bhm()
  {
    return this.kml;
  }
  
  public final void cl(View paramView)
  {
    AppMethodBeat.i(188226);
    if (!com.tencent.mm.plugin.appbrand.ae.m(((com.tencent.mm.plugin.appbrand.page.ae)El()).getRuntime()))
    {
      AppMethodBeat.o(188226);
      return;
    }
    super.cl(paramView);
    AppMethodBeat.o(188226);
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(188222);
    super.cm(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (bhs())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(2131099726);
      this.clb.addView(paramView, this.clb.indexOfChild(this.cle), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = ar.jG(getContext()) + com.tencent.mm.cc.a.ay(getContext(), 2131165742);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.clb.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((com.tencent.mm.plugin.appbrand.page.ae)El()).aXe().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.CH();
        if ((paramView.cjj != null) && (paramView.cjj.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.page.ae)El()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void DA()
        {
          AppMethodBeat.i(188221);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.El()).bux().setVisibility(0);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.El()).mcE.setVisibility(0);
          AppMethodBeat.o(188221);
        }
        
        public final void bht()
        {
          AppMethodBeat.i(188220);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.El()).bux().setVisibility(4);
          ((com.tencent.mm.plugin.appbrand.page.ae)e.this.El()).mcE.setVisibility(4);
          AppMethodBeat.o(188220);
        }
      });
      AppMethodBeat.o(188222);
      return;
      label220:
      paramView = paramView.cjj.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    String str = ((com.tencent.mm.plugin.appbrand.page.ae)El()).getAppId();
    ad.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { str });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.jRW != null)
    {
      MMToClientEvent.b(str, com.tencent.mm.plugin.appbrand.game.e.b.b.jRW);
      com.tencent.mm.plugin.appbrand.game.e.b.b.jRW = null;
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(188224);
    super.dispatchStart();
    if (bhs()) {
      ((com.tencent.mm.plugin.appbrand.page.b.h)Q(com.tencent.mm.plugin.appbrand.page.b.h.class)).DK();
    }
    AppMethodBeat.o(188224);
  }
  
  public final MagicBrushView getMagicBrushView()
  {
    return this.kmk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */