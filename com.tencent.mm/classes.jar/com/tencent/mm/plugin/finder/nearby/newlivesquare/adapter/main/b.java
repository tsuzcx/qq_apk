package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/AdItemConvertFactory;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BaseFactory;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "isMoreThanOne", "(Lcom/tencent/mm/ui/MMActivity;ZZIZ)V", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  private final int AJo;
  private final boolean ALp;
  private final boolean ANc;
  private final boolean akhL;
  private final MMActivity lzt;
  
  public b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(370488);
    this.lzt = paramMMActivity;
    this.ALp = false;
    this.ANc = false;
    this.AJo = 0;
    this.akhL = paramBoolean;
    AppMethodBeat.o(370488);
  }
  
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(340576);
    if (paramInt == 8)
    {
      localf = (f)new a(this.akhL);
      AppMethodBeat.o(340576);
      return localf;
    }
    f localf = (f)eFP();
    AppMethodBeat.o(340576);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.b
 * JD-Core Version:    0.7.0.1
 */