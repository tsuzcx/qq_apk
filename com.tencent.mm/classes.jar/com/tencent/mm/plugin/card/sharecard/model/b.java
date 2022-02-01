package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public String nWw;
  public String nYj;
  private final com.tencent.mm.ak.b rr;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(112957);
    this.nYj = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aut();
    ((b.a)localObject).hvu = new auu();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((b.a)localObject).funcId = 1164;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aut)this.rr.hvr.hvw;
    ((aut)localObject).latitude = paramDouble1;
    ((aut)localObject).longitude = paramDouble2;
    ((aut)localObject).nYj = paramString;
    ((aut)localObject).EMT = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFf, ""));
    ac.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((aut)localObject).EMT);
    AppMethodBeat.o(112957);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (auu)this.rr.hvs.hvw;
      ac.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + paramq.nWw);
      this.nWw = paramq.nWw;
      this.nYj = paramq.nYj;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */