package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cw;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveVideoDefinitionInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveVideoDefinitionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends cw
{
  public static final a ahpT;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216732);
    ahpT = new a((byte)0);
    info = cw.aJm();
    AppMethodBeat.o(216732);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(216735);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(216735);
    return localMAutoDBInfo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveVideoDefinitionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.i
 * JD-Core Version:    0.7.0.1
 */