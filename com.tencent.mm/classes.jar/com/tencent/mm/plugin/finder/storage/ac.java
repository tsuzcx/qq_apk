package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"})
public final class ac
  extends ci
{
  private static final c.a info;
  private static final String szr = "metion_Index";
  public static final a szs;
  
  static
  {
    AppMethodBeat.i(167038);
    szs = new a((byte)0);
    c.a locala = ci.Vv();
    p.g(locala, "BaseFinderMention.initAu…inderMention::class.java)");
    info = locala;
    szr = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final int cIU()
  {
    apf localapf = this.field_aggregatedContacts;
    if (localapf != null) {
      return localapf.GnL;
    }
    return 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isOverlap()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.GnL != 0);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention$Companion;", "", "()V", "TABLEINDEXUSERNAME", "", "getTABLEINDEXUSERNAME", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ac
 * JD-Core Version:    0.7.0.1
 */