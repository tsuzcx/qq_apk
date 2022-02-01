package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  private i callback;
  public String country;
  public String fuJ;
  public String fuK;
  private d rr;
  
  public g(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(182046);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bmd();
    ((d.a)localObject).iLO = new bme();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((d.a)localObject).funcId = 665;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bmd)this.rr.iLK.iLR;
    ((bmd)localObject).KUu = paramDouble1;
    ((bmd)localObject).KUt = paramDouble2;
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
  
  public final bme ecK()
  {
    return (bme)this.rr.iLL.iLR;
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
      params = (bme)this.rr.iLL.iLR;
      this.fuK = params.kea;
      this.country = params.keh;
      this.fuJ = params.kdZ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(182048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */