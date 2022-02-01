package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends o<bcv>
{
  private bcu CJn;
  private final String TAG;
  
  public p(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm)
  {
    AppMethodBeat.i(360310);
    this.TAG = "Finder.CgiFinderLiveAcceptBattle";
    this.CJn = new bcu();
    this.CJn.mMJ = paramLong1;
    bcu localbcu = this.CJn;
    bi localbi = bi.ABn;
    localbcu.YIY = bi.dVu();
    this.CJn.object_id = paramLong2;
    this.CJn.object_nonce_id = paramString;
    this.CJn.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJn.YIZ = z.bAW();
    this.CJn.scene = paramInt;
    this.CJn.CER = parambdm;
    paramString = new c.a();
    paramString.otE = ((a)this.CJn);
    paramArrayOfByte = new bcv();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderliveacceptbattle";
    paramString.funcId = 5804;
    paramString = paramString.bEF();
    Log.i(this.TAG, "liveId:" + this.CJn.mMJ + " objectId:" + this.CJn.object_id + " nonceId:" + this.CJn.object_nonce_id + " username:" + this.CJn.YIZ + " scene:" + this.CJn.scene);
    c(paramString);
    AppMethodBeat.o(360310);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bcv parambcv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.p
 * JD-Core Version:    0.7.0.1
 */