package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/AllowanceGiftSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "<set-?>", "", "allowancePackageId", "getAllowancePackageId", "()Ljava/lang/String;", "consumedPackageId", "", "cutOffTime", "getCutOffTime", "()J", "value", "", "isAnchorNeedShowGuide", "()Z", "setAnchorNeedShowGuide", "(Z)V", "consumedAllowanceGift", "", "onCleared", "updateAllowanceInfo", "finderLiveGiftInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGiftInfo;", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a Eca;
  public String Ecb;
  public String Ecc;
  public long Ecd;
  public boolean Ece;
  
  static
  {
    AppMethodBeat.i(356680);
    Eca = new a((byte)0);
    AppMethodBeat.o(356680);
  }
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356672);
    this.Ecb = "";
    this.Ecc = "";
    this.Ecd = -1L;
    AppMethodBeat.o(356672);
  }
  
  public final String eye()
  {
    AppMethodBeat.i(356687);
    if (a.eyg())
    {
      AppMethodBeat.o(356687);
      return "debug_id";
    }
    String str = this.Ecc;
    AppMethodBeat.o(356687);
    return str;
  }
  
  public final boolean eyf()
  {
    AppMethodBeat.i(356695);
    if (a.eyg())
    {
      AppMethodBeat.o(356695);
      return true;
    }
    boolean bool = this.Ece;
    AppMethodBeat.o(356695);
    return bool;
  }
  
  public final void onCleared()
  {
    this.Ecc = "";
    this.Ecd = -1L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/AllowanceGiftSlice$Companion;", "", "()V", "TAG", "", "isDemoEnable", "", "()Z", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean eyg()
    {
      AppMethodBeat.i(356635);
      com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUf().bmg()).intValue() == 1)
      {
        AppMethodBeat.o(356635);
        return true;
      }
      AppMethodBeat.o(356635);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.a
 * JD-Core Version:    0.7.0.1
 */