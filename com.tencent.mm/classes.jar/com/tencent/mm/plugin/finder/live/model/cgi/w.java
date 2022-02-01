package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "liveId", "", "commentContent", "", "liveMsgType", "", "liveCookies", "", "objectId", "nonceId", "finderUsername", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clientMsgId", "cdnServerIp", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "(JLjava/lang/String;I[BJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;)V", "TAG", "getCommentContent", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgReq;)V", "resultExt", "Lorg/json/JSONObject;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends o<bst>
{
  private final JSONObject AAn;
  private a CJA;
  public bss CJB;
  private final String CJz;
  private final String TAG;
  
  private w(long paramLong1, String paramString1, int paramInt, byte[] paramArrayOfByte, long paramLong2, String paramString2, String paramString3, bui parambui, String paramString4, String paramString5, bma parambma)
  {
    super(parambui);
    AppMethodBeat.i(360241);
    this.CJz = paramString1;
    this.TAG = "Finder.CgiFinderLiveCommentPost";
    this.AAn = new JSONObject();
    this.CJA = null;
    this.CJB = new bss();
    paramString1 = this.CJB;
    bi localbi = bi.ABn;
    paramString1.ZEc = bi.a(parambui);
    this.CJB.liveId = paramLong1;
    this.CJB.hKN = paramLong2;
    this.CJB.kLn = paramString4;
    this.CJB.Ayh = b.cX(paramArrayOfByte);
    paramString1 = this.CJB;
    paramArrayOfByte = new bke();
    paramArrayOfByte.content = this.CJz;
    paramArrayOfByte.nickname = z.bAO();
    paramArrayOfByte.type = paramInt;
    paramString4 = ah.aiuX;
    paramString1.CIc = paramArrayOfByte;
    this.CJB.object_nonce_id = paramString2;
    this.CJB.YIZ = paramString3;
    paramString1 = this.CJB;
    paramArrayOfByte = new bsr();
    paramArrayOfByte.aaav = paramString5;
    paramString2 = ah.aiuX;
    paramString1.ZPb = paramArrayOfByte;
    this.CJB.ZIR = parambma;
    paramString1 = bi.ABn;
    bi.a(this.CJB.ZEc, p.listOf(new r(Integer.valueOf(parambui.hLK), Long.valueOf(paramLong2))));
    d.Pmb.kY(540999694, 6);
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CJB);
    paramArrayOfByte = new bst();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramArrayOfByte);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderpostlivemsg";
    paramString1.funcId = 3896;
    c(paramString1.bEF());
    paramArrayOfByte = this.TAG;
    paramString2 = new StringBuilder("CgiFinderLiveCommentPost init ").append(this.CJB.liveId).append(",msgId:").append(this.CJB.kLn).append(',').append(z.bAO()).append(',').append(this.CJz).append(",live_identity:");
    paramString1 = this.CJB.ZEc;
    if (paramString1 == null)
    {
      paramString1 = null;
      paramString1 = paramString2.append(paramString1).append(",nonceId is empty?:");
      paramString2 = (CharSequence)this.CJB.object_nonce_id;
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label559;
      }
    }
    label559:
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool + ",finder_username:" + this.CJB.YIZ);
      AppMethodBeat.o(360241);
      return;
      paramString1 = Integer.valueOf(paramString1.ZEt);
      break;
    }
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bst parambst);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.w
 * JD-Core Version:    0.7.0.1
 */