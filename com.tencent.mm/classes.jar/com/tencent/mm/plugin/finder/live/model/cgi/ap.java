package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "sdkUserId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends o<blw>
{
  private final a CKp;
  private blv CKq;
  private final String TAG;
  
  public ap(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, a parama)
  {
    AppMethodBeat.i(360197);
    this.CKp = parama;
    this.TAG = "Finder.CgiFinderLiveRefreshMic";
    this.CKq = new blv();
    this.CKq.mMJ = paramLong1;
    parama = this.CKq;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKq.object_id = paramLong2;
    this.CKq.object_nonce_id = paramString1;
    this.CKq.YIZ = z.bAW();
    this.CKq.scene = paramInt;
    this.CKq.YJa = b.cX(paramArrayOfByte);
    this.CKq.ZlX = paramString2;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CKq);
    paramArrayOfByte = new blw();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramArrayOfByte);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderliverefreshmicwithaudience";
    paramString1.funcId = 4180;
    paramString1 = paramString1.bEF();
    Log.i(this.TAG, "liveId:" + this.CKq.mMJ + " objectId:" + this.CKq.object_id + " objectNonceId:" + this.CKq.object_nonce_id + " scene:" + this.CKq.scene + " mic_sdk_user_id:" + this.CKq.ZlX);
    c(paramString1);
    AppMethodBeat.o(360197);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void b(int paramInt1, int paramInt2, blw paramblw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ap
 * JD-Core Version:    0.7.0.1
 */