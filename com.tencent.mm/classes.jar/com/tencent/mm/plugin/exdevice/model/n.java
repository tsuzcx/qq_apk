package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public String cUi;
  private f callback;
  public int qcW;
  b rr;
  
  public n(bou parambou, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(23388);
    this.callback = null;
    this.rr = null;
    this.cUi = null;
    this.qcW = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dow();
    ((b.a)localObject).hNN = new dox();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((b.a)localObject).funcId = 1717;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dow)this.rr.hNK.hNQ;
    ((dow)localObject).FzJ = paramString1;
    ((dow)localObject).Gax = paramString2;
    ((dow)localObject).HDc = parambou;
    ((dow)localObject).HDd = paramInt;
    this.cUi = paramString2;
    this.qcW = paramInt;
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
    ad.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */