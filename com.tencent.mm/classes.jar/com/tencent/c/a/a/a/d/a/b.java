package com.tencent.c.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.c.cl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveGiftInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isFullPagGift", "", "pagFetched", "pagFullFetched", "pagPreFetched", "resetPagFullFetched", "", "toFinderLiveGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "Companion", "plugin-finder-live-api_release"})
public final class b
  extends cl
{
  public static final a ZlS;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(230451);
    ZlS = new a((byte)0);
    info = cl.aoY();
    AppMethodBeat.o(230451);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(230440);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.j(localMAutoDBInfo, "info");
    AppMethodBeat.o(230440);
    return localMAutoDBInfo;
  }
  
  public final boolean inu()
  {
    return this.field_giftType == 2;
  }
  
  public final boolean inv()
  {
    AppMethodBeat.i(230443);
    boolean bool = d.dr(this.field_state, 1);
    AppMethodBeat.o(230443);
    return bool;
  }
  
  public final boolean inw()
  {
    AppMethodBeat.i(230445);
    boolean bool = d.dr(this.field_state, 2);
    AppMethodBeat.o(230445);
    return bool;
  }
  
  public final void inx()
  {
    this.field_state &= 0xFFFFFFFD;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.a.b
 * JD-Core Version:    0.7.0.1
 */