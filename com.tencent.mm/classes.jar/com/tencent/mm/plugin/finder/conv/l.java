package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "", "Companion", "plugin-finder_release"})
public final class l
  extends cv
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a xgH;
  
  static
  {
    AppMethodBeat.i(277906);
    xgH = new a((byte)0);
    info = cv.aoY();
    AppMethodBeat.o(277906);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(277905);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.j(localMAutoDBInfo, "info");
    AppMethodBeat.o(277905);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    return "";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.l
 * JD-Core Version:    0.7.0.1
 */