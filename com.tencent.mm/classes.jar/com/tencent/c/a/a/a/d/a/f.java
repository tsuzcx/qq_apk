package com.tencent.c.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ck;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveConfig;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"})
public final class f
  extends ck
{
  public static final a ZlW;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(229963);
    ZlW = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ck.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(FinderLiveSetting::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(229963);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.a.f
 * JD-Core Version:    0.7.0.1
 */