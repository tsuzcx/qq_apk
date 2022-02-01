package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "onNetSceneGetWxaOrderInfoCallback", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "", "(Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "resp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "IOnNetSceneGetWxaOrderInfoCallback", "plugin-appbrand-integration_release"})
public final class c
  extends n
  implements k
{
  private final String TAG;
  private f gzH;
  public final b lVf;
  private final a<c, ? extends Object> lVg;
  
  public c(a<c, ? extends Object> parama)
  {
    AppMethodBeat.i(50892);
    this.lVg = parama;
    this.TAG = "MicroMsg.webview.NetSceneGetWxaOrderInfo";
    parama = new b.a();
    parama.c((a)new blz());
    parama.d((a)new bma());
    parama.Dl("/cgi-bin/mmbiz-bin/wxaboss/getwxaorderinfo");
    parama.oP(1893);
    parama.oR(0);
    parama.oS(0);
    parama = parama.aDC();
    p.g(parama, "builder.buildInstance()");
    this.lVf = parama;
    AppMethodBeat.o(50892);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(50890);
    this.gzH = paramf;
    int i = dispatch(parame, (q)this.lVf, (k)this);
    AppMethodBeat.o(50890);
    return i;
  }
  
  public final int getType()
  {
    return 1893;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50891);
    ad.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.gzH;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramArrayOfByte = this.lVg;
    if (paramArrayOfByte != null)
    {
      paramq = paramString;
      if (paramString == null) {
        paramq = "";
      }
      paramArrayOfByte.a(paramInt2, paramInt3, paramq, (n)this);
      AppMethodBeat.o(50891);
      return;
    }
    AppMethodBeat.o(50891);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "T", "Lcom/tencent/mm/modelbase/NetSceneBase;", "U", "", "ui", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "getUi", "()Ljava/lang/ref/WeakReference;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "plugin-appbrand-integration_release"})
  public static abstract class a<T extends n, U>
  {
    public final WeakReference<U> lVh;
    
    public a(WeakReference<U> paramWeakReference)
    {
      this.lVh = paramWeakReference;
    }
    
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c
 * JD-Core Version:    0.7.0.1
 */