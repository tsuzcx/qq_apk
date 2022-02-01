package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.sdk.platformtools.ad;

public final class al
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public al()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new bbk();
    locala.hNN = new bbl();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.hNO = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.aDC();
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
    ad.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bbl)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      ad.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(paramq.Fvd), Long.valueOf(paramq.nDF), Integer.valueOf(paramq.Gyw), Integer.valueOf(paramq.Gyv), Integer.valueOf(paramq.Gyu) });
      b.vn(paramq.Fvd);
      b.vo(paramq.nDF);
      b.vq(paramq.Gyw);
      b.vr(paramq.Gyv);
      b.vs(paramq.Gyu);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */