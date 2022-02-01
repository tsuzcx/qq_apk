package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;

public final class y
  extends n
  implements k
{
  private String cLR;
  private g callback;
  private String dfF;
  public String eKn;
  private int oWl;
  private b rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.eKn = paramString3;
    this.cLR = paramString1;
    this.dfF = paramString2;
    this.oWl = 0;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23422);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new dfu();
    paramg.gUV = new dfv();
    paramg.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
    paramg = (dfu)this.rr.gUS.gUX;
    paramg.eKn = this.eKn;
    paramg.ujZ = this.cLR;
    paramg.devicetype = this.dfF;
    paramg.EwW = this.oWl;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23422);
    return i;
  }
  
  public final int getType()
  {
    return 1263;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23423);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.y
 * JD-Core Version:    0.7.0.1
 */