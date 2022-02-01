package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
  extends n
  implements k
{
  private g callback;
  public final b hpf;
  
  public q()
  {
    AppMethodBeat.i(20638);
    b.a locala = new b.a();
    locala.hvt = new bdr();
    locala.hvu = new bds();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.funcId = 725;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hpf = locala.aAz();
    ((bdr)this.hpf.hvr.hvw).ndI = 0;
    ac.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), bs.eWi() });
    AppMethodBeat.o(20638);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20640);
    this.callback = paramg;
    h.wUl.idkeyStat(405L, 1L, 1L, true);
    int i = dispatch(parame, this.hpf, this);
    AppMethodBeat.o(20640);
    return i;
  }
  
  public final int getType()
  {
    return 725;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20639);
    ac.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.wUl.idkeyStat(405L, 2L, 1L, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q
 * JD-Core Version:    0.7.0.1
 */