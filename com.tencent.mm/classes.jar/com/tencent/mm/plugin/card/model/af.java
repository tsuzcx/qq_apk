package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.sdk.platformtools.ad;

public final class af
  extends n
  implements k
{
  private g callback;
  public String dyd;
  public int ntx;
  public String nty;
  private final b rr;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bed();
    ((b.a)localObject).gUV = new bee();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((b.a)localObject).funcId = 1045;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bed)this.rr.gUS.gUX;
    ((bed)localObject).dyc = paramString1;
    ((bed)localObject).DBL = paramString2;
    ((bed)localObject).DBM = paramInt;
    AppMethodBeat.o(112852);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112853);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112853);
    return i;
  }
  
  public final int getType()
  {
    return 1045;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112854);
    ad.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bee)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.dyd = paramq.dyd;
        this.nty = paramq.nty;
        this.ntx = paramq.ntx;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      paramq = (bee)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.dyd = paramq.dyd;
        this.nty = paramq.nty;
        this.ntx = paramq.ntx;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */