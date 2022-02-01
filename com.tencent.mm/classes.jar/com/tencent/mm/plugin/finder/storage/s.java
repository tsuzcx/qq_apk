package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lcom/tencent/mm/autogen/table/BaseFinderLocalOperation;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends cx
{
  public static final a FKV;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(339257);
    FKV = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cx.aJm();
    kotlin.g.b.s.s(localMAutoDBInfo, "initAutoDBInfo(FinderLocalOperation::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(339257);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.s
 * JD-Core Version:    0.7.0.1
 */