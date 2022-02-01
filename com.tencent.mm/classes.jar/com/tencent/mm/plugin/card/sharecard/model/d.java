package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  public String pTY;
  public int pTZ;
  public String pUa;
  private final com.tencent.mm.ak.d rr;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(112963);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bvb();
    ((d.a)localObject).iLO = new bvc();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((d.a)localObject).funcId = 910;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bvb)this.rr.iLK.iLR;
    ((bvb)localObject).eaO = paramString1;
    ((bvb)localObject).scene = 20;
    ((bvb)localObject).pRX = paramString2;
    ((bvb)localObject).code = paramString3;
    AppMethodBeat.o(112963);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112965);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112965);
    return i;
  }
  
  public final int getType()
  {
    return 910;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112964);
    Log.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bvc)this.rr.iLL.iLR;
      Log.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + params.pTY);
      this.pTY = params.pTY;
      this.pUa = params.pUa;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */