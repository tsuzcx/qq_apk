package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  public String cIZ;
  private g callback;
  public int pzr;
  b rr;
  
  public n(bkk parambkk, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.cIZ = null;
    this.pzr = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new djh();
    ((b.a)localObject).hvu = new dji();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((b.a)localObject).funcId = 1717;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (djh)this.rr.hvr.hvw;
    ((djh)localObject).DUp = paramString1;
    ((djh)localObject).Etg = paramString2;
    ((djh)localObject).FSt = parambkk;
    ((djh)localObject).FSu = paramInt;
    this.cIZ = paramString2;
    this.pzr = paramInt;
    AppMethodBeat.o(23388);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23390);
    this.callback = paramg;
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
    ac.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */