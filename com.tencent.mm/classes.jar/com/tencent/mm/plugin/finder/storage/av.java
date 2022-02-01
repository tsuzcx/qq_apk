package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cz;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends cz
{
  public static final a FMF;
  private static final String TABLEINDEXUSERNAME;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(167038);
    FMF = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cz.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(LocalFinderMention::class.java)");
    info = localMAutoDBInfo;
    TABLEINDEXUSERNAME = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final boolean eZS()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.ZXF != 0);
  }
  
  public final int eZT()
  {
    bpe localbpe = this.field_aggregatedContacts;
    if (localbpe == null) {
      return 0;
    }
    return localbpe.ZXF;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention$Companion;", "", "()V", "TABLEINDEXUSERNAME", "", "getTABLEINDEXUSERNAME", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.av
 * JD-Core Version:    0.7.0.1
 */