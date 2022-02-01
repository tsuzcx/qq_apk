package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveDislikeBannerRecord;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveDislikeBannerRecord;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends cr
{
  public static final a ahpN;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216737);
    ahpN = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cr.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(BaseFinde…BannerRecord::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(216737);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveDislikeBannerRecord$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.c
 * JD-Core Version:    0.7.0.1
 */