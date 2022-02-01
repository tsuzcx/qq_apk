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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class be
  extends a
{
  private int gST;
  final b gSV;
  private final View gVy;
  
  public be(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212624);
    this.gSV = paramb;
    this.gVy = paramViewGroup.findViewById(2131307836);
    this.gST = ar.ej(paramViewGroup.getContext());
    this.gVy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212620);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b.a(this.gXn.gSV, b.c.gRv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212620);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (aol())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212624);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212624);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.ej(paramViewGroup.getContext()));
      AppMethodBeat.o(212624);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212624);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aq.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212623);
    p.h(paramc, "status");
    switch (bf.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212623);
      return;
      nI(8);
      AppMethodBeat.o(212623);
      return;
      nI(0);
      AppMethodBeat.o(212623);
      return;
      if (this.gSV.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nI(4);
          AppMethodBeat.o(212623);
          return;
        }
        nI(0);
        AppMethodBeat.o(212623);
        return;
        if ((this.gGK.getLayoutParams() != null) && ((this.gGK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.gGK.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(212623);
              throw paramc;
            }
          case 3: 
            paramc = this.gGK.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(212623);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = aq.fromDPToPix(this.gGK.getContext(), 16);
            this.gGK.requestLayout();
            AppMethodBeat.o(212623);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = this.gST;
            this.gGK.requestLayout();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(212622);
    super.resume();
    int j = ar.ej(this.gGK.getContext());
    int i = j;
    if (j == 0) {
      i = aq.fromDPToPix(this.gGK.getContext(), 16);
    }
    this.gST = i;
    AppMethodBeat.o(212622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.be
 * JD-Core Version:    0.7.0.1
 */