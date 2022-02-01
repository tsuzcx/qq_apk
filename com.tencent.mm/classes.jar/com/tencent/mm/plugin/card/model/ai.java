package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.eqn;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112861);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eqm();
    ((c.a)localObject).otF = new eqn();
    ((c.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((c.a)localObject).funcId = 2574;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eqm)c.b.b(this.rr.otB);
    ((eqm)localObject).iaI = paramString;
    ((eqm)localObject).abul = b.cX(paramArrayOfByte);
    ((eqm)localObject).longitude = paramFloat1;
    ((eqm)localObject).latitude = paramFloat2;
    ((eqm)localObject).abuk = paramFloat3;
    ((eqm)localObject).abum = paramBoolean1;
    ((eqm)localObject).abun = paramBoolean2;
    AppMethodBeat.o(112861);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112862);
    this.callback = paramh;
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