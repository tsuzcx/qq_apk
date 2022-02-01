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
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.platformtools.ad;

public final class ag
  extends n
  implements k
{
  private f callback;
  public String content;
  public String dFE;
  public String jVX;
  public String oAk;
  public String oAl;
  public boolean oAm;
  public String oAn;
  public String oAo;
  public String oAp;
  public String oAq;
  private final b rr;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new clj();
    ((b.a)localObject).hNN = new clk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((b.a)localObject).funcId = 1171;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (clj)this.rr.hNK.hNQ;
    ((clj)localObject).Frv = paramInt;
    ((clj)localObject).Frw = paramString1;
    ((clj)localObject).Frx = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112857);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112857);
    return i;
  }
  
  public final int getType()
  {
    return 1171;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112856);
    ad.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (clk)this.rr.hNL.hNQ;
      this.dFE = paramq.FrA;
      this.oAk = paramq.FrB;
      this.status = paramq.status;
      this.content = paramq.content;
      this.oAl = paramq.ozC;
      this.jVX = paramq.GXz;
      this.oAm = paramq.oAm;
      this.oAn = paramq.Hey;
      this.oAo = paramq.Hez;
      this.oAp = paramq.HeA;
      this.oAq = paramq.HeB;
      ad.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.dFE, this.oAk, Integer.valueOf(this.status), this.content, this.oAl, this.jVX, Boolean.valueOf(this.oAm) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */