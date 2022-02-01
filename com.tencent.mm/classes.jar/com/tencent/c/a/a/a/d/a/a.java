package com.tencent.c.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveActionRecord;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveActionRecord;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"})
public final class a
  extends cj
{
  public static final a ZlR;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(229320);
    ZlR = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cj.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(BaseFinde…ActionRecord::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(229320);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveActionRecord$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */