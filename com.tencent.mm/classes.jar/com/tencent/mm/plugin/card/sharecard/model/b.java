package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String tpZ;
  public String trU;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(112957);
    this.trU = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bsa();
    ((d.a)localObject).lBV = new bsb();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((d.a)localObject).funcId = 1164;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bsa)d.b.b(this.rr.lBR);
    ((bsa)localObject).latitude = paramDouble1;
    ((bsa)localObject).longitude = paramDouble2;
    ((bsa)localObject).trU = paramString;
    ((bsa)localObject).Tcm = ((String)h.aHG().aHp().get(ar.a.VhV, ""));
    Log.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((bsa)localObject).Tcm);
    AppMethodBeat.o(112957);
  }
  
  public final int doScene(g paramg, i parami)
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
      params = (bsb)d.c.b(this.rr.lBS);
      Log.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + params.tpZ);
      this.tpZ = params.tpZ;
      this.trU = params.trU;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */