package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dnr;
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
    ((d.a)localObject).iLN = new dnq();
    ((d.a)localObject).iLO = new dnr();
    ((d.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((d.a)localObject).funcId = 2574;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dnq)this.rr.iLK.iLR;
    ((dnq)localObject).eaO = paramString;
    ((dnq)localObject).MQK = b.cD(paramArrayOfByte);
    ((dnq)localObject).dTj = paramFloat1;
    ((dnq)localObject).latitude = paramFloat2;
    ((dnq)localObject).MQJ = paramFloat3;
    ((dnq)localObject).MQL = paramBoolean1;
    ((dnq)localObject).MQM = paramBoolean2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */