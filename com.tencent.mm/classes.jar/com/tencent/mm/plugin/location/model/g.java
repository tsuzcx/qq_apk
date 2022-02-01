package com.tencent.mm.plugin.location.model;

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
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  public String country;
  public String ePu;
  public String ePv;
  private b rr;
  
  public g(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(182046);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new azy();
    ((b.a)localObject).hNN = new azz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((b.a)localObject).funcId = 665;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (azy)this.rr.hNK.hNQ;
    ((azy)localObject).FIc = paramDouble1;
    ((azy)localObject).FIb = paramDouble2;
    ad.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + paramDouble1 + ", longitude:" + paramDouble2);
    AppMethodBeat.o(182046);
  }
  
  public final azz dga()
  {
    return (azz)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182047);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182047);
    return i;
  }
  
  public final int getType()
  {
    return 665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182048);
    ad.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (azz)this.rr.hNL.hNQ;
      this.ePv = paramq.jde;
      this.country = paramq.jdl;
      this.ePu = paramq.jdd;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(182048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */