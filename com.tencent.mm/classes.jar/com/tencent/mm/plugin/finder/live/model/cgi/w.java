package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveTopComment;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "TAG", "", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class w
  extends k<axn>
{
  private final String TAG;
  private g liveData;
  private awq uke;
  private axm ulr;
  
  public w(g paramg, awq paramawq)
  {
    super((byte)0);
    AppMethodBeat.i(246344);
    this.liveData = paramg;
    this.uke = paramawq;
    this.TAG = "Finder.CgiFinderLiveTopComment";
    this.ulr = new axm();
    paramg = this.ulr;
    paramawq = am.tuw;
    paramg.LAI = am.cXY();
    this.ulr.liveId = this.liveData.liveInfo.liveId;
    this.ulr.hFK = this.liveData.hFK;
    this.ulr.fQY = this.uke.fQY;
    this.ulr.LDx = com.tencent.mm.bw.b.cD(this.liveData.hIt);
    this.ulr.seq = this.uke.seq;
    this.ulr.dYx = 0;
    this.ulr.LGk = d.Ga(this.liveData.hwg);
    this.ulr.finderUsername = this.liveData.hwd;
    this.ulr.LGs = this.liveData.hwg;
    paramg = new d.a();
    paramg.c((a)this.ulr);
    paramawq = new axn();
    paramawq.setBaseResponse(new BaseResponse());
    paramg.d((a)paramawq);
    paramg.MB("/cgi-bin/micromsg-bin/finderlivetopcomment");
    paramg.sG(6295);
    c(paramg.aXF());
    Log.i(this.TAG, "CgiFinderLiveTopComment init " + this.ulr.liveId + ',' + this.liveData.hwd + ',' + this.uke.content);
    AppMethodBeat.o(246344);
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return com.tencent.mm.plugin.finder.cgi.report.b.tye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.w
 * JD-Core Version:    0.7.0.1
 */