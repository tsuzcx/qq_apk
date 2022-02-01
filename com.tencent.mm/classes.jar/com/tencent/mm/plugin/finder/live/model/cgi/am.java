package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "micFinderUsername", "micObjectId", "", "micLiveId", "timeout", "", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;Ljava/lang/String;JJIJLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "getFinderBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareRequest;", "requestExt", "Lorg/json/JSONObject;", "getRequestId", "()J", "resultExt", "getTimeout", "()I", "actionExt", "addDebugData", "", "resp", "dumpFinderObject", "sb", "Ljava/lang/StringBuilder;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "dumpFinderRecoverLiveInfo", "recoverLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRecoverLiveInfo;", "dumpResp", "dumpSpamRisk", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "dumpVisibilityFileList", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "initReqResp", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preLoadImg", "saveFuncSwitchFlag", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends o<awa>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final long Bjl;
  private final atz CJv;
  private final a CKj;
  private avz CKk;
  private final String TAG;
  private final int timeout;
  
  private am(atz paramatz, String paramString, long paramLong, a parama)
  {
    AppMethodBeat.i(360278);
    this.CJv = paramatz;
    this.timeout = 5000;
    this.Bjl = paramLong;
    this.CKj = parama;
    this.TAG = "Finder.CgiFinderLivePrepare";
    this.CKk = new avz();
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CKk.YIY = this.CJv;
    this.CKk.YIZ = paramString;
    this.CKk.ZGh = null;
    this.CKk.ZGi = 0L;
    this.CKk.ZGj = 0L;
    this.ABH.put("mic_live_id", 0L);
    this.ABH.put("mic_object_id", 0L);
    this.AAn.put("username", null);
    Log.i(this.TAG, "CgiFinderLivePrepare finderUsername " + paramString + " micFinderUsername " + null + " micObjectId 0 micLiveId 0");
    paramatz = new c.a();
    paramatz.otE = ((com.tencent.mm.bx.a)this.CKk);
    paramString = new awa();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramatz.otF = ((com.tencent.mm.bx.a)paramString);
    paramatz.uri = "/cgi-bin/micromsg-bin/findercreateliveprepare";
    paramatz.funcId = 5874;
    c(paramatz.bEF());
    AppMethodBeat.o(360278);
  }
  
  private static void a(awa paramawa)
  {
    AppMethodBeat.i(360300);
    Object localObject = aw.Gjk;
    if (aw.bgV()) {
      if (paramawa.ZGr.isEmpty())
      {
        localObject = com.tencent.d.a.a.a.a.a.ahiX;
        if (((Number)com.tencent.d.a.a.a.a.a.jSI().bmg()).intValue() == 1) {
          localObject = new LinkedList();
        }
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      bfh localbfh = new bfh();
      localbfh.YPy = s.X("finder_debug_audien_file_", Integer.valueOf(i));
      localbfh.title = s.X("测试列表", Integer.valueOf(i));
      ((LinkedList)localObject).add(localbfh);
      if (j >= 50)
      {
        paramawa.ZGr = ((LinkedList)localObject);
        if (paramawa.ZGw == null)
        {
          paramawa.ZGw = new fgq();
          localObject = paramawa.ZGw;
          if (localObject != null) {
            ((fgq)localObject).abGt = "测试";
          }
          paramawa = paramawa.ZGw;
          if (paramawa != null) {
            paramawa.abGs = "https://weixin110.qq.com/security/newreadtemplate?t=roomlive/verify";
          }
        }
        AppMethodBeat.o(360300);
        return;
      }
    }
  }
  
  private final void a(StringBuilder paramStringBuilder, LinkedList<bfh> paramLinkedList)
  {
    AppMethodBeat.i(360290);
    try
    {
      paramStringBuilder.append("VisibilityFileList:");
      if (paramLinkedList != null)
      {
        paramLinkedList = ((Iterable)paramLinkedList).iterator();
        while (paramLinkedList.hasNext())
        {
          bfh localbfh = (bfh)paramLinkedList.next();
          paramStringBuilder.append("[" + localbfh.title + ':' + localbfh.YPy + ']');
        }
      }
      AppMethodBeat.o(360290);
    }
    catch (Exception paramStringBuilder)
    {
      paramLinkedList = aw.Gjk;
      aw.a(paramStringBuilder, s.X(this.TAG, ",dumpVisibilityFileList"));
      AppMethodBeat.o(360290);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "requestId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, long paramLong, awa paramawa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.am
 * JD-Core Version:    0.7.0.1
 */