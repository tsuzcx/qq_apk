package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b rr;
  private cmt uNc;
  public cmu uNd;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(25454);
    this.rr = null;
    this.uNc = null;
    this.uNd = null;
    b.a locala = new b.a();
    locala.hNM = new cmt();
    locala.hNN = new cmu();
    locala.funcId = 807;
    locala.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNc = ((cmt)this.rr.hNK.hNQ);
    this.uNc.Hga = paramString1;
    this.uNc.Hgc = paramString2;
    this.uNc.Hge = paramString3;
    this.uNc.Hgd = paramString4;
    this.uNc.Hgf = paramInt;
    ad.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) });
    AppMethodBeat.o(25454);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25455);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25455);
    return i;
  }
  
  public final int getType()
  {
    return 807;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25456);
    ad.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNd = ((cmu)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.b
 * JD-Core Version:    0.7.0.1
 */