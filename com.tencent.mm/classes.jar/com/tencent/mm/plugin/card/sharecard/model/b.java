package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class b
  extends n
  implements k
{
  private f callback;
  public String oBD;
  public String ozQ;
  private final com.tencent.mm.al.b rr;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(112957);
    this.oBD = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ayr();
    ((b.a)localObject).hNN = new ays();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((b.a)localObject).funcId = 1164;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ayr)this.rr.hNK.hNQ;
    ((ayr)localObject).latitude = paramDouble1;
    ((ayr)localObject).longitude = paramDouble2;
    ((ayr)localObject).oBD = paramString;
    ((ayr)localObject).GvX = ((String)g.ajC().ajl().get(al.a.Irx, ""));
    ad.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((ayr)localObject).GvX);
    AppMethodBeat.o(112957);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112959);
    this.callback = paramf;
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
      paramq = (ays)this.rr.hNL.hNQ;
      ad.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + paramq.ozQ);
      this.ozQ = paramq.ozQ;
      this.oBD = paramq.oBD;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */