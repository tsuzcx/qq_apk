package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.b.g;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "finderUsername", "", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "ticket", "Lcom/tencent/mm/protobuf/ByteString;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "visibilityMode", "", "visibilityList", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class e
  extends k<aqd>
{
  private final String TAG;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private a ukC;
  private aqc ukD;
  
  private e(String paramString, FinderObjectDesc paramFinderObjectDesc, axk paramaxk, int paramInt, LinkedList<String> paramLinkedList, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246303);
    this.TAG = "Finder.CgiFinderCreateLive";
    this.ukC = parama;
    this.ukD = new aqc();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    this.ukD.objectDesc = paramFinderObjectDesc;
    this.ukD.LBZ = null;
    parama = this.ukD;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      paramFinderObjectDesc = d.UTF_8;
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(246303);
        throw paramString;
      }
      paramFinderObjectDesc = paramString.getBytes(paramFinderObjectDesc);
      p.g(paramFinderObjectDesc, "(this as java.lang.String).getBytes(charset)");
      parama.clientId = (g.getMessageDigest(paramFinderObjectDesc) + '_' + System.currentTimeMillis());
      this.ukD.finderUsername = paramString;
      paramFinderObjectDesc = this.ukD;
      parama = am.tuw;
      paramFinderObjectDesc.LAI = am.cXY();
      this.ukD.LCb = paramaxk;
      this.ukD.LCc = paramInt;
      this.ukD.LCd = paramLinkedList;
      this.tuL.put("username", paramString);
      this.tuL.put("clientId", this.ukD.clientId);
      paramString = new d.a();
      paramString.c((a)this.ukD);
      paramFinderObjectDesc = new aqd();
      paramFinderObjectDesc.setBaseResponse(new BaseResponse());
      paramFinderObjectDesc.getBaseResponse().ErrMsg = new dqi();
      paramString.d((a)paramFinderObjectDesc);
      paramString.MB("/cgi-bin/micromsg-bin/findercreatelive");
      paramString.sG(3686);
      c(paramString.aXF());
      paramFinderObjectDesc = this.TAG;
      paramaxk = new StringBuilder("CgiFinderCreateLive init ").append(this.ukD.clientId).append(',').append(this.ukD.finderUsername).append(',').append(this.ukD.objectDesc).append(", tag:[");
      paramString = this.ukD.LCb;
      if (paramString == null) {
        break label517;
      }
    }
    label517:
    for (paramString = paramString.qHk;; paramString = null)
    {
      paramaxk = paramaxk.append(paramString).append('-');
      paramLinkedList = this.ukD.LCb;
      paramString = localObject;
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.LHU;
        paramString = localObject;
        if (paramLinkedList != null) {
          paramString = paramLinkedList.qHk;
        }
      }
      Log.i(paramFinderObjectDesc, paramString + "],visibility_mode:" + this.ukD.LCc + ",list size:" + this.ukD.LCd.size());
      AppMethodBeat.o(246303);
      return;
      paramFinderObjectDesc = null;
      break;
    }
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final JSONObject cXV()
  {
    return this.tuL;
  }
  
  public final JSONObject cXW()
  {
    return this.ttQ;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aqd paramaqd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */