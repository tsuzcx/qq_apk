package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.m;
import com.tencent.mm.openim.api.i;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/NetSceneGetOpenIMKefuContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getRequest", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactRequest;", "(Lcom/tencent/mm/openim/api/OpenIMKefuGetContactRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContactResp", "Lcom/tencent/mm/protocal/protobuf/GetOpenIMKefuContactResp;", "mRequest", "openImKfContact", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getGetContactResp", "getOpenIMKefuContact", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends p
  implements m
{
  public static final k.a psu;
  private h callback;
  public com.tencent.mm.openim.a.c psv;
  public cou psw;
  public final i psx;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(235854);
    psu = new k.a((byte)0);
    AppMethodBeat.o(235854);
  }
  
  public k(i parami)
  {
    AppMethodBeat.i(235849);
    this.psx = parami;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)new cot());
    ((c.a)localObject1).otF = ((a)new cou());
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/getopenimkefucontact";
    ((c.a)localObject1).funcId = getType();
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = this.rr;
    cot localcot;
    Object localObject2;
    int i;
    label212:
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      localcot = (cot)localObject1;
      if (localcot != null)
      {
        localObject1 = new cos();
        ((cos)localObject1).url = parami.url;
        ((cos)localObject1).YFY = parami.prk;
        localObject2 = ah.aiuX;
        localcot.aavH = ((cos)localObject1);
      }
      if (localcot != null) {
        localcot.scene = parami.scene;
      }
      if ((parami.pro) && (localcot != null))
      {
        localObject1 = new cor();
        localObject2 = parami.url;
        kotlin.g.b.s.s(localObject2, "getRequest.url");
        if (((CharSequence)localObject2).length() <= 0) {
          break label360;
        }
        i = 1;
        if (i == 0) {
          break label365;
        }
        bool = com.tencent.mm.openim.a.k.RQ(parami.url);
        label224:
        if (!bool) {
          break label387;
        }
        i = 1;
        label230:
        ((cor)localObject1).aavG = i;
        localObject2 = ah.aiuX;
        localcot.aavI = ((cor)localObject1);
      }
      localObject2 = new StringBuilder("alvinluo getOpenImKefuContact url: ");
      if (localcot != null) {
        break label392;
      }
      localObject1 = null;
      label267:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", username: ");
      if (localcot != null) {
        break label420;
      }
      localObject1 = null;
      label289:
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", getContactScene: ").append(parami.scene).append(", hasChatRecord: ");
      if (localcot != null) {
        break label448;
      }
      parami = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneGetOpenIMKefuContact", parami);
      this.psw = null;
      AppMethodBeat.o(235849);
      return;
      localObject1 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
      break;
      label360:
      i = 0;
      break label212;
      label365:
      localObject2 = parami.prk;
      kotlin.g.b.s.s(localObject2, "getRequest.kfUsername");
      bool = com.tencent.mm.openim.a.k.RR((String)localObject2);
      break label224;
      label387:
      i = 0;
      break label230;
      label392:
      localObject1 = localcot.aavH;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label267;
      }
      localObject1 = ((cos)localObject1).url;
      break label267;
      label420:
      localObject1 = localcot.aavH;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label289;
      }
      localObject1 = ((cos)localObject1).YFY;
      break label289;
      label448:
      parami = localcot.aavI;
      if (parami == null) {
        parami = null;
      } else {
        parami = Integer.valueOf(parami.aavG);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(235856);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(235856);
    return i;
  }
  
  public final int getType()
  {
    return 4010;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    AppMethodBeat.i(235867);
    Log.i("MicroMsg.NetSceneGetOpenIMKefuContact", "alvinluo getOpenImKefuContact onGYNetEnd errType: " + paramInt2 + ", errCode: " + paramInt3 + ", errMsg: " + paramString + ", type: " + getType() + ", username: " + this.psx.key);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(235867);
      return;
    }
    params = this.rr;
    if (params == null)
    {
      params = null;
      this.psw = ((cou)params);
      params = this.psw;
      if (params != null) {
        break label292;
      }
      params = null;
      label158:
      paramArrayOfByte = this.psw;
      if (paramArrayOfByte != null) {
        break label341;
      }
      paramArrayOfByte = null;
      label172:
      Log.i("MicroMsg.NetSceneGetOpenIMKefuContact", "alvinluo getOpenImKefuContact resp.setting flag: %s, confirmType: %s", new Object[] { params, paramArrayOfByte });
      params = com.tencent.mm.openim.a.g.prW;
      paramArrayOfByte = this.psx.url;
      params = this.psw;
      if (params != null) {
        break label354;
      }
    }
    label292:
    label341:
    label354:
    for (params = localObject;; params = params.aavJ)
    {
      this.psv = com.tencent.mm.openim.a.g.a(paramArrayOfByte, params);
      params = com.tencent.mm.openim.a.g.prW;
      com.tencent.mm.openim.a.g.c(this.psv);
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(235867);
      return;
      params = c.c.b(params.otC);
      break;
      params = params.aavJ;
      if (params == null)
      {
        params = null;
        break label158;
      }
      params = params.abdv;
      if (params == null)
      {
        params = null;
        break label158;
      }
      params = Long.valueOf(params.NlD);
      break label158;
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.xld);
      break label172;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.k
 * JD-Core Version:    0.7.0.1
 */