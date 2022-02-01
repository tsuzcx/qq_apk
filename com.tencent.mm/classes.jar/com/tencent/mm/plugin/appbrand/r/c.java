package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Result;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "resp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "send", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaOrderInfoResp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private final String TAG;
  private i jQg;
  private final d qif;
  
  public c()
  {
    AppMethodBeat.i(256481);
    this.TAG = "MicroMsg.webview.NetSceneGetWxaOrderInfo";
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new chc());
    ((d.a)localObject).d((a)new chd());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/wxaboss/getwxaorderinfo");
    ((d.a)localObject).vD(1893);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.qif = ((d)localObject);
    AppMethodBeat.o(256481);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(50890);
    this.jQg = parami;
    int i = dispatch(paramg, (s)this.qif, (com.tencent.mm.network.m)this);
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
    params = this.jQg;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(50891);
      return;
    }
    AppMethodBeat.o(50891);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$send$2$sceneEndListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
  public static final class a
    implements i
  {
    public a(kotlinx.coroutines.m paramm, c paramc) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(281013);
      if (p.h(this.qig, paramq))
      {
        Object localObject1 = h.aHF();
        p.j(localObject1, "MMKernel.network()");
        ((com.tencent.mm.kernel.c)localObject1).aGY().b(this.qig.getType(), (i)this);
        localObject1 = this.khs;
        Object localObject2 = Result.Companion;
        localObject2 = c.a(this.qig).bhY();
        if (localObject2 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
          AppMethodBeat.o(281013);
          throw paramString;
        }
        ((kotlinx.coroutines.m)localObject1).resumeWith(Result.constructor-impl(com.tencent.mm.an.c.a.a(paramInt1, paramInt2, paramString, (dyy)localObject2, paramq, null)));
      }
      AppMethodBeat.o(281013);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$send$2$1"})
  public static final class b
    extends kotlin.g.b.q
    implements b<Throwable, x>
  {
    public b(c.a parama, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c
 * JD-Core Version:    0.7.0.1
 */