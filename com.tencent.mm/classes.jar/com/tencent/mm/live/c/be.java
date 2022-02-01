package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class be
  extends a
{
  private int hOw;
  final b hOy;
  private final View hRd;
  
  public be(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208211);
    this.hOy = paramb;
    this.hRd = paramViewGroup.findViewById(2131303624);
    this.hOw = au.aD(paramViewGroup.getContext());
    this.hRd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.hSU.hOy, b.c.hLC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208207);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208211);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(208211);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramViewGroup.getContext()));
      AppMethodBeat.o(208211);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(208211);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(at.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(208209);
    super.resume();
    int j = au.aD(this.hwr.getContext());
    int i = j;
    if (j == 0) {
      i = at.fromDPToPix(this.hwr.getContext(), 16);
    }
    this.hOw = i;
    AppMethodBeat.o(208209);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208210);
    p.h(paramc, "status");
    switch (bf.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208210);
      return;
      rg(8);
      AppMethodBeat.o(208210);
      return;
      rg(0);
      AppMethodBeat.o(208210);
      return;
      if (this.hOy.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          rg(4);
          AppMethodBeat.o(208210);
          return;
        }
        rg(0);
        AppMethodBeat.o(208210);
        return;
        if ((this.hwr.getLayoutParams() != null) && ((this.hwr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.hwr.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(208210);
              throw paramc;
            }
          case 3: 
            paramc = this.hwr.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(208210);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = at.fromDPToPix(this.hwr.getContext(), 16);
            this.hwr.requestLayout();
            AppMethodBeat.o(208210);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = this.hOw;
            this.hwr.requestLayout();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.be
 * JD-Core Version:    0.7.0.1
 */