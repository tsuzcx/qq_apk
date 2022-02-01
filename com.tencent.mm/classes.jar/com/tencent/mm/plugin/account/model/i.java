package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(127838);
    b.a locala = new b.a();
    locala.hvt = new dhc();
    locala.hvu = new dhd();
    locala.uri = "/cgi-bin/micromsg-bin/thirdappverify";
    locala.funcId = 755;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((dhc)this.rr.hvr.hvw).Eyp = paramString;
    ((dhc)this.rr.hvr.hvw).FQk = 1;
    ((dhc)this.rr.hvr.hvw).pAD = ab.eUO();
    paramString = bs.eWb();
    ((dhc)this.rr.hvr.hvw).DYu = z.al(paramString);
    this.rr.setRsaInfo(com.tencent.mm.protocal.ac.eRv());
    this.rr.option = 1;
    this.rr.getReqObj().setPassKey(paramString);
    this.rr.getReqObj().setSceneStatus(1);
    AppMethodBeat.o(127838);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127839);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127839);
    return i;
  }
  
  public final int getType()
  {
    return 755;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127840);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneVerifyThirdApp", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.i
 * JD-Core Version:    0.7.0.1
 */