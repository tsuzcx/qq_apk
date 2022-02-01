package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.platformtools.ae;

public final class al
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public al()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new bca();
    locala.hQG = new bcb();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.hQH = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.aDS();
    AppMethodBeat.o(103480);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103481);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103481);
    return i;
  }
  
  public final int getType()
  {
    return 438;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103482);
    ae.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcb)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      ae.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(paramq.FNB), Long.valueOf(paramq.nJa), Integer.valueOf(paramq.GRW), Integer.valueOf(paramq.GRV), Integer.valueOf(paramq.GRU) });
      b.vD(paramq.FNB);
      b.vE(paramq.nJa);
      b.vG(paramq.GRW);
      b.vH(paramq.GRV);
      b.vI(paramq.GRU);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */