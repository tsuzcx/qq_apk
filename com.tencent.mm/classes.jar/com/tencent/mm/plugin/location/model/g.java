package com.tencent.mm.plugin.location.model;

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
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends n
  implements k
{
  private f callback;
  public String country;
  public String eRf;
  public String eRg;
  private b rr;
  
  public g(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(182046);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bao();
    ((b.a)localObject).hQG = new bap();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((b.a)localObject).funcId = 665;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bao)this.rr.hQD.hQJ;
    ((bao)localObject).Gay = paramDouble1;
    ((bao)localObject).Gax = paramDouble2;
    ae.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + paramDouble1 + ", longitude:" + paramDouble2);
    AppMethodBeat.o(182046);
  }
  
  public final bap diZ()
  {
    return (bap)this.rr.hQE.hQJ;
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
    ae.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bap)this.rr.hQE.hQJ;
      this.eRg = paramq.jfX;
      this.country = paramq.jge;
      this.eRf = paramq.jfW;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(182048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */