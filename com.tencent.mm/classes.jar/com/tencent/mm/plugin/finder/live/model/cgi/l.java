package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "liveId", "", "commentContent", "", "liveMsgType", "", "liveCookies", "", "objectId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "(JLjava/lang/String;I[BJLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;)V", "TAG", "getCommentContent", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class l
  extends k<bap>
{
  private final String TAG;
  private a ukP;
  private bao ukQ;
  private final String ukR;
  
  public l(long paramLong1, String paramString, int paramInt, byte[] paramArrayOfByte, long paramLong2, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246319);
    this.ukR = paramString;
    this.TAG = "Finder.CgiFinderLiveCommentPost";
    this.ukP = parama;
    this.ukQ = new bao();
    paramString = this.ukQ;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    this.ukQ.liveId = paramLong1;
    this.ukQ.hFK = paramLong2;
    paramString = this.ukQ;
    parama = y.vXH;
    paramString.fQY = y.dCV();
    this.ukQ.LDx = b.cD(paramArrayOfByte);
    paramString = this.ukQ;
    paramArrayOfByte = new awq();
    paramArrayOfByte.content = this.ukR;
    paramArrayOfByte.nickname = z.aUa();
    paramArrayOfByte.type = paramInt;
    paramString.uke = paramArrayOfByte;
    paramString = new d.a();
    paramString.c((a)this.ukQ);
    paramArrayOfByte = new bap();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)paramArrayOfByte);
    paramString.MB("/cgi-bin/micromsg-bin/finderpostlivemsg");
    paramString.sG(3896);
    c(paramString.aXF());
    Log.i(this.TAG, "CgiFinderLiveCommentPost init " + this.ukQ.liveId + ",msgId:" + this.ukQ.fQY + ',' + z.aUa() + ',' + this.ukR);
    AppMethodBeat.o(246319);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bap parambap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.l
 * JD-Core Version:    0.7.0.1
 */