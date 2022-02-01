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
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.sdk.platformtools.ad;

public final class ag
  extends n
  implements k
{
  private g callback;
  public String content;
  public String dvQ;
  public String jbK;
  public String ntQ;
  public String ntR;
  public boolean ntS;
  public String ntT;
  public String ntU;
  public String ntV;
  public String ntW;
  private final b rr;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cbi();
    ((b.a)localObject).gUV = new cbj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((b.a)localObject).funcId = 1171;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cbi)this.rr.gUS.gUX;
    ((cbi)localObject).CtZ = paramInt;
    ((cbi)localObject).Cua = paramString1;
    ((cbi)localObject).Cub = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112857);
    this.callback = paramg;
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
      paramq = (cbj)this.rr.gUT.gUX;
      this.dvQ = paramq.Cue;
      this.ntQ = paramq.Cuf;
      this.status = paramq.status;
      this.content = paramq.content;
      this.ntR = paramq.nti;
      this.jbK = paramq.DRy;
      this.ntS = paramq.ntS;
      this.ntT = paramq.DXz;
      this.ntU = paramq.DXA;
      this.ntV = paramq.DXB;
      this.ntW = paramq.DXC;
      ad.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.dvQ, this.ntQ, Integer.valueOf(this.status), this.content, this.ntR, this.jbK, Boolean.valueOf(this.ntS) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */