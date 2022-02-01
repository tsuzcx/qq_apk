package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends o<bge>
{
  private bgd CJy;
  private final String TAG;
  
  public v(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm)
  {
    AppMethodBeat.i(360236);
    this.TAG = "Finder.CgiFinderLiveCloseBattle";
    this.CJy = new bgd();
    this.CJy.mMJ = paramLong1;
    bgd localbgd = this.CJy;
    bi localbi = bi.ABn;
    localbgd.YIY = bi.dVu();
    this.CJy.object_id = paramLong2;
    this.CJy.object_nonce_id = paramString;
    this.CJy.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJy.YIZ = z.bAW();
    this.CJy.scene = paramInt;
    this.CJy.CER = parambdm;
    paramString = new c.a();
    paramString.otE = ((a)this.CJy);
    paramArrayOfByte = new bge();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderliveclosebattle";
    paramString.funcId = 4262;
    paramString = paramString.bEF();
    Log.i(this.TAG, "liveId:" + this.CJy.mMJ + " objectId:" + this.CJy.object_id + " nonceId:" + this.CJy.object_nonce_id + " username:" + this.CJy.YIZ + " scene:" + this.CJy.scene);
    c(paramString);
    AppMethodBeat.o(360236);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bge parambge);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.v
 * JD-Core Version:    0.7.0.1
 */