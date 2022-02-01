package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.sdk.platformtools.ac;

public final class ai
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112861);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new coy();
    ((b.a)localObject).hvu = new coz();
    ((b.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((b.a)localObject).funcId = 2574;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (coy)this.rr.hvr.hvw;
    ((coy)localObject).dvO = paramString;
    ((coy)localObject).FBL = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    ((coy)localObject).doB = paramFloat1;
    ((coy)localObject).dmL = paramFloat2;
    ((coy)localObject).FBK = paramFloat3;
    ((coy)localObject).FBM = paramBoolean1;
    ((coy)localObject).FBN = paramBoolean2;
    AppMethodBeat.o(112861);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112862);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */