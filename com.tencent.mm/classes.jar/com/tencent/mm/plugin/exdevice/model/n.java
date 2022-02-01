package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  public String cVh;
  private f callback;
  public int qjB;
  b rr;
  
  public n(bpm parambpm, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.cVh = null;
    this.qjB = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dpt();
    ((b.a)localObject).hQG = new dpu();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((b.a)localObject).funcId = 1717;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dpt)this.rr.hQD.hQJ;
    ((dpt)localObject).FSh = paramString1;
    ((dpt)localObject).Gte = paramString2;
    ((dpt)localObject).HWP = parambpm;
    ((dpt)localObject).HWQ = paramInt;
    this.cVh = paramString2;
    this.qjB = paramInt;
    AppMethodBeat.o(23388);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23390);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23390);
    return i;
  }
  
  public final int getType()
  {
    return 1717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23389);
    ae.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */