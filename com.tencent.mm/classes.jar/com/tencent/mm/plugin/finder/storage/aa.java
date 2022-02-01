package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cc;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "Lcom/tencent/mm/autogen/table/BaseFinderAction;", "()V", "obj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "uniqueId", "", "Companion", "plugin-finder_release"})
public class aa
  extends cc
{
  private static final c.a info;
  private static final String sKe = "table_index_select_1";
  private static final String sKf = "table_index_select_2";
  public static final a sKg;
  
  static
  {
    AppMethodBeat.i(167032);
    sKg = new a((byte)0);
    c.a locala = cc.VD();
    p.g(locala, "initAutoDBInfo(LocalFinderAction::class.java)");
    info = locala;
    sKe = "table_index_select_1";
    sKf = "table_index_select_2";
    AppMethodBeat.o(167032);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction$Companion;", "", "()V", "TABLEINDEX1", "", "getTABLEINDEX1", "()Ljava/lang/String;", "TABLEINDEX2", "getTABLEINDEX2", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aa
 * JD-Core Version:    0.7.0.1
 */