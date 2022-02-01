package com.tencent.mm.live.b;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends a
{
  private final b ngl;
  private int ngo;
  private final View niB;
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247366);
    this.ngl = paramb;
    this.niB = paramViewGroup.findViewById(b.e.live_visitor_close_btn_group);
    this.ngo = bf.bk(paramViewGroup.getContext());
    this.niB.setOnClickListener(new ae..ExternalSyntheticLambda0(this));
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(247366);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247366);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramViewGroup.getContext()));
      AppMethodBeat.o(247366);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247366);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bd.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  private static final void a(ae paramae, View paramView)
  {
    AppMethodBeat.i(247373);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVisitorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramae, "this$0");
    b.b.a(paramae.ngl, b.c.nck);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVisitorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247373);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247388);
    super.resume();
    int j = bf.bk(this.mJe.getContext());
    int i = j;
    if (j == 0) {
      i = bd.fromDPToPix(this.mJe.getContext(), 16);
    }
    this.ngo = i;
    AppMethodBeat.o(247388);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247400);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247400);
      return;
      tO(8);
      AppMethodBeat.o(247400);
      return;
      tO(0);
      AppMethodBeat.o(247400);
      return;
      if (this.ngl.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
        while (i != 0)
        {
          tO(4);
          AppMethodBeat.o(247400);
          return;
          i = 0;
        }
        tO(0);
        AppMethodBeat.o(247400);
        return;
        if ((this.mJe.getLayoutParams() != null) && ((this.mJe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.mJe.getLayoutParams();
            if (paramc == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(247400);
              throw paramc;
            }
          case 3: 
            paramc = this.mJe.getLayoutParams();
            if (paramc == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(247400);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = bd.fromDPToPix(this.mJe.getContext(), 16);
            this.mJe.requestLayout();
            AppMethodBeat.o(247400);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).rightMargin = this.ngo;
            this.mJe.requestLayout();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.ae
 * JD-Core Version:    0.7.0.1
 */