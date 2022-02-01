package com.tencent.mm.plugin.finder.order.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerGetOrderList;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerGetOrderListResp;", "tabType", "", "lastBuffer", "", "pageSize", "(ILjava/lang/String;I)V", "TAG", "getLastBuffer", "()Ljava/lang/String;", "getPageSize", "()I", "getTabType", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<alq>
{
  private final String ESi;
  private final String TAG;
  private final int hJx;
  private final int pageSize;
  
  public b(int paramInt1, String paramString, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(332310);
    this.hJx = paramInt1;
    this.ESi = paramString;
    this.pageSize = paramInt2;
    this.TAG = "Finder.CgiFinderLiveEcCustomerGetOrderList";
    Object localObject = new alp();
    ((alp)localObject).tab_type = this.hJx;
    ((alp)localObject).ZsJ = this.ESi;
    ((alp)localObject).YSW = this.pageSize;
    paramString = new c.a();
    paramString.otE = ((a)localObject);
    localObject = new alq();
    ((alq)localObject).setBaseResponse(new kd());
    ((alq)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/eccustomergetorderlist";
    paramString.funcId = 6881;
    c(paramString.bEF());
    Log.i(this.TAG, "init tabType:" + this.hJx + ", lastBuffer:" + this.ESi + ", pageSize:" + this.pageSize);
    AppMethodBeat.o(332310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.cgi.b
 * JD-Core Version:    0.7.0.1
 */