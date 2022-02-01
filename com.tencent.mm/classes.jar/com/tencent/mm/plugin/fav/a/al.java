package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.sdk.platformtools.ad;

public final class al
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b rr;
  
  public al()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    b.a locala = new b.a();
    locala.gUU = new auc();
    locala.gUV = new aud();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.reqCmdId = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.atI();
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
    ad.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aud)((com.tencent.mm.al.b)paramq).gUT.gUX;
      ad.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(paramq.Cxs), Long.valueOf(paramq.mBh), Integer.valueOf(paramq.Duc), Integer.valueOf(paramq.Dub), Integer.valueOf(paramq.Dua) });
      b.pB(paramq.Cxs);
      b.pC(paramq.mBh);
      b.pE(paramq.Duc);
      b.pF(paramq.Dub);
      b.pG(paramq.Dua);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */