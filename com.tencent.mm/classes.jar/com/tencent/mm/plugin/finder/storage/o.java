package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lcom/tencent/mm/autogen/table/BaseFinderLocalOperation;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder_release"})
public final class o
  extends cg
{
  private static final c.a info;
  public static final a syA;
  
  static
  {
    AppMethodBeat.i(203709);
    syA = new a((byte)0);
    c.a locala = cg.Vv();
    p.g(locala, "initAutoDBInfo(FinderLocalOperation::class.java)");
    info = locala;
    AppMethodBeat.o(203709);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.o
 * JD-Core Version:    0.7.0.1
 */