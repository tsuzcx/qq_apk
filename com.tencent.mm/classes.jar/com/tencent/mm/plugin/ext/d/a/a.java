package com.tencent.mm.plugin.ext.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  public f callback;
  public String mUrl;
  public int rmE;
  private b rr;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24508);
    this.rmE = -1;
    this.mUrl = null;
    this.mUrl = paramString;
    b.a locala = new b.a();
    locala.hQF = new wq();
    locala.hQG = new wr();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.funcId = 782;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ae.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (wq)this.rr.hQD.hQJ;
    paramString.URL = this.mUrl;
    paramString.Goq = paramInt1;
    paramString.Gor = paramInt2;
    AppMethodBeat.o(24508);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24509);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24509);
    return i;
  }
  
  public final int getType()
  {
    return 782;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24510);
    ae.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (wr)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.rmE = paramq.nJA;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.a.a
 * JD-Core Version:    0.7.0.1
 */