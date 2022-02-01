package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "liveId", "", "objectId", "nonceId", "", "liveCookies", "", "scene", "", "sendIdList", "", "(JJLjava/lang/String;[BILjava/util/List;)V", "TAG", "getTAG", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends o<bid>
{
  public static final b CJU;
  private bic CJV;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(360243);
    CJU = new b((byte)0);
    AppMethodBeat.o(360243);
  }
  
  public ae(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(360237);
    this.TAG = "Finder.CgiFinderLiveGetRedPacketInfo";
    this.CJV = new bic();
    this.CJV.mMJ = paramLong1;
    this.CJV.object_id = paramLong2;
    this.CJV.object_nonce_id = paramString;
    paramString = this.CJV;
    bi localbi = bi.ABn;
    paramString.YIY = bi.dVu();
    this.CJV.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJV.YIZ = z.bAW();
    this.CJV.scene = paramInt;
    paramString = this.CJV.ZRj;
    if (paramString != null) {
      paramString.addAll((Collection)paramList);
    }
    paramString = new c.a();
    paramString.otE = ((a)this.CJV);
    paramArrayOfByte = new bid();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivegetredpacketinfo";
    paramString.funcId = 6271;
    c(paramString.bEF());
    Log.i(this.TAG, "CgiFinderLiveGetRedPacketInfo, init liveId:" + this.CJV.mMJ + ", objectId:" + this.CJV.object_id + ", nonceId:" + this.CJV.object_nonce_id + ", send_id_list:" + this.CJV.ZRj);
    AppMethodBeat.o(360237);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$Companion;", "", "()V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ae
 * JD-Core Version:    0.7.0.1
 */