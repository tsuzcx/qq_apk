package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(127838);
    b.a locala = new b.a();
    locala.hQF = new dnm();
    locala.hQG = new dnn();
    locala.uri = "/cgi-bin/micromsg-bin/thirdappverify";
    locala.funcId = 755;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((dnm)this.rr.hQD.hQJ).GyK = paramString;
    ((dnm)this.rr.hQD.hQJ).HUB = 1;
    ((dnm)this.rr.hQD.hQJ).qkN = ad.fom();
    paramString = bu.fpG();
    ((dnm)this.rr.hQD.hQJ).FWl = z.al(paramString);
    this.rr.setRsaInfo(ac.fkp());
    this.rr.option = 1;
    this.rr.getReqObj().setPassKey(paramString);
    this.rr.getReqObj().setSceneStatus(1);
    AppMethodBeat.o(127838);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127839);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneVerifyThirdApp", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.i
 * JD-Core Version:    0.7.0.1
 */