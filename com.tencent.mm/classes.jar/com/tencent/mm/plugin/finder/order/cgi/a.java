package com.tencent.mm.plugin.finder.order.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerGetAllTabOrderCnt;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerGetAllTabOrderCntResp;", "()V", "TAG", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<alo>
{
  public static final a.a ESh;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(332315);
    ESh = new a.a((byte)0);
    AppMethodBeat.o(332315);
  }
  
  public a()
  {
    super(null);
    AppMethodBeat.i(332308);
    this.TAG = "Finder.CgiFinderLiveEcCustomerGetAllTabOrderCnt";
    Object localObject = new aln();
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    localObject = new alo();
    ((alo)localObject).setBaseResponse(new kd());
    ((alo)localObject).getBaseResponse().akjO = new etl();
    locala.otF = ((com.tencent.mm.bx.a)localObject);
    locala.uri = "/cgi-bin/micromsg-bin/eccustomergettabordercnt";
    locala.funcId = 6247;
    c(locala.bEF());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(332308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.cgi.a
 * JD-Core Version:    0.7.0.1
 */