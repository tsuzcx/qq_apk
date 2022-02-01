package com.tencent.mm.plugin.finder.replay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayUtil;", "", "()V", "createVideoData", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "replayUrl", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n FkP;
  
  static
  {
    AppMethodBeat.i(332624);
    FkP = new n();
    AppMethodBeat.o(332624);
  }
  
  public static com.tencent.mm.plugin.finder.loader.v d(bip parambip)
  {
    AppMethodBeat.i(332617);
    s.u(parambip, "liveInfo");
    Object localObject = parambip.ZRm;
    parambip = (bip)localObject;
    if (localObject == null) {
      parambip = "";
    }
    s.u(parambip, "replayUrl");
    dji localdji = new dji();
    localObject = parambip;
    if (BuildInfo.DEBUG) {
      localObject = kotlin.n.n.m(parambip, "https", "http", false);
    }
    localdji.url = ((String)localObject);
    localdji.mediaId = g.getMD5(localdji.url);
    parambip = ah.aiuX;
    parambip = new com.tencent.mm.plugin.finder.loader.v(localdji, com.tencent.mm.plugin.finder.storage.v.FLa, 0, null, 12);
    AppMethodBeat.o(332617);
    return parambip;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.n
 * JD-Core Version:    0.7.0.1
 */