package com.tencent.mm.plugin.ext.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  public g callback;
  public String mUrl;
  public int quL;
  private b rr;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24508);
    this.quL = -1;
    this.mUrl = null;
    this.mUrl = paramString;
    b.a locala = new b.a();
    locala.hvt = new uo();
    locala.hvu = new up();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.funcId = 782;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (uo)this.rr.hvr.hvw;
    paramString.URL = this.mUrl;
    paramString.EoF = paramInt1;
    paramString.EoG = paramInt2;
    AppMethodBeat.o(24508);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(24509);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (up)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.quL = paramq.ndI;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.a.a
 * JD-Core Version:    0.7.0.1
 */