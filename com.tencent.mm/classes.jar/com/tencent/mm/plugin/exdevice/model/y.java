package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elv;
import com.tencent.mm.protocal.protobuf.elw;

public final class y
  extends q
  implements m
{
  private i callback;
  private String dGL;
  private String dGP;
  public String fMb;
  private int rAB;
  private d rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.fMb = paramString3;
    this.dGL = paramString1;
    this.dGP = paramString2;
    this.rAB = 0;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23422);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new elv();
    parami.iLO = new elw();
    parami.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    parami.funcId = getType();
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    parami = (elv)this.rr.iLK.iLR;
    parami.fMb = this.fMb;
    parami.AJE = this.dGL;
    parami.devicetype = this.dGP;
    parami.NkG = this.rAB;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23422);
    return i;
  }
  
  public final int getType()
  {
    return 1263;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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