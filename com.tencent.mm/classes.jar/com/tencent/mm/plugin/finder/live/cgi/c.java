package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveActivitiyClickReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivitiyClickReportResponse;", "activityId", "", "(Ljava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivitiyClickReportRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.findersdk.b.c<bbs>
{
  private final String TAG;
  private bbr xXQ;
  
  public c(String paramString)
  {
    AppMethodBeat.i(284947);
    this.TAG = "Finder.CgiFinderLiveActivitiyClickReport";
    this.xXQ = new bbr();
    this.xXQ.OIw = paramString;
    this.xXQ.SNy = 1;
    this.xXQ.RLN = z.bdh();
    Object localObject = this.xXQ;
    ao localao = ao.xcj;
    ((bbr)localObject).RLM = ao.dnO();
    Log.i(this.TAG, "CgiFinderLiveActivitiyClickReport init " + paramString + '}');
    paramString = new d.a();
    paramString.c((a)this.xXQ);
    localObject = new bbs();
    ((bbs)localObject).setBaseResponse(new jh());
    ((bbs)localObject).getBaseResponse().Tef = new eaf();
    paramString.d((a)localObject);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivequestactivityclickreport");
    paramString.vD(5246);
    c(paramString.bgN());
    AppMethodBeat.o(284947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.c
 * JD-Core Version:    0.7.0.1
 */