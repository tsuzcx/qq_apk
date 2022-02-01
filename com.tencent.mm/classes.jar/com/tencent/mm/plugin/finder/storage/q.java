package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveConfig;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveConfig;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder_release"})
public final class q
  extends ci
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a vEf;
  
  static
  {
    AppMethodBeat.i(251789);
    vEf = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ci.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(FinderLiveConfig::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(251789);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveConfig$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.q
 * JD-Core Version:    0.7.0.1
 */