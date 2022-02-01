package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class d
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public d()
  {
    AppMethodBeat.i(109749);
    d.a locala = new d.a();
    locala.lBU = new eve();
    locala.lBV = new evf();
    locala.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((eve)d.b.b(this.rr.lBR)).RNt = 1;
    AppMethodBeat.o(109749);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(109750);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109750);
    return i;
  }
  
  public final int getType()
  {
    return 550;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109751);
    Log.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    d.b.b(this.rr.lBR);
    d.c.b(this.rr.lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      h.aHG().aHp().i(286722, "");
      h.aHG().aHp().i(286721, "");
      h.aHG().aHp().i(286723, "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.d
 * JD-Core Version:    0.7.0.1
 */