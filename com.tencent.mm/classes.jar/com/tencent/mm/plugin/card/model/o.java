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
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends m
  implements k
{
  private f callback;
  public String koi;
  public int koj;
  public String kok;
  private final b rr;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, cgd paramcgd)
  {
    AppMethodBeat.i(87857);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ai();
    ((b.a)localObject).fsY = new aj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((b.a)localObject).funcId = 651;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ai)this.rr.fsV.fta;
    ((ai)localObject).cHn = paramString1;
    ((ai)localObject).knu = paramString2;
    ((ai)localObject).cHp = paramInt1;
    ((ai)localObject).cHo = paramString3;
    ((ai)localObject).wlG = paramString4;
    ((ai)localObject).wlF = paramString5;
    ((ai)localObject).wlH = paramInt2;
    ((ai)localObject).wlI = paramInt3;
    ((ai)localObject).wlJ = paramcgd;
    AppMethodBeat.o(87857);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87858);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87858);
    return i;
  }
  
  public final int getType()
  {
    return 651;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87859);
    ab.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aj)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.koi = paramq.koi;
        this.koj = paramq.koj;
        this.kok = paramq.kok;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(87859);
      return;
      paramq = (aj)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.koi = paramq.koi;
        this.koj = paramq.koj;
        this.kok = paramq.kok;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */