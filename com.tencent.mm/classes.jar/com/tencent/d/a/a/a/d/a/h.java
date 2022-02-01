package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cq;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveConfig;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends cq
{
  public static final h.a ahpS;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216731);
    ahpS = new h.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cq.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(FinderLiveSetting::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(216731);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.h
 * JD-Core Version:    0.7.0.1
 */