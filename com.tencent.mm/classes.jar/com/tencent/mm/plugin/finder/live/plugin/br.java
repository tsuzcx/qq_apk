package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.report.live.s.at;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "canClearScreen", "", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class br
  extends d
{
  private int hOw;
  final com.tencent.mm.live.c.b hOy;
  private final View hRd;
  
  public br(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247134);
    this.hOy = paramb;
    this.hRd = paramViewGroup.findViewById(2131303624);
    this.hOw = au.aD(paramViewGroup.getContext());
    this.hRd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247130);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.uve.hOy, b.c.hLC);
        com.tencent.mm.plugin.finder.report.live.m.vli.a(s.at.vrK);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247130);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this, false);
      paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this);
      AppMethodBeat.o(247134);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247134);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramViewGroup.getContext()));
      continue;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247134);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(at.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247132);
    super.resume();
    int j = au.aD(this.hwr.getContext());
    int i = j;
    if (j == 0) {
      i = at.fromDPToPix(this.hwr.getContext(), 16);
    }
    this.hOw = i;
    AppMethodBeat.o(247132);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247133);
    p.h(paramc, "status");
    switch (bs.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247133);
      return;
      rg(8);
      AppMethodBeat.o(247133);
      return;
      rg(0);
      AppMethodBeat.o(247133);
      return;
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.br
 * JD-Core Version:    0.7.0.1
 */