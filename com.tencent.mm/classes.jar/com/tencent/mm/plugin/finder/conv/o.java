package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dd;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends dd
{
  public static final a AHd;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(335995);
    AHd = new a((byte)0);
    info = dd.aJm();
    AppMethodBeat.o(335995);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(336000);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(336000);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    return "";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.o
 * JD-Core Version:    0.7.0.1
 */