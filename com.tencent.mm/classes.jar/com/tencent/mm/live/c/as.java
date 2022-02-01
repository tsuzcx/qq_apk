package com.tencent.mm.live.c;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as
  extends a
{
  private final b gVE;
  private final View gZA;
  private final View gZz;
  
  public as(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216193);
    this.gVE = paramb;
    this.gZz = paramViewGroup.findViewById(2131307770);
    this.gZA = paramViewGroup.findViewById(2131307772);
    if (!aoA())
    {
      paramb = this.gZz;
      p.g(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += ar.en(paramViewGroup.getContext());
    }
    AppMethodBeat.o(216193);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216192);
    p.h(paramc, "status");
    switch (at.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216192);
      return;
      nL(4);
      AppMethodBeat.o(216192);
      return;
      if (this.gVE.getLiveRole() != 1)
      {
        nL(4);
        AppMethodBeat.o(216192);
        return;
        nL(0);
        AppMethodBeat.o(216192);
        return;
        if (this.gVE.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
          {
            nL(4);
            AppMethodBeat.o(216192);
            return;
          }
          nL(0);
        }
      }
    }
  }
  
  public final Rect[] aph()
  {
    AppMethodBeat.i(216191);
    Object localObject1 = new int[2];
    this.gZz.getLocationOnScreen((int[])localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    int k = localObject1[0];
    Object localObject2 = this.gZz;
    p.g(localObject2, "shadowDown");
    int m = ((View)localObject2).getWidth();
    int n = localObject1[1];
    localObject2 = this.gZz;
    p.g(localObject2, "shadowDown");
    localObject2 = new Rect(i, j, k + m, n + ((View)localObject2).getHeight());
    this.gZA.getLocationOnScreen((int[])localObject1);
    i = localObject1[0];
    j = localObject1[1];
    k = localObject1[0];
    View localView = this.gZA;
    p.g(localView, "shadowUp");
    m = localView.getWidth();
    n = localObject1[1];
    localObject1 = this.gZA;
    p.g(localObject1, "shadowUp");
    localObject1 = new Rect(i, j, k + m, n + ((View)localObject1).getHeight());
    AppMethodBeat.o(216191);
    return new Rect[] { localObject2, localObject1 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.as
 * JD-Core Version:    0.7.0.1
 */