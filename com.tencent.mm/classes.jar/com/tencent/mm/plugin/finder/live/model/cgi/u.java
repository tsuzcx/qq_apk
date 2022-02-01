package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "liveId", "", "commentContent", "", "liveMsgType", "", "liveCookies", "", "objectId", "nonceId", "finderUsername", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clientMsgId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "(JLjava/lang/String;I[BJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;)V", "TAG", "getCommentContent", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgReq;", "resultExt", "Lorg/json/JSONObject;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class u
  extends n<bha>
{
  private final String TAG;
  private final JSONObject xbw;
  private a yjs;
  private bgz yjt;
  private final String yju;
  
  public u(long paramLong1, String paramString1, int paramInt, byte[] paramArrayOfByte, long paramLong2, String paramString2, String paramString3, bid parambid, String paramString4, a parama)
  {
    super(parambid);
    AppMethodBeat.i(274834);
    this.yju = paramString1;
    this.TAG = "Finder.CgiFinderLiveCommentPost";
    this.xbw = new JSONObject();
    this.yjs = parama;
    this.yjt = new bgz();
    paramString1 = this.yjt;
    parama = ao.xcj;
    paramString1.SDi = ao.a(parambid);
    this.yjt.liveId = paramLong1;
    this.yjt.xbk = paramLong2;
    this.yjt.ilo = paramString4;
    this.yjt.xak = b.cU(paramArrayOfByte);
    paramString1 = this.yjt;
    paramArrayOfByte = new bbd();
    paramArrayOfByte.content = this.yju;
    paramArrayOfByte.nickname = z.bdb();
    paramArrayOfByte.type = paramInt;
    paramString1.yig = paramArrayOfByte;
    this.yjt.object_nonce_id = paramString2;
    this.yjt.RLN = paramString3;
    paramString1 = ao.xcj;
    ao.a(this.yjt.SDi, j.listOf(new o(Integer.valueOf(parambid.fGo), Long.valueOf(paramLong2))));
    d.Jcm.jq(540999694, 6);
    paramString1 = new d.a();
    paramString1.c((a)this.yjt);
    paramArrayOfByte = new bha();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramArrayOfByte);
    paramString1.TW("/cgi-bin/micromsg-bin/finderpostlivemsg");
    paramString1.vD(3896);
    c(paramString1.bgN());
    paramArrayOfByte = this.TAG;
    paramString2 = new StringBuilder("CgiFinderLiveCommentPost init ").append(this.yjt.liveId).append(",msgId:").append(this.yjt.ilo).append(',').append(z.bdb()).append(',').append(this.yju).append(",live_identity:");
    paramString1 = this.yjt.SDi;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.SDv);
      paramString1 = paramString2.append(paramString1).append(",nonceId is empty?:");
      paramString2 = (CharSequence)this.yjt.object_nonce_id;
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label512;
      }
    }
    label512:
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool + ",finder_username:" + this.yjt.RLN);
      AppMethodBeat.o(274834);
      return;
      paramString1 = null;
      break;
    }
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bha parambha);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.u
 * JD-Core Version:    0.7.0.1
 */