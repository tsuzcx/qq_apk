package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetDeliveryDetail;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetDeliveryDetailResponse;", "finder_username", "", "liveCookie", "Lcom/tencent/mm/protobuf/ByteString;", "objectId", "", "liveId", "objectNonceId", "cmdId", "", "reqBuffer", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetGiftDetailReq;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderLiveGetGiftDetailReq;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetDeliveryDetailRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends o<bhn>
{
  public static final a CJO;
  private bhm CJP;
  
  static
  {
    AppMethodBeat.i(360232);
    CJO = new a((byte)0);
    AppMethodBeat.o(360232);
  }
  
  public ab(String paramString1, b paramb, long paramLong1, long paramLong2, String paramString2, bhu parambhu)
  {
    AppMethodBeat.i(360224);
    this.CJP = new bhm();
    bhm localbhm = this.CJP;
    bi localbi = bi.ABn;
    localbhm.YIY = bi.a(this.Auc);
    this.CJP.YIZ = paramString1;
    this.CJP.YJa = paramb;
    this.CJP.object_id = paramLong1;
    this.CJP.mMJ = paramLong2;
    this.CJP.object_nonce_id = paramString2;
    this.CJP.Tps = 1;
    paramString1 = this.CJP;
    paramb = aw.Gjk;
    paramString1.ZQU = aw.j((a)parambhu);
    Log.i("Finder.CgiFinderLiveGetDeliveryDetail", "#init objectId=" + paramLong1 + " liveId=" + paramLong2 + " objectNonceId=" + paramString2 + " cmdId=1 reqBuffer.package_id=" + parambhu.ZRa);
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CJP);
    paramb = new bhn();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramb);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivegetdeliverydetail";
    paramString1.funcId = 4119;
    c(paramString1.bEF());
    AppMethodBeat.o(360224);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetDeliveryDetail$Companion;", "", "()V", "MMFinderLiveGetDeliveryDetail_Gift", "", "RET_CODE_EXPIRED", "RET_CODE_RUNOUT", "RET_CODE_SUCC", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ab
 * JD-Core Version:    0.7.0.1
 */