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
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.sdk.platformtools.ab;

public final class ag
  extends m
  implements k
{
  public String cFh;
  private f callback;
  public String content;
  public String hhh;
  public String koD;
  public String koE;
  public boolean koF;
  public String koG;
  public String koH;
  public String koI;
  public String koJ;
  private final b rr;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(87913);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bna();
    ((b.a)localObject).fsY = new bnb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((b.a)localObject).funcId = 1171;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bna)this.rr.fsV.fta;
    ((bna)localObject).wlL = paramInt;
    ((bna)localObject).wlM = paramString1;
    ((bna)localObject).wlN = paramString2;
    AppMethodBeat.o(87913);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87915);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87915);
    return i;
  }
  
  public final int getType()
  {
    return 1171;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87914);
    ab.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bnb)this.rr.fsW.fta;
      this.cFh = paramq.wlQ;
      this.koD = paramq.wlR;
      this.status = paramq.status;
      this.content = paramq.content;
      this.koE = paramq.knU;
      this.hhh = paramq.xBj;
      this.koF = paramq.koF;
      this.koG = paramq.xBk;
      this.koH = paramq.xBl;
      this.koI = paramq.xBm;
      this.koJ = paramq.xBn;
      ab.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.cFh, this.koD, Integer.valueOf(this.status), this.content, this.koE, this.hhh, Boolean.valueOf(this.koF) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */