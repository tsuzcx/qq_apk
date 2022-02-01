package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "sdkUserId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class u
  extends k<awz>
{
  private final String TAG;
  private awy uln;
  private final a ulo;
  
  public u(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246340);
    this.ulo = parama;
    this.TAG = "Finder.CgiFinderLiveRefreshMic";
    this.uln = new awy();
    this.uln.hyH = paramLong1;
    parama = this.uln;
    am localam = am.tuw;
    parama.LBM = am.cXY();
    this.uln.object_id = paramLong2;
    this.uln.object_nonce_id = paramString1;
    this.uln.LAt = z.aUg();
    this.uln.scene = paramInt;
    this.uln.LFp = b.cD(paramArrayOfByte);
    this.uln.Lmn = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)this.uln);
    paramArrayOfByte = new awz();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramArrayOfByte);
    paramString1.MB("/cgi-bin/micromsg-bin/finderliverefreshmicwithaudience");
    paramString1.sG(4180);
    paramString1 = paramString1.aXF();
    Log.i(this.TAG, "liveId:" + this.uln.hyH + " objectId:" + this.uln.object_id + " objectNonceId:" + this.uln.object_nonce_id + " scene:" + this.uln.scene + " mic_sdk_user_id:" + this.uln.Lmn);
    c(paramString1);
    AppMethodBeat.o(246340);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void c(int paramInt1, int paramInt2, awz paramawz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.u
 * JD-Core Version:    0.7.0.1
 */