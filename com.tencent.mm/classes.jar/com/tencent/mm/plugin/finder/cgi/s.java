package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveIncomePage;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveIncomePageResponse;", "finderUsername", "", "(Ljava/lang/String;)V", "TAG", "getFinderUsername", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveIncomePageRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends c<azj>
{
  private final azi Azi;
  private final String TAG;
  private final String finderUsername;
  
  public s(String paramString)
  {
    AppMethodBeat.i(336404);
    this.finderUsername = paramString;
    this.TAG = "MicroMsg.CgiFinderGetLiveIncomePage";
    this.Azi = new azi();
    paramString = this.Azi;
    Object localObject = bi.ABn;
    paramString.YIY = bi.dVu();
    this.Azi.YIZ = this.finderUsername;
    paramString = new c.a();
    paramString.otE = ((a)this.Azi);
    localObject = new azj();
    ((azj)localObject).setBaseResponse(new kd());
    ((azj)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/findergetliveincomepage";
    paramString.funcId = 6477;
    c(paramString.bEF());
    Log.i(this.TAG, kotlin.g.b.s.X("init ", this.Azi.YIZ));
    AppMethodBeat.o(336404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.s
 * JD-Core Version:    0.7.0.1
 */