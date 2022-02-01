package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "onNetSceneGetWxaOrderInfoCallback", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "", "(Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;)V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "resp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "IOnNetSceneGetWxaOrderInfoCallback", "plugin-appbrand-integration_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g gfX;
  public final b lvS;
  private final a<c, ? extends Object> lvT;
  
  public c(a<c, ? extends Object> parama)
  {
    AppMethodBeat.i(50892);
    this.lvT = parama;
    this.TAG = "MicroMsg.webview.NetSceneGetWxaOrderInfo";
    parama = new b.a();
    parama.c((a)new bhr());
    parama.d((a)new bhs());
    parama.Am("/cgi-bin/mmbiz-bin/wxaboss/getwxaorderinfo");
    parama.op(1893);
    parama.or(0);
    parama.os(0);
    parama = parama.aAz();
    d.g.b.k.g(parama, "builder.buildInstance()");
    this.lvS = parama;
    AppMethodBeat.o(50892);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(50890);
    this.gfX = paramg;
    int i = dispatch(parame, (q)this.lvS, (com.tencent.mm.network.k)this);
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
    ac.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.gfX;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramArrayOfByte = this.lvT;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "T", "Lcom/tencent/mm/modelbase/NetSceneBase;", "U", "", "ui", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "getUi", "()Ljava/lang/ref/WeakReference;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "plugin-appbrand-integration_release"})
  public static abstract class a<T extends n, U>
  {
    public final WeakReference<U> lvU;
    
    public a(WeakReference<U> paramWeakReference)
    {
      this.lvU = paramWeakReference;
    }
    
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.c
 * JD-Core Version:    0.7.0.1
 */