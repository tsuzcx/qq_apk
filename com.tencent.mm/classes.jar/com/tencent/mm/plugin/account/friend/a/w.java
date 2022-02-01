package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public int opType;
  private b rr;
  
  public w(int paramInt, String paramString)
  {
    AppMethodBeat.i(131079);
    this.opType = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new agi();
    ((b.a)localObject).hvu = new agj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((b.a)localObject).funcId = 183;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    agi localagi = (agi)this.rr.hvr.hvw;
    localObject = paramString;
    if (bs.isNullOrNil(paramString)) {
      localObject = "";
    }
    localagi.Eyp = ((String)localObject);
    localagi.fZz = paramInt;
    AppMethodBeat.o(131079);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (agj)this.rr.hvs.hvw;
      paramInt1 = paramq.getBaseResponse().Ret;
      if (paramInt1 != 0)
      {
        ac.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(131081);
        return;
      }
      ac.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + paramq.Eyr + ", fbusername = " + paramq.Eys);
      if ((this.opType == 0) || (this.opType == 1))
      {
        com.tencent.mm.kernel.g.agR().agA().set(65825, paramq.Eyr);
        c.zM(paramq.Eyr);
        com.tencent.mm.kernel.g.agR().agA().set(65826, paramq.Eys);
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.w
 * JD-Core Version:    0.7.0.1
 */