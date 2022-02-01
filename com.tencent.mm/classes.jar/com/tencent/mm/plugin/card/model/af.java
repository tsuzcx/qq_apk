package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.platformtools.ac;

public final class af
  extends n
  implements k
{
  private g callback;
  public String dvP;
  public int nWx;
  public String nWy;
  private final b rr;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112852);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bhv();
    ((b.a)localObject).hvu = new bhw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((b.a)localObject).funcId = 1045;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bhv)this.rr.hvr.hvw;
    ((bhv)localObject).dvO = paramString1;
    ((bhv)localObject).EXh = paramString2;
    ((bhv)localObject).EXi = paramInt;
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
    ac.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bhw)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.dvP = paramq.dvP;
        this.nWy = paramq.nWy;
        this.nWx = paramq.nWx;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112854);
      return;
      paramq = (bhw)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.dvP = paramq.dvP;
        this.nWy = paramq.nWy;
        this.nWx = paramq.nWx;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */