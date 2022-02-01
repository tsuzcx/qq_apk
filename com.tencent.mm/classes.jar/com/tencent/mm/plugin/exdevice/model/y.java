package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.drb;

public final class y
  extends n
  implements k
{
  private String cUi;
  private f callback;
  private String dow;
  public String ffB;
  private int qdb;
  private b rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.ffB = paramString3;
    this.cUi = paramString1;
    this.dow = paramString2;
    this.qdb = 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23422);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new dra();
    paramf.hNN = new drb();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramf.funcId = getType();
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    paramf = (dra)this.rr.hNK.hNQ;
    paramf.ffB = this.ffB;
    paramf.wyn = this.cUi;
    paramf.devicetype = this.dow;
    paramf.HEM = this.qdb;
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