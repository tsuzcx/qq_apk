package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends q
  implements m
{
  private i callback;
  public String fUM;
  private final d rr;
  public int tqa;
  public String tqb;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new chg();
    ((d.a)localObject).lBV = new chh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((d.a)localObject).funcId = 1045;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (chg)d.b.b(this.rr.lBR);
    ((chg)localObject).fUL = paramString1;
    ((chg)localObject).sWA = paramString2;
    ((chg)localObject).ToI = paramInt;
    AppMethodBeat.o(112852);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112853);
    this.callback = parami;
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
      params = (chh)d.c.b(this.rr.lBS);
      if (params != null)
      {
        this.fUM = params.fUM;
        this.tqb = params.tqb;
        this.tqa = params.tqa;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      params = (chh)d.c.b(this.rr.lBS);
      if (params != null)
      {
        this.fUM = params.fUM;
        this.tqb = params.tqb;
        this.tqa = params.tqa;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */