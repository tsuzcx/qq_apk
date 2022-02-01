package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.u;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "resp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "send", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaOrderInfoResp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.am.p
  implements m
{
  private final String TAG;
  private com.tencent.mm.am.h mAY;
  private final com.tencent.mm.am.c tmR;
  
  public c()
  {
    AppMethodBeat.i(319817);
    this.TAG = "MicroMsg.webview.NetSceneGetWxaOrderInfo";
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = ((com.tencent.mm.bx.a)new cxd());
    ((com.tencent.mm.am.c.a)localObject).otF = ((com.tencent.mm.bx.a)new cxe());
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaboss/getwxaorderinfo";
    ((com.tencent.mm.am.c.a)localObject).funcId = 1893;
    ((com.tencent.mm.am.c.a)localObject).otG = 0;
    ((com.tencent.mm.am.c.a)localObject).respCmdId = 0;
    localObject = ((com.tencent.mm.am.c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.tmR = ((com.tencent.mm.am.c)localObject);
    AppMethodBeat.o(319817);
  }
  
  public final Object U(d<? super b.a<cxe>> paramd)
  {
    AppMethodBeat.i(319851);
    Object localObject = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject).kBA();
    final kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localObject;
    final b localb = new b(this, localp);
    localp.bg((kotlin.g.a.b)new a(this, localb));
    com.tencent.mm.kernel.h.baD().mCm.a(getType(), (com.tencent.mm.am.h)localb);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)this, 0);
    localObject = ((q)localObject).getResult();
    if (localObject == kotlin.d.a.a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(319851);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(50890);
    this.mAY = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.tmR, (m)this);
    AppMethodBeat.o(50890);
    return i;
  }
  
  public final int getType()
  {
    return 1893;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50891);
    Log.i(this.TAG, "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.mAY;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(50891);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    a(c paramc, c.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$send$2$sceneEndListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    b(c paramc, kotlinx.coroutines.p<? super b.a<cxe>> paramp) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(319841);
      if (kotlin.g.b.s.p(this.tmS, paramp))
      {
        com.tencent.mm.kernel.h.baD().mCm.b(this.tmS.getType(), (com.tencent.mm.am.h)this);
        kotlinx.coroutines.p localp = localp;
        Object localObject = Result.Companion;
        localObject = c.c.b(c.a(this.tmS).otC);
        if (localObject == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
          AppMethodBeat.o(319841);
          throw paramString;
        }
        localp.resumeWith(Result.constructor-impl(b.a.a(paramInt1, paramInt2, paramString, (esc)localObject, paramp, null)));
      }
      AppMethodBeat.o(319841);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.c
 * JD-Core Version:    0.7.0.1
 */