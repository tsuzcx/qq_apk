package com.tencent.mm.plugin.finder.order.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerSearchOrderList;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerSearchOrderListResp;", "query", "", "lastOffset", "", "pageSize", "(Ljava/lang/String;II)V", "TAG", "getLastOffset", "()I", "getPageSize", "getQuery", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.findersdk.b.c<alt>
{
  private final int ESj;
  private final String TAG;
  private final int pageSize;
  private final String query;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(332301);
    this.query = paramString;
    this.ESj = paramInt1;
    this.pageSize = paramInt2;
    this.TAG = "Finder.CgiFinderLiveEcCustomerGetOrderList";
    Object localObject = new als();
    ((als)localObject).hAB = this.query;
    ((als)localObject).YSW = this.pageSize;
    ((als)localObject).offset = this.ESj;
    paramString = new c.a();
    paramString.otE = ((a)localObject);
    localObject = new alt();
    ((alt)localObject).setBaseResponse(new kd());
    ((alt)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/eccustomersearchorderlist";
    paramString.funcId = 6881;
    c(paramString.bEF());
    Log.i(this.TAG, "init query:" + this.query + ", pageSize:" + this.pageSize + ", lastOffset:" + this.ESj);
    AppMethodBeat.o(332301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.cgi.c
 * JD-Core Version:    0.7.0.1
 */