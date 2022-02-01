package com.tencent.mm.live.c;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as
  extends a
{
  private final b kCU;
  private final View kGR;
  private final View kGS;
  
  public as(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(196482);
    this.kCU = paramb;
    this.kGR = paramViewGroup.findViewById(b.e.live_shadow_down);
    this.kGS = paramViewGroup.findViewById(b.e.live_shadow_up);
    if (!isLandscape())
    {
      paramb = this.kGR;
      p.j(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += ax.aB(paramViewGroup.getContext());
    }
    AppMethodBeat.o(196482);
  }
  
  public final Rect[] aPF()
  {
    AppMethodBeat.i(196475);
    Object localObject1 = new int[2];
    this.kGR.getLocationOnScreen((int[])localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    int k = localObject1[0];
    Object localObject2 = this.kGR;
    p.j(localObject2, "shadowDown");
    int m = ((View)localObject2).getWidth();
    int n = localObject1[1];
    localObject2 = this.kGR;
    p.j(localObject2, "shadowDown");
    localObject2 = new Rect(i, j, k + m, n + ((View)localObject2).getHeight());
    this.kGS.getLocationOnScreen((int[])localObject1);
    i = localObject1[0];
    j = localObject1[1];
    k = localObject1[0];
    View localView = this.kGS;
    p.j(localView, "shadowUp");
    m = localView.getWidth();
    n = localObject1[1];
    localObject1 = this.kGS;
    p.j(localObject1, "shadowUp");
    localObject1 = new Rect(i, j, k + m, n + ((View)localObject1).getHeight());
    AppMethodBeat.o(196475);
    return new Rect[] { localObject2, localObject1 };
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(196480);
    p.k(paramc, "status");
    switch (at.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196480);
      return;
      tU(4);
      AppMethodBeat.o(196480);
      return;
      if (this.kCU.getLiveRole() != 1)
      {
        tU(4);
        AppMethodBeat.o(196480);
        return;
        tU(0);
        AppMethodBeat.o(196480);
        return;
        if (this.kCU.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
          {
            tU(4);
            AppMethodBeat.o(196480);
            return;
          }
          tU(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.as
 * JD-Core Version:    0.7.0.1
 */