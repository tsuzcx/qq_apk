package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.ad;

public final class ai
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112861);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cud();
    ((b.a)localObject).hNN = new cue();
    ((b.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((b.a)localObject).funcId = 2574;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cud)this.rr.hNK.hNQ;
    ((cud)localObject).dHX = paramString;
    ((cud)localObject).Hma = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    ((cud)localObject).dAp = paramFloat1;
    ((cud)localObject).dyz = paramFloat2;
    ((cud)localObject).HlZ = paramFloat3;
    ((cud)localObject).Hmb = paramBoolean1;
    ((cud)localObject).Hmc = paramBoolean2;
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
    ad.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */