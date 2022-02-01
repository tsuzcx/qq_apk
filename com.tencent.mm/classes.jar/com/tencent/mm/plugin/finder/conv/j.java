package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-finder_release"})
public final class j
  extends ck
{
  private static final c.a info;
  public static final a rUc;
  
  static
  {
    AppMethodBeat.i(201729);
    rUc = new a((byte)0);
    info = ck.VD();
    AppMethodBeat.o(201729);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(201728);
    c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(201728);
    return locala;
  }
  
  public final String toString()
  {
    return "";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.j
 * JD-Core Version:    0.7.0.1
 */