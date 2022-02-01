package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "Lcom/tencent/mm/autogen/table/BaseFinderAction;", "()V", "obj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "uniqueId", "", "Companion", "plugin-finder_release"})
public class s
  extends cb
{
  private static final c.a info;
  private static final String rEt = "table_index_select_1";
  private static final String rEu = "table_index_select_2";
  public static final s.a rEv;
  
  static
  {
    AppMethodBeat.i(167032);
    rEv = new s.a((byte)0);
    c.a locala = cb.Th();
    k.g(locala, "initAutoDBInfo(LocalFinderAction::class.java)");
    info = locala;
    rEt = "table_index_select_1";
    rEu = "table_index_select_2";
    AppMethodBeat.o(167032);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.s
 * JD-Core Version:    0.7.0.1
 */