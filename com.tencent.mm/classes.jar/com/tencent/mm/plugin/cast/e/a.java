package com.tencent.mm.plugin.cast.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/netscene/NetSceneGetScreenCastAuthorization;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "ticket", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;)V", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-cast_release"})
public final class a
  extends q
  implements m
{
  public static final a tJL;
  private i callback;
  private d kwO;
  private azj tJJ;
  public azk tJK;
  
  static
  {
    AppMethodBeat.i(189656);
    tJL = new a((byte)0);
    AppMethodBeat.o(189656);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(189652);
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.cd.a)new azj());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new azk());
    ((d.a)localObject).vD(4261);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/finderlivegetauthorization");
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.kwO = ((d)localObject);
    localObject = this.kwO.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetAuthorizationRequest");
      AppMethodBeat.o(189652);
      throw paramString;
    }
    this.tJJ = ((azj)localObject);
    this.tJJ.scene = 3;
    this.tJJ.RLN = z.bdh();
    this.tJJ.fAo = paramString;
    setHasCallbackToQueue(true);
    AppMethodBeat.o(189652);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(189642);
    Log.i("MicroMsg.NetSceneGetScreenCastAuthorization", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(189642);
    return i;
  }
  
  public final int getType()
  {
    return 4261;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189649);
    Log.i("MicroMsg.NetSceneGetScreenCastAuthorization", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189649);
      throw paramString;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetAuthorizationResponse");
      AppMethodBeat.o(189649);
      throw paramString;
    }
    this.tJK = ((azk)params);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetScreenCastAuthorization", "onGYNetEnd error");
      params = com.tencent.mm.plugin.cast.g.a.tKa;
      com.tencent.mm.plugin.cast.g.a.cLF();
    }
    params = this.tJK;
    if (params != null)
    {
      params = params.SLm;
      if (params != null)
      {
        paramArrayOfByte = this.callback;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        }
        Log.i("MicroMsg.NetSceneGetScreenCastAuthorization", "response is " + params.SNI + " and " + params.SNJ + " and " + params.SNK);
        paramString = new Intent();
        paramString.putExtra("remoteConfig", params.SNI);
        paramString.putExtra("pc_ip", params.SNJ);
        paramString.putExtra("phone_ip", params.SNK);
        params = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLG();
        c.b(MMApplicationContext.getContext(), "cast", ".ui.ScreenCastActivity", paramString);
        AppMethodBeat.o(189649);
        return;
      }
    }
    AppMethodBeat.o(189649);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/netscene/NetSceneGetScreenCastAuthorization$Companion;", "", "()V", "TAG", "", "plugin-cast_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.e.a
 * JD-Core Version:    0.7.0.1
 */