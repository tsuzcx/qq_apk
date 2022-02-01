package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class w
  extends n
  implements k
{
  private f callback;
  public int opType;
  private b rr;
  
  public w(int paramInt, String paramString)
  {
    AppMethodBeat.i(131079);
    this.opType = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new aji();
    ((b.a)localObject).hQG = new ajj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((b.a)localObject).funcId = 183;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    aji localaji = (aji)this.rr.hQD.hQJ;
    localObject = paramString;
    if (bu.isNullOrNil(paramString)) {
      localObject = "";
    }
    localaji.GyK = ((String)localObject);
    localaji.gvx = paramInt;
    AppMethodBeat.o(131079);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(131080);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131080);
    return i;
  }
  
  public final int getType()
  {
    return 183;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131081);
    updateDispatchId(paramInt1);
    ae.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ajj)this.rr.hQE.hQJ;
      paramInt1 = paramq.getBaseResponse().Ret;
      if (paramInt1 != 0)
      {
        ae.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(131081);
        return;
      }
      ae.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + paramq.GyM + ", fbusername = " + paramq.GyN);
      if ((this.opType == 0) || (this.opType == 1))
      {
        g.ajR().ajA().set(65825, paramq.GyM);
        c.Dn(paramq.GyM);
        g.ajR().ajA().set(65826, paramq.GyN);
        g.ajR().ajA().fuc();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.w
 * JD-Core Version:    0.7.0.1
 */