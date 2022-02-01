package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(21952);
    ac.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[] { paramString, bs.eWi() });
    b.a locala = new b.a();
    locala.hvt = new avq();
    locala.hvu = new avr();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.aAz();
    ((avq)this.rr.hvr.hvw).URL = paramString;
    AppMethodBeat.o(21952);
  }
  
  public final avr bFs()
  {
    return (avr)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(21953);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21953);
    return i;
  }
  
  public final int getType()
  {
    return 595;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21954);
    ac.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (avr)this.rr.hvs.hvw;
      d.aB(paramq.DUt.getBuffer().xy);
      ac.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", new Object[] { paramq.ID, paramq.DVl, paramq.DVm, paramq.DVe, paramq.DVf, Integer.valueOf(paramq.Scene) });
      ac.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", new Object[] { paramq.ENI });
      paramq.DUt.getBuffer();
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.f
 * JD-Core Version:    0.7.0.1
 */