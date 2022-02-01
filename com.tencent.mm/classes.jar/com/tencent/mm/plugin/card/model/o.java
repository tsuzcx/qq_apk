package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String wuA;
  public String wuy;
  public int wuz;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, fhj paramfhj)
  {
    AppMethodBeat.i(112799);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new am();
    ((c.a)localObject).otF = new an();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((c.a)localObject).funcId = 1037;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (am)c.b.b(this.rr.otB);
    ((am)localObject).iaI = paramString1;
    ((am)localObject).from_username = paramString2;
    ((am)localObject).iaK = paramInt1;
    ((am)localObject).iaJ = paramString3;
    ((am)localObject).YBc = paramString4;
    ((am)localObject).YBb = paramString5;
    ((am)localObject).YBd = paramInt2;
    ((am)localObject).YBe = paramInt3;
    ((am)localObject).YBf = paramfhj;
    AppMethodBeat.o(112799);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112800);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112800);
    return i;
  }
  
  public final int getType()
  {
    return 1037;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112801);
    Log.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (an)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.wuy = params.wuy;
        this.wuz = params.wuz;
        this.wuA = params.wuA;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112801);
      return;
      params = (an)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.wuy = params.wuy;
        this.wuz = params.wuz;
        this.wuA = params.wuA;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */