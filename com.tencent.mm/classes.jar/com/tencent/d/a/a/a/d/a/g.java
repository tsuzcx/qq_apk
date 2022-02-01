package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveNotifyExposureInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends cv
{
  public static final g.a ahpR;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216734);
    ahpR = new g.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cv.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(FinderLiv…ExposureInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(216734);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.g
 * JD-Core Version:    0.7.0.1
 */