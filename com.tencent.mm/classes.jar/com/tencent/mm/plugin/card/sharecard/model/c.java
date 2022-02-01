package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  public String nWw;
  private final b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(112960);
    b.a locala = new b.a();
    locala.hvt = new bee();
    locala.hvu = new bef();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.funcId = 1051;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((bee)this.rr.hvr.hvw).dvO = paramString;
    AppMethodBeat.o(112960);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112962);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112962);
    return i;
  }
  
  public final int getType()
  {
    return 1051;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112961);
    ac.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bef)this.rr.hvs.hvw;
      ac.v("MicroMsg.NetSceneGetShareCard", "json:" + paramq.nWw);
      this.nWw = paramq.nWw;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */