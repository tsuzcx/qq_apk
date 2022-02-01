package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneReportOpenWxaOrder;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "destroyRedDot", "", "(Z)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-appbrand-integration_release"})
public final class f
  extends n
  implements k
{
  private final String TAG;
  private com.tencent.mm.ak.f gCo;
  private final boolean lZM;
  private final b rr;
  
  public f(boolean paramBoolean)
  {
    AppMethodBeat.i(50895);
    this.lZM = paramBoolean;
    this.TAG = "MicroMsg.webview.NetSceneReportOpenWxaOrder";
    Object localObject = new b.a();
    cvd localcvd = new cvd();
    localcvd.HFH = this.lZM;
    ((b.a)localObject).c((a)localcvd);
    ((b.a)localObject).d((a)new cve());
    ((b.a)localObject).DN("/cgi-bin/mmbiz-bin/wxaboss/reportopenwxaorder");
    ((b.a)localObject).oS(1954);
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    AppMethodBeat.o(50895);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(50893);
    this.gCo = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(50893);
    return i;
  }
  
  public final int getType()
  {
    return 1954;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50894);
    ae.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.gCo;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(50894);
      return;
    }
    AppMethodBeat.o(50894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.f
 * JD-Core Version:    0.7.0.1
 */