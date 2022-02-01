package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public u(float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112818);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dno();
    ((d.a)localObject).iLO = new dnp();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((d.a)localObject).funcId = 1253;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dno)this.rr.iLK.iLR;
    ((dno)localObject).latitude = paramFloat1;
    ((dno)localObject).longitude = paramFloat2;
    ((dno)localObject).eaO = paramString1;
    ((dno)localObject).pRX = paramString2;
    ((dno)localObject).MQI = paramInt;
    AppMethodBeat.o(112818);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112819);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112819);
    return i;
  }
  
  public final int getType()
  {
    return 1253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112820);
    Log.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.u
 * JD-Core Version:    0.7.0.1
 */