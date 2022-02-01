package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public String country;
  public String exV;
  public String exW;
  private b rr;
  
  public g(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(182046);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new awa();
    ((b.a)localObject).hvu = new awb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((b.a)localObject).funcId = 665;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (awa)this.rr.hvr.hvw;
    ((awa)localObject).Ecg = paramDouble1;
    ((awa)localObject).Ecf = paramDouble2;
    ac.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + paramDouble1 + ", longitude:" + paramDouble2);
    AppMethodBeat.o(182046);
  }
  
  public final awb cWO()
  {
    return (awb)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(182047);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (awb)this.rr.hvs.hvw;
      this.exW = paramq.iJV;
      this.country = paramq.iKc;
      this.exV = paramq.iJU;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(182048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */