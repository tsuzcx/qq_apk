package com.tencent.mm.live.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends a
{
  private final b ngl;
  private final View njL;
  private final View njM;
  
  public y(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247236);
    this.ngl = paramb;
    this.njL = paramViewGroup.findViewById(b.e.live_shadow_down);
    this.njM = paramViewGroup.findViewById(b.e.live_shadow_up);
    if (!isLandscape())
    {
      paramb = this.njL.getLayoutParams();
      paramb.height += bf.bk(paramViewGroup.getContext());
    }
    AppMethodBeat.o(247236);
  }
  
  public final Rect[] bjt()
  {
    AppMethodBeat.i(247244);
    Object localObject = new int[2];
    this.njL.getLocationOnScreen((int[])localObject);
    Rect localRect = new Rect(localObject[0], localObject[1], localObject[0] + this.njL.getWidth(), localObject[1] + this.njL.getHeight());
    this.njM.getLocationOnScreen((int[])localObject);
    localObject = new Rect(localObject[0], localObject[1], localObject[0] + this.njM.getWidth(), localObject[1] + this.njM.getHeight());
    AppMethodBeat.o(247244);
    return new Rect[] { localRect, localObject };
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247255);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247255);
      return;
      tO(4);
      AppMethodBeat.o(247255);
      return;
      if (this.ngl.getLiveRole() != 1)
      {
        tO(4);
        AppMethodBeat.o(247255);
        return;
        tO(0);
        AppMethodBeat.o(247255);
        return;
        if (this.ngl.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
          while (i != 0)
          {
            tO(4);
            AppMethodBeat.o(247255);
            return;
            i = 0;
          }
          tO(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.y
 * JD-Core Version:    0.7.0.1
 */