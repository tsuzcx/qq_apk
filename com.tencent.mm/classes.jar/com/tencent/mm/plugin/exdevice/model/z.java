package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewb;
import com.tencent.mm.protocal.protobuf.ewc;

public final class z
  extends q
  implements m
{
  private i callback;
  private String fzB;
  private String fzF;
  public String idS;
  private d rr;
  private int vgi;
  
  public z(String paramString1, String paramString2, String paramString3)
  {
    this.idS = paramString3;
    this.fzB = paramString1;
    this.fzF = paramString2;
    this.vgi = 0;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23422);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new ewb();
    parami.lBV = new ewc();
    parami.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    parami.funcId = getType();
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    parami = (ewb)d.b.b(this.rr.lBR);
    parami.idS = this.idS;
    parami.GCL = this.fzB;
    parami.devicetype = this.fzF;
    parami.Uxq = this.vgi;
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
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */