package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112861);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dxi();
    ((d.a)localObject).lBV = new dxj();
    ((d.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((d.a)localObject).funcId = 2574;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dxi)d.b.b(this.rr.lBR);
    ((dxi)localObject).fUL = paramString;
    ((dxi)localObject).UcR = b.cU(paramArrayOfByte);
    ((dxi)localObject).longitude = paramFloat1;
    ((dxi)localObject).latitude = paramFloat2;
    ((dxi)localObject).UcQ = paramFloat3;
    ((dxi)localObject).UcS = paramBoolean1;
    ((dxi)localObject).UcT = paramBoolean2;
    AppMethodBeat.o(112861);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112862);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112862);
    return i;
  }
  
  public final int getType()
  {
    return 2574;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112863);
    Log.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */