package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveCookie", "", "liveId", "", "count", "", "objectId", "scene", "nonceId", "", "finderUsername", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;[BJIJILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;)V", "TAG", "getCount", "()I", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends o<bcq>
{
  private bcp CJl;
  private final String TAG;
  private final int count;
  private final long hKN;
  private final long liveId;
  
  public n(atz paramatz, byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, bui parambui, bma parambma)
  {
    super(parambui);
    AppMethodBeat.i(360316);
    this.liveId = paramLong1;
    this.count = paramInt;
    this.hKN = paramLong2;
    this.TAG = "Finder.CgiFinderLikeLive";
    this.CJl = new bcp();
    this.CJl.YIY = paramatz;
    this.CJl.mMJ = this.liveId;
    this.CJl.YJa = b.cX(paramArrayOfByte);
    this.CJl.object_id = this.hKN;
    this.CJl.seq = 0L;
    this.CJl.ZNC = 0;
    paramatz = this.CJl;
    paramArrayOfByte = aw.Gjk;
    paramatz.Tro = aw.fgw();
    this.CJl.count = this.count;
    this.CJl.scene = 1;
    this.CJl.object_nonce_id = paramString1;
    this.CJl.YIZ = paramString2;
    this.CJl.ZIR = parambma;
    paramatz = bi.ABn;
    paramatz = this.CJl.YIY;
    boolean bool;
    if (parambui == null)
    {
      paramInt = 0;
      bi.a(paramatz, p.listOf(new r(Integer.valueOf(paramInt), Long.valueOf(this.hKN))));
      paramatz = new c.a();
      paramatz.otE = ((a)this.CJl);
      paramArrayOfByte = new bcq();
      paramArrayOfByte.setBaseResponse(new kd());
      paramArrayOfByte.getBaseResponse().akjO = new etl();
      paramatz.otF = ((a)paramArrayOfByte);
      paramatz.uri = "/cgi-bin/micromsg-bin/finderlikelive";
      paramatz.funcId = 564;
      c(paramatz.bEF());
      paramArrayOfByte = this.TAG;
      paramatz = new StringBuilder("[likeInfo]like live id:").append(this.liveId).append(" objectId:").append(this.hKN).append(" count:").append(this.count).append(",finder_username is empty:");
      if (this.CJl.YIZ != null) {
        break label434;
      }
      bool = true;
      label377:
      paramString1 = paramatz.append(bool).append(",live_identity:");
      paramatz = this.CJl.YIY;
      if (paramatz != null) {
        break label440;
      }
    }
    label434:
    label440:
    for (paramatz = null;; paramatz = Integer.valueOf(paramatz.ZEt))
    {
      Log.i(paramArrayOfByte, paramatz);
      AppMethodBeat.o(360316);
      return;
      paramInt = parambui.hLK;
      break;
      bool = false;
      break label377;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.n
 * JD-Core Version:    0.7.0.1
 */