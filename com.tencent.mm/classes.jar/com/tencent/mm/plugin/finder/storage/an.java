package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cr;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"})
public final class an
  extends cr
{
  public static final a AmM;
  private static final String TABLEINDEXUSERNAME = "metion_Index";
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(167038);
    AmM = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cr.aoY();
    p.j(localMAutoDBInfo, "BaseFinderMention.initAu…inderMention::class.java)");
    info = localMAutoDBInfo;
    TABLEINDEXUSERNAME = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final boolean dZj()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.SPu != 0);
  }
  
  public final int dZk()
  {
    beg localbeg = this.field_aggregatedContacts;
    if (localbeg != null) {
      return localbeg.SPu;
    }
    return 0;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention$Companion;", "", "()V", "TABLEINDEXUSERNAME", "", "getTABLEINDEXUSERNAME", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.an
 * JD-Core Version:    0.7.0.1
 */