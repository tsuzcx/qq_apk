package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/NetSceneDelOpenIMKefuContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "kfUsername", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getUsername", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends p
  implements m
{
  public static final a psr;
  private h callback;
  public String prk;
  private c rr;
  
  static
  {
    AppMethodBeat.i(235884);
    psr = new a((byte)0);
    AppMethodBeat.o(235884);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(235880);
    this.prk = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new ait());
    ((c.a)localObject).otF = ((a)new aiu());
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimkefucontact";
    ((c.a)localObject).funcId = getType();
    this.rr = ((c.a)localObject).bEF();
    if (paramString == null)
    {
      localObject = "";
      this.prk = ((String)localObject);
      localObject = this.rr;
      if (localObject != null) {
        break label132;
      }
    }
    label132:
    for (localObject = null;; localObject = c.b.b(((c)localObject).otB))
    {
      localObject = (ait)localObject;
      if (localObject != null) {
        ((ait)localObject).YFY = paramString;
      }
      Log.i("MicroMsg.NetSceneDelOpenIMKefuContact", kotlin.g.b.s.X("alvinluo delOpenImKefuContact username: ", paramString));
      AppMethodBeat.o(235880);
      return;
      localObject = paramString;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(235886);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(235886);
    return i;
  }
  
  public final int getType()
  {
    return 5997;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235892);
    Log.i("MicroMsg.NetSceneDelOpenIMKefuContact", "alvinluo delOpenImKefuContact onGYNetEnd errType: " + paramInt2 + ", errCode: " + paramInt3 + ", errMsg: " + paramString + ", type: " + getType() + ", username: " + this.prk);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(235892);
      return;
    }
    params = this.callback;
    kotlin.g.b.s.checkNotNull(params);
    params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    AppMethodBeat.o(235892);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/NetSceneDelOpenIMKefuContact$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.model.f
 * JD-Core Version:    0.7.0.1
 */