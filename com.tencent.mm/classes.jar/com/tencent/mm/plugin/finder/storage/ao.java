package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"})
public final class ao
  extends cm
{
  private static final String TABLEINDEXUSERNAME = "metion_Index";
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a vFu;
  
  static
  {
    AppMethodBeat.i(167038);
    vFu = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cm.ajs();
    p.g(localMAutoDBInfo, "BaseFinderMention.initAu…inderMention::class.java)");
    info = localMAutoDBInfo;
    TABLEINDEXUSERNAME = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final int dym()
  {
    aym localaym = this.field_aggregatedContacts;
    if (localaym != null) {
      return localaym.LII;
    }
    return 0;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean isOverlap()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.LII != 0);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention$Companion;", "", "()V", "TABLEINDEXUSERNAME", "", "getTABLEINDEXUSERNAME", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ao
 * JD-Core Version:    0.7.0.1
 */