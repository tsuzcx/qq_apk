package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAttendLottery;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAttendLotteryResponse;", "lotteryAttendType", "", "objectId", "", "liveCookie", "Lcom/tencent/mm/protobuf/ByteString;", "finderUserName", "", "(IJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAttendLotteryRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends o<bff>
{
  public static final a CJp;
  private bfe CJq;
  
  static
  {
    AppMethodBeat.i(360260);
    CJp = new a((byte)0);
    AppMethodBeat.o(360260);
  }
  
  public r(int paramInt, long paramLong, b paramb, String paramString)
  {
    AppMethodBeat.i(360253);
    this.CJq = new bfe();
    this.CJq.ZPk = paramInt;
    this.CJq.object_id = paramLong;
    bfe localbfe = this.CJq;
    bi localbi = bi.ABn;
    localbfe.YIY = bi.dVu();
    this.CJq.YJa = paramb;
    this.CJq.YIZ = paramString;
    paramb = new c.a();
    paramb.otE = ((a)this.CJq);
    paramString = new bff();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramb.otF = ((a)paramString);
    paramb.uri = "/cgi-bin/micromsg-bin/finderliveattendlottery";
    paramb.funcId = 4013;
    c(paramb.bEF());
    Log.i("Finder.CgiFinderLiveAttendLottery", "init " + this.CJq.ZPk + ", " + this.CJq.object_id);
    AppMethodBeat.o(360253);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAttendLottery$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.r
 * JD-Core Version:    0.7.0.1
 */