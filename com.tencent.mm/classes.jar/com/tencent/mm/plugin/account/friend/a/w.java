package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public int opType;
  private b rr;
  
  public w(int paramInt, String paramString)
  {
    AppMethodBeat.i(131079);
    this.opType = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new afj();
    ((b.a)localObject).gUV = new afk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((b.a)localObject).funcId = 183;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    afj localafj = (afj)this.rr.gUS.gUX;
    localObject = paramString;
    if (bt.isNullOrNil(paramString)) {
      localObject = "";
    }
    localafj.Dfj = ((String)localObject);
    localafj.fVE = paramInt;
    AppMethodBeat.o(131079);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131080);
    this.callback = paramg;
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
    ad.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (afk)this.rr.gUT.gUX;
      paramInt1 = paramq.getBaseResponse().Ret;
      if (paramInt1 != 0)
      {
        ad.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(131081);
        return;
      }
      ad.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + paramq.Dfl + ", fbusername = " + paramq.Dfm);
      if ((this.opType == 0) || (this.opType == 1))
      {
        com.tencent.mm.kernel.g.afB().afk().set(65825, paramq.Dfl);
        c.vG(paramq.Dfl);
        com.tencent.mm.kernel.g.afB().afk().set(65826, paramq.Dfm);
        com.tencent.mm.kernel.g.afB().afk().eKy();
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