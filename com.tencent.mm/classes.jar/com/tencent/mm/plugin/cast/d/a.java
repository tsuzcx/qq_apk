package com.tencent.mm.plugin.cast.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/netscene/NetSceneGetScreenCastAuthorization;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "ticket", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;)V", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
  implements m
{
  public static final a.a wNf;
  private h callback;
  private com.tencent.mm.am.c nao;
  private bhg wNg;
  public bhh wNh;
  
  static
  {
    AppMethodBeat.i(274092);
    wNf = new a.a((byte)0);
    AppMethodBeat.o(274092);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(274086);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)new bhg());
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new bhh());
    ((c.a)localObject).funcId = 4261;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/finderlivegetauthorization";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((com.tencent.mm.am.c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetAuthorizationRequest");
      AppMethodBeat.o(274086);
      throw paramString;
    }
    this.wNg = ((bhg)localObject);
    this.wNg.scene = 3;
    this.wNg.YIZ = z.bAW();
    this.wNg.hFb = paramString;
    setHasCallbackToQueue(true);
    AppMethodBeat.o(274086);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(274103);
    Log.i("MicroMsg.NetSceneGetScreenCastAuthorization", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(274103);
    return i;
  }
  
  public final int getType()
  {
    return 4261;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(274117);
    Log.i("MicroMsg.NetSceneGetScreenCastAuthorization", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(274117);
      throw paramString;
    }
    params = c.c.b(((com.tencent.mm.am.c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetAuthorizationResponse");
      AppMethodBeat.o(274117);
      throw paramString;
    }
    this.wNh = ((bhh)params);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetScreenCastAuthorization", "onGYNetEnd error");
      params = com.tencent.mm.plugin.cast.f.a.wNt;
      com.tencent.mm.plugin.cast.f.a.dpl();
    }
    params = this.wNh;
    if (params != null)
    {
      params = params.ZQT;
      if (params != null)
      {
        paramArrayOfByte = this.callback;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
        }
        Log.i("MicroMsg.NetSceneGetScreenCastAuthorization", "response is " + params.ZUY + " and " + params.ZUZ + " and " + params.ZVa);
        paramString = new Intent();
        paramString.putExtra("remoteConfig", params.ZUY);
        paramString.putExtra("pc_ip", params.ZUZ);
        paramString.putExtra("phone_ip", params.ZVa);
        params = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.dpm();
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "cast", ".ui.ScreenCastActivity", paramString);
      }
    }
    AppMethodBeat.o(274117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.d.a
 * JD-Core Version:    0.7.0.1
 */