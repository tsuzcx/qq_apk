package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveActivitiyClickReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivitiyClickReportResponse;", "activityId", "", "(Ljava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivitiyClickReportRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.findersdk.b.c<blj>
{
  private bli CuW;
  private final String TAG;
  
  public c(String paramString)
  {
    AppMethodBeat.i(351101);
    this.TAG = "Finder.CgiFinderLiveActivitiyClickReport";
    this.CuW = new bli();
    this.CuW.Vyi = paramString;
    this.CuW.ZUA = 1;
    this.CuW.YIZ = z.bAW();
    Object localObject = this.CuW;
    bi localbi = bi.ABn;
    ((bli)localObject).YIY = bi.dVu();
    Log.i(this.TAG, "CgiFinderLiveActivitiyClickReport init " + paramString + '}');
    paramString = new c.a();
    paramString.otE = ((a)this.CuW);
    localObject = new blj();
    ((blj)localObject).setBaseResponse(new kd());
    ((blj)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivequestactivityclickreport";
    paramString.funcId = 5246;
    c(paramString.bEF());
    AppMethodBeat.o(351101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.c
 * JD-Core Version:    0.7.0.1
 */