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
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.game.a.q;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ai;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.sdk.platformtools.bu;

public class e<PAGE extends ad>
  extends com.tencent.luggage.game.page.h<PAGE>
  implements a
{
  private MagicBrushView kpA = null;
  private b kpB = null;
  
  public e(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private boolean bia()
  {
    AppMethodBeat.i(222351);
    boolean bool = aq.o(((ad)Eo()).getRuntime());
    AppMethodBeat.o(222351);
    return bool;
  }
  
  public final void DE()
  {
    AppMethodBeat.i(45192);
    b(a.class, this);
    AppMethodBeat.o(45192);
  }
  
  public final void DI()
  {
    AppMethodBeat.i(45189);
    if ((com.tencent.mm.plugin.appbrand.h.KU(((ad)Eo()).getAppId()) == h.d.jzh) && (this.kpB != null) && (this.kpB.bhV())) {
      new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((ad)Eo()).aXz(), b.a.kpn, 0);
    }
    super.DI();
    AppMethodBeat.o(45189);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(45191);
    paramb = paramb.mvq;
    this.kpB = new b(paramb, Eq());
    if ((paramb != null) && (paramb.IlU))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
      paramb = this.kpB;
      if ((paramb.kpq == null) || (paramb.bhW() == null) || (bu.isNullOrNil(paramb.kpq.Imc)) || (!paramb.kpq.IlU) || (paramb.kps == null))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
        AppMethodBeat.o(45191);
        return;
      }
      if (paramb.bhX())
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: running, trigger send event after 1 sec");
        com.tencent.mm.sdk.platformtools.ar.o(new b.1(paramb), 1000L);
        AppMethodBeat.o(45191);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: not running!");
      AppMethodBeat.o(45191);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WAGamePageViewRendererWC", "hy: no server config or do not need sample. do not do anything");
    AppMethodBeat.o(45191);
  }
  
  public final MagicBrushView ay(Context paramContext)
  {
    AppMethodBeat.i(45188);
    boolean bool = ((Boolean)q.kol.att()).booleanValue();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc, use texture view: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (Object localObject = new com.tencent.mm.plugin.appbrand.game.f.a.c(paramContext);; localObject = new com.tencent.mm.plugin.appbrand.game.f.a.b(paramContext))
    {
      this.kpA = new MagicBrushView(paramContext, (MagicBrushView.b)localObject);
      paramContext = this.kpA;
      AppMethodBeat.o(45188);
      return paramContext;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(222349);
    if (bia())
    {
      paramb.setFullscreenMode(false);
      paramb.setBackgroundAlpha(0.0D);
      paramb.setForegroundColor(-1);
      paramb.setMainTitle(Eq().Fg().dpI);
      AppMethodBeat.o(222349);
      return;
    }
    super.b(paramb);
    AppMethodBeat.o(222349);
  }
  
  public final b bhU()
  {
    return this.kpB;
  }
  
  public final void cl(View paramView)
  {
    AppMethodBeat.i(222352);
    if (!com.tencent.mm.plugin.appbrand.ae.n(((ad)Eo()).getRuntime()))
    {
      AppMethodBeat.o(222352);
      return;
    }
    super.cl(paramView);
    AppMethodBeat.o(222352);
  }
  
  public final void cm(View paramView)
  {
    AppMethodBeat.i(222348);
    super.cm(paramView);
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (bia())
    {
      paramView = new View(getContext());
      paramView.setBackgroundResource(2131099726);
      this.cld.addView(paramView, this.cld.indexOfChild(this.clg), new FrameLayout.LayoutParams(-1, -1));
      paramView = new View(getContext());
      paramView.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -2147483648, 0 }));
      i = com.tencent.mm.ui.ar.jN(getContext()) + com.tencent.mm.cb.a.ay(getContext(), 2131165742);
      localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      this.cld.addView(paramView, localLayoutParams);
      paramView = (com.tencent.luggage.game.d.a.a.b)((ad)Eo()).aXz().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (paramView != null)
      {
        paramView = paramView.CK();
        if ((paramView.cjl != null) && (paramView.cjl.getView() != null)) {
          break label220;
        }
      }
    }
    for (;;)
    {
      ((ad)Eo()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void DD()
        {
          AppMethodBeat.i(222347);
          ((ad)e.this.Eo()).bvi().setVisibility(0);
          ((ad)e.this.Eo()).mgW.setVisibility(0);
          AppMethodBeat.o(222347);
        }
        
        public final void bib()
        {
          AppMethodBeat.i(222346);
          ((ad)e.this.Eo()).bvi().setVisibility(4);
          ((ad)e.this.Eo()).mgW.setVisibility(4);
          AppMethodBeat.o(222346);
        }
      });
      AppMethodBeat.o(222348);
      return;
      label220:
      paramView = paramView.cjl.getView();
      localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 52;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(45190);
    String str = ((ad)Eo()).getAppId();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", new Object[] { str });
    if (com.tencent.mm.plugin.appbrand.game.e.b.b.jVn != null)
    {
      MMToClientEvent.b(str, com.tencent.mm.plugin.appbrand.game.e.b.b.jVn);
      com.tencent.mm.plugin.appbrand.game.e.b.b.jVn = null;
    }
    super.dispatchDestroy();
    AppMethodBeat.o(45190);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(222350);
    super.dispatchStart();
    if (bia()) {
      ((com.tencent.mm.plugin.appbrand.page.a.h)Q(com.tencent.mm.plugin.appbrand.page.a.h.class)).DN();
    }
    AppMethodBeat.o(222350);
  }
  
  public final MagicBrushView getMagicBrushView()
  {
    return this.kpA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.e
 * JD-Core Version:    0.7.0.1
 */