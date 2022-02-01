package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "liveId", "", "finderUsername", "", "objectId", "pauseSecond", "", "pauseMode", "scene", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "(JLjava/lang/String;JIIILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ad
  extends n<bgo>
{
  private final String TAG;
  private bgn yjO;
  private final a yjP;
  
  public ad(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(291553);
    this.yjP = parama;
    this.TAG = "Finder.CgiFinderLivePause";
    this.yjO = new bgn();
    this.yjO.klE = paramLong1;
    this.yjO.RLN = paramString;
    this.yjO.object_id = paramLong2;
    this.yjO.SRk = 0;
    this.yjO.SRl = paramInt1;
    this.yjO.scene = paramInt2;
    paramString = new d.a();
    paramString.c((a)this.yjO);
    parama = new bgo();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/finderpauselive");
    paramString.vD(4197);
    c(paramString.bgN());
    Log.i(this.TAG, "CgiFinderLivePause init " + this.yjO.klE + ',' + this.yjO.RLN + ",pause_second:" + this.yjO.SRk + ",pause_mode:" + this.yjO.SRl);
    AppMethodBeat.o(291553);
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bgo parambgo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ad
 * JD-Core Version:    0.7.0.1
 */