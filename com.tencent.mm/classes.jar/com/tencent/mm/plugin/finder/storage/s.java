package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveGiftInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isFullPagGift", "", "pagFetched", "pagFullFetched", "pagPreFetched", "resetPagFullFetched", "", "toFinderLiveGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "Companion", "plugin-finder_release"})
public final class s
  extends cj
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a vEi;
  
  static
  {
    AppMethodBeat.i(251799);
    vEi = new a((byte)0);
    info = cj.ajs();
    AppMethodBeat.o(251799);
  }
  
  public final boolean dxN()
  {
    return this.field_giftType == 2;
  }
  
  public final boolean dxO()
  {
    AppMethodBeat.i(251797);
    boolean bool = d.cW(this.field_state, 1);
    AppMethodBeat.o(251797);
    return bool;
  }
  
  public final boolean dxP()
  {
    AppMethodBeat.i(251798);
    boolean bool = d.cW(this.field_state, 2);
    AppMethodBeat.o(251798);
    return bool;
  }
  
  public final void dxQ()
  {
    this.field_state &= 0xFFFFFFFD;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(251796);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(251796);
    return localMAutoDBInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.s
 * JD-Core Version:    0.7.0.1
 */