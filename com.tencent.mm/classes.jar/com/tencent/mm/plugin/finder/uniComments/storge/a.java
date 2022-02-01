package com.tencent.mm.plugin.finder.uniComments.storge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hz;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniAction;", "Lcom/tencent/mm/autogen/table/BaseUniAction;", "()V", "obj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "uniqueId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends hz
{
  private static final String FMB;
  private static final String FMC;
  public static final a Gbl;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(341701);
    Gbl = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = hz.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(LocalUniAction::class.java)");
    info = localMAutoDBInfo;
    FMB = "table_index_select_1";
    FMC = "table_index_select_2";
    AppMethodBeat.o(341701);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniAction$Companion;", "", "()V", "TABLEINDEX1", "", "getTABLEINDEX1", "()Ljava/lang/String;", "TABLEINDEX2", "getTABLEINDEX2", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.storge.a
 * JD-Core Version:    0.7.0.1
 */