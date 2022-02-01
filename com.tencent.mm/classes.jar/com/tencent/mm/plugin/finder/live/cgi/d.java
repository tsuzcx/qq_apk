package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorOpFanClub;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorOpFanClubResponse;", "opCode", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveFanClubInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubInfo;", "getOpCode", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorOpFanClubRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorOpFanClubRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c<bdi>
{
  private final bgw CuX;
  private final bdh CuY;
  private final String TAG;
  private final int hHC;
  
  public d(int paramInt, bgw parambgw)
  {
    super(null);
    AppMethodBeat.i(351105);
    this.hHC = paramInt;
    this.CuX = parambgw;
    this.TAG = "Finder.CgiFinderLiveAnchorOpFanClub";
    this.CuY = new bdh();
    parambgw = this.CuY;
    Object localObject = bi.ABn;
    parambgw.YIY = bi.dVu();
    this.CuY.YIZ = z.bAW();
    this.CuY.ZlE = this.hHC;
    this.CuY.ZNT = this.CuX;
    parambgw = new c.a();
    parambgw.otE = ((a)this.CuY);
    localObject = new bdi();
    ((bdi)localObject).setBaseResponse(new kd());
    ((bdi)localObject).getBaseResponse().akjO = new etl();
    parambgw.otF = ((a)localObject);
    parambgw.uri = "/cgi-bin/micromsg-bin/finderliveanchoropfanclub";
    parambgw.funcId = 6632;
    c(parambgw.bEF());
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init ").append(this.CuY.YIZ).append(',').append(this.CuY.ZlE).append(',');
    parambgw = this.CuY.ZNT;
    if (parambgw == null) {}
    for (parambgw = null;; parambgw = parambgw.ZQn)
    {
      Log.i((String)localObject, parambgw);
      AppMethodBeat.o(351105);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.d
 * JD-Core Version:    0.7.0.1
 */