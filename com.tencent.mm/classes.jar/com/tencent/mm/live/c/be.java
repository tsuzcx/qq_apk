package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class be
  extends a
{
  private final View gBO;
  private int gzi;
  final b gzk;
  
  public be(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190334);
    this.gzk = paramb;
    this.gBO = paramViewGroup.findViewById(2131307836);
    this.gzi = ap.ej(paramViewGroup.getContext());
    this.gBO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190330);
        b.b.a(this.gDD.gzk, b.c.gxK);
        AppMethodBeat.o(190330);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (aly())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(190334);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190334);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ap.ej(paramViewGroup.getContext()));
      AppMethodBeat.o(190334);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190334);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ao.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190333);
    k.h(paramc, "status");
    switch (bf.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190333);
      return;
      nj(8);
      AppMethodBeat.o(190333);
      return;
      nj(0);
      AppMethodBeat.o(190333);
      return;
      if (this.gzk.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nj(4);
          AppMethodBeat.o(190333);
          return;
        }
        nj(0);
        AppMethodBeat.o(190333);
        return;
        if ((this.gnb.getLayoutParams() != null) && ((this.gnb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.gnb.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(190333);
              throw paramc;
            }
          case 3: 
            paramc = this.gnb.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(190333);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = ao.fromDPToPix(this.gnb.getContext(), 16);
            this.gnb.requestLayout();
            AppMethodBeat.o(190333);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = this.gzi;
            this.gnb.requestLayout();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(190332);
    super.resume();
    int j = ap.ej(this.gnb.getContext());
    int i = j;
    if (j == 0) {
      i = ao.fromDPToPix(this.gnb.getContext(), 16);
    }
    this.gzi = i;
    AppMethodBeat.o(190332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.be
 * JD-Core Version:    0.7.0.1
 */