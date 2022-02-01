package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveIssueCoupon;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;", "liveId", "", "objectId", "finderUsername", "", "stockId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveIssueCoupon$CallBack;", "(JJLjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveIssueCoupon$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends o<bir>
{
  private a CJY;
  private biq CJZ;
  private final String TAG;
  
  public ag(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(360282);
    this.TAG = "Finder.CgiFinderLiveIssueCoupon";
    this.CJY = parama;
    this.CJZ = new biq();
    parama = this.CJZ;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CJZ.mMJ = paramLong1;
    this.CJZ.object_id = paramLong2;
    this.CJZ.YIZ = paramString1;
    this.CJZ.mdE = paramString2;
    this.CJZ.scene = paramInt;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CJZ);
    paramString2 = new bir();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderliveissuecoupon";
    paramString1.funcId = 5941;
    c(paramString1.bEF());
    Log.i(this.TAG, "init " + this.CJZ.mMJ + ", " + this.CJZ.YIZ);
    AppMethodBeat.o(360282);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveIssueCoupon$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bir parambir);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ag
 * JD-Core Version:    0.7.0.1
 */