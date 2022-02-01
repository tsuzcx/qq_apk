package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"})
public final class u
  extends cf
{
  private static final c.a info;
  private static final String rEx = "metion_Index";
  public static final u.a rEy;
  
  static
  {
    AppMethodBeat.i(167038);
    rEy = new u.a((byte)0);
    c.a locala = cf.Th();
    k.g(locala, "BaseFinderMention.initAu…inderMention::class.java)");
    info = locala;
    rEx = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final int cAY()
  {
    alz localalz = this.field_aggregatedContacts;
    if (localalz != null) {
      return localalz.EFx;
    }
    return 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isOverlap()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.EFx != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.u
 * JD-Core Version:    0.7.0.1
 */