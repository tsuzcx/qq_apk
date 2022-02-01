package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.sdk.platformtools.ac;

public final class al
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public al()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new axi();
    locala.hvu = new axj();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.reqCmdId = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.aAz();
    AppMethodBeat.o(103480);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103481);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (axj)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      ac.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(paramq.DPO), Long.valueOf(paramq.ndi), Integer.valueOf(paramq.EPl), Integer.valueOf(paramq.EPk), Integer.valueOf(paramq.EPj) });
      b.tq(paramq.DPO);
      b.tr(paramq.ndi);
      b.tt(paramq.EPl);
      b.tu(paramq.EPk);
      b.tv(paramq.EPj);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */