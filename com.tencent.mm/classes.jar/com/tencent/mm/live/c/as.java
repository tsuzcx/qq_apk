package com.tencent.mm.live.c;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as
  extends a
{
  private final View gDc;
  private final View gDd;
  private final b gzk;
  
  public as(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190277);
    this.gzk = paramb;
    this.gDc = paramViewGroup.findViewById(2131307770);
    this.gDd = paramViewGroup.findViewById(2131307772);
    if (!aly())
    {
      paramb = this.gDc;
      k.g(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += ap.ej(paramViewGroup.getContext());
    }
    AppMethodBeat.o(190277);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190276);
    k.h(paramc, "status");
    switch (at.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190276);
      return;
      nj(4);
      AppMethodBeat.o(190276);
      return;
      if (this.gzk.getLiveRole() != 1)
      {
        nj(4);
        AppMethodBeat.o(190276);
        return;
        nj(0);
        AppMethodBeat.o(190276);
        return;
        if (this.gzk.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
          {
            nj(4);
            AppMethodBeat.o(190276);
            return;
          }
          nj(0);
        }
      }
    }
  }
  
  public final Rect[] amg()
  {
    AppMethodBeat.i(190275);
    Object localObject1 = new int[2];
    this.gDc.getLocationOnScreen((int[])localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    int k = localObject1[0];
    Object localObject2 = this.gDc;
    k.g(localObject2, "shadowDown");
    int m = ((View)localObject2).getWidth();
    int n = localObject1[1];
    localObject2 = this.gDc;
    k.g(localObject2, "shadowDown");
    localObject2 = new Rect(i, j, k + m, n + ((View)localObject2).getHeight());
    this.gDd.getLocationOnScreen((int[])localObject1);
    i = localObject1[0];
    j = localObject1[1];
    k = localObject1[0];
    View localView = this.gDd;
    k.g(localView, "shadowUp");
    m = localView.getWidth();
    n = localObject1[1];
    localObject1 = this.gDd;
    k.g(localObject1, "shadowUp");
    localObject1 = new Rect(i, j, k + m, n + ((View)localObject1).getHeight());
    AppMethodBeat.o(190275);
    return new Rect[] { localObject2, localObject1 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.as
 * JD-Core Version:    0.7.0.1
 */