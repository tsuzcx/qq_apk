package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cp;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveChargeInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveChargeInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends cp
{
  public static final a ahpM;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216736);
    ahpM = new a((byte)0);
    info = cp.aJm();
    AppMethodBeat.o(216736);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(216741);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(216741);
    return localMAutoDBInfo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveChargeInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.b
 * JD-Core Version:    0.7.0.1
 */