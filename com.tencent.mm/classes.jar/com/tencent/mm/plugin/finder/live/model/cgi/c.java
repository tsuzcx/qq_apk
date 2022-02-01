package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class c
  extends n<apm>
{
  private final String TAG;
  private apl yiN;
  private final a yiO;
  
  public c(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2, a parama)
  {
    AppMethodBeat.i(287720);
    this.yiO = parama;
    this.TAG = "Finder.CgiFinderActivateLiveMic";
    this.yiN = new apl();
    this.yiN.klE = paramLong1;
    parama = this.yiN;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yiN.object_id = paramLong2;
    this.yiN.object_nonce_id = paramString1;
    this.yiN.RLN = z.bdh();
    this.yiN.scene = 1;
    this.yiN.RLO = b.cU(paramArrayOfByte);
    this.yiN.RFk = paramString2;
    Log.i(this.TAG, "activate live mic id:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " sessionId:" + paramString2);
    paramString1 = new d.a();
    paramString1.c((a)this.yiN);
    paramArrayOfByte = new apm();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramArrayOfByte);
    paramString1.TW("/cgi-bin/micromsg-bin/finderactivatelivemic");
    paramString1.vD(6802);
    c(paramString1.bgN());
    AppMethodBeat.o(287720);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(apm paramapm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */