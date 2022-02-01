package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  public String ntw;
  private final b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(112960);
    b.a locala = new b.a();
    locala.gUU = new bam();
    locala.gUV = new ban();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.funcId = 1051;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((bam)this.rr.gUS.gUX).dyc = paramString;
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
    ad.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ban)this.rr.gUT.gUX;
      ad.v("MicroMsg.NetSceneGetShareCard", "json:" + paramq.ntw);
      this.ntw = paramq.ntw;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */