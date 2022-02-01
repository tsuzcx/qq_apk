package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  private i callback;
  public String city;
  public String country;
  public String province;
  private d rr;
  
  public g(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(182046);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new btm();
    ((d.a)localObject).lBV = new btn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((d.a)localObject).funcId = 665;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (btm)d.b.b(this.rr.lBR);
    ((btm)localObject).RVz = paramDouble1;
    ((btm)localObject).RVy = paramDouble2;
    Log.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + paramDouble1 + ", longitude:" + paramDouble2);
    AppMethodBeat.o(182046);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(182047);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182047);
    return i;
  }
  
  public final btn eMc()
  {
    AppMethodBeat.i(244606);
    btn localbtn = (btn)d.c.b(this.rr.lBS);
    AppMethodBeat.o(244606);
    return localbtn;
  }
  
  public final int getType()
  {
    return 665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182048);
    Log.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (btn)d.c.b(this.rr.lBS);
      this.city = params.mVA;
      this.country = params.mVH;
      this.province = params.mVz;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(182048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */