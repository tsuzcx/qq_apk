package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class be
  extends a
{
  private int kCS;
  private final b kCU;
  private final View kFA;
  
  public be(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(194427);
    this.kCU = paramb;
    this.kFA = paramViewGroup.findViewById(b.e.live_visitor_close_btn_group);
    this.kCS = ax.aB(paramViewGroup.getContext());
    this.kFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191905);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.b.a(be.a(this.kHr), b.c.kyV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191905);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(194427);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(194427);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramViewGroup.getContext()));
      AppMethodBeat.o(194427);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(194427);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aw.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(194425);
    super.resume();
    int j = ax.aB(this.kiF.getContext());
    int i = j;
    if (j == 0) {
      i = aw.fromDPToPix(this.kiF.getContext(), 16);
    }
    this.kCS = i;
    AppMethodBeat.o(194425);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(194426);
    p.k(paramc, "status");
    switch (bf.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194426);
      return;
      tU(8);
      AppMethodBeat.o(194426);
      return;
      tU(0);
      AppMethodBeat.o(194426);
      return;
      if (this.kCU.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          tU(4);
          AppMethodBeat.o(194426);
          return;
        }
        tU(0);
        AppMethodBeat.o(194426);
        return;
        if ((this.kiF.getLayoutParams() != null) && ((this.kiF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.kiF.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(194426);
              throw paramc;
            }
          case 3: 
            paramc = this.kiF.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(194426);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = aw.fromDPToPix(this.kiF.getContext(), 16);
            this.kiF.requestLayout();
            AppMethodBeat.o(194426);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = this.kCS;
            this.kiF.requestLayout();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.be
 * JD-Core Version:    0.7.0.1
 */