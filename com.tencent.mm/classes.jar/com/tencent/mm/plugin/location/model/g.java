package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public String country;
  public String evA;
  public String evz;
  private b rr;
  
  public g(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(182046);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new asw();
    ((b.a)localObject).gUV = new asx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((b.a)localObject).funcId = 665;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (asw)this.rr.gUS.gUX;
    ((asw)localObject).CJE = paramDouble1;
    ((asw)localObject).CJD = paramDouble2;
    ad.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + paramDouble1 + ", longitude:" + paramDouble2);
    AppMethodBeat.o(182046);
  }
  
  public final asx cJj()
  {
    return (asx)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    ad.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (asx)this.rr.gUT.gUX;
      this.evA = paramq.ijO;
      this.country = paramq.ijV;
      this.evz = paramq.ijN;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(182048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */