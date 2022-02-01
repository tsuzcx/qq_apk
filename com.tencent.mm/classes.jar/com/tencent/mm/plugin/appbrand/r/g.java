package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneReportOpenWxaOrder;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "destroyRedDot", "", "(Z)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-appbrand-integration_release"})
public final class g
  extends q
  implements m
{
  private final String TAG;
  private i heq;
  private final boolean nhB;
  private final d rr;
  
  public g(boolean paramBoolean)
  {
    AppMethodBeat.i(50895);
    this.nhB = paramBoolean;
    this.TAG = "MicroMsg.webview.NetSceneReportOpenWxaOrder";
    Object localObject = new d.a();
    dnw localdnw = new dnw();
    localdnw.MQR = this.nhB;
    ((d.a)localObject).c((a)localdnw);
    ((d.a)localObject).d((a)new dnx());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/wxaboss/reportopenwxaorder");
    ((d.a)localObject).sG(1954);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    AppMethodBeat.o(50895);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(50893);
    this.heq = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(50893);
    return i;
  }
  
  public final int getType()
  {
    return 1954;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50894);
    Log.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.heq;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(50894);
      return;
    }
    AppMethodBeat.o(50894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.g
 * JD-Core Version:    0.7.0.1
 */