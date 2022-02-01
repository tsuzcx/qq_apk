package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lcom/tencent/mm/autogen/table/BaseFinderLocalOperation;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder_release"})
public final class u
  extends ck
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a vEk;
  
  static
  {
    AppMethodBeat.i(251804);
    vEk = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ck.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(FinderLocalOperation::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(251804);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.u
 * JD-Core Version:    0.7.0.1
 */