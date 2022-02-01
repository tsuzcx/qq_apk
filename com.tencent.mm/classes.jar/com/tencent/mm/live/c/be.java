package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class be
  extends a
{
  private int gVC;
  final b gVE;
  private final View gYh;
  
  public be(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216250);
    this.gVE = paramb;
    this.gYh = paramViewGroup.findViewById(2131307836);
    this.gVC = ar.en(paramViewGroup.getContext());
    this.gYh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216246);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b.a(this.gZZ.gVE, b.c.gUd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216246);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (aoA())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216250);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216250);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.en(paramViewGroup.getContext()));
      AppMethodBeat.o(216250);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216250);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aq.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216249);
    p.h(paramc, "status");
    switch (bf.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216249);
      return;
      nL(8);
      AppMethodBeat.o(216249);
      return;
      nL(0);
      AppMethodBeat.o(216249);
      return;
      if (this.gVE.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nL(4);
          AppMethodBeat.o(216249);
          return;
        }
        nL(0);
        AppMethodBeat.o(216249);
        return;
        if ((this.gJt.getLayoutParams() != null) && ((this.gJt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.gJt.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(216249);
              throw paramc;
            }
          case 3: 
            paramc = this.gJt.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(216249);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = aq.fromDPToPix(this.gJt.getContext(), 16);
            this.gJt.requestLayout();
            AppMethodBeat.o(216249);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = this.gVC;
            this.gJt.requestLayout();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(216248);
    super.resume();
    int j = ar.en(this.gJt.getContext());
    int i = j;
    if (j == 0) {
      i = aq.fromDPToPix(this.gJt.getContext(), 16);
    }
    this.gVC = i;
    AppMethodBeat.o(216248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.be
 * JD-Core Version:    0.7.0.1
 */