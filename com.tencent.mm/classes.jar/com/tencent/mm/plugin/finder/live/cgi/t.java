package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRandomMicResponse;", "liveCookie", "", "liveId", "", "objectId", "objectNonceId", "", "finderUserName", "opCode", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic$CallBack;", "([BJJLjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRandomMicRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends c<bln>
{
  private final a CvE;
  private blm CvF;
  private final String TAG;
  
  public t(byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(351142);
    this.CvE = parama;
    this.TAG = "Finder.CgiFinderLiveRandomMic";
    this.CvF = new blm();
    this.CvF.YJa = b.cX(paramArrayOfByte);
    this.CvF.mMJ = paramLong1;
    this.CvF.object_id = paramLong2;
    this.CvF.object_nonce_id = paramString1;
    this.CvF.YIZ = paramString2;
    paramArrayOfByte = this.CvF;
    paramString1 = bi.ABn;
    paramArrayOfByte.YIY = bi.dVu();
    this.CvF.ZlE = paramInt;
    paramArrayOfByte = new c.a();
    paramArrayOfByte.otE = ((a)this.CvF);
    paramString1 = new bln();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramArrayOfByte.otF = ((a)paramString1);
    paramArrayOfByte.uri = "/cgi-bin/micromsg-bin/finderliverandommic";
    paramArrayOfByte.funcId = 4136;
    c(paramArrayOfByte.bEF());
    Log.i(this.TAG, "init: liveId:" + this.CvF.mMJ + ", objectId:" + this.CvF.object_id + ", objectNonceId:" + this.CvF.object_nonce_id + ", finderUserName:" + this.CvF.YIZ + ", opCode:" + this.CvF.ZlE);
    AppMethodBeat.o(351142);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRandomMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bln parambln);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.t
 * JD-Core Version:    0.7.0.1
 */