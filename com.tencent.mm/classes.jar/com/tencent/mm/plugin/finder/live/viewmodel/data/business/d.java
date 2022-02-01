package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveChargeSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "value", "", "cacheLiveMode", "getCacheLiveMode", "()I", "setCacheLiveMode", "(I)V", "purchaseInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePurchaseInfo;", "getPurchaseInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePurchaseInfo;", "setPurchaseInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLivePurchaseInfo;)V", "isChargeLive", "", "isPurchase", "isUnPurchaseChargeLive", "onCleared", "", "purchaseHeat", "", "purchasePrice", "purchaseUserCount", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private static final int CXA;
  public static final a Eci;
  public int Ecj;
  
  static
  {
    AppMethodBeat.i(356700);
    Eci = new a((byte)0);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    CXA = ((Number)com.tencent.d.a.a.a.a.a.jUn().bmg()).intValue();
    AppMethodBeat.o(356700);
  }
  
  public d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356686);
    AppMethodBeat.o(356686);
  }
  
  public final void PX(int paramInt)
  {
    AppMethodBeat.i(356709);
    if (paramInt != this.Ecj) {
      Log.i("LiveChargeSlice", s.X("cacheLiveMode ", Integer.valueOf(paramInt)));
    }
    this.Ecj = paramInt;
    AppMethodBeat.o(356709);
  }
  
  public final blf eyi()
  {
    AppMethodBeat.i(356712);
    blf localblf = ((f)business(f.class)).liveInfo.ZSc;
    AppMethodBeat.o(356712);
    return localblf;
  }
  
  public final boolean eyj()
  {
    AppMethodBeat.i(356719);
    blf localblf = eyi();
    if ((localblf != null) && (localblf.ZGN == 2))
    {
      AppMethodBeat.o(356719);
      return true;
    }
    AppMethodBeat.o(356719);
    return false;
  }
  
  public final boolean eyk()
  {
    AppMethodBeat.i(356726);
    blf localblf = eyi();
    if ((localblf != null) && (localblf.ZUj == true))
    {
      AppMethodBeat.o(356726);
      return true;
    }
    AppMethodBeat.o(356726);
    return false;
  }
  
  public final boolean eyl()
  {
    AppMethodBeat.i(356733);
    if ((eyj()) && (!eyk()))
    {
      AppMethodBeat.o(356733);
      return true;
    }
    AppMethodBeat.o(356733);
    return false;
  }
  
  public final int eym()
  {
    AppMethodBeat.i(356738);
    blf localblf = eyi();
    if (localblf == null)
    {
      AppMethodBeat.o(356738);
      return 0;
    }
    int i = localblf.ZUk;
    AppMethodBeat.o(356738);
    return i;
  }
  
  public final void onCleared() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveChargeSlice$Companion;", "", "()V", "TAG", "", "totalFreeTimeToWatch", "", "getTotalFreeTimeToWatch", "()I", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.d
 * JD-Core Version:    0.7.0.1
 */