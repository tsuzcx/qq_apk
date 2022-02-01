package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxh;
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
    ((d.a)localObject).lBU = new dxg();
    ((d.a)localObject).lBV = new dxh();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((d.a)localObject).funcId = 1253;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dxg)d.b.b(this.rr.lBR);
    ((dxg)localObject).latitude = paramFloat1;
    ((dxg)localObject).longitude = paramFloat2;
    ((dxg)localObject).fUL = paramString1;
    ((dxg)localObject).tnX = paramString2;
    ((dxg)localObject).UcP = paramInt;
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