package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
  extends q
  implements m
{
  private i callback;
  public String pTY;
  public String pVT;
  private final d rr;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(112957);
    this.pVT = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bkr();
    ((d.a)localObject).iLO = new bks();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((d.a)localObject).funcId = 1164;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bkr)this.rr.iLK.iLR;
    ((bkr)localObject).latitude = paramDouble1;
    ((bkr)localObject).longitude = paramDouble2;
    ((bkr)localObject).pVT = paramString;
    ((bkr)localObject).LTC = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTV, ""));
    Log.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((bkr)localObject).LTC);
    AppMethodBeat.o(112957);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112959);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112959);
    return i;
  }
  
  public final int getType()
  {
    return 1164;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112958);
    Log.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bks)this.rr.iLL.iLR;
      Log.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + params.pTY);
      this.pTY = params.pTY;
      this.pVT = params.pVT;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */