package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneReportOpenWxaOrder;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "destroyRedDot", "", "(Z)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-appbrand-integration_release"})
public final class f
  extends n
  implements k
{
  private final String TAG;
  private com.tencent.mm.al.f gzH;
  private final boolean lVj;
  private final b rr;
  
  public f(boolean paramBoolean)
  {
    AppMethodBeat.i(50895);
    this.lVj = paramBoolean;
    this.TAG = "MicroMsg.webview.NetSceneReportOpenWxaOrder";
    Object localObject = new b.a();
    cuj localcuj = new cuj();
    localcuj.Hmh = this.lVj;
    ((b.a)localObject).c((a)localcuj);
    ((b.a)localObject).d((a)new cuk());
    ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/wxaboss/reportopenwxaorder");
    ((b.a)localObject).oP(1954);
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    AppMethodBeat.o(50895);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(50893);
    this.gzH = paramf;
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
    ad.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.gzH;
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