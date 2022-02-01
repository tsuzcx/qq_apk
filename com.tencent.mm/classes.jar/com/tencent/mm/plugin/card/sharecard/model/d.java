package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d rr;
  public String tpZ;
  public int tqa;
  public String tqb;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(112963);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cct();
    ((d.a)localObject).lBV = new ccu();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((d.a)localObject).funcId = 910;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cct)d.b.b(this.rr.lBR);
    ((cct)localObject).fUL = paramString1;
    ((cct)localObject).scene = 20;
    ((cct)localObject).tnX = paramString2;
    ((cct)localObject).code = paramString3;
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
      params = (ccu)d.c.b(this.rr.lBS);
      Log.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + params.tpZ);
      this.tpZ = params.tpZ;
      this.tqb = params.tqb;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */