package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dlj;
import com.tencent.mm.protocal.protobuf.dlk;

public final class y
  extends n
  implements k
{
  private String cIZ;
  private g callback;
  private String dda;
  public String eNf;
  private int pzw;
  private b rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.eNf = paramString3;
    this.cIZ = paramString1;
    this.dda = paramString2;
    this.pzw = 0;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23422);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new dlj();
    paramg.hvu = new dlk();
    paramg.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
    paramg = (dlj)this.rr.hvr.hvw;
    paramg.eNf = this.eNf;
    paramg.vsV = this.cIZ;
    paramg.devicetype = this.dda;
    paramg.FTY = this.pzw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.y
 * JD-Core Version:    0.7.0.1
 */