package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public String ntw;
  public String nvj;
  private final com.tencent.mm.al.b rr;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(112957);
    this.nvj = "";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new arp();
    ((b.a)localObject).gUV = new arq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((b.a)localObject).funcId = 1164;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (arp)this.rr.gUS.gUX;
    ((arp)localObject).latitude = paramDouble1;
    ((arp)localObject).longitude = paramDouble2;
    ((arp)localObject).nvj = paramString;
    ((arp)localObject).DrR = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhq, ""));
    ad.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((arp)localObject).DrR);
    AppMethodBeat.o(112957);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(112959);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112959);
    return i;
  }
  
  public final int getType()
  {
    return 1164;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112958);
    ad.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (arq)this.rr.gUT.gUX;
      ad.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + paramq.ntw);
      this.ntw = paramq.ntw;
      this.nvj = paramq.nvj;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */