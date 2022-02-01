package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.sdk.platformtools.ae;

public final class af
  extends n
  implements k
{
  private f callback;
  public String dJc;
  public int oGt;
  public String oGu;
  private final b rr;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bmv();
    ((b.a)localObject).hQG = new bmw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((b.a)localObject).funcId = 1045;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bmv)this.rr.hQD.hQJ;
    ((bmv)localObject).dJb = paramString1;
    ((bmv)localObject).oBN = paramString2;
    ((bmv)localObject).Hag = paramInt;
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
    ae.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bmw)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.dJc = paramq.dJc;
        this.oGu = paramq.oGu;
        this.oGt = paramq.oGt;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      paramq = (bmw)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.dJc = paramq.dJc;
        this.oGu = paramq.oGu;
        this.oGt = paramq.oGt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */