package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"})
public final class l
  extends cd
{
  private static final c.a info;
  private static final String qKh = "metion_Index";
  public static final a qKi;
  
  static
  {
    AppMethodBeat.i(167038);
    qKi = new a((byte)0);
    c.a locala = cd.So();
    k.g(locala, "BaseFinderMention.initAu…inderMention::class.java)");
    info = locala;
    qKh = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final int fVb()
  {
    dzg localdzg = this.field_aggregatedContacts;
    if (localdzg != null) {
      return localdzg.LxM;
    }
    return 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isOverlap()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.LxM != 0);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention$Companion;", "", "()V", "TABLEINDEXUSERNAME", "", "getTABLEINDEXUSERNAME", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */