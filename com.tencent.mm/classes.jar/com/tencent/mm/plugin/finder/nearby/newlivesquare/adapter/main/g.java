package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.d;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/HeadLivingItemConvertFactory;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BaseFactory;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;ZZI)V", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends c
{
  private final int AJo;
  private final boolean ALp;
  private final boolean ANc;
  private final MMActivity lzt;
  
  public g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(340593);
    this.lzt = paramMMActivity;
    this.ALp = false;
    this.ANc = false;
    this.AJo = 0;
    AppMethodBeat.o(340593);
  }
  
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(340602);
    switch (paramInt)
    {
    default: 
      localf = (f)eFP();
      AppMethodBeat.o(340602);
      return localf;
    case 1: 
      localf = (f)new d();
      AppMethodBeat.o(340602);
      return localf;
    }
    f localf = (f)new i(null);
    AppMethodBeat.o(340602);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.g
 * JD-Core Version:    0.7.0.1
 */