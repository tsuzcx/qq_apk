package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f callback;
  public String koi;
  private final b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(88021);
    b.a locala = new b.a();
    locala.fsX = new apx();
    locala.fsY = new apy();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.funcId = 904;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((apx)this.rr.fsV.fta).cHn = paramString;
    AppMethodBeat.o(88021);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(88023);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88023);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88022);
    ab.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (apy)this.rr.fsW.fta;
      ab.v("MicroMsg.NetSceneGetShareCard", "json:" + paramq.koi);
      this.koi = paramq.koi;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */