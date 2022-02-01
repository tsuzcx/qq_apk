package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.sdk.platformtools.ae;

public final class ai
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112861);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cux();
    ((b.a)localObject).hQG = new cuy();
    ((b.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((b.a)localObject).funcId = 2574;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cux)this.rr.hQD.hQJ;
    ((cux)localObject).dJb = paramString;
    ((cux)localObject).HFA = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    ((cux)localObject).dBu = paramFloat1;
    ((cux)localObject).dzE = paramFloat2;
    ((cux)localObject).HFz = paramFloat3;
    ((cux)localObject).HFB = paramBoolean1;
    ((cux)localObject).HFC = paramBoolean2;
    AppMethodBeat.o(112861);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112862);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112862);
    return i;
  }
  
  public final int getType()
  {
    return 2574;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112863);
    ae.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */