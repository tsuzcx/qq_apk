package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class v
  extends m
  implements k
{
  private f callback;
  public int opType;
  private com.tencent.mm.ai.b rr;
  
  public v(int paramInt, String paramString)
  {
    AppMethodBeat.i(108418);
    this.opType = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new abm();
    ((b.a)localObject).fsY = new abn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((b.a)localObject).funcId = 183;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    abm localabm = (abm)this.rr.fsV.fta;
    localObject = paramString;
    if (bo.isNullOrNil(paramString)) {
      localObject = "";
    }
    localabm.wRO = ((String)localObject);
    localabm.nrS = paramInt;
    AppMethodBeat.o(108418);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108419);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108419);
    return i;
  }
  
  public final int getType()
  {
    return 183;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108420);
    updateDispatchId(paramInt1);
    ab.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (abn)this.rr.fsW.fta;
      paramInt1 = paramq.getBaseResponse().Ret;
      if (paramInt1 != 0)
      {
        ab.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(108420);
        return;
      }
      ab.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + paramq.wRQ + ", fbusername = " + paramq.wRR);
      if ((this.opType == 0) || (this.opType == 1))
      {
        g.RL().Ru().set(65825, paramq.wRQ);
        com.tencent.mm.ah.b.qM(paramq.wRQ);
        g.RL().Ru().set(65826, paramq.wRR);
        g.RL().Ru().dww();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.v
 * JD-Core Version:    0.7.0.1
 */