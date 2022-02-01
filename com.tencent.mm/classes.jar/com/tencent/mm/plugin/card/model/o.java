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
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private g callback;
  public String ntw;
  public int ntx;
  public String nty;
  private final b rr;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, cxe paramcxe)
  {
    AppMethodBeat.i(112799);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ak();
    ((b.a)localObject).gUV = new al();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((b.a)localObject).funcId = 1037;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ak)this.rr.gUS.gUX;
    ((ak)localObject).dyc = paramString1;
    ((ak)localObject).nsI = paramString2;
    ((ak)localObject).dye = paramInt1;
    ((ak)localObject).dyd = paramString3;
    ((ak)localObject).CtU = paramString4;
    ((ak)localObject).CtT = paramString5;
    ((ak)localObject).CtV = paramInt2;
    ((ak)localObject).CtW = paramInt3;
    ((ak)localObject).CtX = paramcxe;
    AppMethodBeat.o(112799);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112800);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112800);
    return i;
  }
  
  public final int getType()
  {
    return 1037;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112801);
    ad.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (al)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.ntw = paramq.ntw;
        this.ntx = paramq.ntx;
        this.nty = paramq.nty;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112801);
      return;
      paramq = (al)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.ntw = paramq.ntw;
        this.ntx = paramq.ntx;
        this.nty = paramq.nty;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */