package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "micFinderUsername", "micObjectId", "", "micLiveId", "timeout", "", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;Ljava/lang/String;JJIJLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "getFinderBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareRequest;", "requestExt", "Lorg/json/JSONObject;", "getRequestId", "()J", "resultExt", "getTimeout", "()I", "actionExt", "addDebugData", "", "resp", "dumpFinderObject", "sb", "Ljava/lang/StringBuilder;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "dumpFinderRecoverLiveInfo", "recoverLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRecoverLiveInfo;", "dumpResp", "dumpSpamRisk", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "dumpVisibilityFileList", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "initReqResp", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preLoadImg", "CallBack", "plugin-finder_release"})
public final class ae
  extends n<arr>
{
  private final String TAG;
  private final int timeout;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private arq yjQ;
  private final long yjR;
  private final a yjS;
  private final aqe yjp;
  
  private ae(aqe paramaqe, String paramString, long paramLong, a parama)
  {
    AppMethodBeat.i(284702);
    this.yjp = paramaqe;
    this.timeout = 5000;
    this.yjR = paramLong;
    this.yjS = parama;
    this.TAG = "Finder.CgiFinderLivePrepare";
    this.yjQ = new arq();
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yjQ.RLM = this.yjp;
    this.yjQ.RLN = paramString;
    this.yjQ.SEF = null;
    this.yjQ.SEG = 0L;
    this.yjQ.SEH = 0L;
    this.xcu.put("mic_live_id", 0L);
    this.xcu.put("mic_object_id", 0L);
    this.xbw.put("username", null);
    Log.i(this.TAG, "CgiFinderLivePrepare finderUsername " + paramString + " micFinderUsername " + null + " micObjectId 0 micLiveId 0");
    paramaqe = new d.a();
    paramaqe.c((com.tencent.mm.cd.a)this.yjQ);
    paramString = new arr();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramaqe.d((com.tencent.mm.cd.a)paramString);
    paramaqe.TW("/cgi-bin/micromsg-bin/findercreateliveprepare");
    paramaqe.vD(5874);
    c(paramaqe.bgN());
    AppMethodBeat.o(284702);
  }
  
  private static void a(arr paramarr)
  {
    AppMethodBeat.i(284701);
    Object localObject = aj.AGc;
    if (aj.eej())
    {
      if (paramarr.SEP.isEmpty())
      {
        localObject = com.tencent.c.a.a.a.a.a.Zlt;
        if (((Number)com.tencent.c.a.a.a.a.a.imf().aSr()).intValue() == 1)
        {
          localObject = new LinkedList();
          int i = 0;
          while (i < 50)
          {
            ayj localayj = new ayj();
            localayj.RRY = "finder_debug_audien_file_".concat(String.valueOf(i));
            localayj.title = "测试列表".concat(String.valueOf(i));
            ((LinkedList)localObject).add(localayj);
            i += 1;
          }
          paramarr.SEP = ((LinkedList)localObject);
        }
      }
      if (paramarr.SEU == null)
      {
        paramarr.SEU = new elx();
        localObject = paramarr.SEU;
        if (localObject != null) {
          ((elx)localObject).UnR = "测试";
        }
        paramarr = paramarr.SEU;
        if (paramarr != null)
        {
          paramarr.UnQ = "https://weixin110.qq.com/security/newreadtemplate?t=roomlive/verify";
          AppMethodBeat.o(284701);
          return;
        }
      }
    }
    AppMethodBeat.o(284701);
  }
  
  private final void a(StringBuilder paramStringBuilder, LinkedList<ayj> paramLinkedList)
  {
    AppMethodBeat.i(284699);
    try
    {
      paramStringBuilder.append("VisibilityFileList:");
      if (paramLinkedList == null) {
        break label138;
      }
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        ayj localayj = (ayj)paramLinkedList.next();
        paramStringBuilder.append("[" + localayj.title + ':' + localayj.RRY + ']');
      }
      AppMethodBeat.o(284699);
    }
    catch (Exception paramStringBuilder)
    {
      paramLinkedList = aj.AGc;
      aj.a(paramStringBuilder, this.TAG + ",dumpVisibilityFileList");
      AppMethodBeat.o(284699);
      return;
    }
    return;
    label138:
    AppMethodBeat.o(284699);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "requestId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, long paramLong, arr paramarr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ae
 * JD-Core Version:    0.7.0.1
 */