package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public String cLR;
  private g callback;
  public int oWg;
  b rr;
  
  public n(bgs parambgs, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.cLR = null;
    this.oWg = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dds();
    ((b.a)localObject).gUV = new ddt();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((b.a)localObject).funcId = 1717;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (dds)this.rr.gUS.gUX;
    ((dds)localObject).CBS = paramString1;
    ((dds)localObject).Daj = paramString2;
    ((dds)localObject).Evq = parambgs;
    ((dds)localObject).Evr = paramInt;
    this.cLR = paramString2;
    this.oWg = paramInt;
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
    ad.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */