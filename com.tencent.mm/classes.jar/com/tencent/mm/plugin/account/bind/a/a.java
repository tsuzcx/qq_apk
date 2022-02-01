package com.tencent.mm.plugin.account.bind.a;

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
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class a
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(109742);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new lt();
    ((d.a)localObject).lBV = new lu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (lt)d.b.b(this.rr.lBR);
    ((lt)localObject).RNt = 1;
    ((lt)localObject).RQD = paramInt;
    ((lt)localObject).RQE = paramString1;
    ((lt)localObject).RQF = paramString2;
    ((lt)localObject).RQG = paramString3;
    ((lt)localObject).RQH = paramString4;
    ((lt)localObject).RQI = paramString5;
    ((lt)localObject).RQJ = paramString6;
    ((lt)localObject).RQK = paramString7;
    AppMethodBeat.o(109742);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(109743);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109743);
    return i;
  }
  
  public final int getType()
  {
    return 549;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109744);
    Log.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (lt)d.b.b(this.rr.lBR);
    d.c.b(this.rr.lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      h.aHG().aHp().i(286722, params.RQF);
      h.aHG().aHp().i(286721, params.RQE);
      h.aHG().aHp().i(286723, params.RQG);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */