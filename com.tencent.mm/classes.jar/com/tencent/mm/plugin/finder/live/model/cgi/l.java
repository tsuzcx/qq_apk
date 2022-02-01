package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "liveId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "(JLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoReq;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends o<azl>
{
  private a CJi;
  private azk CJj;
  private final String TAG;
  
  public l(long paramLong)
  {
    AppMethodBeat.i(371576);
    this.CJi = null;
    this.TAG = "Finder.CgiFinderGetLiveInfo";
    this.CJj = new azk();
    this.CJj.liveId = paramLong;
    this.CJj.YIZ = z.bAW();
    Log.i(this.TAG, s.X("get live info liveId:", Long.valueOf(paramLong)));
    c.a locala = new c.a();
    locala.otE = ((a)this.CJj);
    azl localazl = new azl();
    localazl.setBaseResponse(new kd());
    localazl.getBaseResponse().akjO = new etl();
    locala.otF = ((a)localazl);
    locala.uri = "/cgi-bin/micromsg-bin/findergetliveinfo";
    locala.funcId = 3861;
    c(locala.bEF());
    AppMethodBeat.o(371576);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.l
 * JD-Core Version:    0.7.0.1
 */