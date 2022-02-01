package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "liveId", "", "objectId", "nonceId", "", "liveCookies", "", "scene", "", "sendIdList", "", "(JJLjava/lang/String;[BILjava/util/List;)V", "TAG", "getTAG", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder_release"})
public final class y
  extends n<azu>
{
  public static final b yjF;
  private final String TAG;
  private azt yjE;
  
  static
  {
    AppMethodBeat.i(271607);
    yjF = new b((byte)0);
    AppMethodBeat.o(271607);
  }
  
  public y(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(271606);
    this.TAG = "Finder.CgiFinderLiveGetRedPacketInfo";
    this.yjE = new azt();
    this.yjE.klE = paramLong1;
    this.yjE.object_id = paramLong2;
    this.yjE.object_nonce_id = paramString;
    paramString = this.yjE;
    ao localao = ao.xcj;
    paramString.RLM = ao.dnO();
    this.yjE.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yjE.RLN = z.bdh();
    this.yjE.scene = paramInt;
    paramString = this.yjE.SLr;
    if (paramString != null) {
      paramString.addAll((Collection)paramList);
    }
    paramString = new d.a();
    paramString.c((a)this.yjE);
    paramArrayOfByte = new azu();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivegetredpacketinfo");
    paramString.vD(6271);
    c(paramString.bgN());
    Log.i(this.TAG, "CgiFinderLiveGetRedPacketInfo, init liveId:" + this.yjE.klE + ", objectId:" + this.yjE.object_id + ", nonceId:" + this.yjE.object_nonce_id + ", send_id_list:" + this.yjE.SLr);
    AppMethodBeat.o(271606);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, azu paramazu);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$Companion;", "", "()V", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.y
 * JD-Core Version:    0.7.0.1
 */