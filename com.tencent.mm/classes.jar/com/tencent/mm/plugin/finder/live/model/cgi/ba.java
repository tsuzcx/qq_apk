package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiGetProductReplayUrl;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlResponse;", "replayId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiGetProductReplayUrl$CallBack;", "(JLcom/tencent/mm/plugin/finder/live/model/cgi/CgiGetProductReplayUrl$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  extends o<bif>
{
  private a CKO;
  private bie CKP;
  private final String TAG;
  
  public ba(long paramLong, a parama)
  {
    AppMethodBeat.i(360152);
    this.TAG = "Finder.CgiGetProductReplayUrl";
    this.CKO = parama;
    this.CKP = new bie();
    parama = this.CKP;
    Object localObject = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKP.ZRl = paramLong;
    parama = new c.a();
    parama.otE = ((a)this.CKP);
    localObject = new bif();
    ((bif)localObject).setBaseResponse(new kd());
    ((bif)localObject).getBaseResponse().akjO = new etl();
    parama.otF = ((a)localObject);
    parama.uri = "/cgi-bin/micromsg-bin/finderlivegetreplayurl";
    parama.funcId = 6613;
    c(parama.bEF());
    Log.i(this.TAG, s.X("init ", Long.valueOf(this.CKP.ZRl)));
    AppMethodBeat.o(360152);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiGetProductReplayUrl$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bif parambif);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ba
 * JD-Core Version:    0.7.0.1
 */