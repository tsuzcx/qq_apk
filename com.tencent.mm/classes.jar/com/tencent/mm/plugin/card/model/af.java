package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ad;

public final class af
  extends n
  implements k
{
  private f callback;
  public String dHY;
  public int ozR;
  public String ozS;
  private final b rr;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bmd();
    ((b.a)localObject).hNN = new bme();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((b.a)localObject).funcId = 1045;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bmd)this.rr.hNK.hNQ;
    ((bmd)localObject).dHX = paramString1;
    ((bmd)localObject).ovm = paramString2;
    ((bmd)localObject).GGE = paramInt;
    AppMethodBeat.o(112852);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112853);
    this.callback = paramf;
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
      paramq = (bme)this.rr.hNL.hNQ;
      if (paramq != null)
      {
        this.dHY = paramq.dHY;
        this.ozS = paramq.ozS;
        this.ozR = paramq.ozR;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      paramq = (bme)this.rr.hNL.hNQ;
      if (paramq != null)
      {
        this.dHY = paramq.dHY;
        this.ozS = paramq.ozS;
        this.ozR = paramq.ozR;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */