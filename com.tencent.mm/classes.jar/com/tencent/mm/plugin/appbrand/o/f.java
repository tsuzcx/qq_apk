package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneReportOpenWxaOrder;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "destroyRedDot", "", "(Z)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-appbrand-integration_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g gfX;
  private final boolean lvW;
  private final b rr;
  
  public f(boolean paramBoolean)
  {
    AppMethodBeat.i(50895);
    this.lvW = paramBoolean;
    this.TAG = "MicroMsg.webview.NetSceneReportOpenWxaOrder";
    Object localObject = new b.a();
    cpe localcpe = new cpe();
    localcpe.FBS = this.lvW;
    ((b.a)localObject).c((a)localcpe);
    ((b.a)localObject).d((a)new cpf());
    ((b.a)localObject).Am("/cgi-bin/mmbiz-bin/wxaboss/reportopenwxaorder");
    ((b.a)localObject).op(1954);
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    AppMethodBeat.o(50895);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(50893);
    this.gfX = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    ac.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.gfX;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.f
 * JD-Core Version:    0.7.0.1
 */