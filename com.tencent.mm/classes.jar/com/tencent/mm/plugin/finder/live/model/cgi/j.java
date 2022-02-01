package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveCookie", "", "liveId", "", "count", "", "objectId", "scene", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;[BJIJILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "getCount", "()I", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class j
  extends k<aun>
{
  private final String TAG;
  private final int count;
  private final long hFK;
  private final long liveId;
  private aum ukM;
  private final a ukN;
  
  public j(aov paramaov, byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246317);
    this.liveId = paramLong1;
    this.count = paramInt;
    this.hFK = paramLong2;
    this.ukN = parama;
    this.TAG = "Finder.CgiFinderLikeLive";
    this.ukM = new aum();
    this.ukM.LBM = paramaov;
    this.ukM.hyH = this.liveId;
    this.ukM.LFp = b.cD(paramArrayOfByte);
    this.ukM.object_id = this.hFK;
    this.ukM.seq = 0L;
    this.ukM.LFq = 0;
    paramaov = this.ukM;
    paramArrayOfByte = y.vXH;
    paramaov.LFr = y.dCV();
    this.ukM.count = this.count;
    this.ukM.scene = 1;
    paramaov = new d.a();
    paramaov.c((a)this.ukM);
    paramArrayOfByte = new aun();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramaov.d((a)paramArrayOfByte);
    paramaov.MB("/cgi-bin/micromsg-bin/finderlikelive");
    paramaov.sG(564);
    c(paramaov.aXF());
    Log.i(this.TAG, "[likeInfo]like live id:" + this.liveId + " objectId:" + this.hFK + " count:" + this.count);
    AppMethodBeat.o(246317);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, aun paramaun);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */