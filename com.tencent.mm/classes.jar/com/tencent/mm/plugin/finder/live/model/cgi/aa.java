package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetCouponList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListResponse;", "liveId", "", "objectId", "anchorUsername", "", "lasBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetCouponList$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetCouponList$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends o<bhl>
{
  private a CJM;
  private bhk CJN;
  private final String TAG;
  
  public aa(long paramLong1, long paramLong2, String paramString, b paramb, a parama)
  {
    AppMethodBeat.i(360263);
    this.TAG = "Finder.CgiFinderLiveGetCouponList";
    this.CJM = parama;
    this.CJN = new bhk();
    parama = this.CJN;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CJN.mMJ = paramLong1;
    this.CJN.object_id = paramLong2;
    this.CJN.YIZ = paramString;
    this.CJN.ZEQ = paramb;
    paramString = new c.a();
    paramString.otE = ((a)this.CJN);
    paramb = new bhl();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramb);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivegetcouponlist";
    paramString.funcId = 4033;
    c(paramString.bEF());
    Log.i(this.TAG, "init " + this.CJN.mMJ + ", " + this.CJN.YIZ);
    AppMethodBeat.o(360263);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetCouponList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bhl parambhl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aa
 * JD-Core Version:    0.7.0.1
 */