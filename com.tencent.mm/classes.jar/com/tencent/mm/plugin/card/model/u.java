package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eqk;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public u(float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112818);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eqk();
    ((c.a)localObject).otF = new eql();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((c.a)localObject).funcId = 1253;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eqk)c.b.b(this.rr.otB);
    ((eqk)localObject).latitude = paramFloat1;
    ((eqk)localObject).longitude = paramFloat2;
    ((eqk)localObject).iaI = paramString1;
    ((eqk)localObject).wsy = paramString2;
    ((eqk)localObject).abuj = paramInt;
    AppMethodBeat.o(112818);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112819);
    this.callback = paramh;
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