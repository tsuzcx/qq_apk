package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;

public final class y
  extends m
  implements k
{
  private String bYu;
  private f callback;
  private String cqJ;
  public String dCJ;
  private int lFA;
  private b rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.dCJ = paramString3;
    this.bYu = paramString1;
    this.cqJ = paramString2;
    this.lFA = 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19353);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new cmu();
    paramf.fsY = new cmv();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramf.funcId = getType();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    paramf = (cmu)this.rr.fsV.fta;
    paramf.dCJ = this.dCJ;
    paramf.plt = this.bYu;
    paramf.devicetype = this.cqJ;
    paramf.xWt = this.lFA;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19353);
    return i;
  }
  
  public final int getType()
  {
    return 1263;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19354);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.y
 * JD-Core Version:    0.7.0.1
 */