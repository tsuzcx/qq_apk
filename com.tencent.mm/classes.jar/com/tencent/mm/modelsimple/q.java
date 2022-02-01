package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  extends n
  implements k
{
  private f callback;
  public final b hHx;
  
  public q()
  {
    AppMethodBeat.i(20638);
    b.a locala = new b.a();
    locala.hNM = new bhx();
    locala.hNN = new bhy();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.funcId = 725;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hHx = locala.aDC();
    ((bhx)this.hHx.hNK.hNQ).nEf = 0;
    ad.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), bt.flS() });
    AppMethodBeat.o(20638);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20640);
    this.callback = paramf;
    g.yhR.idkeyStat(405L, 1L, 1L, true);
    int i = dispatch(parame, this.hHx, this);
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
    ad.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      g.yhR.idkeyStat(405L, 2L, 1L, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q
 * JD-Core Version:    0.7.0.1
 */