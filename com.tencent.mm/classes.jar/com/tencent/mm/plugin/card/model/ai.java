package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.sdk.platformtools.ab;

public final class ai
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87919);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bue();
    ((b.a)localObject).fsY = new buf();
    ((b.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((b.a)localObject).funcId = 2574;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bue)this.rr.fsV.fta;
    ((bue)localObject).cHn = paramString;
    ((bue)localObject).xHw = com.tencent.mm.bv.b.bL(paramArrayOfByte);
    ((bue)localObject).cAH = paramFloat1;
    ((bue)localObject).cyV = paramFloat2;
    ((bue)localObject).xHv = paramFloat3;
    ((bue)localObject).xHx = paramBoolean1;
    ((bue)localObject).xHy = paramBoolean2;
    AppMethodBeat.o(87919);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87920);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87920);
    return i;
  }
  
  public final int getType()
  {
    return 2574;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87921);
    ab.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */