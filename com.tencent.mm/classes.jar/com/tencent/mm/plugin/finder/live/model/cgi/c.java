package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends o<atf>
{
  private final a CIP;
  private ate CIQ;
  private final String TAG;
  
  public c(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2, a parama)
  {
    AppMethodBeat.i(360306);
    this.CIP = parama;
    this.TAG = "Finder.CgiFinderActivateLiveMic";
    this.CIQ = new ate();
    this.CIQ.mMJ = paramLong1;
    parama = this.CIQ;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CIQ.object_id = paramLong2;
    this.CIQ.object_nonce_id = paramString1;
    this.CIQ.YIZ = z.bAW();
    this.CIQ.scene = 1;
    this.CIQ.YJa = b.cX(paramArrayOfByte);
    this.CIQ.YBM = paramString2;
    Log.i(this.TAG, "activate live mic id:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " sessionId:" + paramString2);
    paramString1 = new com.tencent.mm.am.c.a();
    paramString1.otE = ((a)this.CIQ);
    paramArrayOfByte = new atf();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramArrayOfByte);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderactivatelivemic";
    paramString1.funcId = 6802;
    c(paramString1.bEF());
    AppMethodBeat.o(360306);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(atf paramatf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */