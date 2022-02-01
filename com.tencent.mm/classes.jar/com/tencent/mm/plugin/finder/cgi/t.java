package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveMsgWithOffset;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgWithOffsetResponse;", "targetFinderUsername", "", "liveId", "", "objectId", "nonceId", "scene", "", "highLightId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "offsetInSecond", "isContinual", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "requestUniqueCode", "(Ljava/lang/String;JJLjava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IZLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgWithOffsetRequest;", "getRequestUniqueCode", "()Ljava/lang/String;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends o<azr>
{
  private final String Azj;
  private azq Azk;
  private final String TAG;
  
  public t(String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt1, String paramString3, bui parambui, int paramInt2, boolean paramBoolean, b paramb, String paramString4)
  {
    super(parambui);
    AppMethodBeat.i(336394);
    this.Azj = paramString4;
    this.TAG = "Finder.CgiFinderGetLiveMsgWithOffset";
    this.Azk = new azq();
    paramString4 = this.Azk;
    bi localbi = bi.ABn;
    paramString4.YIY = bi.dVu();
    this.Azk.YIZ = paramString1;
    this.Azk.mMJ = paramLong1;
    this.Azk.object_id = paramLong2;
    this.Azk.object_nonce_id = paramString2;
    this.Azk.ZKm = paramString3;
    this.Azk.ZKk = paramInt2;
    this.Azk.ZKl = paramBoolean;
    this.Azk.ZEQ = paramb;
    this.Azk.scene = paramInt1;
    paramString1 = bi.ABn;
    bi.a(this.Azk.YIY, p.listOf(new r(Integer.valueOf(parambui.AJo), Long.valueOf(paramLong2))));
    paramString1 = new c.a();
    paramString1.otE = ((a)this.Azk);
    paramString2 = new azr();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/findergetlivemsgwithoffset";
    paramString1.funcId = 5806;
    paramString1.longPolling = true;
    paramString1.longPollingTimeout = 25000;
    c(paramString1.bEF());
    Log.i(this.TAG, "CgiFinderGetLiveMsg init " + this.Azk.mMJ + ", object_id:" + d.hF(this.Azk.object_id) + ", nonce_id:" + this.Azk.object_nonce_id + ", offset:" + this.Azk.ZKk + ", continual:" + this.Azk.ZKl + ", username:" + this.Azk.YIZ + ", scene:" + this.Azk.scene + ",requestUniqueCode:" + this.Azj);
    AppMethodBeat.o(336394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */