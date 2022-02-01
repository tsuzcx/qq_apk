package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "Lcom/tencent/mm/autogen/table/BaseFinderAction;", "()V", "obj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "uniqueId", "", "Companion", "plugin-finder_release"})
public class am
  extends cd
{
  private static final IAutoDBItem.MAutoDBInfo info;
  private static final String vFq = "table_index_select_1";
  private static final String vFr = "table_index_select_2";
  public static final a vFs;
  
  static
  {
    AppMethodBeat.i(167032);
    vFs = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cd.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(LocalFinderAction::class.java)");
    info = localMAutoDBInfo;
    vFq = "table_index_select_1";
    vFr = "table_index_select_2";
    AppMethodBeat.o(167032);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction$Companion;", "", "()V", "TABLEINDEX1", "", "getTABLEINDEX1", "()Ljava/lang/String;", "TABLEINDEX2", "getTABLEINDEX2", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.am
 * JD-Core Version:    0.7.0.1
 */