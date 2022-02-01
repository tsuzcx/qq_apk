package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bin;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class r
  extends n
  implements k
{
  private f callback;
  public final b hKp;
  
  public r()
  {
    AppMethodBeat.i(20638);
    b.a locala = new b.a();
    locala.hQF = new bin();
    locala.hQG = new bio();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.funcId = 725;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hKp = locala.aDS();
    ((bin)this.hKp.hQD.hQJ).nJA = 0;
    ae.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), bu.fpN() });
    AppMethodBeat.o(20638);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20640);
    this.callback = paramf;
    g.yxI.idkeyStat(405L, 1L, 1L, true);
    int i = dispatch(parame, this.hKp, this);
    AppMethodBeat.o(20640);
    return i;
  }
  
  public final int getType()
  {
    return 725;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20639);
    ae.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      g.yxI.idkeyStat(405L, 2L, 1L, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.r
 * JD-Core Version:    0.7.0.1
 */