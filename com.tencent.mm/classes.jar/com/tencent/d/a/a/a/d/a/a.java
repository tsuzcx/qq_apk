package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.co;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveActionRecord;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveActionRecord;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends co
{
  public static final a ahpL;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216742);
    ahpL = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = co.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(BaseFinde…ActionRecord::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(216742);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveActionRecord$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */