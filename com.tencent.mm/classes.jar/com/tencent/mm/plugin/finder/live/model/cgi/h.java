package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;[BJJLjava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class h
  extends k<ass>
{
  private final String TAG;
  private a ukI;
  private asr ukJ;
  
  private h(aov paramaov, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt, boolean paramBoolean, avk paramavk, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246312);
    this.TAG = "Finder.CgiFinderGetLiveMsg";
    this.ukI = parama;
    this.ukJ = new asr();
    this.ukJ.LAI = paramaov;
    this.ukJ.finderUsername = paramString1;
    this.ukJ.LDx = b.cD(paramArrayOfByte);
    this.ukJ.liveId = paramLong1;
    this.ukJ.hFK = paramLong2;
    this.ukJ.object_nonce_id = paramString2;
    this.ukJ.scene = paramInt;
    this.ukJ.AqQ = paramBoolean;
    this.ukJ.LDy = paramavk;
    paramaov = new d.a();
    paramaov.c((a)this.ukJ);
    paramString1 = new ass();
    paramString1.setBaseResponse(new BaseResponse());
    paramString1.getBaseResponse().ErrMsg = new dqi();
    paramaov.d((a)paramString1);
    paramaov.MB("/cgi-bin/micromsg-bin/findergetlivemsg");
    paramaov.sG(3976);
    c(paramaov.aXF());
    paramaov = this.TAG;
    paramString1 = new StringBuilder("CgiFinderGetLiveMsg init ").append(this.ukJ.liveId).append(',').append(this.ukJ.finderUsername).append(',').append(this.ukJ.scene).append(",liveCookies is null:");
    if (this.ukJ.LDx == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i(paramaov, paramBoolean);
      AppMethodBeat.o(246312);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, ass paramass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */