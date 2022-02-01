package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "onNetSceneGetWxaOrderInfoCallback", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "", "(Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "resp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "IOnNetSceneGetWxaOrderInfoCallback", "plugin-appbrand-integration_release"})
public final class c
  extends q
  implements m
{
  private final String TAG;
  private i heq;
  public final d nhw;
  private final a<c, ? extends Object> nhx;
  
  public c(a<c, ? extends Object> parama)
  {
    AppMethodBeat.i(50892);
    this.nhx = parama;
    this.TAG = "MicroMsg.webview.NetSceneGetWxaOrderInfo";
    parama = new d.a();
    parama.c((a)new bzi());
    parama.d((a)new bzj());
    parama.MB("/cgi-bin/mmbiz-bin/wxaboss/getwxaorderinfo");
    parama.sG(1893);
    parama.sI(0);
    parama.sJ(0);
    parama = parama.aXF();
    p.g(parama, "builder.buildInstance()");
    this.nhw = parama;
    AppMethodBeat.o(50892);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(50890);
    this.heq = parami;
    int i = dispatch(paramg, (s)this.nhw, (m)this);
    AppMethodBeat.o(50890);
    return i;
  }
  
  public final int getType()
  {
    return 1893;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50891);
    Log.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.heq;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramArrayOfByte = this.nhx;
    if (paramArrayOfByte != null)
    {
      params = paramString;
      if (paramString == null) {
        params = "";
      }
      paramArrayOfByte.a(paramInt2, paramInt3, params, (q)this);
      AppMethodBeat.o(50891);
      return;
    }
    AppMethodBeat.o(50891);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "T", "Lcom/tencent/mm/modelbase/NetSceneBase;", "U", "", "ui", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "getUi", "()Ljava/lang/ref/WeakReference;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "plugin-appbrand-integration_release"})
  public static abstract class a<T extends q, U>
  {
    public final WeakReference<U> nhy;
    
    public a(WeakReference<U> paramWeakReference)
    {
      this.nhy = paramWeakReference;
    }
    
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c
 * JD-Core Version:    0.7.0.1
 */