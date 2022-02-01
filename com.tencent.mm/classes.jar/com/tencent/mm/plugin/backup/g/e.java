package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21717);
    ac.i("MicroMsg.NetSceneGetConnectInfo", "BackupGetConnectInfoNetScene init, url[%s], stack[%s]", new Object[] { paramString, bs.eWi() });
    b.a locala = new b.a();
    locala.hvt = new avq();
    locala.hvu = new avr();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.aAz();
    ((avq)this.rr.hvr.hvw).URL = paramString;
    AppMethodBeat.o(21717);
  }
  
  public final avr bEI()
  {
    return (avr)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(21718);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21718);
    return i;
  }
  
  public final int getType()
  {
    return 595;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21719);
    ac.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = bEI();
      d.aB(paramq.DUt.getBuffer().xy);
      ac.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", new Object[] { paramq.ID, paramq.DVl, paramq.DVm, paramq.DVe, paramq.DVf, Integer.valueOf(paramq.Scene), paramq.ENI });
      paramq.DUt.getBuffer();
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.e
 * JD-Core Version:    0.7.0.1
 */