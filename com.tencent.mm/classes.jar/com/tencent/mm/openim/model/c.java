package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/NetSceneAddOpenIMKefuContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "addContactContext", "Lcom/tencent/mm/protocal/protobuf/AddOpenIMKefuContactContext;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/AddOpenIMKefuContactContext;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "source", "", "url", "doScene", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getSource", "getType", "getUsername", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  public static final c.a psq;
  private h callback;
  private com.tencent.mm.am.c rr;
  public int source;
  private String url;
  public String username;
  
  static
  {
    AppMethodBeat.i(235862);
    psq = new c.a((byte)0);
    AppMethodBeat.o(235862);
  }
  
  public c(String paramString, du paramdu)
  {
    AppMethodBeat.i(235858);
    this.username = "";
    this.url = "";
    Object localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = ((a)new dv());
    ((com.tencent.mm.am.c.a)localObject1).otF = ((a)new dw());
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/micromsg-bin/addopenimkefucontact";
    ((com.tencent.mm.am.c.a)localObject1).funcId = getType();
    this.rr = ((com.tencent.mm.am.c.a)localObject1).bEF();
    if (paramString == null)
    {
      localObject1 = "";
      this.username = ((String)localObject1);
      String str = paramdu.url;
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      this.url = ((String)localObject1);
      localObject1 = this.rr;
      if (localObject1 != null) {
        break label257;
      }
      localObject1 = null;
      label133:
      localObject1 = (dv)localObject1;
      if (localObject1 != null) {
        ((dv)localObject1).YFY = paramString;
      }
      if (localObject1 != null) {
        ((dv)localObject1).YFZ = paramdu;
      }
      localObject1 = new StringBuilder("alvinluo addOpenImKefuContact username: ").append(paramString).append(", url: ").append(paramdu.url).append(", ticket: ").append(paramdu.YFW).append(", scene: ");
      paramString = paramdu.YFX;
      if (paramString != null) {
        break label268;
      }
      paramString = null;
      label210:
      localObject1 = ((StringBuilder)localObject1).append(paramString).append(", entityId: ");
      paramString = paramdu.YFX;
      if (paramString != null) {
        break label279;
      }
    }
    label257:
    label268:
    label279:
    for (paramString = localObject2;; paramString = paramString.abdw)
    {
      Log.i("MicroMsg.NetSceneAddOpenIMKefuContact", paramString);
      AppMethodBeat.o(235858);
      return;
      localObject1 = paramString;
      break;
      localObject1 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
      break label133;
      paramString = Integer.valueOf(paramString.scene);
      break label210;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(235865);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(235865);
    return i;
  }
  
  public final int getType()
  {
    return 6849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235872);
    Log.i("MicroMsg.NetSceneAddOpenIMKefuContact", "alvinluo addOpenImKefuContact onGYNetEnd errType: " + paramInt2 + ", errCode: " + paramInt3 + ", errMsg: " + paramString + ", type: " + getType());
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(235872);
      return;
    }
    params = this.rr;
    if (params == null)
    {
      params = null;
      params = (dw)params;
      if (params != null) {
        break label175;
      }
    }
    label175:
    for (paramInt1 = 0;; paramInt1 = params.source)
    {
      this.source = paramInt1;
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(235872);
      return;
      params = c.c.b(params.otC);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.c
 * JD-Core Version:    0.7.0.1
 */