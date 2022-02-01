package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;

public final class y
  extends n
  implements k
{
  private String cVh;
  private f callback;
  private String dpB;
  public String fhy;
  private int qjG;
  private b rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.fhy = paramString3;
    this.cVh = paramString1;
    this.dpB = paramString2;
    this.qjG = 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23422);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new drx();
    paramf.hQG = new dry();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramf.funcId = getType();
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    paramf = (drx)this.rr.hQD.hQJ;
    paramf.fhy = this.fhy;
    paramf.wNY = this.cVh;
    paramf.devicetype = this.dpB;
    paramf.HYz = this.qjG;
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