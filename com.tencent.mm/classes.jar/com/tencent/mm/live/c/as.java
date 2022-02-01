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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as
  extends a
{
  private final b gSV;
  private final View gWM;
  private final View gWN;
  
  public as(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212567);
    this.gSV = paramb;
    this.gWM = paramViewGroup.findViewById(2131307770);
    this.gWN = paramViewGroup.findViewById(2131307772);
    if (!aol())
    {
      paramb = this.gWM;
      p.g(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += ar.ej(paramViewGroup.getContext());
    }
    AppMethodBeat.o(212567);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212566);
    p.h(paramc, "status");
    switch (at.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212566);
      return;
      nI(4);
      AppMethodBeat.o(212566);
      return;
      if (this.gSV.getLiveRole() != 1)
      {
        nI(4);
        AppMethodBeat.o(212566);
        return;
        nI(0);
        AppMethodBeat.o(212566);
        return;
        if (this.gSV.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
          {
            nI(4);
            AppMethodBeat.o(212566);
            return;
          }
          nI(0);
        }
      }
    }
  }
  
  public final Rect[] aoT()
  {
    AppMethodBeat.i(212565);
    Object localObject1 = new int[2];
    this.gWM.getLocationOnScreen((int[])localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    int k = localObject1[0];
    Object localObject2 = this.gWM;
    p.g(localObject2, "shadowDown");
    int m = ((View)localObject2).getWidth();
    int n = localObject1[1];
    localObject2 = this.gWM;
    p.g(localObject2, "shadowDown");
    localObject2 = new Rect(i, j, k + m, n + ((View)localObject2).getHeight());
    this.gWN.getLocationOnScreen((int[])localObject1);
    i = localObject1[0];
    j = localObject1[1];
    k = localObject1[0];
    View localView = this.gWN;
    p.g(localView, "shadowUp");
    m = localView.getWidth();
    n = localObject1[1];
    localObject1 = this.gWN;
    p.g(localObject1, "shadowUp");
    localObject1 = new Rect(i, j, k + m, n + ((View)localObject1).getHeight());
    AppMethodBeat.o(212565);
    return new Rect[] { localObject2, localObject1 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.as
 * JD-Core Version:    0.7.0.1
 */