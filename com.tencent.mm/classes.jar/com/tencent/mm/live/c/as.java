package com.tencent.mm.live.c;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as
  extends a
{
  private final b hOy;
  private final View hSu;
  private final View hSv;
  
  public as(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208155);
    this.hOy = paramb;
    this.hSu = paramViewGroup.findViewById(2131303556);
    this.hSv = paramViewGroup.findViewById(2131303558);
    if (!isLandscape())
    {
      paramb = this.hSu;
      p.g(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += au.aD(paramViewGroup.getContext());
    }
    AppMethodBeat.o(208155);
  }
  
  public final Rect[] aHH()
  {
    AppMethodBeat.i(208153);
    Object localObject1 = new int[2];
    this.hSu.getLocationOnScreen((int[])localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    int k = localObject1[0];
    Object localObject2 = this.hSu;
    p.g(localObject2, "shadowDown");
    int m = ((View)localObject2).getWidth();
    int n = localObject1[1];
    localObject2 = this.hSu;
    p.g(localObject2, "shadowDown");
    localObject2 = new Rect(i, j, k + m, n + ((View)localObject2).getHeight());
    this.hSv.getLocationOnScreen((int[])localObject1);
    i = localObject1[0];
    j = localObject1[1];
    k = localObject1[0];
    View localView = this.hSv;
    p.g(localView, "shadowUp");
    m = localView.getWidth();
    n = localObject1[1];
    localObject1 = this.hSv;
    p.g(localObject1, "shadowUp");
    localObject1 = new Rect(i, j, k + m, n + ((View)localObject1).getHeight());
    AppMethodBeat.o(208153);
    return new Rect[] { localObject2, localObject1 };
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208154);
    p.h(paramc, "status");
    switch (at.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208154);
      return;
      rg(4);
      AppMethodBeat.o(208154);
      return;
      if (this.hOy.getLiveRole() != 1)
      {
        rg(4);
        AppMethodBeat.o(208154);
        return;
        rg(0);
        AppMethodBeat.o(208154);
        return;
        if (this.hOy.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
          {
            rg(4);
            AppMethodBeat.o(208154);
            return;
          }
          rg(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.as
 * JD-Core Version:    0.7.0.1
 */