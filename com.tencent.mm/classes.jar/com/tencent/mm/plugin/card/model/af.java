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
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends q
  implements m
{
  private i callback;
  public String eaP;
  public int pTZ;
  public String pUa;
  private final d rr;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bzm();
    ((d.a)localObject).iLO = new bzn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((d.a)localObject).funcId = 1045;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bzm)this.rr.iLK.iLR;
    ((bzm)localObject).eaO = paramString1;
    ((bzm)localObject).pPz = paramString2;
    ((bzm)localObject).Mfg = paramInt;
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
      params = (bzn)this.rr.iLL.iLR;
      if (params != null)
      {
        this.eaP = params.eaP;
        this.pUa = params.pUa;
        this.pTZ = params.pTZ;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      params = (bzn)this.rr.iLL.iLR;
      if (params != null)
      {
        this.eaP = params.eaP;
        this.pUa = params.pUa;
        this.pTZ = params.pTZ;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */