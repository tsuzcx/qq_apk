package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class ac
  extends m
  implements k
{
  private f callback;
  public LinkedList<String> kkX;
  public int kkZ;
  public int kla;
  public int klb;
  private final b rr;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(87901);
    b.a locala = new b.a();
    locala.fsX = new aig();
    locala.fsY = new aih();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((aig)this.rr.fsV.fta).cHn = paramString;
    AppMethodBeat.o(87901);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87902);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87902);
    return i;
  }
  
  public final int getType()
  {
    return 577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87903);
    ab.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aih)this.rr.fsW.fta;
      this.kkX = paramq.kkX;
      this.kkZ = paramq.kkZ;
      this.kla = paramq.kla;
      this.klb = paramq.klb;
    }
    ab.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.kkZ), Integer.valueOf(this.kla), Integer.valueOf(this.klb) });
    if (this.kkX != null) {
      ab.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.kkX.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */