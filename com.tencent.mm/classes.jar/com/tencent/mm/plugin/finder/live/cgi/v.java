package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.findersdk.a.u;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "tabType", "", "lng", "", "lat", "callback", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveStreamCallback;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveStreamCallback;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends c<bne>
{
  private u CvI;
  private bnd CvJ;
  private final String TAG;
  
  public v(b paramb, int paramInt, float paramFloat1, float paramFloat2, u paramu)
  {
    AppMethodBeat.i(351178);
    this.TAG = "Finder.CgiFinderLiveStream";
    this.CvI = paramu;
    this.CvJ = new bnd();
    this.CvJ.lastBuffer = paramb;
    this.CvJ.ZVQ = paramInt;
    this.CvJ.longitude = paramFloat1;
    this.CvJ.latitude = paramFloat2;
    paramb = new c.a();
    paramb.otE = ((a)this.CvJ);
    paramu = new bne();
    paramu.setBaseResponse(new kd());
    paramu.getBaseResponse().akjO = new etl();
    paramb.otF = ((a)paramu);
    paramb.uri = "/cgi-bin/micromsg-bin/finderlivestream";
    paramb.funcId = 4151;
    c(paramb.bEF());
    Log.i(this.TAG, "CgiFinderLiveStream init " + this.CvJ.ZVQ + ',' + this.CvJ.lastBuffer);
    AppMethodBeat.o(351178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.v
 * JD-Core Version:    0.7.0.1
 */