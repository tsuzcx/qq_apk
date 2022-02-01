package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-finder_release"})
public final class j
  extends ck
{
  private static final c.a info;
  public static final a rLP;
  
  static
  {
    AppMethodBeat.i(201302);
    rLP = new a((byte)0);
    info = ck.Vv();
    AppMethodBeat.o(201302);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(201301);
    c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(201301);
    return locala;
  }
  
  public final String toString()
  {
    return "";
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.j
 * JD-Core Version:    0.7.0.1
 */