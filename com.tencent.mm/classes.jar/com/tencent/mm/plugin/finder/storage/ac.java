package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isOverlap", "", "overlapCount", "", "Companion", "plugin-finder_release"})
public final class ac
  extends ci
{
  private static final c.a info;
  private static final String sKi = "metion_Index";
  public static final ac.a sKj;
  
  static
  {
    AppMethodBeat.i(167038);
    sKj = new ac.a((byte)0);
    c.a locala = ci.VD();
    p.g(locala, "BaseFinderMention.initAu…inderMention::class.java)");
    info = locala;
    sKi = "metion_Index";
    AppMethodBeat.o(167038);
  }
  
  public final int cLw()
  {
    aps localaps = this.field_aggregatedContacts;
    if (localaps != null) {
      return localaps.GGR;
    }
    return 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isOverlap()
  {
    return (this.field_aggregatedContacts != null) && (this.field_aggregatedContacts.GGR != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ac
 * JD-Core Version:    0.7.0.1
 */