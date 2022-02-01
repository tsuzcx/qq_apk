package com.tencent.mm.plugin.ext.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  public f callback;
  public String mUrl;
  public int reB;
  private b rr;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24508);
    this.reB = -1;
    this.mUrl = null;
    this.mUrl = paramString;
    b.a locala = new b.a();
    locala.hNM = new wn();
    locala.hNN = new wo();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.funcId = 782;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ad.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (wn)this.rr.hNK.hNQ;
    paramString.URL = this.mUrl;
    paramString.FVR = paramInt1;
    paramString.FVS = paramInt2;
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
    ad.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (wo)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.reB = paramq.nEf;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.a.a
 * JD-Core Version:    0.7.0.1
 */