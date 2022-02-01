package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  public String pTY;
  public int pTZ;
  public String pUa;
  private final d rr;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, eck parameck)
  {
    AppMethodBeat.i(112799);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new am();
    ((d.a)localObject).iLO = new an();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((d.a)localObject).funcId = 1037;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (am)this.rr.iLK.iLR;
    ((am)localObject).eaO = paramString1;
    ((am)localObject).pPy = paramString2;
    ((am)localObject).eaQ = paramInt1;
    ((am)localObject).eaP = paramString3;
    ((am)localObject).KDg = paramString4;
    ((am)localObject).KDf = paramString5;
    ((am)localObject).KDh = paramInt2;
    ((am)localObject).KDi = paramInt3;
    ((am)localObject).KDj = parameck;
    AppMethodBeat.o(112799);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112800);
    this.callback = parami;
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
      params = (an)this.rr.iLL.iLR;
      if (params != null)
      {
        this.pTY = params.pTY;
        this.pTZ = params.pTZ;
        this.pUa = params.pUa;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112801);
      return;
      params = (an)this.rr.iLL.iLR;
      if (params != null)
      {
        this.pTY = params.pTY;
        this.pTZ = params.pTZ;
        this.pUa = params.pUa;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */