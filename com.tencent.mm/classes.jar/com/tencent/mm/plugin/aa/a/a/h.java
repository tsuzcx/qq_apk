package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private b goo;
  private l gow;
  public com.tencent.mm.protocal.protobuf.m gox;
  
  public h()
  {
    AppMethodBeat.i(40654);
    b.a locala = new b.a();
    locala.fsX = new l();
    locala.fsY = new com.tencent.mm.protocal.protobuf.m();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.gow = ((l)this.goo.fsV.fta);
    AppMethodBeat.o(40654);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(40655);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40655);
    return i;
  }
  
  public final int getType()
  {
    return 1698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40656);
    ab.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gox = ((com.tencent.mm.protocal.protobuf.m)((b)paramq).fsW.fta);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ab.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.gox.cnK), this.gox.kNv, Integer.valueOf(this.gox.wkk), Integer.valueOf(this.gox.wkl), Integer.valueOf(this.gox.wkm), Long.valueOf(this.gox.wkn), Long.valueOf(this.gox.wko), this.gox.kNG, this.gox.kNH });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.h
 * JD-Core Version:    0.7.0.1
 */