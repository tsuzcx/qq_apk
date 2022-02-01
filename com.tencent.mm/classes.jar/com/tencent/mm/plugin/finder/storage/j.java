package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bz;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "Lcom/tencent/mm/autogen/table/BaseFinderAction;", "()V", "obj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "uniqueId", "", "Companion", "plugin-finder_release"})
public class j
  extends bz
{
  private static final c.a info;
  private static final String qKd = "table_index_select_1";
  private static final String qKe = "table_index_select_2";
  public static final a qKf;
  
  static
  {
    AppMethodBeat.i(167032);
    qKf = new a((byte)0);
    c.a locala = bz.So();
    k.g(locala, "initAutoDBInfo(LocalFinderAction::class.java)");
    info = locala;
    qKd = "table_index_select_1";
    qKe = "table_index_select_2";
    AppMethodBeat.o(167032);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction$Companion;", "", "()V", "TABLEINDEX1", "", "getTABLEINDEX1", "()Ljava/lang/String;", "TABLEINDEX2", "getTABLEINDEX2", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.j
 * JD-Core Version:    0.7.0.1
 */