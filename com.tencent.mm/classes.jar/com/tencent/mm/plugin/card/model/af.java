package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.sdk.platformtools.ab;

public final class af
  extends m
  implements k
{
  public String cHo;
  private f callback;
  public int koj;
  public String kok;
  private final b rr;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(87910);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new atc();
    ((b.a)localObject).fsY = new atd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((b.a)localObject).funcId = 652;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (atc)this.rr.fsV.fta;
    ((atc)localObject).cHn = paramString1;
    ((atc)localObject).xit = paramString2;
    ((atc)localObject).xiu = paramInt;
    AppMethodBeat.o(87910);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87911);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87911);
    return i;
  }
  
  public final int getType()
  {
    return 652;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87912);
    ab.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (atd)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.cHo = paramq.cHo;
        this.kok = paramq.kok;
        this.koj = paramq.koj;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(87912);
      return;
      paramq = (atd)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.cHo = paramq.cHo;
        this.kok = paramq.kok;
        this.koj = paramq.koj;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */