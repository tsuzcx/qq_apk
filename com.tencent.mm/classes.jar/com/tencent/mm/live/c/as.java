package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as
  extends a
{
  private final b IIz;
  
  public as(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203042);
    this.IIz = paramb;
    AppMethodBeat.o(203042);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203041);
    k.h(paramc, "status");
    switch (at.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203041);
      return;
      agK(4);
      AppMethodBeat.o(203041);
      return;
      if (this.IIz.getLiveRole() != 1)
      {
        agK(4);
        AppMethodBeat.o(203041);
        return;
        agK(0);
        AppMethodBeat.o(203041);
        return;
        if (this.IIz.getLiveRole() == 0)
        {
          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
          {
            agK(4);
            AppMethodBeat.o(203041);
            return;
          }
          agK(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.as
 * JD-Core Version:    0.7.0.1
 */