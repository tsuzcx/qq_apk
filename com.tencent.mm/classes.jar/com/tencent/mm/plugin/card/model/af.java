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
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends p
  implements m
{
  private h callback;
  public String iaJ;
  private final c rr;
  public String wuA;
  public int wuz;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cxh();
    ((c.a)localObject).otF = new cxi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((c.a)localObject).funcId = 1045;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cxh)c.b.b(this.rr.otB);
    ((cxh)localObject).iaI = paramString1;
    ((cxh)localObject).waL = paramString2;
    ((cxh)localObject).aaCP = paramInt;
    AppMethodBeat.o(112852);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112853);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112853);
    return i;
  }
  
  public final int getType()
  {
    return 1045;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112854);
    Log.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cxi)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.iaJ = params.iaJ;
        this.wuA = params.wuA;
        this.wuz = params.wuz;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      params = (cxi)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.iaJ = params.iaJ;
        this.wuA = params.wuA;
        this.wuz = params.wuz;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */