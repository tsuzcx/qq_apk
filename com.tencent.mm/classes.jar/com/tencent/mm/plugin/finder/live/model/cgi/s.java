package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "micFinderUsername", "micObjectId", "", "micLiveId", "timeout", "", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;Ljava/lang/String;JJIJLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "getFinderBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareRequest;", "requestExt", "Lorg/json/JSONObject;", "getRequestId", "()J", "resultExt", "getTimeout", "()I", "actionExt", "addDebugData", "", "resp", "dumpFinderObject", "sb", "Ljava/lang/StringBuilder;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "dumpFinderRecoverLiveInfo", "recoverLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRecoverLiveInfo;", "dumpResp", "dumpVisibilityFileList", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "initReqResp", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class s
  extends k<aqb>
{
  private final String TAG;
  private final int timeout;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private aqa ulh;
  private final aov uli;
  private final long ulj;
  private final a ulk;
  
  private s(aov paramaov, String paramString, long paramLong, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246336);
    this.uli = paramaov;
    this.timeout = 5000;
    this.ulj = paramLong;
    this.ulk = parama;
    this.TAG = "Finder.CgiFinderLivePrepare";
    this.ulh = new aqa();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    this.ulh.LBM = this.uli;
    this.ulh.LAt = paramString;
    this.ulh.LBN = null;
    this.ulh.LBO = 0L;
    this.ulh.LBP = 0L;
    this.tuL.put("mic_live_id", 0L);
    this.tuL.put("mic_object_id", 0L);
    this.ttQ.put("username", null);
    Log.i(this.TAG, "CgiFinderLivePrepare finderUsername " + paramString + " micFinderUsername " + null + " micObjectId 0 micLiveId 0");
    paramaov = new d.a();
    paramaov.c((a)this.ulh);
    paramString = new aqb();
    paramString.setBaseResponse(new BaseResponse());
    paramString.getBaseResponse().ErrMsg = new dqi();
    paramaov.d((a)paramString);
    paramaov.MB("/cgi-bin/micromsg-bin/findercreateliveprepare");
    paramaov.sG(5874);
    c(paramaov.aXF());
    AppMethodBeat.o(246336);
  }
  
  private static void a(aqb paramaqb)
  {
    AppMethodBeat.i(246335);
    Object localObject = y.vXH;
    if ((y.dCM()) && (paramaqb.LBX.isEmpty()))
    {
      localObject = c.vCb;
      if (((Number)c.dwm().value()).intValue() == 1)
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < 50)
        {
          avh localavh = new avh();
          localavh.KRd = "finder_debug_audien_file_".concat(String.valueOf(i));
          localavh.title = "测试列表".concat(String.valueOf(i));
          ((LinkedList)localObject).add(localavh);
          i += 1;
        }
        paramaqb.LBX = ((LinkedList)localObject);
      }
    }
    AppMethodBeat.o(246335);
  }
  
  private final void a(StringBuilder paramStringBuilder, LinkedList<avh> paramLinkedList)
  {
    AppMethodBeat.i(246334);
    try
    {
      paramStringBuilder.append("VisibilityFileList:");
      if (paramLinkedList == null) {
        break label138;
      }
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        avh localavh = (avh)paramLinkedList.next();
        paramStringBuilder.append("[" + localavh.title + ':' + localavh.KRd + ']');
      }
      AppMethodBeat.o(246334);
    }
    catch (Exception paramStringBuilder)
    {
      paramLinkedList = y.vXH;
      y.a(paramStringBuilder, this.TAG + ",dumpVisibilityFileList");
      AppMethodBeat.o(246334);
      return;
    }
    return;
    label138:
    AppMethodBeat.o(246334);
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return com.tencent.mm.plugin.finder.cgi.report.b.tye;
  }
  
  public final JSONObject cXV()
  {
    return this.tuL;
  }
  
  public final JSONObject cXW()
  {
    return this.ttQ;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "requestId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, long paramLong, aqb paramaqb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.s
 * JD-Core Version:    0.7.0.1
 */