package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class d
  extends k<avm>
{
  private final String TAG;
  private avl ukA;
  private final a ukB;
  
  public d(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, aut paramaut, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246301);
    this.ukB = parama;
    this.TAG = "Finder.CgiFinderCloseLiveMic";
    this.ukA = new avl();
    this.ukA.hyH = paramLong1;
    parama = this.ukA;
    am localam = am.tuw;
    parama.LBM = am.cXY();
    this.ukA.object_id = paramLong2;
    this.ukA.object_nonce_id = paramString;
    this.ukA.LAt = z.aUg();
    this.ukA.scene = paramInt;
    this.ukA.LFp = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    this.ukA.uio = paramaut;
    paramString = new com.tencent.mm.ak.d.a();
    paramString.c((a)this.ukA);
    paramArrayOfByte = new avm();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)paramArrayOfByte);
    paramString.MB("/cgi-bin/micromsg-bin/finderliveclosemicwithaudience");
    paramString.sG(4142);
    paramString = paramString.aXF();
    Log.i(this.TAG, "liveId:" + this.ukA.hyH + " objectId:" + this.ukA.object_id + " objectNonceId:" + this.ukA.object_nonce_id + " scene:" + this.ukA.scene);
    c(paramString);
    AppMethodBeat.o(246301);
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return com.tencent.mm.plugin.finder.cgi.report.b.tye;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void onCgiBack(int paramInt1, int paramInt2, String paramString, avm paramavm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.d
 * JD-Core Version:    0.7.0.1
 */