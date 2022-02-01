package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.an;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/BypMsgInfo;", "Lcom/tencent/mm/autogen/table/BaseBypMsgInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-byp_release"})
public final class b
  extends an
{
  private static final c.a info;
  public static final a ouL;
  
  static
  {
    AppMethodBeat.i(219196);
    ouL = new a((byte)0);
    info = an.Vv();
    AppMethodBeat.o(219196);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(219195);
    c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(219195);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/BypMsgInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b
 * JD-Core Version:    0.7.0.1
 */