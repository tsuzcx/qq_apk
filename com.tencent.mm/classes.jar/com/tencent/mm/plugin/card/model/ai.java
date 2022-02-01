package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.sdk.platformtools.ad;

public final class ai
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112861);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cjr();
    ((b.a)localObject).gUV = new cjs();
    ((b.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((b.a)localObject).funcId = 2574;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cjr)this.rr.gUS.gUX;
    ((cjr)localObject).dyc = paramString;
    ((cjr)localObject).EeL = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    ((cjr)localObject).dqQ = paramFloat1;
    ((cjr)localObject).dpb = paramFloat2;
    ((cjr)localObject).EeK = paramFloat3;
    ((cjr)localObject).EeM = paramBoolean1;
    ((cjr)localObject).EeN = paramBoolean2;
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
    ad.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */