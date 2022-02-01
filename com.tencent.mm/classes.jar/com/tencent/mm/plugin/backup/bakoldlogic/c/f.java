package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private final com.tencent.mm.al.b rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(21952);
    ad.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[] { paramString, bt.flS() });
    b.a locala = new b.a();
    locala.hNM = new azo();
    locala.hNN = new azp();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.hNO = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.aDC();
    ((azo)this.rr.hNK.hNQ).URL = paramString;
    AppMethodBeat.o(21952);
  }
  
  public final azp bJB()
  {
    return (azp)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(21953);
    this.callback = paramf;
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
    ad.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (azp)this.rr.hNL.hNQ;
      d.aB(paramq.FzN.getBuffer().zr);
      ad.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", new Object[] { paramq.ID, paramq.FAG, paramq.FAH, paramq.FAz, paramq.FAA, Integer.valueOf(paramq.Scene) });
      ad.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", new Object[] { paramq.GwM });
      paramq.FzN.getBuffer();
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.f
 * JD-Core Version:    0.7.0.1
 */