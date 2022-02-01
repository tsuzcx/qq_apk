package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fqr;
import com.tencent.mm.protocal.protobuf.fqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class d
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public d()
  {
    AppMethodBeat.i(109749);
    c.a locala = new c.a();
    locala.otE = new fqr();
    locala.otF = new fqs();
    locala.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fqr)c.b.b(this.rr.otB)).YKH = 1;
    AppMethodBeat.o(109749);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(109750);
    this.callback = paramh;
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
    c.b.b(this.rr.otB);
    c.c.b(this.rr.otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().B(286722, "");
      com.tencent.mm.kernel.h.baE().ban().B(286721, "");
      com.tencent.mm.kernel.h.baE().ban().B(286723, "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.d
 * JD-Core Version:    0.7.0.1
 */