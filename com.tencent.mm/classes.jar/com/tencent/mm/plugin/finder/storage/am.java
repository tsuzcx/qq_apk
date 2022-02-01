package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.df;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsJumpConfig;", "Lcom/tencent/mm/autogen/table/BaseFinderSnsKeyWordsJumpConfig;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends df
{
  public static final a FMv;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(339403);
    FMv = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = df.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(FinderSns…dsJumpConfig::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(339403);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsJumpConfig$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.am
 * JD-Core Version:    0.7.0.1
 */