package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eky;
import com.tencent.mm.protocal.protobuf.ekz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class c
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public c()
  {
    AppMethodBeat.i(109749);
    d.a locala = new d.a();
    locala.iLN = new eky();
    locala.iLO = new ekz();
    locala.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((eky)this.rr.iLK.iLR).KMz = 1;
    AppMethodBeat.o(109749);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(286722, "");
      com.tencent.mm.kernel.g.aAh().azQ().set(286721, "");
      com.tencent.mm.kernel.g.aAh().azQ().set(286723, "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.c
 * JD-Core Version:    0.7.0.1
 */